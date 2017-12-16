import java.util.*;

public class BattleshipPlayer {

    private String         name;
    private BattleshipGrid battlegrid;

    public BattleshipPlayer() {
        name = "";
        battlegrid = new BattleshipGrid();
    }

    public void startGame() {
     
        if (name.equals("")) {      
            Scanner in = new Scanner(System.in);
            System.out.println("Enter name");
            name = in.next();
            
            System.out.println("Welcome " + name);
        }
    }
    
    public String playerName(){
        return name;
    }
    
    public Position shoot(){
        Scanner in2 = new Scanner(System.in);
        System.out.println("Enter row");
        String row = in2.next();
        System.out.println("Enter column");
        String column = in2.next();
        Position res = new Position(row.toCharArray()[0], Integer.parseInt(column));
        return res;
        
    }
    
    void updateGrid(Position pos, boolean hit, char initial){
    	battlegrid.shotAt(pos, hit, initial);
    }
    
    public void makeOcean(Ocean ocean){
    	battlegrid = new BattleshipGrid();
    	battlegrid.makeOcean(ocean);
    }
    
    public void updatePlayer(Position pos, boolean hit, char initial, String boatName, boolean sunk, boolean gameOver, boolean tooManyTurns, int turns){
    	if(hit){
    		System.out.println("Hit a ship");
    		System.out.println("Hit " + boatName);
    		if(sunk)
    			System.out.println("Boat was sunk");
    		else
    			System.out.println("Boat was not sunk");
    		
    	}else{
    		System.out.println("Shot was a miss");
    	}
    	
    	if(tooManyTurns)
    		System.out.println("Game has gone on for too long");
    	if(gameOver)
    		System.out.println("Game Over");
    	System.out.println(turns + " turns taken");
    	
    	updateGrid(pos, hit, initial);
    	
    	System.out.println(battlegrid);
    }
}
