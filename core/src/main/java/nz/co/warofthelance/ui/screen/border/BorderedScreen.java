package nz.co.warofthelance.ui.screen.border;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Texture;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;

import nz.co.warofthelance.Constants;

public class BorderedScreen extends BasicGameScreen {

    protected static Texture borderImage;

    @Override
    public void initialise(GameContainer gc) {
	if (borderImage == null) {
	    borderImage = Mdx.graphics.newTexture(Mdx.files.internal("border.png"));
	}
    }

    @Override
    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {

    }

    @Override
    public void interpolate(GameContainer gc, float alpha) {
    }

    @Override
    public void render(GameContainer gc, Graphics g) {
	int widthMultiple = Constants.SCREEN_WIDTH / borderImage.getWidth();
	int heightMultiple = Constants.SCREEN_HEIGHT / borderImage.getHeight();
	for (int x = 0; x < widthMultiple; x++) {
	    for (int y = 0; y < heightMultiple; y++) {
		if (!((x > 0 && x < widthMultiple - 1) && (y > 0 && y < heightMultiple - 1))) {
		    g.drawTexture(borderImage, x * borderImage.getWidth(), y * borderImage.getHeight());
		}
	    }
	}
    }

    @Override
    public int getId() {
	return 999;
    }

}
