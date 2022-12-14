package info3.game.entity;

import info3.game.content.Item;
import info3.game.graphics.Sprite;
import info3.game.position.AutCategory;
import info3.game.position.AutDirection;
import info3.game.scene.KitchenScene;
import info3.game.scene.Scene;

public abstract class KitchenTile extends Tile {
	final CookEntity player;
	public Item item;

	protected KitchenTile(Scene parent, int gridX, int gridY, Sprite sprite, AutDirection d) {
		super(parent, gridX, gridY, sprite);
		category = AutCategory.O;
		direction = d;
		player = ((KitchenScene) parent).getCook();
	}

	@Override
	public boolean move(AutDirection direction) {
		// Can't move
		return false;
	}

	@Override
	public boolean gotStuff() {
		return this.item != null;
	}

}
