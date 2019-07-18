
public class test {
	public static void main(String[] args) {
		String str = "Content-Disposition: form-data; name=\"myfile\"; filename=\"시연.txt\"";
		// 문제) 화면에 '애국가.txt'를 출력하시오.
		
		int startIdx = str.lastIndexOf("=") + 2;
		int endIdx = str.length() - 1;
		
		System.out.println(str.substring(startIdx,endIdx));
	}
}
