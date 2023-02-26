package nz.co.warofthelance.ui.screen.intro;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Colors;
import org.mini2Dx.core.graphics.Texture;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.gdx.Input.Keys;
import org.mini2Dx.gdx.InputAdapter;

import nz.co.warofthelance.Constants;
import nz.co.warofthelance.ui.font.Fonts;
import nz.co.warofthelance.ui.screen.Screen;
import nz.co.warofthelance.ui.screen.border.BorderedScreen;

public class IntroScreen extends BorderedScreen {

    private Texture mainImage;

    private Texture logo;

    private Texture gameName;

    private boolean spacePressed = false;

    @Override
    public void initialise(GameContainer gc) {
	mainImage = Mdx.graphics.newTexture(Mdx.files.internal("intro-image.png"));
	logo = Mdx.graphics.newTexture(Mdx.files.internal("logo.png"));
	gameName = Mdx.graphics.newTexture(Mdx.files.internal("game-name.png"));
	super.initialise(gc);
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {
	if (spacePressed) {
	    screenManager.enterGameScreen(Screen.START_SCREEN.getScreenId(), null, null);
	}
	super.update(gc, screenManager, delta);
    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {
	super.interpolate(gc, alpha);
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
	g.drawTexture(mainImage, (Constants.SCREEM_WIDTH / 2) - (mainImage.getWidth() / 2),
		(Constants.SCREEM_HEIGHT / 5) - (mainImage.getHeight() / 2));

	g.drawTexture(gameName, (Constants.SCREEM_WIDTH / 2) - (gameName.getWidth() / 2),
		(float) ((Constants.SCREEM_HEIGHT / 2.75) - (gameName.getHeight() / 2)));

	g.setFont(Fonts.MAIN_FONT);
	g.setColor(Colors.GREEN());
//	Fonts.GREEN_FONT.draw(g, "Based on the game by David Landrey & Chuck Kroegel",
//		(float) (Constants.SCREEM_WIDTH / 2.7), (float) (Constants.SCREEM_HEIGHT / 1.9));
	g.drawString("Based on the game by David Landrey & Chuck Kroegel", (float) (Constants.SCREEM_WIDTH / 4),
		(float) (Constants.SCREEM_HEIGHT / 1.9));

	g.drawString("AND", (float) (Constants.SCREEM_WIDTH / 2.1), (float) (Constants.SCREEM_HEIGHT / 1.7));

	g.drawTexture(logo, (Constants.SCREEM_WIDTH / 2) - (logo.getWidth() / 2),
		(float) (Constants.SCREEM_HEIGHT / 1.4) - (logo.getHeight() / 2));

	g.setColor(Colors.WHITE());
	g.drawString("Press <SPACE> or click to continue...", (float) (Constants.SCREEM_WIDTH / 2.8),
		(float) (Constants.SCREEM_HEIGHT / 1.1));
	super.render(gc, g);
    }

    @Override
    public int getId() {
	return Screen.INTRO_SCREEN.getScreenId();
    }

    @Override
    public void postTransitionIn(Transition transitionIn) {
	Mdx.input.setInputProcessor(new InputAdapter() {

	    @Override
	    public boolean keyDown(int keycode) {
		if (Keys.SPACE == keycode) {
		    // change screen
		    spacePressed = true;
		}
		return true;
	    }

	    @Override
	    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		spacePressed = true;
		return super.touchDown(screenX, screenY, pointer, button);
	    }

	});
	super.postTransitionIn(transitionIn);
    }

    @Override
    public void postTransitionOut(Transition transitionOut) {
	mainImage.dispose();
	logo.dispose();
	gameName.dispose();
	super.postTransitionOut(transitionOut);
    }

}
