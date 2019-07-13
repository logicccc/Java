public class BubbleSort {	 
	  public static void main(String[] args) {
	          tBubble();
	  }	 
	  public static void tBubble() {
	     //练习冒泡排序
	     int[] a = {20,60,24,16,40};	    
	     for (int i = 0; i < a.length-1; i++) {
	        //外层for循环控制比了几轮	   
	        for (int j = 0; j < a.length-1-i; j++) {
	         //里层的for循环控制每一轮比较的次数
	          if(a[j] > a[j+1]) {//满足前一个数大于后一个数
	             //完成交换两个数字
	             int c = a[j];
	             a[j] = a[j+1];
	             a[j+1] = c;
	          }
	        }	      
	     }
	     System.out.println(Arrays.toString(a));
	  }
	}
