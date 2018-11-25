package gin.oop.bomberman.entities.tile;

import gin.oop.bomberman.Board;
import gin.oop.bomberman.entities.Entity;
import gin.oop.bomberman.entities.character.Bomber;
import gin.oop.bomberman.graphics.Sprite;

public class Portal extends Tile {
	protected Board _board;
	public Portal(int x, int y,Board board, Sprite sprite) {
		super(x, y, sprite);
		_board = board;
	}
	
	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý khi Bomber đi vào
		//&& _board.get_characters().size() == 1
		if (e instanceof Bomber ) {
			_board.nextLevel();
			return true;
		}
		return false;
	}

}
