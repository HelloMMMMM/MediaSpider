package spider.wallherespider;

public class WallHereArgsBean {
	public static final String TYPE_POPULAR = "popular";
	public static final String TYPE_LATEST = "latest";
	public static final String DIRECTION_HORIZONTAL = "horizontal";
	public static final String DIRECTION_VERTICAL = "vertical";
	
	private String keyWord;
	private int minWidth;
	private int minHeight;
	private String type;
	private String direction;
	private int page;
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public int getMinWidth() {
		return minWidth;
	}
	public void setMinWidth(int minWidth) {
		this.minWidth = minWidth;
	}
	public int getMinHeight() {
		return minHeight;
	}
	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}
