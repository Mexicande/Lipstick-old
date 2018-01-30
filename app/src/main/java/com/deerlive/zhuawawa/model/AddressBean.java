package com.deerlive.zhuawawa.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by apple on 2018/1/30.
 */

public class AddressBean implements Serializable {
    /**
     * code : 200
     * addr : [{"id":"1","name":"张三","mobile":"1388888888","address":"现代城2号楼1902","status":"0","city":"北京市北京市朝阳区"}]
     * descrp : success
     */

    private int code;
    private String descrp;
    private List<AddrBean> addr;


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

    public List<AddrBean> getAddr() {
        return addr;
    }

    public void setAddr(List<AddrBean> addr) {
        this.addr = addr;
    }

    public static class AddrBean implements Serializable{
        /**
         * id : 1
         * name : 张三
         * mobile : 1388888888
         * address : 现代城2号楼1902
         * status : 0
         * city : 北京市北京市朝阳区
         */

        private String id;
        private String name;
        private String mobile;
        private String address;
        private String status;
        private String city;

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

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }
}
