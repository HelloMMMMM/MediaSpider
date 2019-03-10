package spider.util;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import spider.commonbean.IPBean;

public class IPUtil {
	private static List<IPBean> ipBeans;

	static {
		// 代理IP数组
		ipBeans = new ArrayList<>();
		ipBeans.add(new IPBean("125.126.215.241", "9999"));
		ipBeans.add(new IPBean("125.123.141.242", "9999"));
		ipBeans.add(new IPBean("144.123.70.95", "9999"));
		ipBeans.add(new IPBean("111.177.169.197", "9999"));
		ipBeans.add(new IPBean("115.151.3.170", "9999"));
		ipBeans.add(new IPBean("1.192.243.220", "9999"));
		ipBeans.add(new IPBean("112.87.68.119", "9999"));
		ipBeans.add(new IPBean("113.122.169.1", "9999"));
		ipBeans.add(new IPBean("1.197.203.242", "9999"));
		ipBeans.add(new IPBean("222.223.115.30", "51618"));
	}

	public static IPBean getRandomIP() {
		return ipBeans.get((int) (Math.random() * ipBeans.size()));
	}

	public static void setRandomProxyIP() {
		IPBean ipBean = getRandomIP();
		String host=ipBean.getIp();
		while (!isHostReachable(host, 500)) {
			ipBean = getRandomIP();
		}
		System.getProperties().setProperty("http.proxyHost", ipBean.getIp());
		System.getProperties().setProperty("http.proxyPort", ipBean.getPort());
		
	}
	
	public static boolean isHostReachable(String host, Integer timeOut) {
        try {
            return Inet4Address.getByName(host).isReachable(timeOut);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
