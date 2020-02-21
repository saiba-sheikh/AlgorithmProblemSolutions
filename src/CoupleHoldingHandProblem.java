/*
 * 
 N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).

The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.

Example 1:

Input: row = [0, 2, 1, 3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
Example 2:

Input: row = [3, 2, 0, 1]
Output: 0
Explanation: All couples are already seated side by side.
Note:

len(row) is even and in the range of [4, 60].
row is guaranteed to be a permutation of 0...len(row)-1.
*
*/
class CoupleHoldingHandProblem {
	public static void main(String[] args) {
		CoupleHoldingHandProblem s = new CoupleHoldingHandProblem();
		int[] row = {0,2,1,3};
		int swapsRequired = s.minSwapsCouples(row);
		System.out.println(swapsRequired);
		System.out.println("Post Swap: ");
		s.printArray(row);
	}
	public int minSwapsCouples(int[] row) {
		int count = 0;
		for(int i =0; i< row.length;){
			if(row[i]%2 == 0){
				if(row.length > i+1 && row[i] +1 == row[i+1]){
					i +=2;
					continue;
				}
				else{
					count += couple(row, 1, i);
				}
			}else{
				if(row.length > i+1 && row[i] - 1 == row[i+1]){
					i+=2;
					continue;
				}else{
					count += couple(row, -1, i);
				}
			}
			i+=2;
		}

		return count;

	}
	private int couple(int[] row, int direction, int currentPosition) {
		if(row.length > currentPosition + direction){
			int pos = findPosition(row[currentPosition] + direction, row);
			swap(currentPosition+1, pos, row);
			return 1;
		}
		return 0;
	}
	private int findPosition(int num , int[] row){
		for(int i=0;i< row.length; i++){
			if(row[i] == num)
				return i;
		}
		return -1;
	}
	private void swap(int i1, int i2, int[] arr){
		int temp = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = temp;
	}
	private void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i +" ");
		}
		System.out.println();
	}
}