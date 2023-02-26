package nz.co.warofthelance.ui.screen.start.enums;

import nz.co.warofthelance.ui.entity.menuoption.MenuKeyAndValuePair;

public enum StartOptions implements MenuKeyAndValuePair {
    NEW_GAME("New Game"), LOAD_GAME("Load Game");

    private String label;

    private StartOptions(String label) {
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
