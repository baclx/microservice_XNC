package com.example.identity_card_service.controller;

import com.example.identity_card_service.entity.Identitycard;
import com.example.identity_card_service.service.IdentityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/identity-card-service")
public class IdentityController {
//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    @Autowired
    private IdentityService identityService;

    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/test")
    public String test(){
        return "identity test";
    }

//    @PostMapping("/test")
//    public String test(@RequestBody Identitycard identitycard) throws JsonProcessingException {
//        rabbitTemplate.convertAndSend("payment-exchange","payment.routing.test", mapper.writeValueAsString(identitycard));
//        return "success";
//    }

    @GetMapping
    public ResponseEntity<List<Identitycard>> getAll() {
        List<Identitycard> identitycardList = identityService.getAllIdentityCards();

        return new ResponseEntity<>(identitycardList, HttpStatus.OK);
    }
    
    @PostMapping("/save")
    public ResponseEntity<Identitycard> addCard(@RequestBody Identitycard identitycard){
        identityService.addIdentityCard(identitycard);
        return ResponseEntity.ok(identitycard);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Identitycard> updateCard(@PathVariable("id") Long id,@RequestBody Identitycard identitycard){
        if(identityService.findById(id)!=null){
            identityService.updateIdentityCard(identitycard,id);
            return ResponseEntity.ok(identitycard);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("delete/{id}")
    public Object deleteCard(@PathVariable("id") Long id){
        if(identityService.findById(id)!=null){
            identityService.deleteById(id);
            return ResponseEntity.ok("Deleted Identity with id = "+id);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
