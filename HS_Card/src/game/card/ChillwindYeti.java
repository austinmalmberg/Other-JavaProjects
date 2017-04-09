package game.card;

import javax.imageio.ImageIO;

public class ChillwindYeti extends Minion {
	
	private String path = "/cards/ChillwindYeti.png";
	
	public ChillwindYeti() {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void init() {
		def_mana = 4;
		def_attack = 4;
		def_health = 5;
	}

	@Override
	public void update() {
		
	}

	@Override
	public void draw(java.awt.Graphics2D g) {
		draw(g, def_mana, attack, def_health);
	}

}
