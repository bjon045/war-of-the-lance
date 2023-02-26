package nz.co.warofthelance.ui.screen.gameoptions.enums;

import nz.co.warofthelance.ui.entity.menuoption.MenuKeyAndValuePair;

public enum GameOptionGroups implements MenuKeyAndValuePair {
    A("A"), B("B"), C("C"), D("D"), E("E"), F("F"), G("G"), H("H");

    private String label;

    private GameOptionGroups(String label) {
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
