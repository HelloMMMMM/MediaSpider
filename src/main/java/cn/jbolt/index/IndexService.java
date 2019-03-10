package cn.jbolt.index;

import java.util.List;

import spider.baiduimagespider.BaiDuImageSpider;
import spider.baiduimagespider.BaiduImageArgsBean;
import spider.commonbean.ImageBean;
import spider.ninetyonespider.NinetyOneArgsBean;
import spider.ninetyonespider.NinetyOneSpider;
import spider.wallherespider.WallHereArgsBean;
import spider.wallherespider.WallHereSpider;

public class IndexService {

	public List<ImageBean> spiderFromWallHere(String keyWord, int page) {
		WallHereArgsBean wallHereArgsBean = new WallHereArgsBean();
		wallHereArgsBean.setKeyWord(keyWord);
		wallHereArgsBean.setPage(page);
		ImageBean.isVedio=false;
		return new WallHereSpider(wallHereArgsBean).spiderData();
	}

	public List<ImageBean> spiderFromBaiDuImage(String keyWord, int page) {
		BaiduImageArgsBean baiduImageArgsBean = new BaiduImageArgsBean();
		baiduImageArgsBean.setKeyWord(keyWord);
		baiduImageArgsBean.setPageNum(page);
		ImageBean.isVedio=false;
		return new BaiDuImageSpider(baiduImageArgsBean).spiderData();
	}

	public List<ImageBean> spiderFrom91(int page) {
		NinetyOneArgsBean ninetyOneArgsBean = new NinetyOneArgsBean();
		ninetyOneArgsBean.setPage(page);
		ImageBean.isVedio=true;
		return new NinetyOneSpider(ninetyOneArgsBean).spiderData();
	}
}
