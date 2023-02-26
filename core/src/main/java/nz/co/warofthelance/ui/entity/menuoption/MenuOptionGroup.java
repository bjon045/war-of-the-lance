package nz.co.warofthelance.ui.entity.menuoption;

import java.util.Iterator;
import java.util.TreeSet;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.geom.Rectangle;

public class MenuOptionGroup<T extends MenuKeyAndValuePair> {

    private Rectangle bounds;

    private TreeSet<MenuOption> menuOptions;

    public MenuOptionGroup(int x, int y, int gapBetweenItems, boolean isHorizontal, T... items) {
	menuOptions = new TreeSet<MenuOption>();

	int startx = x;
	int starty = y;
	int priority = 1;
	for (T t : items) {
	    MenuOption menuOption = new MenuOption(startx, starty, t.getMenyKey(), t.getMenuValue());
	    menuOption.setPriorty(priority);
	    menuOptions.add(menuOption);

	    if (isHorizontal) {
		// increment X
		startx = startx + gapBetweenItems;

	    } else {
		// increment y
		starty = starty + gapBetweenItems;
	    }
	    priority++;

	}

	if (isHorizontal) {
	    startx = startx - gapBetweenItems;
	    bounds = new Rectangle(x, y, startx, y + 100); // TODO: correct Y
	} else {
	    starty = starty - gapBetweenItems;
	    bounds = new Rectangle(x, y, x + 100, starty); // TODO: correct X
	}
    }

    public void setSelected(String selectecKey) {
	for (MenuOption mo : menuOptions) {
	    if (mo.getKey() != null && mo.getKey().equals(selectecKey)) {
		mo.setSelected(true);
	    } else {
		mo.setSelected(false);
	    }
	}
    }

    public String getSelected() {
	for (MenuOption mo : menuOptions) {
	    if (mo.isSelected()) {
		return mo.getKey();
	    }
	}
	return null;
    }

    public void setNextMenuOption() {
	Iterator<MenuOption> i = menuOptions.iterator();
	while (i.hasNext()) {
	    MenuOption mo = i.next();
	    if (mo.isSelected() && i.hasNext()) {
		mo.setSelected(false);
		MenuOption nextMenuOption = i.next();
		nextMenuOption.setSelected(true);
		return;
	    }
	}
    }

    public void setPrevMenuOption() {
	Iterator<MenuOption> i = menuOptions.iterator();
	MenuOption previousMenuOption = null;
	while (i.hasNext()) {
	    MenuOption mo = i.next();

	    if (mo.isSelected() && previousMenuOption != null) {
		mo.setSelected(false);
		previousMenuOption.setSelected(true);
		return;
	    }

	    previousMenuOption = mo;
	}
    }

    public String getSelectedByXY(int x, int y) {
	if (bounds.contains(x, y)) {
	    for (MenuOption mo : menuOptions) {
		if (mo.inside(x, y)) {
		    return mo.getKey();
		}
	    }
	}
	return null;
    }

    public void render(GameContainer gc, Graphics g) {
	for (MenuOption mo : menuOptions) {
	    mo.render(g);
	}
    }

}
