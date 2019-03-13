package cn.jbolt.api;

import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

import cn.jbolt.interceptor.PageNumInterceptor;
import cn.jbolt.service.ResourceService;
import spider.commonbean.ResourcePageBean;

public class ApiController extends Controller {

	@Inject
	private ResourceService resourceService;

	@Before(PageNumInterceptor.class)
	public void resourcePage() {
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
		renderJson(resourcePageBean);
	}
}
