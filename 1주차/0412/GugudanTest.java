class GugudanTest
{
	public static void main(String[] args) 
	{
		for(int j = 1; j<10 ; j++){	   // �ݺ��� : for - ��Ģ���� ���� ǥ��, �ٱ� for�� : ����(����)
									   // ���ϴ� �� 1~9
			for(int i = 2; i<10; i++){ // ���� for�� : ���� ����Ǵ� ��, �ܼ� : 2~9
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