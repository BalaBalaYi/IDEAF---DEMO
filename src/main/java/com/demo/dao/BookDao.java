package com.demo.dao;

import java.util.List;

import com.demo.entity.BookEntity;

public interface BookDao {

	public BookEntity queryById(Integer id);

	public List<BookEntity> queryAll();
	
	public int insert(BookEntity book);
	
	public int update(BookEntity book);
	
	public int delete(Integer id);

	public BookEntity queryByISBN(String isbn);
	
}
