class Gugudan2 
{
	public static void main(String[] args) 
	{
		// 다중 for문을 사용하여 3단부터 5단까지 출력하기!
		for(int i = 3; i<=5; i++){
			System.out.println( "<" + i + "단>");
			for(int j = 1; j<10; j++){
				System.out.println( i + "*" + j + "=" + i*j);
			}
			System.out.println();
		}
	}
}
