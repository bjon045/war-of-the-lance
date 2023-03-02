package nz.co.warofthelance;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.exception.SerializationException;
import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.core.graphics.viewport.FitViewport;

import nz.co.warofthelance.model.GameData;
import nz.co.warofthelance.ui.screen.Screen;
import nz.co.warofthelance.ui.screen.gameoptions.GameOptionsScreen;
import nz.co.warofthelance.ui.screen.intro.IntroScreen;
import nz.co.warofthelance.ui.screen.mainmap.MainMapScreen;
import nz.co.warofthelance.ui.screen.start.StartScreen;

public class WarOfTheLanceGame extends ScreenBasedGame {
    public static final String GAME_IDENTIFIER = "nz.co.warofthelance";

    private FitViewport fitViewport;

    @Override
    public void initialise() {

	try {
	    GameData gd = Mdx.json.fromJson(Mdx.files.internal("gamedata.json"), GameData.class);
	} catch (SerializationException e) {
	    throw new RuntimeException(e);
	}

//	List<Hero> heroes = new ArrayList<>();
//	heroes.add(new Hero());
//	gd.setHighlordHeroes(heroes);
//	gd.setWhiteStoneHeroes(heroes);
//	try {
//	    String json = Mdx.json.toJson(gd);
//	    System.out.println(json);
//	} catch (SerializationException e) {
//	    throw new RuntimeException(e);
//	}

	fitViewport = new FitViewport(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

	addScreen(new IntroScreen());
	addScreen(new StartScreen());
	addScreen(new GameOptionsScreen());
	addScreen(new MainMapScreen());
    }

    @Override
    public int getInitialScreenId() {
	return Screen.INTRO_SCREEN.getScreenId();
    }

    @Override
    public void render(Graphics g) {
	fitViewport.apply(g);
	super.render(g);
    }

    @Override
    public void resize(int width, int height) {
	fitViewport.onResize(width, height);
	super.resize(width, height);
    }
}
