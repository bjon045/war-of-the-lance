package nz.co.warofthelance.model;

import java.util.ArrayList;
import java.util.List;

import org.mini2Dx.core.serialization.annotation.Field;

import nz.co.warofthelance.model.country.Country;
import nz.co.warofthelance.model.hero.Hero;

public class GameData {

    @Field
    private List<Hero> whitestoneHeroes = new ArrayList<>();

    @Field
    private List<Hero> highlordHeroes = new ArrayList<>();

    @Field
    private List<Country> neutralCountries = new ArrayList<>();

    @Field
    private List<Country> whitestoneCountries = new ArrayList<>();

    @Field
    private List<Country> highlordCountries = new ArrayList<>();

    public List<Hero> getWhiteStoneHeroes() {
	return whitestoneHeroes;
    }

    public void setWhiteStoneHeroes(List<Hero> heroes) {
	this.whitestoneHeroes = heroes;
    }

    public List<Hero> getHighlordHeroes() {
	return highlordHeroes;
    }

    public void setHighlordHeroes(List<Hero> highlordHeroes) {
	this.highlordHeroes = highlordHeroes;
    }

}
