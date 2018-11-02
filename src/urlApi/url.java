package urlApi;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

public class url {
	public static void main(String path[]) throws Exception {
		URL u = new URL("http://route.showapi.com/594-4?showapi_appid%3Dmyappid%26s%3D%E7%99%BE%E5%BA%A6%26n%3D10%26showapi_sign%3Dmysecret");
		InputStream in = u.openStream();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
		byte buf[] = new byte[1024];
		int read = 0;
		while ((read = in .read(buf)) > 0) {
		out.write(buf, 0, read);
		}
		} finally {
		if ( in != null) {
		in .close();
		}
		}
		byte b[] = out.toByteArray();
		System.out.println(new String(b, "utf-8"));
		}
}
