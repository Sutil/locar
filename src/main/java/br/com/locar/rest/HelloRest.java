package br.com.locar.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloRest {
	
	@ResponseBody
	@RequestMapping(value = "/teste", method=RequestMethod.POST, produces = "text/plain")
	public String execute(@RequestBody String json){
		
		System.out.println(json);
		return "ok";
	}

}
