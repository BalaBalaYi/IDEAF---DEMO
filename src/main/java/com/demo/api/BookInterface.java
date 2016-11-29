package com.demo.api;

import com.demo.vo.BookVO;

/**
 * 模拟对外的接口
 * @author chenty
 *
 */
public interface BookInterface {

	/**
	 * 根据id查找书籍
	 * @param id
	 * @return
	 */
	public BookVO findBookById(Long id);
}
