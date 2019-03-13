package cn.jbolt.index;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

import cn.jbolt.common.common.HandleTimeInterceptor;
import cn.jbolt.common.common.UrlFileRender;
import cn.jbolt.interceptor.PageNumInterceptor;
import cn.jbolt.service.ResourceService;
import spider.commonbean.ResourcePageBean;
import spider.util.RequestHeaderUtil;

@Before(HandleTimeInterceptor.class)
public class IndexController extends Controller {

	@Inject
	private ResourceService resourceService;

	@Before(PageNumInterceptor.class)
	public void index() {
		// 获取参数
		String keyWord = get("keyWord");
		int page = getAttrForInt("page");
		String resourceFrom = get("resourceFrom", "WallHere");
		// 根据参数获取数据,设置相关数据，并渲染
		ResourcePageBean resourcePageBean = resourceService.spiderResource(keyWord, page, resourceFrom);
		if (resourcePageBean == null) {
			renderError(404);
			return;
		}
		set("resourceFrom", resourceFrom).set("keyWord", keyWord).set("page", page)
				.set("resourcePageBean", resourcePageBean).render("index.html");
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
