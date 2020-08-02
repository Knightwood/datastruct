package tool;

import java.util.List;

public class TreeNode {
    List<TreeNode> files;
    List<TreeNode> folders;
    TreeNode parent;

    enum FileKind {
        file,folder
    }
}
