import java.util.Arrays;

public class Boat {

	private String type;
	private Position position;
	private String orientation;
	private int size;
	private boolean[] hitlist;
	
	public Boat(String t, Position p, String o){
		type = t.toLowerCase();
		position = p;
		orientation = o.toLowerCase();
		if(t.startsWith("A")){
			size = 5;
		}else if(t.startsWith("B")){
			size = 4;
		}else if(t.startsWith("C")||t.startsWith("S")){
			size = 3;
		}else if(t.startsWith("D")){
			size = 2;
		}
		hitlist = new boolean[size];
	}
	
	public String name(){
		return type;
	}
	
	public char abbreviation(){
		return (char) type.charAt(0);
	}
	
	public int size(){
		return size;
	}
	
	public boolean onBoat(Position p){
		if(orientation.equals("horizontal")){
			for(int i = 0; i < size;i++){
				if(p.rowIndex() == position.rowIndex() && (p.columnIndex()) == (position.columnIndex() + i)){
					
					return true;
				}
			}
		}else{
			for(int i = 0; i < size;i++){
				if(p.rowIndex() == (position.rowIndex()+i) && p.columnIndex() == position.columnIndex()){
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void hit(Position p){
		if(onBoat(p)){
			if(orientation.equals("horizontal")){
				for(int i = 0; i < size;i++){
					if(p.rowIndex() == position.rowIndex() && (p.columnIndex()) == (position.columnIndex() + i)){
						
						hitlist[i] = true;
					}
				}
			}else{
				for(int i = 0; i < size;i++){
					if(p.rowIndex() == (position.rowIndex()+i) && p.columnIndex() == position.columnIndex()){
						
						hitlist[i] = true;
					}
				}
			}
		}
	}
	
	public boolean sunk(){
		for(boolean value: hitlist){
			  if(!value){ return false;}
			}
			return true;
	}	
	
	public boolean isHit(Position p){
		if(orientation.equals("horizontal")){
			for(int i = 0; i < size;i++){
				if(p.rowIndex() == position.rowIndex() && (p.columnIndex()) == (position.columnIndex() + i)){
					if(hitlist[i])
					return true;
				}
			}
		}else{
			for(int i = 0; i < size;i++){
				if(p.rowIndex() == (position.rowIndex()+i) && p.columnIndex() == position.columnIndex()){
					if(hitlist[i])
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public String direction(){
		return orientation;
	}
	
	public Position position(){
		return position;
	}
	
}
