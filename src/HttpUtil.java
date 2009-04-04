
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

/**
 *
 * @author patrik
 * Sköter http och parsar även svaret till en sträng
 */
public class HttpUtil {
    private String baseUrl;
   

    public HttpUtil(String bUrl) {
        this.baseUrl = bUrl;
       
    }
    
   
     public String httpGetQuery(String artist , String song){
         
    String value = null;
         
        try {
            
        
            HttpConnection connection;
            
            String url = baseUrl + "&a="+artist+"&t="+song;            
            while(url.indexOf(" ")!=-1){
                
                url = url.substring(0, url.indexOf(" ")) + "%20" + url.substring(url.indexOf(" ")+1);
                
            }
            connection = (HttpConnection)Connector.open(url);
            int length = (int) connection.getLength();
            DataInputStream in = new DataInputStream(connection.openInputStream());
            byte[] data = new byte[length];
            in.read(data);
            
            value = new String(data);
            if(value.indexOf("<tx>")!=-1){
            
                value = value.substring(value.indexOf("<tx>")+4, value.indexOf("</tx>")-4);
                while(value.indexOf("[br]")!=-1){
                    value = value.substring(0,value.indexOf("[br]"))+value.substring(value.indexOf("[br]")+4);
                }
                while(value.indexOf("&")!=-1 && value.indexOf(";",value.indexOf("&"))!=-1){
                value = value.substring(0,value.indexOf("&")) + value.substring(0,value.indexOf(";", value.indexOf("&")));
                }
                connection.close();
           
            }else{
                   value = "Not Found";
            }
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
         return value;
        
    }

    public void httpPassQuery() {
        try {
            HttpConnection connection1;
            connection1 = (HttpConnection) Connector.open("http://http://lyricsfly.com/api/");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

 
}
