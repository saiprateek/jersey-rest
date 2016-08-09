package com.jersy.rest.message;

import javax.xml.bind.annotation.XmlRootElement;

 

@XmlRootElement
public class Profile {

	private String id;
	private String name;
	private String value;
	public Profile(String id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}
	
	public Profile() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
