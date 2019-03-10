package spider.commonbean;

public class IPBean {

	private String ip;
	private String port;
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public IPBean(String ip, String port) {
		this.ip = ip;
		this.port = port;
	}
}
