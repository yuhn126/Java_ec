class LeapYearTest 
{
	public static void main(String[] args) 
	{
		int year = 2019;

		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			System.out.println(year + "���� �����Դϴ�.");
		}else{
			System.out.println(year + "���� ����Դϴ�.");
		}

		System.out.println();

		if(!((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)){
			System.out.println(year + "���� ����Դϴ�.");
		}else{
			System.out.println(year + "���� �����Դϴ�.");
		}
		// ! : not������, ����������
		// ! boolean������

		// !true = false
		// !false = true


	}
}
