package cn.ddkl.android.netlayer.constant;

public class NetConstant {

	// 该字段表示资源服务器上的存盘\;根路径，不含服务器公网IP或者域名前缀（基于knd-cloud）
	public static final String KEY_MEDIA_ROOTPATH = "KEY_MEDIA_ROOTPATH";
	public static final String MEDIA_ROOTPATH_DEFAULT = "kingnod";

	public static final String ACTION_NETWORK_CHANGED = "com.kingnode.bmp.ACTION_NETWORK_CHANGED";
	public static final String NETWORK_EXTRA = "NETWORK_EXTRA"; // "true"
																	// 异常断开需重连接　“false”
																	// 正常关闭
	// xmpp重新连接
	public static final String ACTION_XMPP_RECONNECT = "com.smack.xmpp.ACTION_XMPP_RECONNECT";

	// 用户注册
	public static final String REGISTER_URL =  "/forApp/register";
	// 密码修改
	public static final String PASSWORD_UPDATE_URL =  "/forApp/updatePwd";
	// 获得一批会员用户的基本信息
	public static final String MEMBERS_GET_URL =  "/forApp/getMembers";
	// 获得所有门店的基本信息
	public static final String DEALERSTORES_GET_URL =  "/forApp/getDealerStores";
	// 获得所经销商的基本信息
	public static final String DEALERINFO_GET_URL =  "/forApp/getDealerInfo";
	// 获取快速回话
	public static final String QUICKREPLY_GET_URL =  "/forApp/getQuickReply";
	// 获得会员的基本信息　
	public static final String MEMBERINFO_GET_URL = "/forApp/getMemberInfo";
	// 更新会员用户的基本信息　
	public static final String MEMBERINFO_UPDATE_URL =  "/forApp/updateMemberInfo";
	// 版本更新
	public static final String APPVERCOMPARE_URL =  "/forApp/appVerCompare";
	// 登录请求
	public static final String LOGIN_REQUST_URL =  "/msgSyncService/login";
	// 登出请求
	public static final String LOGOUT_REQUST_URL =  "/msgSyncService/logout";
	// 注册请求
	public static final String REGISTER_REQUST_URL =  "/msgSyncService/registerReq";
	// 注册确认请求
	public static final String REGISTER_SUBMIT_REQUST_URL =  "/msgSyncService/registerSubmit";
	// 消息发送请求
	public static final String MSGSEND_REQUST_URL =  "/msgSyncService/sendMsg";
	// 获得消息请求
	public static final String MSGGET_REQUST_URL =  "/msgSyncService/getMsgs";
	// 消息回馈请求
	public static final String MSG_REPORT_REQUST_URL =  "/msgSyncService/msgReport";
	// 定义各种键
	public static final String EXTRA_XMPP_LOGIN_STATE = "EXTRA_XMPP_LOGIN_STATE";

	// 请求希望返回的会员数量
	public static final String REQUEST_MEMBER_COUNT = "50";

	// 默认请求返回的消息数量
	public static final String REQUEST_MSG_CALLBACK_COUNT = "10";
	
	/*--------------------V1.3 版本 获取头像接口------------------*/
	public static final String DEALER_LOGO_GET_RUL = "/forApp/getDealerLogoURL";


	/**测试数据接口**/
	public static final String TEST_URL = "http://apis.juhe.cn/mobile/get?";

	/**测试上传数据接口**/
	public static final String TEST_POST = "http://10.0.1.180:8080/NetTest/servlet/test";

	/**测试文件上传**/
	public static final String TEST_FILE = "http://10.0.1.180:8080/NetTest/servlet/UploadHandleServlet";
	/**测试文件下载**/
	public static final String TEST_DOWNLOAD = "http://10.0.1.180:8080/test.apk";
	/**测试图片下载**/
	public static final String TEST_DOWNLOADIMG = "http://10.0.1.180:8080/ds.jpg";

	/**用于添加分类**/
	public static final   String ADD_CATEGORY="http://devtest.kingnode.com/api/category/add";

}
