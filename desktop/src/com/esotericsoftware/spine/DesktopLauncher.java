package com.esotericsoftware.spine;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Window;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3WindowListener;
import com.badlogic.gdx.files.FileHandle;

import java.awt.*;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	final static String version = "3.8.99.1 (Support Drop Files)";

	static float getDpi() {
		String os = System.getProperty("os.name");
		float dpiScale = 1;

		if (os.contains("Windows")) {
			dpiScale = (float) Toolkit.getDefaultToolkit().getScreenResolution() / 96;
		}
		else if (os.contains("OS X")) {
			// TODO: real dpi
			return 1;
		}

		return dpiScale;
	}

	public static void main (String[] args) {
		SkeletonViewer.args = args;
		SkeletonViewer.uiScale = getDpi();

		SkeletonViewer viewer = new SkeletonViewer();

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("Skeleton Viewer - " + version);
		config.setWindowedMode((int) (800 * SkeletonViewer.uiScale), (int) (600 * SkeletonViewer.uiScale));
		config.setWindowListener(new Lwjgl3WindowListener() {
			@Override
			public void created(Lwjgl3Window window) {}

			@Override
			public void iconified(boolean isIconified) {}

			@Override
			public void maximized(boolean isMaximized) {}

			@Override
			public void focusLost() {}

			@Override
			public void focusGained() {}

			@Override
			public boolean closeRequested() { return true; }

			@Override
			public void filesDropped(String[] files) {
				if (files.length < 1)  return;

				FileHandle skeletonFile = null;
				for (String file : files) {
					for (String ext : SkeletonViewer.dataSuffixes) {
						if (!file.isEmpty() && file.endsWith(ext)) {
							FileHandle f = Gdx.files.getFileHandle(file, Files.FileType.Absolute);
							if (!f.isDirectory() && f.exists()) {
								skeletonFile = f;
								viewer.ui.toast("Drop: " + f.path());
								break;
							}
						}
					}
				}

				if (skeletonFile == null) return;
				viewer.loadSkeleton(skeletonFile);
			}

			@Override
			public void refreshRequested() {}
		});

		new Lwjgl3Application(viewer, config);
	}
}
