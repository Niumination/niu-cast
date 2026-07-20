package com.transsion.message.cast.notification;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.message.cast.notification.i.NotificationInterface;
import com.transsion.message.cast.notification.i.SmsHandler;
import com.transsion.message.cast.notification.i.SmsNotificationInterface;
import com.transsion.message.cast.notification.impl.NotificationManagerImpl;
import com.transsion.message.cast.notification.impl.SmsNotificationImpl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u0016\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/transsion/message/cast/notification/NotificationFactory;", "", "<init>", "()V", "notificationManager", "Lcom/transsion/message/cast/notification/i/NotificationInterface;", "getNotificationManager$annotations", "smsNotificationManager", "Lcom/transsion/message/cast/notification/i/SmsNotificationInterface;", "getNotificationManager", "getSmsNotificationManager", "setSmsHandler", "", "handler", "Lcom/transsion/message/cast/notification/i/SmsHandler;", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NotificationFactory {
    public static final NotificationFactory INSTANCE = new NotificationFactory();
    private static final NotificationInterface notificationManager = new NotificationManagerImpl();
    private static final SmsNotificationInterface smsNotificationManager = new SmsNotificationImpl();

    private NotificationFactory() {
    }

    @JvmStatic
    private static /* synthetic */ void getNotificationManager$annotations() {
    }

    @JvmStatic
    public static final void setSmsHandler(SmsHandler handler) {
        SmsReplyDispatcher.setHandler(handler);
    }

    public final NotificationInterface getNotificationManager() {
        return notificationManager;
    }

    public final SmsNotificationInterface getSmsNotificationManager() {
        return smsNotificationManager;
    }
}
