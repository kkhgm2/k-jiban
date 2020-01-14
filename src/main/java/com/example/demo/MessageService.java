package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepository;

	public List<Message> findAll(){
		return messageRepository.findAll();
	}

	public Message findOne(Long id) {
		return messageRepository.getOne(id);
	}

	public Message save(Message message) {
		return messageRepository.save(message);
	}

	public void delete(Long id) {
		messageRepository.deleteById(id);
	}

}
