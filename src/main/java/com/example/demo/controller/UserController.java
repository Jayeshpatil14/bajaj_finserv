package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;
import com.example.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/bfhl")
public class UserController {

	@Autowired
	private UserServiceImpl user;

	@PostMapping
	public ResponseEntity<User> voidLabel(@RequestParam(value = "data[]") String[] paramValues) {

		User mainResponse = user.getResponse(paramValues);
		return new ResponseEntity<>(mainResponse, HttpStatus.OK);
	}
}
