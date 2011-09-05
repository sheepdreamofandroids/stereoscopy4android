package net.bloemsma.android.stereoscopy;

import android.view.SurfaceView;

public class No3D implements StereoscopyProvider {

	public boolean isAvailable() {
		return false;
	}

	public void setupSurface(SurfaceView surfaceView) {
		// Do nothing, implemented in actual class
	}

}
