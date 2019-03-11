package spider.ninetyonespider;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import spider.base.BaseSpider;
import spider.commonbean.ImageBean;
import spider.commonbean.ResourcePageBean;

public class NinetyOneSpider extends BaseSpider<ResourcePageBean, NinetyOneArgsBean> {

	public NinetyOneSpider(NinetyOneArgsBean args) {
		super(args);
	}

	@Override
	public String getRequestUrl(NinetyOneArgsBean args) {
		StringBuilder requestUrl = new StringBuilder();
		String baseUrl = "http://a.t6k.co/v.php?";
		requestUrl.append(baseUrl);
		requestUrl.append("page=" + args.getPage());
		return requestUrl.toString();
	}

	@Override
	public ResourcePageBean parseData(Document document) {
		ResourcePageBean resourcePageBean = new ResourcePageBean();
		resourcePageBean.setResourceType(ResourcePageBean.TYPE_VEDIO);
		List<ImageBean> imageBeans = new ArrayList<>();
		Elements targetElements = document.getElementsByClass("listchannel");
		for (Element element : targetElements) {
			ImageBean imageBean = new ImageBean();
			// 解析一级数据
			Element childElement1 = element.children().first();
			Element childElement2 = childElement1.getElementsByTag("a").get(0);
			Element childElement3 = childElement2.getElementsByTag("img").get(0);
			imageBean.setThumbUrl(childElement3.attr("src"));
			imageBean.setTitle(childElement3.attr("title"));
			Element childElement4 = element.getElementsByClass("info").get(0);
			imageBean.setDesc(childElement4.text());
			imageBean.setObjUrl(childElement2.attr("href"));
			imageBeans.add(imageBean);
		}
		resourcePageBean.setImageBeans(imageBeans);
		return resourcePageBean;
	}

}
