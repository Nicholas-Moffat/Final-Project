package project.model;

import java.util.ArrayList;
import java.util.List;

public class Room {

	private Tile[][] room;
	private int xStartPos;
	private int yStartPos;
	private List<Enemy> enemies;
	
	public Room(String[] levelDesign, int xStartPos, int yStartPos, Enemy... species) {
		room = new Tile[levelDesign.length][];
		for(int column = 0; column<levelDesign.length; column++) {
			room[column] = new Tile[levelDesign[column].length()];
			
			for(int row = 0; row<levelDesign[column].length(); row++) {
				switch(levelDesign[column].charAt(row)) {
				case '#':
					room[column][row] = new Tile("wall", row, column);
					break;
				case ' ':
					room[column][row] = new Tile("floor", row, column);
					break;
				case 'd':
					room[column][row] = new Tile("door", row, column);
					break;
				case '^':
					room[column][row] = new Tile("stairs", row, column);
					break;
				case 'p':
					room[column][row] = new Tile("player", row, column);
					break;
				case 's':
					room[column][row] = new Tile("skeleton", row, column);
					break;
				case 'c':
					room[column][row] = new Tile("chest", row, column);
					break;
				case 'o':
					room[column][row] = new Tile("open", row, column);
					break;
				case 'g':
					room[column][row] = new Tile("gate", row, column);
					break;
				}
			}
		}
		
		this.enemies = new ArrayList<Enemy>();
		for (Enemy enemy : species) {
			this.enemies.add(enemy);
		}
		
		this.xStartPos = xStartPos;
		this.yStartPos = yStartPos;
	}
	
	public Enemy[] getEnemies() {
		Enemy[] roomEnemies = new Enemy[enemies.size()];
		roomEnemies = enemies.toArray(roomEnemies);
		return roomEnemies;
	}
	
	public Enemy getEnemyAt(int x, int y)
	{
		for (Enemy enemy: enemies)
		{
			if (enemy.getPosX() == x && enemy.getPosY() == y)
			{
				return enemy;
			}
		}
		return null;
	}
	
	public boolean enemyInRoom(int x, int y) {
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).getPosX() == x && enemies.get(i).getPosY() == y) {
				return true;
			}
		}
		return false;
	}
	
	public int getxStartPos() {
		return xStartPos;
	}
	
	public int getyStartPos() {
		return yStartPos;
	}
	
	public int getSizeX() {
		return room[0].length;
	}
	
	public int getSizeY() {
		return room.length;
	}
	
	public Tile getTileAt(int x, int y) {
		return room[y][x];
	}
}