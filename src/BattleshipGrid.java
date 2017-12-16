

public class BattleshipGrid {

    private int[][] grid;
    private Ocean ocean;

    public BattleshipGrid() {
        //hit = 2, miss = 1, empty = 0
        grid = new int[10][10];
        
    }

    public void shotAt(Position pos, boolean hit, char initial) {
        if(hit)
            grid[pos.rowIndex()][pos.columnIndex()] = 2;
        else
            grid[pos.rowIndex()][pos.columnIndex()] = 1;

    }

    public boolean hit(Position pos) {
        if(grid[pos.rowIndex()][pos.columnIndex()]==2)
            return true;
        else
            return false;
    }


    public boolean miss(Position pos) {
          if(grid[pos.rowIndex()][pos.columnIndex()]==1)
            return true;
        else
            return false;
    }


    public boolean empty(Position pos) {
          if(grid[pos.rowIndex()][pos.columnIndex()]==0)
            return true;
        else
            return false;
    }


   public char boatInitial(Position pos) {
       return ocean.boatInitial(pos);
    }
    
    public void makeOcean(Ocean oc){
        ocean = oc;
    }


    public String toString() {
        String res = "";
        for(int row = 0; row < 11; row++){
        	
        	if(row==0){
        		res+="  ";
        	}else{
        		Position temp = new Position(row-1, 0);
        		res+=temp.row()+" ";
        	}
        	for(int col = 0; col < 10; col++){
        		if(row==0){
        			res+=(col+1+"  ");
        		}else{
        			if(empty(new Position(row-1, col))){
        				res+=".  ";
        			}else if(miss(new Position(row-1, col))){
        				res+="*  ";
        			}else{
        				
        				Position tmp = new Position(row-1, col);
        				char c = ocean.boatInitial(tmp);
        				if(c!=' '){
        					String str = String.valueOf(c);
            				res+=str+"  ";
        				}else{
        					res+="#  ";
        				}
        					
        				
        			}
        		}
        			
        	}
        	res+="\n";
        }
        return res;
    }


}
