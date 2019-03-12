package cn.jbolt.api;

import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

import spider.commonbean.ResourcePageBean;

public class ApiController extends Controller {
	
	@Inject
	private ApiService apiService;
	
	public void resourcePage(){
		ResourcePageBean resourcePageBean=apiService.getResourcePage();
		renderJson(resourcePageBean);
	}
}
