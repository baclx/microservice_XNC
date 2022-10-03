package com.example.customer_service.service;

import com.example.customer_service.entity.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUser();
    List<Users> getUsersByFullname(String name);
    List<Users> getUsersByNationality(String nationality);
    List<Users> getUsersByGender(Integer gender);
    Users insertUsers(Users users);
    Users updateUsers(Users users);
    void deleteUsersById(Long id);
}
