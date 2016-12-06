package com.demo.job;

import java.util.Calendar;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.demo.service.BookService;
import com.demo.util.CommonUtil;
import com.demo.util.DateUtil;
import com.demo.vo.BookVO;

public class BookAddingJob implements SimpleJob {
	
	private Logger logger = LoggerFactory.getLogger(BookService.class);
	
	@Resource
	private BookService bookService;
	
	@Override
	public void execute(ShardingContext shardingContext) {
		
		logger.info("进入书籍添加自动化作业------>");
		boolean result = false;
		
		switch (shardingContext.getShardingItem()) {
			case 0: 
				logger.info("进行普通书籍添加--->");
				result = doBookAddingByType("0");
			case 1: 
				logger.info("进行精品书籍添加--->");
				result = doBookAddingByType("1");
		}
		
		if(result){
			logger.info("完成书籍添加自动化作业！");
		} else {
			logger.warn("书籍添加自动化作业失败！");
		}
		
		
	}
		
	
	public boolean doBookAddingByType(String type){
		
		BookVO book = new BookVO();
		boolean insertResult = false;
		
		try{
			//初始化书籍
			book.setAuthor("Author" + CommonUtil.getRandomNaturalWithMax(100));
			Long timeStamp = DateUtil.getTimeStampForNow();
			book.setIsbn("ISBN" + timeStamp + CommonUtil.generateRandomNumberWithNoConflict(3));
			book.setName("BOOK" + timeStamp);
			book.setPrice("0".equals(type) 
					? CommonUtil.getRandomNaturalWithMinAndMax(0, 50) + "" 
					: CommonUtil.getRandomNaturalWithMinAndMax(50, 100) + "");
			String tempTime = DateUtil.getTimeForNowByType(Calendar.YEAR) 
					+ "/" + (DateUtil.getTimeForNowByType(Calendar.MONTH) + 1)
					+ "/" + DateUtil.getTimeForNowByType(Calendar.DATE);
			book.setPublicationTime(tempTime);
			book.setPublisher("Publisher" + CommonUtil.getRandomNaturalWithMax(100));
			insertResult = bookService.insert(book);
		} catch (Exception e) {
			logger.error("添加书籍入库发生异常！", e);
			return false;
		}
		return insertResult;
	}
	
	public static void main(String[] args) throws Exception {
		BookVO book = new BookVO();
		book.setAuthor("Author" + CommonUtil.getRandomNaturalWithMax(100));
		Long timeStamp = DateUtil.getTimeStampForNow();
		book.setIsbn("ISBN" + timeStamp);
		book.setName("BOOK" + timeStamp);
		book.setPrice("0".equals("1") 
				? CommonUtil.getRandomNaturalWithMinAndMax(0, 50) + "" 
				: CommonUtil.getRandomNaturalWithMinAndMax(50, 100) + "");
		String tempTime = DateUtil.getTimeForNowByType(Calendar.YEAR) 
				+ "/" + (DateUtil.getTimeForNowByType(Calendar.MONTH) + 1)
				+ "/" + DateUtil.getTimeForNowByType(Calendar.DATE);
		book.setPublicationTime(tempTime);
		book.setPublisher("Publisher" + CommonUtil.getRandomNaturalWithMax(100));
		System.out.println(book.toString());
	}
	
}
