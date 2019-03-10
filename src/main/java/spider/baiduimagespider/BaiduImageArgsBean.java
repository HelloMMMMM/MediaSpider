package spider.baiduimagespider;

import com.jfinal.kit.StrKit;

public class BaiduImageArgsBean {
	private String keyWord;
	private int pageNum;
	private int maxPerPage;
	private int width;
	private int height;

	public String getKeyWord() {
		return StrKit.isBlank(keyWord) ? "壁纸" : keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getMaxPerPage() {
		return maxPerPage != 0 ? maxPerPage : 50;
	}

	public void setMaxPerPage(int maxPerPage) {
		this.maxPerPage = maxPerPage;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
