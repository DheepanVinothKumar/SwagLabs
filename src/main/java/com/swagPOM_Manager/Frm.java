package com.swagPOM_Manager;

import com.swagReader.Configreader;

public class Frm {

	private Frm() {

	}

	private static Frm fr;

	public static Frm getInstancefrm() {
		if (fr == null) {
			fr = new Frm();
		}
		return fr;
	}

	public Configreader getInstanceConfigurationReader() {
		Configreader cf = new Configreader();
		return cf;
	}

}
