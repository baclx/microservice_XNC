package com.example.customer_service.controller;

import com.example.customer_service.entity.ResponseObject;
import com.example.customer_service.entity.Users;
import com.example.customer_service.repository.UsersRepository;
import com.example.customer_service.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("customer-service")
public class CustomerController {
    @Autowired
    private UsersServiceImpl userService;
    @Autowired
    private UsersRepository repository;

    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/search/fullname/{name}")
    public ResponseEntity<ResponseObject> getUsersByFullname(@PathVariable String name){
        List<Users> found=userService.getUsersByFullname(name);
        return (found.isEmpty())?ResponseEntity.status(NOT_FOUND).body(
                new ResponseObject("Failed","Cannot found users","")
        ):ResponseEntity.ok().body(new ResponseObject("OK","found users success",found));
    }

    @GetMapping("/search/gender/{gender}")
    public ResponseEntity<ResponseObject> getUserByGender(@PathVariable Integer gender){
        List<Users> found=userService.getUsersByGender(gender);
        return (found.isEmpty())?ResponseEntity.status(NOT_FOUND).body(
                new ResponseObject("Failed","Cannot found users","")

        ):ResponseEntity.ok().body(new ResponseObject("OK","found users success",found));

    }

    @GetMapping("/search/nationality/{nationality}")
    public ResponseEntity<ResponseObject> getUserByNationality(@PathVariable String nationality){
        List<Users> found=userService.getUsersByNationality(nationality);
        return (found.isEmpty())?ResponseEntity.status(NOT_FOUND).body(
                new ResponseObject("Failed","Cannot found users","")

        ):ResponseEntity.ok().body(new ResponseObject("OK","found users success",found));

    }

    @PostMapping("/save")
    public ResponseEntity<ResponseObject> insertUsers(@RequestBody Users users){
        return ResponseEntity.ok().body(new ResponseObject("OK","found customer success",userService.insertUsers(users)));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseObject> updateUsers(@RequestBody Users users){
        Users updateUsers=userService.updateUsers(users);
        return (updateUsers==null)?ResponseEntity.status(NOT_IMPLEMENTED).body(
                new ResponseObject("Failed","Cannot save users","")

        ):ResponseEntity.ok().body(new ResponseObject("OK","found users success",users));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseObject> deleteUsers(@PathVariable Long id){
        Optional<Users> found=repository.findById(id);
        if (found.isPresent()){
            userService.deleteUsersById(id);
            return ResponseEntity.ok().body(
                    new ResponseObject("OK","found users success",found));
        }else {
            return ResponseEntity.status(NOT_IMPLEMENTED).body(
                    new ResponseObject("Failed","Cannot save users",""));
        }
    }
}
