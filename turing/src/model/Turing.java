package model;

public class Turing {
	
	//---------------------
	//     ATTRIBUTES
	//---------------------
	private Cell firstCell;	//Double linked list 
	private Cell c0;
	private Cell c1;
	private Cell c2;
	private int cellsNo;
	
	//---------------------
	//    CONSTRUCTOR
	//---------------------
	public Turing () {
		firstCell = null;
		c0 = null;
		c1 = null;
		c2 = null;
		cellsNo = 0;
	}
	
	//---------------------
	//     F.METHODS
	//---------------------
	public void addCell(char letter, char head) {
		Cell toAdd = new Cell(letter);
		if (firstCell == null) { //Empty list
			firstCell = toAdd;
			firstCell.setPrevCell(firstCell);
			firstCell.setNextCell(firstCell);
			c0 = firstCell; 
			c1 = firstCell; 
			c2 = firstCell;
			++cellsNo;
		}
		else {
			switch (head) { //Non-empty list
			case '0': //C0
				toAdd.setNextCell(firstCell); 
				toAdd.setPrevCell(firstCell.getPrevCell());
				firstCell.setPrevCell(toAdd);
				if (cellsNo == 1) {
					firstCell.setNextCell(toAdd);
				}
				firstCell = toAdd;
				if(cellsNo == 1) { //Special case 
					c2 = firstCell.getNextCell();
				}
				else if (cellsNo == 2) { //Special case 
					c1 = firstCell.getNextCell();
				}
				else if (cellsNo % 2 != 0) { //Rule 
					c1 = c1.getPrevCell();
				}
				c0 = firstCell;
				break;

			case '1': //C1
				if (cellsNo % 2 == 0) { //Even cells
					toAdd.setNextCell(c1.getNextCell());
					toAdd.setPrevCell(c1);
					c1.getNextCell().setPrevCell(toAdd);
					c1.setNextCell(toAdd);
					c1 = c1.getNextCell();
				}
				else { //Odd cells
					toAdd.setNextCell(c1);
					toAdd.setPrevCell(c1.getPrevCell());
					c1.getPrevCell().setNextCell(toAdd);
					c1.setPrevCell(toAdd);
					if (cellsNo == 1) {
						firstCell = toAdd;
						c0 = firstCell;
						c2.setPrevCell(toAdd);
					}
					c1 = c1.getPrevCell();
				}
				break;
				
			case '2': //C2
				toAdd.setNextCell(firstCell);
				toAdd.setPrevCell(c2);
				firstCell.getPrevCell().setNextCell(toAdd);
				firstCell.setPrevCell(toAdd);
				c2 = toAdd;
				if (cellsNo % 2 == 0) {
					c1 = c1.getNextCell();
				}
				break;
			}
			++cellsNo;
		}
	}

	public char readCell (char head) {
		char letter = '#';
		if (cellsNo > 0) {
			switch (head) {
			case '0': 
				letter = c0.getLetter();
				break;

			case '1':
				letter = c1.getLetter();
				break;

			case '2': 
				letter = c2.getLetter();
				break;
			}
		}
		return letter;
	}

	public void removeCell (char head) {
		if (cellsNo > 0) {
			if (cellsNo == 1) {
				firstCell = null;
				c0 = firstCell;
				c1 = firstCell;
				c2 = firstCell;
				--cellsNo;
			}
			else {
				switch (head) {
				case '0':
					c2.setNextCell(c0.getNextCell());
					c0.getNextCell().setPrevCell(c2);
					c0 = c0.getNextCell();
					firstCell = c0;
					if (cellsNo % 2 == 0) {
						c1 = c1.getNextCell();
					}
					break;

				case '1':
					c1.getPrevCell().setNextCell(c1.getNextCell());
					c1.getNextCell().setPrevCell(c1.getPrevCell());
					if(cellsNo % 2 == 0) {
						c1 = c1.getNextCell();
						if(cellsNo == 2) {
							c0 = c0.getNextCell();
							firstCell = c0;
						}
					}
					else {
						c1 = c1.getPrevCell();
					}
					break;

				case '2':
					c2.getPrevCell().setNextCell(firstCell);
					firstCell.setPrevCell(c2.getPrevCell());
					c2 = c2.getPrevCell();
					if (cellsNo % 2 != 0) {
						c1 = c1.getPrevCell();
					}
					break;	
				}
				--cellsNo;
			}
		}
	}
	//---------------------
	//        GETS
	//---------------------
	public Cell getFirstCell() {
		return firstCell;
	}
	
	//---------------------
	//        SETS
	//---------------------
	public void setFirstCell(Cell firstCell) {
		this.firstCell = firstCell;
	}
	
}
