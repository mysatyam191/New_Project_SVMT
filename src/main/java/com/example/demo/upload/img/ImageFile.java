package com.example.demo.upload.img;

import javax.persistence.*;

@Entity
public class ImageFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private byte[] data;

    private String contentType;

    // Constructors, getters, and setters

    public ImageFile() {
    }

    public ImageFile(String name, byte[] data, String contentType) {
        this.name = name;
        this.data = data;
        this.contentType = contentType;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public ImageFile(Long id, String name, byte[] data, String contentType) {
		super();
		this.id = id;
		this.name = name;
		this.data = data;
		this.contentType = contentType;
	}
    
	

    
    
}

