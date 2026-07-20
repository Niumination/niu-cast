package com.transsion.message.cast.notification.i;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.cast.transfer.e.EAudioOutput;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001JJ\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H&J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0011H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0018"}, d2 = {"Lcom/transsion/message/cast/notification/i/CallNotificationInterface;", "", "ring", "", "context", "Landroid/content/Context;", "callId", "", "phoneNumber", "contactName", "location", "deviceName", "callHandler", "Lcom/transsion/message/cast/notification/i/CallHandler;", "showActiveCall", "showActiveCallWithAudioOutput", "audioOutput", "Lcom/transsion/message/cast/transfer/e/EAudioOutput;", "switchAudioOutput", "output", "endActiveCall", "cancelCallNotification", "recoverCall", "release", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface CallNotificationInterface {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        public static /* synthetic */ void ring$default(CallNotificationInterface callNotificationInterface, Context context, String str, String str2, String str3, String str4, String str5, CallHandler callHandler, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ring");
            }
            callNotificationInterface.ring(context, str, str2, (i8 & 8) != 0 ? null : str3, (i8 & 16) != 0 ? null : str4, (i8 & 32) != 0 ? "Unknown Device" : str5, callHandler);
        }
    }

    void cancelCallNotification(Context context, String callId);

    void endActiveCall(Context context, String callId);

    void recoverCall(Context context, String callId);

    void release(Context context);

    void ring(Context context, String callId, String phoneNumber, String contactName, String location, String deviceName, CallHandler callHandler);

    void showActiveCall(Context context, String callId);

    void showActiveCallWithAudioOutput(Context context, String callId, EAudioOutput audioOutput);

    void switchAudioOutput(Context context, String callId, EAudioOutput output);
}
