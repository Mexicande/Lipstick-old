package com.deerlive.lipstick.common;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.FragmentActivity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.LogUtils;
import com.deerlive.lipstick.MainActivity;
import com.deerlive.lipstick.MyApplication;
import com.deerlive.lipstick.R;
import com.deerlive.lipstick.activity.IntegarlCoinListActivity;
import com.deerlive.lipstick.intf.OnRequestDataListener;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/8/19.
 * Author: XuDeLong
 */
public class Api {
    public static final String APP_VER = MyApplication.getInstance().getPackageName();
    public static final String HOST = "http://doll.anwenqianbao.com/";
    public static final String OS = "android";
    public static final String QUDAO = "kuailai-two";

    public static final String OS_VER = Build.VERSION.RELEASE;
    private static final String KEY = "HZ1lERfDhUqNuUQ42PfX5lALvKlaTQxT";
    private static final String LOGIN = HOST + "Api/SiSi/sendOauthUserInfo";
    private static final String GET_BANNER = HOST + "Api/SiSi/getBanner";
    private static final String GET_GAME = HOST + "Api/SiSi/getLiveBanner";
    private static final String GET_CHANNEL_KEY = HOST + "Api/SiSi/getChannelKey";
    //帮助
    public static final String URL_GAME_HELP = HOST + "/portal/appweb/help?qudao="+QUDAO;
    //邀请
    public static final String URL_GAME_YAOQING = HOST + "/portal/appweb/my_code_hong?qudao="+QUDAO;
    //邀请码
    public static final String URL_GAME_YAOQINGMA = HOST + "/portal/appweb/input_code?qudao="+QUDAO;
    //问题反馈
    public static final String URL_GAME_FEEDBACK = HOST + "/portal/appweb/feedback?qudao="+QUDAO;
    //关于
    public static final String URL_GAME_ABOUT = HOST + "/portal/appweb/about_us?qudao="+QUDAO;
    //协议
    public static final String URL_GAME_XIEYI = HOST + "portal/page/index/id/2?qudao="+QUDAO;

    private static final String CHECK_UPDATE = HOST + "Api/SiSi/checkAndroidVer";
    private static final String ENTER_PLAYER = HOST + "Api/SiSi/enterDeviceRoom";
    private static final String GET_LATEST_DEVICE_RECORD = HOST + "Api/SiSi/getWinLogByDeviceid";
    //收货地址
    private static final String GET_SHOUHUO_LOCATION = HOST + "Api/SiSi/getAddress";
    //广告弹窗
    private static final String GET_DIALOG = HOST + "Api/SiSi/pushPopup";

    //收货地址修改和添加
    private static final String SET_SHOUHUO_LOCATION = HOST + "Api/SiSi/addAddress";
    //收货地址删除
    private static final String DELETE_ADDRESS = HOST + "Api/SiSi/delAddress";
    //抓取记录
    private static final String GET_ZHUA_RECORD = HOST + "Api/SiSi/getPlayLogByUid";
    //积分商城-兑换记录
    private static final String GET_DUI_RECORD = HOST + "Api/SiSi/convertLog";
    private static final String CONVER_APPLY = HOST + "Api/SiSi/convertApply";
    //用户心中-积分记录
    private static final String GET_INTERGATION_COIN = HOST + "Api/SiSi/intergationLog";

    private static final String GET_COIN_RECORD = HOST + "Api/SiSi/getMoneylog";
    private static final String GET_USER_INFO = HOST + "Api/SiSi/getTokenInfo";
    //充值
    private static final String GET_PAY_METHOD = HOST + "Api/SiSi/get_recharge";
    //积分商城  积分
    private static final String STORE_INTEGAR=HOST+"Api/SiSi/convertList";
    private static final String BEGIN_PAY = HOST + "Api/Pay/begin_pay";
    private static final String REQUEST_CONNECT_DEVICE = HOST + "Api/SiSi/connDeviceControl";
   // private static final String GET_NOTAKEN_WAWA = HOST + "Api/SiSi/getNotTakenWawaByUid";
    private static final String GET_NOTAKEN_WAWA = HOST + "Api/SiSi/getNotTakenWawaByToken";
    private static final String GET_MESSAGE = HOST + "Api/SiSi/pushNotice";
    //private static final String APPLY_POST_DUIHUAN_WAWA = HOST + "Api/SiSi/applyPostWawa";

    private static final String APPLY_POST_DUIHUAN_WAWA = HOST + "Api/SiSi/getPostConvert";
    public static String GET_PAY_TYPE = HOST + "Api/Appconfig/getPayType";
    private static final String GET_LAUNCH_SCREEN = HOST + "Api/SiSi/getLaunchScreen";
    public static final String UPLOAD_RECORD = HOST + "Api/SiSi/userUploadPlayVideo";
    public static void doLogin(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(LOGIN, context, params,listener);
    }
    public static void getPayType(final Context context, JSONObject params, final OnRequestDataListener listener) {
        //SFProgrssDialog dialog = SFProgrssDialog.show(context,"请稍后...");
        excutePost(GET_PAY_TYPE, context, params,listener);
    }
    public static void applyPostOrDuiHuanWaWa(final Context context, JSONObject params, final OnRequestDataListener listener) {
        newExcutePost(APPLY_POST_DUIHUAN_WAWA, context, params,listener);
    }
    //广告弹窗
    public static void getDialog(MainActivity mainActivity, HashMap<String, String> stringStringHashMap, OnRequestDataListener onRequestDataListener) {
        newExcuteMapPost(GET_DIALOG, mainActivity, stringStringHashMap,onRequestDataListener);

    }
    public static void getNoTakenWawa(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(GET_NOTAKEN_WAWA, context, params,listener);
    }

    public static void requestConnectDevice(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(REQUEST_CONNECT_DEVICE, context, params,listener);
    }
    public static void beginPay(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(BEGIN_PAY, context, params,listener);
    }

    //积分商城商品
    public static void getStoreIntegar(FragmentActivity context,  Map<String,String> params , OnRequestDataListener listener) {
        newExcuteMapPost(STORE_INTEGAR, context, params,listener);
    }
    //消息通知
    public static void getMessage(final Context context, Map<String,String> params, final OnRequestDataListener listener) {
        newExcuteMapPost(GET_MESSAGE, context, params,listener);
    }


    public static void getPayMethod(final Context context, Map<String,String> params, final OnRequestDataListener listener) {
        newExcuteMapPost(GET_PAY_METHOD, context, params,listener);
    }
    public static void getLaunchScreen(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(GET_LAUNCH_SCREEN, context, params, listener);
    }
    public static void getUserInfo(final Context context, Map<String,String> params, final OnRequestDataListener listener) {
        newExcuteMapPost(GET_USER_INFO, context, params,listener);
    }

    public static void getZhuaRecord(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(GET_ZHUA_RECORD, context, params,listener);
    }
    //积分商城兑换记录
    public static void getDuiRecord(FragmentActivity context,Map<String,String> params, OnRequestDataListener listener) {
        newExcuteMapPost(GET_DUI_RECORD, context, params,listener);
    }

    //礼物兑换
    public static void convertApply(final Context context, Map<String,String> params, final OnRequestDataListener listener) {
        newExcuteMapPost(CONVER_APPLY, context, params,listener);

    }

    // UserCenter 积分记录

    public static void getIntegarlCoinRecord(IntegarlCoinListActivity context, Map<String, String> params, OnRequestDataListener listener) {
        newExcuteMapPost(GET_INTERGATION_COIN, context, params,listener);
    }

    // 收货地址
    public static void getShouHuoLocation(final Context context, Map<String, String>  params, final OnRequestDataListener listener) {
        newExcuteMapPost(GET_SHOUHUO_LOCATION, context, params,listener);
    }
    public static void getCoinRecord(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(GET_COIN_RECORD, context, params,listener);
    }
    //收货地址修改Andtianjia

    public static void setShouHuoLocation(final Context context,Map<String, String>  params, final OnRequestDataListener listener) {
        newExcuteMapPost(SET_SHOUHUO_LOCATION, context, params,listener);
    }
    //收货地址删除
    public static void getDeleteAddress(final Context context,Map<String, String>  params, final OnRequestDataListener listener) {
        newExcuteMapPost(DELETE_ADDRESS, context, params,listener);

    }


    public static void getLatestDeviceRecord(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(GET_LATEST_DEVICE_RECORD, context, params,listener);
    }


    public static void enterPlayer(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(ENTER_PLAYER, context, params,listener);
    }

    public static void getChannelKey(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(GET_CHANNEL_KEY, context, params,listener);
    }

    public static void getBanner(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(GET_BANNER, context, params,listener);
    }

    //device banner
    public static void getGameList(final Context context, Map<String, String> params, final OnRequestDataListener listener) {
        newExcuteMapPost(GET_GAME, context, params,listener);
    }

    public static void checkUpdate(final Context context, JSONObject params, final OnRequestDataListener listener) {
        excutePost(CHECK_UPDATE, context, params, listener);
    }

    public static void uploadFile(final Context context, RequestParams params, final OnRequestDataListener listener) {
        excutePostFile(UPLOAD_RECORD, context, params, listener);
    }

    public static JSONObject getJsonObject(Context context, int statusCode, byte[] responseBody, OnRequestDataListener listener) {

        final String net_error = context.getString(R.string.net_error);
        if (statusCode == 200) {
            String response = null;
            try {
                if(responseBody != null){
                    response = new String(responseBody, "UTF-8");
                    LogUtils.i(response);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            JSONObject object = null;
            if (response != null) {
                object = JSON.parseObject(response);
            }
            return object;
        }
        return null;
    }

    protected static RequestParams getRequestParams(JSONObject params) {
        RequestParams requestParams = new RequestParams();
        Iterator<?> it = params.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            String value = (String) params.getString(key);
            requestParams.put(key, value);
        }
        return requestParams;
    }

    private static void newExcuteMapPost(String storeIntegar, Context context, Map<String,String> params, final OnRequestDataListener listener) {
        final String net_error = context.getString(R.string.net_error);

        OkGo.<String>post(storeIntegar)
                .tag(context)
                .params(params,false)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if(response.body()!=null){
                            JSONObject jsonObject = JSON.parseObject(response.body());
                            Integer code = jsonObject.getInteger("code");
                            if(code==200){
                                listener.requestSuccess(0, jsonObject);
                            }else {
                                listener.requestFailure(-1, jsonObject.getString("descrp"));
                            }
                        }else {
                            listener.requestFailure(-1, net_error);

                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        listener.requestFailure(-1, net_error);
                    }
                });


    }


    protected static void newExcutePost(String url, final Context context, JSONObject params, final OnRequestDataListener listener){
        final String net_error = context.getString(R.string.net_error);

        String s = JSON.toJSONString(params);
        OkGo.<String>post(url)
                .tag(context)
                .upJson(s)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if(response.body()!=null){
                            JSONObject jsonObject = JSON.parseObject(response.body());
                            Integer code = jsonObject.getInteger("code");
                            if(code==200){
                                listener.requestSuccess(0, jsonObject);
                            }else {
                                listener.requestFailure(-1, jsonObject.getString("descrp"));
                            }
                        }else {
                            listener.requestFailure(-1, net_error);

                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        listener.requestFailure(-1, net_error);
                    }
                });


    }

    protected static void excutePost(String url, final Context context, JSONObject params, final OnRequestDataListener listener) {
        params.put("os", OS);
        params.put("soft_ver", APP_VER);
        params.put("os_ver", OS_VER);
        params.put("qudao",QUDAO);

        //String stamp = getTime();
        //params.put("timestamp",stamp);
        //params.put("sign",getMD5(KEY+stamp));
        final String net_error = context.getString(R.string.net_error);
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(30000);
        RequestParams requestParams = getRequestParams(params);

        client.post(context, url, requestParams, new AsyncHttpResponseHandler() {
            
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    if (responseBody != null) {
                        JSONObject data = getJsonObject(context, statusCode, responseBody, listener);
                        if (data != null) {
                            if(200 == data.getIntValue("code")){
                                listener.requestSuccess(statusCode, data);
                            }else {
                                listener.requestFailure(-1, data.getString("descrp"));
                            }
                        }else{
                            listener.requestFailure(-1, net_error);
                        }
                    } else {
                        if (listener != null) {
                            listener.requestFailure(-1, net_error);
                        }
                    }
                } catch (Exception e) {
                    //listener.requestFailure(-1, net_error);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                LogUtils.d("onFailure===",statusCode);


                try {
                    if (null != context && responseBody != null) {
                        String response = "";
                        response = new String(responseBody, "UTF-8");
                        if (listener != null) {
                            listener.requestFailure(-1, net_error);
                        }
                    } else {
                        if (listener != null) {
                            listener.requestFailure(-1, net_error);
                        }
                    }
                } catch (Exception e) {

                }

            }
        });
    }


    protected static void excutePostFile(String url, final Context context, RequestParams requestParams, final OnRequestDataListener listener) {
        requestParams.put("os", OS);
        requestParams.put("soft_ver", APP_VER);
        requestParams.put("os_ver", OS_VER);
        //String stamp = getTime();
        //params.put("timestamp",stamp);
        //params.put("sign",getMD5(KEY+stamp));
        final String net_error = context.getString(R.string.net_error);
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(300000);
        client.post(context, url, requestParams, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    if (responseBody != null) {
                        JSONObject data = getJsonObject(context, statusCode, responseBody, listener);
                        if (data != null) {
                            if(200 == data.getIntValue("code")){
                                listener.requestSuccess(statusCode, data);
                            }else {
                                listener.requestFailure(-1, data.getString("descrp"));
                            }

                        }else{
                            listener.requestFailure(-1, net_error);
                        }
                    } else {
                        if (listener != null) {
                            listener.requestFailure(-1, net_error);
                        }
                    }
                } catch (Exception e) {
                    //listener.requestFailure(-1, net_error);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    if (null != context && responseBody != null) {
                        String response = "";
                        response = new String(responseBody, "UTF-8");
                        LogUtils.i("response=" + response);
                        if (listener != null) {
                            listener.requestFailure(-1, net_error);
                        }
                    } else {
                        if (listener != null) {
                            listener.requestFailure(-1, net_error);
                        }
                    }
                } catch (Exception e) {

                }

            }
        });
    }

    private static String getMD5(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
        } catch (Exception e) {
        }
        byte[] b = messageDigest.digest();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            int a = b[i];
            if (a < 0)
                a += 256;
            if (a < 16)
                buf.append("0");
            buf.append(Integer.toHexString(a));

        }
        return buf.toString();  //32位
    }

    public static String getTime() {

        long time = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳

        String str = String.valueOf(time);

        return str;

    }


}
