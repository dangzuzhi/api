package showapi;

import com.show.api.ShowApiRequest;

public class showapi {
public static void main(String[] args) {
	String res=new ShowApiRequest("http://route.showapi.com/594-4","my_appId","my_appSecret")
			.addTextPara("s","°Ù¶È")
			.addTextPara("n","10")
		  .post();
		System.out.println(res);
}
}
