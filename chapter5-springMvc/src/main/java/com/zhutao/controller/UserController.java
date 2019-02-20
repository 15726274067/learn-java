package com.zhutao.controller;

import com.zhutao.enumation.SexEnum;
import com.zhutao.pojo.User;
import com.zhutao.pojo.ValidatorPojo;
import com.zhutao.validator.UserValidator;
import com.zhutao.vo.UserVo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: zhutao
 * @Date: 2019/2/20 21:58
 * @Version 1.0
 */
@Controller
@RequestMapping("/springmvc")
public class UserController {
    /**
     * 获取控制器参数
     * 1. 无注解下获取参数,
     *    - 要求参数名称与http请求中的参数名称一致
     *    - 参数允许为空
     *    - 无注解,即不需要写@RequestParam
     *
     * 2. 使用@RequestParam 获取参数
     *    - 可设置前后端参数映射关系 @RequestParam(value = "user_name") String userName
     *    - required: 注解参数是否必填, 默认true
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public UserVo getUserByQuery(@RequestParam(value = "id") Long id){
        User user = new User(id, "zhutao", "note1", SexEnum.MALE);
        return this.changeToVo(user);
    }

    @GetMapping("/user/{id}")
    public UserVo getUser(@PathVariable("id") Long id){

        User user = new User(id, "zhutao", "note1", SexEnum.MALE);
        return this.changeToVo(user);
    }

    /**
     * 思路: controller层将VO转换为PO,完成前端展示到后端存储的映射
     * @param UserVo
     * @return
     */
    @PostMapping("/user")
    public User insert(@RequestBody UserVo UserVo){
        User User = this.changeToPo(UserVo);
        return User;
    }

    /**
     * 传递数组,支持用逗号分隔的数组参数
     * eg: user?id=1,2,3
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> userList(@RequestParam(value = "id") Long[] idArr){
        System.out.println(Arrays.toString(idArr));
        List<User> lst = new ArrayList<>();
        User User = new User(11L, "zhutao", "note_1", SexEnum.FEMALE);
        lst.add(User);

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("success", true);
        hashMap.put("data", lst);
        return hashMap;
    }

    /**
     * 处理post请求
     * 使用 @RequestBody 注解
     * JSON请求体与user类名称一致,自动转换为user类
     *
     */
    @ResponseBody
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Map<String, Object> insertUser(@RequestBody User user){
        HashMap<String, Object> map = new HashMap<>();
        map.put("success", true);
        map.put("user", user);
        return map;
    }

    /**
     * 通过url传递参数
     * 通过controller映射和注解@PathVariable 组合,获取url参数
     * {...}代表占位符,可配置参数名称
     */
    @GetMapping("/{name}")
    public User getUserByName(@PathVariable("name") String userName){
        System.out.println(userName);
        return new User(111L, userName, "note_111", SexEnum.FEMALE);
    }

    /**
     * 获取格式化参数
     * @DateTimeFormat
     * @NumberFormat
     */
    @PostMapping("/format")
    @ResponseBody
    public Map<String, Object> format(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
            @NumberFormat(pattern = "#,###.##") Double number){
        Map<String, Object> map = new HashMap<>();
        map.put("date", date);
        map.put("number", number);
        return map;
    }

    /**
     * 自定义参数转换规则
     *处理器转换参数的过程:
     * 在 Spring MVC 中, 是通过 WebDataBinder 机制来获取参数的, 解析 HTTP 请求的上下文,
     * 在控制器调用之前,转换参数并且提供验证, 为调用控制器方法做准备
     * 处理器会从 HTTP 请求中读取数据，然后通过Converter, Formatter和GenericConverter 进行转换
     *
     * Converter: 一对一转换器
     * GenericConverter 集合和数组转换,会先进行分隔,调用对应类型的Converter转换器
     */
    @GetMapping("/user/convert")
    public UserVo convert(User user){
        return changeToVo(user);
    }

    @GetMapping("/user/generic-convert")
    public List<User> getericConvert(List<User> userList){
        return userList;
    }

    /**
     * 通过注解进行参数验证 (JSR-303)
     * @Valid 注解表示启动验证机制, 会将验证结果放到Errors 对象中
     */
    @PostMapping("/user/valid")
    @ResponseBody
    public Map<String, Object> validate(
            @Valid @RequestBody ValidatorPojo vp, Errors errors){

        Map<String, Object> errMap = new HashMap<>();
        // 获取错误列表
        List<ObjectError> objectErrors = errors.getAllErrors();
        for (ObjectError error: objectErrors){
            String key = null;
            String msg = null;

            // 字段错误
            if (error instanceof FieldError){
                FieldError fieldError = (FieldError) error;
                key = fieldError.getField();
            } else {
                // 非字段错误
                key = error.getObjectName();
            }

            msg = error.getDefaultMessage();
            errMap.put(key, msg);
        }
        return errMap;
    }

    /**
     * spring 自带的参数验证
     * WebDataBinder注册验证器,
     * @InitBinder注解标注方法,使得方法在执行控制器方法前执行
     */

    @InitBinder
    public void initBinder(WebDataBinder binder){
        // 绑定验证器
        binder.setValidator(new UserValidator());
        // 定义日期参数格式，参数不再需要注解@DateTimeFormat,boolean 参数表示是否允许为空
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false));

    }

    @PostMapping("/user/validator")
    @ResponseBody
    public Map<String, Object> validator(
            @Valid @RequestBody User user, Errors errors, Date date){

        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("date", date);

        // 是否存在错误
        if (errors.hasErrors()){

            // 获取全部错误
            List<ObjectError> objectErrors = errors.getAllErrors();
            for (ObjectError error: objectErrors){
                if (error instanceof FieldError) {
                    // 字段错误
                    FieldError fe = (FieldError) error;
                    map.put (fe.getField(), fe.getDefaultMessage ());
                } else {
                    map.put(error.getObjectName(), error.getDefaultMessage());
                }
            }
        }
        return map;
    }


    // 转换Vo 变为PO
    private User changeToPo(UserVo UserVo){
        User User = new User();
        User.setId(UserVo.getId());
        User.setNote(UserVo.getNote());
        User.setUserName(UserVo.getUserName());
        User.setSex(SexEnum.getEnumById(UserVo.getSexCode()));
        return User;
    }

    // 转换PO -> VO
    private UserVo changeToVo(User User){
        UserVo UserVo = new UserVo();
        UserVo.setId(User.getId());
        UserVo.setUserName(User.getUserName());
        UserVo.setNote(User.getNote());
        UserVo.setSexCode(User.getSex().getId());
        UserVo.setSexName(User.getSex().getName());
        return UserVo;
    }

    // 将PO列表转换为VO列表
    private List<UserVo> changeToVoLst(List<User> list){
        List<UserVo> result = new ArrayList<>();
        for (User User: list){
            UserVo vo = changeToVo(User);
            result.add(vo);
        }
        return result;
    }

    // 结果VO
    public class ResultVo{

        private Boolean success = null;
        private String message = null;

        public ResultVo() {
        }

        public ResultVo(Boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


}
