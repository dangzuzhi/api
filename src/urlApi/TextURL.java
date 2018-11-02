package urlApi;
 
import java.io.BufferedInputStream; 
import java.io.IOException; 
import java.io.InputStream; 
import java.io.InputStreamReader; 
import java.io.Reader; 
import java.net.URL; 
import java.net.URLConnection; 

public class TextURL { 
/* 
* 获取url指定的资源 
*/ 
public static void getImageResourceByURL(String imagesFile) throws IOException{ 
URL url = new URL(imagesFile); 
Object obj = url.getContent();//获得url内容 
System.out.print(obj.getClass().getName());//显示名称 
} 
/* 
* 获取url指定的资源 
*/ 
public static void getHtmlResourceByURL(String htmlFile) throws IOException{ 
URL url = new URL(htmlFile); 
URLConnection us = url.openConnection();//创建远程连接对象 
InputStream in = us.getInputStream();//打开连接读取的输入流 
int c; 
while((c=in.read())!=-1){ 
System.out.print((char)c); 
} 
System.out.println(); 
in.close(); 
} 
/* 
* 读取url指定的网页资源 
*/ 
public static void getHTMLResource(String htmlFile) throws IOException{ 
URL url = new URL(htmlFile);//创建URL对象 
Reader reader = new InputStreamReader(//打开URL连接,创建一个读对象 
new BufferedInputStream(url.openStream())); 
int c; 
while((c = reader.read())!=-1){ 
System.out.print((char)c); 
} 
System.out.println(); 
reader.close(); 
} 
/* 
* 读取url指定的网页资源 
*/ 
public static void getResourceOfHTML(String htmlFile) throws IOException{ 
URL url = new URL(htmlFile); 
InputStream in = url.openStream();//打开url连接创建输入流 
int c; 
while((c = in.read()) !=-1){ 
System.out.print((char)c); 
} 
System.out.println(); 
in.close(); 
} 
/* 
* java所支持的url类型 
*/ 
public static void supportURLType(String host,String file) { 
String[] schemes = {"url","http","mailto","jdbc","telnet","ftp","netdoc"}; 
for(int i=0; i < schemes.length; i++){ 
try { 
URL url = new URL(schemes[i], host, file); 
System.out.println(schemes[i]+"是java的支持的URL类型rn"); 
} catch (Exception e) { 
System.out.println(schemes[i]+"不是java支持的URL类型rn"); 
} 
} 
} 
public static void main(String[] args) throws IOException { 
String imageFile ="https://gw.alicdn.com/tfs/TB1GxwdSXXXXXa.aXXXXXXXXXXX-65-70.gif"; 
String htmlFile ="https://www.aliyun.com/jiaocheng/531531.html"; 
String hostFile ="http://image.baidu.com/channel/wallpaper"; 
String file ="/1753.4.html"; 
//System.out.println("1.获取URL图像资源信息"); 
getImageResourceByURL("https://gw.alicdn.com/tfs/TB1GxwdSXXXXXa.aXXXXXXXXXXX-65-70.gif"); 
System.out.println(); 
//System.out.println("2.获取URL指定的HTML网页资源信息"); 
//getHtmlResourceByURL(htmlFile); 
//System.out.println("3.根据URL创建该对象读取网页内容"); 
//getHTMLResource(hostFile); 
//System.out.println("4.根据URL创建输入流读取网页内容"); 
//getResourceOfHTML(htmlFile); 
System.out.println("5.判断java所支持的url类型"); 
supportURLType(hostFile, file); 
} 
}