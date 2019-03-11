package spider.commonbean;

import java.util.List;

public class ResourcePageBean {
	public static final int TYPE_IMG = 1;
	public static final int TYPE_VEDIO = 2;

	private int totalPage;
	private int resourceType;
	private List<ImageBean> imageBeans;
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getResourceType() {
		return resourceType;
	}
	public void setResourceType(int resourceType) {
		this.resourceType = resourceType;
	}
	public List<ImageBean> getImageBeans() {
		return imageBeans;
	}
	public void setImageBeans(List<ImageBean> imageBeans) {
		this.imageBeans = imageBeans;
	}
}
