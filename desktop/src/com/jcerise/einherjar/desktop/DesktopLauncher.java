package com.jcerise.einherjar.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.jcerise.einherjar.EinherjarGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Einherjar";
		config.width = 1920;
		config.height = 1080;
		new LwjglApplication(new EinherjarGame(), config);
	}
}
