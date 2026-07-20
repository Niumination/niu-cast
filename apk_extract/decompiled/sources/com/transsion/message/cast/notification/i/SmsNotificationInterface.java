package com.transsion.message.cast.notification.i;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.atomiccore.support.host.AtomicIntentType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u0010"}, d2 = {"Lcom/transsion/message/cast/notification/i/SmsNotificationInterface;", "", "showSmsNotification", "", AtomicIntentType.ACTIVITY, "Landroid/content/Context;", "smsId", "", "phoneNumber", "contactName", "content", "timestamp", "", "deviceName", "createNotificationChannel", "cancelSmsNotification", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public interface SmsNotificationInterface {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class DefaultImpls {
        public static /* synthetic */ void showSmsNotification$default(SmsNotificationInterface smsNotificationInterface, Context context, String str, String str2, String str3, String str4, long j8, String str5, int i8, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSmsNotification");
            }
            smsNotificationInterface.showSmsNotification(context, str, str2, (i8 & 8) != 0 ? null : str3, str4, (i8 & 32) != 0 ? System.currentTimeMillis() : j8, (i8 & 64) != 0 ? "Unknown Device" : str5);
        }
    }

    void cancelSmsNotification(Context activity, String phoneNumber, long timestamp);

    void createNotificationChannel(Context activity);

    void showSmsNotification(Context activity, String smsId, String phoneNumber, String contactName, String content, long timestamp, String deviceName);
}
