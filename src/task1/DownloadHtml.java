package task1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadHtml {

    public static void main(String[] args) {
        try(InputStream input = new URL("https://example.com/").openStream();
            OutputStream ops = new FileOutputStream("example.html")) {
           int data = input.read();
            while (data != -1){
                ops.write(data);
                data = input.read();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
