package org.example.controller;

import org.example.entity.Admin;
import org.example.entity.Params;
import org.example.entity.Result;
import org.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController//声明当前是一个controller类，接收前端请求
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    //
    @RequestMapping("/list")//接收的请求的地址声明
    public List<Admin> list() {
        //调用service,要使用mybatisplus注意要让我们的类集成 mybatis的东西
        return adminService.list();
    }

    //在controller层使用统一返回数据结构
    @GetMapping("/search")//接收请求的地址声明
    public Result search(Params params) {//搜索admin
        List<Admin> list = adminService.search(params);
        return Result.success(list);
    }

}
