package cn.jbolt.common.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.jfinal.kit.LogKit;
import com.jfinal.render.Render;
import com.jfinal.render.RenderException;

import spider.util.RequestHeaderUtil;

/**
 * 自定义的render,负责从非同源网站下载文件
 */
public class UrlFileRender extends Render {

	private Logger logger = Logger.getLogger(UrlFileRender.class);
	private String url;

	public UrlFileRender(String url) {
		this.url = url;
	}

	@Override
	public void render() {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			long startTime = Calendar.getInstance().getTimeInMillis();
			// 连接
			URL url = new URL(this.url);
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			// 设置请求头
			Map<String, String> header = RequestHeaderUtil.getRandomHeader(this.url);
			Set<String> keySet = header.keySet();
			for (String key : keySet) {
				httpConnection.setRequestProperty(key, header.get(key));
			}
			// 设置响应头
			response.setHeader("Accept-Ranges", "bytes");
			response.setHeader("Content-disposition", "attachment;");
			response.setContentType(httpConnection.getContentType());
			// 传输数据
			inputStream = httpConnection.getInputStream();
			long connectedTime = Calendar.getInstance().getTimeInMillis();
			outputStream = response.getOutputStream();
			byte[] buffer = new byte[1024];
			for (int len = -1; (len = inputStream.read(buffer)) != -1;) {
				outputStream.write(buffer, 0, len);
			}
			outputStream.flush();
			outputStream.close();
			long responseTime = Calendar.getInstance().getTimeInMillis();
			logger.info("\n连接资源耗时(ms):"+(connectedTime-startTime)
					+"\n响应耗时(ms):"+(responseTime-connectedTime));
		} catch (Exception e) {
			throw new RenderException(e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					LogKit.error(e.getMessage(), e);
				}
			}
		}
	}
}
