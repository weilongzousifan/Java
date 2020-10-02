package com.itheima.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.itheima.mapper.AdministratorMapper;
import com.itheima.pojo.Administrator;
import com.itheima.service.AdminService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public List<Administrator> findAll() {
        return administratorMapper.selectList(null);
    }

    @Override
    public void deleteById(Integer id) {
        administratorMapper.deleteById(id);
    }

    @Override
    public Administrator findUserByUsername(String username) {
        //封装查询条件  如果为null的话  默认查询所有
        Wrapper<Administrator> wrapper = new EntityWrapper<Administrator>();
        wrapper.eq("username",username);
        List<Administrator> adminList = administratorMapper.selectList(wrapper);
        if(adminList != null && adminList.size() > 0){
            return adminList.get(0);
        }
        return null;
    }

    @Override
    public Set<String> findRolesByUsername(String username) {
        return administratorMapper.findRolesByUsername(username);
    }

    @Override
    public Set<String> findPermissionsByUsername(String username) {
        return administratorMapper.findPermissionsByUsername(username);
    }

    public void saveAdmin(Administrator admin) {
        String password = admin.getPassword();
        String salt = RandomStringUtils.randomNumeric(6,8); //使用随机salt  6--8位
        admin.setPrivateSalt(salt);//存加密使用的salt

        //模拟md5加密一次，也可以加密两次，在后面加个2即可，表示次数，解密的时候需要告诉shiro框架加密了几次
        Md5Hash md5Hash = new Md5Hash(password,salt);
        admin.setPassword(md5Hash.toString());

        admin.setUserStatus("1");

        administratorMapper.insert(admin);
    }
}
