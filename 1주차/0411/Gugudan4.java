class Gugudan4 
{
	public static void main(String[] args) throws Exception
	{
		System.out.print("시작단? ");
		int dan1 = System.in.read()-48;
		System.in.read();
		System.in.read();

		System.out.print("끝단? ");
		int dan2 = System.in.read()-48;

		System.out.println();

		for(int i = dan1; i<=dan2; i++){
			System.out.println( "<" + i + "단>");
			for(int j = 1; j<10; j++){
				System.out.println( i + "*" + j + "=" + i*j);
			}
			System.out.println();
		}
	}
}
