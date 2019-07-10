public static void main(String[] args) {
		//调用zbsz()获取数组
		int[] r = zbsz(33);
		int[] b =zbsz(16);
		System.out.println(Arrays.toString(r));
		System.out.println(Arrays.toString(b));
		//从r数组选择6个号码。存入red数组
		int [] red = selectRed(r);
		//从b数组选择1个号码，存入blue数组
		int [] blue = selectblue(b);
		System.out.println("红球："+Arrays.toString(red));
		System.out.println("蓝球："+Arrays.toString(blue));
	}

	private static int[] selectblue(int[] r) {

		int j =new Random().nextInt(16);
		int t =r[0];
		r[0]=r[j];
		r[j]=t;


		return Arrays.copyOf(r, 1);
	}

	private static int[] selectRed(int[] r) {

		for (int i = 0; i < 6; i++) {
			//随机下标j,范围(i,33]
			//可以表示成 i + [0,33-i]
			int j =i+new Random().nextInt(33-i);
			//i和j交换
			int t =r[i];
			r[i]=r[j];
			r[j]=t;

		}
		return Arrays.copyOf(r, 6);
		//截取前面6个位置，生成新的数组并返回
	}

	private static int[] zbsz(int n) {
		int[] arr = new int[n];//新建int[]数组，长度n
		for (int i = 0; i < arr.length; i++) {//遍历数组
			arr[i]=i+1;//填入1到n
		}
		return arr;//返回数组


	}
