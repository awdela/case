package com.test.spring.aop;

import com.test.spring.aop.bean.UserDao;
import com.test.spring.aop.bean.UserDaoImpl;

public class Main {

    public static void main(String[] args) {
        // 创建代理对象
        BeanProxy bp = new BeanProxy();
        // 创建目标对象
        UserDao userDao = new UserDaoImpl();
        // 从代理对象中获取增强后的
        UserDao userDao1 = (UserDao) bp.creatProxy(userDao);
        // 代理后的对象,执行得是invoke方法
        userDao1.addUser();
    }

}
