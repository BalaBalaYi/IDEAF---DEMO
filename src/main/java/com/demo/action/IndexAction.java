package com.demo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.service.BookService;
import com.demo.vo.BookVO;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/*")
public class IndexAction {

	private Logger logger = LoggerFactory.getLogger(IndexAction.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("toIndex.do")
	public String toIndex(HttpServletRequest request){
		logger.info("跳转主页");
		return "index";
	}
	
	@RequestMapping("toQuery.do")
	public String toQuery(HttpServletRequest request){
		logger.info("跳转至DEMO页");
		return "query";
	}
	
	@RequestMapping("query.do")
	public void query(HttpServletRequest request, HttpServletResponse response){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<BookVO> bookList = new ArrayList<BookVO>();
		
		String bookId = request.getParameter("bookId");
		String pageNumParam = request.getParameter("pageNum");
		
		int pageNum = 0;
		PageInfo<BookVO> page = null;
		
		if(!StringUtil.isEmpty(pageNumParam)){
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		if(bookId != "" && bookId != null){
			logger.info("根据id查询书籍，id:" + bookId);
			
			//查询单个
			BookVO book = bookService.queryById(Long.valueOf(bookId));
			bookList.add(book);
			resultMap.put("bookList", bookList);
		} else {
			logger.info("查询全部书籍");
			
			//查询所有
			bookList = bookService.queryAll(pageNum);
			logger.info("查询结果：" + bookList.size() + "个");
			
			resultMap.put("bookList", bookList);
			page = new PageInfo<BookVO>(bookList);
			resultMap.put("pageNum", page.getPageNum());
			resultMap.put("pages", page.getPages());
			resultMap.put("totalCount", page.getTotal());
		}
		
		PrintWriter writer = null;
		try {
			response.setCharacterEncoding("utf-8");
			writer = response.getWriter();
			writer.write(JSONObject.fromObject(resultMap).toString());
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if( writer != null){
				writer.close();
			}
		}
	}
	
	@RequestMapping("toAdd.do")
	public String toAdd(){
		return "add";
	}
	
	@RequestMapping("add.do")
	public void add(HttpServletRequest request, HttpServletResponse response, BookVO book){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		logger.info("新增书籍，book:" + book.toString());
		
		boolean result = bookService.insert(book);
		
		if(result){
			resultMap.put("addResult", "添加成功！");
		} else {
			resultMap.put("addResult", "添加失败！");
		}
		
		PrintWriter writer = null;
		try {
			response.setCharacterEncoding("utf-8");
			writer = response.getWriter();
			writer.write(JSONObject.fromObject(resultMap).toString());
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if( writer != null){
				writer.close();
			}
		}
	}
	
	@RequestMapping("toUpdate.do")
	public ModelAndView toUpdate(HttpServletRequest request){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String bookId = request.getParameter("bookId");
		
		BookVO book = bookService.queryById(Long.valueOf(bookId));
		resultMap.put("book", book);
		
		return new ModelAndView("update", resultMap);
	}
	
	@RequestMapping("update.do")
	public void update(HttpServletRequest request, HttpServletResponse response, BookVO book){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		logger.info("修改书籍，book:" + book.toString());
		
		boolean result = bookService.update(book);
		
		if(result){
			resultMap.put("updateResult", "修改成功！");
		} else {
			resultMap.put("updateResult", "修改失败！");
		}
		
		PrintWriter writer = null;
		try {
			response.setCharacterEncoding("utf-8");
			writer = response.getWriter();
			writer.write(JSONObject.fromObject(resultMap).toString());
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if( writer != null){
				writer.close();
			}
		}
	}
	
	@RequestMapping("delete.do")
	public void delete(HttpServletRequest request, HttpServletResponse response){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String bookId = request.getParameter("bookId");
		
		logger.info("删除书籍，id:" + bookId);
		
		boolean result = bookService.delete(Long.valueOf(bookId));
		
		if(result){
			resultMap.put("deleteResult", "删除成功！");
		} else {
			resultMap.put("deleteResult", "删除失败！");
		}
		
		PrintWriter writer = null;
		try {
			response.setCharacterEncoding("utf-8");
			writer = response.getWriter();
			writer.write(JSONObject.fromObject(resultMap).toString());
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if( writer != null){
				writer.close();
			}
		}
	}
	
	@RequestMapping("queryByISBN.do")
	public void queryByISBN(HttpServletRequest request, HttpServletResponse response){
				
		Map<String, Object> resultMap = new HashMap<String, Object>();		
		String isbn = request.getParameter("isbn");
		
		logger.info("根据ISBN查询书籍，ISBN：" + isbn);
		
		BookVO book = bookService.queryByISBN(isbn);
		logger.info("根据ISBN查询到的书籍：" + book);
		resultMap.put("book", book);
	
		PrintWriter writer = null;
		try {
			response.setCharacterEncoding("utf-8");
			writer = response.getWriter();
			writer.write(JSONObject.fromObject(resultMap).toString());
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if( writer != null){
				writer.close();
			}
		}
	}
	
}
