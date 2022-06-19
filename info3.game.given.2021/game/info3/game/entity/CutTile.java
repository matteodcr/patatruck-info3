package info3.game.entity;

import info3.game.content.Item;
import info3.game.graphics.Graphics;
import info3.game.graphics.Sprite;
import info3.game.position.AutCategory;
import info3.game.position.AutDirection;
import info3.game.scene.KitchenScene;
import info3.game.scene.Scene;

public class CutTile extends KitchenTile {
	Item item;
	int compteur;

	public CutTile(Scene parent, int gridX, int gridY, AutDirection d) {
		super(parent, gridX, gridY, null, d);
		this.item = null;
		this.compteur = 0;
	}

	@Override
	public boolean pop(AutDirection direction) {// prend un ingrédiant à couper
		Item item_player = ((KitchenScene) this.parentScene).getCook().item;
		if (item_player == null || this.item != null) {
			return false;
		} else {
			if (item_player.cut() == null) { // est-ce qu'on peut couper?
				return false;
			}
			this.item = item_player.cut();
			item_player = null;
			this.compteur = 20000;
			return true;
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public EntityType getType() {
		return EntityType.TILE_CUT;
	}

	@Override
	public boolean wizz(AutDirection direction) {// rend l'ingrédient coupé au joueur
		((KitchenScene) this.parentScene).getCook().item = this.item;
		this.item = null;
		return true;

	}

	@Override
	public boolean gwait() {
		if (this.compteur > 0) {
			this.compteur++;
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void render(Graphics g) {
		// BufferedImage img = m_images[m_imageIndex];
		g.drawSprite(Sprite.CUT_TILE, 0, 0);
	}

	@Override
	public boolean egg(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hit(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean jump(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean explode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pick(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean power() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean protect(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean store() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean turn(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gthrow(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean myDir(AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closest(AutCategory category, AutDirection direction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotPower() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gotStuff() {
		// TODO Auto-generated method stub
		return false;
	}

}
