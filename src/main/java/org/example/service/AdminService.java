package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.Admin;
import org.example.entity.Params;
import org.example.exception.CustomException;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService extends IService<Admin> {

    Admin login(Admin admin);

    Admin selectByPhone(String tel, String password);

    public void add(Admin params) throws CustomException;

    List search(Params params);
}
