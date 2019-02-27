package com.zhutao.controller;

import com.zhutao.pojo.User;
import com.zhutao.repository.UserRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author: zhutao
 * @Date: 2019/2/26 22:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/es/user")
public class UserController {
    @Autowired
    private UserRepository userRepository = null;

    @GetMapping("/save")
    public String save(){
        User user = new User(System.currentTimeMillis(),
                "商品"+System.currentTimeMillis(),"这是一个测试商品");
        userRepository.save(user);
        return "success";
    }

    @GetMapping("/delete")
    public String delete(long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            userRepository.delete(user.get());
        } else {
            return "user not found";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(
            @RequestParam("id") long id,
            @RequestParam("user_name") String userName,
            @RequestParam("note") String note){
        User goodsInfo = new User(id,
                userName,note);

        if (userRepository.existsById(id)){
            userRepository.save(goodsInfo);
        } else {
            return "user not found";
        }
        return "success";
    }

    @GetMapping("")
    public User getOne(long id){
        return userRepository.findById(id).orElse(new User());
    }

    //每页数量
    private Integer PAGESIZE=10;

    // /userList?query=张
    // /getGoodsList?query=张&pageNumber=1
    // 根据关键字"张"去查询列表，userName或者note包含的都查询
    @GetMapping("getGoodsList")
    public List<User> getList(Integer page, String query){
        if(page==null) page = 0;
        //es搜索默认第一页页码是0
        SearchQuery searchQuery=getEntitySearchQuery(page,PAGESIZE,query);
        Page<User> usersPage = userRepository.search(searchQuery);
        return usersPage.getContent();
    }


    private SearchQuery getEntitySearchQuery(int page, int pageSize, String searchContent) {
        // TODO finish it
//        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
//                .add(QueryBuilders.matchPhraseQuery("userName", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                .add(QueryBuilders.matchPhraseQuery("note", searchContent),
//                        ScoreFunctionBuilders.weightFactorFunction(100))
//                //设置权重分 求和模式
//                .scoreMode("sum")
//                //设置权重分最低分
//                .setMinScore(10);

        FunctionScoreQueryBuilder functionScoreQueryBuilder = null;

        // 设置分页
        Pageable pageable = new PageRequest(page, pageSize);
        return new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
    }




}
