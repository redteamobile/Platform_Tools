package com.redteamobile.ticket.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: lu
 * @description:
 * @create time: 2022/5/12
 */
@Getter
@NoArgsConstructor
public enum DateRangeEnum {
    DEFAULT(0,"Default"),
    TODAY(1,"today"),
    YESTERDAY(2,"yesterday"),
    TOMORROW(3,"tomorrow"),
    THIS_WEEK(4,"ThisWeek"),
    LAST_WEEK(5,"LastWeek"),
    NEXT_WEEK(6,"NextWeek"),
    THIS_MONTH(7,"thisMonth"),
    LAST_MONTH(8,"LastMonth"),
    NEXT_MONTH(9,"NextMonth"),
    LAST_ENUM(10,"LastEnum"),
    NEXT_ENUM(11,"NextEnum"),
    THIS_QUARTER(12,"ThisQuarter"),
    LAST_QUARTER(13,"LastQuarter"),
    NEXT_QUARTER(14,"NextQuarter"),
    THIS_YEAR(15,"ThisYear"),
    LAST_YEAR(16,"LastYear"),
    NEXT_YEAR(17,"NextYear"),
    CUSTOMIZE(18,"Customize"),
    LAST7DAY(21,"Last7Day"),
    LAST14DAY(22,"Last14Day"),
    LAST30DAY(23,"Last30Day"),
    NEXT7DAY(31,"Next7Day"),
    NEXT14DAY(32,"Next14Day"),
    NEXT33DAY(33,"Next33Day");

    DateRangeEnum(Integer number, String character) {
        this.number = number;
        this.character = character;
    }

    private Integer number;
    private String character;
}
