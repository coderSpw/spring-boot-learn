package com.spw.dynamic.config;

public class DatasourceContextHolder {
    //线程局部变量，保证线程之间互相独立
    private static final ThreadLocal<String> holder = new ThreadLocal<>();

    public static String getDatasource() {
        return holder.get();
    }

    public static void setDatasource(String name) {
        holder.set(name);
    }
}
