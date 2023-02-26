package nz.co.warofthelance.ui.entity.menuoption;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.graphics.Color;
import org.mini2Dx.core.graphics.Colors;

import nz.co.warofthelance.ui.entity.Entity;
import nz.co.warofthelance.ui.font.Fonts;

public class MenuOption extends Entity implements Comparable<Entity> {

    private static int lineHeight = (int) Fonts.MAIN_FONT.getLineHeight();

    private static int characterWidth = (int) Fonts.MAIN_FONT.getLineHeight() - 10;

    private boolean selected = false;

    private Color colour = Colors.GREEN();

    private String key;

    private String label;

    public MenuOption(int x, int y, String key, String label) {
	super(x, y, label.length() * characterWidth, lineHeight, 0);
	this.key = key;
	this.label = label;
	// setDrawBorder(true);
    }

    public boolean isSelected() {
	return selected;
    }

    public void setSelected(boolean selected) {
	this.selected = selected;
    }

    public void setColour(Color colour) {
	this.colour = colour;
    }

    @Override
    public void update(float delta) {
	// no update required
    }

    @Override
    protected void renderEntitySpecific(Graphics g) {
	super.renderEntitySpecific(g);
	g.setFont(Fonts.MAIN_FONT);
	if (isSelected()) {
	    g.setColor(Colors.MAGENTA());
	} else {
	    g.setColor(colour);
	}
	g.drawString(label, getX(), getY());
    }

    public String getKey() {
	return key;
    }

    public String getLabel() {
	return label;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((key == null) ? 0 : key.hashCode());
	result = prime * result + ((label == null) ? 0 : label.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	MenuOption other = (MenuOption) obj;
	if (key == null) {
	    if (other.key != null)
		return false;
	} else if (!key.equals(other.key))
	    return false;
	if (label == null) {
	    if (other.label != null)
		return false;
	} else if (!label.equals(other.label))
	    return false;
	return true;
    }

}
