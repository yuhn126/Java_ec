import java.util.Calendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class JuminBunhoTest 
{
	public static void main(String[] args) throws Exception
	{
		// �ֹι�ȣ�� �Է¹޾� ȭ�鿡 ���̸� ����ϱ�! (readLine() �޼ҵ� ���)
		// "920306-1012345"
		// "080603-3012345"
		// ===> ��ü ���ڿ����� "92"�� �����ϱ� : String
		// ���� ����ϱ�?    2019 - (1990 + 92) + 1
		// �ڹ� ��¥ ���õ� Ŭ���� : Date, Calendar ---> java.util ��Ű��

		Calendar cal = Calendar.getInstance();
		//cal���� �ȿ� �� �ý����� ��� ��¥ ���� ������ �����
		//cal.get(����� �ϴ� ��������);

		int year = cal.get(Calendar.YEAR);
		//System.out.println("year : " + year);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�ֹι�ȣ�� ��Ȯ�� �Է��ϼ���('-'����) : ");
		String id = in.readLine();		//"921126-1012345"   "080603-3012345"
					//���ؽ�                0123456789
		String birthYear = id.substring(0,2);

		char ch = id.charAt(7);		//ch ---> '1' '2' '3' '4' ...

		int age;
		if( ch < '3' ){
			age = year - (1900 + Integer.parseInt(birthYear)) + 1;
		}else{
			age = year - (2000 + Integer.parseInt(birthYear)) + 1;
		}

		System.out.println("����� ���̴� : " + age);
	}
}
