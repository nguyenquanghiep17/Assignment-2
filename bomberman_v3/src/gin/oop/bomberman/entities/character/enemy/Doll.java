package gin.oop.bomberman.entities.character.enemy;

import gin.oop.bomberman.Board;
import gin.oop.bomberman.Game;
import gin.oop.bomberman.entities.character.enemy.ai.AILow;
import gin.oop.bomberman.graphics.Sprite;

public class Doll extends Enemy {


    public Doll(int x, int y, Board board) {
        super(x, y, board, Sprite.balloom_dead, 1.4, 100);

        _sprite = Sprite.balloom_left1;

        _ai = new AILow();
        _direction = _ai.calculateDirection();
    }

    @Override
    protected void chooseSprite() {
        switch(_direction) {
            case 0:
            case 1:
                _sprite = Sprite.movingSprite(Sprite.doll_right1, Sprite.doll_right2, Sprite.doll_right3, _animate, 60);
                break;
            case 2:
            case 3:
                _sprite = Sprite.movingSprite(Sprite.doll_left1, Sprite.doll_left2, Sprite.doll_left3, _animate, 60);
                break;
        }
    }
}
