package org.example.service.ServiceImpI;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Admin;
import org.example.entity.Params;
import org.example.common.config.exception.CustomException;
import org.example.mapper.AdminMapper;
import org.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    public List<Admin> search(Params params) {
        return adminMapper.search(params);
    }

    @Override
    public Admin selectByPhone(String tel, String password) {
        return null;
    }
    @Override
    //我们之前添加管理员用户时没有做任何操作,只是初始化密码为123456
    //根据常识,我们在添加用户时,要确认用户名不能重复
    public void add(Admin params) throws CustomException {
        //1.拿到输入的电话
        String phone = params.getPhone();
        //2.根据电话查询数据库
        Admin admin = adminMapper.selectByPhone(phone);
        //3.如果存在该电话的用户
        if (admin != null) {
            //那么我们抛出异常提示前端
            throw new CustomException("当前电话已被注册");
        }

        //判断添加用户的时候有没有输入密码，如果没有输入密码，我们设置初始密码为123456
        if (params.getPassword() == null) {
            params.setPassword("123456");
        }
        //4.如果没有该电话注册的用户，那么我们就可以注册新用户了
        //AdminMapper.insertSelective(params);
    }

    /**
     * 登录校验
     * @author gjk
     */
    @Override
    public Admin login(Admin admin) throws CustomException {
        /*
         * 1.判断非空
         * 2.根据用户输入的账户密码去数据库查询管理员信息
         * 如果有，说明存在这个管理员，并且用户输入的账户密码都正确，提示登录成功
         * 如果没有，说明用户输入的账户或者密码不正确，提示用户输入正确的账户或密码
         * */
        if (admin.getPhone() == null || "".equals(admin.getPhone())) {
            throw  new CustomException("用户名不能为空");
        }
        if (admin.getPassword() == null || "".equals(admin.getPassword())) {
            throw new CustomException("密码不能为空");
        }
        //根据用户输入去数据库查询
        Admin user = adminMapper.findByPhoneAndPassword(admin.getPhone(),admin.getPassword());
        if (user == null) {
            throw new CustomException("请输入正确的账户或密码");
        }
        return user;
    }


    @Override
    public boolean saveBatch(Collection<Admin> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<Admin> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<Admin> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(Admin entity) {
        return false;
    }

    @Override
    public Admin getOne(Wrapper<Admin> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<Admin> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<Admin> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

}
