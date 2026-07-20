package com.transsion.message.cast.notification.impl;

import a1.a;
import android.R;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.content.ContextCompat;
import com.transsion.message.cast.notification.i.CallHandler;
import com.transsion.message.cast.notification.i.CallNotificationInterface;
import com.transsion.message.cast.transfer.e.EAudioOutput;
import com.transsion.message.cast.transfer.e.ECallState;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 62\u00020\u0001:\u000267B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016JT\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016JD\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010$\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010%\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010&\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010'\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010(\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010)\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J\u001a\u0010*\u001a\u00020+2\b\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010\b\u001a\u00020\u0005H\u0002J \u0010.\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u00100\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0005H\u0002J\b\u00101\u001a\u00020\u0007H\u0002J\u0010\u00102\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u00103\u001a\u0002042\u0006\u0010\t\u001a\u00020\n2\u0006\u00105\u001a\u000204H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/transsion/message/cast/notification/impl/CallNotificationImpl;", "Lcom/transsion/message/cast/notification/i/CallNotificationInterface;", "<init>", "()V", "mRegisterContext", "Landroid/content/Context;", "ring", "", "context", "callId", "", "phoneNumber", "contactName", "location", "deviceName", "callHandler", "Lcom/transsion/message/cast/notification/i/CallHandler;", "showActiveCall", "showActiveCallWithAudioOutput", "audioOutput", "Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "switchAudioOutput", "output", "endActiveCall", "cancelCallNotification", "recoverCall", "showCallNotification", "state", "Lcom/transsion/message/cast/transfer/e/ECallState;", "release", "updateRingingNotification", "updateActiveNotification", "updateDisconnectedNotification", "getRejectPendingIntent", "Landroid/app/PendingIntent;", "getAnswerPendingIntent", "getSpeakerPendingIntent", "getEarpiecePendingIntent", "getFullScreenPendingIntent", "getOtherPendingIntent", "getDismissPendingIntent", "getReproducePendingIntent", "createCaller", "Landroidx/core/app/Person;", "checkPermission", "", "registerActionReceiver", "unregisterActionReceiver", "holdOtherCall", "unregisterAllActionReceivers", "clearAllNotification", "getRequestCode", "", TypedValues.CycleType.S_WAVE_OFFSET, "Companion", "CallNotification", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nCallNotificationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CallNotificationImpl.kt\ncom/transsion/message/cast/notification/impl/CallNotificationImpl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,758:1\n1863#2,2:759\n1863#2,2:761\n1863#2,2:763\n*S KotlinDebug\n*F\n+ 1 CallNotificationImpl.kt\ncom/transsion/message/cast/notification/impl/CallNotificationImpl\n*L\n718#1:759,2\n735#1:761,2\n747#1:763,2\n*E\n"})
public final class CallNotificationImpl implements CallNotificationInterface {
    private static final String ACTION_ANSWER = "com.transsion.message.notification.ACTION_ANSWER";
    private static final String ACTION_CANCEL = "com.transsion.message.notification.ACTION_CANCEL";
    private static final String ACTION_DISMISS = "com.transsion.message.notification.ACTION_DISMISS";
    private static final String ACTION_EARPIECE = "com.transsion.message.notification.ACTION_EARPIECE";
    private static final String ACTION_HOLD = "com.transsion.message.notification.ACTION_HOLD";
    private static final String ACTION_OTHER = "com.transsion.message.notification.ACTION_OTHER";
    private static final String ACTION_REJECT = "com.transsion.message.notification.ACTION_REJECT";
    private static final String ACTION_REPRODUCE = "com.transsion.message.notification.ACTION_REPRODUCE";
    private static final String ACTION_SPEAKER = "com.transsion.message.notification.ACTION_SPEAKER";
    private static final String CALL_ID_EXTRA = "call_id";
    private static final String CHANNEL_ID = "phone_call_channel_silent";
    public static final String TAG = "CallNotificationImpl";
    private Context mRegisterContext;
    private static final Map<String, BroadcastReceiver> mActionReceivers = new LinkedHashMap();
    private static final Map<String, CallNotification> mNotifications = new LinkedHashMap();

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\rHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001fJn\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001f¨\u00062"}, d2 = {"Lcom/transsion/message/cast/notification/impl/CallNotificationImpl$CallNotification;", "", "callId", "", "phoneNumber", "contactName", "location", "deviceName", "state", "Lcom/transsion/message/cast/transfer/e/ECallState;", "audioOutput", "Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "callHandler", "Lcom/transsion/message/cast/notification/i/CallHandler;", "startWhen", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/message/cast/transfer/e/ECallState;Lcom/transsion/message/cast/transfer/e/EAudioOutput;Lcom/transsion/message/cast/notification/i/CallHandler;Ljava/lang/Long;)V", "getCallId", "()Ljava/lang/String;", "getPhoneNumber", "getContactName", "getLocation", "getDeviceName", "getState", "()Lcom/transsion/message/cast/transfer/e/ECallState;", "getAudioOutput", "()Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "getCallHandler", "()Lcom/transsion/message/cast/notification/i/CallHandler;", "getStartWhen", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/transsion/message/cast/transfer/e/ECallState;Lcom/transsion/message/cast/transfer/e/EAudioOutput;Lcom/transsion/message/cast/notification/i/CallHandler;Ljava/lang/Long;)Lcom/transsion/message/cast/notification/impl/CallNotificationImpl$CallNotification;", "equals", "", "other", "hashCode", "", "toString", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final /* data */ class CallNotification {
        private final EAudioOutput audioOutput;
        private final CallHandler callHandler;
        private final String callId;
        private final String contactName;
        private final String deviceName;
        private final String location;
        private final String phoneNumber;
        private final Long startWhen;
        private final ECallState state;

        public CallNotification(String callId, String phoneNumber, String str, String str2, String deviceName, ECallState state, EAudioOutput audioOutput, CallHandler callHandler, Long l4) {
            Intrinsics.checkNotNullParameter(callId, "callId");
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            Intrinsics.checkNotNullParameter(deviceName, "deviceName");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(audioOutput, "audioOutput");
            Intrinsics.checkNotNullParameter(callHandler, "callHandler");
            this.callId = callId;
            this.phoneNumber = phoneNumber;
            this.contactName = str;
            this.location = str2;
            this.deviceName = deviceName;
            this.state = state;
            this.audioOutput = audioOutput;
            this.callHandler = callHandler;
            this.startWhen = l4;
        }

        public static /* synthetic */ CallNotification copy$default(CallNotification callNotification, String str, String str2, String str3, String str4, String str5, ECallState eCallState, EAudioOutput eAudioOutput, CallHandler callHandler, Long l4, int i8, Object obj) {
            return callNotification.copy((i8 & 1) != 0 ? callNotification.callId : str, (i8 & 2) != 0 ? callNotification.phoneNumber : str2, (i8 & 4) != 0 ? callNotification.contactName : str3, (i8 & 8) != 0 ? callNotification.location : str4, (i8 & 16) != 0 ? callNotification.deviceName : str5, (i8 & 32) != 0 ? callNotification.state : eCallState, (i8 & 64) != 0 ? callNotification.audioOutput : eAudioOutput, (i8 & 128) != 0 ? callNotification.callHandler : callHandler, (i8 & 256) != 0 ? callNotification.startWhen : l4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCallId() {
            return this.callId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getContactName() {
            return this.contactName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getLocation() {
            return this.location;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getDeviceName() {
            return this.deviceName;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final ECallState getState() {
            return this.state;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final EAudioOutput getAudioOutput() {
            return this.audioOutput;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final CallHandler getCallHandler() {
            return this.callHandler;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Long getStartWhen() {
            return this.startWhen;
        }

        public final CallNotification copy(String callId, String phoneNumber, String contactName, String location, String deviceName, ECallState state, EAudioOutput audioOutput, CallHandler callHandler, Long startWhen) {
            Intrinsics.checkNotNullParameter(callId, "callId");
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            Intrinsics.checkNotNullParameter(deviceName, "deviceName");
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(audioOutput, "audioOutput");
            Intrinsics.checkNotNullParameter(callHandler, "callHandler");
            return new CallNotification(callId, phoneNumber, contactName, location, deviceName, state, audioOutput, callHandler, startWhen);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CallNotification)) {
                return false;
            }
            CallNotification callNotification = (CallNotification) other;
            return Intrinsics.areEqual(this.callId, callNotification.callId) && Intrinsics.areEqual(this.phoneNumber, callNotification.phoneNumber) && Intrinsics.areEqual(this.contactName, callNotification.contactName) && Intrinsics.areEqual(this.location, callNotification.location) && Intrinsics.areEqual(this.deviceName, callNotification.deviceName) && this.state == callNotification.state && this.audioOutput == callNotification.audioOutput && Intrinsics.areEqual(this.callHandler, callNotification.callHandler) && Intrinsics.areEqual(this.startWhen, callNotification.startWhen);
        }

        public final EAudioOutput getAudioOutput() {
            return this.audioOutput;
        }

        public final CallHandler getCallHandler() {
            return this.callHandler;
        }

        public final String getCallId() {
            return this.callId;
        }

        public final String getContactName() {
            return this.contactName;
        }

        public final String getDeviceName() {
            return this.deviceName;
        }

        public final String getLocation() {
            return this.location;
        }

        public final String getPhoneNumber() {
            return this.phoneNumber;
        }

        public final Long getStartWhen() {
            return this.startWhen;
        }

        public final ECallState getState() {
            return this.state;
        }

        public int hashCode() {
            int iE = a.e(this.callId.hashCode() * 31, 31, this.phoneNumber);
            String str = this.contactName;
            int iHashCode = (iE + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.location;
            int iHashCode2 = (this.callHandler.hashCode() + ((this.audioOutput.hashCode() + ((this.state.hashCode() + a.e((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.deviceName)) * 31)) * 31)) * 31;
            Long l4 = this.startWhen;
            return iHashCode2 + (l4 != null ? l4.hashCode() : 0);
        }

        public String toString() {
            String str = this.callId;
            String str2 = this.phoneNumber;
            String str3 = this.contactName;
            String str4 = this.location;
            String str5 = this.deviceName;
            ECallState eCallState = this.state;
            EAudioOutput eAudioOutput = this.audioOutput;
            CallHandler callHandler = this.callHandler;
            Long l4 = this.startWhen;
            StringBuilder sbP = h0.a.p("CallNotification(callId=", str, ", phoneNumber=", str2, ", contactName=");
            d.A(sbP, str3, ", location=", str4, ", deviceName=");
            sbP.append(str5);
            sbP.append(", state=");
            sbP.append(eCallState);
            sbP.append(", audioOutput=");
            sbP.append(eAudioOutput);
            sbP.append(", callHandler=");
            sbP.append(callHandler);
            sbP.append(", startWhen=");
            sbP.append(l4);
            sbP.append(")");
            return sbP.toString();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ECallState.values().length];
            try {
                iArr[ECallState.RINGING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ECallState.DISCONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ECallState.ACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[EAudioOutput.values().length];
            try {
                iArr2[EAudioOutput.SPEAKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[EAudioOutput.EARPIECE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EAudioOutput.BLUETOOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EAudioOutput.WIRED.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private final boolean checkPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
            return true;
        }
        Log.w(TAG, "Notification permission not granted, requesting permission");
        return false;
    }

    private final void clearAllNotification(Context context) {
        Iterator<T> it = mActionReceivers.keySet().iterator();
        while (it.hasNext()) {
            NotificationManagerCompat.from(context).cancel(getRequestCode((String) it.next(), 0));
        }
        mNotifications.clear();
    }

    private final Person createCaller(String contactName, String phoneNumber) {
        Person.Builder builder = new Person.Builder();
        if (contactName == null) {
            contactName = phoneNumber;
        }
        Person personBuild = builder.setName(contactName).build();
        Intrinsics.checkNotNullExpressionValue(personBuild, "build(...)");
        return personBuild;
    }

    private final PendingIntent getAnswerPendingIntent(Context context, String callId) {
        Intent intent = new Intent(ACTION_ANSWER);
        intent.putExtra(CALL_ID_EXTRA, callId);
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, getRequestCode(callId, 2), intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final PendingIntent getDismissPendingIntent(Context context, String callId) {
        Intent intent = new Intent(ACTION_DISMISS);
        intent.putExtra(CALL_ID_EXTRA, callId);
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, getRequestCode(callId, 7), intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final PendingIntent getEarpiecePendingIntent(Context context, String callId) {
        Intent intent = new Intent(ACTION_EARPIECE);
        intent.putExtra(CALL_ID_EXTRA, callId);
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, getRequestCode(callId, 4), intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final PendingIntent getFullScreenPendingIntent(Context context, String callId) {
        Intent intent = new Intent(ACTION_OTHER);
        intent.putExtra(CALL_ID_EXTRA, callId);
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, getRequestCode(callId, 5), intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final PendingIntent getOtherPendingIntent(Context context, String callId) {
        Intent intent = new Intent(ACTION_OTHER);
        intent.putExtra(CALL_ID_EXTRA, callId);
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, getRequestCode(callId, 6), intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final PendingIntent getRejectPendingIntent(Context context, String callId) {
        Intent intent = new Intent(ACTION_REJECT);
        intent.putExtra(CALL_ID_EXTRA, callId);
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, getRequestCode(callId, 1), intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final PendingIntent getReproducePendingIntent(Context context, String callId) {
        Intent intent = new Intent(ACTION_REPRODUCE);
        intent.putExtra(CALL_ID_EXTRA, callId);
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, getRequestCode(callId, 8), intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getRequestCode(String callId, int offset) {
        return callId.hashCode() + offset;
    }

    private final PendingIntent getSpeakerPendingIntent(Context context, String callId) {
        Intent intent = new Intent(ACTION_SPEAKER);
        intent.putExtra(CALL_ID_EXTRA, callId);
        intent.setPackage(context.getPackageName());
        PendingIntent broadcast = PendingIntent.getBroadcast(context, getRequestCode(callId, 3), intent, 201326592);
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(...)");
        return broadcast;
    }

    private final void holdOtherCall(String callId, Context context) {
        for (String str : mActionReceivers.keySet()) {
            if (!Intrinsics.areEqual(str, callId)) {
                NotificationManagerCompat.from(context).cancel(getRequestCode(str, 0));
                Log.d(TAG, "holdOtherCall callId=" + callId + " otherCallId = " + str);
                Intent intent = new Intent(ACTION_HOLD);
                intent.putExtra(CALL_ID_EXTRA, str);
                intent.setPackage(context.getPackageName());
                context.sendBroadcast(intent);
                return;
            }
        }
        Log.d(TAG, "No need to holdOtherCall");
    }

    private final void registerActionReceiver(Context context, final String callId, final CallHandler callHandler) {
        Map<String, BroadcastReceiver> map = mActionReceivers;
        if (map.containsKey(callId)) {
            return;
        }
        Log.d(TAG, "registerActionReceiver callId=" + callId);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.transsion.message.cast.notification.impl.CallNotificationImpl$registerActionReceiver$actionReceiver$1
            /* JADX WARN: Code duplicated, block: B:29:0x0093  */
            /* JADX WARN: Code duplicated, block: B:32:0x0098  */
            /* JADX WARN: Code duplicated, block: B:35:0x00bb A[Catch: Exception -> 0x0096, TryCatch #6 {Exception -> 0x0096, blocks: (B:27:0x0087, B:33:0x009a, B:35:0x00bb, B:36:0x00c6), top: B:108:0x0087 }] */
            /* JADX WARN: Code duplicated, block: B:36:0x00c6 A[Catch: Exception -> 0x0096, TRY_LEAVE, TryCatch #6 {Exception -> 0x0096, blocks: (B:27:0x0087, B:33:0x009a, B:35:0x00bb, B:36:0x00c6), top: B:108:0x0087 }] */
            /* JADX WARN: Code duplicated, block: B:70:0x0199 A[Catch: all -> 0x01a9, Exception -> 0x01ab, TryCatch #2 {Exception -> 0x01ab, blocks: (B:68:0x017f, B:70:0x0199, B:75:0x01ad), top: B:100:0x017f, outer: #5 }] */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String str;
                if (Intrinsics.areEqual(intent != null ? intent.getStringExtra("call_id") : null, callId)) {
                    Log.d(CallNotificationImpl.TAG, "onReceive action=" + intent.getAction());
                    String action = intent.getAction();
                    if (action != null) {
                        switch (action.hashCode()) {
                            case -936358043:
                                if (action.equals("com.transsion.message.notification.ACTION_OTHER")) {
                                    try {
                                        Log.d(CallNotificationImpl.TAG, "otherAction callId=" + callId);
                                        return;
                                    } catch (Exception e) {
                                        h0.a.w("otherAction failed: ", e.getMessage(), CallNotificationImpl.TAG);
                                        return;
                                    }
                                }
                                return;
                            case -218987230:
                                if (action.equals("com.transsion.message.notification.ACTION_REPRODUCE") && context2 != null) {
                                    try {
                                        NotificationManagerCompat.from(context2).cancel(this.getRequestCode(callId, 0));
                                        this.recoverCall(context2, callId);
                                        return;
                                    } catch (Exception e4) {
                                        h0.a.w("reproduce call fail: ", e4.getMessage(), CallNotificationImpl.TAG);
                                        return;
                                    }
                                }
                                return;
                            case 625917343:
                                if (!action.equals("com.transsion.message.notification.ACTION_DISMISS")) {
                                    return;
                                }
                                try {
                                    try {
                                        Log.d(CallNotificationImpl.TAG, "rejectCall/dismissAction callId=" + callId);
                                        callHandler.rejectCall(callId);
                                        if (context2 != null) {
                                            NotificationManagerCompat.from(context2).cancel(this.getRequestCode(callId, 0));
                                        }
                                        CallNotificationImpl.mNotifications.remove(callId);
                                        break;
                                    } catch (Exception e10) {
                                        Log.e(CallNotificationImpl.TAG, "rejectCall/dismissAction failed: " + e10.getMessage());
                                        break;
                                    }
                                    return;
                                } finally {
                                    this.unregisterActionReceiver(callId);
                                }
                            case 631667177:
                                if (action.equals("com.transsion.message.notification.ACTION_ANSWER")) {
                                    try {
                                        Log.d(CallNotificationImpl.TAG, "answerCall callId=" + callId);
                                        callHandler.answerCall(callId);
                                        return;
                                    } catch (Exception e11) {
                                        h0.a.w("answerCall failed: ", e11.getMessage(), CallNotificationImpl.TAG);
                                        return;
                                    }
                                }
                                return;
                            case 676751525:
                                try {
                                    if (action.equals("com.transsion.message.notification.ACTION_CANCEL")) {
                                        try {
                                            Log.d(CallNotificationImpl.TAG, "cancelCall callId=" + callId);
                                            if (context2 != null) {
                                                NotificationManagerCompat.from(context2).cancel(this.getRequestCode(callId, 0));
                                            }
                                            CallNotificationImpl.mNotifications.remove(callId);
                                            break;
                                        } catch (Exception e12) {
                                            Log.e(CallNotificationImpl.TAG, "cancelCall failed: " + e12.getMessage());
                                        }
                                        return;
                                    }
                                    return;
                                } finally {
                                    this.unregisterActionReceiver(callId);
                                }
                            case 1109765578:
                                if (!action.equals("com.transsion.message.notification.ACTION_REJECT")) {
                                    return;
                                }
                                Log.d(CallNotificationImpl.TAG, "rejectCall/dismissAction callId=" + callId);
                                callHandler.rejectCall(callId);
                                if (context2 != null) {
                                    NotificationManagerCompat.from(context2).cancel(this.getRequestCode(callId, 0));
                                }
                                CallNotificationImpl.mNotifications.remove(callId);
                                return;
                            case 1135444163:
                                if (!action.equals("com.transsion.message.notification.ACTION_EARPIECE")) {
                                    return;
                                }
                                try {
                                    String str2 = callId;
                                    if (Intrinsics.areEqual("com.transsion.message.notification.ACTION_SPEAKER", intent.getAction())) {
                                        str = "SPEAKER";
                                    } else {
                                        str = "EARPIECE";
                                    }
                                    Log.d(CallNotificationImpl.TAG, "setAudioOutput callId=" + str2 + " output=" + str);
                                    if (Intrinsics.areEqual("com.transsion.message.notification.ACTION_SPEAKER", intent.getAction())) {
                                        callHandler.setAudioOutput(callId, EAudioOutput.SPEAKER);
                                    } else {
                                        callHandler.setAudioOutput(callId, EAudioOutput.EARPIECE);
                                    }
                                    return;
                                } catch (Exception e13) {
                                    h0.a.w("setAudioOutput failed: ", e13.getMessage(), CallNotificationImpl.TAG);
                                    return;
                                }
                            case 1240689428:
                                if (!action.equals("com.transsion.message.notification.ACTION_SPEAKER")) {
                                    return;
                                }
                                String str3 = callId;
                                if (Intrinsics.areEqual("com.transsion.message.notification.ACTION_SPEAKER", intent.getAction())) {
                                    str = "SPEAKER";
                                } else {
                                    str = "EARPIECE";
                                }
                                Log.d(CallNotificationImpl.TAG, "setAudioOutput callId=" + str3 + " output=" + str);
                                if (Intrinsics.areEqual("com.transsion.message.notification.ACTION_SPEAKER", intent.getAction())) {
                                    callHandler.setAudioOutput(callId, EAudioOutput.SPEAKER);
                                } else {
                                    callHandler.setAudioOutput(callId, EAudioOutput.EARPIECE);
                                }
                                return;
                            case 1909244330:
                                if (action.equals("com.transsion.message.notification.ACTION_HOLD")) {
                                    try {
                                        Log.d(CallNotificationImpl.TAG, "holdCall callId=" + callId);
                                        return;
                                    } catch (Exception e14) {
                                        h0.a.w("holdCall failed: ", e14.getMessage(), CallNotificationImpl.TAG);
                                        return;
                                    }
                                }
                                return;
                            default:
                                return;
                        }
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_ANSWER);
        intentFilter.addAction(ACTION_REJECT);
        intentFilter.addAction(ACTION_SPEAKER);
        intentFilter.addAction(ACTION_EARPIECE);
        intentFilter.addAction(ACTION_OTHER);
        intentFilter.addAction(ACTION_DISMISS);
        intentFilter.addAction(ACTION_HOLD);
        intentFilter.addAction(ACTION_CANCEL);
        intentFilter.addAction(ACTION_REPRODUCE);
        try {
            Context applicationContext = context.getApplicationContext();
            this.mRegisterContext = applicationContext;
            applicationContext.registerReceiver(broadcastReceiver, intentFilter, 4);
            map.put(callId, broadcastReceiver);
            Log.d(TAG, "registerActionReceiver success for callId=" + callId);
        } catch (Exception e) {
            Log.w(TAG, "registerReceiver warning: " + e.getMessage());
        }
    }

    private final void showCallNotification(Context context, String callId, String phoneNumber, String contactName, String location, String deviceName, ECallState state, EAudioOutput audioOutput, CallHandler callHandler) {
        if (checkPermission(context)) {
            int i8 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i8 == 1) {
                updateRingingNotification(context, callId, phoneNumber, contactName, location, deviceName, callHandler);
            } else if (i8 == 2) {
                updateDisconnectedNotification(context, callId);
            } else {
                if (i8 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                updateActiveNotification(context, callId, audioOutput);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterActionReceiver(String callId) {
        Context context;
        Map<String, BroadcastReceiver> map = mActionReceivers;
        if (map.containsKey(callId)) {
            try {
                try {
                    Log.d(TAG, "unregisterActionReceiver for callId=" + callId);
                    BroadcastReceiver broadcastReceiver = map.get(callId);
                    if (broadcastReceiver != null && (context = this.mRegisterContext) != null) {
                        context.unregisterReceiver(broadcastReceiver);
                    }
                    map.remove(callId);
                    if (!map.isEmpty()) {
                        return;
                    }
                } catch (Exception e) {
                    Log.w(TAG, "unregisterReceiver warning: " + e.getMessage());
                    Map<String, BroadcastReceiver> map2 = mActionReceivers;
                    map2.remove(callId);
                    if (!map2.isEmpty()) {
                        return;
                    }
                }
                this.mRegisterContext = null;
                Log.d(TAG, "unregisterAllActionReceivers success");
            } catch (Throwable th2) {
                Map<String, BroadcastReceiver> map3 = mActionReceivers;
                map3.remove(callId);
                if (map3.isEmpty()) {
                    this.mRegisterContext = null;
                    Log.d(TAG, "unregisterAllActionReceivers success");
                }
                throw th2;
            }
        }
    }

    private final void unregisterAllActionReceivers() {
        for (BroadcastReceiver broadcastReceiver : mActionReceivers.values()) {
            Context context = this.mRegisterContext;
            if (context != null) {
                context.unregisterReceiver(broadcastReceiver);
            }
        }
        mActionReceivers.clear();
        this.mRegisterContext = null;
        Log.d(TAG, "unregisterAllActionReceivers success");
    }

    private final void updateActiveNotification(Context context, String callId, EAudioOutput audioOutput) {
        Long startWhen;
        Log.d(TAG, "updateActiveNotification callId=" + callId + ", audioOutput=" + audioOutput);
        Map<String, CallNotification> map = mNotifications;
        CallNotification callNotification = map.get(callId);
        if (callNotification == null) {
            return;
        }
        Log.d(TAG, "updateActiveNotification callNotification=" + callNotification);
        ECallState eCallState = ECallState.ACTIVE;
        Long startWhen2 = callNotification.getStartWhen();
        map.put(callId, CallNotification.copy$default(callNotification, null, null, null, null, null, eCallState, audioOutput, null, Long.valueOf(startWhen2 != null ? startWhen2.longValue() : System.currentTimeMillis()), 159, null));
        Person personCreateCaller = createCaller(callNotification.getContactName(), callNotification.getPhoneNumber());
        registerActionReceiver(context, callId, callNotification.getCallHandler());
        PendingIntent reproducePendingIntent = getReproducePendingIntent(context, callId);
        NotificationCompat.Builder usesChronometer = new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(R.drawable.ic_menu_call).setStyle(NotificationCompat.CallStyle.forOngoingCall(personCreateCaller, getRejectPendingIntent(context, callId))).setFullScreenIntent(reproducePendingIntent, true).setContentIntent(reproducePendingIntent).setChronometerCountDown(false).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setUsesChronometer(true);
        CallNotification callNotification2 = map.get(callId);
        NotificationCompat.Builder deleteIntent = usesChronometer.setWhen((callNotification2 == null || (startWhen = callNotification2.getStartWhen()) == null) ? System.currentTimeMillis() : startWhen.longValue()).setCategory(NotificationCompat.CATEGORY_CALL).setVisibility(1).setDeleteIntent(getDismissPendingIntent(context, callId));
        int i8 = WhenMappings.$EnumSwitchMapping$1[audioOutput.ordinal()];
        if (i8 == 1) {
            deleteIntent.addAction(R.drawable.sym_call_outgoing, context.getString(com.transsion.message.cast.R.string.call_audio_output_speaker), getEarpiecePendingIntent(context, callId));
        } else if (i8 == 2) {
            deleteIntent.addAction(R.drawable.stat_sys_speakerphone, context.getString(com.transsion.message.cast.R.string.call_audio_output_earpiece), getSpeakerPendingIntent(context, callId));
        } else if (i8 == 3) {
            deleteIntent.addAction(R.drawable.stat_sys_data_bluetooth, context.getString(com.transsion.message.cast.R.string.call_audio_output_bluetooth), getOtherPendingIntent(context, callId));
        } else {
            if (i8 != 4) {
                throw new NoWhenBranchMatchedException();
            }
            deleteIntent.addAction(R.drawable.ic_btn_speak_now, context.getString(com.transsion.message.cast.R.string.call_audio_output_wire), getOtherPendingIntent(context, callId));
        }
        Notification notificationBuild = deleteIntent.build();
        if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") != 0) {
            Log.d(TAG, "updateActiveNotification: no permission");
        } else {
            NotificationManagerCompat.from(context).notify(getRequestCode(callId, 0), notificationBuild);
        }
    }

    private final void updateDisconnectedNotification(Context context, String callId) {
        NotificationManagerCompat.from(context).cancel(getRequestCode(callId, 0));
        mNotifications.remove(callId);
        unregisterActionReceiver(callId);
    }

    private final void updateRingingNotification(Context context, String callId, String phoneNumber, String contactName, String location, String deviceName, CallHandler callHandler) {
        holdOtherCall(callId, context);
        Person personCreateCaller = createCaller(contactName, phoneNumber);
        registerActionReceiver(context, callId, callHandler);
        PendingIntent reproducePendingIntent = getReproducePendingIntent(context, callId);
        PendingIntent rejectPendingIntent = getRejectPendingIntent(context, callId);
        PendingIntent answerPendingIntent = getAnswerPendingIntent(context, callId);
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(context, CHANNEL_ID).setSmallIcon(R.drawable.ic_menu_call);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = context.getString(com.transsion.message.cast.R.string.call_from);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Notification notificationBuild = smallIcon.setContentText(location + " | " + d.q(new Object[]{deviceName}, 1, string, "format(...)")).setStyle(NotificationCompat.CallStyle.forIncomingCall(personCreateCaller, rejectPendingIntent, answerPendingIntent)).setFullScreenIntent(reproducePendingIntent, true).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setCategory(NotificationCompat.CATEGORY_CALL).setVisibility(1).setDeleteIntent(getDismissPendingIntent(context, callId)).build();
        if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") != 0) {
            Log.d(TAG, "updateRingingNotification: no permission");
        } else {
            NotificationManagerCompat.from(context).notify(getRequestCode(callId, 0), notificationBuild);
        }
    }

    @Override // com.transsion.message.cast.notification.i.CallNotificationInterface
    public void cancelCallNotification(Context context, String callId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callId, "callId");
        this.mRegisterContext = context;
        Intent intent = new Intent(ACTION_CANCEL);
        intent.putExtra(CALL_ID_EXTRA, callId);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    @Override // com.transsion.message.cast.notification.i.CallNotificationInterface
    public void endActiveCall(Context context, String callId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callId, "callId");
        this.mRegisterContext = context;
        Intent intent = new Intent(ACTION_REJECT);
        intent.putExtra(CALL_ID_EXTRA, callId);
        intent.setPackage(context.getPackageName());
        context.sendBroadcast(intent);
    }

    @Override // com.transsion.message.cast.notification.i.CallNotificationInterface
    public void recoverCall(Context context, String callId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callId, "callId");
        this.mRegisterContext = context;
        CallNotification callNotification = mNotifications.get(callId);
        if (callNotification == null) {
            return;
        }
        if (callNotification.getState() != ECallState.ACTIVE) {
            ring(context, callId, callNotification.getPhoneNumber(), callNotification.getContactName(), callNotification.getLocation(), callNotification.getDeviceName(), callNotification.getCallHandler());
        } else {
            updateActiveNotification(context, callId, callNotification.getAudioOutput());
        }
    }

    @Override // com.transsion.message.cast.notification.i.CallNotificationInterface
    public void release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d(TAG, "release ringing notification");
        clearAllNotification(context);
        unregisterAllActionReceivers();
    }

    @Override // com.transsion.message.cast.notification.i.CallNotificationInterface
    public void ring(Context context, String callId, String phoneNumber, String contactName, String location, String deviceName, CallHandler callHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(callHandler, "callHandler");
        this.mRegisterContext = context;
        Map<String, CallNotification> map = mNotifications;
        ECallState eCallState = ECallState.RINGING;
        EAudioOutput eAudioOutput = EAudioOutput.SPEAKER;
        map.put(callId, new CallNotification(callId, phoneNumber, contactName, location, deviceName, eCallState, eAudioOutput, callHandler, null));
        showCallNotification(context, callId, phoneNumber, contactName, location, deviceName, eCallState, eAudioOutput, callHandler);
    }

    @Override // com.transsion.message.cast.notification.i.CallNotificationInterface
    public void showActiveCall(Context context, String callId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callId, "callId");
        Log.d(TAG, "showActiveCall: " + callId);
        this.mRegisterContext = context;
        CallNotification callNotification = mNotifications.get(callId);
        if (callNotification == null) {
            return;
        }
        Log.d(TAG, "showCallNotification: " + callId);
        showCallNotification(context, callId, callNotification.getPhoneNumber(), callNotification.getContactName(), callNotification.getLocation(), callNotification.getDeviceName(), ECallState.ACTIVE, callNotification.getAudioOutput(), callNotification.getCallHandler());
    }

    @Override // com.transsion.message.cast.notification.i.CallNotificationInterface
    public void showActiveCallWithAudioOutput(Context context, String callId, EAudioOutput audioOutput) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(audioOutput, "audioOutput");
        this.mRegisterContext = context;
        Map<String, CallNotification> map = mNotifications;
        CallNotification callNotification = map.get(callId);
        if (callNotification == null) {
            return;
        }
        map.put(callId, CallNotification.copy$default(callNotification, null, null, null, null, null, ECallState.ACTIVE, null, null, null, 479, null));
        switchAudioOutput(context, callId, audioOutput);
    }

    @Override // com.transsion.message.cast.notification.i.CallNotificationInterface
    public void switchAudioOutput(Context context, String callId, EAudioOutput output) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(output, "output");
        Log.d(TAG, "switchAudioOutput: " + callId);
        this.mRegisterContext = context;
        Map<String, CallNotification> map = mNotifications;
        CallNotification callNotification = map.get(callId);
        if (callNotification == null) {
            return;
        }
        d.B("switchAudioOutput: ", callNotification.getCallId(), TAG);
        map.put(callId, CallNotification.copy$default(callNotification, null, null, null, null, null, null, output, null, null, 447, null));
        showCallNotification(context, callId, callNotification.getPhoneNumber(), callNotification.getContactName(), callNotification.getLocation(), callNotification.getDeviceName(), callNotification.getState(), output, callNotification.getCallHandler());
    }
}
