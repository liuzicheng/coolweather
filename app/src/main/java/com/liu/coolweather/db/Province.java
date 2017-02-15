package com.liu.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by LIUZICHENG on 2017/2/13.
 */

public class Province extends DataSupport {

    private int id;
    /**/
    private String name;

    //省名字
    private String provinceName;
    //省代号
    private int proviceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProviceCode() {
        return proviceCode;
    }

    public void setProviceCode(int proviceCode) {
        this.proviceCode = proviceCode;
    }
}
