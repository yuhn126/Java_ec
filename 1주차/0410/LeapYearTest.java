class LeapYearTest 
{
	public static void main(String[] args) 
	{
		int year = 2019;

		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			System.out.println(year + "년은 윤년입니다.");
		}else{
			System.out.println(year + "년은 평년입니다.");
		}

		System.out.println();

		if(!((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)){
			System.out.println(year + "년은 평년입니다.");
		}else{
			System.out.println(year + "년은 윤년입니다.");
		}
		// ! : not연산자, 부정연산자
		// ! boolean데이터

		// !true = false
		// !false = true


	}
}
