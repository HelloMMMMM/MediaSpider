package cn.jbolt.index;

import spider.baiduimagespider.BaiDuImageSpider;
import spider.baiduimagespider.BaiduImageArgsBean;
import spider.commonbean.ResourcePageBean;
import spider.ninetyonespider.NinetyOneArgsBean;
import spider.ninetyonespider.NinetyOneSpider;
import spider.wallherespider.WallHereArgsBean;
import spider.wallherespider.WallHereSpider;

public class IndexService {

	public ResourcePageBean spiderFromWallHere(String keyWord, int page) {
		WallHereArgsBean wallHereArgsBean = new WallHereArgsBean();
		wallHereArgsBean.setKeyWord(keyWord);
		wallHereArgsBean.setPage(page);
		return new WallHereSpider(wallHereArgsBean).spiderData();
	}

	public ResourcePageBean spiderFromBaiDuImage(String keyWord, int page) {
		BaiduImageArgsBean baiduImageArgsBean = new BaiduImageArgsBean();
		baiduImageArgsBean.setKeyWord(keyWord);
		baiduImageArgsBean.setPageNum(page);
		return new BaiDuImageSpider(baiduImageArgsBean).spiderData();
	}

	public ResourcePageBean spiderFrom91(int page) {
		NinetyOneArgsBean ninetyOneArgsBean = new NinetyOneArgsBean();
		ninetyOneArgsBean.setPage(page);
		return new NinetyOneSpider(ninetyOneArgsBean).spiderData();
	}
}
