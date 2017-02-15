package com.liu.coolweather.lenum;

/**
 * Created by LIUZICHENG on 2016/12/23.
 */

public enum WeatherCodeEnum {
    SUNNY(100, "晴", "Sunny", "http://files.heweather.com/cond_icon/100.png"),
    Cloudy(101, "多云", "Cloudy", "http://files.heweather.com/cond_icon/101.png"),
    FewClouds(102, "少云", "Few Clouds", "http://files.heweather.com/cond_icon/102.png"),
    PartlyCloudy(103, "晴间多云", "Partly Cloudy", "http://files.heweather.com/cond_icon/103.png"),
    Overcast(104, "阴", "Overcast", "http://files.heweather.com/cond_icon/104.png"),
    Windy(200, "有风", "Windy", "http://files.heweather.com/cond_icon/200.png"),
    Calm(201, "平静", "Calm", "http://files.heweather.com/cond_icon/201.png"),
    LightBreeze(202, "微风", "Light Breeze", "http://files.heweather.com/cond_icon/202.png"),
    GentleBreeze(203, "和风", "Gentle Breeze", "http://files.heweather.com/cond_icon/203.png"),
    FreshBreeze(204, "清风", "Fresh Breeze", "http://files.heweather.com/cond_icon/204.png"),
    StrongBreeze(205, "强风", "Strong Breeze", "http://files.heweather.com/cond_icon/205.png"),
    HighWind(206, "疾风", "High Wind", "http://files.heweather.com/cond_icon/206.png"),
    Gale(207, "大风", "Gale", "http://files.heweather.com/cond_icon/207.png"),
    StrongGale(208, "烈风", "Strong Gale", "http://files.heweather.com/cond_icon/208.png"),
    storm(209, "风暴", "Storm", "http://files.heweather.com/cond_icon/209.png"),
    ViolentStorm(210, "狂爆风", "Violent Storm", "http://files.heweather.com/cond_icon/210.png"),
    Hurricane(211, "飓风", "Hurricane", "http://files.heweather.com/cond_icon/211.png"),
    Tornado(212, "龙卷风", "Tornado", "http://files.heweather.com/cond_icon/212.png"),
    TropicalStorm(213, "热带风暴", "Tropical Storm", "http://files.heweather.com/cond_icon/213.png"),
    ShowerRain(300, "阵雨", "Shower Rain", "http://files.heweather.com/cond_icon/300.png"),
    HeavyShowerRain(301, "强阵雨", "Heavy Shower Rain", "http://files.heweather.com/cond_icon/301.png"),
    Thundershower(302, "雷阵雨", "Thundershower", "http://files.heweather.com/cond_icon/302.png"),
    HeavyThunderstorm(303, "强雷阵雨", "Heavy Thunderstorm", "http://files.heweather.com/cond_icon/303.png"),
    Hail(304, "雷阵雨伴有冰雹", "Hail", "http://files.heweather.com/cond_icon/304.png"),
    LightRain(305, "小雨", "Light Rain", "http://files.heweather.com/cond_icon/305.png"),
    ModerateRain(306, "中雨", "Moderate Rain", "http://files.heweather.com/cond_icon/306.png"),
    HeavyRain(307, "大雨", "Heavy Rain", "http://files.heweather.com/cond_icon/307.png"),
    ExtremeRain(308, "极端降雨", "Extreme Rain", "http://files.heweather.com/cond_icon/308.png"),
    DrizzleRain(309, "毛毛雨", "Drizzle Rain", "http://files.heweather.com/cond_icon/309.png"),
    Storm(310, "暴雨", "Storm", "http://files.heweather.com/cond_icon/310.png"),
    HeavyStorm(311, "大暴雨", "Heavy Storm", "http://files.heweather.com/cond_icon/311.png"),
    SevereStorm(312, "特大暴雨", "Severe Storm", "http://files.heweather.com/cond_icon/312.png"),
    FreezingRain(313, "冻雨", "Freezing Rain", "http://files.heweather.com/cond_icon/313.png"),
    LightSnow(400, "小雪", "Light Snow", "http://files.heweather.com/cond_icon/400.png"),
    ModerateSnow(401, "中雪", "Moderate Snow", "http://files.heweather.com/cond_icon/401.png"),
    HeavySnow(402, "大雪", "Heavy Snow", "http://files.heweather.com/cond_icon/402.png"),
    Snowstorm(403, "暴雪", "Snowstorm", "http://files.heweather.com/cond_icon/403.png"),
    Sleet(404, "雨夹雪", "Sleet", "http://files.heweather.com/cond_icon/404.png"),
    RainAndSnow(405, "雨雪天气", "Rain And Snow", "http://files.heweather.com/cond_icon/405.png"),
    ShowerSnow(406, "阵雨夹雪", "Shower Snow", "http://files.heweather.com/cond_icon/406.png"),
    SnowFlurry(407, "阵雪", "Snow Flurry", "http://files.heweather.com/cond_icon/407.png"),
    Mist(500, "薄雾", "Mist", "http://files.heweather.com/cond_icon/500.png"),
    Foggy(501, "雾", "Foggy", "http://files.heweather.com/cond_icon/501.png"),
    Haze(502, "霾", "Haze", "http://files.heweather.com/cond_icon/502.png"),
    Sand(503, "扬沙", "Sand", "http://files.heweather.com/cond_icon/503.png"),
    Dust(504, "浮尘", "Dust", "http://files.heweather.com/cond_icon/504.png"),
    Duststorm(507, "沙尘暴", "Duststorm", "http://files.heweather.com/cond_icon/507.png"),
    Sandstorm(508, "强沙尘暴", "Sandstorm", "http://files.heweather.com/cond_icon/508.png"),
    Hot(900, "热", "Hot", "http://files.heweather.com/cond_icon/900.png"),
    Cold(901, "冷", "Cold", "http://files.heweather.com/cond_icon/901.png"),
    Unknown(999, "未知", "Unknown", "http://files.heweather.com/cond_icon/999.png"),;

    private int code;
    private String zh;
    private String en;
    private String image;

    WeatherCodeEnum(int code, String zh, String en, String image) {
        this.code = code;
        this.zh = zh;
        this.en = en;
        this.image = image;
    }

    public String zhCode(int code) {
        for (WeatherCodeEnum w : WeatherCodeEnum.values()) {
            if (w.code == code) {
                return w.zh;
            }
        }
        return Unknown.zh;
    }

    public String EnCode(int code) {
        for (WeatherCodeEnum w : WeatherCodeEnum.values()) {
            if (w.code == code) {
                return w.en;
            }
        }
        return Unknown.en;
    }

    public String ImageCode(int code) {
        for (WeatherCodeEnum w : WeatherCodeEnum.values()) {
            if (w.code == code) {
                return w.image;
            }
        }
        return Unknown.image;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getZh() {
        return zh;
    }

    public void setZh(String zh) {
        this.zh = zh;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
