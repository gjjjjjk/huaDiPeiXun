package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Admin;
import org.example.entity.Params;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper extends BaseMapper<Admin> {
    //通过电话查询数据库
    Admin selectByPhone(@Param("phone") String phone);

    List<Admin> search(Params params);
}
