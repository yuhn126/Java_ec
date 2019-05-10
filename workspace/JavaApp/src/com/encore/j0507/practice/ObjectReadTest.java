package com.encore.j0507.practice;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Vector;

public class ObjectReadTest {
	public static void main(String[] args) throws Exception{
		Product p = new Product();
		FileInputStream fis = new FileInputStream("Product.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		@SuppressWarnings("unchecked")
		Vector<Product> v = (Vector<Product>)ois.readObject();
		p = v.get(0);
		System.out.println(p.name);
		System.out.println(p.getName());
				
	}
}
