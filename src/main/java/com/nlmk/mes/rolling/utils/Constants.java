package com.nlmk.mes.rolling.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public final class Constants {

    public static final int MAX_YEAR = 9999;
    public static final int MAX_MONTH = 12;
    public static final int MAX_DAY = 31;
    public static final Instant MAX_INSTANT = LocalDateTime.of(MAX_YEAR, MAX_MONTH, MAX_DAY, 0, 0, 0).atZone(ZoneId.systemDefault())
            .toInstant();
    public static final int UNACCOUNTED_STATUS_CODE = 32;
    public static final int ON_AGGREGATE_STATUS_CODE = 30;
    public static final int ACTUAL_STATUS_CODE = 29;
    public static final int ATTR_REJECT_FLAG_CODE = 6630;

    public static final int CREATE_UNIT_OPERATION_CODE = 42;
    public static final int CLOSE_UNIT_OPERATION_CODE = 211;
    public static final int CHANGE_UNIT_STATUS_OPERATION_CODE = 212;
    public static final int PLACE_UNIT_OPERATION_CODE = 214;

    private Constants() {

    }
}
