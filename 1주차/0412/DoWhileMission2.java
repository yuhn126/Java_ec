class DoWhileMission2 
{
	public static void main(String[] args) throws Exception
	{
		int i = 0;
		int sum = 0;

		do{
			System.out.println("<<�޴�>>");
			System.out.println("1.�˻� 2.���� 3.���� 4.����");
			System.out.print("��ȣ==> ");


			i = System.in.read() -48;
			System.in.read();
			System.in.read();

			switch(i){
				case 1:
					System.out.println("#�˻���� : " + sum);
					System.out.println();
					continue;
				case 2:
					sum += 1;
					System.out.println("# 1 �����Ͽ����ϴ�.");
					System.out.println();
					continue;
				case 3:
					sum -= 1;
					System.out.println("# 1 �����Ͽ����ϴ�.");
					System.out.println();
					continue;
				case 4:
					System.out.println("���α׷��� �����մϴ�.");
					break;
				default:
					System.out.println("�ٽ� �Է����ּ���.");
					System.out.println();
					continue;
			}
			if (i == 4)
				break;
		}while(true);
	}
}
