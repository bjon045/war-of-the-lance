package nz.co.warofthelance.model.country;

import org.mini2Dx.core.serialization.annotation.Field;

public class Country {

    @Field
    private String name;

    @Field(optional = true)
    private int alignment; // AG

    @Field(optional = true)
    private AllianceLevel playerOneAllianceLevel; // AL

    @Field(optional = true)
    private AllianceLevel playerTwoAllianceLevel; // AL

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getAlignment() {
	return alignment;
    }

    public void setAlignment(int alignment) {
	this.alignment = alignment;
    }

    public AllianceLevel getPlayerOneAllianceLevel() {
	return playerOneAllianceLevel;
    }

    public void setPlayerOneAllianceLevel(AllianceLevel playerOneAllianceLevel) {
	this.playerOneAllianceLevel = playerOneAllianceLevel;
    }

    public AllianceLevel getPlayerTwoAllianceLevel() {
	return playerTwoAllianceLevel;
    }

    public void setPlayerTwoAllianceLevel(AllianceLevel playerTwoAllianceLevel) {
	this.playerTwoAllianceLevel = playerTwoAllianceLevel;
    }

}
