package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Control {
	public static final String INPUT_PATH = "data\\in_turing.txt";
	public static final String OUTPUT_PATH = "data\\output.txt";
	private BufferedReader br;
	private BufferedWriter bw;
	private Turing turing;

	public Control () throws IOException {
		br = new BufferedReader (new FileReader(new File(Control.INPUT_PATH)));
		bw = new BufferedWriter (new FileWriter(new File(Control.OUTPUT_PATH)));
		turing = new Turing();
	}
	
	public long initiate() throws IOException {
		String instructions = br.readLine(); 		  			
		long beginning = System.currentTimeMillis();  
		while (instructions != null) {	//Start: Reads the file lines 
			int pos = 0;
			while (pos < instructions.length()) {				//Reads chars			
				char head = instructions.charAt(pos);
				switch (head) {
				case '0':			
					pos = operationDecision(instructions, pos,'0');
					break;
					
				case '1':
					pos = operationDecision(instructions, pos,'1');
					break;
					
				case '2':
					pos = operationDecision(instructions, pos,'2');
					break;
				}
			} //All chars have been read
			instructions = br.readLine();
			turing = new Turing();
		} //All lines have been read
		br.close();
		bw.close();
		long time = System.currentTimeMillis() - beginning;
		return time;
	}
	
	public int operationDecision (String instructions, int pos, char head) throws IOException {
		++pos;
		char operation = instructions.charAt(pos);
		switch (operation) {
		//Read
		case '0': 
			char output = turing.readCell(head);
			bw.write(output);
			bw.newLine();	
		
			break;
			
		//Add
		case '1':
			char letter = instructions.charAt(++pos);
			turing.addCell(letter, head);
			break;
			
		//Remove
		case '2':
			turing.removeCell(head);
			break;
		}
		return ++pos;
	}
}
