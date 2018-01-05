package com.deerlive.zhuawawa.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2018/1/5.
 */

public  class Annunciate implements Serializable{

    /**
     * code : 200
     * info : [{"id":"1846","title":"欢迎来到快来抓娃娃2","content":"欢迎来到快来抓娃娃2，300金币已赠送到您的账户上","make_time":"2017-12-14 17:26:06"}]
     * limit_end : 1
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
         * id : 1846
         * title : 欢迎来到快来抓娃娃2
         * content : 欢迎来到快来抓娃娃2，300金币已赠送到您的账户上
         * make_time : 2017-12-14 17:26:06
         */

        private String id;
        private String title;
        private String content;
        private String make_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getMake_time() {
            return make_time;
        }

        public void setMake_time(String make_time) {
            this.make_time = make_time;
        }

        @Override
        public String toString() {
            return "InfoBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    ", make_time='" + make_time + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Annunciate{" +
                "code=" + code +
                ", limit_end=" + limit_end +
                ", descrp='" + descrp + '\'' +
                ", info=" + info +
                '}';
    }
}
