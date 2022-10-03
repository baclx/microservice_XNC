package com.example.customer_service.service;

import com.example.customer_service.entity.Users;
import com.example.customer_service.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j

public class UsersServiceImpl implements UserService{
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<Users> getAllUser() {
        log.info("Loading all users...");
        return usersRepository.findAll();
    }

    @Override
    public List<Users> getUsersByFullname(String name) {
        return usersRepository.findByFullname(name);
    }

    @Override
    public List<Users> getUsersByNationality(String nationality) {
        return usersRepository.findByNationality(nationality);
    }

    @Override
    public List<Users> getUsersByGender(Integer gender) {
        return usersRepository.findByGender(gender);
    }

    @Override
    public Users insertUsers(Users users) {
        log.info("saving user...");
        return usersRepository.save(users);
    }

    @Override
    public Users updateUsers(Users users) {
        Optional<Users> user=usersRepository.findById(users.getId());

        if (user.isPresent()){
            user.map(t->{
                t.setFullname(users.getFullname());
                t.setGender(users.getGender());
                t.setNationality(users.getNationality());
                return t;
            }).orElse(usersRepository.save(users));
        }
        return usersRepository.save(users);
    }

    @Override
    public void deleteUsersById(Long id) {
        Optional<Users> users= usersRepository.findById(id);
        if (users.isPresent()) {
            log.info("delete user success");
            usersRepository.deleteById(id);
        }else {
            log.error("cannot delete is not found users");
        }
    }
}
