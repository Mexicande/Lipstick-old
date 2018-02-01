package com.deerlive.zhuawawa.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2018/1/30.
 */

public class NoticeMessageBean implements Serializable{

    /**
     * code : 200
     * info : [{"title":"标题","content":"123","img":"http://local.testdoll.com/data/upload/","update_time":"1970-01-01 00:00:00"},{"title":"标题2","content":"456","img":"http://local.testdoll.com/data/upload/","update_time":"2018-01-27 00:00:00"}]
     * descrp : success
     */

    private int code;
    private String descrp;
    private List<InfoBean> info;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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
         * title : 标题
         * content : 123
         * img : http://local.testdoll.com/data/upload/
         * update_time : 1970-01-01 00:00:00
         */

        private String title;
        private String content;
        private String img;
        private String update_time;

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

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }
    }
}
