import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        DownloadManager manager=DownloadManager.getInstance();
        DownloadInfo info1=new DownloadInfo("https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-inst-win64.exe",null,null,8);

        try {
            manager.startDownload(info1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
