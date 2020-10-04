package com.heima;

import com.heima.dao.UsersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;


/**
 * Unit test for simple App.
 */
public class UsersTest {
    private  InputStream inputStream;
    private  SqlSessionFactory factory;
    private  SqlSession session;
    private  UsersMapper usersMapper;
//    初始化方法
    @Before
    public void init()throws IOException{
        //        1.读取配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//        2.创建sqlsessionfactory工厂
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        factory=builder.build(inputStream);
//        3.使用工厂创建sqlsession对象
        session = factory.openSession();//可以在这开启自动提交true，默认关闭：false
//        4.使用sqlsession对象创建dao接口代理对象
        usersMapper = session.getMapper(UsersMapper.class);
    }

//  释放资源
    @After
    public void destoryed()throws IOException{
//        提交事务,增删改都要提交事务，否则无法完成
        session.commit();
        session.close();
        inputStream.close();
    }

//    查询用户列表





}
