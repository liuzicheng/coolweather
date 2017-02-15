package com.liu.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by LIUZICHENG on 2016/12/26.
 */

public class NowEnity extends DataSupport {

    private String fl;
    private String hum;
    private String pcpn;
    private String pres;
    private String tmp;
    private String vis;
//    private Weather.HeWeather5Entity.NowEntity.WindEntity wind;
//    private Weather.HeWeather5Entity.NowEntity.CondEntity cond;


    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getPcpn() {
        return pcpn;
    }

    public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }

    public String getVis() {
        return vis;
    }

    public void setVis(String vis) {
        this.vis = vis;
    }
}
