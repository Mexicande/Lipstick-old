package com.deerlive.zhuawawa.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2018/2/1.
 */

public class DeviceAndBanner implements Serializable {

    /**
     * code : 200
     * info : {"device":[{"deviceid":"10020","channel_title":"娃娃机020","channel_status":"4","price":"0","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/1v2lnevnh974ljke","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg"},{"deviceid":"10011","channel_title":"娃娃机011","channel_status":"2","price":"100","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/vijiyxpexlhosy11","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg"},{"deviceid":"10012","channel_title":"娃娃机012","channel_status":"2","price":"200","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/p8s4e4yusyuwumgt","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg"},{"deviceid":"10013","channel_title":"娃娃机013","channel_status":"2","price":"200","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/duivxjaj8gwfwjmi","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70a53dfa3e.jpg"},{"deviceid":"10018","channel_title":"娃娃机018","channel_status":"2","price":"200","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/ipfxkge5orshf1fq","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70a53dfa3e.jpg"},{"deviceid":"80015","channel_title":"娃娃机015","channel_status":"2","price":"200","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/faoh6ob2mpezfdk5","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70a53dfa3e.jpg"},{"deviceid":"80016","channel_title":"娃娃机016","channel_status":"2","price":"200","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/ogvv0pnlx7iwxcjt","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70a53dfa3e.jpg"},{"deviceid":"10014","channel_title":"娃娃机014","channel_status":"2","price":"300","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/ijpanyn1f6gzgbrq","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70ab7503a5.jpg"},{"deviceid":"10017","channel_title":"娃娃机017","channel_status":"2","price":"300","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/s98qhkslgeonwmxc","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70ab7503a5.jpg"},{"deviceid":"10019","channel_title":"娃娃机019","channel_status":"2","price":"300","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/jibwwtqfxafebeqn","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70ab7503a5.jpg"}],"descrp":"success"}
     * banner : {"pic":[{"id":"9","title":"标题","img":"http://p2mq2wa57.bkt.clouddn.com/integration/webwxgetmsgimg.jpeg"},{"id":"10","title":"标题","img":"http://p2mq2wa57.bkt.clouddn.com/integration/webwxgetmsgimg.jpeg"}],"descrp":"success"}
     * limit_end : 10
     */

    private int code;
    private InfoBean info;
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
         * device : [{"deviceid":"10020","channel_title":"娃娃机020","channel_status":"4","price":"0","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/1v2lnevnh974ljke","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg"},{"deviceid":"10011","channel_title":"娃娃机011","channel_status":"2","price":"100","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/vijiyxpexlhosy11","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg"},{"deviceid":"10012","channel_title":"娃娃机012","channel_status":"2","price":"200","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/p8s4e4yusyuwumgt","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg"},{"deviceid":"10013","channel_title":"娃娃机013","channel_status":"2","price":"200","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/duivxjaj8gwfwjmi","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70a53dfa3e.jpg"},{"deviceid":"10018","channel_title":"娃娃机018","channel_status":"2","price":"200","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/ipfxkge5orshf1fq","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70a53dfa3e.jpg"},{"deviceid":"80015","channel_title":"娃娃机015","channel_status":"2","price":"200","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/faoh6ob2mpezfdk5","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70a53dfa3e.jpg"},{"deviceid":"80016","channel_title":"娃娃机016","channel_status":"2","price":"200","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/ogvv0pnlx7iwxcjt","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70a53dfa3e.jpg"},{"deviceid":"10014","channel_title":"娃娃机014","channel_status":"2","price":"300","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/ijpanyn1f6gzgbrq","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70ab7503a5.jpg"},{"deviceid":"10017","channel_title":"娃娃机017","channel_status":"2","price":"300","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/s98qhkslgeonwmxc","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70ab7503a5.jpg"},{"deviceid":"10019","channel_title":"娃娃机019","channel_status":"2","price":"300","channel_stream":"rtmp://test.video.anwenqianbao.com/xinhe/jibwwtqfxafebeqn","vip_level":"0","thumb":"http://kuailai.deerlive.com/data/upload/20171025/59f70ab7503a5.jpg"}]
         * descrp : success
         */

        private String descrp;
        private List<DeviceBean> device;

        public String getDescrp() {
            return descrp;
        }

        public void setDescrp(String descrp) {
            this.descrp = descrp;
        }

        public List<DeviceBean> getDevice() {
            return device;
        }

        public void setDevice(List<DeviceBean> device) {
            this.device = device;
        }

        public static class DeviceBean implements Serializable{
            /**
             * deviceid : 10020
             * channel_title : 娃娃机020
             * channel_status : 4
             * price : 0
             * channel_stream : rtmp://test.video.anwenqianbao.com/xinhe/1v2lnevnh974ljke
             * vip_level : 0
             * thumb : http://kuailai.deerlive.com/data/upload/20171025/59f046881145c.jpg
             */

            private String deviceid;
            private String channel_title;
            private String channel_status;
            private String price;
            private String channel_stream;
            private String vip_level;
            private String thumb;

            public String getDeviceid() {
                return deviceid;
            }

            public void setDeviceid(String deviceid) {
                this.deviceid = deviceid;
            }

            public String getChannel_title() {
                return channel_title;
            }

            public void setChannel_title(String channel_title) {
                this.channel_title = channel_title;
            }

            public String getChannel_status() {
                return channel_status;
            }

            public void setChannel_status(String channel_status) {
                this.channel_status = channel_status;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getChannel_stream() {
                return channel_stream;
            }

            public void setChannel_stream(String channel_stream) {
                this.channel_stream = channel_stream;
            }

            public String getVip_level() {
                return vip_level;
            }

            public void setVip_level(String vip_level) {
                this.vip_level = vip_level;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }
        }
    }

    public static class BannerBean implements Serializable {
        /**
         * pic : [{"id":"9","title":"标题","img":"http://p2mq2wa57.bkt.clouddn.com/integration/webwxgetmsgimg.jpeg"},{"id":"10","title":"标题","img":"http://p2mq2wa57.bkt.clouddn.com/integration/webwxgetmsgimg.jpeg"}]
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
             * id : 9
             * title : 标题
             * img : http://p2mq2wa57.bkt.clouddn.com/integration/webwxgetmsgimg.jpeg
             */

            private String id;
            private String title;
            private String img;
            private String jump;

            public String getJump() {
                return jump;
            }

            public void setJump(String jump) {
                this.jump = jump;
            }

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
