package com.example.demo6.controller;

import com.example.demo6.model.StudentWork;
import com.example.demo6.rabbit.QueueNames;
import com.example.demo6.rabbit.Sender;
import com.example.demo6.service.UserService;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo6.model.User;

import java.net.URI;
import java.util.List;

/**
 * User Controller
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "创建User", notes = "描述信息", tags = {"tag"})
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "创建成功", response = URI.class),
            @ApiResponse(code = 400, message = "参数错误", response = IllegalArgumentException.class)
    })
    @GetMapping("save")
    public ResponseEntity<String> save(){

        String id = ObjectId.get().toHexString();
        User user  = new User(id, 1234, "user1", null);

        userService.save(user);

        return ResponseEntity.ok(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> find(){
        List<User> userList = userService.query();

        return ResponseEntity.ok(userList);
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public String findByName(@PathVariable String userName){
        return "findByName";
    }

    @GetMapping("clear")
    public String clear(){

        return "data cleared";
    }
}
