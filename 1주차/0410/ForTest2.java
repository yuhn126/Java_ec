class ForTest2 
{
	public static void main(String[] args) 
	{
		System.out.println("����1)");
		for(int i=1; i<6; i++){
			System.out.println(i);
		}

		System.out.println("����2)");
		for(int i=1; i<6; i++){
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println("����3)");
		for(int i=5; i>0; i--){
			System.out.print(i + " ");
		}
		System.out.println();
		
		System.out.println("����4)");
		for(int i=3; i<=12; i+=3){
			System.out.print(i + " ");
		}
		System.out.println();

		System.out.println( "����5)");
		System.out.print("[");
		for(int i=5; i<=20; i+=5){
			//if(i < 20){
			//	System.out.print(i + ", ");
			//}else{
			//	System.out.print(i + "]");

			System.out.print(i);
			if(i < 20){
				System.out.print(", ");
			}
		} 
		System.out.print("]");
	}
}
