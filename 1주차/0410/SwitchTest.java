class SwitchTest
{
	public static void main(String[] args){
		
		int su=5;

		switch(su){
			case 1:
				System.out.println("안녕");
				break;
			case 2:
				System.out.println("신짜오");
				break;
			case 3:
	    		System.out.println("Hello");
				break;
			default :	//일치하는 case값이 없을때 실행할 문장을 표현
				System.out.println("감사합니다~!");
		}
	}
}