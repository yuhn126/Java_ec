package com.encore.j0507.practice;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class ObjectWriteTest {
	public static void main (String[] args) throws Exception {
		Vector<Product> v = new Vector<>();
		
		FileOutputStream fos = new FileOutputStream("Product.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		Product p1 = new Product();
			p1.setName("초코우유");
			p1.price = 1200;
			p1.stock = 10;
		v.add(p1);
		
		oos.writeObject(v);
		
		oos.close();
		fos.close();
		
		System.out.println("객체쓰기 성공");
	}
}
