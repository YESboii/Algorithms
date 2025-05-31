package Trees;
//https://takeuforward.org/plus/dsa/problems/top-view-of-bt


import java.util.*;


  class Pair{
    TreeNode node;
    int col;

      public Pair(TreeNode node, int col) {
          this.node = node;
          this.col = col;
      }
  }
 public class TopView {
      static List<Integer> topView(TreeNode root){
          if(root == null) return new ArrayList<>();
          List<Integer> ans = new ArrayList<>();
          Map<Integer, Integer> map = new TreeMap<>();
          Queue<Pair> queue = new ArrayDeque<>();
          queue.offer(new Pair(root, 0));
          while (!queue.isEmpty()){
              Pair p = queue.poll();
              if(!map.containsKey(p.col)) map.put(p.col, p.node.val);
              //map.put(p.col, p.node.data); for bottom view

              if (p.node.left != null) queue.offer(new Pair(p.node.left, p.col - 1));
              if(p.node.right != null) queue.offer(new Pair(p.node.right, p.col + 1));
          }
          return new ArrayList<>(map.values());
      }
}
