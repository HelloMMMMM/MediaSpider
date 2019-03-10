package spider.wallherespider;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import spider.base.BaseSpider;
import spider.commonbean.ImageBean;
import spider.wallherespider.WallHereArgsBean;

public class WallHereSpider extends BaseSpider<List<ImageBean>, WallHereArgsBean> {

	public WallHereSpider(WallHereArgsBean args) {
		super(args);
	}

	@Override
	public String getRequestUrl(WallHereArgsBean args) {
		StringBuilder requestUrl = new StringBuilder();
		String baseUrl = "https://wallhere.com/zh/wallpapers?";
		requestUrl.append(baseUrl);
		if (args.getKeyWord() != null) {
			requestUrl.append("q=" + args.getKeyWord());
		}
		if (args.getMinWidth() > 0) {
			requestUrl.append("&min_width=" + args.getMinWidth());
		}
		if (args.getMinHeight() > 0) {
			requestUrl.append("&min_height=" + args.getMinHeight());
		}
		String type = args.getType();
		if (type != null && (WallHereArgsBean.TYPE_POPULAR.equals(type) || WallHereArgsBean.TYPE_LATEST.equals(type))) {
			requestUrl.append("&order=" + type);
		}
		String direction = args.getDirection();
		if (direction != null && (WallHereArgsBean.DIRECTION_HORIZONTAL.equals(direction)
				|| WallHereArgsBean.DIRECTION_VERTICAL.equals(direction))) {
			requestUrl.append("&direction=" + direction);
		}
		if (args.getPage() > 0) {
			requestUrl.append("&page=" + args.getPage());
		}
		return requestUrl.toString();
	}
	

	@Override
	public List<ImageBean> parseData(Document document) {
		/**
		 * www.wallhere.com图片压缩各参数意思 不保持比例: s:小图        保持比例: c:小图 f,q:中图 d:大图
		 */
		List<ImageBean> imageBeans = new ArrayList<>();
		// 获取搜索的图片总张数
		Element totalInfo = document.getElementsByClass("hub-totalinfo").get(0);
		String temp[] = totalInfo.text().split(" ");
		int total = -1;
		try {
			total = Integer.parseInt(temp[0]);
			ImageBean.totalPage = (int) (total/24F);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取图片信息
		Elements targetElements = document.getElementsByClass("item");
		for (Element element : targetElements) {
			ImageBean imageBean = new ImageBean();
			// 处理图片URL,根据缩略图URL修改参数获取其他尺寸图片
			Element childTargetElement = element.getElementsByTag("img").get(0);
			String tempThumpUrl = childTargetElement.attr("src");
			String thumbUrl = tempThumpUrl.substring(0, tempThumpUrl.length() - 1);
			// 中图
			String middleImageUrl = thumbUrl + "f";
			imageBean.setThumbUrl(middleImageUrl);
			// 大图
			String bigImageUrl = thumbUrl + "d";
			imageBean.setObjUrl(bigImageUrl);
			// 图片标题
			String attrString = childTargetElement.attr("alt");
			imageBean.setTitle(attrString);

			imageBeans.add(imageBean);
		}
		return imageBeans;
	}
}
