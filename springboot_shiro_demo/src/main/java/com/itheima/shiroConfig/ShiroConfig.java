package com.itheima.shiroConfig;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置信息
 */
@Configuration
public class ShiroConfig {
    //0.shiroFilter
    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //告诉shiro框架，登录页面是什么
        shiroFilterFactoryBean.setLoginUrl("/page/toLogin");

        //控制 访问xx资源 需要xx权限 先后顺序不能乱，必须是LinkedHashMap
        Map filterChainMap = new LinkedHashMap<String,String>();
        filterChainMap.put("/page/toLogin","anon"); //访问登录页面 直接放行
        filterChainMap.put("/","anon"); //访问登录页面 直接放行
        filterChainMap.put("/user/all","perms[user:select]"); //查询所有用户 需要认证(登录)

        //当用户查看仓库列表时，需要有仓库权限
        filterChainMap.put("/storage/all","perms[storage:select]");
        //当用户删除用户时，需要有超级管理员角色 *代表一级目录   如果多个*表示多级目录  例如：/{user}/{all}/{id} 表示为：***
        //filterChainMap.put("/user/del/*","roles[role_superman]");

        filterChainMap.put("/backend/logout","logout");//退出登录

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }

    //1.安全管理器
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setSessionManager(sessionManager());

        securityManager.setRealm(myRealm());
        return securityManager;
    }

    //2.realm
    @Bean
    public Realm myRealm(){
        MyRealm myRealm = new MyRealm();
        //告诉realm密码匹配方式
        myRealm.setCredentialsMatcher(credentialsMatcher());

        myRealm.setAuthorizationCacheName("perms");
        myRealm.setAuthorizationCachingEnabled(true);

        myRealm.setAuthenticationCachingEnabled(false);
        //设置缓存管理器
        myRealm.setCacheManager(cacheManager());
        return myRealm;
    }

    //缓存管理
    @Bean
    public CacheManager cacheManager(){
        MyRedisCacheManager cacheManager = new MyRedisCacheManager();
        return cacheManager;
    }

    //密码匹配方式  要告诉realm
    @Bean
    public CredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher hashedMatcher = new HashedCredentialsMatcher();
        hashedMatcher.setHashAlgorithmName("md5");
        //hashedMatcher.setHashIterations(1);// 告诉加密次数 如果是一次，可以省略不写
        return hashedMatcher;
    }

    /**
     * 注解支持
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


    //标签支持
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    /**
     * 会话管理器
     * @return
     */
    @Bean
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());

        //设置会话过期时间
        sessionManager.setGlobalSessionTimeout(3*60*1000); //默认半小时
        sessionManager.setDeleteInvalidSessions(true); //默认自定调用SessionDAO的delete方法删除会话
        //设置会话定时检查
        //        sessionManager.setSessionValidationInterval(180000); //默认一小时
        //        sessionManager.setSessionValidationSchedulerEnabled(true);
        return sessionManager;
    }

    @Bean
    public SessionDAO redisSessionDAO(){
        ShiroRedisSessionDao redisDAO = new ShiroRedisSessionDao();
        return redisDAO;
    }



}
