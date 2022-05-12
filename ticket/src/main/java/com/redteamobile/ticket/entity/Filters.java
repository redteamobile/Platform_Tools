package com.redteamobile.ticket.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: lu
 * @description:
 * @create time: 2022/5/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Filters {
    private String controlld;
    private Integer dataType;
    private Integer spliceType;
    private Integer filterType;
    private List<String> values;
    private String value;
    private Integer dateRange;
    private Integer dateRangeType;
    private String minValue;
    private String maxValue;
    private boolean isAsc;
}
