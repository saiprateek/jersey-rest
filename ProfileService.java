package com.jersy.rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersy.rest.message.Profile;

@Path("/linkedinProfiles")
public class ProfileService {

	ProfileResource profileResource = new ProfileResource();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	public List<Profile> getAll(){
		return profileResource.getAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfileByid(@PathParam("id")String id) {
		return profileResource.getProfileById(id);
	}
	
	@Path("/update")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Profile update(Profile profile) {
		return profileResource.update(profile);
	}
	
	@Path("/add")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Profile add(Profile profile) {
		return profileResource.add(profile);
	}
	
	@DELETE
	@Path("/delete/{id}")
	public void remove(@PathParam("id") String id) {
		profileResource.remove(id); 
	}
}
