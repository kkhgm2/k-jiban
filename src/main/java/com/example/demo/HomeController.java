package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@Autowired
	MessageService messageService;

	@RequestMapping("/")
	public String index(ModelMap modelMap) {
		List<Message> messages = messageService.findAll();
		modelMap.addAttribute("messages", messages);
		return "hello";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String create(@ModelAttribute MessageForm messageForm, ModelMap modelMap) {
		Message message = new Message();
		message.name = messageForm.getName();
		message.message = messageForm.getMessage();
		messageService.save(message);

		return "redirect:/" ;
	}

//	@DeleteMapping("{id}")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String destroy(@PathVariable Long id) {
		 messageService.delete(id);

		 return "redirect:/" ;
    }
}
