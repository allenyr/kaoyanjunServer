package JPush;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.push.model.notification.*;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.SMS;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;

import com.google.gson.JsonObject;

public class PushExample {
    protected static final Logger LOG = LoggerFactory.getLogger(PushExample.class);

    // demo App defined in resources/jpush-api.conf 
	private static final String appKey ="2bd1d6f333d2f9001b4f854b";
	private static final String masterSecret = "bd481994798d8a8024b5ef33";
	
	public static final String TITLE = "Test from API example";
    public static final String ALERT = "Test from API Example - alert";
    public static final String MSG_CONTENT = "Test from API Example - msgContent";
    public static final String REGISTRATION_ID = "0900e8d85ef";
    public static final String TAG = "tag_api";

//	public static void main(String[] args) {
////        testSendPushWithCustomConfig();
////        testSendIosAlert();
//		testSendPush();
//	}
//	
	
    public static void testSendPush(String alert) {
	    // HttpProxy proxy = new HttpProxy("localhost", 3128);
	    // Can use this https proxy: https://github.com/Exa-Networks/exaproxy
		ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, clientConfig);
        
        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject_all_all_alert(alert);
        
        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);
            
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
	}
    
	public static void testSendPush(String alias,String alert) {
		System.out.println("alias="+alias);
		System.out.println("alert="+alert);
	    // HttpProxy proxy = new HttpProxy("localhost", 3128);
	    // Can use this https proxy: https://github.com/Exa-Networks/exaproxy
		ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, clientConfig);
        
        // For push, all you need do is to build PushPayload object.
//        PushPayload payload = buildPushObject_all_all_alert();
        PushPayload payload = buildPushObject_all_alias_alert(alias,alert);
        
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("PushResult="+result);
            LOG.info("Got result - " + result);
            
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            System.out.println("APIConnectionException="+e);
            
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            System.out.println("APIRequestException="+e);
        }
	}
	
	public static PushPayload buildPushObject_all_all_alert(String alert) {
	    return PushPayload.alertAll(alert);
	}
	
    public static PushPayload buildPushObject_all_alias_alert(String alias,String alert) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setNotification(Notification.alert(alert))
                .build();
    }
    
    public static PushPayload buildPushObject_android_tag_alertWithTitle() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.android(ALERT, TITLE, null))
                .build();
    }
    
    public static PushPayload buildPushObject_android_and_ios() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.newBuilder()
                		.setAlert("alert content")
                		.addPlatformNotification(AndroidNotification.newBuilder()
                				.setTitle("Android Title").build())
                		.addPlatformNotification(IosNotification.newBuilder()
                				.incrBadge(1)
                				.addExtra("extra_key", "extra_value").build())
                		.build())
                .build();
    }

    public static void buildPushObject_with_extra() {

        JsonObject jsonExtra = new JsonObject();
        jsonExtra.addProperty("extra1", 1);
        jsonExtra.addProperty("extra2", false);

        Map<String, String> extras = new HashMap<String, String>();
        extras.put("extra_1", "val1");
        extras.put("extra_2", "val2");

        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.tag("tag1"))
                .setNotification(Notification.newBuilder()
                        .setAlert("alert content")
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setTitle("Android Title")
                                .addExtras(extras)
                                .addExtra("booleanExtra", false)
                                .addExtra("numberExtra", 1)
                                .addExtra("jsonExtra", jsonExtra)
                                .build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .incrBadge(1)
                                .addExtra("extra_key", "extra_value").build())
                        .build())
                .build();

        System.out.println(payload.toJSON());
    }
    
    public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.tag_and("tag1", "tag_all"))
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(ALERT)
                                .setBadge(5)
                                .setSound("happy")
                                .addExtra("from", "JPush")
                                .build())
                        .build())
                 .setMessage(Message.content(MSG_CONTENT))
                 .setOptions(Options.newBuilder()
                         .setApnsProduction(true)
                         .build())
                 .build();
    }
    
    public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.newBuilder()
                        .addAudienceTarget(AudienceTarget.tag("tag1", "tag2"))
                        .addAudienceTarget(AudienceTarget.alias("alias1", "alias2"))
                        .build())
                .setMessage(Message.newBuilder()
                        .setMsgContent(MSG_CONTENT)
                        .addExtra("from", "JPush")
                        .build())
                .build();
    }

    public static void testSendPushWithCustomConfig(String alert) {
        ClientConfig config = ClientConfig.getInstance();
        // Setup the custom hostname
        config.setPushHostName("https://api.jpush.cn");

        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null, config);

        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject_all_all_alert(alert);

        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);

        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
    }

    public static void testSendIosAlert() {
        JPushClient jpushClient = new JPushClient(masterSecret, appKey);

        IosAlert alert = IosAlert.newBuilder()
        		.setTitleAndBody("test alert", "subtitle", "test ios alert json")
                .setActionLocKey("PLAY")
                .build();
        try {
            PushResult result = jpushClient.sendIosNotificationWithAlias(alert, new HashMap<String, String>(), "alias1");
            LOG.info("Got result - " + result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    public static void testSendWithSMS() {
        JPushClient jpushClient = new JPushClient(masterSecret, appKey);
        try {
            SMS sms = SMS.content("Test SMS", 10);
            PushResult result = jpushClient.sendAndroidMessageWithAlias("Test SMS", "test sms", sms, "alias1");
            LOG.info("Got result - " + result);
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

}
