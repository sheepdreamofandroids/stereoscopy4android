package net.bloemsma.android.stereoscopy;

import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.htc.view.DisplaySetting;

public class HTCS3D implements StereoscopyProvider {
	public static final boolean available = detectS3D();

	private static boolean detectS3D() {
		try {
			HTCS3D.class.getClassLoader().loadClass("com.htc.view.DisplaySetting");
			return true;
		} catch (Throwable e) {
			// Ignore
		}
		return false;
	}

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public void setupSurface(SurfaceView glSurface) {
		try {
			glSurface.getHolder().setType(SurfaceHolder.SURFACE_TYPE_GPU);
			boolean formatResult = DisplaySetting.setStereoscopic3DFormat(
				glSurface.getHolder().getSurface(),
				true ? DisplaySetting.STEREOSCOPIC_3D_FORMAT_SIDE_BY_SIDE : DisplaySetting.STEREOSCOPIC_3D_FORMAT_OFF);
			if (!formatResult)
				Log.e("HTC S3D", "Couldn't format stereoscopic");
		} catch (NoClassDefFoundError e) {
		} catch (UnsatisfiedLinkError usle) {
		}
	}
}
