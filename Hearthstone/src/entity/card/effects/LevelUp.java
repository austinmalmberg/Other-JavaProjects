package entity.card.effects;


// give a friendly minion +1/+1
public class LevelUp extends Battlecry {
	
	public LevelUp(int attack, int health) {
		targetFriendlyPlayer = false;
		targetFriendlyMinion = true;
		targetEnemyPlayer = false;
		targetEnemyMinion = false;
	}
}
