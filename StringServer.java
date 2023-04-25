import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {

    String message = "";
    public String handleRequest(URI url){
        if (url.getPath().equals("/")) {
             return String.format("Your messages: %s", message);
        }
        else if(url.getPath().contains("/add-message")){
            String[] param = url.getQuery().split("=");
            //String template = param + "\n";
            System.out.println("Added " + param[1] + " to your messages!"); 
            System.out.println(param[1]);
            message = message + "\n" + param[1];
            return String.format("Added %s to your messages!", param[1]);
        }
        return "404 Not Found!";
    }
}
public class StringServer{
    public static void main(String[] arr) throws IOException{
        if(arr.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        int port = Integer.parseInt(arr[0]);
        Server.start(port, new Handler());
    }
}
