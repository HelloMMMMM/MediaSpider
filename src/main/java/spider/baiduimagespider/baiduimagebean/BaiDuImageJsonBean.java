package spider.baiduimagespider.baiduimagebean;

import java.util.List;

public class BaiDuImageJsonBean {

	private String queryEnc;
	private String queryExt;
	private int listNum;
	private long displayNum;
	private String gsm;
	private String bdFmtDispNum;
	private String bdSearchTime;
	private int isNeedAsyncRequest;
	private String bdIsClustered;
	private List<Data> data;

	public void setQueryEnc(String queryEnc) {
		this.queryEnc = queryEnc;
	}

	public String getQueryEnc() {
		return queryEnc;
	}

	public void setQueryExt(String queryExt) {
		this.queryExt = queryExt;
	}

	public String getQueryExt() {
		return queryExt;
	}

	public void setListNum(int listNum) {
		this.listNum = listNum;
	}

	public int getListNum() {
		return listNum;
	}

	public void setDisplayNum(long displayNum) {
		this.displayNum = displayNum;
	}

	public long getDisplayNum() {
		return displayNum;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public String getGsm() {
		return gsm;
	}

	public void setBdFmtDispNum(String bdFmtDispNum) {
		this.bdFmtDispNum = bdFmtDispNum;
	}

	public String getBdFmtDispNum() {
		return bdFmtDispNum;
	}

	public void setBdSearchTime(String bdSearchTime) {
		this.bdSearchTime = bdSearchTime;
	}

	public String getBdSearchTime() {
		return bdSearchTime;
	}

	public void setIsNeedAsyncRequest(int isNeedAsyncRequest) {
		this.isNeedAsyncRequest = isNeedAsyncRequest;
	}

	public int getIsNeedAsyncRequest() {
		return isNeedAsyncRequest;
	}

	public void setBdIsClustered(String bdIsClustered) {
		this.bdIsClustered = bdIsClustered;
	}

	public String getBdIsClustered() {
		return bdIsClustered;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public List<Data> getData() {
		return data;
	}
}
