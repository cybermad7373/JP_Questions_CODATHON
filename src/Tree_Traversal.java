import java.util.*;

public class Tree_Traversal {
    public static class Node{
        int data ;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("pre order :");
        preorder(root);

        System.out.println("\n\npost order :");
        postorder(root);

        System.out.println("\n\nIn order :");
        inorder(root);

        System.out.println("\n\nLevel order :");
        LevelOrder(root);

    }

    public static void preorder(Node root)
    {
        if(root == null){
            return;
        }
        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root)
    {
        if(root == null){
            return;

        }
        System.out.print(root.data+ " ");
        postorder(root.right);
        postorder(root.left);
    }

    public static void inorder(Node root)
    {
        if(root == null){
            return;

        }
        inorder(root.left);
        System.out.print(root.data+ " ");
        inorder(root.right);

    }

    public static void LevelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root!=null){
            q.add(root);
        }else{
            System.out.println("Tree is Empty");
        }
        while(!q.isEmpty())
        {
            Node dummy = q.peek();
            System.out.print(dummy.data+" ");
            if(dummy.left!=null)
            {
                q.add(dummy.left);
            }
            if(dummy.right!=null)
            {
                q.add(dummy.right);
            }
            q.poll();

        }

    }

}