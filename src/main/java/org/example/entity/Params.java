package org.example.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//新建实体类Params.java用于接收参数
public class Params {
    private Integer id;
    private String username;
    private String password;
    private String tel;
    private String address;

    @TableField(exist = false)
    private Integer pageSize;
    @TableField(exist = false)
    private Integer pageNum;

}

