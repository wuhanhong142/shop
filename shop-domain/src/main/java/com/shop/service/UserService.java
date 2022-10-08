package com.shop.service;


import com.shop.core.service.ServiceImpl;
import com.shop.model.UserDO;
import com.shop.model.UserModel;
import com.shop.repoistory.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService extends ServiceImpl<UserDO, UserRepository> {

    /**
     * 查询用户
     */
    public UserModel loadUserModel(String username, String password) {



    }
}
