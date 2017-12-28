import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MyFile {
	public static int percentile(int [] inputArray, double rank) {
		int arrayLength	=	inputArray.length;
		double rankCalc	=	Math.round((rank / 100) * arrayLength);
		int rankpos		=	0;
		for (int i = 1 ; i < inputArray.length; i++) {
			if(i  == rankCalc) {
				rankpos =  inputArray[i-1];
			}
		}
		return rankpos;
	}
	
	public static String dataCals(File inputInformation, int inputLine, String Calcreq, double perRank) throws IOException {
		Scanner scannner	=	new Scanner(inputInformation);
		inputLine	=	inputLine -1;	
		ArrayList<String> dataList	=	new ArrayList<String>();
			while(scannner.hasNext()) {
			String myString	=	scannner.nextLine();
			dataList.add(myString);
		}
			scannner.close();
			String initialString	=	dataList.get(inputLine);
			String [] FirstSplit	=	initialString.split(":");
			String [] SecondSplit	=	FirstSplit[1].split(",");
			int [] arrayOfvalues	=	new int[SecondSplit.length];
		
				for (int i = 0; i < arrayOfvalues.length; i++) {
					arrayOfvalues[i]	=	Integer.parseInt(SecondSplit[i]);
	}
			if(Calcreq == "min") {
				return String.valueOf(Arrays.stream(arrayOfvalues).min().getAsInt());	
			} else if(Calcreq == "max") {
				return String.valueOf(Arrays.stream(arrayOfvalues).max().getAsInt());
			} else if(Calcreq == "ave"){
				return String.valueOf(Arrays.stream(arrayOfvalues).average().getAsDouble());
			} else if (Calcreq == "sum") {
				return String.valueOf(Arrays.stream(arrayOfvalues).sum());
			} else if (Calcreq == "per"){
				return String.valueOf(percentile(arrayOfvalues, perRank));
			} else {
				return "";
			}
}
	
	public static void main(String[] args) throws IOException{
			
			File file	=	new File("/home/neil/eclipse-workspace/HyperionDev3/src/input.txt");
			String min	=	dataCals(file, 1, "min" , 0);
			String max	=	dataCals(file, 2, "max" , 0);
			String ave	=	dataCals(file, 3, "ave" , 0);
			String P90	=	dataCals(file, 4, "per" , 90);
			String sum	=	dataCals(file, 5, "sum", 0);
			String P70	=	dataCals(file, 6, "per" , 70);
			
			try {
				BufferedWriter fileOutPut	=	new BufferedWriter(new FileWriter("/home/neil/eclipse-workspace/HyperionDev3/src/output.txt"));
				fileOutPut.write("The​ ​ min​ ​ of​ ​ [1,​ ​ 2,​ ​ 3,​ ​ 5,​ ​ 6]​ ​ is "+min+"\n");
				fileOutPut.write("The​ ​ max​ ​ of​ ​ [1,​ ​ 2,​ ​ 3,​ ​ 5,​ ​ 6]​ ​ is "+max+"\n");
				fileOutPut.write("The​ ​ avg ​ of​ ​ [1,​ ​ 2,​ ​ 3,​ ​ 5,​ ​ 6]​ ​ is "+ave+"\n");
				fileOutPut.write("The​ ​ 90th​ ​ percentile​ ​ of​ ​ [1,2,3,4,5,6,7,8,9,10]​ is "+P90+"\n");
				fileOutPut.write("The​ ​ sum​ ​ of​ ​ [1,2,3,5,6]​ ​ is ​"+sum+"\n");
				fileOutPut.write("The​ ​ 70th​ ​ percentile​ ​ of​ ​ [1,2,3]​ ​ is​ ​"+P70);
				fileOutPut.close();
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			
	}		
}
