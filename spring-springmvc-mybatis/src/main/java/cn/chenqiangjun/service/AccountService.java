package cn.chenqiangjun.service;


import cn.chenqiangjun.domain.Account;

import java.util.List;

public interface AccountService {

    // 查询所有账户
    public void findAll();

    // 保存帐户信息
    public void saveAccount(Account account);

}