import java.util.Arrays;

/*
 * Given an array of n integers nums and a target, 
 * the number of index triplets i, j, k with 0 <= i < j < k < n 
 * that satisfy the condition nums[i] + nums[j] + nums[k] < target
*/

public class ThreeSumSmaller {
public static void main(String[] args) {
	int [] nums = {0, 2,1,3,5, 4 };
	int res = solution(nums, 64);
	System.out.println(res);
}

public static int solution(int nums[], int target) {
	int res = 0;
	if(nums.length < 3) return 0;
	Arrays.sort(nums);
	
	for(int i = 0; i< nums.length; i++) {
		int left = i+1; int right = nums.length - 1;
		if(nums[i] < target)
			while(left < right) {
				if(nums[left]+ nums[right]+nums[i] < target) {
					res++;
					right--;
				}
				else {
					right--;
				}
			}
	}
	
	
	return res;
}
}
