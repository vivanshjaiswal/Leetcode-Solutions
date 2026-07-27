class Solution {
    void helper(int [] candidates, int target,int index,List<Integer>curr_arr,List<List<Integer>>res){
        if(target==0){
            res.add(new ArrayList<>(curr_arr));
            return;
        }
        if(index>=candidates.length) return ;
        for(int i=index;i<candidates.length;i++){
            if (i > index && candidates[i] == candidates[i - 1]) continue; // skip duplicates

            if (candidates[i] > target) break;
            curr_arr.add(candidates[i]);
            helper(candidates,target-candidates[i],i+1,curr_arr,res);
            curr_arr.remove(curr_arr.size()-1);
        }
    

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         Arrays.sort(candidates);
         List<List<Integer>>ans=new ArrayList<>();
         List<Integer>curr_arr=new ArrayList<>();
         helper(candidates,target,0,curr_arr,ans);

        return ans;
    }
}