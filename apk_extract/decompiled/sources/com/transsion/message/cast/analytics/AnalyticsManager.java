package com.transsion.message.cast.analytics;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.transsion.message.cast.analytics.i.AnalyticsInterface;
import com.transsion.message.cast.analytics.p000const.EAnalyticsEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\r\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J*\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\fH\u0002J\u001e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nJ\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ&\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nJ\u0016\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/transsion/message/cast/analytics/AnalyticsManager;", "", "<init>", "()V", "analyticsInterface", "Lcom/transsion/message/cast/analytics/i/AnalyticsInterface;", "setAnalyticsInterface", "", "trackEvent", NotificationCompat.CATEGORY_EVENT, "", "params", "", "trackCallEvent", "connectedDeviceName", "did", "model", "trackCancelCallEvent", "trackSwitchOutputAudioEvent", "switchTo", "connectedDeviceType", "trackSmsEvent", "trackCancelSmsEvent", "trackReplySmsEvent", "Companion", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AnalyticsManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile AnalyticsManager INSTANCE = null;
    private static final String TAG = "AnalyticsManager";
    private AnalyticsInterface analyticsInterface;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/transsion/message/cast/analytics/AnalyticsManager$Companion;", "", "<init>", "()V", "TAG", "", "INSTANCE", "Lcom/transsion/message/cast/analytics/AnalyticsManager;", "getInstance", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final AnalyticsManager getInstance() {
            AnalyticsManager analyticsManager = AnalyticsManager.INSTANCE;
            if (analyticsManager == null) {
                synchronized (this) {
                    analyticsManager = AnalyticsManager.INSTANCE;
                    if (analyticsManager == null) {
                        analyticsManager = new AnalyticsManager(null);
                        AnalyticsManager.INSTANCE = analyticsManager;
                    }
                }
            }
            return analyticsManager;
        }

        private Companion() {
        }
    }

    public /* synthetic */ AnalyticsManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final AnalyticsManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final void trackEvent(String event, Map<String, ? extends Object> params) {
        AnalyticsInterface analyticsInterface = this.analyticsInterface;
        if (analyticsInterface == null) {
            d.B("AnalyticsInterface not set, event ignored: ", event, TAG);
            return;
        }
        try {
            Log.d(TAG, "Track event: " + event + ", params: " + params);
            analyticsInterface.trackCallEvent(event, params);
            Unit unit = Unit.INSTANCE;
        } catch (Exception e) {
            Log.e(TAG, "Error tracking event: " + event, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackEvent$default(AnalyticsManager analyticsManager, String str, Map map, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            map = null;
        }
        analyticsManager.trackEvent(str, map);
    }

    public final void setAnalyticsInterface(AnalyticsInterface analyticsInterface) {
        Intrinsics.checkNotNullParameter(analyticsInterface, "analyticsInterface");
        this.analyticsInterface = analyticsInterface;
        Log.d(TAG, "AnalyticsInterface set: " + analyticsInterface);
    }

    public final void trackCallEvent(String connectedDeviceName, String did, String model) {
        Intrinsics.checkNotNullParameter(connectedDeviceName, "connectedDeviceName");
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter(model, "model");
        trackEvent(EAnalyticsEvent.IOT_PC_CALL_TRANSFER, MapsKt.mapOf(TuplesKt.to("connected_device_name", connectedDeviceName), TuplesKt.to("did", did), TuplesKt.to("model", model)));
    }

    public final void trackCancelCallEvent(String connectedDeviceName, String did) {
        Intrinsics.checkNotNullParameter(connectedDeviceName, "connectedDeviceName");
        Intrinsics.checkNotNullParameter(did, "did");
        trackEvent(EAnalyticsEvent.IOT_PC_CANCEL_CALL_EVENT, MapsKt.mapOf(TuplesKt.to("connected_device_name", connectedDeviceName), TuplesKt.to("did", did)));
    }

    public final void trackCancelSmsEvent(String connectedDeviceName, String did) {
        Intrinsics.checkNotNullParameter(connectedDeviceName, "connectedDeviceName");
        Intrinsics.checkNotNullParameter(did, "did");
        trackEvent(EAnalyticsEvent.IOT_PC_CANCEL_SMS_EVENT, MapsKt.mapOf(TuplesKt.to("connected_device_name", connectedDeviceName), TuplesKt.to("did", did)));
    }

    public final void trackReplySmsEvent(String connectedDeviceName, String did) {
        Intrinsics.checkNotNullParameter(connectedDeviceName, "connectedDeviceName");
        Intrinsics.checkNotNullParameter(did, "did");
        trackEvent(EAnalyticsEvent.IOT_PC_REPLY_SMS_EVENT, MapsKt.mapOf(TuplesKt.to("connected_device_name", connectedDeviceName), TuplesKt.to("did", did)));
    }

    public final void trackSmsEvent(String connectedDeviceName, String did) {
        Intrinsics.checkNotNullParameter(connectedDeviceName, "connectedDeviceName");
        Intrinsics.checkNotNullParameter(did, "did");
        trackEvent(EAnalyticsEvent.IOT_PC_SMS_TRANSFER, MapsKt.mapOf(TuplesKt.to("connected_device_name", connectedDeviceName), TuplesKt.to("did", did)));
    }

    public final void trackSwitchOutputAudioEvent(String connectedDeviceName, String did, String switchTo, String connectedDeviceType) {
        Intrinsics.checkNotNullParameter(connectedDeviceName, "connectedDeviceName");
        Intrinsics.checkNotNullParameter(did, "did");
        Intrinsics.checkNotNullParameter(switchTo, "switchTo");
        Intrinsics.checkNotNullParameter(connectedDeviceType, "connectedDeviceType");
        trackEvent(EAnalyticsEvent.IOT_PC_SWITCH_OUTPUT_AUDIO_EVENT, MapsKt.mapOf(TuplesKt.to("connected_device_name", connectedDeviceName), TuplesKt.to("did", did), TuplesKt.to("switch_to", switchTo), TuplesKt.to("connected_device_type", connectedDeviceType)));
    }

    private AnalyticsManager() {
    }
}
