package com.redteamobile.ticket.request;

import com.redteamobile.ticket.entity.Filters;
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
public class TicketReq {
    private String appKey;
    private String sign;
    private String worksheetId;
    private String viewId;
    private Integer pageSize;
    private Integer pageIndex;
    private String sortId;
    private boolean isAsc;
    private List<Filters> filters;
    private boolean notGetTotal;
    private boolean useControlld;

}
