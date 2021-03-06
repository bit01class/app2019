package com.bit.sts01.controller;

import java.sql.SQLException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.sts01.model.entity.TestDbVo;
import com.bit.sts01.service.TestDbService;

@Controller
public class HomeController {
	@Inject
	TestDbService testDbService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@GetMapping("/")
//	public String home() {
//		return "home";
//	}
	@GetMapping("/member")
	public String member(Model model) {
		model.addAttribute("msg", "회원");
		return "main";
	}
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("msg", "관리자");
		return "main";
	}
	@GetMapping("/user")
	public String user(Model model) {
		model.addAttribute("msg", "일반");
		return "main";
	}
	@GetMapping("/login")
	public void login() {
	}
	@GetMapping("/logout")
	public void logout() {
	}
	@GetMapping(value = "/list")
	public @ResponseBody ResponseEntity<?> list() throws SQLException {
		return ResponseEntity.status(HttpStatus.OK).body(testDbService.getList());
	}
	
	@PostMapping(value="/list")
	public @ResponseBody ResponseEntity<?> add(TestDbVo bean) throws SQLException{
		testDbService.addDB(bean);
		ResponseEntity<Object> result = ResponseEntity.status(HttpStatus.OK).body(null);
		return result;
	}
	
	@GetMapping(value = "/list/{num}")
	public @ResponseBody ResponseEntity<?> listOne(@PathVariable int num) throws SQLException {
		return ResponseEntity.status(HttpStatus.OK).body(testDbService.oneDB(num));
	}
	
	@PutMapping(value = "/list/{num}")
	public @ResponseBody ResponseEntity<?> edit(@PathVariable int num, TestDbVo bean) throws SQLException {
		if(testDbService.editDB(bean)>0) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);			
		}
	}
	

	@DeleteMapping(value = "/list/{num}")
	public @ResponseBody ResponseEntity<?> delete(@PathVariable int num) throws SQLException {
		if(testDbService.delDB(num)>0) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);			
		}
	}
}
















