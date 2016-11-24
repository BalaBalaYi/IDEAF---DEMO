package com.demo.api.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.api.BookInterface;
import com.demo.service.BookService;
import com.demo.vo.BookVO;

/**
 * 对外接口实现
 * @author chenty
 *
 */
public class BookInterfaceImpl implements BookInterface{

	@Autowired
	private BookService  bookService;
	
	public BookVO findBookById(Integer id){
		return bookService.queryById(id);
	}
}
