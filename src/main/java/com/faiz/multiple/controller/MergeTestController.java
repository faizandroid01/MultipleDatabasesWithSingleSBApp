package com.faiz.multiple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faiz.multiple.service.MergeService;

@RestController
public class MergeTestController {

	@Autowired
	private MergeService mergeService;

	@GetMapping("/getAllBooksAndUsers")
	public Object getAllBooksAndUsers() {
		return mergeService.getAllBooksAndUsers();
	}
	
	@GetMapping("/saveAllBooksAndUsers")
	public String saveAllBooksAndUsers() {
		return mergeService.saveAllBooksAndUsers();
	}

}
