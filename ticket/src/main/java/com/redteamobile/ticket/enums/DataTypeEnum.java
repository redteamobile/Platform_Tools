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
public enum DataTypeEnum {
    TEXT(2,"文本"),
    CELLPHONE(3,"手机"),
    PHONE(4,"座机"),
    MAIL(5,"邮箱"),
    FIGURE(6,"数值"),
    CERTIFICATE(7,"证件"),
    BALANCE(8,"余额"),
    TILE_RADIO(9,"平铺单选"),
    MULTIPLE_CHOICE(10,"多选"),
    PULL_DOWN_RADIO(11,"下拉单选"),
    ATTACHMENT(14,"附件"),
    SHORT_DATE(15,"简写日期"),
    SPECIFIC_DATE(16,"具体日期"),
    PROVINCE(19,"省"),
    FREE_TO_CONNECT(21,"自由连接"),
    PIECEWISE(22,"分段"),
    PROVINCE_CITY(23,"省/市"),
    PROVINCE_CITY_COUNTY(24,"省/市/县"),
    AMOUNT_IN_WORDS(25,"大写金额"),
    MEMBERS(26,"成员"),
    DEPARTMENT(27,"部门"),
    LEVEL(28,"等级"),
    RELATIONAL_RECORD(29,"关联记录"),
    TABLE_FIELD(30,"他表字段"),
    DIGITAL_FORMULA(31,"数字公式"),
    TEXT_COMBINED(32,"文本组合"),
    AUTOMATIC_NUMBERING(33,"自动编号"),
    WORD_TABLE(34,"字表"),
    CASCADE_CHOICE(35,"级联选择"),
    CHECK_BOX(36,"检查框"),
    SUMMARY(37,"汇总"),
    DATE_FORMULA(38,"日期公式"),
    POSITIONING(40,"定位"),
    RICH_TEXT(41,"富文本"),
    SIGN(42,"签名"),
    EMBEDDED(45,"嵌入"),
    NOTE(10010,"备注");

    DataTypeEnum(Integer number, String type) {
        this.number = number;
        this.type = type;
    }

    private Integer number;
    private String type;
}
