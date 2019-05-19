package timu;

/*
 * LeetCode上的题目
 */
public class TestLeetCode {
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] get = solution.twoSum(new int[] {2, 7, 11, 15, 20}, 22);
//		System.out.println(get[0] + " " + get[1]);
		
		System.out.println(solution.reverse(-123));
		
		System.out.println(solution.isPalindrome(14542));    //回文数
		
		System.out.println(solution.searchInsert(new int[] {2, 7, 11, 15, 20}, 12));   //二分法查找
		
		char[] digits = new char[] {'1', '2', '3'};
		Integer i = Integer.parseInt(String.valueOf(digits));
		System.out.println(i);
		
		int[] nums = new int[] {8, 12, 19, 2, 2, 1};
		Solution.selectSort(nums);
		for(int j= 0; j < nums.length; j++) {
			System.out.print(nums[j] + "\t");
		}
		
	}
	 
}

class Solution{
	/*
	 * 给定一个整数数组 nums 和一个目标值for(int i = 0; i < nums.length; i++) {
    		for(int j = 1; j < nums.length; j++) {
    			
    		}
    	} target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
	 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	 * 示例:
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9
	 * 所以返回 [0, 1]
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] record = new int[2]; 
		for(int i = 0; i < nums.length - 1; i++) {
			int temp = nums[i];
			for(int j = i + 1; j < nums.length; j++) {
				if((target - temp) == nums[j]) {				
					record[0] = i;
					record[1] = j;		
					break;
				}
			}
		}
		return record;
	}
	
	/*
	 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
	 * 示例 1:
	 * 输入: 123
	 * 输出: 321
	 * 
	 * 示例 2:
	 * 输入: -123
	 * 输出: -321
	 * 
	 * 示例 3:
	 * 输入: 120
	 * 输出: 21
	 * 
	 * 注意:假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
	 */
	public int reverse(int x) {
		char[] chars = Integer.toString(x).toCharArray();
		if(chars[0] == '-') {
			
		}
		return 0; 
	}
    
    /*
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 示例 1:
     * 输入: 121
     * 输出: true
     * 
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 
     * 示例 3:
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */
    public boolean isPalindrome(int x) {
    	char[] chars1 = Integer.toString(x).toCharArray();   //将整形数据转化为字符数组
    	char[] chars2 = Integer.toString(x).toCharArray();
    	int i = 0;  
    	int j = chars1.length - 1;
    	while(i < j) {
    		swap(chars1, i++, j--);
    	}
    	for(int k = 0; k < chars1.length; k++) {
    		if(chars1[k] != chars2[k])
    			return false;
    	}
    	return true;
    }
    public static void swap(char[] chars, int a, int b) {
    	char temp = chars[a];
    	chars[a] = chars[b];
    	chars[b] = temp;
    	
    }
    /*
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * 示例 1:
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * 注意这五个元素可为任意顺序。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeElement(int[] nums, int val) {
    	int count = 0;        //用来记录操作之后的数组长度
    	for(int i = 0; i < nums.length; i++) {
    		if(val != nums[i]) {
    			nums[count] = nums[i];     //双指针
    			count++;
    		}
    	}
    	return count;
    }
    
    /*
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。    !!!!注意:是排序数组
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeDuplicates(int[] nums) {   //双指针思路
        int index = 0;         //新数组的下标值
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] != nums[index]) {
        		index++;
        		nums[index] = nums[i];
        	}
        }
        return index + 1;
    }
    /*
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 
     * 示例 2:
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 
     * 示例 3:
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 
     * 示例 4:
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */
    public int searchInsert(int[] nums, int target) {    //二分法升级版
        if(nums == null || target < nums[0]){
            return 0;
        }
        if(target > nums[nums.length - 1]){
            return nums.length;
        }
        int low = 0;          //数组索引最小值
        int height = nums.length - 1;   //数组索引最大值 
        int mid = 0;
        while(low <= height){
            if(target == nums[mid]){
                return mid;
            }else if(target > nums[mid]){
                low = mid + 1;
                mid = (low + height + 1) / 2;
            }else{
                height = mid -1;
                mid = (low + height + 1) / 2;
            }
        }
        return mid;      
    }
    
    /*
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * 示例 1:
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 
     * 示例 2:
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     * 
     * 示例 3:
     * 输入: [9]
     * 输出: [1, 0]
     * 解释: 输入数组表示数字9。
     */
    public int[] plusOne(int[] digits) {
    	
    	return new int[2];
    }
    /*
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 
     * 示例:
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int[] tempArray = new int[m + n];
    	int i = 0;
    	int j = 0;
    	int index = 0;
    	while(i < m || j < n) {
    		if(index < m)
    			tempArray[index++] = nums1[i++];
    		else
    			tempArray[index++] = nums2[j++];
    	}
    	//将tempArray数组排序
    	for(int x = 0; x < tempArray.length - 1; x++){
    		int t = x;    //默认此处为最小值
            for(int y = x + 1; y < tempArray.length; y++){             
                if(tempArray[t] > tempArray[y]){
                	t = y;
                } 
            }  
            if(t != x) {
            	int temp = tempArray[t];
            	tempArray[t] = tempArray[x];
            	tempArray[x] = temp;
            }
        }
    }
    //冒泡排序
    public static void bubbleSort(int[] nums) {
    	for(int i = 0; i < nums.length - 1; i++) {
    		for(int j = 0; j < nums.length - 1 - i; j++) {
    			if(nums[j] > nums[j + 1]) {
    				int temp = nums[j];
    				nums[j] = nums[j + 1];
    				nums[j + 1] = temp;
    			}
    		}
    	}
    }
    //直接选择排序
    public static void selectSort(int[] nums) {
    	for(int i = 0; i < nums.length - 1; i++) {
    		int t = i;         //假设i处的值为最小
    		for(int j = i + 1; j < nums.length; j++) {
    			if(nums[t] > nums[j]) {
    				t = j;
    			}
    		}
    		if(t != i) {
    			int temp = nums[t];
    			nums[t] = nums[i];
    			nums[i] = temp;
    		}
    	}
    }
    
    /*
     * 实现 int sqrt(int x) 函数。计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * 示例 1:
     * 输入: 4
     * 输出: 2
     * 
     * 示例 2:
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842..., 
     * 由于返回类型是整数，小数部分将被舍去。
     */
    public int mySqrt(int x) {    //提示: 使用二分法
    	return 0;
    }
    
}