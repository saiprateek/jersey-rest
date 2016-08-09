package com.jersy.rest.controller;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.message.internal.MediaTypes;

import com.jersy.rest.message.Comment;
import com.jersy.rest.message.Messages;
 

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageService {

	MessageResource messageResource = new MessageResource();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Messages> getAllMessages() {
		return messageResource.getAllMessages();
	}
	
	@GET
	@Path("/all")
	public List<Messages> getMessage(@BeanParam MessagesFilterBean filterBean) {
		if(messageResource.getMessageByYear(filterBean.getYear(), filterBean.getStart(), filterBean.getEnd()).size()>0)
			return messageResource.getMessageByYear(filterBean.getYear(), filterBean.getStart(), filterBean.getEnd());
		return null;
	}
	
	
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Messages getMessageById(@PathParam("messageId") Long id) {
		return messageResource.getMessageById(id);
	}
	
	@Path("/update")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Messages updateMessage(Messages messages) {
		return messageResource.update(messages);
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Messages addMessages(Messages messages) {
		return messageResource.add(messages);
	}
	
	@DELETE
	@Path("/delete/{messageId}")
	public void deleteMessages(@PathParam("messageId") Long id) {
		messageResource.delete(id);
	}
	
	/*Implementing sub resources in Rest*/
	
	@Path("/{messageId}/comments")
	public CommentResource getComments() {
		return new CommentResource();
	}
}
