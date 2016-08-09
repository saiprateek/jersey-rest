package com.jersy.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jersy.rest.message.Profile;

public class ProfileResource {

	private Map<String, Profile> profiles = Database.getProfiles();
	public ProfileResource() {
		if(profiles.size()<1) {
			profiles.put("pratee.singh", new Profile("prateek.singh","Prateek Kumar Singh","Tieto corporation"));
			profiles.put("suman.saha", new Profile("suman.saha","Suman saha","Tieto corporation"));
			profiles.put("milind", new Profile("milind","Milinda Brahma","Tieto corporation"));
			profiles.put("rajesh.mohanty", new Profile("rajesh.mohanty","Rajesh Mohanty","Tieto corporation"));
		}
	}
	
	public List<Profile> getAll() {
		return new ArrayList<>(profiles.values());
	}
	
	public Profile getProfileById(String id) {
		return profiles.get(id);
	}
	
	public Profile add(Profile profile) {
		StringBuilder id = new StringBuilder();
		if(profile.getName().contains("")) {
			String[] names = profile.getName().split("");
			for(String name:names) {
				id.append(name).append(".");
			}
		} 
		profile.setId(id.toString());
		
		profiles.put(profile.getId(), profile);
		return profiles.get(profile.getId());
	}
	
	public Profile update(Profile profile) {
		profiles.put(profile.getId(), profile);
		return profiles.get(profile.getId());
	}
	
	public void remove(String id) {
		profiles.remove(id);
	}
	
	
}
