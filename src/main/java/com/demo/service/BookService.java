package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.BookDao;
import com.demo.entity.BookEntity;
import com.demo.vo.BookVO;
import com.github.pagehelper.PageHelper;

@Service
public class BookService {

	private Logger logger = LoggerFactory.getLogger(BookService.class);
	
	@Autowired
	private BookDao bookDao;
	@Autowired
	private Page page;
	
	public BookVO queryById(Integer id){
		BookEntity book = new BookEntity();
		BookVO bookVO = new BookVO();
		try {
			book = bookDao.queryById(id);
			bookVO = entityToVO(book);
		} catch (Exception e) {
			logger.error("BookService的queryById发生异常", e);
			return null;
		}
		return bookVO;
	}
	
	public List<BookVO> queryAll(int pageNum){
		List<BookEntity> bookList = new ArrayList<BookEntity>();
		List<BookVO> bookVOList = new ArrayList<BookVO>();
		try {
			if(0 == pageNum){
				pageNum = 1;
			}
			PageHelper.startPage(pageNum, page.getPageSize());
			bookList = bookDao.queryAll();
			
			//类型转换
			for(BookEntity entity : bookList){
				BookVO book = new BookVO();
				book = entityToVO(entity);
				bookVOList.add(book);
			}
			
		} catch (Exception e) {
			logger.error("BookService的queryAll发生异常", e);
			return null;
		}
		return bookVOList;
	}
	
	public boolean insert(BookEntity book){
		int insertResult = -1;
		try {
			insertResult = bookDao.insert(book);
			if(insertResult == 1){
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.error("BookService的insert发生异常", e);
			return false;
		}
	}
	
	public boolean update(BookEntity book){
		int updateResult = -1;
		try {
			updateResult = bookDao.update(book);
			if(updateResult == 1){
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.error("BookService的update发生异常", e);
			return false;
		}
	}
	
	public boolean delete(Integer id){
		int deleteResult = -1;
		try {
			deleteResult = bookDao.delete(id);
			if(deleteResult == 1){
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			logger.error("BookService的delete发生异常", e);
			return false;
		}
	}
	
	public BookVO entityToVO(BookEntity entity){
		if(null == entity){
			return null;
		}
		BookVO book = new BookVO();
		book.setId(entity.getId() + "");
		book.setAuthor(entity.getAuthor());
		book.setIsbn(entity.getIsbn());
		book.setName(entity.getName());
		book.setPrice(entity.getPrice());
		book.setPublicationTime(entity.getPublicationTime().toString());
		book.setPublisher(entity.getPublisher());
		return book;
	}

	public BookVO queryByISBN(String isbn) {
		BookEntity book = new BookEntity();
		BookVO bookVO = new BookVO();
		try {
			book = bookDao.queryByISBN(isbn);
			bookVO = entityToVO(book);
		} catch (Exception e) {
			logger.error("BookService的queryByISBN发生异常", e);
			return null;
		}
		return bookVO;
	}
}
