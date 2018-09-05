package com.files.handle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData_Txt {

	public static void main(String[] args) throws IOException {
		
		String flPath = "C:\\Users\\envy\\Desktop\\IbmManyatha\\Data\\Demo.txt";
		FileWriter fr = new FileWriter(flPath,true); //true will append data
		BufferedWriter br = new BufferedWriter(fr);
		
		br.write("data1");
		br.newLine();
		br.write("data2");
		br.newLine();
		br.write("data3");
		br.newLine();
		br.write("data4");
		
		br.close();fr.close();
	}

}
