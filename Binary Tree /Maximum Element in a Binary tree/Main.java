class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Main
{
    public static int findMax(TreeNode root)
    {
        if(root == null ){
            return -1;
        }
       int leftmax = findMax(root.left);
       int rightmax = findMax(root.right);
       
       return Math.max(root.val,Math.max(leftmax,rightmax));
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		int maxElement = findMax(root);
		System.out.println("maximum element in the binary tree:" + maxElement);
		}
}
