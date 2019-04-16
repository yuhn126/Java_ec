class DoWhileMission2 
{
	public static void main(String[] args) throws Exception
	{
		int i = 0;
		int sum = 0;

		do{
			System.out.println("<<메뉴>>");
			System.out.println("1.검색 2.증가 3.감소 4.종료");
			System.out.print("번호==> ");


			i = System.in.read() -48;
			System.in.read();
			System.in.read();

			switch(i){
				case 1:
					System.out.println("#검색결과 : " + sum);
					System.out.println();
					continue;
				case 2:
					sum += 1;
					System.out.println("# 1 증가하였습니다.");
					System.out.println();
					continue;
				case 3:
					sum -= 1;
					System.out.println("# 1 감소하였습니다.");
					System.out.println();
					continue;
				case 4:
					System.out.println("프로그램을 종료합니다.");
					break;
				default:
					System.out.println("다시 입력해주세요.");
					System.out.println();
					continue;
			}
			if (i == 4)
				break;
		}while(true);
	}
}
