package net.bloemsma.android.stereoscopy;

import android.view.SurfaceView;

import com.lge.real3d.Real3D;
import com.lge.real3d.Real3DInfo;

public class LGReal3D implements StereoscopyProvider {
	public static final boolean available = detectReal3D();

	@Override
	public boolean isAvailable() {
		return available;
	}

	private static boolean detectReal3D() {
		try {
			LGReal3D.class.getClassLoader().loadClass("com.lge.real3d.Real3D");
			return true;
		} catch (ClassNotFoundException e) {
			// ignore
		}
		return false;
	}

	@Override
	public void setupSurface(SurfaceView surfaceView) {
		if (available) {
			com.lge.real3d.Real3D mReal3D = new Real3D(surfaceView.getHolder());
			mReal3D.setReal3DInfo(new Real3DInfo(true, Real3D.REAL3D_TYPE_SS, Real3D.REAL3D_ORDER_LR));
		}
	}
}
