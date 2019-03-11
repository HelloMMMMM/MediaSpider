package spider.baiduimagespider;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;

import com.alibaba.fastjson.JSON;

import spider.baiduimagespider.baiduimagebean.BaiDuImageJsonBean;
import spider.baiduimagespider.baiduimagebean.Data;
import spider.base.BaseSpider;
import spider.commonbean.ImageBean;
import spider.commonbean.ResourcePageBean;
import spider.util.DecryptUtil;

public class BaiDuImageSpider extends BaseSpider<ResourcePageBean, BaiduImageArgsBean> {

	public BaiDuImageSpider(BaiduImageArgsBean args) {
		super(args);
	}

	@Override
	public String getRequestUrl(BaiduImageArgsBean args) {
		StringBuilder requestUrl = new StringBuilder();
		String baseUrl = "https://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rjfp=result&cl=2&lm=-1&st=-1&face=0&istype=2&nc=1&gsm=1e";
		requestUrl.append(baseUrl);
		requestUrl.append("&word=" + args.getKeyWord());
		requestUrl.append("&pn=" + (args.getPageNum() * args.getMaxPerPage()));
		requestUrl.append("&rn=" + args.getMaxPerPage());
		requestUrl.append("&width=" + (args.getWidth() != 0 ? args.getWidth() : ""));
		requestUrl.append("&height=" + (args.getHeight() != 0 ? args.getHeight() : ""));
		return requestUrl.toString();
	}

	@Override
	public ResourcePageBean parseData(Document document) {
		ResourcePageBean resourcePageBean = new ResourcePageBean();
		resourcePageBean.setResourceType(ResourcePageBean.TYPE_IMG);
		List<ImageBean> imageBeans = new ArrayList<>();
		BaiDuImageJsonBean baiDuImageJsonBean = JSON.parseObject(document.body().text(), BaiDuImageJsonBean.class);
		resourcePageBean.setTotalPage((int) (baiDuImageJsonBean.getListNum() / 50f));
		for (Data data : baiDuImageJsonBean.getData()) {
			ImageBean imageBean = new ImageBean();
			String thumbUrl = data.getThumbURL();
			String objUrl = data.getObjURL();
			if (thumbUrl != null && !"".equals(thumbUrl) && objUrl != null && !"".equals(objUrl)) {
				imageBean.setTitle(data.getFromPageTitle());
				imageBean.setThumbUrl(thumbUrl);
				String plaintext = DecryptUtil.decryptBaiDuImageUrl(data.getObjURL());
				imageBean.setObjUrl(plaintext);
				imageBeans.add(imageBean);
			}
		}
		resourcePageBean.setImageBeans(imageBeans);
		return resourcePageBean;
	}

}
