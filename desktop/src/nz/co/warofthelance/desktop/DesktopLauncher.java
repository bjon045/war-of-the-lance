package nz.co.warofthelance.desktop;

import com.badlogic.gdx.backends.lwjgl3.DesktopMini2DxGame;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Mini2DxConfig;

import nz.co.warofthelance.Constants;
import nz.co.warofthelance.WarOfTheLanceGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
	Lwjgl3Mini2DxConfig config = new Lwjgl3Mini2DxConfig(WarOfTheLanceGame.GAME_IDENTIFIER);
	config.useVsync(true);
	config.setWindowedMode(Constants.SCREEM_WIDTH, Constants.SCREEM_HEIGHT);
	new DesktopMini2DxGame(new WarOfTheLanceGame(), config);
    }
}
