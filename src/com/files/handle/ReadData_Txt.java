package com.files.handle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadData_Txt {

	public static void main(String[] args) throws IOException {
		
		String flPath = "C:\\Users\\envy\\Desktop\\IbmManyatha\\Data\\Demo.txt";
		FileReader fr = new FileReader(flPath);
		BufferedReader br = new BufferedReader(fr);
		
		String str = br.readLine();
		while(str!=null) {
		
			System.out.println(str);
			str = br.readLine();
		}
		br.close();
		fr.close();

	}

}
