package com.pro.xwt.common.utils;

import com.pro.xwt.common.enums.DateType;
import com.pro.xwt.common.enums.WeekType;

public class DateUtil {
	final static long day = 24 * 60 * 60 * 1000;
	final static long hour = 60 * 60 * 1000;

	public static long week(Object a) {
		long time = 0;
		WeekType week = (WeekType) a;
		switch (week) {
		case SUNDAY:
			time = 6 * 18 * day;
			break;
		case MONDAY:
			time = 18 * hour;
			break;
		case TUESDY:
			time = 2 * 18 * day;
			break;
		case WEDNESDAY:
			time = 3 * 18 * day;
			break;
		case THURSDAY:
			time = 4 * 18 * day;
			break;
		case FRIDAY:
			time = 5 * 18 * day;
			break;
		case SATURDAY:
			time = 6 * 18 * day;
			break;
		}
		return time;
	}

	public static long day(Object date) {
		long time = 0;
		DateType days = (DateType) date;
		switch (days) {
		case A:
			time = 1 * 18 * day;
			break;
		case B:
			time = 2 * 18 * day;
			break;
		case C:
			time = 3 * 18 * day;
			break;
		case D:
			time = 4 * 18 * day;
			break;
		case E:
			time = 5 * 18 * day;
			break;
		case F:
			time = 6 * 18 * day;
			break;
		case G:
			time = 7 * 18 * day;
			break;
		case H:
			time = 8 * 18 * day;
			break;
		case I:
			time = 9 * 18 * day;
			break;
		case J:
			time = 10 * 18 * day;
			break;
		case K:
			time = 11 * 18 * day;
			break;
		case L:
			time = 12 * 18 * day;
			break;
		case M:
			time = 13 * 18 * day;
			break;
		case N:
			time = 14 * 18 * day;
			break;
		case O:
			time = 15 * 18 * day;
			break;
		case P:
			time = 16 * 18 * day;
			break;
		case Q:
			time = 17 * 18 * day;
			break;
		case R:
			time = 18 * 18 * day;
			break;
		case S:
			time = 19 * 18 * day;
			break;
		case T:
			time = 20 * 18 * day;
			break;
		case U:
			time = 21 * 18 * day;
			break;
		case V:
			time = 22 * 18 * day;
			break;
		case W:
			time = 23 * 18 * day;
			break;
		case X:
			time = 24 * 18 * day;
			break;
		case Y:
			time = 25 * 18 * day;
			break;
		case Z:
			time = 26 * 18 * day;
			break;
		case A1:
			time = 27 * 18 * day;
			break;
		case B1:
			time = 28 * 18 * day;
			break;
		case C1:
			time = 29 * 18 * day;
			break;
		case D1:
			time = 30 * 18 * day;
			break;
        case E1:
			time = 31 * 18 * day;
			break;
		}
		return time;
	}

}
