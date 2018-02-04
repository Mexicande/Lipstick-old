package com.deerlive.zhuawawa.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2018/2/2.
 */

public class WaWaBean implements Serializable {
    /**
     * code : 200
     * info : [{"gift_id":"1","play_time":"2018-01-24 00:00:00","exchange_price":"0","name":"海绵宝宝","img":"http://local.testdoll.com/data/upload/","change":1},{"doll_id":"1","name":"哆啦A梦","img":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg","exchange_price":"100","create_time":"2017-12-14 11:47:46","num":1,"change":0},{"gift_id":"2","play_time":"1970-01-01 00:00:00","exchange_price":"0","name":"海绵宝宝","img":"http://local.testdoll.com/data/upload/","change":1}]
     * descrp : success
     */
    private String code;
    private String descrp;
    private List<InfoBean> info;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean implements Serializable{
        /**
         * gift_id : 1
         * play_time : 2018-01-24 00:00:00
         * exchange_price : 0
         * name : 海绵宝宝
         * img : http://local.testdoll.com/data/upload/
         * change : 1
         * doll_id : 1
         * create_time : 2017-12-14 11:47:46
         * num : 1
         */

        private String gift_id;
        private String play_time;
        private String exchange_price;
        private String name;
        private String img;
        private int change;
        private String doll_id;
        private String create_time;
        private int num;

        public String getGift_id() {
            return gift_id;
        }

        public void setGift_id(String gift_id) {
            this.gift_id = gift_id;
        }

        public String getPlay_time() {
            return play_time;
        }

        public void setPlay_time(String play_time) {
            this.play_time = play_time;
        }

        public String getExchange_price() {
            return exchange_price;
        }

        public void setExchange_price(String exchange_price) {
            this.exchange_price = exchange_price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getChange() {
            return change;
        }

        public void setChange(int change) {
            this.change = change;
        }

        public String getDoll_id() {
            return doll_id;
        }

        public void setDoll_id(String doll_id) {
            this.doll_id = doll_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
