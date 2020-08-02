package tool;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;

public class NTree {
    public TreeNode root;

    public NTree(String rootPath) {
        try {
            initTree(rootPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initTree(String rootPath) throws FileNotFoundException {
        File file=new File(rootPath);
        if (!file.exists()){
            throw new FileNotFoundException("文件不存在");
        }
        root.parent=null;


    }
}
