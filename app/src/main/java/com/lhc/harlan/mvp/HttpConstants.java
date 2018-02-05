package com.lhc.harlan.mvp;

/**
 * SmartCommunity-com.BIT.fuxingwuye.constant
 * 作者： YanwuTang
 * 时间： 2017/7/1.
 */

public class HttpConstants {
    /**
     *
     */
    public static final String test="http://t.6666ht.com/Home/Api4c/cx_knowledge";

    public static final String HTTP = "http://";
    public static final String HTTPS = "https://";

    /**
     * 端口
     */
    public static final String PORT = "38080";   //28080
    public static final String TPORT = "8080";

    /**
     * 服务器地址
     */
    // TODO: 2017/7/1
    public static final String HTTP_IP_ADDS = "192.168.1.185:";
    public static final String HTTP_IP_ADDS_TEST = "60.29.30.98:";

    /********************************************************************************
     *                                    ERROR CODE                               **
     *******************************************************************************/
    /*** 未知错误*/
    public static final int UNKNOWN = 1000;
    /*** 解析错误*/
    public static final int PARSE_ERROR = 1001;
    /*** 网络错误*/
    public static final int NETWORD_ERROR = 1002;
    /*** 协议出错*/
    public static final int HTTP_ERROR = 1003;
    /*** 证书出错*/
    public static final int SSL_ERROR = 1005;
    /*** 连接超时 */
    public static final int TIMEOUT_ERROR = 1006;
    /*** 系统异常*/
    public static final int SYSTEM_ERROR = 10001;
    /*** redis未启动*/
    public static final int REDIS_NOT_WORK = 10002;
    /*** 短信接口异常，运营商问题*/
    public static final int SMS_WRONG = 10003;
    /*** 操作失败*/
    public static final int OPERAT_FAIL = 10004;
    /*** 操作成功*/
    public static final int OPERAT_OK = 10005;
    /*** 手机号为空*/
    public static final int EMPTY_PHONE = 11001;
    /*** 密码为空*/
    public static final int EMPTY_PWD = 11002;
    /*** 验证码为空*/
    public static final int EMPTY_CODE = 11003;
    /*** 验证方式为空*/
    public static final int EMPTY_TYPE = 11004;
    /*** 验证码已发送*/
    public static final int SEND_ALREADY = 11005;
    /*** 验证码错误 */
    public static final int WRONG_CODE = 11006;
    /*** 验证码不符合该操作*/
    public static final int NOT_MATCH = 11007;
    /*** 验证码不存在或已过期*/
    public static final int CODE_OVER = 11008;
    /*** 该用户没设密码*/
    public static final int PWD_NOT_SET = 11009;
    /*** 用户不存在*/
    public static final int USER_NOT_EXIST = 11010;
    /*** token缓存失败*/
    public static final int TOKEN_WRONG = 11011;
    /*** 帐号或密码错误 */
    public static final int PWD_WRONG = 11012;
    /*** 该手机号已存在*/
    public static final int PHONE_EXIST = 11013;
    /*** 修改密码类型为空*/
    public static final int NO_PWDTYPE = 11014;
    /*** 原密码为空*/
    public static final int NO_OLDPWD = 11015;
    /*** 原密码不正确*/
    public static final int WRONG_OLDPWD = 11016;
    /*** 户主名为空*/
    public static final int EMPTY_USERNAME = 11017;
    /*** 身份证为空 */
    public static final int EMPTY_IDENTITY = 11018;

    public static final String USER = "user";
    public static final String USERID = "userId";
    public static final String TOKEN = "token";
    public static final String MOBILE = "mobilePhone";
    public static final String PASSWORD = "password";
    public static final String OWNER = "owner";
    public static final String STATUS = "identityStatus";
    public static final String USERNAME = "userName";
    public static final String DROPOUTTIME = "dropoutTime";



    public static final String GET_CODE = "/ktwlw_rest/wplot/app/common/getCode";    // 	根据手机号获取验证码
    public static final String REGISTER = "/ktwlw_rest/wplot/app/common/register";    // 	用户注册
    public static final String LOGIN = "/ktwlw_rest/wplot/app/common/login";    // 	用户登录
    public static final String CHANGE_PWD = "/ktwlw_rest/wplot/app/common/changePwd";   // 	修改密码
    public static final String REPLENISH = "/ktwlw_rest/wplot/app/common/replenish";  // 	用户信息填写
    public static final String EDITWPFLOOR = "/ktwlw_rest/wplot/app/user/editWpFloor";  // 	户主添加房产信息
    public static final String ADDHOUSSEHOLD = "/ktwlw_rest/wplot/app/user/addWpUserAffiliate";  // 	户主添加家属或租客
    public static final String DELETEHOUSSEHOLD = "/ktwlw_rest/wplot/app/user/deleteWpUserAffiliate";  // 	户主删除家属或租客
    public static final String FINDONE = "/ktwlw_rest/wplot/app/user/findOne";      //根据条件查询用户信息
    public static final String UPGRADE = "";  // 	应用升级
    public static final String VERIFY_CODE_BY_PHONE = "/ktwlw_rest/wplot/app/code/verifyCodeByPhone";  // 	手机验证码校验（验证码只能校验一次） 校验成功就删除

    /**
     * 住户信息
     */
    public static final String GET_PLOT_INFO = "/ktwlw_rest/wplot/app/user/getPlotInfo";   // 获取小区楼盘信息
    public static final String GET_CAR_INFO = "/ktwlw_rest/wplot/app/user/getCarPork";   // 获取小区车位信息
    public static final String BIND_CAR_INFO = "/ktwlw_rest/wplot/app/user/WpUserRelatPork";   // 绑定车位信息
    public static final String GET_PARK_BY_UID = "/ktwlw_rest/wplot/app/user/getParkByUserId";   // 根据用户id获取车位列表
    public static final String GET_CAR_BY_PARKID = "/ktwlw_rest/wplot/app/user/getCarByParkId";   // 根据车位ID获取车位列表
    public static final String GET_FLOORS = "/ktwlw_rest/wplot/app/user/getFloors";   // 根据用户ID获取楼房列表
    public static final String GET_USER_AFFILIATE = "/ktwlw_rest/wplot/app/user/getUserAffiliate";   // 户主获取对应楼房的家属或租客信息
    public static final String GET_NOTICES = "/ktwlw_rest/wplot/app/common/getWpNoticeList";   // 获取通知列表
    public static final String GET_NOTICE = "/ktwlw_rest/wplot/app/common/getWpNotice";   // 根据通知ID获取通知详情
    public static final String CHECK_VERSION = "/ktwlw_rest/wplot/app/common/inspectVersion";   // 检查版本号
    public static final String GET_TALIKING = "/ktwlw_rest/wplot/app/common/getTickling";   // 用户反馈
    public static final String EDIT_USER = "/ktwlw_rest/wplot/app/user/editUser";   // 修改用户信息
    public static final String GET_TEST = "/ktwlw_rest/wplot/app/common/decode";   // ceshi

    public static final String DEL_USER = "/ktwlw_rest/wplot/app/user/deleteWpUserAffiliate";   // 户主删除家属或租客信息
    public static final String DEL_FLOOR = "/ktwlw_rest/wplot/app/user/deltFloor";   // 删除楼房
    public static final String DEL_PARK = "/ktwlw_rest/wplot/app/user/deletePark";   // 删除车位
    public static final String GET_STORES = "/ktwlw_rest/wplot/app/common/getStores";   // 获取市场下载地址

    public static final String GET_REPAIRS = "/ktwlw_rest/wplot/app/faultRepair/page";   // 获取报修列表
    public static final String ADD_REPAIR = "/ktwlw_rest/wplot/app/faultRepair/add";   // 新增报修
    public static final String GET_REPAIR = "/ktwlw_rest/wplot/app/faultRepair/get";   // 获取故障详情
    public static final String UPDATE_REPAIR = "/ktwlw_rest/wplot/app/faultRepair/update";   // 修改故障详情
    public static final String DELETE_REPAIR = "/ktwlw_rest/wplot/app/faultRepair/delete";   // 删除故障申请

    public static final String ADD_EVALUATION = "/ktwlw_rest/wplot/app/evaluation/add";   // 新增评价信息
    public static final String GET_EVALUATION = "/ktwlw_rest/wplot/app/evaluation/getById";   // 获取评价信息

    public static final String GET_ELEVATOR = "/ktwlw_rest/wplot/app/elevator/getWpElevatorNo";   // 获取电梯

    public static final String UPLOAD = "/ktwlw_rest/wplot/app/file/upload";   // 文件上传
    public static final String DOWNLOAD = "/ktwlw_rest/wplot/app/file/download";   // 文件下载

    public static final String GETIMAGES = "/ktwlw_rest/wplot/app/file/getImages";   // 获取图片信息

    public static final String CALLPOLICE = "/ktwlw_rest/wplot/app/callPolice/add";   // 一键报警

    public static final String WX_PAY = "/ktwlw_rest/wplot/app/order/wx/pay";      //微信支付
    public static final String ALI_PAY = "/ktwlw_rest/wplot/app/order/ali/pay";      //支付宝支付
    public static final String WX_QUERY = "/ktwlw_rest/wplot/app/order/wx/query";      //微信查询
    public static final String ALI_QUERY = "/ktwlw_rest/wplot/app/order/ali/query";      //支付宝查询

    public static final String GET_UNPAY_LIST = "/ktwlw_rest/wplot/app/expenses/getList";      //获取未交费的消费单列表
    public static final String GET_PAY_CONTENT = "/ktwlw_rest/wplot/app/expenses/getById";      //获取消费单详细
    public static final String GET_PAY_HISTORY = "/ktwlw_rest/wplot/app/expenses/getHistoryOrder";      //获取历史消费单

    public static final String MERCHANT = "/ktwlw_rest/wplot/app/merchant/query";      //获取商家列表
    public static final String MERCHANT_GOODS = "/ktwlw_rest/wplot/app/merchant/goods";      //获取商品列表
    public static final String GET_SLIDE = "/ktwlw_rest/wplot/app/slide/list";      //获取商圈轮播图

    //社区论坛
    public static final String SAVE_INFO = "/ktwlw_rest/wplot/app/information/save";      //新增信息
    public static final String DEL_INFO = "/ktwlw_rest/wplot/app/information/delete";      //删除信息
    public static final String GET_INFO_BY_ID = "/ktwlw_rest/wplot/app/information/getById";      //获取消息明细
    public static final String QUERY_INFO_PAGE = "/ktwlw_rest/wplot/app/information/queryPage";      //消息分页
    public static final String GET_NEW_REPLIES = "/ktwlw_rest/wplot/app/information/getNewReplies";      //获取当前用户的新消息
    public static final String GET_INFO_BY_USERID = "/ktwlw_rest/wplot/app/information/getByUserId";      //获取当前用户的消息
    public static final String GET_ORDER = "/ktwlw_rest/wplot/app/information/getOrder";      //获取当前用户回复的消息
    public static final String SAVE_REPLY = "/ktwlw_rest/wplot/app/reply/save";      //新增回复
    public static final String DEL_REPLY = "/ktwlw_rest/wplot/app/reply/delete";      //删除回复
    public static final String GET_REPLY = "/ktwlw_rest/wplot/app/reply/getReply";      //获取回复当前用户的回复
    public static final String ZAN = "/ktwlw_rest/wplot/app/thumb/zan";      //点赞

    public static final String EXIST_EMCHAT = "/ktwlw_rest/wplot/app/common/existEmchat";      //环信注册
    public static final String SET_JPUSH_ALIAS = "/ktwlw_rest/wplot/app/common/setJpushAlias";      //设置极光别名

    public static final String ADD_VIA = "/ktwlw_rest/wplot/app/via/add";      //新增放行条
    public static final String GET_VIA_LIST = "/ktwlw_rest/wplot/app/via/getByUserId";      //根据用户ID获取放行条列表
    public static final String GET_VIA_CONTENT = "/ktwlw_rest/wplot/app/via/getById";      //获取放行条详细信息
    public static final String DELETE_VIA = "/ktwlw_rest/wplot/app/via/delete";      //删除放行条

    public static final String GET_DOORS = "/ktwlw_rest/wplot/app/door/page";      //获取楼栋门分页
    public static final String GET_DOOR = "/ktwlw_rest/wplot/app/door/get";      //获取楼栋门详细信息
    public static final String GET_DOOR_FACILITYS = "/ktwlw_rest/wplot/app/doorFacility/list";      //获取楼门设备列表
    public static final String GET_DOOR_FACILITY = "/ktwlw_rest/wplot/app/doorFacility/get";      //获取楼门设备详细信息
    public static final String GET_DOOR_FACILITYS_NEW = "/ktwlw_rest/wplot/app/doorFacility/newList";      //获取楼门设备列表
}
