package com.example.demo.features.home;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "svmt_home")
public class Home {
	
	@Id
	private String keyName;
	
	@Column(columnDefinition = "TEXT")
	private String value;

	public String getKey() {
		return keyName;
	}

	public void setKey(String key) {
		this.keyName = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
