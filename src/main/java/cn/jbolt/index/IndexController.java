package cn.jbolt.index;

import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

import cn.jbolt.common.common.HandleTimeInterceptor;
import cn.jbolt.common.common.UrlFileRender;
import spider.commonbean.ImageBean;
import spider.util.IPUtil;
import spider.util.RequestHeaderUtil;

@Before(HandleTimeInterceptor.class)
public class IndexController extends Controller {

	@Inject
	private IndexService indexService;

	@Before(IndexInterceptor.class)
	public void index() {
		// 获取参数
		String keyWord = get("keyWord");
		int page = getAttrForInt("page");
		int totalPage = getAttrForInt("totalPage");
		String resourceFrom = get("resourceFrom", "WallHere");
		// 根据参数获取数据,设置相关数据，并渲染
		List<ImageBean> imageBeans = null;
		if ("WallHere".equals(resourceFrom)) {
			imageBeans = indexService.spiderFromWallHere(keyWord, page);
		} else if ("BaiDu".equals(resourceFrom)) {
			imageBeans = indexService.spiderFromBaiDuImage(keyWord, page);
		} else if ("91".equals(resourceFrom)) {
			imageBeans = indexService.spiderFrom91(page);
		} else {
			renderError(404);
			return;
		}
		totalPage = ImageBean.totalPage;
		set("resourceFrom", resourceFrom).set("keyWord", keyWord).set("page", page).set("totalPage", totalPage)
				.set("imgData", imageBeans).set("isVedio", ImageBean.isVedio).render("index.html");
	}

	public void download() {
		String targetUrl = get("targetUrl");
		render(new UrlFileRender(targetUrl));
	}
	
	public void parseVedioUrl(){
		String targetUrl=get("targetUrl");
		//解析二级数据
		//IPUtil.setRandomProxyIP();
		Connection secondConnection=Jsoup.connect(targetUrl);
		secondConnection.data(RequestHeaderUtil.getRandomHeader(targetUrl));
		try {
			Document secondDocument=secondConnection.get();
			String objUrl=secondDocument.select("source[src]").get(0).attr("src");
			set("objUrl", objUrl).render("play.html");
		} catch (Exception e) {
			renderError(404);
			e.printStackTrace();
		}
	}
}
