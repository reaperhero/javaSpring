package cn.chenqiangjun.service.impl;


import cn.chenqiangjun.dao.IAccountDao;
import cn.chenqiangjun.dao.factory.BeanFactory;
import cn.chenqiangjun.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    // 传统创建
    //private IAccountDao accountDao = new AccountDaoImpl();

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    private int i = 1;

    public void  saveAccount(){
        //int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
