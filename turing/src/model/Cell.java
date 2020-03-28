package model;

public class Cell {
	
	//---------------------
	//     ATTRIBUTES
	//---------------------
	private char letter;
	private Cell nextCell;
	private Cell prevCell;
	
	//---------------------
	//    CONSTRUCTOR
	//---------------------
	public Cell (char l) {
		letter = l;
		nextCell = null;
		prevCell = null;
	}
	
	//---------------------
	//        GETS
	//---------------------
	public char getLetter() {
		return letter;
	}

	public Cell getNextCell() {
		return nextCell;
	}

	public Cell getPrevCell() {
		return prevCell;
	}

	//---------------------
	//        SETS
	//---------------------
	public void setLetter(char letter) {
		this.letter = letter;
	}

	public void setNextCell(Cell nextCell) {
		this.nextCell = nextCell;
	}

	public void setPrevCell(Cell prevCell) {
		this.prevCell = prevCell;
	}	
}
