package nz.co.warofthelance;

import org.mini2Dx.core.serialization.annotation.Field;

public class Resource {

    @Field
    private String playerOneName;

    @Field
    private String playerTwoName;

    public String getPlayerOneName() {
	return playerOneName;
    }

    public void setPlayerOneName(String playerOneName) {
	this.playerOneName = playerOneName;
    }

    public String getPlayerTwoName() {
	return playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName) {
	this.playerTwoName = playerTwoName;
    }

}
