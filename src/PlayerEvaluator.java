
public class PlayerEvaluator {

	private int maxTurns;
	private int minTurns;
	private float averageTurns;
	
	public PlayerEvaluator(ComputerBattleshipPlayer player, int runs){
		maxTurns = -1;
		minTurns = 101;
		averageTurns = 0;
		
		for(int i = 0; i < runs; i++){
			BattleshipGame game = new BattleshipGame(player);
			int turns = game.play();
		
			averageTurns+=turns;
			
			if(turns >=maxTurns){
				maxTurns = turns;
			}
			
			if(turns <= minTurns){
				minTurns = turns;
			}
			
		}
		
		averageTurns = averageTurns/runs;
		
		
		
	}
	
	public int maxTurns(){
		return maxTurns;
	}
	
	public int minTurns(){
		return minTurns;
	}
	
	public float averageTurns(){
		return averageTurns;
	}
	
	
}
