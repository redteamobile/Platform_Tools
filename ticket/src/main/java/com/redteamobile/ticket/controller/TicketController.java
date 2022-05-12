package com.redteamobile.ticket.controller;

import com.redteamobile.ticket.dto.ResponseStruct;
import com.redteamobile.ticket.request.TicketReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author: lu
 * @description:
 * @create time: 2022/5/12
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/ticket/")
public class TicketController extends BaseController{
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/list")
    public ResponseStruct list(@RequestBody TicketReq ticketReq) {
        String url="https://api.mingdao.com/v2/open/worksheet/getFilterRows";
        HttpHeaders headers=new HttpHeaders();
        HttpEntity<TicketReq> entity =new HttpEntity<>(ticketReq, headers);
        ResponseEntity<TicketReq> responseEntity = restTemplate.postForEntity(url, entity, TicketReq.class);
        return succ(responseEntity);
        }
}
