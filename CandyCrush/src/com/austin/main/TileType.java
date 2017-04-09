package com.austin.main;

public enum TileType {
	DISABLED,		// does not hold candies, candies fall around it
	DIVERT,			// diverts candies to left and right
	NORMAL,			// holds candies
	JELLY,			// candy must be popped on tile multiple times
	BLOCKED,		// similar to NORMAL, but candies are not removed until charges are depleted
	DROPPER;		// similar to NONE, but generates candies from bottom border
}
