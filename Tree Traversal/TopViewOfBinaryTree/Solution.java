//GFG Practice

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    
    static class Info{
        Node node;
        int hd;
        
        public Info(Node node, int hd){
            this.hd = hd;
            this.node = node;
        }
    }
    
    
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        
        HashMap<Integer,Node> map = new HashMap<>();
        Queue<Info> q = new LinkedList<>();
        
        int min = 0, max = 0;
        q.add(new Info(root,0));
        q.add(null);
        
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd,curr.node);
                }
                if(curr.node.left!=null){
                    q.add(new Info(curr.node.left,curr.hd-1));
                    min = Math.min(min,curr.hd-1);
                }
                
                if(curr.node.right!=null){
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max,curr.hd+1);
                }
            }
        }
        
        for(int i=min; i<=max; i++){
            ans.add(map.get(i).data);
        }
        return ans;
        
    }
}
