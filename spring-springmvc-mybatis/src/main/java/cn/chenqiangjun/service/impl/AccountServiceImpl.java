package cn.chenqiangjun.service.impl;


import cn.chenqiangjun.dao.AccountDao;
import cn.chenqiangjun.domain.Account;
import cn.chenqiangjun.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    //@Autowired
    //private AccountDao accountDao;

    public void findAll() {
        System.out.println("业务层：查询所有账户...");
        //return accountDao.findAll();
    }

    public void saveAccount(Account account) {
        System.out.println("业务层：保存帐户...");
        //accountDao.saveAccount(account);
    }
}
