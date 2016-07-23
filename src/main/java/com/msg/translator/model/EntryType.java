package com.msg.translator.model;

public enum EntryType {

	PATHS, EXTERNAL_OBJECTS, OBJECT_ATTRIBUTES, METHODS, LOCAL_OBJECTS, LOCAL_VARIABLES;

	public static EntryType getEntryType(int index) {
		switch (index) {
		case 0:
			return PATHS;
		case 1:
			return EXTERNAL_OBJECTS;
		case 2:
			return OBJECT_ATTRIBUTES;
		case 3:
			return METHODS;
		case 4:
			return LOCAL_OBJECTS;
		case 5:
			return LOCAL_VARIABLES;
		default:
			return null;
		}
	}

	public static EntryType getEntryType(String line) {
		if (line.startsWith("extern path")) {
			return PATHS;
		}

		if (line.startsWith("extern object")) {
			return EXTERNAL_OBJECTS;
		}

		if (line.startsWith("data") && !line.startsWith("data int vtm_")) {
			return OBJECT_ATTRIBUTES;
		}

		if (line.startsWith("data int vtm_")) {
			return METHODS;
		}

		if (line.startsWith("object")) {
			return LOCAL_OBJECTS;
		}

		if (line.startsWith("float") || line.startsWith("int") || line.startsWith("date") || line.startsWith("bool")) {
			return LOCAL_VARIABLES;
		}

		return null;
	}
}
