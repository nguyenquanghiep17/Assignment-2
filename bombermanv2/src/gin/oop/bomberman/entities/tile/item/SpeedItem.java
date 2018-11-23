package gin.oop.bomberman.entities.tile.item;

import gin.oop.bomberman.Game;
import gin.oop.bomberman.entities.Entity;
import gin.oop.bomberman.entities.character.Bomber;
import gin.oop.bomberman.graphics.Sprite;
import gin.oop.bomberman.sound.Sound;

public class SpeedItem extends Item {

	public SpeedItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
	private Sound sound = new Sound();
	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý Bomber ăn Item
		if (e instanceof Bomber) {
			Game.addBomberSpeed(0.1);
			remove();
			sound.play("ITEM");
		}
		return false;
	}
}
