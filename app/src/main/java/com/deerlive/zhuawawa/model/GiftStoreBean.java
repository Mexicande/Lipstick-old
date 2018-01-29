package com.deerlive.zhuawawa.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2018/1/27.
 */

public class GiftStoreBean implements Serializable {


    /**
     * code : 200
     * info : {"gift":[{"id":"1","name":"海绵宝宝","integration":"20","list_img":"http://local.testdoll.com/data/upload/"}],"descrp":"success"}
     * integrations : {"user_integration":"0"}
     * banner : {"pic":[{"id":"5","title":"海绵宝宝","img":"http://local.testdoll.com/data/upload/"}],"descrp":"success"}
     * limit_end : 1
     */

    private int code;
    private InfoBean info;
    private IntegrationsBean integrations;
    private BannerBean banner;
    private int limit_end;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public IntegrationsBean getIntegrations() {
        return integrations;
    }

    public void setIntegrations(IntegrationsBean integrations) {
        this.integrations = integrations;
    }

    public BannerBean getBanner() {
        return banner;
    }

    public void setBanner(BannerBean banner) {
        this.banner = banner;
    }

    public int getLimit_end() {
        return limit_end;
    }

    public void setLimit_end(int limit_end) {
        this.limit_end = limit_end;
    }

    public static class InfoBean implements Serializable{
        /**
         * gift : [{"id":"1","name":"海绵宝宝","integration":"20","list_img":"http://local.testdoll.com/data/upload/"}]
         * descrp : success
         */

        private String descrp;
        private List<GiftBean> gift;

        public String getDescrp() {
            return descrp;
        }

        public void setDescrp(String descrp) {
            this.descrp = descrp;
        }

        public List<GiftBean> getGift() {
            return gift;
        }

        public void setGift(List<GiftBean> gift) {
            this.gift = gift;
        }

        public static class GiftBean implements Serializable{
            /**
             * id : 1
             * name : 海绵宝宝
             * integration : 20
             * list_img : http://local.testdoll.com/data/upload/
             */

            private String id;
            private String name;
            private String integration;
            private String list_img;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIntegration() {
                return integration;
            }

            public void setIntegration(String integration) {
                this.integration = integration;
            }

            public String getList_img() {
                return list_img;
            }

            public void setList_img(String list_img) {
                this.list_img = list_img;
            }
        }
    }

    public static class IntegrationsBean implements Serializable{
        /**
         * user_integration : 0
         */

        private int user_integration;

        public int getUser_integration() {
            return user_integration;
        }

        public void setUser_integration(int user_integration) {
            this.user_integration = user_integration;
        }
    }

    public static class BannerBean implements Serializable{
        /**
         * pic : [{"id":"5","title":"海绵宝宝","img":"http://local.testdoll.com/data/upload/"}]
         * descrp : success
         */

        private String descrp;
        private List<PicBean> pic;

        public String getDescrp() {
            return descrp;
        }

        public void setDescrp(String descrp) {
            this.descrp = descrp;
        }

        public List<PicBean> getPic() {
            return pic;
        }

        public void setPic(List<PicBean> pic) {
            this.pic = pic;
        }

        public static class PicBean implements Serializable{
            /**
             * id : 5
             * title : 海绵宝宝
             * img : http://local.testdoll.com/data/upload/
             */

            private String id;
            private String title;
            private String img;

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

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
