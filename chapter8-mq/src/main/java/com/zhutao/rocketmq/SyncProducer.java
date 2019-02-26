package com.zhutao.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * @Author: zhutao
 * @Date: 2019/2/23 21:42
 * @Version 1.0
 */
public class SyncProducer {

        public static void main(String[] args) throws Exception {
            //Instantiate with a producer group name.
            DefaultMQProducer producer = new
                    DefaultMQProducer("my_group_name");
            // Specify name server addresses.
            producer.setNamesrvAddr("139.129.201.222:9876");
            //Launch the instance.
            producer.start();
            for (int i = 0; i < 100; i++) {
                //Create a message instance, specifying topic, tag and message body.
                Message msg = new Message("TopicTest" /* Topic */,
                        "TagA" /* Tag */,
                        ("Hello RocketMQ " +
                                i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
                );
                //Call send message to deliver message to one of brokers.
                SendResult sendResult = producer.send(msg);
                System.out.printf("%s%n", sendResult);
            }
            //Shut down once the producer instance is not longer in use.
            producer.shutdown();
        }



}
