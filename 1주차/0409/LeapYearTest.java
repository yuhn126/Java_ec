class LeapYearTest 
{
	public static void main(String[] args) 
	{
		//int year = 2020;
		//System.out.println((year%4==0&&year%100!=0)||year%400==0);

		int year = 2019;
		boolean status1 = (year%4)==0;
		boolean status2 = year%100!=0;

		boolean status3 = year%400==0;

		boolean result = (status1 && status2)||status3;

		System.out.println("°á°ú°ª : "+ result);
	}
}
