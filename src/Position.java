
public class Position {

	private char row;
	private int col;
	private int rowIndex;
	private int columnIndex;
	
	public Position(char string, int c){
		row = Character.toUpperCase(string);
		col = c;
		rowIndex();
		columnIndex();
	}
	public Position(int r, int c){
		rowIndex = r;
		columnIndex = c;
		String beta = "ABCDEFGHIJ";
		row = beta.charAt(r);
		col = c+1;
	}
	
	
	
	public char row(){
		return row;
		
	}
	
	public int column(){
		return col;
	}
	
	public String toString(){	
		return row+"-"+col;
	}
	
	public int rowIndex(){
		String alpha = "ABCDEFGHIJ";
		rowIndex =  alpha.indexOf(row);
		return rowIndex;
	}
	public int columnIndex(){
		columnIndex =  col-1;
		return columnIndex;
	}
	
	
}
