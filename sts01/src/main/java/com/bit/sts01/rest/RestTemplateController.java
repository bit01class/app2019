package com.bit.sts01.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.bit.sts01.model.entity.TestDbVo;

@Controller
public class RestTemplateController {
	private String url="http://localhost:8080/sts01/";

	@GetMapping("/")
	public String getList(Model model) {
		RestTemplate template=new RestTemplate();
		ResponseEntity<String> result =null;
		String url=this.url+"list";
		result= template.getForEntity(url, String.class);
		model.addAttribute("list", result.getBody());
		return "home";
	}
	
	@GetMapping("/add")
	public String addList() {
		RestTemplate template =new RestTemplate();
		
		String url=this.url+"list";
		HttpEntity<?> request=null;
		
		HttpHeaders headers=new HttpHeaders();
		headers.add("Content-Type",	"application/x-www-form-urlencoded; charset=utf-8");
		
		MultiValueMap body=null;
		body=new LinkedMultiValueMap();
		body.add("name", "test");
		
		request=new HttpEntity(body,headers);
		Class responseType=String.class;
//<form action="" method="post" enctype="application/x-www-form-urlencoded"></form>
		template.postForObject(url, request, responseType);
		return "redirect:/";
	}
	
	@GetMapping("/find")
	public String findList(int num,Model model) {
		RestTemplate template=new RestTemplate();
		
		String url=this.url+"list/{num}";
		Class responseType=TestDbVo.class;
		ResponseEntity result =null;
		result= template.getForEntity(url, responseType,num);
		model.addAttribute("bean", result.getBody());
		return "home";
	}
}







