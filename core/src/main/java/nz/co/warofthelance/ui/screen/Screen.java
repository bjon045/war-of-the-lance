package nz.co.warofthelance.ui.screen;

public enum Screen {
    INTRO_SCREEN(1), // Shows the Intro image and credits
    START_SCREEN(2), // Screen to select difficult and options
    GAME_OPTIONS_SCREEN(3), // Screen to show adventure results
    DIPLOMACY_SCREEN(4), // Screen to show Diplomacy options
    SUBVERSION_SCREEN(5), // Subersion phase screen
    MAIN_MAP_SCREEN(6); // Main map screen

    private int screenId;

    Screen(int screenId) {
	this.screenId = screenId;
    }

    public int getScreenId() {
	return screenId;
    }
}
