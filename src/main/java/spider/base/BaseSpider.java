package spider.base;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import spider.util.RequestHeaderUtil;

public abstract class BaseSpider<R, A> {
	private A mArgs;

	public BaseSpider(A args) {
		if (args == null) {
			throw new NullPointerException("args can not be null");
		}
		this.mArgs = args;
	}

	public R spiderData() {
		Document document = requestData();
		R data = null;
		if (document != null) {
			data = parseData(document);
		}
		return data;
	}

	private Document requestData() {
		String requestUrl = getRequestUrl(mArgs);
		Connection connection = Jsoup.connect(requestUrl);
		connection.data(RequestHeaderUtil.getRandomHeader(requestUrl));
		Document document = null;
		try {
			document = connection.get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}

	/**
	 * 拼接请求URL
	 * 
	 * @param args请求所需参数
	 * @return 请求URL
	 */
	public abstract String getRequestUrl(A args);

	/**
	 * 解析爬取的文档
	 * 
	 * @param document需要解析的文档
	 * @return 解析之后的数据
	 */
	public abstract R parseData(Document document);
}
