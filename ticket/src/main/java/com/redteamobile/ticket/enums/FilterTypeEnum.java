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
public enum FilterTypeEnum {
    DEFAULT(0,"Default"),
    LIKE(1,"Like"),
    EQ(2,"Eq"),
    START(3,"Start"),
    END(4,"End"),
    NO_CONTAIN(5,"NContain"),
    NE(6,"Ne"),
    IS_NULL(7,"IsNull"),
    HAS_VALUE(8,"HasValue"),
    BETWEEN(11,"Between"),
    NO_BETWEEN(12,"NBetween"),
    GT(13,"Gt"),
    GTE(14,"Gte"),
    LT(15,"Lt"),
    LTE(16,"Lte"),
    DATE_ENUM(17,"DateEnum"),
    NO_DATE_ENUM(18,"NDateEnum"),
    MYSELF(21,"MySelf"),
    UNREAD(22,"UnRead"),
    SUB(23,"Sub"),
    RC_EQ(24,"RCEq"),
    RC_NE(25,"RENe"),
    ARR_EQ(26,"ArrEq"),
    ARR_NE(27,"ArrNe"),
    DATE_BETWEEN(31,"DateBetween"),
    DATE_NO_BETWEEN(32,"DateNBetween"),
    DATE_GT(33,"DateGt"),
    DATE_GTE(34,"DateGte"),
    DATE_LT(35,"DateLt"),
    DATE_LTE(36,"DateLte"),
    NORMAL_USER(41,"NormalUser"),
    PORTAL_USER(42,"PortalUser");

    FilterTypeEnum(Integer number, String character) {
        this.number = number;
        this.character = character;
    }

    private Integer number;
    private String character;
}
