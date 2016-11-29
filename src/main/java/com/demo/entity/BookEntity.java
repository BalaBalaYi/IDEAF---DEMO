package com.demo.entity;

import java.io.Serializable;
import java.util.Date;

public class BookEntity implements Serializable{

	private static final long serialVersionUID = 7858750449579576020L;
	
	private Long id;
	private String name;
	private String author;
	private String publisher;
	private Date publicationTime;
	private String price;
	private String isbn;
	
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublicationTime() {
		return publicationTime;
	}
	public void setPublicationTime(Date publicationTime) {
		this.publicationTime = publicationTime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@Override
	public String toString() {
		return "BookVO [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher
				+ ", publicationTime=" + publicationTime + ", price=" + price + ", isbn=" + isbn + "]";
	}
	
	
}
