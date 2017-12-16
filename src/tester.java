
public class tester {
	public static void main(String[] args){
		//BattleshipPlayer player = new BattleshipPlayer();
		//BattleshipGame game = new BattleshipGame(player);
		//System.out.println("Game finished by "+player.playerName()+" in " + game.play());
		
		ComputerBattleshipPlayer comp = new ComputerBattleshipPlayer();
		PlayerEvaluator eval = new PlayerEvaluator(comp, 500);
		
		System.out.println(eval.averageTurns() + ": Average Number of Turns");
		System.out.println(eval.maxTurns() + ": Max Turns");
		System.out.println(eval.minTurns()+": Min Turns");
		
		
	}
}
