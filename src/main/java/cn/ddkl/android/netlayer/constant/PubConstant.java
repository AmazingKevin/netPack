package cn.ddkl.android.netlayer.constant;

/**
 * 存放一些静态常量
 * 
 * @author dujianglei@kingnode.com
 */
public class PubConstant {

	public static final String SOFT_KEY = "KND_BMP";

	public static final String PLATEFORM = "android";

	public static final String APPID = "appid";

	// 定义preference文件中的各种键
	public static final String NAME_KEY = "name_key"; // 登录的账户名
	public static final String DEALERNUMBER_KEY = "dealernumber_key";
	public static final String LOGIN_NAME_KEY = "loginname_key";
	public static final String LOGIN_PWD_KEY = "loginpwd_key";
	public static final String IS_SAVE_USER_KEY = "is_save_pwd_key";
	public static final String IS_FIRST_LOGIN_KEY = "is_first_login_key";
	// public static final String SELECT_STR = "select_dealer_store_str";
	public static final String EXIT_LOGIN = "exit_login";
	public static final String EXIT_RELOGIN = "exit_relogin";
	public static final String EXTRA_NAME_EXIT_RELOGIN = "exit_relogin_extra_name";
	
	public static final String IM_CHAT_STATUS = "im_chat_status";
	public static final String IM_EVE_STATUS = "im_eve_status";

	public static final String EXTRA_STORE_NAME = "extra_stroe_name";
	public static final String EXTRA_DEALER_NAME = "extra_dealer_name";

	public static final String KILL_BY_SYSTEM = "KILL_BY_SYSTEM";

	public static final String APPHOST = "mi.kingnode.com:30000";

	public static final String BASE_URL_PRO = "/knd_xSimple";

	public static String BUILD_VERSION_TYPE = "test"; // 发布版本时候打包的key

	public static final String SEND_CONTENT = "T";// 文本
	public static final String SEND_IMAGE = "I";// 图像
	public static final String SEND_FILE = "F";
	public static final String SEND_AVI = "A"; // 录音
	public static final String SEND_IMGTEXT = "N"; // 录音

	public static final String SEND_ORIGINAL_IMAGE = "I";

	public static final String SEND_LOCATION = "PLACE"; // 位置
	public static final String SEND_LOOKEXP = "LOOKEXP"; // 表情
	// MDM 所需要的
	public static final String UPDATA_APP = "updata_app";// 强制更新
	public static final String VERSION_NUM = "version_num";// 最新的版本号;
	public static final String NEW_APP_URL = "new_app_url";// 新版本apk地址
	public static final String DOWNLOAD_APP = "download_app";// 正在下载;
	public static final String HAS_MESSAGE = "has_mesaage";// 有消息
	public static final String NOTIFICATION_TITLE = "notificationTitle";// 消息标题
	public static final String NOTIFICATION_MESSAGE = "notificationMessage";// 消息内容
	public static final String NOTIFICATION_URI = "notificationUri";// 消息url

	public static final String BROADCAST_PATH = "broadcast_path";
	public static final String APPDOWNLOAD_OK = "appinfo_download_ok";

	public static final String XMPP_LOGIN_STATE = "xmpp_login_state";
	public static final String EXTRA_IMAGE_LIST = "imagelist"; // 查看图片Intent传的key
	public static final String IMAGESPATH = "imagesPath";
	public static final String CURRENTPOSITION = "currentPosition";

	public static final String CLOUN_URL_SPF = "cloudUrl";
	public static final String CLOUN_URL_KEY = "cloudUrlKey";
	// public static final String IMMESSAGE_KEY = "bmpmessage.key";

	/**
	 * 精确到毫秒
	 */
	public static final String MS_FORMART = "yyyy-MM-dd HH:mm:ss";

	// public static final String NETWORK_STATE = "com.xmpp.net.state";
	// public static final String EXTRA_NETSTATE = "extra_netstate"; // "true"
	// 异常断开需重连接　“false”
	// 正常关闭

	public static final String LOGIN_STATE = "com.xmpp.login.state";
	public static final String LOGIN_START = "com.xmpp.login.start";

	public static final String RECONNECT_ALARM = "com.xmpp.RECONNECT_ALARM";

	public static final String FORUM_LT_URL = "http://oa.kingnode.com:8080/dis/forum.php?mod=guide&mobile=2&username=";
	public final static String AUTO_RECONNECT = "reconnect";

	public final static String USER_NAME = "USER_NAME";
	public final static String USER_PWD = "USER_PWD";

	public final static String CONTACTER_COUNT = "contacterCount";

	public final static String DEMETE_HISTORY_MESSAGE = "delete.history.message";
	public final static String UPDATE_ICON = "update.user.icon";

	public final static String TO_TOP = "to.top";
	public final static String SAVE_DRAFT = "save.draft";

}
