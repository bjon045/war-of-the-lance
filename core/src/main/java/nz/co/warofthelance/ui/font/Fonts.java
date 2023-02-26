package nz.co.warofthelance.ui.font;

import org.mini2Dx.core.files.FileType;
import org.mini2Dx.core.font.FontBuilderGameFont;
import org.mini2Dx.core.font.FontBuilderGameFont.FontParameters;
import org.mini2Dx.core.graphics.Colors;

public final class Fonts {

    public static final FontBuilderGameFont MAIN_FONT;
    static {

	FontParameters parameter = new FontParameters();
	parameter.texturePath = "font.png";
	parameter.xmlFileHandleType = FileType.INTERNAL;
	parameter.xmlPath = "font.xml";
	MAIN_FONT = new FontBuilderGameFont(parameter);

	MAIN_FONT.loadInternal();
	MAIN_FONT.setColor(Colors.GREEN());

    }
}
