class OperatorTest{
	int test;			//������� ��ġ�� ���� ���� ����!
	int trst2 = 300;	//������� ��ġ�� ����� �ʱ�ȭ�� ���ÿ� ����� �� ����!

	public static void main(String[] arg){
	//main() ������ class : �ڹ� ���ø����̼�(Java application)
	//���������� ������ �� �ִ� �ڹ� ���α׷�

		int su1;
		su1 = 40;
		int su2 = 30;
		
		System.out.println("<<su1�� su2�� ��Ģ����>>");
		// "���ڿ�1"+"���ڿ�2"		->		"���ڿ�1���ڿ�2"
		// "���ڿ�1" + 33			->		"���ڿ�33"
		// 55 + "���ڿ�"			->		"55���ڿ�"
		// 1+2+"�ȳ�"			->		"3�ȳ�"
		// "�ȳ�"+1+2			->		"�ȳ�12"
		
		System.out.println("su1 + su2 = " + (su1+su2));
		System.out.println("su1 - su2 = " + (su1-su2));
		System.out.println("su1 * su2 = " + (su1*su2));
		System.out.println("su1 / su2 = " + (su1/su2));
		System.out.println("su1 % su2 = " + (su1%su2));

		int su3 = 50;
		System.out.println("su3 = " + su3);
		su3++;
		System.out.println("���������� su3 = " + su3);
		++su3;
		System.out.println("���������� su3 = " + su3);

		System.out.println("�������� su3++ = " + su3++);
		System.out.println("�ٽ� su3 ��� = " + su3);

		System.out.println("�������� ++su3 = " + ++su3);
		System.out.println("�ٽ� su3 ��� = " + su3);

		System.out.println("==========�񱳿�����=========");

		int a=3, b=4;

		System.out.println(true);
		System.out.println(false);

		System.out.println("a<b : " + (a<b));
		System.out.println("a>b : " + (a>b));
		System.out.println("a==b : " + (a==b));
		System.out.println("a!=b : " + (a!=b));


	}
}