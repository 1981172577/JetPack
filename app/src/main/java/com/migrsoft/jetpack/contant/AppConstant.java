package com.migrsoft.jetpack.contant;

import com.migrsoft.jetpack.BuildConfig;

/**
 * 简介:
 *
 * Created by fayou on 2017/8/22.
 */
public class AppConstant {
    public static final int DEFAULT_LAST_INDEX = -1;
    public static final String NOEE_CODE_GOODS = "999999999"; //无码商品

    public static final String HANG_MENU_CODE = "[SCXZ]{2}AM010101$";

    /**
     * 数据同步完成广播
     */
    public static final String ACTION_SYNC_FINISHED =
            BuildConfig.APPLICATION_ID + ".ACTION_SYNC_FINISHED";

    /**
     * 数据变化广播
     */
    public static final String ACTION_SALE_ORDER_CHANGED =
            BuildConfig.APPLICATION_ID + ".SALE_ORDER_CHANGED_ACTION";

    /**
     * 监控SD卡空间广播
     */
    public static final String ACTION_SDCARD_SPACE =
            BuildConfig.APPLICATION_ID + ".ACTION_SDCARD_SPACE";
    /**
     * 网络请求返回status
     */
    public static final int API_RESPONSE_SUCCESS = 1;
    public static final int API_RESPONSE_FAILED = 0;
    public static final int API_RESPONSE_ERROR = -1;

    /**
     * 收银终端分类, 每个版本都有[手持版]和 [座机pad版]
     *
     * <b>NOTE</b> 正常生鲜版对应 1 和 2 两个标记为, 判断版本时使用 0 或 3 即可.
     *
     * changed by chenRuiHua at 2018-06-06
     * 1 2 生鲜专卖版
     * 3 自助收银版
     * 4 手持收银
     * 0 商超版
     */
    public static final int TAG_LAUNCH_SUPER = 0;      // 商超版
//    public static final int TAG_LAUNCH_NORMAL = 1;     // 正常生鲜版
    public static final int TAG_LAUNCH_NORMAL = 2;     // 正常生鲜版
    public static final int TAG_LAUNCH_SELF_SERVICE = 3;   // 自助收银
    public static final int TAG_LAUNCH_MOBILE = 4;  // 手持版
    public static final int TAG_LAUNCH_SELF_WX_FACE_PAY = 6;  // 自助收银-微信刷脸

    /**
     * 手持设备, 商米 Build.MANUFACTURE.
     */
    public static final String SUNMI_MANUFACTURE = "SUNMI";
    public static final String SUNMI_BRAND = "SUNMI";


    /**
     * 分页阀值
     */
    public static final int PAGE_SIZE = 20;
    /**
     * 日期时间等静态常量
     */
    public static final String PATTERN_YEAR_MONTH_DAY_HOUR_MINUTE = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DATE = "yyyyMMdd";
    public static final String PATTERN_TIME = "HHmmss";
    public static final String PATTERN_DATE_TIME = "yyyyMMddHHmmss";

    public static final String PATTERN_YEAR_MONTH_DAY = "yyyy-MM-dd";
    public static final String START_TIME = " 00:00:00";
    public static final String END_TIME = " 23:59:59";

    public static final String PATTERN_FULL_NO_CONN = "yyyyMMddHHmmssSSS";


    //系统单据：dtype
    public static final int SYNC_126 = 126;
    //商品列表分页每次加载数量
    public static final int PRODUCT_PAGE_SIZE = 20;
    /**
     * 订单类型静态常量
     */
    public static final int BUNDLE_INT_UNKONW = -2; //未知
    public static final int BUNDLE_INT_HANGUP = -1; //挂单
    public static final int BUNDLE_INT_SALE = 0; //销售单
    public static final int BUNDLE_INT_RETURN_GOOD = 1; //退货单
    public static final int BUNDLE_INT_RETURN_CASH = 2; //退款单
    public static final int BUNDLE_INT_RETURN_GOOD_ALL = 3; //退货单-整单退
    public static final int BUNDLE_INT_RETURN_GOOD_ANY = 4; //退货单-按商品退
    public static final int BUNDLE_INT_SELF_ERROR = 5; //自助收银结算异常单据


    public static final int SALE_TYPE_WEIGHT = 1; // 计重商品

    /**
     * 外卖订单Url
     */
    public static final String WAI_MAI_BASE_URL = "http://order.saaso2o.net/";

    /**
     * 支付方式静态常量
     */
    /**
     * 现金
     */
    public static final String ACCOUNT_CASH = "204007CASH";
    /**
     * 银行卡
     */
    public static final String ACCOUNT_CRD = "204007CRD";

    /**
     * 微信支付
     */
    public static final String ACCOUNT_WECHAT = "204007WeChat";
    /**
     * 微信刷脸支付
     */
    public static final String ACCOUNT_WECHAT_FACEPAY = "204007WeChatFacePay";
    /**
     * 支付宝
     */
    public static final String ACCOUNT_ALIPAY = "204007AliPay";

    /**
     * 抹零支付
     */
    public static final String ACCOUNT_CHG = "204007CHG";
    /**
     * 优惠券
     */
    public static final String ACCOUNT_SHP = "204007SHP";
    /**
     * 储值卡
     */
    public static final String ACCOUNT_SAV = "204007SAV";
    /**
     * TODO: 银联
     */
    public static final String ACCOUNT_YINLIAN = "?";
    /**
     * 积分支付
     */
    public static final String ACCOUNT_VIP = "204007VIP";
    /**
     * 支票
     */
    public static final String ACCOUNT_CHQ = "204007CHQ";
    /**
     * 在线支付-第三方-微信
     */
    public static final String ACCOUNT_CIBPAY_WECHAT = "204007CIBPay_WeChat";

    /**
     * 在线支付-第三方-支付宝
     */
    public static final String ACCOUNT_CIBPAY_ALIPAY = "204007CIBPay_AliPay";

    /**
     * 建行支付
     */
    public static final String ACCOUNT_CCBPAY = "204007CCBPay";

    /**
     * 账户余额
     */
    public static final String ACCOUNT_MEM = "204007MEM";

    /**
     * 预留支付
     */
    public static final String ACCOUNT_SELF_PAY = "204007selfPay";
    /**
     * 字符过滤，非中文、英文、数字 和*()_-
     */
    public static final String PATTERN_CH_ENG_NUM_SYM_STRING = "[^*()_\\-/+a-zA-Z0-9\\u4E00-\\u9FA5]";
    public static final int MENU_SPAN = 6; //menu列数
    /**
     * 预留支付方式1
     */
    public static String ACCOUNT_SELF_PAY_ONE = "204007selfPay01";
    /**
     * 预留支付方式2
     */
    public static String ACCOUNT_SELF_PAY_TWO = "204007selfPay02";
    /**
     * 预留支付方式3
     */
    public static String ACCOUNT_SELF_PAY_THREE = "204007selfPay03";
    /**
     * 预留支付方式4
     */
    public static String ACCOUNT_SELF_PAY_FOUR = "204007selfPay04";
    /**
     * 预留支付方式5
     */
    public static String ACCOUNT_SELF_PAY_FIVE = "204007selfPay05";
    /**sa
     * 预留支付方式6
     */
    public static String ACCOUNT_SELF_PAY_SIX = "204007selfPay06";
    /**
     * 预留支付方式7
     */
    public static String ACCOUNT_SELF_PAY_SEVEN = "204007selfPay07";
    /**
     * 预留支付方式8
     */
    public static String ACCOUNT_SELF_PAY_EIGHT = "204007selfPay08";


    public static class FastInput {
        public static final int BAR_CODE_MAX_LENGTH = 16;
        public static final String KEY_BAR_CODE = "bar_code";
        /**
         * 请求成功
         */
        public static int FAST_INPUT_REQUEST_SUCCESS_CODE = 10;
        /**
         * 请求失败返回码
         */
        public static int FAST_INPUT_REQUEST_FAILED_CODE = 20;
        /**
         * 未查到商品
         */
        public static int FAST_INPUT_REQUEST_NO_SUCH_SKU_CODE = 30;
        /**
         * 未查到商品,但是在其他平台查到
         */
        public static int FAST_INPUT_REQUEST_FIND_IN_TAOBAO_CODE = 40;
        /**
         * 未查到商品,但是在其他平台查到
         */
        public static int FAST_INPUT_REQUEST_FIND_IN_OTHER_PLATFORM_CODE = 50;
    }

    public class SaleType {
        public static final int TYPE_ORDINARY = 0;
        public static final int TYPE_WEIGH = 1;
        public static final int TYPE_TIMEKEEP = 2;
        public static final int TYPE_COUNT = 3;

    }

    /**
     * 优惠的种类
     */
    public class Preferential {
        public static final String DISCOUNT = "折扣";
        public static final String PRESENT = "赠送";
        public static final String PROMOTION_SALE = "特价";
        public static final String BARGAIN = "议价";
        public static final String FULLMINUS= "满减";
    }

    public class KeyboardType {
        public static final int TYPE_ORDER_DISCOUNT = 1; //整单折扣
        public static final int TYPE_ERASURE_ZERO = 1 << 2; //抹零
        public static final int TYPE_SINGLE_ORDER_COUNT = 1 << 3;//单个订单数量修改
        public static final int TYPE_SINGLE_ORDER_DISCOUNT = 1 << 4;//单个订单折扣
        public static final int TYPE_SINGLE_ORDER_NEGOTIATE_PRICE = 1 << 5;//单个订单议价
        public static final int TYPE_SINGLE_ORDER_DELETE = 1 << 6;//单个订单删除
        public static final int TYPE_MENU_MEMBER = 1 << 7; //会员
        public static final int TYPE_MENU_WEIGHT = 1 << 8; //称重
    }

    public class CashierMenu extends Menu {
        public static final String HANGUP = "挂单";
        public static final String HANGOUT = "取单";
        public static final String SYNC = "同步";
        public static final String BALANCEACCOUNT = "对账";
        public static final String ORDERSEARCH = "单据查询";
        public static final String MEMBER = "关联会员";
        public static final String MEMBER_CENTER = "会员中心";
        public static final String CHANGE_PRICE = "改价";
        public static final String SHIFT_CHANGE = "交接班";
        public static final String POP_CASH_DRAWER = "弹钱箱";
        public static final String WEIGH = "称重";
        public static final String ONLINLE_ORDER = "线上订单";
        public static final String CLASSIFY_MANAGER = "分类管理";
        public static final String POP_OUT = "暂离";
    }

    public class Menu {
        public static final String MORE = "更多";
        public static final String HIDE = "收起";
    }

    public class BundleKey {
        public static final String KEY_ORDERNO = "orderNo";
        public static final String KEY_TOTALVALUE = "totalValue";
        public static final String KEY_PAYVALUE = "payValue";
        public static final String KEY_CHANGEVALUE = "changeValue";
        public static final String KEY_SALE_ORDER = "sale_order";
        public static final String KEY_MEM_NAME = "mem_name";
        public static final String KEY_MEM_PHONE = "mem_phone";
    }

    public class MenuType {
        public static final int TYPE_MENU_MORE = 1;  //菜单更多
        public static final int TYPE_MENU_HIDE = 1 << 2;//菜单收起
        public static final int TYPE_MENU_NORMAL = 0;
    }

    public class ChangePrice {
        public static final int CHANGE_PRICE_SUCCESS = 10;
        public static final int CHANGE_PRICE_FAILED = 20;


    }

    public class OnLineWaiMaiStatus {
        // onlineOrder orderFlag 状态 0.销售单 2.退款单'
        public static final int ORDER_FLAG_SELL = 0;
        public static final int ORDER_FLAG_RETURN = 2;
        // onlineOrder oderStatus 的状态  0 已提交 1待发货 2已发货 3已完成 4已取消
        public static final int ORDER_STATUS_WAIT_DETIL = 0;       // 待处理
        public static final int ORDER_STATUS_RECEIVER = 1;       // 已接单
        public static final int ORDER_STATUS_DELIVERY = 2;    // 配送中
        public static final int ORDER_STATUS_COMPLETE = 3;       // 已完成
        public static final int ORDER_STATUS_CANCELL = 4;    // 已取消

        public static final int ONLINE_ORDER_MEITUAN = 6;   // 美团外卖
        public static final int ONLINE_ORDER_E_LE_ME = 7;   // 饿了么
    }

    public class WaiMaiMQTTStatus {
        // 0新订单 1取消订单(被客户/客服取消) 2申请退款  3订单已完成(客户确认收货)
        // 10 接单 11 取消订单 12 同意退款 13 拒绝退款
        public static final int MQTT_NEW_ORDER = 0;
        public static final int MQTT_REFUND_ORDER = 2;
    }

    public class CashierPayload {
        public static final int WHOLE_ORDER_DISCOUNT = 0;
        public static final int COUNT_STEPPER = 1;
    }

    public static final int MARK_PROMO_LIMIT_NUM = -2;   //限购
    public static final int MARK_SNAPPER_UNENABLE = -1;

    public final class PromotionType {
        public static final String ALL_PRODUCT_DISCOUNT_PROMOTION = "all_product_discount_promotion";
    }

    public static final class RequestCode {
        public static final int REQUEST_HANG_OUT_CODE = 1000;//取单
    }

    public class PromoModel {
        public static final int PROMO_DISCOUNT = 3; //折扣
        public static final int PROMO_FULL_SUBTRACT = 4; //满减
        public static final int PROMO_FULL_GIFT = 5; //满赠
        public static final int PROMO_GROUP = 8; //组合促销
    }

    public class CashierType{
        public static final int INCREASE = 1; //增加
        public static final int DECREASE = 2; //减少
        public static final int NONE = 3; //无关的
        public static final int ACCRUAL = 4;//通过扫码，点击商品查找到相同商品累加修改数量
    }
}
