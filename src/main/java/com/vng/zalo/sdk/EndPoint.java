/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vng.zalo.sdk;

/**
 * ZALO API ENDPOINT
 *
 * @author linhndh
 */
public class EndPoint {

    /* OFFICAL ACCOUNT API ENDPOINT */
    /**
     * Send message
     */
    public static String OA_SEND_MESSAGE = String.format("%s/%s/oa/message",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Get user profile
     */
    public static final String OA_GET_USER_PROFILE = String.format("%s/%s/oa/getprofile",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Get OA profile
     */
    public static final String OA_GET_OFFICIAL_ACCOUNT_PROFILE = String.format("%s/%s/oa/getoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Get followers
     */
    public static final String OA_GET_FOLLOWERS = String.format("%s/%s/oa/getfollowers",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Get list recent chat
     */
    public static final String OA_GET_RECENT_CHAT = String.format("%s/%s/oa/listrecentchat",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Get list conversation
     */
    public static final String OA_GET_CONVERSATION_WITH_USER = String.format("%s/%s/oa/conversation",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Upload photo
     */
    public static String OA_UPLOAD_PHOTO = String.format("%s/%s/oa/upload/image",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Upload gif photo
     */
    public static String OA_UPLOAD_GIF_PHOTO = String.format("%s/%s/oa/upload/gif",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Get slice tag
     */
    public static String OA_GET_SLICE_TAG = String.format("%s/%s/oa/tag/gettagsofoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Remove tag
     */
    public static String OA_REMOVE_TAG = String.format("%s/%s/oa/tag/rmtag",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Remove user from tag
     */
    public static String OA_REMOVE_USER_FROM_TAG = String.format("%s/%s/oa/tag/rmfollowerfromtag",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Tag user
     */
    public static String OA_TAG_USER = String.format("%s/%s/oa/tag/tagfollower",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Get message status
     */
    public static final String OA_GET_MESSAGE_STATUS = String.format("%s/%s/getmessagestatus",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * Setting menu OA
     */
    public static final String OA_SET_MENU_OF_OA = String.format("%s/%s/oa/menu",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    /**
     * update follower info
     */
    public static String OA_CREATE_QRCODE = String.format("%s/%s/oa/updatefollowerinfo",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    
    /*                                                     ARTICLE API 
     *
     * Get link upload
     */
    public static String OA_ARTICLE_UPLOAD_VIDEO = String.format("%s/%s/article/upload_video/preparevideo",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get video id
     */
    public static String OA_ARTICLE_GET_VIDEO_ID = String.format("%s/%s/article/upload_video/verify",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Create article
     */
    public static String OA_ARTICLE_CREATE_ARTICLE = String.format("%s/%s/article/create",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Update article
     */
    public static String OA_ARTICLE_UPDATE_ARTICLE = String.format("%s/%s/article/update",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Remove article
     */
    public static String OA_ARTICLE_REMOVE_ARTICLE = String.format("%s/%s/article/remove",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice article
     */
    public static String OA_ARTICLE_GET_SLICE = String.format("%s/%s/article/getslice",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    
    /**
     * Get slice article
     */
    public static String OA_ARTICLE_GET_DETAIL = String.format("%s/%s/article/getdetail",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get article id from token
     */
    public static String OA_ARTICLE_GET_ARTICLE_ID = String.format("%s/%s/article/verify",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

   
    /**
     * OA STORE API
     **/
    
    /**
     * Get slice attribute
     */
    public static String OA_STORE_GET_SLICE_ATTR = String.format("%s/%s/store/product/getsliceattribute",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    
    /**
     * Get attribute
     */
    public static String OA_STORE_GET_ATTR = String.format("%s/%s/store/product/getattribute",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Create attribute
     */
    public static String OA_STORE_CREATE_ATTR = String.format("%s/%s/store/product/createattribute",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    
    /**
     * Create attribute type
     */
    public static String OA_STORE_CREATE_ATTR_TYPE = String.format("%s/%s/store/product/createattributetype",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice attribute type
     */
    public static String OA_STORE_GET_SLICE_ATTR_TYPE = String.format("%s/%s/store/product/getsliceattributetype",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Create product
     */
    public static String OA_STORE_CREATE_PRODUCT = String.format("%s/%s/store/product/create",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Update product
     */
    public static String OA_STORE_UPDATE_PRODUCT = String.format("%s/%s/store/product/update",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);
    
    /**
     * Get product
     */
    public static String OA_STORE_GET_PRODUCT_INFO = String.format("%s/%s/store/product/getproduct",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice product
     */
    public static String OA_STORE_GET_SLICE_PRODUCT = String.format("%s/%s/store/product/getproductofoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Create category
     */
    public static String OA_STORE_CREATE_CATEGORY = String.format("%s/%s/store/category/create",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Update category
     */
    public static String OA_STORE_UPDATE_CATEGORY = String.format("%s/%s/store/category/update",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice category
     */
    public static String OA_STORE_GET_SLICE_CATEGORY = String.format("%s/%s/store/category/getcategoryofoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Upload store photo
     */
    public static String OA_STORE_UPLOAD_PHOTO = String.format("%s/%s/store/upload/photo",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Create order
     */
    public static String OA_STORE_CREATE_ORDER = String.format("%s/%s/store/order/create",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Update order
     */
    public static String OA_STORE_UPDATE_ORDER = String.format("%s/%s/store/order/update",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get slice order
     */
    public static String OA_STORE_GET_SLICE_ORDER = String.format("%s/%s/store/order/getorderofoa",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get order info
     */
    public static String OA_STORE_GET_ORDER_INFO = String.format("%s/%s/store/order/getorder",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

    /**
     * Get industry
     */
    public static String OA_STORE_GET_INDUSTRY = String.format("%s/%s/store/getindustry",
            APIConfig.DEFAULT_OA_API_BASE, APIConfig.DEFAULT_OA_API_VERSION);

}
