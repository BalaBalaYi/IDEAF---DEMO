package com.demo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.baidu.disconf.client.common.annotations.DisconfFile;
import com.baidu.disconf.client.common.annotations.DisconfFileItem;

@Component
@Scope("singleton")
@DisconfFile(filename = "page.properties")
public class Page {

	//分页的页面大小
	private int pageSize;

	@DisconfFileItem(name = "pageSize")
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
