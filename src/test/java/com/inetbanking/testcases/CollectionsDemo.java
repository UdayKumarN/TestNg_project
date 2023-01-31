package com.inetbanking.testcases;

import java.io.IOException;
import java.util.Arrays;

import com.inetbanking.utilities.XLUtils;

public class CollectionsDemo {
	public static void main(String[] args) throws IOException {
		String[][] output_data = get_data();
		System.out.println(Arrays.toString(output_data));
		for (String s[]: output_data) {
			//System.out.println(s.getClass().getName()+'@'+Integer.toHexString());
			System.out.println(s.getClass().getName() + "@" + s.hashCode());	
			}
//		List<String> listOfString = Stream.of(output_data)
//				  .map(Object::toString)
//				  .collect(Collectors.toList());
//		System.out.println(listOfString);
		}
		
	
				
		public static  String[][] get_data() throws IOException {
		String path = System.getProperty(("user.dir"))+"/src/test/java/com/inetbanking/testdata/TD.xlsx";
		System.out.println(path);
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		System.out.println(rowCount);
		int colno=XLUtils.getCellCount(path, "Sheet1", 1);
		System.out.println(colno);
		String[][] data=  new String[rowCount][colno];
		//LinkedList data = new LinkedList();
		
		for (int i=1;i<=rowCount;i++) {
			for(int j=0;j<colno;j++) {
				 data[i-1][j]= XLUtils.getCellData(path, "Sheet1", rowCount, colno);
				 if (data == null) {
					 System.out.println("data empty");
					 }
				 
			}
			
		}
		return data;
		/*
		Iterator<String> itr= data.iterator();
		
		while (itr.hasNext())                 
		{  
		System.out.println(itr.next());  
		System.out.println(data);
		
	}*/

}
}
