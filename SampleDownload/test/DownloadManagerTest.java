import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DownloadManagerTest {

    @Test
    public void startDownload() {
    }

    @Test
    void download(String[] args) {
        System.out.println("Hello World!");
        //list被new出来以后，不添加任何数据的时候就是null，所以用list.get(0)会报错，要用list.isEmpty
        List list = new ArrayList<String>();
        list.add("adwd");
        System.out.println(list.isEmpty());

        DownloadManager manager = DownloadManager.getInstance();
        DownloadInfo info1 = new DownloadInfo("https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-inst-win64.exe", null, null, 8);

        try {
            manager.startDownload(info1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
*
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //list被new出来以后，不添加任何数据的时候就是null，所以用list.get(0)会报错，要用list.isEmpty
        List list = new ArrayList<String>();
        list.add("adwd");
        System.out.println(list.isEmpty());

        DownloadManager manager=DownloadManager.getInstance();
        DownloadInfo info1=new DownloadInfo("https://raw.githubusercontent.com/guolindev/eclipse/master/eclipse-inst-win64.exe",null,null,8);

        try {
            manager.startDownload(info1);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
*/