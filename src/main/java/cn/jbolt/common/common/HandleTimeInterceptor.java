package cn.jbolt.common.common;

import java.util.Calendar;

import org.apache.log4j.Logger;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class HandleTimeInterceptor implements Interceptor {
	private Logger logger = Logger.getLogger(HandleTimeInterceptor.class);

	@Override
	public void intercept(Invocation inv) {
		long startTime = Calendar.getInstance().getTimeInMillis();
		inv.invoke();
		long endTime = Calendar.getInstance().getTimeInMillis();
		logger.info("处理时间:" + (endTime - startTime)+"ms");
	}

}
