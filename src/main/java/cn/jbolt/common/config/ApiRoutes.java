package cn.jbolt.common.config;

import com.jfinal.config.Routes;

import cn.jbolt.api.ApiController;

public class ApiRoutes extends Routes {

	@Override
	public void config() {
		//针对一组路由配置baseViewPath
		//this.setBaseViewPath("/_view/_admin");
		//针对一组路由配置单独的拦截器
		//this.addInterceptor(new AdminAuthInterceptor());
		//针对后台管理系统配置路由+controller
		//this.add("/admin", AdminIndexController.class,"/index");
		setBaseViewPath("/api");
		add("/api",ApiController.class);
	}

}