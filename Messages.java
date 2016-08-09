package com.jersy.rest.message;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Messages {

	private Long id;
	private String creater;
	private String value;
	private String created;
	private Map<Long,Comment> comments = new HashMap<>();
	public Messages() {
		 
	}

	public Messages(Long id, String creater, String value, String string, Map<Long,Comment> comments) {
		super();
		this.id = id;
		this.creater = creater;
		this.value = value;
		this.created=string;
		this.comments=comments;
	}

	
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	//@XmlTransient
	public Map<Long, Comment> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comment> comments) {
		this.comments = comments;
	}

	 
	
	
}
