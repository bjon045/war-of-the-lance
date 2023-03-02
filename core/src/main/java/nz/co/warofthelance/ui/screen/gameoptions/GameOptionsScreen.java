package nz.co.warofthelance.ui.screen.gameoptions;

import static nz.co.warofthelance.GameContext.RESOURCES;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Colors;
import org.mini2Dx.core.graphics.Texture;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;
import org.mini2Dx.core.screen.Transition;
import org.mini2Dx.gdx.Input.Buttons;
import org.mini2Dx.gdx.Input.Keys;
import org.mini2Dx.gdx.InputAdapter;

import nz.co.warofthelance.Constants;
import nz.co.warofthelance.ui.entity.button.Button;
import nz.co.warofthelance.ui.entity.menuoption.MenuOptionGroup;
import nz.co.warofthelance.ui.font.Fonts;
import nz.co.warofthelance.ui.screen.Screen;
import nz.co.warofthelance.ui.screen.border.BorderedScreen;
import nz.co.warofthelance.ui.screen.gameoptions.enums.CampaignTypeGroup;
import nz.co.warofthelance.ui.screen.gameoptions.enums.GameOptionGroups;
import nz.co.warofthelance.ui.screen.gameoptions.enums.LevelSelectionGroup;
import nz.co.warofthelance.ui.screen.gameoptions.enums.PlayerTypeGroup;

public class GameOptionsScreen extends BorderedScreen {

    private boolean screenTransition;

    private int screenId;

    private Texture gameName;

    private MenuOptionGroup<GameOptionGroups> gameOptionGroups;

    private MenuOptionGroup<PlayerTypeGroup> playerTypeGroup;

    private MenuOptionGroup<CampaignTypeGroup> campaignTypeGroup;

    private MenuOptionGroup<LevelSelectionGroup> levelOfPlaySelectionGroup;

    private MenuOptionGroup<LevelSelectionGroup> playerTwoStrengthSelectionGroup;

    private MenuOptionGroup<LevelSelectionGroup> playerOneStrengthSelectionGroup;

    private MenuOptionGroup<LevelSelectionGroup> playerTwoReplacementsSelectionGroup;

    private MenuOptionGroup<LevelSelectionGroup> playerOneReplacementsSelectionGroup;

    private MenuOptionGroup<LevelSelectionGroup> allianceLevelSelectionGroup;

    private Button startButton;

    private static final int GAP_BETWEEN_GROUPS_VERTICAL = 50;

    private static final int GAP_BETWEEN_GROUPS_HORIZONTAL = 50;

    private static final int START_X = 50;

    private static final int START_Y = 150;

    @Override
    public void initialise(GameContainer gc) {
	gameName = Mdx.graphics.newTexture(Mdx.files.internal("game-name.png"));

	// game options
	gameOptionGroups = new MenuOptionGroup<GameOptionGroups>(START_X, START_Y, GAP_BETWEEN_GROUPS_VERTICAL, false,
		GameOptionGroups.A, GameOptionGroups.B, GameOptionGroups.C, GameOptionGroups.D, GameOptionGroups.E,
		GameOptionGroups.F, GameOptionGroups.G, GameOptionGroups.H);
	gameOptionGroups.setSelected(GameOptionGroups.A.getMenyKey());

	int secondColumnX = START_X + 500;
	int y = START_Y;

	// player Types
	playerTypeGroup = new MenuOptionGroup<PlayerTypeGroup>(secondColumnX, y, 150, true, PlayerTypeGroup.values());
	playerTypeGroup.setSelected(PlayerTypeGroup.COMPUTER.getMenyKey());

	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	campaignTypeGroup = new MenuOptionGroup<CampaignTypeGroup>(secondColumnX, y, 150, true,
		CampaignTypeGroup.values());
	campaignTypeGroup.setSelected(CampaignTypeGroup.SCENARIO.getMenyKey());

	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	levelOfPlaySelectionGroup = new MenuOptionGroup<LevelSelectionGroup>(secondColumnX, y,
		GAP_BETWEEN_GROUPS_HORIZONTAL, true, LevelSelectionGroup.values());
	levelOfPlaySelectionGroup.setSelected(LevelSelectionGroup.THREE.getMenyKey());

	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	playerTwoStrengthSelectionGroup = new MenuOptionGroup<LevelSelectionGroup>(secondColumnX, y,
		GAP_BETWEEN_GROUPS_HORIZONTAL, true, LevelSelectionGroup.values());
	playerTwoStrengthSelectionGroup.setSelected(LevelSelectionGroup.THREE.getMenyKey());

	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	playerOneStrengthSelectionGroup = new MenuOptionGroup<LevelSelectionGroup>(secondColumnX, y,
		GAP_BETWEEN_GROUPS_HORIZONTAL, true, LevelSelectionGroup.values());
	playerOneStrengthSelectionGroup.setSelected(LevelSelectionGroup.THREE.getMenyKey());

	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	playerTwoReplacementsSelectionGroup = new MenuOptionGroup<LevelSelectionGroup>(secondColumnX, y,
		GAP_BETWEEN_GROUPS_HORIZONTAL, true, LevelSelectionGroup.values());
	playerTwoReplacementsSelectionGroup.setSelected(LevelSelectionGroup.THREE.getMenyKey());

	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	playerOneReplacementsSelectionGroup = new MenuOptionGroup<LevelSelectionGroup>(secondColumnX, y,
		GAP_BETWEEN_GROUPS_HORIZONTAL, true, LevelSelectionGroup.values());
	playerOneReplacementsSelectionGroup.setSelected(LevelSelectionGroup.THREE.getMenyKey());

	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	allianceLevelSelectionGroup = new MenuOptionGroup<LevelSelectionGroup>(secondColumnX, y,
		GAP_BETWEEN_GROUPS_HORIZONTAL, true, LevelSelectionGroup.values());
	allianceLevelSelectionGroup.setSelected(LevelSelectionGroup.THREE.getMenyKey());

	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	startButton = new Button(secondColumnX, y, "Start");

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
	g.drawTexture(gameName, (float) (Constants.SCREEN_WIDTH / 2) - (gameName.getWidth() / 2),
		(float) borderImage.getHeight() + 30);

	int widthMultiple = Constants.SCREEN_WIDTH / borderImage.getWidth();
	for (int x = 0; x < widthMultiple; x++) {
	    if (x > 0 && x < widthMultiple - 1) {
		g.drawTexture(borderImage, x * borderImage.getWidth(), 120);
	    }
	}

	gameOptionGroups.render(gc, g);
	playerTypeGroup.render(gc, g);
	campaignTypeGroup.render(gc, g);
	levelOfPlaySelectionGroup.render(gc, g);
	playerTwoStrengthSelectionGroup.render(gc, g);
	playerOneStrengthSelectionGroup.render(gc, g);
	playerTwoReplacementsSelectionGroup.render(gc, g);
	playerOneReplacementsSelectionGroup.render(gc, g);
	allianceLevelSelectionGroup.render(gc, g);
	startButton.render(g);

	g.setFont(Fonts.MAIN_FONT);
	g.setColor(Colors.CYAN());

	int firstColumnX = START_X + 30;
	int y = START_Y;
	g.drawString(") " + RESOURCES.getPlayerTwoName(), firstColumnX, y);

	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	g.drawString(") Game Selection", firstColumnX, y);
	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	g.drawString(") Level of Play", firstColumnX, y);
	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	g.drawString(") " + RESOURCES.getPlayerTwoName() + " Strength", firstColumnX, y);
	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	g.drawString(") " + RESOURCES.getPlayerOneName() + " Strength", firstColumnX, y);
	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	g.drawString(") " + RESOURCES.getPlayerTwoName() + " Replacements", firstColumnX, y);
	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	g.drawString(") " + RESOURCES.getPlayerOneName() + " Replacements", firstColumnX, y);
	y = y + GAP_BETWEEN_GROUPS_VERTICAL;
	g.drawString(") Alliance Level", firstColumnX, y);

	g.setColor(Colors.FIREBRICK());

	y = y + (GAP_BETWEEN_GROUPS_VERTICAL * 2);
	g.drawString("Select options: Use cursor keys", START_X, y);

	y = y + GAP_BETWEEN_GROUPS_VERTICAL / 2;
	g.drawString("Play game: Press <SPACE> or click START", START_X, y);

	y = y + GAP_BETWEEN_GROUPS_VERTICAL / 2;
	g.drawString("Press <ESC> or Right Click for NEW/LOAD game menu", START_X, y);
    }

    @Override
    public int getId() {
	return Screen.GAME_OPTIONS_SCREEN.getScreenId();
    }

    @Override
    public void postTransitionIn(Transition transitionIn) {
	screenTransition = false;
	screenId = 0;
	Mdx.input.setInputProcessor(new GameOptionsScreenInputAdapter());
	super.postTransitionIn(transitionIn);
    }

    @Override
    public void postTransitionOut(Transition transitionOut) {
	gameName.dispose();
	super.postTransitionOut(transitionOut);
    }

    class GameOptionsScreenInputAdapter extends InputAdapter {

	@Override
	public boolean keyDown(int keycode) {
	    if (Keys.DOWN == keycode || Keys.NUMPAD_2 == keycode) {
		gameOptionGroups.setNextMenuOption();
	    } else if (Keys.UP == keycode || Keys.NUMPAD_8 == keycode) {
		gameOptionGroups.setPrevMenuOption();
	    } else if (Keys.LEFT == keycode || Keys.NUMPAD_4 == keycode) {
		GameOptionGroups currentlySelectedOption = GameOptionGroups.valueOf(gameOptionGroups.getSelected());
		switch (currentlySelectedOption) {
		case A:
		    playerTypeGroup.setPrevMenuOption();
		    break;
		case B:
		    campaignTypeGroup.setPrevMenuOption();
		    break;
		case C:
		    levelOfPlaySelectionGroup.setPrevMenuOption();
		    break;
		case D:
		    playerTwoStrengthSelectionGroup.setPrevMenuOption();
		    break;
		case E:
		    playerOneStrengthSelectionGroup.setPrevMenuOption();
		    break;
		case F:
		    playerTwoReplacementsSelectionGroup.setPrevMenuOption();
		    break;
		case G:
		    playerOneReplacementsSelectionGroup.setPrevMenuOption();
		    break;
		case H:
		    allianceLevelSelectionGroup.setPrevMenuOption();
		    break;
		}
	    } else if (Keys.RIGHT == keycode || Keys.NUMPAD_6 == keycode) {
		GameOptionGroups currentlySelectedOption = GameOptionGroups.valueOf(gameOptionGroups.getSelected());
		switch (currentlySelectedOption) {
		case A:
		    playerTypeGroup.setNextMenuOption();
		    break;
		case B:
		    campaignTypeGroup.setNextMenuOption();
		    break;
		case C:
		    levelOfPlaySelectionGroup.setNextMenuOption();
		    break;
		case D:
		    playerTwoStrengthSelectionGroup.setNextMenuOption();
		    break;
		case E:
		    playerOneStrengthSelectionGroup.setNextMenuOption();
		    break;
		case F:
		    playerTwoReplacementsSelectionGroup.setNextMenuOption();
		    break;
		case G:
		    playerOneReplacementsSelectionGroup.setNextMenuOption();
		    break;
		case H:
		    allianceLevelSelectionGroup.setNextMenuOption();
		    break;
		}
	    } else if (Keys.SPACE == keycode) {
		// TODO: call start game logic
		// StartOptions selectedOption =
		// StartOptions.valueOf(gameOptionGroups.getSelected());
		screenTransition = true;
		screenId = Screen.MAIN_MAP_SCREEN.getScreenId();

	    } else if (Keys.ESCAPE == keycode) {
		screenTransition = true;
		screenId = Screen.START_SCREEN.getScreenId();

	    }

	    return true;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
	    System.out.println("screenX: " + screenX);
	    System.out.println("screenY: " + screenY);

	    if (button == Buttons.RIGHT) {
		screenTransition = true;
		screenId = Screen.START_SCREEN.getScreenId();
		return true;
	    } else if (button != Buttons.LEFT) {
		return true;
	    }

	    if (startButton.inside(screenX, screenY)) {
		screenTransition = true;
		screenId = Screen.MAIN_MAP_SCREEN.getScreenId();
		return true;
	    }

	    String selectedKey = gameOptionGroups.getSelectedByXY(screenX, screenY);
	    if (selectedKey != null) {
		gameOptionGroups.setSelected(selectedKey);
		return true;
	    }

	    selectedKey = playerTypeGroup.getSelectedByXY(screenX, screenY);
	    if (selectedKey != null) {
		playerTypeGroup.setSelected(selectedKey);
		return true;
	    }

	    selectedKey = campaignTypeGroup.getSelectedByXY(screenX, screenY);
	    if (selectedKey != null) {
		campaignTypeGroup.setSelected(selectedKey);
		return true;
	    }

	    selectedKey = levelOfPlaySelectionGroup.getSelectedByXY(screenX, screenY);
	    if (selectedKey != null) {
		levelOfPlaySelectionGroup.setSelected(selectedKey);
		return true;
	    }

	    selectedKey = playerTwoStrengthSelectionGroup.getSelectedByXY(screenX, screenY);
	    if (selectedKey != null) {
		playerTwoStrengthSelectionGroup.setSelected(selectedKey);
		return true;
	    }

	    selectedKey = playerOneStrengthSelectionGroup.getSelectedByXY(screenX, screenY);
	    if (selectedKey != null) {
		playerOneStrengthSelectionGroup.setSelected(selectedKey);
		return true;
	    }

	    selectedKey = playerTwoReplacementsSelectionGroup.getSelectedByXY(screenX, screenY);
	    if (selectedKey != null) {
		playerTwoReplacementsSelectionGroup.setSelected(selectedKey);
		return true;
	    }

	    selectedKey = playerOneReplacementsSelectionGroup.getSelectedByXY(screenX, screenY);
	    if (selectedKey != null) {
		playerOneReplacementsSelectionGroup.setSelected(selectedKey);
		return true;
	    }

	    selectedKey = allianceLevelSelectionGroup.getSelectedByXY(screenX, screenY);
	    if (selectedKey != null) {
		allianceLevelSelectionGroup.setSelected(selectedKey);
		return true;
	    }

	    return super.touchDown(screenX, screenY, pointer, button);
	}

    }

}
