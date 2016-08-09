package com.jersy.rest.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jersy.rest.message.Comment;
import com.jersy.rest.message.Messages;


public class MessageResource {

	public MessageResource() {
		 Map<Long,Comment> comments = new HashMap<>();
		 comments.put(1L, new Comment(1L, "this is comment1", "prateek", "prateek"));
		 comments.put(2L, new Comment(2L, "this is comment1", "prateek", "prateek"));
		 comments.put(3L, new Comment(3L, "this is comment1", "prateek", "prateek"));
		 
		if(messages.size()<1) {
			messages.put(1L, new Messages(1L, "prateek", "Test message1", new SimpleDateFormat("MM/dd/yyyy").format(new Date()), comments));
			messages.put(2L, new Messages(2L, "prateek", "Test message2", new SimpleDateFormat("MM/dd/yyyy").format(new Date()), comments));
			messages.put(3L, new Messages(3L, "prateek", "Test message3", new SimpleDateFormat("MM/dd/yyyy").format(new Date()), comments));
			messages.put(4L, new Messages(4L, "prateek", "Test message4", new SimpleDateFormat("MM/dd/yyyy").format(new Date()),comments));
		}
		 
	}
	private Map<Long, Messages> messages = Database.getMessages();
	
	public List<Messages> getAllMessages() {
		return new ArrayList<>(messages.values());
	}
	
	public Messages getMessageById(Long id) {
		return messages.get(id);
	}
	
	public Messages add(Messages msg) {
		msg.setId((messages.size()+1L));
		messages.put(messages.size()+1L, msg);
		return messages.get(msg.getId());
	}
	
	public void delete(Long id) {
		if(null != messages && messages.containsKey(id)) {
			messages.remove(id);
		}
	}
	
	public Messages update(Messages msg) {
		if(messages.containsKey(msg.getId())) {
			messages.put(msg.getId(), msg);
		}
		return messages.get(msg.getId());
	}
	
	public List<Messages> getMessageByYear(int year, int start, int end) {
		List<Messages> result = new ArrayList<Messages>();
		for(Messages msg:messages.values()) {
			if(msg.getCreated().contains(String.valueOf(year))) {
				result.add(msg);
			}
		}
		return result.subList(start, end);
	}
}
