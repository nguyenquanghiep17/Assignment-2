package gin.oop.bomberman.entities.tile.item;

import gin.oop.bomberman.Game;
import gin.oop.bomberman.entities.Entity;
import gin.oop.bomberman.entities.character.Bomber;
import gin.oop.bomberman.graphics.Sprite;
import gin.oop.bomberman.sound.Sound;

public class BombItem extends Item {
	private Sound _sound;
	public BombItem(int x, int y, Sprite sprite) {
		super(x, y, sprite);
		_sound = new Sound();
	}

	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý Bomber ăn Item
		if (e instanceof Bomber) {
			Game.addBombRate(1);
			remove();
			Sound.setSoundEffectVolume(_sound.ITEM);
			_sound.play("ITEM");
		}
		return false;
	}
	


}
