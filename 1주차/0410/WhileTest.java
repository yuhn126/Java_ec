class WhileTest 
{
	public static void main(String[] args) 
	{
		//while(){
		//	System.out.println("�ȳ�");
		//}
		
		int i = 1;
		int sum = 0;

		//boolean flag = true;

		//while(flag){
		//	sum = sum + i;
		//	if(i == 10)
		//		flag = false;
		//	i++;
		//}


		while(i<=10){
			sum = sum + i;
			i++;
		}

		System.out.println(sum);
	}
}
