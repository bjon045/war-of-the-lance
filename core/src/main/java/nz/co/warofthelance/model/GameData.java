package nz.co.warofthelance.model;

import java.util.ArrayList;
import java.util.List;

import org.mini2Dx.core.serialization.annotation.Field;

import nz.co.warofthelance.model.country.Country;
import nz.co.warofthelance.model.hero.Hero;

public class GameData {

    @Field
    private List<Hero> playerOneHeroes = new ArrayList<>();

    @Field
    private List<Hero> playerTwoHeroes = new ArrayList<>();

    @Field
    private List<Country> neutralCountries = new ArrayList<>();

    @Field
    private List<Country> playerOneCountries = new ArrayList<>();

    @Field
    private List<Country> playerTwoCountries = new ArrayList<>();

    public List<Hero> getPlayerOneHeroes() {
	return playerOneHeroes;
    }

    public void setPlayerOneHeroes(List<Hero> playerOneHeroes) {
	this.playerOneHeroes = playerOneHeroes;
    }

    public List<Hero> getPlayerTwoHeroes() {
	return playerTwoHeroes;
    }

    public void setPlayerTwoHeroes(List<Hero> playerTwoHeroes) {
	this.playerTwoHeroes = playerTwoHeroes;
    }

    public List<Country> getNeutralCountries() {
	return neutralCountries;
    }

    public void setNeutralCountries(List<Country> neutralCountries) {
	this.neutralCountries = neutralCountries;
    }

    public List<Country> getPlayerOneCountries() {
	return playerOneCountries;
    }

    public void setPlayerOneCountries(List<Country> playerOneCountries) {
	this.playerOneCountries = playerOneCountries;
    }

    public List<Country> getPlayerTwoCountries() {
	return playerTwoCountries;
    }

    public void setPlayerTwoCountries(List<Country> playerTwoCountries) {
	this.playerTwoCountries = playerTwoCountries;
    }

}
