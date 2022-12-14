package info3.game.graphics;

import java.awt.Color;
import java.awt.Image;

public class AwtGraphics implements Graphics {

	public static final String RESOURCES_DIRECTORY = "resources";

	private final java.awt.Graphics g;
	private final int width;
	private final int height;
	private final int scaleFactor;

	private final TextureCache textures;

	public AwtGraphics(AwtGraphics old, java.awt.Graphics g, int width, int height, int scaleFactor) {
		this.g = g;
		this.width = width;
		this.height = height;
		this.scaleFactor = scaleFactor;
		this.textures = old != null ? old.textures : new TextureCache(RESOURCES_DIRECTORY, scaleFactor);
	}

	@Override
	public Graphics window(int x, int y, int w, int h) {
		return new AwtGraphics(this, g.create(x * scaleFactor, y * scaleFactor, w * scaleFactor, h * scaleFactor), w, h,
				scaleFactor);
	}

	@Override
	public Graphics window(float x, float y, int w, int h) {
		return new AwtGraphics(this,
				g.create((int) (x * scaleFactor), (int) (y * scaleFactor), w * scaleFactor, h * scaleFactor), w, h,
				scaleFactor);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void fill(int color, int x, int y, int width, int height) {
		g.setColor(new Color(color, true));
		g.fillRect(x * scaleFactor, y * scaleFactor, width * scaleFactor, height * scaleFactor);
	}

	void drawSpriteRealCoords(Sprite sprite, int dx, int dy) {
		Image img = textures.getScaledSprites().get(sprite);
		if (img == null)
			throw new IllegalStateException("Texture non trouvée");

		drawSpriteRealCoords(img, dx, dy);
	}

	void drawSpriteRealCoords(Image img, int dx, int dy) {
		g.drawImage(img, dx, dy, null);
	}

	@Override
	public void drawSprite(Sprite sprite, int x, int y) {
		drawSpriteRealCoords(sprite, x * this.scaleFactor, y * this.scaleFactor);
	}

	@Override
	public void drawSprite(Sprite sprite, float x, float y) {
		drawSpriteRealCoords(sprite, (int) (x * this.scaleFactor), (int) (y * this.scaleFactor));
	}

	@Override
	public void drawSpritePart(Sprite sprite, int x, int y, int offsetU, int offsetV) {
		Image img = textures.getScaledSprites().get(sprite);
		if (img == null)
			throw new IllegalStateException("Texture non trouvée");

		int tileSize = sprite.spritesheet.tileSize;
		int dx = x * this.scaleFactor, dy = y * this.scaleFactor;
		int sx = offsetU * this.scaleFactor * tileSize, sy = offsetV * this.scaleFactor * tileSize;
		int size = tileSize * this.scaleFactor;
		g.drawImage(img, dx, dy, dx + size, dy + size, sx, sy, sx + size, sy + size, null);
	}

	@Override
	public int measureText(String text) {
		return textures.getFont7beige().measureText(text);
	}

	@Override
	public void drawText(String text, Align align, int x, int y) {
		AwtFont f = textures.getFont7beige();
		int width = f.measureText(text);
		switch (align) {
		case LEFT:
			f.drawText(this, text, x, y);
			break;
		case RIGHT:
			f.drawText(this, text, x - width, y);
			break;
		case CENTER:
			f.drawText(this, text, x - width / 2, y);
			break;
		}
	}

	@Override
	protected void finalize() {
		g.dispose();
	}

}
