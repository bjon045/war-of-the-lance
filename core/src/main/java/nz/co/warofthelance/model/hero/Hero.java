package nz.co.warofthelance.model.hero;

import org.mini2Dx.core.serialization.annotation.Field;

public class Hero {

    @Field(optional = true)
    private String name;

    @Field(optional = true)
    private int skillLevel;

    @Field(optional = true)
    private HeroStatus status = HeroStatus.OKAY_ON_QUEST;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getSkillLevel() {
	return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
	this.skillLevel = skillLevel;
    }

    public HeroStatus getStatus() {
	return status;
    }

    public void setStatus(HeroStatus status) {
	this.status = status;
    }

}
