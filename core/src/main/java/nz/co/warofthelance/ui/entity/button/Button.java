package nz.co.warofthelance.ui.entity.button;

import org.mini2Dx.core.Graphics;
import org.mini2Dx.core.graphics.Color;
import org.mini2Dx.core.graphics.Colors;

import nz.co.warofthelance.ui.entity.Entity;
import nz.co.warofthelance.ui.font.Fonts;

public class Button extends Entity {

    private static int lineHeight = (int) Fonts.MAIN_FONT.getLineHeight();

    private static int characterWidth = (int) Fonts.MAIN_FONT.getLineHeight() - 10;

    private Color colour = Colors.GREEN();

    private String label;

    public Button(int x, int y, String label) {
	super(x, y, label.length() * characterWidth, lineHeight, 0);
	this.label = label;
	setDrawBorder(true);
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
	g.setColor(colour);
	g.drawString(label, getX(), getY());
    }

}
