package gin.oop.bomberman.level;

import gin.oop.bomberman.entities.LayeredEntity;
import gin.oop.bomberman.entities.tile.Grass;
import gin.oop.bomberman.entities.tile.Portal;
import gin.oop.bomberman.entities.tile.Wall;
import gin.oop.bomberman.entities.tile.destroyable.Brick;
import gin.oop.bomberman.entities.tile.item.BombItem;
import gin.oop.bomberman.entities.tile.item.FlameItem;
import gin.oop.bomberman.entities.tile.item.SpeedItem;
import gin.oop.bomberman.Board;
import gin.oop.bomberman.Game;
import gin.oop.bomberman.entities.character.Bomber;
import gin.oop.bomberman.entities.character.enemy.Balloon;
import gin.oop.bomberman.entities.character.enemy.Oneal;
import gin.oop.bomberman.exceptions.LoadLevelException;
import gin.oop.bomberman.graphics.Screen;
import gin.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class FileLevelLoader extends LevelLoader {

	/**
	 * Ma trận chứa thông tin bản đồ, mỗi phần tử lưu giá trị kí tự đọc được
	 * từ ma trận bản đồ trong tệp cấu hình
	 */
	private static char[][] _map;
	
	public FileLevelLoader(Board board, int level) throws LoadLevelException {
		super(board, level);
	}
	
	@Override
	public void loadLevel(int level) {
		// TODO: đọc dữ liệu từ tệp cấu hình /levels/Level{level}.txt
		// TODO: cập nhật các giá trị đọc được vào _width, _height, _level, _map
		String path = "levels/Level" + level + ".txt";
		System.out.println(path);
		try {
			URL url = FileLevelLoader.class.getResource("/" + path);
			System.out.println(url);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			String data = bufferedReader.readLine();
			StringTokenizer tokens = new StringTokenizer(data);
			this._level = Integer.valueOf(tokens.nextToken());
			this._height = Integer.valueOf(tokens.nextToken());
			this._width = Integer.valueOf(tokens.nextToken());

			FileLevelLoader._map = new char[this._height][this._width];

			for (int i = 0; i < _height; i++) {
				String line = bufferedReader.readLine();
				for (int j = 0; j < _width; j++) {
					_map[i][j] = line.charAt(j);
				}
			}
			for (int i = 0; i < _map.length; i++) {
				for (int j = 0; j < _map[i].length; j++) {
					System.out.print(_map[i][j]);
				}
				System.out.println();
			}

		} catch (IOException e) {

		}

	}

	@Override
	public void createEntities() {
		// TODO: tạo các Entity của màn chơi
		// TODO: sau khi tạo xong, gọi _board.addEntity() để thêm Entity vào game

		// TODO: phần code mẫu ở dưới để hướng dẫn cách thêm các loại Entity vào game
		// TODO: hãy xóa nó khi hoàn thành chức năng load màn chơi từ tệp cấu hình
		// thêm Wall
		for (int y = 0; y <_height; y ++) {
			for (int x = 0; x < _width;x ++) {
				addEntities(_map[y][x], x, y);
			}
		}
	}

	private void addEntities(char c, int x, int y) {
		int pos = x + y * getWidth();

		switch (c) {
			case '#':
				_board.addEntity(pos, new Wall(x, y, Sprite.wall));
				break;
			case '*':
				_board.addEntity(pos, new LayeredEntity(x, y, new Grass(x, y, Sprite.grass), new Brick(x, y, Sprite.brick)));
				break;
			case 'x':
				_board.addEntity(pos, new LayeredEntity(x, y,
						new Grass(x, y, Sprite.grass),
						new Portal(x, y, _board, Sprite.portal),
						new Brick(x, y, Sprite.brick)));
				break;
			case 'p':
				_board.addCharacter(new Bomber(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
				Screen.setOffset(0, 0);
				_board.addEntity(pos,  new Grass(x, y, Sprite.grass));
				break;
			case '1':
				_board.addCharacter(new Balloon(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
				_board.addEntity(pos, new Grass(x, y, Sprite.grass));
				break;
			case '2':
				_board.addCharacter(new Oneal(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
				_board.addEntity(pos, new Grass(x, y, Sprite.grass));
				break;
			case 'b':
				LayeredEntity layer = new LayeredEntity(x, y,
						new Grass(x, y, Sprite.grass),
						new BombItem(x, y, Sprite.powerup_bombs),
						new Brick(x, y, Sprite.brick)
						);
				_board.addEntity(pos, layer);
				break;
			case 'f':
				layer = new LayeredEntity(x, y,
						new Grass(x, y, Sprite.grass),
						new FlameItem(x, y, Sprite.powerup_flames),
						new Brick(x, y, Sprite.brick)
						);
				_board.addEntity(pos, layer);
				break;
			case 's':
				layer = new LayeredEntity(x, y,
						new Grass(x, y, Sprite.grass),
						new SpeedItem(x, y, Sprite.powerup_speed),
						new Brick(x, y, Sprite.brick)
						);
				_board.addEntity(pos, layer);
				break;
			default:
				_board.addEntity(pos, new Grass(x, y, Sprite.grass));
				break;

		}
	}

}
