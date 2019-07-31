package spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 网络爬虫基本原理
 * 用正则表达式提取网络链接
 * @author Administrator
 *
 */
public class WebSpiderTest {
	/*
	 * 获取url对应的网页内容
	 */
	public static String getURLContent(String urlStr,String charSet) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlStr);
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(),Charset.forName(charSet)));
			String temp = "";
			while((temp = reader.readLine())!=null) {
				sb.append(temp);
			}
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	/*
	 * 用正则进行查找
	 * 将链接存放到List集合中
	 */
	public static List<String> getUrl(String desStr,String regexStr){
		Pattern p = Pattern.compile(regexStr);
		Matcher m = p.matcher(desStr);
		List<String> result = new ArrayList<String>();
		while(m.find()) {
			result.add(m.group(1));
		}
		return result;
	}
	
	public static void main(String[] args) {
		String desStr = getURLContent("http://www.163.com","gbk");
		//System.out.println(desStr);
		//List<String> result = getUrl(desStr, "<a[\\s\\S]+?</a>");
		List<String> result = getUrl(desStr, "href=\"(http+[\\w\\s./:]+?)\"");
		for(String temp : result) {
			System.out.println(temp);
		}
	}
}
