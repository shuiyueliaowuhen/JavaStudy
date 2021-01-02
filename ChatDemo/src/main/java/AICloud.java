import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.UUID;


public class AICloud {
    private String userId= UUID.randomUUID().toString().replace("-","");
    private String cloudLocation = "http://118.31.38.150:10241/heima/ai/v1_0/talk?userId="+userId+"&content=";
    public AICloud() {
    }
    public AICloud(String cloudLocation) {
        this.cloudLocation = cloudLocation;
    }


    public String talk(String content){
        try {
            URL url = new URL(cloudLocation+ URLEncoder.encode(content,"utf-8"));
            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(50*1000);

            InputStream is = conn.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > -1 ) {
                baos.write(buffer, 0, len);
            }
            baos.flush();

            String rsp = baos.toString("UTF-8");

            return rsp;
        } catch (IOException|RuntimeException e) {
              e.printStackTrace();
              return "宝宝累了~一会儿再陪您~";
        }
    }
}
