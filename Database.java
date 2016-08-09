package com.jersy.rest.controller;

import java.util.HashMap;
import java.util.Map;

import com.jersy.rest.message.Messages;
import com.jersy.rest.message.Profile;

public class Database {

	private static Map<Long, Messages> messages = new HashMap<>(); 
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Messages> getMessages() {
		return messages;
	}
	 
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
	  
	
	
}
