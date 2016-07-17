package com.msg.translator.model;

public enum EntryType {

	PATHS, EXTERNAL_OBJECTS, OBJECT_ATTRIBUTES, METHODS, LOCAL_OBJECTS, LOCAL_VARIABLES, GLOBAL_VARIABLES;

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
		case 6:
			return GLOBAL_VARIABLES;
		default:
			return null;
		}
	}
}
