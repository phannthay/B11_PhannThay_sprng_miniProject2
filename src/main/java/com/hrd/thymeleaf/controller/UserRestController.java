package com.hrd.thymeleaf.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrd.thymeleaf.model.User;
import com.hrd.thymeleaf.service.UserService;


@Controller // = @Contoller + @ResponseBody
public class UserRestController {

	private UserService userService;
	
	/**
	 * ..........??????
	 * @param userService
	 */
	@Autowired
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * ????????????????
	 * @return
	 */
	@RequestMapping("/user")
	public String user(ModelMap model){
		model.addAttribute("user",userService.findAll());
		return "/shared/_user";
	}
	
	@RequestMapping("/form")
	public String fomr(ModelMap model){
		model.addAttribute("user",new User());
		model.addAttribute("addstatus", true);
		return "/shared/_form";
	}
	@PostMapping("/user")
	public String form(@ModelAttribute User user,ModelMap model){
		model.addAttribute("user",userService.save(user));
		return "redirect:/user";
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/save")
	public boolean save(){
		return userService.save(new User(0, "PP", "pp@gmail.com", "pp123", "F","0", null));
	}
	
//	/**
//	 * 
//	 * @param userHash
//	 * @return
//	 */
//	@RequestMapping("/delete/{user_hash}")
//	public boolean delete(@PathVariable("user_hash") String userHash){
//		return userService.deleteByUserHash(userHash);
//	}
//	
//	/**
//	 * 
//	 * @return
//	 */
//	@RequestMapping("/update")
//	public boolean update(){
//		User user = new User();
//		user.setUsername("DADA");
//		user.setUserHash("fgasdfg-fasd-fads-fasd");
//		return userService.updateByUserHash(user);
//	}
//	
//	@RequestMapping("/save-batch")
//	public boolean saveBatch(){
//		ArrayList<User> users = new ArrayList<User>();
//		User user = new User();
//		user.setUsername("DADA");
//		users.add(user);
//		user = new User();
//		user.setUsername("TADA");
//		users.add(user);
//		return userService.saveBatch(users);
//	}
	
	
}
