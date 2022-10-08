package tree;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TreeTest {
    public static void main(String[] args) {
        //创建一课平衡二叉搜索树
        TreeNode treeNode6 = new TreeNode(7, null, null);
        TreeNode treeNode5 = new TreeNode(6, null, null);
        TreeNode treeNode4 = new TreeNode(5, null, null);
        TreeNode treeNode3 = new TreeNode(4, null, null);
        TreeNode treeNode2 = new TreeNode(3, treeNode5, treeNode6);
        TreeNode treeNode1 = new TreeNode(2, treeNode3, treeNode4);
        TreeNode treeNode0 = new TreeNode(1, treeNode1, treeNode2);   //根节点

        List<Integer> list = new ArrayList<>();  //获取前序遍历的数值
        firstIteBack(treeNode0, list);

        for (int i : list) {
            System.out.print(i + " ");   //1 2 4 5 3 6 7
        }
        System.out.println();
        list.clear();

        // 前序遍历（迭代）
        //（直接用while的话，会发现第一次到一个树叶后就没办法再去遍历另一边的树叶了（对应return无果））
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode0);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) stack.push(cur.right);  //先压右，才能先出左
            if (cur.left != null) stack.push(cur.left);
        }

        for (int i : list) {
            System.out.print(i + " ");  //1 2 4 5 3 6 7
        }
        System.out.println();
        list.clear();

        // 中序遍历（迭代）
        //stack用上面的即可，因为跳出while循环时，stack为空


    }

    /**
     * 前序遍历（递归）
     * 1、确定函数参数： TreeNode cur, List list，返回值void（list自己存储）
     * 2、确定终止条件： cur == null
     * 3、确定递归内容
     */
    public static void firstIteBack(TreeNode cur , List list) {
        if (cur == null) return;
        list.add(cur.val);
        firstIteBack(cur.left, list);
        firstIteBack(cur.right, list);

        /*  //中序
            firstIteBack(cur.left, list);
            list.add(cur.val);
            firstIteBack(cur.right, list);
         */

        /*  //后序
            firstIteBack(cur.left, list);
            firstIteBack(cur.right, list);
            list.add(cur.val);
         */

    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
