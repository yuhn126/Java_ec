
class Abc{
	int su;			//�������(�ʵ�) - ���� �޼ҵ尡 ������ �����͸� ǥ��, �⺻���� ���� O
					//�⺻�� ==> ���� : 0, �Ǽ� : 0.0, �� : false, Ŭ���� : null

	Abc(){
		System.out.println("Abc�⺻������");
	}

	Abc(String name){
		System.out.println("Abc�����ε�������");
	}

	void hello(){
		int min;	//�������� - ���� �޼ҵ忡���� ����� �����͸� ǥ��, �⺻���� ���� X
		System.out.println("���ݸ��ȳ�~!" + su);
	}

}

class ConstructorTest 
{
	public static void main(String[] args) 
	{
		Abc a = new             Abc("ȫ�浿");
		//		1.�޸��Ҵ�		2.������ȣ��
		a.hello();
	}
}
