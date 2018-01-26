package com.deerlive.zhuawawa.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2018/1/26.
 */

public class GrabBean implements Serializable{

    /**
     * code : 200
     * info : [{"doll_id":"26","name":"哆啦A梦","img":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg","exchange_price":"100","play_time":"2017-12-22 16:14:27","num":1},{"doll_id":"19","name":"哆啦A梦","img":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg","exchange_price":"100","play_time":"2017-12-22 15:18:36","num":1},{"doll_id":"28","name":"哆啦A梦","img":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg","exchange_price":"100","play_time":"2017-12-14 16:29:02","num":1},{"doll_id":"27","name":"哆啦A梦","img":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg","exchange_price":"100","play_time":"2017-12-14 16:21:29","num":1},{"doll_id":"25","name":"哆啦A梦","img":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg","exchange_price":"100","play_time":"2017-12-14 16:12:56","num":1},{"doll_id":"24","name":"哆啦A梦","img":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg","exchange_price":"100","play_time":"2017-12-14 16:10:49","num":1},{"doll_id":"23","name":"哆啦A梦","img":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg","exchange_price":"100","play_time":"2017-12-14 16:04:10","num":1},{"doll_id":"22","name":"哆啦A梦","img":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg","exchange_price":"100","play_time":"2017-12-14 16:01:51","num":1},{"doll_id":"21","name":"哆啦A梦","img":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg","exchange_price":"100","play_time":"2017-12-14 16:00:47","num":1}]
     * all_num : 9
     * not_token_num : 9
     * limit_end : 9
     * descrp : 获取成功
     */

    private int code;
    private int all_num;
    private int not_token_num;
    private int limit_end;
    private String token;
    private String descrp;
    private List<InfoBean> info;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAll_num() {
        return all_num;
    }

    public void setAll_num(int all_num) {
        this.all_num = all_num;
    }

    public int getNot_token_num() {
        return not_token_num;
    }

    public void setNot_token_num(int not_token_num) {
        this.not_token_num = not_token_num;
    }

    public int getLimit_end() {
        return limit_end;
    }

    public void setLimit_end(int limit_end) {
        this.limit_end = limit_end;
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
         * doll_id : 26
         * name : 哆啦A梦
         * img : http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg
         * exchange_price : 100
         * play_time : 2017-12-22 16:14:27
         * num : 1
         */
        private int remoteUid;
        private String gift_id;
        private String doll_id;
        private String name;
        private String img;
        private String exchange_price;
        private String play_time;
        private int  change;
        private int num;

        public int getChange() {
            return change;
        }

        public void setChange(int change) {
            this.change = change;
        }

        public int getRemoteUid() {
            return remoteUid;
        }

        public void setRemoteUid(int remoteUid) {
            this.remoteUid = remoteUid;
        }

        public String getGift_id() {
            return gift_id;
        }

        public void setGift_id(String gift_id) {
            this.gift_id = gift_id;
        }

        public String getDoll_id() {
            return doll_id;
        }

        public void setDoll_id(String doll_id) {
            this.doll_id = doll_id;
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

        public String getExchange_price() {
            return exchange_price;
        }

        public void setExchange_price(String exchange_price) {
            this.exchange_price = exchange_price;
        }

        public String getPlay_time() {
            return play_time;
        }

        public void setPlay_time(String play_time) {
            this.play_time = play_time;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
