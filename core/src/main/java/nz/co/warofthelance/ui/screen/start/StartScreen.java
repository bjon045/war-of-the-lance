package nz.co.warofthelance.ui.screen.start;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Texture;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.gdx.Input.Keys;
import org.mini2Dx.gdx.InputAdapter;

import nz.co.warofthelance.Constants;
import nz.co.warofthelance.ui.entity.menuoption.MenuOptionGroup;
import nz.co.warofthelance.ui.screen.Screen;
import nz.co.warofthelance.ui.screen.border.BorderedScreen;
import nz.co.warofthelance.ui.screen.start.enums.StartOptions;

public class StartScreen extends BorderedScreen {

    private boolean screenTransition;

    private int screenId;

    private Texture gameName;

    private MenuOptionGroup<StartOptions> menuOptions;

    @Override
    public void initialise(GameContainer gc) {
	gameName = Mdx.graphics.newTexture(Mdx.files.internal("game-name.png"));
	menuOptions = new MenuOptionGroup<StartOptions>(300, 300, 100, false, StartOptions.NEW_GAME,
		StartOptions.LOAD_GAME);
	menuOptions.setSelected(StartOptions.NEW_GAME.getMenyKey());
	super.initialise(gc);
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {
	if (screenTransition) {
	    screenManager.enterGameScreen(screenId, null, null);
	}
	super.update(gc, screenManager, delta);
    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {
	super.interpolate(gc, alpha);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
	super.render(gc, g);
	g.drawTexture(gameName, (float) (Constants.SCREEM_WIDTH / 2) - (gameName.getWidth() / 2),
		(float) borderImage.getHeight() + 30);

	int widthMultiple = Constants.SCREEM_WIDTH / borderImage.getWidth();
	for (int x = 0; x < widthMultiple; x++) {
	    if (x > 0 && x < widthMultiple - 1) {
		g.drawTexture(borderImage, x * borderImage.getWidth(), 120);
	    }
	}

	menuOptions.render(gc, g);

    }

    @Override
    public int getId() {
	return Screen.START_SCREEN.getScreenId();
    }

    @Override
    public void postTransitionIn(Transition transitionIn) {
	screenTransition = false;
	screenId = 0;
	Mdx.input.setInputProcessor(new InputAdapter() {

	    @Override
	    public boolean keyDown(int keycode) {
		if (Keys.DOWN == keycode || Keys.NUMPAD_2 == keycode) {
		    menuOptions.setNextMenuOption();
		} else if (Keys.UP == keycode || Keys.NUMPAD_8 == keycode) {
		    menuOptions.setPrevMenuOption();
		} else if (Keys.SPACE == keycode) {
		    StartOptions selectedOption = StartOptions.valueOf(menuOptions.getSelected());
		    switch (selectedOption) {
		    case NEW_GAME:
			screenTransition = true;
			screenId = Screen.GAME_OPTIONS_SCREEN.getScreenId();
			break;
		    case LOAD_GAME:
			break;
		    }
		}

		return true;
	    }

	    @Override
	    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		String selectedKey = menuOptions.getSelectedByXY(screenX, screenY);
		if (selectedKey != null) {
		    StartOptions selectedOption = StartOptions.valueOf(selectedKey);
		    switch (selectedOption) {
		    case NEW_GAME:
			screenTransition = true;
			screenId = Screen.GAME_OPTIONS_SCREEN.getScreenId();
			break;
		    case LOAD_GAME:
			// TODO: not implemented.
			break;
		    }
		}
		return super.touchDown(screenX, screenY, pointer, button);
	    }

	    @Override
	    public boolean mouseMoved(int screenX, int screenY) {
		String selectedKey = menuOptions.getSelectedByXY(screenX, screenY);
		if (selectedKey != null) {
		    menuOptions.setSelected(selectedKey);
		}
		return super.mouseMoved(screenX, screenY);
	    }
	});
	super.postTransitionIn(transitionIn);
    }

//    @Override
//    public void postTransitionOut(Transition transitionOut) {
//	gameName.dispose();
//	super.postTransitionOut(transitionOut);
//    }

    @Override
    public void onResize(int width, int height) {
	// TODO Auto-generated method stub
	super.onResize(width, height);
    }
}
