package com.encore.j0820.di;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputImpl implements FileOutput {

	@Override
	public void output(String str) {
		//실제 파일 출력
		try {
			FileWriter fw = new FileWriter("hello.txt");
			fw.write(str);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
