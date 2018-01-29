package com.deerlive.zhuawawa.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/10/30.
 * Author: XuDeLong
 */

public class PayMethod implements Serializable{
    /**
     * code : 200
     * prices : [{"id":"70","money_num":"15元","diamond_num":"1500"},{"id":"71","money_num":"25元","diamond_num":"2700"}]
     * banner : {"code":200,"pic":{"id":"6","title":"标题","img":"http://p2mq2wa57.bkt.clouddn.com/integration/webwxgetmsgimg.jpeg"},"descrp":"success"}
     * descrp : success
     */

    private int code;
    private BannerBean banner;
    private String descrp;
    private List<PricesBean> prices;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BannerBean getBanner() {
        return banner;
    }

    public void setBanner(BannerBean banner) {
        this.banner = banner;
    }

    public String getDescrp() {
        return descrp;
    }

    public void setDescrp(String descrp) {
        this.descrp = descrp;
    }

    public List<PricesBean> getPrices() {
        return prices;
    }

    public void setPrices(List<PricesBean> prices) {
        this.prices = prices;
    }

    public static class BannerBean implements Serializable{
        /**
         * code : 200
         * pic : {"id":"6","title":"标题","img":"http://p2mq2wa57.bkt.clouddn.com/integration/webwxgetmsgimg.jpeg"}
         * descrp : success
         */

        private int code;
        private PicBean pic;
        private String descrp;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public PicBean getPic() {
            return pic;
        }

        public void setPic(PicBean pic) {
            this.pic = pic;
        }

        public String getDescrp() {
            return descrp;
        }

        public void setDescrp(String descrp) {
            this.descrp = descrp;
        }

        public static class PicBean {
            /**
             * id : 6
             * title : 标题
             * img : http://p2mq2wa57.bkt.clouddn.com/integration/webwxgetmsgimg.jpeg
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

    public static class PricesBean implements Serializable{
        /**
         * id : 70
         * money_num : 15元
         * diamond_num : 1500
         */

        private String id;
        private String money_num;
        private String diamond_num;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMoney_num() {
            return money_num;
        }

        public void setMoney_num(String money_num) {
            this.money_num = money_num;
        }

        public String getDiamond_num() {
            return diamond_num;
        }

        public void setDiamond_num(String diamond_num) {
            this.diamond_num = diamond_num;
        }
    }
}
