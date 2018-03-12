package com.common.utils;

import com.common.pojo.ContractEntityRequest;
import com.common.pojo.IndividualEntityRequest;
import com.common.pojo.UserEntityRequest;

import java.io.File;
import java.io.IOException;

import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by linlipin on 18/3/3.
 */

public class HttpApiUtil {

    public static final MediaType MEDIA_TYPE_IMAGE
            = MediaType.parse("image/*");

//    上传图片
    public static void uploadImage(File file, Callback callback){
        RequestBody fileBody = RequestBody.create(MEDIA_TYPE_IMAGE, file);
//        String formdata = String.format("form-data; name=\"file\";filename=\"%s\"", file.getName());
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", file.getName(), fileBody)
                .build();
        OkHttpUtil.enqueuePost("/res/file/upload",requestBody,callback);
    }

//登录
    public static void login(UserEntityRequest userEntityRequest, Callback callback){
        OkHttpUtil.enqueuePost("/login", GsonUtil.toJson(userEntityRequest), callback);
    }

//    注册
    public static void register(IndividualEntityRequest individualEntityRequest, Callback callback){
        OkHttpUtil.enqueuePost("/register/individual", GsonUtil.toJson(individualEntityRequest), callback);
    }

    public static Response register(IndividualEntityRequest individualEntityRequest) throws IOException {
        return OkHttpUtil.executePost("/register/individual", GsonUtil.toJson(individualEntityRequest));
    }

//    获取编码信息
    public static void getProductCode(String code, Callback callback){
        OkHttpUtil.enqueueGet(String.format("/qr/code/%s/info", code), callback);
    }

//    新建合同
    public static void addSellContract(ContractEntityRequest contractEntityRequest, Callback callback){
        OkHttpUtil.enqueuePost("/contract/sell", GsonUtil.toJson(contractEntityRequest), callback);
    }

//    消费者签合同
    public static void customerSignContract(Long userId, String enc_cno, Callback callback){
        OkHttpUtil.enqueuePost(String.format("/contract/customer/%d/sign/%s",userId, enc_cno),
                "", callback);
    }

//  商品保真
    public static void verifyProductCode(Long contractId, String code, Callback callback){
        OkHttpUtil.enqueuePut(String.format("/contract/%d/code/%s",contractId, code),
                "", callback);    }
    public static Response verifyProductCode(Long contractId, String code) throws IOException {
        return OkHttpUtil.executePut(String.format("/contract/%d/code/%s",contractId, code),
                "");    }

    public static void verifyEncProductCode(Long contractId, String enc_code, Callback callback){
        OkHttpUtil.enqueuePut(String.format("/contract/%d/enccode/%s",contractId, enc_code), "", callback);    }
    public static Response verifyEncProductCode(Long contractId, String enc_code) throws IOException {
        return OkHttpUtil.executePut(String.format("/contract/%d/enccode/%s",contractId, enc_code), "");    }
//    消费者验真
    public static void productCodeVerify(String code, Long userId, Callback callback){
        OkHttpUtil.enqueuePut(String.format("/product/code/%s/user/%d/verify", code, userId), "", callback);
    }

    public static Response productCodeVerify(String code, Long userId) throws IOException {
        return OkHttpUtil.executePut(String.format("/product/code/%s/user/%d/verify", code, userId),"");
    }

    public static void productEncCodeVerify(String enc_code, Long userId, Callback callback){
        OkHttpUtil.enqueuePut(String.format("/product/enccode/%s/user/%d/verify", enc_code, userId),"", callback);
    }

    public static Response productEncCodeVerify(String enc_code, Long userId) throws IOException {
        return OkHttpUtil.executePut(String.format("/product/enccode/%s/user/%d/verify", enc_code, userId),"");
    }

//      获取合同列表 -> 通过contactPart
    public static void getContractPart(Long userId, Callback callback){
        OkHttpUtil.enqueueGet(String.format("/contract/part?userId.id=%d", userId), callback);
    }

    public static void getContractPart(Long userId, int page, Callback callback){
        OkHttpUtil.enqueueGet(String.format("/contract/part/page/%d?userId.id=%d", page, userId),
                callback);
    }

//    获取验证码
    public static void getVerifyCode(String telephone, Callback callback){
        OkHttpUtil.enqueueGet(String.format("/user/telephone/%s/sms/code", telephone), callback);
    }

    public static Response getVerifyCode(String telephone) throws IOException {
        return OkHttpUtil.executeGet(String.format("/user/telephone/%s/sms/code", telephone));
    }

//    验证手机验证码
    public static void verifyCode(String telephone, String verifyCode, Callback callback){
        OkHttpUtil.enqueuePut(String.format("/user/telephone/%s/sms/code/%s",telephone, verifyCode),
                "", callback);
    }
    public static Response verifyCode(String telephone, String verifyCode) throws IOException {
        return OkHttpUtil.executePut(String.format("/user/telephone/%s/sms/code/%s",telephone, verifyCode), "");
    }


}
