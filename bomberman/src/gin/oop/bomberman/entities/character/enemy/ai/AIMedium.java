package gin.oop.bomberman.entities.character.enemy.ai;

import gin.oop.bomberman.entities.character.Bomber;
import gin.oop.bomberman.entities.character.enemy.Enemy;

public class AIMedium extends AI {
	Bomber _bomber;
	Enemy _e;
	
	public AIMedium(Bomber bomber, Enemy e) {
		_bomber = bomber;
		_e = e;
	}
        public int sameCol(){
            if(_bomber.getXTile() < _e.getXTile())
			return 3;
		else if(_bomber.getXTile() > _e.getXTile())
			return 1;
		
		return -1;
        }
        public int sameRow(){
            if(_bomber.getYTile() < _e.getYTile())
			return 0;
		else if(_bomber.getYTile() > _e.getYTile())
			return 2;
		return -1;
        }
	@Override
	public int calculateDirection() {
		// TODO: cài đặt thuật toán tìm đường đi
                if (_bomber == null) {
                    return random.nextInt(4);
                }
                int pos = random.nextInt(2);
                if (pos == 0) {
                    int col = sameCol();
			
			if(col != -1) {
                            return col;
                        } else {
                            return sameRow();
                        }
				
			
				
                } else {
                    int row = sameRow();
                    if(row != - 1) {
                        return row;
                    } else {
                        return sameCol();
                    }
                }
	}
        

}
