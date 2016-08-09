package com.jersy.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jersy.rest.message.Comment;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

	MessageResource messageResource = new MessageResource();
	 
	
	 
	
	@GET
	public List<Comment> getCommentByMessageId(@PathParam("messageId")Long messageId) {
		return new ArrayList<>(messageResource.getMessageById(messageId).getComments().values());
	}
	
	/*@GET
	@Path("/{commentId}")
	public Comment getCommentByCommentId(@PathParam("messageId")Long messageId, @PathParam("commentId")Long commentId) {
		return messageResource.getMessageById(messageId).getComments().get(commentId);
	}*/
}
