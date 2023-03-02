package nz.co.warofthelance;

import org.mini2Dx.core.Mdx;
import org.mini2Dx.core.exception.SerializationException;

public class GameContext {

    public static final Resource RESOURCES;
    static {
	try {
	    RESOURCES = Mdx.json.fromJson(Mdx.files.internal("resources.json"), Resource.class);
	} catch (SerializationException e) {
	    throw new RuntimeException(e);
	}
    }

}
