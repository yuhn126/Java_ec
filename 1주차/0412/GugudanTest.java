class GugudanTest
{
	public static void main(String[] args) 
	{
		for(int j = 1; j<10 ; j++){	   // 반복문 : for - 규칙적인 수를 표현, 바깥 for문 : 기준(고정)
									   // 곱하는 수 1~9
			for(int i = 2; i<10; i++){ // 안쪽 for문 : 자주 변경되는 수, 단수 : 2~9
				if(i*j < 10){
					System.out.print(i + "*" + j + "=" + i*j + "   " );
				}else{
					System.out.print(i + "*" + j + "=" + i*j + "  ");
				}
			}
			System.out.println();
		}
	}
}