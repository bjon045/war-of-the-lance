package nz.co.warofthelance.ui.screen.gameoptions.enums;

import nz.co.warofthelance.ui.entity.menuoption.MenuKeyAndValuePair;

public enum CampaignTypeGroup implements MenuKeyAndValuePair {
    SCENARIO("Scenario"), CAMPAIGN("Campaign");

    private String label;

    private CampaignTypeGroup(String label) {
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
