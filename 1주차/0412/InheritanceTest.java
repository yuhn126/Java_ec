//�����Ϸ��� import java.lang.*; �߰�

class Parent{
	int i = 11;

	void hello(){
		System.out.println("�ȳ�~!!");
	}

	void hello(String name){//-----> �����ε��޼ҵ�(�޼ҵ�� ���� ������ ���� �Ǵ� �ڷ����� �ٸ���)
		System.out.println("�ȳ�," + name);
	}

	void hello(int age){ // �����ε� �޼ҵ�
		System.out.println("�ȳ�," + age);
	}

	void print(){
		System.out.println("�θ�����Ʈ!");
	}

}

class Child extends Parent{
			//is a      => �ڽ��� �θ��!!
			//          => �ڽ�Ŭ������ �θ�Ŭ������ ����ȯ�� �����ϴ�!
	int j=22;

	void goodBye(){
		System.out.println("�ȳ���������~!");
	}
	void print(){//------> �������̵��޼ҵ�(������ �޼ҵ�)
		System.out.println("�ڽ�����Ʈ");
	}
}

class InheritanceTest{
	public static void main(String[] args) {
		Child c = new Child();		//�޸�: O P C
			//�ڽ��� �ڿ�
		System.out.println("J = " + c.j);
		c. goodBye();
		c. print();
		
		//�θ��� �ڿ�
		c.hello();
		//c.abc();		//���� : Child, Parent, ObjectŬ������ �������� �ʱ� ������ ����!
		c.toString();   //������ �� �Ǵ� ����? Object Ŭ������ toString()�޼ҵ尡 ���ǵǾ��� ����


		System.out.println("==========================");
		Parent p = new Parent();
		//�ڽ��� �ڿ�
		p.hello();
		p.print();

		//�ڽ��� �ڿ�
		//p.goodBye(); //�����߻�
		//�⺻ : �θ���������(p)�� ���� �ڽ� ���� �Ұ���!

		//�θ�			 �ڽ�
		Parent p2 = new Child();	// �޸��Ҵ� : O  P  C
		//----     -------------
		//����      ��ȯ�������� ����?

		p2.hello();
		p2.print();		//�⺻��Ģ : �θ����� ���� �ڽ� ȣ�� �Ұ�!!
						//����   : �������̵� �޼ҵ�� ȣ�� ����!!
						//		==> ��Ȯ��
						//		==> �������̵� �޼ҵ尡 �����Ѵٸ� �θ��� �޼ҵ�� ����ǰ�
						//          �ڽ��� �޼ҵ�� ��ü�� �ȴ�.
	}
}
