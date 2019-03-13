package cn.jbolt.service;

import spider.baiduimagespider.BaiDuImageSpider;
import spider.baiduimagespider.BaiduImageArgsBean;
import spider.commonbean.ResourcePageBean;
import spider.ninetyonespider.NinetyOneArgsBean;
import spider.ninetyonespider.NinetyOneSpider;
import spider.wallherespider.WallHereArgsBean;
import spider.wallherespider.WallHereSpider;

public class ResourceService {

	public ResourcePageBean spiderResource(String keyWord, int page,String resourceFrom){
		ResourcePageBean resourcePageBean = null;
		if ("WallHere".equals(resourceFrom)) {
			resourcePageBean = spiderFromWallHere(keyWord, page);
		} else if ("BaiDu".equals(resourceFrom)) {
			resourcePageBean = spiderFromBaiDuImage(keyWord, page);
		} else if ("91".equals(resourceFrom)) {
			resourcePageBean = spiderFrom91(page);
		} 
		return resourcePageBean;
	}
	
	private ResourcePageBean spiderFromWallHere(String keyWord, int page) {
		WallHereArgsBean wallHereArgsBean = new WallHereArgsBean();
		wallHereArgsBean.setKeyWord(keyWord);
		wallHereArgsBean.setPage(page);
		return new WallHereSpider(wallHereArgsBean).spiderData();
	}

	private ResourcePageBean spiderFromBaiDuImage(String keyWord, int page) {
		BaiduImageArgsBean baiduImageArgsBean = new BaiduImageArgsBean();
		baiduImageArgsBean.setKeyWord(keyWord);
		baiduImageArgsBean.setPageNum(page);
		return new BaiDuImageSpider(baiduImageArgsBean).spiderData();
	}

	private ResourcePageBean spiderFrom91(int page) {
		NinetyOneArgsBean ninetyOneArgsBean = new NinetyOneArgsBean();
		ninetyOneArgsBean.setPage(page);
		return new NinetyOneSpider(ninetyOneArgsBean).spiderData();
	}
}
