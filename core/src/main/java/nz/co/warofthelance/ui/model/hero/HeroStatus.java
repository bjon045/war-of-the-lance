package nz.co.warofthelance.ui.model.hero;

public enum HeroStatus {

    WOUNDED("WOUNDED : NOT ON QUEST"), //
    CAPTURED("CAPTURED: NOT ON QUEST"), //
    KILLED("KILLED"), //
    WOUNDED_ON_QUEST("WOUNDED : ON QUEST"), //
    OKAY_ON_QUEST("OKAY : ON QUEST");//

    private String label;

    private HeroStatus(String label) {
	this.label = label;
    }

    public String getLabel() {
	return label;
    }

}
