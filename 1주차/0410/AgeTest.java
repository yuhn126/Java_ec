class AgeTest
{
	public static void main(String[] args) 
	{
		int age = 40;
		
		if(age<10 || age>39){
			System.out.println("범위 밖의 나이입니다.");
		}else if(age < 20){
			System.out.println("10대 입니다.");
		}else if(age < 30 ){
			System.out.println("20대 입니다.");
		}else{
			System.out.println("30대 입니다.");
		}
	}
}
