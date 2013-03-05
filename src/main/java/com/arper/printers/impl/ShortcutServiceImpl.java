package com.arper.printers.impl;

import com.arper.printers.ui.ArperPrintersApp;
import com.melloware.jintellitype.HotkeyListener;

public class ShortcutServiceImpl implements HotkeyListener {
	private ArperPrintersApp arperPrintersApp; 

	public ShortcutServiceImpl(ArperPrintersApp arperPrintersApp) {
		this.arperPrintersApp = arperPrintersApp;
	}

	// listen for hotkey
	public void onHotKey(int aIdentifier) {
		this.arperPrintersApp.setVisible(true);
		
	}
}
