package ui;
import java.io.IOException;

import model.*;

public class Main {
	
	private Control control;
	
	public Main () throws IOException {
		control = new Control();
	}
	public static void main (String[] args) throws IOException {
		Main main = new Main();
		main.timePrinter();
	}
	
	public void timePrinter () throws IOException {
		long time = control.initiate();
		System.out.println(String.valueOf(time));
	}
}
