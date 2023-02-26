package nz.co.warofthelance.ui.screen.gameoptions.enums;

import nz.co.warofthelance.ui.entity.menuoption.MenuKeyAndValuePair;

public enum PlayerTypeGroup implements MenuKeyAndValuePair {
    HUMAN("Human"), COMPUTER("Computer");

    private String label;

    private PlayerTypeGroup(String label) {
	this.label = label;
    }

    @Override
    public String getMenyKey() {
	return this.name();
    }

    @Override
    public String getMenuValue() {
	return label;
    }
}
