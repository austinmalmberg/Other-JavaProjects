

public class Main {

	public static void main(String[] args) {
		
		final double weaponDamage = 2300.0;
		final double cdr = 63;
		
		Ability EBnoRune = new ExplosiveBlast(weaponDamage, 945.0, 1.0, 6.0, cdr);
		Ability EBunleashed = new ExplosiveBlast(weaponDamage, 1485.0, 1.0, 6.0, cdr);
		Ability EBflash = new ExplosiveBlast(weaponDamage, 945.0, 1.0, 3.0, cdr);
		Ability EBshortFuse = new ExplosiveBlast(weaponDamage, 909.0, 1.0, 6.0, cdr);
		Ability EBobliterate = new ExplosiveBlast(weaponDamage, 990.0, 1.0, 6.0, cdr);
		Ability EBchainReaction = new ExplosiveBlast(weaponDamage, 520.0, 3.0, 6.0, cdr);
		
		System.out.println("\n-----Explosive Blast DPM (with Wand of Woh)-----");
		System.out.printf("No rune: %,.2f%n", EBnoRune.getDPM());
		System.out.printf("Unleashed: %,.2f%n", EBunleashed.getDPM());
		System.out.printf("Flash: %,.2f%n", EBflash.getDPM());
		System.out.printf("Short Fuse: %,.2f%n", EBshortFuse.getDPM());
		System.out.printf("Obliterate: %,.2f%n", EBobliterate.getDPM());
		System.out.printf("Chain Reaction: %,.2f%n", EBchainReaction.getDPM());
		
		Ability FNnoRune = new FrostNova(weaponDamage, 0.0, 0.0, 11.0, cdr);
		Ability FNcoldSnap = new FrostNova(weaponDamage, 0.0, 0.0, 7.5, cdr);
		
		System.out.println("\n-----Frost Nova CD-----");
		System.out.printf("No rune: %,.2f%n", FNnoRune.getCD());
		System.out.printf("Cold Snap: %,.2f%n", FNcoldSnap.getCD());
		
		Ability mirrorImage = new Ability(weaponDamage, 0.0, 0.0, 15, cdr);
		System.out.println("\n-----Mirror Image-----");
		System.out.printf("All runes: %,.2f%n", mirrorImage.getCD());
	}

}
