package br.com.fiap.epictask.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.epictask.model.User;

import br.com.fiap.epictask.repository.UserRepository;
@Controller
public class UserController {
	
	
		@Autowired
		private UserRepository repository;
		
		@GetMapping("/user")
		public ModelAndView index() {
			
			ModelAndView modelAndView = new ModelAndView("users");//users nome da view
			List<User> users = repository.findAll(); // users nome da lista de objs 
			modelAndView.addObject("users", users);
			return modelAndView;
		}
		
		@RequestMapping("/user/new")
		public String create(User user) {
			return "register";
		}

		@PostMapping("/user/new")
		public String save(@Valid User user, BindingResult result) { 
			if(result.hasErrors()) {
				return "register";
			}
			repository.save(user);
			return "users";
		}
		
}

