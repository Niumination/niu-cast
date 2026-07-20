package com.transsion.message.cast;

import ag.q;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.cast.analytics.AnalyticsManager;
import com.transsion.message.cast.analytics.p000const.EAnalyticsParams;
import com.transsion.message.cast.notification.NotificationFactory;
import com.transsion.message.cast.notification.SmsReplyDispatcher;
import com.transsion.message.cast.notification.i.CallHandler;
import com.transsion.message.cast.notification.i.NotificationInterface;
import com.transsion.message.cast.notification.i.SmsNotificationInterface;
import com.transsion.message.cast.notification.impl.CallNotificationImpl;
import com.transsion.message.cast.transfer.TransferServiceManager;
import com.transsion.message.cast.transfer.data.CallInfo;
import com.transsion.message.cast.transfer.data.SmsInfo;
import com.transsion.message.cast.transfer.e.EAudioOutput;
import com.transsion.message.cast.transfer.i.TransferServiceListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lc.a;
import li.k;
import o.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0016J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002J\u0012\u0010\"\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010#\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0002J\u0010\u0010)\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0002J\u0018\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0011H\u0002J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00100\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u0011H\u0002J\u0010\u00102\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0011H\u0002J\u0010\u00103\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0011H\u0002J\u0018\u00104\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00112\u0006\u00105\u001a\u000206H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/transsion/message/cast/MessageCastService;", "Landroid/app/Service;", "<init>", "()V", "mNotificationManager", "Lcom/transsion/message/cast/notification/i/NotificationInterface;", "mSmsNotificationManager", "Lcom/transsion/message/cast/notification/i/SmsNotificationInterface;", "mIntentDataHandler", "Lcom/transsion/message/cast/IntentDataHandler;", "mTransferServiceManager", "Lcom/transsion/message/cast/transfer/TransferServiceManager;", "mCallNotificationImpl", "Lcom/transsion/message/cast/notification/impl/CallNotificationImpl;", "mCallHandler", "Lcom/transsion/message/cast/notification/i/CallHandler;", "mDid", "", "mDeviceName", "mMoDel", "onCreate", "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", "initializeComponents", "initializeNotificationManagers", "initializeHandlers", "setupSmsReplyDispatcher", "handleIncomingIntent", "handleTrackerData", "createTransferServiceListener", "Lcom/transsion/message/cast/transfer/i/TransferServiceListener;", "handleIncomingCall", "callInfo", "Lcom/transsion/message/cast/transfer/data/CallInfo;", "handleCallActive", "handleCallEnded", "callId", "reason", "handleSmsReceived", "smsInfo", "Lcom/transsion/message/cast/transfer/data/SmsInfo;", "handleCallAudioOutputChanged", "audioOutput", "answerCallAction", "rejectCallAction", "setAudioOutputAction", "output", "Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "Companion", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class MessageCastService extends Service {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MessageCastService";
    private static TransferServiceListener transferServiceListener;
    private CallHandler mCallHandler;
    private CallNotificationImpl mCallNotificationImpl;
    private IntentDataHandler mIntentDataHandler;
    private NotificationInterface mNotificationManager;
    private SmsNotificationInterface mSmsNotificationManager;
    private TransferServiceManager mTransferServiceManager;
    private String mDid = "";
    private String mDeviceName = "";
    private String mMoDel = "";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/transsion/message/cast/MessageCastService$Companion;", "", "<init>", "()V", "TAG", "", "transferServiceListener", "Lcom/transsion/message/cast/transfer/i/TransferServiceListener;", "getTransferServiceListener", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TransferServiceListener getTransferServiceListener() {
            TransferServiceListener transferServiceListener = MessageCastService.transferServiceListener;
            if (transferServiceListener != null) {
                return transferServiceListener;
            }
            Intrinsics.throwUninitializedPropertyAccessException("transferServiceListener");
            return null;
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EAudioOutput.values().length];
            try {
                iArr[EAudioOutput.SPEAKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EAudioOutput.EARPIECE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void answerCallAction(String callId) {
        TransferServiceManager.Companion companion = TransferServiceManager.INSTANCE;
        companion.getInstance().answerCall(callId);
        CallNotificationImpl callNotificationImpl = this.mCallNotificationImpl;
        if (callNotificationImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallNotificationImpl");
            callNotificationImpl = null;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        callNotificationImpl.showActiveCallWithAudioOutput(applicationContext, callId, companion.getInstance().getAudioOutput());
    }

    private final TransferServiceListener createTransferServiceListener() {
        return new TransferServiceListener() { // from class: com.transsion.message.cast.MessageCastService.createTransferServiceListener.1
            @Override // com.transsion.message.cast.transfer.i.CallInterface
            public void onCallActive(CallInfo callInfo) {
                Intrinsics.checkNotNullParameter(callInfo, "callInfo");
                String phoneNumber = callInfo.getPhoneNumber();
                String contactName = callInfo.getContactName();
                if (contactName == null) {
                    contactName = "Unknown";
                }
                Log.d(MessageCastService.TAG, "TransferServiceListener onCallActive Call active: " + phoneNumber + ", Contact: " + contactName);
                MessageCastService.this.handleCallActive(callInfo);
            }

            @Override // com.transsion.message.cast.transfer.i.CallInterface
            public void onCallAudioOutputChanged(String callId, String audioOutput) {
                Intrinsics.checkNotNullParameter(callId, "callId");
                Intrinsics.checkNotNullParameter(audioOutput, "audioOutput");
                Log.d(MessageCastService.TAG, "TransferServiceListener onCallAudioOutputChanged Call audio output changed: " + callId + ", " + audioOutput);
                MessageCastService.this.handleCallAudioOutputChanged(callId, audioOutput);
            }

            @Override // com.transsion.message.cast.transfer.i.CallInterface
            public void onCallEnded(String callId, String reason) {
                Intrinsics.checkNotNullParameter(callId, "callId");
                Intrinsics.checkNotNullParameter(reason, "reason");
                Log.d(MessageCastService.TAG, "TransferServiceListener onCallEnded Call ended: " + callId + ", Reason: " + reason);
                MessageCastService.this.handleCallEnded(callId, reason);
            }

            @Override // com.transsion.message.cast.transfer.i.TransferServiceListener
            public void onConnectionLost(String reason) {
                if (reason == null) {
                    reason = "Unknown";
                }
                Log.d(MessageCastService.TAG, "TransferServiceListener onConnectionLost Connection lost: ".concat(reason));
                CallNotificationImpl callNotificationImpl = MessageCastService.this.mCallNotificationImpl;
                if (callNotificationImpl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCallNotificationImpl");
                    callNotificationImpl = null;
                }
                Context applicationContext = MessageCastService.this.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                callNotificationImpl.release(applicationContext);
            }

            @Override // com.transsion.message.cast.transfer.i.CallInterface
            public void onIncomingCall(CallInfo callInfo) {
                Intrinsics.checkNotNullParameter(callInfo, "callInfo");
                String phoneNumber = callInfo.getPhoneNumber();
                String contactName = callInfo.getContactName();
                if (contactName == null) {
                    contactName = "Unknown";
                }
                Log.d(MessageCastService.TAG, "TransferServiceListener onIncomingCall Incoming call: " + phoneNumber + ", Contact: " + contactName);
                MessageCastService.this.handleIncomingCall(callInfo);
            }

            @Override // com.transsion.message.cast.transfer.i.SmsInterface
            public void onSmsReceived(SmsInfo smsInfo) {
                Intrinsics.checkNotNullParameter(smsInfo, "smsInfo");
                Log.d(MessageCastService.TAG, "TransferServiceListener onSmsReceived SMS received: " + smsInfo.getPhoneNumber() + ", Content: " + smsInfo.getContent());
                MessageCastService.this.handleSmsReceived(smsInfo);
            }
        };
    }

    @JvmStatic
    public static final TransferServiceListener getTransferServiceListener() {
        return INSTANCE.getTransferServiceListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCallActive(CallInfo callInfo) {
        boolean zIsPadAnswer = TransferServiceManager.INSTANCE.getInstance().getMIsPadAnswer();
        Log.d(TAG, "Handle call active, isPadAnswer: " + zIsPadAnswer);
        CallNotificationImpl callNotificationImpl = null;
        if (zIsPadAnswer) {
            CallNotificationImpl callNotificationImpl2 = this.mCallNotificationImpl;
            if (callNotificationImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCallNotificationImpl");
            } else {
                callNotificationImpl = callNotificationImpl2;
            }
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            callNotificationImpl.showActiveCallWithAudioOutput(applicationContext, callInfo.getCallId(), callInfo.getAudioOutput());
            return;
        }
        CallNotificationImpl callNotificationImpl3 = this.mCallNotificationImpl;
        if (callNotificationImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallNotificationImpl");
        } else {
            callNotificationImpl = callNotificationImpl3;
        }
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        callNotificationImpl.cancelCallNotification(applicationContext2, callInfo.getCallId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCallAudioOutputChanged(String callId, String audioOutput) {
        Log.d(TAG, "Handle call audio output changed: " + callId + ", " + audioOutput);
        CallNotificationImpl callNotificationImpl = this.mCallNotificationImpl;
        if (callNotificationImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallNotificationImpl");
            callNotificationImpl = null;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        callNotificationImpl.cancelCallNotification(applicationContext, callId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCallEnded(String callId, String reason) {
        Log.d(TAG, "Handle call ended: " + callId + ", " + reason);
        CallNotificationImpl callNotificationImpl = this.mCallNotificationImpl;
        if (callNotificationImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallNotificationImpl");
            callNotificationImpl = null;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        callNotificationImpl.endActiveCall(applicationContext, callId);
        TransferServiceManager.INSTANCE.getInstance().disconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleIncomingCall(CallInfo callInfo) {
        CallNotificationImpl callNotificationImpl;
        CallHandler callHandler;
        CallNotificationImpl callNotificationImpl2 = this.mCallNotificationImpl;
        if (callNotificationImpl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallNotificationImpl");
            callNotificationImpl = null;
        } else {
            callNotificationImpl = callNotificationImpl2;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        String callId = callInfo.getCallId();
        String phoneNumber = callInfo.getPhoneNumber();
        String contactName = callInfo.getContactName();
        String location = callInfo.getLocation();
        String deviceName = callInfo.getDeviceName();
        CallHandler callHandler2 = this.mCallHandler;
        if (callHandler2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallHandler");
            callHandler = null;
        } else {
            callHandler = callHandler2;
        }
        callNotificationImpl.ring(applicationContext, callId, phoneNumber, contactName, location, deviceName, callHandler);
        AnalyticsManager.INSTANCE.getInstance().trackCallEvent(this.mDeviceName, this.mDid, this.mMoDel);
    }

    private final void handleIncomingIntent(Intent intent) {
        handleTrackerData(intent);
        IntentDataHandler intentDataHandler = this.mIntentDataHandler;
        if (intentDataHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntentDataHandler");
            intentDataHandler = null;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        intentDataHandler.handleIntent(applicationContext, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSmsReceived(SmsInfo smsInfo) {
        Log.d(TAG, "Handle SMS received: " + smsInfo);
        try {
            Intent intent = new Intent("com.transsion.message.cast.SMS_MESSAGE_NEW");
            intent.putExtra("phoneNumber", smsInfo.getPhoneNumber());
            intent.putExtra("content", smsInfo.getContent());
            intent.putExtra("timestamp", smsInfo.getTimestamp());
            intent.putExtra("smsId", smsInfo.getSmsId());
            intent.setPackage("com.transsion.message.cast");
            sendBroadcast(intent);
        } catch (Exception unused) {
        }
        SmsNotificationInterface smsNotificationInterface = this.mSmsNotificationManager;
        if (smsNotificationInterface == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSmsNotificationManager");
            smsNotificationInterface = null;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        smsNotificationInterface.showSmsNotification(applicationContext, smsInfo.getSmsId(), smsInfo.getPhoneNumber(), smsInfo.getContactName(), smsInfo.getContent(), smsInfo.getTimestamp(), smsInfo.getDeviceName());
        AnalyticsManager.INSTANCE.getInstance().trackSmsEvent(this.mDeviceName, this.mDid);
    }

    private final void handleTrackerData(Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("content");
            String str = "";
            if (stringExtra == null) {
                stringExtra = "";
            }
            Log.d(TAG, "handleTrackerData content: ".concat(stringExtra));
            if (TextUtils.isEmpty(stringExtra)) {
                Log.d(TAG, "handleTrackerData content is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                Log.d(TAG, "handleTrackerData contentJson: " + jSONObject);
                String string = jSONObject.getString("deviceName");
                if (string == null) {
                    string = "";
                }
                this.mDeviceName = string;
                String string2 = jSONObject.getString("did");
                if (string2 == null) {
                    string2 = "";
                }
                this.mDid = string2;
                Log.d(TAG, "handleTrackerData did: " + string2);
                String string3 = jSONObject.getString("model");
                if (string3 != null) {
                    str = string3;
                }
                this.mMoDel = str;
                Log.d(TAG, "handleTrackerData model: " + str);
            } catch (JSONException e) {
                e.printStackTrace();
                d.B("handleTrackerData error: ", e.getMessage(), TAG);
            }
        }
    }

    private final void initializeComponents() {
        initializeNotificationManagers();
        initializeHandlers();
        setupSmsReplyDispatcher();
    }

    private final void initializeHandlers() {
        this.mTransferServiceManager = TransferServiceManager.INSTANCE.getInstance();
        transferServiceListener = createTransferServiceListener();
        TransferServiceManager transferServiceManager = this.mTransferServiceManager;
        TransferServiceListener transferServiceListener2 = null;
        if (transferServiceManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTransferServiceManager");
            transferServiceManager = null;
        }
        TransferServiceListener transferServiceListener3 = transferServiceListener;
        if (transferServiceListener3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("transferServiceListener");
        } else {
            transferServiceListener2 = transferServiceListener3;
        }
        transferServiceManager.registerListener(transferServiceListener2);
        this.mCallHandler = new CallHandler() { // from class: com.transsion.message.cast.MessageCastService.initializeHandlers.1
            @Override // com.transsion.message.cast.notification.i.CallHandler
            public void answerCall(String callId) {
                Intrinsics.checkNotNullParameter(callId, "callId");
                Log.d(MessageCastService.TAG, "answerCall Answer call: " + callId);
                MessageCastService.this.answerCallAction(callId);
            }

            @Override // com.transsion.message.cast.notification.i.CallHandler
            public void rejectCall(String callId) {
                Intrinsics.checkNotNullParameter(callId, "callId");
                Log.d(MessageCastService.TAG, "rejectCall Reject call: " + callId);
                MessageCastService.this.rejectCallAction(callId);
            }

            @Override // com.transsion.message.cast.notification.i.CallHandler
            public void setAudioOutput(String callId, EAudioOutput output) {
                Intrinsics.checkNotNullParameter(callId, "callId");
                Intrinsics.checkNotNullParameter(output, "output");
                Log.d(MessageCastService.TAG, "setAudioOutput Set audio output: " + callId + ", " + output);
                MessageCastService.this.setAudioOutputAction(callId, output);
            }
        };
        this.mIntentDataHandler = new IntentDataHandler(INSTANCE.getTransferServiceListener());
    }

    private final void initializeNotificationManagers() {
        NotificationFactory notificationFactory = NotificationFactory.INSTANCE;
        NotificationInterface notificationManager = notificationFactory.getNotificationManager();
        this.mNotificationManager = notificationManager;
        SmsNotificationInterface smsNotificationInterface = null;
        if (notificationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotificationManager");
            notificationManager = null;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        notificationManager.createNotificationChannel(applicationContext);
        SmsNotificationInterface smsNotificationManager = notificationFactory.getSmsNotificationManager();
        this.mSmsNotificationManager = smsNotificationManager;
        if (smsNotificationManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSmsNotificationManager");
        } else {
            smsNotificationInterface = smsNotificationManager;
        }
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        smsNotificationInterface.createNotificationChannel(applicationContext2);
        this.mCallNotificationImpl = new CallNotificationImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rejectCallAction(String callId) {
        TransferServiceManager.INSTANCE.getInstance().rejectCall(callId);
        AnalyticsManager.INSTANCE.getInstance().trackCancelCallEvent(this.mDeviceName, this.mDid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAudioOutputAction(String callId, EAudioOutput output) {
        int i8 = WhenMappings.$EnumSwitchMapping$0[output.ordinal()];
        CallNotificationImpl callNotificationImpl = null;
        if (i8 == 1) {
            TransferServiceManager companion = TransferServiceManager.INSTANCE.getInstance();
            EAudioOutput eAudioOutput = EAudioOutput.SPEAKER;
            companion.switchAudioOutput(callId, eAudioOutput);
            AnalyticsManager.INSTANCE.getInstance().trackSwitchOutputAudioEvent(this.mDeviceName, this.mDid, EAnalyticsParams.AUDIO_TYPE_SPEAKER, EAnalyticsParams.DEVICE_TYPE_PAD);
            CallNotificationImpl callNotificationImpl2 = this.mCallNotificationImpl;
            if (callNotificationImpl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCallNotificationImpl");
            } else {
                callNotificationImpl = callNotificationImpl2;
            }
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            callNotificationImpl.switchAudioOutput(applicationContext, callId, eAudioOutput);
            return;
        }
        if (i8 != 2) {
            Log.d(TAG, "Audio output switched to: " + output);
            return;
        }
        TransferServiceManager companion2 = TransferServiceManager.INSTANCE.getInstance();
        EAudioOutput eAudioOutput2 = EAudioOutput.EARPIECE;
        companion2.switchAudioOutput(callId, eAudioOutput2);
        AnalyticsManager.INSTANCE.getInstance().trackSwitchOutputAudioEvent(this.mDeviceName, this.mDid, EAnalyticsParams.AUDIO_TYPE_EARPIECE, EAnalyticsParams.DEVICE_TYPE_PAD);
        Log.d(TAG, "Audio output switched to earpiece using modern API");
        CallNotificationImpl callNotificationImpl3 = this.mCallNotificationImpl;
        if (callNotificationImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallNotificationImpl");
        } else {
            callNotificationImpl = callNotificationImpl3;
        }
        Context applicationContext2 = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
        callNotificationImpl.switchAudioOutput(applicationContext2, callId, eAudioOutput2);
    }

    private final void setupSmsReplyDispatcher() {
        SmsReplyDispatcher.setSendStrategy(new k(this, 3));
        SmsReplyDispatcher.setOnReplyClicked(new q(19));
        SmsReplyDispatcher.setOnMarkReadClicked(new a(this, 9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupSmsReplyDispatcher$lambda$0(MessageCastService this$0, String phone, String content, String smsId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        StringBuilder sb2 = new StringBuilder("Chat Activity Reply SMS: ");
        d.A(sb2, phone, ", ", content, ", ");
        sb2.append(smsId);
        Log.d(TAG, sb2.toString());
        TransferServiceManager.INSTANCE.getInstance().replySms(phone, smsId, content);
        AnalyticsManager.INSTANCE.getInstance().trackReplySmsEvent(this$0.mDeviceName, this$0.mDid);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupSmsReplyDispatcher$lambda$1(String phone, String smsId) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        Log.d(TAG, "Notification Reply clicked: " + phone + " smsId:" + smsId);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupSmsReplyDispatcher$lambda$2(MessageCastService this$0, String phone, String smsId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        Log.d(TAG, "Notification Mark read clicked: " + phone + " smsId:" + smsId);
        TransferServiceManager.INSTANCE.getInstance().markSmsAsRead(phone, smsId);
        AnalyticsManager.INSTANCE.getInstance().trackCancelSmsEvent(this$0.mDeviceName, this$0.mDid);
        return Unit.INSTANCE;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        TransferServiceManager.Companion companion = TransferServiceManager.INSTANCE;
        Log.d(TAG, "TransferServiceImpl: " + companion.getInstance().getTransferService());
        boolean zInitialize = companion.getInstance().initialize(this);
        Log.d(TAG, "TransferServiceManager initialized: " + zInitialize);
        if (zInitialize) {
            Log.i(TAG, "TransferServiceManager initialized successfully");
        } else {
            Log.e(TAG, "Failed to initialize TransferServiceManager");
        }
        initializeComponents();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        Log.d(TAG, "onStartCommand");
        Log.d(TAG, "onStartCommand Intent: " + intent);
        Log.d(TAG, "onStartCommand flags: " + flags);
        Log.d(TAG, "onStartCommand startId: " + startId);
        handleIncomingIntent(intent);
        stopSelf();
        return 2;
    }
}
