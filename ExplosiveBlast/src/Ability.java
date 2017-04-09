
public class Ability {
	
	private double dpa; // damage per action
	private double modifiedCD;
	private double apm; // actions per minute
	private double dpm; // with Wand of Woh
	
	public Ability(double weaponDamage, double damageMod, double pulses, double baseCD, double cdr) {
		dpa = weaponDamage * damageMod * pulses;
		modifiedCD = baseCD * ((100.0 - cdr) / 100.0);
		apm = 60 / modifiedCD;
		dpm = apm * dpa * 4;
	}
	
	public double getDPM() { return dpm; }
	public double getCD() { return modifiedCD; }
}
