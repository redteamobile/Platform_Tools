package com.redteamobile.ticket.shanghaidianxin;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 字段是否格式化为map
 * value 有值时则表示调用JsonUtils.parseToMap 的时候将该字段以及值不会加入到Map中
 * 主要是为了针对电信的签名接口
 */
@Target({METHOD,TYPE,FIELD})
@Retention(RUNTIME)
public @interface TelecomAnnotation {
    String value() default "";
}
