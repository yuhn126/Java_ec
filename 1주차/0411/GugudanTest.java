class GugudanTest 
{
	public static void main(String[] args) throws Exception
	{
		System.out.print("출력할 단 입력 : ");
		int i = System.in.read()-48;	//입력시점
		
		System.out.println( "<" + i + "단>" );

		for (int j = 1; j<10 ; j++ ){
			System.out.println( i + "*" + j + "=" + i*j );
		}
	}
}
