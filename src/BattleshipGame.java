
public class BattleshipGame {
	
	private Ocean ocean;
	private int turns;
	private int maxTurns;
	private BattleshipPlayer user;
	
	public BattleshipGame(BattleshipPlayer player){
		user = player;
		ocean = new Ocean();
		ocean.placeAllBoats();
		user.makeOcean(ocean);
		
		turns = 1;
		
		user.startGame();
		maxTurns = 100;
	}
	
	public int play(){

	while(!gameOver()){
				Position pos = user.shoot();
				ocean.shootAt(pos);
				user.updatePlayer(pos, ocean.hit(pos), ocean.boatInitial(pos), ocean.boatName(pos), ocean.sunk(pos), gameOver(), tooManyTurns(), turns);
				turns++;	
				
		}
		return turns;
	}
	
	private boolean gameOver(){
		if(ocean.allSunk())
			return true;
		else
			return false;
	}
	
	private boolean tooManyTurns(){
		if(turns>=maxTurns)
			return true;
		else
			return false;
	}
	
	
	
	
	
	
}
