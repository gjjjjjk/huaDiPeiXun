package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "admin")
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField("username")
    private String username;
    @TableField("phone")
    private String phone;
    private String address;
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
