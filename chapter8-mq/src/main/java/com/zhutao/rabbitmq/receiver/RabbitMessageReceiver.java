package com.zhutao.rabbitmq.receiver;

import com.rabbitmq.client.Channel;
import com.zhutao.pojo.User;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * rabbitmq 消费者
 * @Author: zhutao
 * @Date: 2019/2/26 15:53
 * @Version 1.0
 */
@Component
public class RabbitMessageReceiver {

    @Value("${rabbitmq.queue.msg}")
    private String msgQueueName = null;

    @Value("${rabbitmq.queue.user}")
    private String userQueueName = null;

    @Value("${rabbitmq.queue.ack}")
    private String ackQueueName;

    /**
     * 可以直接通过注解声明交换器、绑定、队列。但是如果声明的和rabbitMq中已经存在的不一致的话会报错
     * RabbitListener注解是可以重复的。并且声明队列绑定的key也可以有多个.
     *
     * Fanout Exchange – 不处理路由键。你只需要简单的将队列绑定到交换机上。一个发送到交换机的消息都会被转发到与该交换机绑定的所有队列上。很像子网广播，每台子网内的主机都获得了一份复制的消息。Fanout交换机转发消息是最快的。
     * 任何发送到Fanout Exchange的消息都会被转发到与该Exchange绑定(Binding)的所有Queue上。
     *
     * 1.可以理解为路由表的模式
     * 2.这种模式不需要RouteKey
     * 3.这种模式需要提前将Exchange与Queue进行绑定，一个Exchange可以绑定多个Queue，一个Queue可以同多个Exchange进行绑定。
     * 4.如果接受到消息的Exchange没有与任何Queue绑定，则消息会被抛弃。
     * @param msg
     */
//    @RabbitListener(queues = { "${rabbitmq.queue.msg}" })
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue( value = "${rabbitmq.queue.msg}"),
            exchange = @Exchange(value = "fanout_exchange", type = ExchangeTypes.FANOUT, durable = "true", autoDelete = "true")),
            // 指定消费者的线程数量,一个线程会打开一个Channel，一个队列上的消息只会被消费一次（不考虑消息重新入队列的情况）,
            // 下面的表示至少开启5个线程，最多10个。线程的数目需要根据你的任务来决定，如果是计算密集型，线程的数目就应该少一些
            concurrency = "5-10")
    /**
     * @Header注解: 注入消息头的单个属性
     * @Payload 注入消息体到一个JavaBean中
     * @Headers 注入所有消息头到一个Map中
     *  如果不是这些类型，那么不加注解的参数将会被当做消息体。
     *  不能多于一个消息体。如下方法ExampleEvent就是默认的消息体：
     * {
     *   amqp_receivedDeliveryMode=PERSISTENT,
     *   amqp_receivedRoutingKey=spring-boot-queue-msg,
     *   amqp_contentEncoding=UTF-8,
     *   amqp_receivedExchange=fanout_exchange,
     *   amqp_deliveryTag=2,
     *   amqp_consumerQueue=spring-boot-queue-msg,
     *   amqp_redelivered=false,
     *   id=9cfb8cdf-94bd-645e-58c5-0c948aeabe66,
     *   amqp_consumerTag=amq.ctag-6jpiXYq14-AaOze1oCH0gA,
     *   contentType=text/plain,
     *   timestamp=1566116060621
     * }
     */
    public void receiveMsg(@Headers Map<String, Object> headers, @Payload String msg){
        System.out.println("queue: spring-boot-queue-msg0 收到消息 :" + msg + " headers:[" + headers);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue( value = "${rabbitmq.queue.msg}1"),
            exchange = @Exchange(value = "fanout_exchange", type = ExchangeTypes.FANOUT, durable = "true", autoDelete = "true")
    ))
    public void receiveMsgFontoutExchange1(String msg){
        System.out.println("queue: spring-boot-queue-msg1 收到消息 :" + msg);
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue( value = "${rabbitmq.queue.msg}2"),
            exchange = @Exchange(value = "fanout_exchange", type = ExchangeTypes.FANOUT, durable = "true", autoDelete = "true")
    ))
    public void receiveMsgFontoutExchange2(String msg){
        System.out.println("queue: spring-boot-queue-msg2 收到消息 :" + msg);
    }

    @RabbitListener(queues = {"${rabbitmq.queue.user}"})
    public void receiveUser(@Payload User user){
        System.out.println("收到用户消息 :" + user.toString());
    }

    /**
     * AcknowledgeMode一共有三种模式：NONE,MANUAL,AUTO,默认是AUTO模式。
     * 这比RabbitMq原生多了一种。NONE对应其实就是RabbitMq的自动确认，MANUAL是手动。
     * 而AUTO其实也是手动模式，只不过是Spring的一层封装，他根据你方法执行的结果自动帮你发送ack和nack。
     * 如果方法未抛出异常，则发送ack。如果方法抛出异常，并且不是AmqpRejectAndDontRequeueException则发送nack，并且重新入队列。
     * @param deliveryTag
     * @param redelivered
     * @param msg
     * @param channel
     */
    @RabbitListener(queues = {"${rabbitmq.queue.ack}"})
    public void receiveAckMsg(@Header(name = "amqp_deliveryTag") long deliveryTag,
                              @Header("amqp_redelivered") boolean redelivered,
                              @Payload String msg,
                              Channel channel) {
        System.out.println("收到消息 :" + msg + " deliveryTag:[" + deliveryTag + "]");

        try {
            channel.basicAck(deliveryTag, false);
        } catch (IOException e) {
            e.printStackTrace();
            //这一步千万不要忘记，否则会导致消息未确认，消息到达连接的qos之后便不能再接收新消息
            //一般重试肯定的有次数，这里简单的根据是否已经重发过来来决定重发。第二个参数表示是否重新分发
            try {
                channel.basicReject(deliveryTag, !redelivered);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
