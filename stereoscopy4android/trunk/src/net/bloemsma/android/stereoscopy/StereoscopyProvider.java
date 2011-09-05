package net.bloemsma.android.stereoscopy;

import android.view.SurfaceView;

public interface StereoscopyProvider {

	boolean isAvailable();

	void setupSurface(SurfaceView surfaceView);

}
