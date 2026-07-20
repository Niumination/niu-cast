package com.transsion.message.cast.transfer;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.cast.audio.AudioOutputMonitor;
import com.transsion.message.cast.transfer.data.CallInfo;
import com.transsion.message.cast.transfer.data.SmsInfo;
import com.transsion.message.cast.transfer.e.EAudioOutput;
import com.transsion.message.cast.transfer.i.TransferServiceListener;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import o.d;
import xc.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u000f\u0018\u0000 *2\u00020\u0001:\u0001*B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!J\u001e\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001dJ\u0016\u0010&\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u001dJ\u0006\u0010'\u001a\u00020!J\u0006\u0010(\u001a\u00020\u001dJ\u0010\u0010)\u001a\u00020\u001d2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006+"}, d2 = {"Lcom/transsion/message/cast/transfer/TransferServiceManager;", "", "<init>", "()V", "transferService", "Lcom/transsion/message/cast/transfer/TransferServiceImpl;", "transactionListener", "Lcom/transsion/message/cast/transfer/i/TransferServiceListener;", "audioOutputMonitor", "Lcom/transsion/message/cast/audio/AudioOutputMonitor;", "mCurrentCallInfo", "Lcom/transsion/message/cast/transfer/data/CallInfo;", "mIsPadAnswer", "", "dispatchListener", "com/transsion/message/cast/transfer/TransferServiceManager$dispatchListener$1", "Lcom/transsion/message/cast/transfer/TransferServiceManager$dispatchListener$1;", "getTransferServiceImpl", "isPadAnswer", "initialize", "context", "Landroid/content/Context;", "disconnect", "", "stopAudioOutputMonitor", "registerListener", "listener", "answerCall", "callId", "", "rejectCall", "switchAudioOutput", "eAudioOutput", "Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "replySms", "phoneNumber", "smsId", "content", "markSmsAsRead", "getAudioOutput", "getDeviceName", "getUniqueDeviceId", "Companion", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TransferServiceManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile TransferServiceManager INSTANCE = null;
    private static final String TAG = "TransferServiceManager";
    private AudioOutputMonitor audioOutputMonitor;
    private final TransferServiceManager$dispatchListener$1 dispatchListener;
    private CallInfo mCurrentCallInfo;
    private boolean mIsPadAnswer;
    private TransferServiceListener transactionListener;
    private TransferServiceImpl transferService;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/transsion/message/cast/transfer/TransferServiceManager$Companion;", "", "<init>", "()V", "TAG", "", "INSTANCE", "Lcom/transsion/message/cast/transfer/TransferServiceManager;", "getInstance", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TransferServiceManager getInstance() {
            TransferServiceManager transferServiceManager = TransferServiceManager.INSTANCE;
            if (transferServiceManager == null) {
                synchronized (this) {
                    transferServiceManager = TransferServiceManager.INSTANCE;
                    if (transferServiceManager == null) {
                        transferServiceManager = new TransferServiceManager(null);
                        TransferServiceManager.INSTANCE = transferServiceManager;
                    }
                }
            }
            return transferServiceManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TransferServiceManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final TransferServiceManager getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initialize$lambda$1(TransferServiceManager this$0, EAudioOutput audioOutput) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(audioOutput, "audioOutput");
        Log.d(TAG, "Audio output changed: " + audioOutput);
        CallInfo callInfo = this$0.mCurrentCallInfo;
        if (callInfo != null) {
            CallInfo callInfoCopy$default = callInfo != null ? CallInfo.copy$default(callInfo, null, null, null, null, null, audioOutput, 31, null) : null;
            Log.d(TAG, "Updating call info with new audio output: " + audioOutput);
            TransferServiceListener transferServiceListener = this$0.transactionListener;
            if (transferServiceListener != null) {
                Intrinsics.checkNotNull(callInfoCopy$default);
                transferServiceListener.onCallActive(callInfoCopy$default);
            }
        }
    }

    public final boolean answerCall(String callId) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        boolean z2 = true;
        this.mIsPadAnswer = true;
        TransferServiceImpl transferServiceImpl = this.transferService;
        boolean z3 = false;
        try {
            if (transferServiceImpl != null) {
                transferServiceImpl.answerCall(callId);
                Log.d(TAG, "Answered call: " + callId);
            } else {
                Log.w(TAG, "Cannot answer call - TransferService not initialized");
                z2 = false;
            }
            z3 = z2;
            return z3;
        } catch (Exception e) {
            Log.e(TAG, "Error answering call", e);
            return z3;
        }
    }

    public final void disconnect() {
        TransferServiceImpl transferServiceImpl = this.transferService;
        if (transferServiceImpl != null) {
            transferServiceImpl.disconnect();
        }
        this.transferService = null;
    }

    public final EAudioOutput getAudioOutput() {
        AudioOutputMonitor audioOutputMonitor = this.audioOutputMonitor;
        EAudioOutput currentAudioOutput = audioOutputMonitor != null ? audioOutputMonitor.getCurrentAudioOutput() : null;
        return currentAudioOutput == null ? EAudioOutput.SPEAKER : currentAudioOutput;
    }

    public final String getDeviceName() {
        try {
            String str = Build.MANUFACTURER;
            String str2 = Build.MODEL;
            Intrinsics.checkNotNull(str2);
            Intrinsics.checkNotNull(str);
            if (StringsKt__StringsJVMKt.startsWith$default(str2, str, false, 2, null)) {
                return str2;
            }
            return str + " " + str2;
        } catch (Exception e) {
            Log.e(TAG, "Error getting device name", e);
            return d.l(Build.BOARD, Build.DEVICE, Build.MODEL);
        }
    }

    /* JADX INFO: renamed from: getTransferServiceImpl, reason: from getter */
    public final TransferServiceImpl getTransferService() {
        return this.transferService;
    }

    public final String getUniqueDeviceId(Context context) {
        ContentResolver contentResolver;
        if (context != null) {
            try {
                contentResolver = context.getContentResolver();
            } catch (Exception e) {
                Log.e(TAG, "Error getting unique device ID", e);
                return Build.BOARD + Build.BRAND + Build.DEVICE + Build.MODEL;
            }
        } else {
            contentResolver = null;
        }
        String string = Settings.Secure.getString(contentResolver, "android_id");
        if (string != null) {
            return string;
        }
        return Build.BOARD + Build.BRAND + Build.DEVICE + Build.MODEL;
    }

    public final boolean initialize(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.transferService != null) {
            Log.d(TAG, "TransferService already initialized");
            return true;
        }
        try {
            Log.d(TAG, "Initializing TransferService");
            TransferServiceImpl transferServiceImpl = new TransferServiceImpl();
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            transferServiceImpl.initialize(applicationContext, this.dispatchListener);
            this.transferService = transferServiceImpl;
            AudioOutputMonitor audioOutputMonitor = new AudioOutputMonitor(context);
            this.audioOutputMonitor = audioOutputMonitor;
            audioOutputMonitor.start(new b(this));
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Failed to initialize TransferService", e);
            this.transferService = null;
            return false;
        }
    }

    /* JADX INFO: renamed from: isPadAnswer, reason: from getter */
    public final boolean getMIsPadAnswer() {
        return this.mIsPadAnswer;
    }

    public final boolean markSmsAsRead(String phoneNumber, String smsId) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        TransferServiceImpl transferServiceImpl = this.transferService;
        boolean z2 = false;
        try {
            if (transferServiceImpl != null) {
                transferServiceImpl.markSmsAsRead(phoneNumber, smsId);
                Log.d(TAG, "Marked SMS as read: " + phoneNumber + " smsId: " + smsId);
                z2 = true;
            } else {
                Log.w(TAG, "Cannot mark SMS as read - TransferService not initialized");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error marking SMS as read", e);
        }
        return z2;
    }

    public final void registerListener(TransferServiceListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.transactionListener = listener;
    }

    public final boolean rejectCall(String callId) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        TransferServiceImpl transferServiceImpl = this.transferService;
        boolean z2 = false;
        try {
            if (transferServiceImpl != null) {
                transferServiceImpl.rejectCall(callId);
                Log.d(TAG, "Rejected call: " + callId);
                z2 = true;
            } else {
                Log.w(TAG, "Cannot reject call - TransferService not initialized");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error rejecting call", e);
        }
        return z2;
    }

    public final boolean replySms(String phoneNumber, String smsId, String content) {
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        Intrinsics.checkNotNullParameter(content, "content");
        TransferServiceImpl transferServiceImpl = this.transferService;
        boolean z2 = false;
        try {
            if (transferServiceImpl != null) {
                transferServiceImpl.replySms(phoneNumber, smsId, content);
                Log.d(TAG, "Sent SMS to: " + phoneNumber + " content: " + content + " smsId: " + smsId);
                z2 = true;
            } else {
                Log.w(TAG, "Cannot send SMS - TransferService not initialized");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error sending SMS", e);
        }
        return z2;
    }

    public final void stopAudioOutputMonitor() {
        AudioOutputMonitor audioOutputMonitor = this.audioOutputMonitor;
        if (audioOutputMonitor != null) {
            audioOutputMonitor.stop();
        }
    }

    public final boolean switchAudioOutput(String callId, EAudioOutput eAudioOutput) {
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(eAudioOutput, "eAudioOutput");
        TransferServiceImpl transferServiceImpl = this.transferService;
        boolean z2 = false;
        try {
            if (transferServiceImpl != null) {
                transferServiceImpl.switchAudioOutput(callId, eAudioOutput);
                Log.d(TAG, "Switch audio output: " + callId + " " + eAudioOutput);
                z2 = true;
            } else {
                Log.w(TAG, "Cannot switch audio output - TransferService not initialized");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error switch audio output", e);
        }
        return z2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.transsion.message.cast.transfer.TransferServiceManager$dispatchListener$1] */
    private TransferServiceManager() {
        this.dispatchListener = new TransferServiceListener() { // from class: com.transsion.message.cast.transfer.TransferServiceManager$dispatchListener$1
            @Override // com.transsion.message.cast.transfer.i.CallInterface
            public void onCallActive(CallInfo callInfo) {
                Intrinsics.checkNotNullParameter(callInfo, "callInfo");
                this.this$0.mCurrentCallInfo = callInfo;
                TransferServiceListener transferServiceListener = this.this$0.transactionListener;
                if (transferServiceListener != null) {
                    transferServiceListener.onCallActive(callInfo);
                }
            }

            @Override // com.transsion.message.cast.transfer.i.CallInterface
            public void onCallAudioOutputChanged(String callId, String audioOutput) {
                Intrinsics.checkNotNullParameter(callId, "callId");
                Intrinsics.checkNotNullParameter(audioOutput, "audioOutput");
                Log.d("TransferServiceManager", "Call audio output changed: " + audioOutput);
                TransferServiceListener transferServiceListener = this.this$0.transactionListener;
                if (transferServiceListener != null) {
                    transferServiceListener.onCallAudioOutputChanged(callId, audioOutput);
                }
            }

            @Override // com.transsion.message.cast.transfer.i.CallInterface
            public void onCallEnded(String callId, String reason) {
                Intrinsics.checkNotNullParameter(callId, "callId");
                Intrinsics.checkNotNullParameter(reason, "reason");
                TransferServiceListener transferServiceListener = this.this$0.transactionListener;
                if (transferServiceListener != null) {
                    transferServiceListener.onCallEnded(callId, reason);
                }
            }

            @Override // com.transsion.message.cast.transfer.i.TransferServiceListener
            public void onConnectionLost(String reason) {
                TransferServiceListener transferServiceListener = this.this$0.transactionListener;
                if (transferServiceListener != null) {
                    transferServiceListener.onConnectionLost(reason);
                }
            }

            @Override // com.transsion.message.cast.transfer.i.CallInterface
            public void onIncomingCall(CallInfo callInfo) {
                Intrinsics.checkNotNullParameter(callInfo, "callInfo");
                Log.d("TransferServiceManager", "Incoming call: " + callInfo);
            }

            @Override // com.transsion.message.cast.transfer.i.SmsInterface
            public void onSmsReceived(SmsInfo smsInfo) {
                Intrinsics.checkNotNullParameter(smsInfo, "smsInfo");
                Log.d("TransferServiceManager", "SMS received: " + smsInfo);
            }
        };
    }
}
