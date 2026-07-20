package com.transsion.message.cast.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/transsion/message/cast/notification/NotificationActionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NotificationActionReceiver extends BroadcastReceiver {
    public static final String ACTION_MARK_READ = "com.example.msgapplication.ACTION_MARK_READ";
    public static final String ACTION_REPLY_AND_OPEN_CHAT = "com.example.msgapplication.ACTION_REPLY_AND_OPEN_CHAT";
    public static final String EXTRA_NOTIFICATION_ID = "notification_id";
    public static final String EXTRA_PHONE_NUMBER = "phone_number";
    public static final String EXTRA_SMS_ID = "sms_id";
    public static final String TAG = "NotificationActionReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        int intExtra = intent.getIntExtra(EXTRA_NOTIFICATION_ID, 0);
        String action = intent.getAction();
        if (action != null) {
            int iHashCode = action.hashCode();
            if (iHashCode == -2116931091) {
                if (action.equals(ACTION_MARK_READ)) {
                    Log.d(TAG, "ACTION_MARK_READ");
                    if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") == 0) {
                        try {
                            NotificationManagerCompat.from(context).cancel(intExtra);
                        } catch (SecurityException e) {
                            Log.e(TAG, "NotificationManagerCompat.cancel() failed", e);
                        }
                    }
                    String stringExtra = intent.getStringExtra(EXTRA_PHONE_NUMBER);
                    Log.d(TAG, "ACTION_MARK_READ phoneNumber: " + stringExtra);
                    String stringExtra2 = intent.getStringExtra(EXTRA_SMS_ID);
                    if (stringExtra2 == null) {
                        stringExtra2 = String.valueOf(intExtra);
                    }
                    d.B("ACTION_MARK_READ smsId: ", stringExtra2, TAG);
                    if (stringExtra == null || stringExtra.length() == 0) {
                        return;
                    }
                    SmsReplyDispatcher.markReadClicked(stringExtra, stringExtra2);
                    return;
                }
                return;
            }
            if (iHashCode == -1972139307 && action.equals(ACTION_REPLY_AND_OPEN_CHAT)) {
                String stringExtra3 = intent.getStringExtra(EXTRA_PHONE_NUMBER);
                String stringExtra4 = intent.getStringExtra(EXTRA_SMS_ID);
                if (stringExtra4 == null && (stringExtra4 = intent.getStringExtra("smsId")) == null) {
                    stringExtra4 = String.valueOf(intExtra);
                }
                if (stringExtra3 != null && stringExtra3.length() != 0) {
                    SmsReplyDispatcher.replyClicked(stringExtra3, stringExtra4);
                }
                NotificationManagerCompat.from(context).cancel(intExtra);
                Intent intent2 = new Intent();
                intent2.setClassName(context, "com.transsion.message.cast.ChatActivity");
                intent2.setFlags(805306368);
                intent2.putExtra("phoneNumber", stringExtra3);
                intent2.putExtra("contactName", intent.getStringExtra("contactName"));
                intent2.putExtra("deviceName", intent.getStringExtra("deviceName"));
                intent2.putExtra("timestamp", intent.getLongExtra("timestamp", 0L));
                intent2.putExtra("smsId", intent.getStringExtra("smsId"));
                intent2.putExtra("content", intent.getStringExtra("content"));
                intent2.putExtra("address", intent.getStringExtra("address"));
                intent2.putExtra("openFromNotification", true);
                context.startActivity(intent2);
            }
        }
    }
}
