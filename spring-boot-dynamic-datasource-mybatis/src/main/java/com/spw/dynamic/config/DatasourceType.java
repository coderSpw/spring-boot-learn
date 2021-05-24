package com.spw.dynamic.config;

public enum DatasourceType {
    /**
     * 主库
     */
    master("master"),
    /**
     * 从库
     */
    slave("slave");

    private String name;

    DatasourceType(String name) {
        this.name = name;
    }

}
