package nz.co.warofthelance.ui.screen.gameoptions.enums;

import nz.co.warofthelance.ui.entity.menuoption.MenuKeyAndValuePair;

public enum LevelSelectionGroup implements MenuKeyAndValuePair {
    ONE("1"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5");

    private String label;

    private LevelSelectionGroup(String label) {
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
