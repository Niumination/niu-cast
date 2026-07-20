package com.transsion.message.cast.transfer;

import a1.a;
import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.cast.phonenumber.GeoCoderManager;
import com.transsion.message.cast.transfer.data.CallInfo;
import com.transsion.message.cast.transfer.data.CallState;
import com.transsion.message.cast.transfer.data.SmsInfo;
import com.transsion.message.cast.transfer.e.EAudioOutput;
import com.transsion.message.cast.transfer.e.EMessageType;
import com.transsion.message.cast.transfer.i.AIotSdkInterface;
import com.transsion.message.cast.transfer.i.CallHandlerInterface;
import com.transsion.message.cast.transfer.i.SmsHandlerInterface;
import com.transsion.message.cast.transfer.i.TransferServiceListener;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.appspot.transsion.aiot.aidl.Message;
import org.json.JSONException;
import org.json.JSONObject;
import tj.c;
import tj.d;
import tj.h;
import tj.j;
import tj.l;
import tj.m;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0005J7\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010\u0005J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\fH\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\b2\u0006\u0010$\u001a\u00020\fH\u0016¢\u0006\u0004\b'\u0010&J\u001f\u0010*\u001a\u00020\b2\u0006\u0010$\u001a\u00020\f2\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J'\u0010.\u001a\u00020\b2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\b2\u0006\u0010,\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fH\u0016¢\u0006\u0004\b0\u00101R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<¨\u0006>"}, d2 = {"Lcom/transsion/message/cast/transfer/TransferServiceImpl;", "Lcom/transsion/message/cast/transfer/i/AIotSdkInterface;", "Lcom/transsion/message/cast/transfer/i/CallHandlerInterface;", "Lcom/transsion/message/cast/transfer/i/SmsHandlerInterface;", "<init>", "()V", "Landroid/content/Context;", "context", "", "subscribeToTopics", "(Landroid/content/Context;)V", "unsubscribeFromTopics", "", "topic", "content", "", "messageType", "", "timestamp", "handleCallMessage", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;IJ)V", "handleCallAudioRouteMessage", "(Ljava/lang/String;Ljava/lang/String;IJ)V", "Lorg/json/JSONObject;", "json", "Lcom/transsion/message/cast/transfer/data/CallInfo;", "parseCallInfo", "(Landroid/content/Context;Lorg/json/JSONObject;)Lcom/transsion/message/cast/transfer/data/CallInfo;", "Lcom/transsion/message/cast/transfer/data/SmsInfo;", "parseSmsInfo", "(Lorg/json/JSONObject;)Lcom/transsion/message/cast/transfer/data/SmsInfo;", "Lcom/transsion/message/cast/transfer/i/TransferServiceListener;", "listener", "initialize", "(Landroid/content/Context;Lcom/transsion/message/cast/transfer/i/TransferServiceListener;)V", "disconnect", "callId", "answerCall", "(Ljava/lang/String;)V", "rejectCall", "Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "eAudioOutput", "switchAudioOutput", "(Ljava/lang/String;Lcom/transsion/message/cast/transfer/e/EAudioOutput;)V", "phoneNumber", "smsId", "replySms", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "markSmsAsRead", "(Ljava/lang/String;Ljava/lang/String;)V", "Ltj/d;", "mCellularManager", "Ltj/d;", "mTransferServiceListener", "Lcom/transsion/message/cast/transfer/i/TransferServiceListener;", "Ltj/m;", "mCallCallback", "Ltj/m;", "mCallAudioRouteCallback", "mContext", "Landroid/content/Context;", "Companion", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TransferServiceImpl implements AIotSdkInterface, CallHandlerInterface, SmsHandlerInterface {
    private static final String TAG = "TransferServiceImpl";
    private m mCallAudioRouteCallback;
    private m mCallCallback;
    private d mCellularManager;
    private Context mContext;
    private TransferServiceListener mTransferServiceListener;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CallState.State.values().length];
            try {
                iArr[CallState.State.RINGING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CallState.State.ACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CallState.State.DISCONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCallAudioRouteMessage(String topic, String content, int messageType, long timestamp) {
        try {
            Log.d(TAG, "Received call audio route message topic: " + topic);
            Log.d(TAG, "Received call audio route message: " + content);
            Log.d(TAG, "Received call audio route message type: " + messageType);
            Log.d(TAG, "Received call audio route message timestamp: " + timestamp);
            JSONObject jSONObject = new JSONObject(content);
            Log.d(TAG, "oriAudioOut: " + jSONObject.optString("oriAudioOut"));
            String strOptString = jSONObject.optString("curAudioOut");
            Log.d(TAG, "curAudioOut: " + strOptString);
            String strOptString2 = jSONObject.optString("callId");
            TransferServiceListener transferServiceListener = this.mTransferServiceListener;
            if (transferServiceListener != null) {
                Intrinsics.checkNotNull(strOptString2);
                Intrinsics.checkNotNull(strOptString);
                transferServiceListener.onCallAudioOutputChanged(strOptString2, strOptString);
            }
        } catch (JSONException e) {
            Log.e(TAG, "Failed to parse call audio route message", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCallMessage(Context context, String topic, String content, int messageType, long timestamp) {
        try {
            Log.d(TAG, "Received call message topic: " + topic);
            Log.d(TAG, "Received call content: " + content);
            Log.d(TAG, "Received call message messageType: " + messageType);
            Log.d(TAG, "Received call message timestamp: " + timestamp);
            JSONObject jSONObject = new JSONObject(content);
            String strOptString = jSONObject.optString("state");
            Log.d(TAG, "Received call state: " + strOptString);
            CallState.State.Companion companion = CallState.State.INSTANCE;
            Intrinsics.checkNotNull(strOptString);
            CallState.State stateFromString = companion.fromString(strOptString);
            int i8 = WhenMappings.$EnumSwitchMapping$0[stateFromString.ordinal()];
            if (i8 == 1) {
                CallInfo callInfo = parseCallInfo(context, jSONObject);
                TransferServiceListener transferServiceListener = this.mTransferServiceListener;
                if (transferServiceListener != null) {
                    transferServiceListener.onIncomingCall(callInfo);
                }
            } else if (i8 == 2) {
                CallInfo callInfo2 = parseCallInfo(context, jSONObject);
                TransferServiceListener transferServiceListener2 = this.mTransferServiceListener;
                if (transferServiceListener2 != null) {
                    transferServiceListener2.onCallActive(callInfo2);
                }
            } else if (i8 != 3) {
                Log.w(TAG, "Unhandled call state: " + stateFromString);
            } else {
                String strOptString2 = jSONObject.optString("callId");
                TransferServiceListener transferServiceListener3 = this.mTransferServiceListener;
                if (transferServiceListener3 != null) {
                    Intrinsics.checkNotNull(strOptString2);
                    transferServiceListener3.onCallEnded(strOptString2, "DISCONNECTED");
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "Failed to parse call message", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$0(TransferServiceImpl this$0, Context context, boolean z2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Log.i(TAG, "Connected to CellularShareManager " + z2);
        if (!z2) {
            Log.e(TAG, "Failed to connect to CellularShareManager");
            return;
        }
        d dVarB = d.b();
        this$0.mCellularManager = dVarB;
        if (dVarB == null) {
            throw new IllegalStateException("CellularShareManager is not initialized");
        }
        this$0.subscribeToTopics(context);
    }

    private final CallInfo parseCallInfo(Context context, JSONObject json) {
        Object systemService = context.getSystemService("phone");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String strOptString = json.optString("phoneNumber");
        GeoCoderManager geoCoderManager = new GeoCoderManager((TelephonyManager) systemService, context, Locale.getDefault());
        Log.d(TAG, "parseCallInfo numberDescription: " + geoCoderManager.getGeoDescription(strOptString, geoCoderManager.getCurrentCountryIso()));
        String strOptString2 = json.optString("callId");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
        String strOptString3 = json.optString("phoneNumber");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        return new CallInfo(strOptString2, strOptString3, json.optString("contactName"), json.optString("location"), "deviceName", TransferServiceManager.INSTANCE.getInstance().getAudioOutput());
    }

    private final SmsInfo parseSmsInfo(JSONObject json) {
        String strOptString = json.optString("smsId");
        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
        String strOptString2 = json.optString("contactName");
        String strOptString3 = json.optString("phoneNumber");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
        String strOptString4 = json.optString("content");
        Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
        return new SmsInfo(strOptString, strOptString2, strOptString3, strOptString4, json.optLong("timestamp"), "deviceName");
    }

    private final void subscribeToTopics(final Context context) {
        this.mCallCallback = new l() { // from class: com.transsion.message.cast.transfer.TransferServiceImpl.subscribeToTopics.1
            @Override // tj.m
            public void onConnectionLost(String reason) {
                Log.w(TransferServiceImpl.TAG, "onConnectionLost Call forward connection lost: " + reason);
                TransferServiceListener transferServiceListener = TransferServiceImpl.this.mTransferServiceListener;
                if (transferServiceListener != null) {
                    transferServiceListener.onConnectionLost(reason);
                }
            }

            @Override // tj.m
            public void onMessageReceived(Message message) {
                Intrinsics.checkNotNullParameter(message, "message");
                TransferServiceImpl transferServiceImpl = TransferServiceImpl.this;
                Context context2 = context;
                String topic = message.f8611a;
                Intrinsics.checkNotNullExpressionValue(topic, "topic");
                String content = message.f8612b;
                Intrinsics.checkNotNullExpressionValue(content, "content");
                transferServiceImpl.handleCallMessage(context2, topic, content, message.f8613c, message.f8614d);
            }
        };
        d dVar = this.mCellularManager;
        d dVar2 = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
            dVar = null;
        }
        Locale locale = Locale.ROOT;
        String strT = a.t(locale, "ROOT", "CALL_FORWARD", locale, "toLowerCase(...)");
        m mVar = this.mCallCallback;
        Intrinsics.checkNotNull(mVar);
        dVar.d(strT, mVar);
        this.mCallAudioRouteCallback = new l() { // from class: com.transsion.message.cast.transfer.TransferServiceImpl.subscribeToTopics.2
            @Override // tj.m
            public void onConnectionLost(String reason) {
                Log.w(TransferServiceImpl.TAG, "Call audio route connection lost: " + reason);
                TransferServiceListener transferServiceListener = TransferServiceImpl.this.mTransferServiceListener;
                if (transferServiceListener != null) {
                    transferServiceListener.onConnectionLost(reason);
                }
            }

            @Override // tj.m
            public void onMessageReceived(Message message) {
                Intrinsics.checkNotNullParameter(message, "message");
                TransferServiceImpl transferServiceImpl = TransferServiceImpl.this;
                String topic = message.f8611a;
                Intrinsics.checkNotNullExpressionValue(topic, "topic");
                String content = message.f8612b;
                Intrinsics.checkNotNullExpressionValue(content, "content");
                transferServiceImpl.handleCallAudioRouteMessage(topic, content, message.f8613c, message.f8614d);
            }
        };
        d dVar3 = this.mCellularManager;
        if (dVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
        } else {
            dVar2 = dVar3;
        }
        String strT2 = a.t(locale, "ROOT", "CALL_AUDIO_ROUTE", locale, "toLowerCase(...)");
        m mVar2 = this.mCallAudioRouteCallback;
        Intrinsics.checkNotNull(mVar2);
        dVar2.d(strT2, mVar2);
    }

    private final void unsubscribeFromTopics() {
        if (this.mCallCallback != null) {
            d dVar = this.mCellularManager;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
                dVar = null;
            }
            dVar.getClass();
            Log.d("CellularShareManager", "unsubscribeFromTopic: CALL_FORWARD");
            try {
                j jVar = dVar.f10248a;
                if (jVar != null) {
                    ((h) jVar).i();
                } else {
                    Log.w("CellularShareManager", "CellularShareService not initialized");
                }
            } catch (RemoteException e) {
                if (e.getCause() instanceof DeadObjectException) {
                    Log.d("CellularShareManager", "unsubscribeFromTopic - service dead");
                } else {
                    Log.e("CellularShareManager", "unsubscribeFromTopic failed", e);
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override // com.transsion.message.cast.transfer.i.CallHandlerInterface
    public void answerCall(String callId) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "ANSWER");
            jSONObject.put("callId", callId);
            TransferServiceManager.Companion companion = TransferServiceManager.INSTANCE;
            jSONObject.put("connected_device_name", companion.getInstance().getDeviceName());
            jSONObject.put("did", companion.getInstance().getUniqueDeviceId(this.mContext));
            d dVar = this.mCellularManager;
            d dVar2 = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
                dVar = null;
            }
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = "CALL_CONTROL".toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = jSONObject.toString();
            int iOrdinal = EMessageType.CONTROL.ordinal();
            dVar.getClass();
            Message messageA = d.a(iOrdinal, lowerCase, string);
            Log.d(TAG, "answer message topic: " + messageA.f8611a);
            Log.d(TAG, "answer message: " + messageA.f8612b);
            Log.d(TAG, "answer message type: " + messageA.f8613c);
            Log.d(TAG, "answer message timestamp: " + messageA.f8614d);
            d dVar3 = this.mCellularManager;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
            } else {
                dVar2 = dVar3;
            }
            dVar2.c(messageA);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create answer message", e);
        }
    }

    @Override // com.transsion.message.cast.transfer.i.AIotSdkInterface
    public void disconnect() {
        unsubscribeFromTopics();
        this.mTransferServiceListener = null;
    }

    @Override // com.transsion.message.cast.transfer.i.AIotSdkInterface
    public void initialize(Context context, TransferServiceListener listener) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mContext = context;
        this.mTransferServiceListener = listener;
        try {
            if (c.f10239j == null) {
                synchronized (c.class) {
                    try {
                        if (c.f10239j == null) {
                            c.f10239j = new c();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            c.f10239j.c(context.getApplicationContext(), new xc.a(this, context));
        } catch (Exception e) {
            Log.e(TAG, "Failed to initialize TransferService", e);
            Log.e(TAG, "TransferService initialization failed, please check CellularShareManager availability");
            throw e;
        }
    }

    @Override // com.transsion.message.cast.transfer.i.SmsHandlerInterface
    public void markSmsAsRead(String phoneNumber, String smsId) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "MASK_AS_READ");
            jSONObject.put("phoneNumber", phoneNumber);
            jSONObject.put("smsId", smsId);
            TransferServiceManager.Companion companion = TransferServiceManager.INSTANCE;
            jSONObject.put("connected_device_name", companion.getInstance().getDeviceName());
            jSONObject.put("did", companion.getInstance().getUniqueDeviceId(this.mContext));
            d dVar = this.mCellularManager;
            d dVar2 = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
                dVar = null;
            }
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = "SMS_FORWARD".toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = jSONObject.toString();
            int iOrdinal = EMessageType.CONTROL.ordinal();
            dVar.getClass();
            Message messageA = d.a(iOrdinal, lowerCase, string);
            Log.d(TAG, "markSmsAsRead message topic: " + messageA.f8611a);
            Log.d(TAG, "markSmsAsRead message: " + messageA.f8612b);
            Log.d(TAG, "markSmsAsRead message type: " + messageA.f8613c);
            Log.d(TAG, "markSmsAsRead message timestamp: " + messageA.f8614d);
            d dVar3 = this.mCellularManager;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
            } else {
                dVar2 = dVar3;
            }
            dVar2.c(messageA);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create mark SMS as read message", e);
        }
    }

    @Override // com.transsion.message.cast.transfer.i.CallHandlerInterface
    public void rejectCall(String callId) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "REJECT");
            jSONObject.put("callId", callId);
            TransferServiceManager.Companion companion = TransferServiceManager.INSTANCE;
            jSONObject.put("connected_device_name", companion.getInstance().getDeviceName());
            jSONObject.put("did", companion.getInstance().getUniqueDeviceId(this.mContext));
            d dVar = this.mCellularManager;
            d dVar2 = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
                dVar = null;
            }
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = "CALL_CONTROL".toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = jSONObject.toString();
            int iOrdinal = EMessageType.CONTROL.ordinal();
            dVar.getClass();
            Message messageA = d.a(iOrdinal, lowerCase, string);
            Log.d(TAG, "reject message topic: " + messageA.f8611a);
            Log.d(TAG, "reject message: " + messageA.f8612b);
            Log.d(TAG, "reject message type: " + messageA.f8613c);
            Log.d(TAG, "reject message timestamp: " + messageA.f8614d);
            d dVar3 = this.mCellularManager;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
            } else {
                dVar2 = dVar3;
            }
            dVar2.c(messageA);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create reject message", e);
        }
    }

    @Override // com.transsion.message.cast.transfer.i.SmsHandlerInterface
    public void replySms(String phoneNumber, String smsId, String content) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "REPLY");
            jSONObject.put("phoneNumber", phoneNumber);
            jSONObject.put("smsId", smsId);
            jSONObject.put("content", content);
            jSONObject.put("timestamp", System.currentTimeMillis());
            TransferServiceManager.Companion companion = TransferServiceManager.INSTANCE;
            jSONObject.put("connected_device_name", companion.getInstance().getDeviceName());
            jSONObject.put("did", companion.getInstance().getUniqueDeviceId(this.mContext));
            d dVar = this.mCellularManager;
            d dVar2 = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
                dVar = null;
            }
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = "SMS_FORWARD".toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = jSONObject.toString();
            int iOrdinal = EMessageType.CONTROL.ordinal();
            dVar.getClass();
            Message messageA = d.a(iOrdinal, lowerCase, string);
            Log.d(TAG, "replySms message topic: " + messageA.f8611a);
            Log.d(TAG, "replySms message: " + messageA.f8612b);
            Log.d(TAG, "replySms message type: " + messageA.f8613c);
            Log.d(TAG, "replySms message timestamp: " + messageA.f8614d);
            d dVar3 = this.mCellularManager;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
            } else {
                dVar2 = dVar3;
            }
            dVar2.c(messageA);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create SMS message", e);
        }
    }

    @Override // com.transsion.message.cast.transfer.i.CallHandlerInterface
    public void switchAudioOutput(String callId, EAudioOutput eAudioOutput) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(eAudioOutput, "eAudioOutput");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", "SET_AUDIO_OUTPUT");
            jSONObject.put("callId", callId);
            jSONObject.put("output", eAudioOutput.name());
            d dVar = this.mCellularManager;
            d dVar2 = null;
            if (dVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
                dVar = null;
            }
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = "CALL_CONTROL".toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            String string = jSONObject.toString();
            int iOrdinal = EMessageType.CONTROL.ordinal();
            dVar.getClass();
            Message messageA = d.a(iOrdinal, lowerCase, string);
            Log.d(TAG, "switchAudioOutput message topic: " + messageA.f8611a);
            Log.d(TAG, "switchAudioOutput message: " + messageA.f8612b);
            Log.d(TAG, "switchAudioOutput message type: " + messageA.f8613c);
            Log.d(TAG, "switchAudioOutput message timestamp: " + messageA.f8614d);
            d dVar3 = this.mCellularManager;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCellularManager");
            } else {
                dVar2 = dVar3;
            }
            dVar2.c(messageA);
        } catch (JSONException e) {
            Log.e(TAG, "Failed to create switchAudioOutput message", e);
        }
    }
}
