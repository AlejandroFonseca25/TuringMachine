package model;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class TuringTest {

	private Turing turing;
	
	private void setup1() {
		turing = new Turing();
		turing.addCell('A', '0');
		turing.addCell('U', '2');
		turing.addCell('R', '2');
		turing.addCell('O', '2');
		turing.addCell('I', '2');
		turing.addCell('D', '2');
		turing.addCell('L', '2');
		turing.addCell('E', '2');
	}
	
	private void setup2() {
		turing = new Turing();
		turing.addCell('A', '0');
		turing.addCell('L', '2');
		turing.addCell('G', '2');
		turing.addCell('O', '2');
		turing.addCell('R', '2');
		turing.addCell('I', '2');
		turing.addCell('T', '2');
		turing.addCell('H', '2');
		turing.addCell('M', '2');
	}
	
	@Test
	public void addCellTest1() {
		turing = new Turing();
		turing.addCell('U', '0');
		boolean checker = (turing.getC0().getLetter() == 'U' && turing.getC1().getLetter() == 'U' && turing.getC2().getLetter() == 'U');
		assertTrue("addCell is not correctly adding cells at c0 when there's no previous elements.", checker);
		
		turing = new Turing();
		turing.addCell('M', '1');
		checker = (turing.getC0().getLetter() == 'M' && turing.getC1().getLetter() == 'M' && turing.getC2().getLetter() == 'M');
		assertTrue("addCell is not correctly adding cells at c1 when there's no previous elements.", checker);
		
		turing = new Turing();
		turing.addCell('L', '2');
		checker = (turing.getC0().getLetter() == 'L' && turing.getC1().getLetter() == 'L' && turing.getC2().getLetter() == 'L');
		assertTrue("addCell is not correctly adding cells at c2 when there's no previous elements.", checker);
	}
	
	@Test
	public void addCellTest2() {
		turing = new Turing();
		turing.addCell('C', '0');
		turing.addCell('P', '0');
		boolean checker = (turing.getC0().getLetter() == 'P' && turing.getC1().getLetter() == 'P' && turing.getC2().getLetter() == 'C');
		assertTrue("addCell is not correctly adding cells at c0 when there's 1 previous element.", checker);
		
		turing = new Turing();
		turing.addCell('S', '0');
		turing.addCell('D', '1');
		checker = (turing.getC0().getLetter() == 'D' && turing.getC1().getLetter() == 'D' && turing.getC2().getLetter() == 'S');
		assertTrue("addCell is not correctly adding cells at c1 when there's 1 previous element.", checker);
		
		turing = new Turing();
		turing.addCell('W', '0');
		turing.addCell('F', '2');
		checker = (turing.getC0().getLetter() == 'W' && turing.getC1().getLetter() == 'W' && turing.getC2().getLetter() == 'F');
		assertTrue("addCell is not correctly adding cells at c2 when there's 1 previous element.", checker);
	}
	
	@Test
	public void addCellTest3() {
		setup1();
		turing.addCell('S', '0');
		boolean checker = (turing.getC0().getLetter() == 'S' && turing.getC1().getLetter() == 'O' && turing.getC2().getLetter() == 'E');
		assertTrue("addCell is not correctly adding cells at c0 when there's an even number of previous elements.", checker);
		
		setup1();
		turing.addCell('A', '1');
		checker = (turing.getC0().getLetter() == 'A' && turing.getC1().getLetter() == 'A' && turing.getC2().getLetter() == 'E');
		assertTrue("addCell is not correctly adding cells at c1 when there's an even number of previous elements.", checker);
		
		setup1();
		turing.addCell('D', '2');
		checker = (turing.getC0().getLetter() == 'A' && turing.getC1().getLetter() == 'I' && turing.getC2().getLetter() == 'D');
		assertTrue("addCell is not correctly adding cells at c2 when there's an even number of previous elements.", checker);
	}
	
	@Test
	public void addCellTest4() {
		setup2();
		turing.addCell('N','0');
		boolean checker = (turing.getC0().getLetter() == 'N' && turing.getC1().getLetter() == 'O' && turing.getC2().getLetter() == 'M');
		assertTrue("addCell is not correctly adding cells at c0 when there's an odd number of previous elements.", checker);
		
		setup2();
		turing.addCell('B','1');
		checker = (turing.getC0().getLetter() == 'A' && turing.getC1().getLetter() == 'B' && turing.getC2().getLetter() == 'M');
		assertTrue("addCell is not correctly adding cells at c1 when there's an odd number of previous elements.", checker);
		
		setup2();
		turing.addCell('A','2');
		checker = (turing.getC0().getLetter() == 'A' && turing.getC1().getLetter() == 'R' && turing.getC2().getLetter() == 'A');
		assertTrue("addCell is not correctly adding cells at c2 when there's an odd number of previous elements.", checker);
	}
	
	@Test
	public void readCellTest1() {
		turing = new Turing();
		char letter = turing.readCell('0');
		assertTrue("readCell is not correctly reading the letter at c0 when there's no previous elements.", letter == '#');
		
		letter = turing.readCell('1');
		assertTrue("readCell is not correctly reading the letter at c1 when there's no previous elements.", letter == '#');
		
		letter = turing.readCell('2');
		assertTrue("readCell is not correctly reading the letter at c2 when there's no previous elements.", letter == '#');
	}
	
	@Test
	public void readCellTest2() {
		turing = new Turing();
		turing.addCell('F', '0');
		char letter = turing.readCell('0');
		assertTrue("readCell is not correctly reading the letter at c0 when there's 1 previous element.", letter == 'F');
		
		letter = turing.readCell('1');
		assertTrue("readCell is not correctly reading the letter at c1 when there's 1 previous element.", letter == 'F');
		
		letter = turing.readCell('2');
		assertTrue("readCell is not correctly reading the letter at c2 when there's 1 previous element.", letter == 'F');
	}
	
	@Test
	public void readCellTest3() {
		setup1();
		char letter = turing.readCell('0');
		assertTrue("readCell is not correctly reading the letter at c0 when there's an even number of previous elements.", letter == 'A');
		
		letter = turing.readCell('1');
		assertTrue("readCell is not correctly reading the letter at c1 when there's an even number of previous elements.", letter == 'O');
		
		letter = turing.readCell('2');
		assertTrue("readCell is not correctly reading the letter at c2 when there's an even number of previous elements.", letter == 'E');
	}
	
	@Test
	public void readCellTest4() {
		setup2();
		char letter = turing.readCell('0');
		assertTrue("readCell is not correctly reading the letter at c0 when there's an odd number of previous elements.", letter == 'A');
		
		letter = turing.readCell('1');
		assertTrue("readCell is not correctly reading the letter at c1 when there's an odd number of previous elements.", letter == 'R');
		
		letter = turing.readCell('2');
		assertTrue("readCell is not correctly reading the letter at c2 when there's an odd number of previous elements.", letter == 'M');
	}
	
	@Test
	public void removeCellTest1() {
		turing = new Turing();
		turing.removeCell('0');
		assertNull("removeCell is not correctly removing the element at c0 when there's no previous element.", turing.getC0());
		
		turing.removeCell('1');
		assertNull("removeCell is not correctly removing the element at c1 when there's no previous element.", turing.getC1());
		
		turing.removeCell('2');
		assertNull("removeCell is not correctly removing the element at c2 when there's no previous element.", turing.getC2());
	}
	
	@Test
	public void removeCellTest2() {
		turing = new Turing();
		turing.addCell('Q', '0');
		turing.removeCell('0');
		assertNull("removeCell is not correctly removing the element at c0 when there's 1 previous element.", turing.getC0());
		
		turing.removeCell('1');
		assertNull("removeCell is not correctly removing the element at c1 when there's 1 previous element.", turing.getC1());
		
		turing.removeCell('2');
		assertNull("removeCell is not correctly removing the element at c2 when there's 1 previous element.", turing.getC2());
	}
	
	@Test
	public void removeCellTest3() {
		turing = new Turing();
		turing.addCell('Q', '0');
		turing.addCell('R', '2');
		turing.removeCell('0');
		boolean checker = (turing.getC0().getLetter() == 'R' && turing.getC1().getLetter() == 'R' && turing.getC2().getLetter() == 'R');
		assertTrue("removeCell is not correctly removing the element at c0 when there's 2 previous elements.", checker);
		
		turing = new Turing();
		turing.addCell('Q', '0');
		turing.addCell('R', '2');
		turing.removeCell('1');
		checker = (turing.getC0().getLetter() == 'R' && turing.getC1().getLetter() == 'R' && turing.getC2().getLetter() == 'R');
		assertTrue("removeCell is not correctly removing the element at c1 when there's 2 previous elements.", checker);
		
		turing = new Turing();
		turing.addCell('Q', '0');
		turing.addCell('R', '2');
		turing.removeCell('2');
		checker = (turing.getC0().getLetter() == 'Q' && turing.getC1().getLetter() == 'Q' && turing.getC2().getLetter() == 'Q');;
		assertTrue("removeCell is not correctly removing the element at c2 when there's 2 previous elements.", checker);
	}
	
	@Test
	public void removeCellTest4() {
		setup1();
		turing.removeCell('0');
		boolean checker = (turing.getC0().getLetter() == 'U' && turing.getC1().getLetter() == 'I' && turing.getC2().getLetter() == 'E');
		assertTrue("removeCell is not correctly removing the element at c0 when there's 2 an even number of previous elements.", checker);
		
		setup1();
		turing.removeCell('1');
		checker = (turing.getC0().getLetter() == 'A' && turing.getC1().getLetter() == 'I' && turing.getC2().getLetter() == 'E');
		assertTrue("removeCell is not correctly removing the element at c1 when there's an even number of previous elements.", checker);
		
		setup1();
		turing.removeCell('2');
		checker = (turing.getC0().getLetter() == 'A' && turing.getC1().getLetter() == 'O' && turing.getC2().getLetter() == 'L');;
		assertTrue("removeCell is not correctly removing the element at c2 when there's 2 an even number of previous elements.", checker);
	}
	
	@Test
	public void removeCellTest5() {
		setup2();
		turing.removeCell('0');
		boolean checker = (turing.getC0().getLetter() == 'L' && turing.getC1().getLetter() == 'R' && turing.getC2().getLetter() == 'M');
		assertTrue("removeCell is not correctly removing the element at c0 when there's 2 an odd number of previous elements.", checker);
		
		setup2();
		turing.removeCell('1');
		checker = (turing.getC0().getLetter() == 'A' && turing.getC1().getLetter() == 'O' && turing.getC2().getLetter() == 'M');
		assertTrue("removeCell is not correctly removing the element at c1 when there's an odd number of previous elements.", checker);
		
		setup2();
		turing.removeCell('2');
		checker = (turing.getC0().getLetter() == 'A' && turing.getC1().getLetter() == 'O' && turing.getC2().getLetter() == 'H');
		assertTrue("removeCell is not correctly removing the element at c2 when there's 2 an odd number of previous elements.", checker);
	}
	
}
