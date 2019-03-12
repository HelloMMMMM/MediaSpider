package cn.jbolt.api;

import spider.commonbean.ResourcePageBean;
import spider.wallherespider.WallHereArgsBean;
import spider.wallherespider.WallHereSpider;

public class ApiService {
	
	public ResourcePageBean getResourcePage(){
		WallHereArgsBean wallHereArgsBean = new WallHereArgsBean();
		wallHereArgsBean.setKeyWord("动漫");
		wallHereArgsBean.setPage(1);
		return new WallHereSpider(wallHereArgsBean).spiderData();
	}
}
