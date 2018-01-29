package com.deerlive.zhuawawa.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2018/1/29.
 */

public class ZhuaRecordBean implements Serializable{

    /**
     * code : 200
     * info : [{"create_time":"1970-01-01 00:00:00","status":"1","name":"海绵宝宝","list_img":"http://local.testdoll.com/data/upload/"},{"create_time":"1970-01-01 00:00:00","status":"0","name":"海绵宝宝","list_img":"http://local.testdoll.com/data/upload/"}]
     * limit_end : 2
     * descrp : success
     */

    private int code;
    private int limit_end;
    private String descrp;
    private List<InfoBean> info;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
         * create_time : 1970-01-01 00:00:00
         * status : 1
         * name : 海绵宝宝
         * list_img : http://local.testdoll.com/data/upload/
         */

        private String create_time;
        private String status;
        private String name;
        private String list_img;

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getList_img() {
            return list_img;
        }

        public void setList_img(String list_img) {
            this.list_img = list_img;
        }
    }
}
