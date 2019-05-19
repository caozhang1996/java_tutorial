package timu;

public class TestTiMu1 {
	public static void main(String[] args) {
		StringAndArray sAnda = new StringAndArray();
//		System.out.println(d.find1(1, new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
//		System.out.println(d.find2(3, new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
		
		System.out.println("s2是否由s1翻转而成?: " + sAnda.checkReverseEqual("waterbottle", "elttobretaw"));
		System.out.println("s2是否由s1移位而成?: " + sAnda.checkShiftEqual("waterbottle", "elttobretaw"));
		System.out.println("替换字符串: " + sAnda.replaceString2("Hello World. Welcome to China"));
		System.out.println("判断字符互异: " + sAnda.compareChar("egdhs"));
	}
}

class StringAndArray{
	/*
	 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
	 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 * */
	public String replaceString1(String str) {      //第一种写法，开辟新空间,使用StringBuffer类，可以对字符串内容进行修改（增加，替换等）
		StringBuffer sBuffer = new StringBuffer();
		char[] charArray = str.toCharArray();
		for(int i = 0; i < charArray.length; i++) {
			if(charArray[i] == ' ') {
				sBuffer.append("%20");
			}else {
				sBuffer.append(charArray[i]);
			}
		}
		return sBuffer.toString();
	}
	
	public String replaceString2(String str) {     //第二种写法，不开辟新空间
		if (str == null || str.length() < 0) {
			return str;
		}
		char[] charArray = str.toCharArray();
		int originalLength = charArray.length;
		int numberOfBlank = 0;
		for(int i = 0; i < originalLength; i++) {
			if(charArray[i] == ' ') {
				numberOfBlank++; 
			}
		}
		int newLength = originalLength + (2 * numberOfBlank);
		char[] newCharArray = new char[newLength];             //构造新的字符数组
		int indexOfOriginal = 0;
		int indexOfNew = 0;
		while(indexOfOriginal < originalLength) {
			if(charArray[indexOfOriginal] == ' ') {
				newCharArray[indexOfNew++] = '%';
				newCharArray[indexOfNew++] = '2';
				newCharArray[indexOfNew++] = '0';
				indexOfOriginal++;                 //保持两个index的加加操作同步
			}else {
				newCharArray[indexOfNew++] = charArray[indexOfOriginal++];
			}
		}
		String strAfter = String.valueOf(newCharArray);
		return strAfter;
	} 
	
	public String replaceString3(String str) {     //直接调用API，不推荐
		if (str == null || str.length() < 0) {
			return str;
		}
		return str.replaceAll(" ", "%20"); 
	} 
	
	/*
	 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
	 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * */
	public boolean find1(int target, int[][] array) {    //利用二分查找
		for(int i = 0; i < array.length; i++) {
			int low = 0;
			int height = array[i].length - 1;
			while(low <= height) {
				int mid = (low + height) / 2;
				if(target > array[i][mid]) {
					low += mid;
				}else if(target < array[i][mid]){
					height -= mid;
				}else {
					return true;
				} 
			}
		} 
		return false;
	}
	
	public boolean find2(int target, int[][] array) {     //第二中方法，暴力遍历
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(array[i][j] == target) {
					return true;
				}
			}
		}
		return false; 
	}
	
	public boolean find3(int target, int[][] array) {  //第三种方法，最佳方法
		return false; 
	}
	
	//判断s2是否是由s1翻转而来
	public boolean checkReverseEqual(String s1, String s2) {
        // write code here
        char[] s1Array = s1.toCharArray();
        for(int i = 0; i < s1Array.length / 2; i++){
            char temp = s1Array[i];
            s1Array[i] = s1Array[s1Array.length - 1 - i];
            s1Array[s1Array.length - 1 - i] = temp;
        }
        String s1After = String.valueOf(s1Array);
        if(s1After.equals(s2))     //这里不能写 == 注意:String类重写了Object类中的equals方法，比较的是String对象的内容是否是一样的
            return true;
        else
            return false;
    }
	/*
	 * 假定我们都知道非常高效的算法来检查一个单词是否为其他字符串的子串。请将这个算法编写成一个函数，给定两个字符串s1和s2，
	 * 请编写代码检查s2是否为s1旋转而成，要求只能调用一次检查子串的函数。(旋转即移位)
	 * 给定两个字符串s1,s2,请返回bool值代表s2是否由s1旋转而成。字符串中字符为英文字母和空格，区分大小写，字符串长度小于等于1000。
     * 测试样例：
     * "Hello world","worldhello "
     * 返回：false
     * "waterbottle","erbottlewat"
     * 返回：true
     * * */
	public boolean checkShiftEqual(String s1, String s2) {
		if(s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		else
			return (s1 + s1).contains(s2);
	}
	
	/*
	 * 请实现一个算法，确定一个字符串的所有字符是否全都不同。这里我们要求不允许使用额外的存储结构。
	 * 给定一个string str，请返回一个bool值,True代表所有字符全都不同，False代表存在相同的字符。
	 * 保证字符串中的字符为ASCII字符。字符串的长度小于等于3000。
	 * 测试样例:
	 * "aeiou"
	 * 返回True
	 * “BarackObama”
	 * 返回false
	 * */
	public boolean compareChar(String str) {
		char[] strArray = str.toCharArray();
		for(int i = 0; i < strArray.length - 1; i++) {
			int temp = i;
			for(int j = i + 1; j < strArray.length; j++) {
				if(strArray[i] == strArray[j]) {
					temp = j;
					break;
				}
			}
			if(temp != i)
				return false;
		}
		return true;
	}
}
