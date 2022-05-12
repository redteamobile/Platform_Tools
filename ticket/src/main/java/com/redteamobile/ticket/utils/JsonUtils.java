package com.redteamobile.ticket.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.redteamobile.ticket.shanghaidianxin.TelecomAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * 序列化类
 *
 * @author zhengdiwen
 */
@Slf4j
public class JsonUtils {

    private static final ObjectMapper OM = new ObjectMapper();
    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
//            .registerTypeAdapter(DateTime.class, new SimpleDateTimeFormatDeserializer(dateTimeFormat))
            .create();
    static {
        // 对象的所有字段全部列入，还是其他的选项，可以忽略null等
        OM.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        // 忽略空Bean转json的错误
        OM.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        OM.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 忽略未知属性，防止json字符串中存在，java对象中不存在对应属性的情况出现错误
        OM.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 对象 => json字符串
     *
     * @param obj 源对象
     */
    public static <T> String toJson(T obj) {
        String json = null;
        if (obj != null) {
            try {
                json = OM.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return json;
    }
    public static <T> T fromJson(String str, Class<T> cls) {
        if (str == null) {
            return null;
        }
        try {
            if(cls == String.class){
                return (T) str;
            }
            return gson.fromJson(str, cls);
        } catch (Exception e) {
            return null;
        }
    }
    /**
     * json字符串 => 对象
     *
     * @param json 源json串
     * @param clazz 对象类
     * @param <T> 泛型
     */
    public static <T> T parse(String json, Class<T> clazz) {
        return parse(json, clazz, null);
    }

    /**
     * json字符串 => 对象
     *
     * @param json 源json串
     * @param type 对象类型
     * @param <T>  泛型
     */
    public static <T> T parse(String json, TypeReference<T> type) {
        return parse(json, null, type);
    }


    /**
     * json => 对象处理方法
     * <br>
     * 参数clazz和type必须一个为null，另一个不为null
     * <br>
     * 此方法不对外暴露，访问权限为private
     *
     * @param json 源json串
     * @param clazz 对象类
     * @param type 对象类型
     * @param <T> 泛型
     */
    private static <T> T parse(String json, Class<T> clazz, TypeReference<T> type) {
        T obj = null;
        if (!StringUtils.isEmpty(json)) {
            try {
                if (clazz != null) {
                    obj = OM.readValue(json, clazz);
                } else {
                    obj = OM.readValue(json, type);
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalArgumentException(e.getMessage());
            }
        }
        return obj;
    }

    public static <T> T mapToBean(Map<String, Object> map, Class<T> clazz) {
        if (MapUtils.isEmpty(map)) {
            return null;
        }
        String actionAsJsonStr = toJson(map);
        if (StringUtils.isEmpty(actionAsJsonStr)) {
            return null;
        }
        return parse(actionAsJsonStr, clazz);
    }

    public static Map<String, Object> beanToMap(Object bean) {
        if (bean == null) {
            return null;
        }
        if (bean instanceof Map) {
            return (Map<String, Object>) bean;
        }
        String actionResponseAsJsonStr = toJson(bean);
        if (StringUtils.isEmpty(actionResponseAsJsonStr)) {
            return null;
        }
        return parse(actionResponseAsJsonStr, new TypeReference<Map<String, Object>>(){});
    }

    public static JsonNode toJsonNode(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return OM.readTree(toJson(obj));
        } catch (Exception e) {
            log.warn("JSON.toJsonNode error", e);
            return null;
        }
    }

    public static Map<String, String> toStringMap(Object obj) {
        JsonNode jsonNode = toJsonNode(obj);
        if (jsonNode == null) {
            return null;
        }
        Map<String, String> map = new HashMap<>();

        List<Entry<String, JsonNode>> entries = CollectionUtils.toList((jsonNode).fields());
        List<JsonNode> list = CollectionUtils.toList(jsonNode.elements());
        entries.stream().forEach(item -> {
            map.put(item.getKey(), item.getValue().textValue());
        });
        return map;
    }
    /**
     *
     * @param obj
     * @return
     */
    public static Map<String, String> parseToMap(Object obj) {
        JsonNode jsonNode = toJsonNode(obj);
        Field[] fields = obj.getClass().getFields();
        List<String> filedList = new ArrayList<>();
        for(Field field : fields) {
            boolean fieldHasAnnotation = field.isAnnotationPresent(TelecomAnnotation.class);
            if (fieldHasAnnotation) {
                TelecomAnnotation annotation = field.getAnnotation(TelecomAnnotation.class);
                if (!Objects.isNull(annotation) && !Strings.isNullOrEmpty(annotation.value())) {
                    filedList.add(annotation.value());
                }
            }
        }
        if (jsonNode == null) {
            return null;
        }
        Map<String, String> map = new HashMap<>();
        List<Entry<String, JsonNode>> entries = CollectionUtils.toList((jsonNode).fields());
        List<JsonNode> list = CollectionUtils.toList(jsonNode.elements());
        entries.stream().forEach(item -> {
            if (!filedList.contains(item.getKey())){
                map.put(item.getKey(), item.getValue().textValue());
            }
        });
        return map;
    }

}
