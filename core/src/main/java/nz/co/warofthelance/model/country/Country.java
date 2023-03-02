package nz.co.warofthelance.model.country;

import org.mini2Dx.core.serialization.annotation.Field;

public class Country {

    @Field(optional = true)
    private String name;

    @Field(optional = true)
    private int alignment; // AG

    @Field(optional = true)
    private AllianceLevel startingWhitestoneAllianceLevel; // AL

    @Field(optional = true)
    private AllianceLevel startingHighlordAllianceLevel; // AL

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

    public AllianceLevel getStartingWhitestoneAllianceLevel() {
	return startingWhitestoneAllianceLevel;
    }

    public void setStartingWhitestoneAllianceLevel(AllianceLevel startingWhitestoneAllianceLevel) {
	this.startingWhitestoneAllianceLevel = startingWhitestoneAllianceLevel;
    }

    public AllianceLevel getStartingHighlordAllianceLevel() {
	return startingHighlordAllianceLevel;
    }

    public void setStartingHighlordAllianceLevel(AllianceLevel startingHighlordAllianceLevel) {
	this.startingHighlordAllianceLevel = startingHighlordAllianceLevel;
    }

}
