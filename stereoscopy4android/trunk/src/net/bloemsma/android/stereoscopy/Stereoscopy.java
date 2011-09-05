package net.bloemsma.android.stereoscopy;

/** Find an available providing class, for binding an injector e.g. */
public abstract class Stereoscopy {

	public static Class<? extends StereoscopyProvider> available3DProviderClass() {
		return LGReal3D.available ? LGReal3D.class : HTCS3D.available ? HTCS3D.class : No3D.class;
	}

	public static StereoscopyProvider available3DProvider() {
		return LGReal3D.available ? new LGReal3D() : HTCS3D.available ? new HTCS3D() : new No3D();
	}
}
