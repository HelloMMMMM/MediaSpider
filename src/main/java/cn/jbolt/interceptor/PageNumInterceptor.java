package cn.jbolt.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class PageNumInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		//对页码进行处理
		Controller controller = inv.getController();
		int page = controller.getParaToInt("page", 1);
		int totalPage = controller.getParaToInt("totalPage", 1);
		if (page < 1) {
			page = 1;
		} else if (totalPage > 1 && page > totalPage) {
			page = totalPage;
		}
		controller.set("page", page);
		inv.invoke();
	}

}
