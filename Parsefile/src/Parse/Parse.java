package Parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Parse {
	public static int i = 0;
	int timeStamp = 0;
	public static String COMMA_DELIMITER = ",";

	public static void main(String[] args) {

		List<List<String>> records = new ArrayList<>();								//listan skapas

		try (Scanner scanner = new Scanner(new File("sample.csv"), "UTF-8");) {     //hämtar csv fil
			while (scanner.hasNextLine()) {

				records.add(getRecordFromLine(scanner.nextLine()));					//Hämtar getrecordfromlinen och addar den till records
			}
			records.remove(0);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	
		List<String> Alist = new ArrayList<String>();  								//skapar listan igen

		for (List<String> b : records) {
		}

		for (int i = 0; i < records.size(); i++) {
			List<String> Value = records.get(i);

			if (Value.get(1).toLowerCase().contains("a")) {						//kollar igenom kolumen 1 inte 0 efter namn med a
				Alist.add(Value.get(1));
			}
			if (Value.get(2).toLowerCase().contains("a")) {						////kollar igenom kolumen 2
				Alist.add(Value.get(2));
			}
		}
		System.out.println("There is "+Alist.size()+" names with a");			//skriver ut lista med alla namn med a i.
	
		int timeStamp = 0;
		List<Integer> indexes = new ArrayList<>(); 								//hämtar lista, ger namn indexes

		for (int i = 0; i < records.size(); i++) {								//i=0 och kollar igenom listan och öka med 1. 
			List<String> checkline = records.get(i);							//kollar igenom listan igen som får namnet checkline
			for (List<String> line : records) {									//kollar igenom listan igen och ger namnet line
				if ((!line.equals(checkline)) && (line.get(timeStamp).equals(checkline.get(timeStamp)))) {//om listorna inte är lika 
					indexes.add(i);				//kollar listorna med kolumerna
				}
			}
		}

		System.out.println("This people have the same timestamp");
		for (Integer i : indexes) {
		//	System.out.println(records.get(i));
			System.out.println(records.get(i).get(1));				//kollar igenom listan o skriver ut första columen
			System.out.println(records.get(i).get(2));
		}
		System.out.println("There is "+i+" that working with andrid apps.");
	}

	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<String>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(COMMA_DELIMITER);				// för att få kolummerna istället för strängarna
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());//scannar hela texten och addar det till values
			}
			if (values.get(6).contains("Android App")) {				//hämtar kolumn 6 o räknar strängen"Android App"
				i++;												//plussar 1 "Android App" för varje sträng
				i++;												//plussar 1 "Android App" för varje sträng
			}
		}
		
		return values;
	}
}