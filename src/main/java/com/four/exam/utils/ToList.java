package com.four.exam.utils;

import sun.applet.Main;

import java.util.*;

//把/类型的数据转化为前台需要的数据格式
public class ToList {
    public static List<Map<String,Object>> toListMap(List<Map<String,Object>> list){
        List<String[]> list1=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            for (String str : map.keySet()) {
                String str1=(String)(map.get(str));
                String[] arr=str1.split("/");
                list1.add(arr);
            }

        }
        List<String> name=new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            boolean flag=true;
            for (int i1 = 0; i1 < name.size(); i1++) {
                if(list1.get(i)[0].equals(name.get(i1))){
                    flag=false;
                }
            }
            if(flag){
                name.add(list1.get(i)[0]);
            }
        }
        List<Map<String,Object>> lis=new ArrayList<>();
        for (int i = 0; i < name.size(); i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("name",name.get(i));
            map.put("list",getStrList(name.get(i),list1));
            lis.add(map);
        }
        return lis;
    }
    public static List<String> getStrList(String name,List<String[]> list1){
        List<String> list=new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i)[0].equals(name)){
                list.add(list1.get(i)[1]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("name","java/js");
        Map<String,Object> map1=new HashMap<>();
        map1.put("name","java/js1");
        Map<String,Object> map2=new HashMap<>();
        map2.put("name","ui/cc");
        Map<String,Object> map3=new HashMap<>();
        map3.put("name","yu/pp");
        Collections.addAll(list,map,map1,map2,map3);
        System.out.println(toListMap(list));
    }
}
