import java.io.IOException; 
import java.net.InetAddress; 

public class TestInetAddress { 
        public static void main(String[] args) throws IOException { 
                test(); 
        } 

        public static void test() throws IOException { 
                //获取本机的IP地址 
                InetAddress address1 = InetAddress.getLocalHost(); 
                System.out.println(address1.getHostAddress()); 
                System.out.println(address1.toString()); 

                System.out.println("---------------"); 
                //获取51cot的IP地址 
                InetAddress address2 = InetAddress.getByName("www.51cto.com"); 
                System.out.println("getHostAddress:\t" + address2.getHostAddress()); 
                System.out.println("getHostName:\t" + address2.getHostName()); 
                System.out.println("---------------"); 
                //获取我博客的IP地址 
                InetAddress address3 = InetAddress.getByName("lavasoft.blog.51cto.com"); 
                System.out.println("getHostAddress:\t" + address3.getHostAddress()); 
                System.out.println("getHostName:\t" + address3.getHostName()); 
                //直接用ip地址构建 
                System.out.println(InetAddress.getByName("211.103.156.224")); 

                System.out.println("---------------"); 
                //获取[url]www.google.com[/url]域名下所有的IP地址 
//                InetAddress[] address4 = InetAddress.getAllByName("www.microsoft.com"); 
                InetAddress[] address4 = InetAddress.getAllByName("www.google.com"); 
                for (InetAddress address : address4) { 
//                                System.out.println(address.getHostAddress()); 
                        System.out.println(address); 
                } 

                InetAddress address5 = InetAddress.getByName("211.103.156.229"); 
                System.out.println(address5.isReachable(10)); 
        } 
}