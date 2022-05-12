package com.redteamobile.ticket.utils;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CollectionUtils {


    /**
     * 连接两个list, 生成新的list
     *
     * @param list1 list1
     * @param list2 list2
     * @param <T>
     * @return
     */
    public static <T> List<T> concat(List<T> list1, List<T> list2) {
        List<T> newList = new ArrayList<>();
        if (list1 != null) {
            newList.addAll(list1);
        }
        if (list2 != null) {
            newList.addAll(list2);
        }
        return newList;
    }


    public static List arrayToList(Object source) {
        return Arrays.asList(ObjectUtils.toObjectArray(source));
    }


    /**
     * 对list按数量进行分组
     *
     * @param list     原始list
     * @param quantity 分组大小
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> groupListByQuantity(List<T> list, int quantity) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Illegal quantity.");
        }

        List<List<T>> wrapList = new ArrayList<>();
        int count = 0;
        while (count < list.size()) {
            wrapList.add(list.subList(count, Math.min((count + quantity), list.size())));
            count += quantity;
        }

        return wrapList;
    }

    public static <T> List<T> toList(Iterator<T> iter) {
        List<T> copy = new ArrayList<T>();
        while (iter.hasNext()) {
            copy.add(iter.next());
        }
        return copy;
    }
}
