
public class ComputerBattleshipPlayer extends BattleshipPlayer {

	private BattleshipGrid battlegr;
	
	public ComputerBattleshipPlayer(){
		battlegr = new BattleshipGrid();
	}
	
	public void startGame(){
		//System.out.println("Battleship Computer commencing play");
	}
	
	void updateGrid(Position pos, boolean hit, char initial){
    	battlegr.shotAt(pos, hit, initial);
    }
	
	public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns){
		updateGrid(pos, hit, initial);
		
	}

	public String playerName(){
		return "Computer Player";
	}
	
	public Position shoot(){
       Position temp = new Position(0,0);
       boolean state = false;
         while(!state){
    		 int row = (int) (Math.random()*10);
             int col = (int) (Math.random()*10);
              temp = new Position(row, col);
        	 if(battlegr.empty(temp)){
        		 state = true;
         	}
         }
         
         return temp;
	}
	
	public void makeOcean(Ocean oc){
		battlegr = new BattleshipGrid();
		battlegr.makeOcean(oc);
	}
	
	 
}
