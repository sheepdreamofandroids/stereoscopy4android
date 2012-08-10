package net.bloemsma.android.stereoscopy;

/** Find an available providing class, for binding an injector e.g. */
public abstract class Stereoscopy {
	private static final StereoscopyProvider stereoscopyProvider = findStereoscopyProvider();

	/**
	 * Find an available providing class, for binding an injector e.g.
	 * 
	 * @deprecated use {@link #available3DProvider()} and bind to instance
	 * @return
	 */
	@Deprecated
	public static Class<? extends StereoscopyProvider> available3DProviderClass() {
		return stereoscopyProvider.getClass();
	}

	public static StereoscopyProvider available3DProvider() {
		return stereoscopyProvider;
	}

	private static StereoscopyProvider findStereoscopyProvider() {
		try {
			if (LGReal3D.available)
				return new LGReal3D();
		} catch (Throwable e) {
			// ignore
		}

		try {
			if (HTCS3D.available)
				return new HTCS3D();
		} catch (Throwable e) {
			// ignore
		}

		return new No3D();
	}
}
