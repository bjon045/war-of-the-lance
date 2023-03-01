package nz.co.warofthelance.ui.screen.mainmap;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.files.FileHandle;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.gdx.Input.Keys;
import org.mini2Dx.gdx.InputAdapter;
import org.mini2Dx.tiled.TiledMap;

import nz.co.warofthelance.ui.screen.Screen;
import nz.co.warofthelance.ui.screen.border.BorderedScreen;

public class MainMapScreen extends BorderedScreen {

    private TiledMap gameMap;

    private static final int MAP_VIEWPORT_WIDTH = 39;

    private static final int MAP_VIEWPORT_HEIGHT = 18;

    private int startX = 20;

    private int startY = 20;

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
	gameMap.draw(g, borderImage.getWidth() + 5, borderImage.getHeight() + 5, startX, startY, MAP_VIEWPORT_WIDTH,
		MAP_VIEWPORT_HEIGHT);
	super.render(gc, g);
    }

    @Override
    public int getId() {
	return Screen.MAIN_MAP_SCREEN.getScreenId();
    }

    @Override
    public void postTransitionIn(Transition transitionIn) {
	Mdx.input.setInputProcessor(new MainMapScreenInputAdapter());
	super.postTransitionIn(transitionIn);
    }

    class MainMapScreenInputAdapter extends InputAdapter {

	@Override
	public boolean keyDown(int keycode) {
	    if (Keys.DOWN == keycode || Keys.NUMPAD_2 == keycode) {
		if (startY < gameMap.getHeight() - MAP_VIEWPORT_HEIGHT) {
		    startY++;
		}
	    } else if (Keys.UP == keycode || Keys.NUMPAD_8 == keycode) {
		if (startY > 1) {
		    startY--;
		}
	    } else if (Keys.LEFT == keycode || Keys.NUMPAD_4 == keycode) {
		if (startX > 1) {
		    startX--;
		}
	    } else if (Keys.RIGHT == keycode || Keys.NUMPAD_6 == keycode) {
		if (startX < gameMap.getWidth() - MAP_VIEWPORT_WIDTH) {
		    startX++;
		}
	    } else if (Keys.SPACE == keycode) {

	    } else if (Keys.ESCAPE == keycode) {

	    }

	    return true;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	    System.out.println("screenX: " + screenX);
	    System.out.println("screenY: " + screenY);

	    return super.touchDown(screenX, screenY, pointer, button);
	}

    }

}
