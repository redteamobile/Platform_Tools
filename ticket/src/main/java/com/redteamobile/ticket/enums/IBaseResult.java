package com.redteamobile.ticket.enums;


public interface IBaseResult {
    String getCode();
    String getMessage();
    IBaseResult setMessage(String message);
}
