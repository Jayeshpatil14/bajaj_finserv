package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.repo.IUserDao;

@Service
@Transactional
public class UserServiceImpl {

	@Autowired
	private EntityManager mgr;
	
	public User getResponse(String[] paramValues) {
		String[] requiredParams = Arrays.toString(paramValues).split(",");
		User response = new User(true, "firstName_lastName_DataOfBirth", "emailid@gmail.com",
				"DummyRollNumber");
		List<String> alphabets = new ArrayList<>();
		List<String> numbers = new ArrayList<>();

		for (String s : requiredParams) {
			int temp = 0;
			try {
				temp = Integer.parseInt(s);
				numbers.add(String.valueOf(temp));
			} catch (NumberFormatException e) {
				alphabets.add(s);
			}
		}

		response.setAlphabets(alphabets);
		response.setNumbers(numbers);
		return response;
	}

}
