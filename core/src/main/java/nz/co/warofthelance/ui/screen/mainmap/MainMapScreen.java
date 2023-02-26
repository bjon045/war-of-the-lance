package nz.co.warofthelance.ui.screen.mainmap;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.files.FileHandle;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.tiled.TiledMap;

import nz.co.warofthelance.ui.screen.Screen;
import nz.co.warofthelance.ui.screen.border.BorderedScreen;

public class MainMapScreen extends BorderedScreen {

    private TiledMap gameMap;

    @Override
    public void initialise(GameContainer gc) {
	FileHandle mapFileHandler = Mdx.files.internal("overland.tmx");
	gameMap = new TiledMap(mapFileHandler);
	super.initialise(gc);
	// how to access a tile
	// Tile tile = gameMap.getTile(12, 12, 0);
	// tile.getProperty("type");
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {
	super.update(gc, screenManager, delta);
    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {
	super.interpolate(gc, alpha);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
	gameMap.draw(g, borderImage.getWidth() + 5, borderImage.getHeight() + 5, 20, 20, 39, 18);
	super.render(gc, g);
    }

    @Override
    public int getId() {
	return Screen.MAIN_MAP_SCREEN.getScreenId();
    }

}
