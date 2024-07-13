public class CheckBST {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.left = new Node(6);
        root.right.right = new Node(8);
        root.left.left.right = new Node(2);


        System.out.println(isBST(root));
    }

    public static boolean isBST(Node node) {
        return isBS_rec(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBS_rec(Node node, int min, int max) {
        if (node == null)
            return true;

        if (node.data <= min || node.data >= max)
            return false;

        return isBS_rec(node.left, min, node.data) && isBS_rec(node.right, node.data, max);
    }
}
