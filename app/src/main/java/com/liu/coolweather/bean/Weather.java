package com.liu.coolweather.bean;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by LIUZICHENG on 2016/12/17.
 */

public class   Weather  extends DataSupport{


    private List<HeWeather5Entity> HeWeather5;

    public List<HeWeather5Entity> getHeWeather5() {
        return HeWeather5;
    }

    public void setHeWeather5(List<HeWeather5Entity> HeWeather5) {
        this.HeWeather5 = HeWeather5;
    }

    public static class HeWeather5Entity  {
        /**
         * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","prov":"北京","update":{"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"}}
         * now : {"cond":{"code":"104","txt":"阴"},"fl":"11","hum":"31","pcpn":"0","pres":"1025","tmp":"13","vis":"10","wind":{"deg":"40","dir":"东北风","sc":"4-5","spd":"24"}}
         * status : ok//接口状态
         */

        private BasicEntity basic;
        private NowEntity now;
        private String status;//接口状态

        public BasicEntity getBasic() {
            return basic;
        }

        public void setBasic(BasicEntity basic) {
            this.basic = basic;
        }

        public NowEntity getNow() {
            return now;
        }

        public void setNow(NowEntity now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public static class BasicEntity  {
            /**
             * city : 北京//城市名称
             * cnty : 中国 //国家
             * id : CN101010100 //城市ID
             * lat : 39.904000      //城市维度
             * lon : 116.391000    //城市经度
             * prov : 北京         //城市所属省份（仅限国内城市）
             * update : {"loc":"2016-08-31 11:52","utc":"2016-08-31 03:52"}
             */

            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
            private String prov;
            private UpdateEntity update;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public String getProv() {
                return prov;
            }

            public void setProv(String prov) {
                this.prov = prov;
            }

            public UpdateEntity getUpdate() {
                return update;
            }

            public void setUpdate(UpdateEntity update) {
                this.update = update;
            }

            public static class UpdateEntity  {
                /**
                 * loc : 2016-08-31 11:52 //当地时间
                 * utc : 2016-08-31 03:52 //UTC时间
                 */

                private String loc;
                private String utc;

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class NowEntity  {
            /**
             * cond : {"code":"104","txt":"阴"}
             * fl : 11          //体感温度
             * hum : 31         //相对湿度（%）
             * pcpn : 0         //降水量（mm）
             * pres : 1025       //气压
             * tmp : 13          //温度
             * vis : 10         //能见度（km）
             * wind : {"deg":"40","dir":"东北风","sc":"4-5","spd":"24"}//风力风向
             */

            private CondEntity cond;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            private WindEntity wind;

            public CondEntity getCond() {
                return cond;
            }

            public void setCond(CondEntity cond) {
                this.cond = cond;
            }

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

            public WindEntity getWind() {
                return wind;
            }

            public void setWind(WindEntity wind) {
                this.wind = wind;
            }

            public static class CondEntity {
                /**
                 * code : 104 //天气状况代码
                 * txt : 阴//天气状况描述
                 */

                private String code;
                private String txt;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class WindEntity {
                /**
                 * deg : 40 //风向（360度）
                 * dir : 东北风//风向
                 * sc : 4-5//风力
                 * spd : 24//风速（kmph）
                 */

                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

    }
}
