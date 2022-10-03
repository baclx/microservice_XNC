package com.example.customer_service.repository;

import com.example.customer_service.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Long> {
    List<Users> findByGender(Integer gender);
    List<Users> findByFullname(String name);
    List<Users> findByNationality(String nationality);

}
