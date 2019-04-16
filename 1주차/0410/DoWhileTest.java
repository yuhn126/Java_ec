class DoWhileTest 
{
	public static void main(String[] args) 
	{
		//문제 ) "Hello World!"를 화면에 3번 출력 (do while문 사용)
		int i=0;

		do{
			System.out.println("Hello World!");
			i++;
		}while(i<3);

		System.out.println("===================");

		boolean flag = true;

		int count = 1;
		do{
			System.out.println("Hello World!");
			if(count++ == 3){
				break;
			}
		}while(flag);

		System.out.println("===================");

		// 문제) 1부터 10까지의 합을 출력하시오. (do~while문을 사용)

		int su = 1, sum = 0;

		do{

			sum += su;
			if(su<10){
				su++;
				continue;
			}
			flag = false;
		}while(flag);

		System.out.println(sum);

		System.out.println("===================");

		int i2 = 1, sum2 = 0;
		do{
			sum2 += i2;
			i2++;
		}while(i2<=10);

		System.out.println(sum2);
	}
}
