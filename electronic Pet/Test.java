public static void main(String[] args) {
		//选择猫狗
		System.out.println("--欢迎来到宠物调教中心--");
		System.out.println("1. 猫");
		System.out.println("2. 狗");
		System.out.println("3. 猪");
		System.out.println("4. 杰尼龟");
		System.out.println("选择：>");
		int c = new Scanner(System.in).nextInt();
		//起名字
		System.out.println("给宠物起个名字：");
		String n = new Scanner(System.in).nextLine();
		//付费
		System.out.println("付费：");
		int money = new Scanner(System.in).nextInt();
		//创建宠物实例
		if (money == 0) {//免费
			
			
			
			
			if (c==1) {//养猫
				Cat cat = new Cat(n); // 50，50不付费猫
				f(cat); //把猫传递到f()方法，执行养猫
			}else if(c==2){//养狗
				Dog dog = new Dog(n); //50，50中等狗
				f(dog); //把狗传递到f（）方法，执行养狗
			}else if(c==4){
				Squirtle squirtle = new Squirtle(n); //杰尼龟
				f(squirtle); //把squirtle传递到f（）方法，执行养squirtle
			}else{ //付费猪
				Pig pig = new Pig(n, 100, 100); //付费猫
				f(pig); //养宠物
			}
			
			
			
		}else {//付费用户
			if (c == 1) {//养猫
				Cat cat = new Cat(n, 100, 100); //付费猫
				f(cat); //养宠物
			}else if(c ==2 ) {//养狗
				Dog dog = new Dog(n, 100, 100);//付费狗
				f(dog);
			}else if (c==4) {
				Squirtle squirtle = new Squirtle(n, 100, 100);//付费杰尼龟
				f(squirtle);
			}else{ //付费猪
				Pig pig = new Pig(n, 100, 100); //付费猫
				f(pig); //养宠物
			}
		}
		
		
	}
	private static void f(Cat cat) {
		System.out.println("按回车执行");
		while (true) {
			new Scanner(System.in).nextLine();
			//0，2，3，4，5，
			int r = new Random().nextInt(6);
			switch(r) {
			case 0: cat.feed(); break;
			case 1: cat.play(); break;
			default: cat.punish(); break;
			}
		}
	}
	private static void f(Dog dog) {
		System.out.println("按回车执行");
		while (true) {
			new Scanner(System.in).nextLine();
			//0，1，2，3，4，5
			int r = new Random().nextInt(6);
			switch (r) {
			case 0: dog.feed(); break;
			case 1: dog.play(); break;
			default: dog.punish(); break;
			}
		}
	}
	
	private static void f(Pig pig) {
		System.out.println("按回车执行");
		while (true) {
			new Scanner(System.in).nextLine();
			//0，1，2，3，4，5
			int r = new Random().nextInt(6);
			switch (r) {
			case 0: pig.feed(); break;
			case 1: pig.play(); break;
			default: pig.punish(); break;
			}
		}
	}
	
	private static void f(Squirtle squirtle) {
		System.out.println("按回车执行");
		while (true) {
			new Scanner(System.in).nextLine();
			int r = new Random().nextInt(6);
			switch (r) {
			case 0: squirtle.feed(); break;
			case 1: squirtle.play(); break;
			default: squirtle.punish(); break;
			}
		}
	}
	
}
