package com.transsion.message.cast.notification.impl;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.EnvironmentCompat;
import com.transsion.message.cast.notification.i.NotificationInterface;
import h0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016JD\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0017J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0003¨\u0006\u001e"}, d2 = {"Lcom/transsion/message/cast/notification/impl/NotificationManagerImpl;", "Lcom/transsion/message/cast/notification/i/NotificationInterface;", "<init>", "()V", "createNotificationChannel", "", "context", "Landroid/content/Context;", "showCallNotification", "callId", "", "phoneNumber", "contactName", "location", "deviceName", "state", "cancelAllNotifications", "cancelCallNotification", "getCallTypeString", "getNotificationTitle", "getNotificationContent", "callerName", "getNotificationStyle", "Landroid/app/Notification$Style;", "caller", "Landroid/app/Person;", "declineIntent", "Landroid/app/PendingIntent;", "answerIntent", "Companion", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NotificationManagerImpl implements NotificationInterface {
    private static final String CHANNEL_ID = "phone_call_channel_silent";
    private static final String TAG = "NotificationManagerImpl";

    private final String getCallTypeString(String state) {
        int iHashCode = state.hashCode();
        if (iHashCode != -1383268394) {
            if (iHashCode != 1925008274) {
                if (iHashCode == 1925346054 && state.equals("ACTIVE")) {
                    return "ongoing";
                }
            } else if (state.equals("RINGING")) {
                return "incoming";
            }
        } else if (state.equals("SCREENING")) {
            return "screening";
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    private final String getNotificationContent(String state, String callerName) {
        int iHashCode = state.hashCode();
        if (iHashCode != -1383268394) {
            if (iHashCode != 1925008274) {
                if (iHashCode == 1925346054 && state.equals("ACTIVE")) {
                    return a.i("with ", callerName);
                }
            } else if (state.equals("RINGING")) {
                return a.i("from ", callerName);
            }
        } else if (state.equals("SCREENING")) {
            return a.i("with ", callerName);
        }
        return a.i("from ", callerName);
    }

    @RequiresApi(34)
    private final Notification.Style getNotificationStyle(String state, Person caller, PendingIntent declineIntent, PendingIntent answerIntent) {
        int iHashCode = state.hashCode();
        if (iHashCode != -1383268394) {
            if (iHashCode != 1925008274) {
                if (iHashCode == 1925346054 && state.equals("ACTIVE")) {
                    Notification.CallStyle callStyleForOngoingCall = Notification.CallStyle.forOngoingCall(caller, declineIntent);
                    Intrinsics.checkNotNullExpressionValue(callStyleForOngoingCall, "forOngoingCall(...)");
                    return callStyleForOngoingCall;
                }
            } else if (state.equals("RINGING")) {
                Notification.CallStyle callStyleForIncomingCall = Notification.CallStyle.forIncomingCall(caller, declineIntent, answerIntent);
                Intrinsics.checkNotNullExpressionValue(callStyleForIncomingCall, "forIncomingCall(...)");
                return callStyleForIncomingCall;
            }
        } else if (state.equals("SCREENING")) {
            Notification.CallStyle callStyleForScreeningCall = Notification.CallStyle.forScreeningCall(caller, declineIntent, answerIntent);
            Intrinsics.checkNotNullExpressionValue(callStyleForScreeningCall, "forScreeningCall(...)");
            return callStyleForScreeningCall;
        }
        Notification.CallStyle callStyleForIncomingCall2 = Notification.CallStyle.forIncomingCall(caller, declineIntent, answerIntent);
        Intrinsics.checkNotNullExpressionValue(callStyleForIncomingCall2, "forIncomingCall(...)");
        return callStyleForIncomingCall2;
    }

    private final String getNotificationTitle(String state) {
        int iHashCode = state.hashCode();
        if (iHashCode != -1383268394) {
            if (iHashCode != 1925008274) {
                if (iHashCode == 1925346054 && state.equals("ACTIVE")) {
                    return "Ongoing Call";
                }
            } else if (state.equals("RINGING")) {
                return "Incoming Call";
            }
        } else if (state.equals("SCREENING")) {
            return "Screening Call";
        }
        return "Call";
    }

    @Override // com.transsion.message.cast.notification.i.NotificationInterface
    public void cancelAllNotifications(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        NotificationManagerCompat.from(context).cancelAll();
        Log.d(TAG, "All notifications cancelled");
    }

    @Override // com.transsion.message.cast.notification.i.NotificationInterface
    public void cancelCallNotification(Context context, String callId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callId, "callId");
        NotificationManagerCompat.from(context).cancel(callId.hashCode());
        Log.d(TAG, "Call notification cancelled: ".concat(callId));
    }

    @Override // com.transsion.message.cast.notification.i.NotificationInterface
    public void createNotificationChannel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Log.d(TAG, "Creating notification channels");
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Call Notification", 4);
        notificationChannel.setDescription("Used to display incoming call notifications");
        notificationChannel.setSound(null, null);
        Object systemService = context.getSystemService((Class<Object>) NotificationManager.class);
        Intrinsics.checkNotNullExpressionValue(systemService, "getSystemService(...)");
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
        Log.d(TAG, "Call notification channel created successfully");
    }

    @Override // com.transsion.message.cast.notification.i.NotificationInterface
    @RequiresApi(34)
    public void showCallNotification(Context context, String callId, String phoneNumber, String contactName, String location, String deviceName, String state) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callId, "callId");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(state, "state");
        if (Build.VERSION.SDK_INT < 34) {
            Log.w(TAG, "Skipping call notification on pre-Android 14");
            return;
        }
        StringBuilder sbP = a.p("Showing call notification: callId=", callId, ", phoneNumber=", phoneNumber, ", contactName=");
        sbP.append(contactName);
        sbP.append(", state=");
        sbP.append(state);
        Log.d(TAG, sbP.toString());
        if (ContextCompat.checkSelfPermission(context, "android.permission.POST_NOTIFICATIONS") != 0) {
            Log.w(TAG, "Notification permission not granted; skipping showCallNotification");
            return;
        }
        String str = contactName == null ? phoneNumber : contactName;
        Person personBuild = new Person.Builder().setName(str).setImportant(true).build();
        Intrinsics.checkNotNullExpressionValue(personBuild, "build(...)");
        Intent intent = new Intent(context, context.getClass());
        intent.setFlags(268468224);
        intent.putExtra("callerName", str);
        intent.putExtra("callType", getCallTypeString(state));
        intent.putExtra("callId", callId);
        intent.putExtra("phoneNumber", phoneNumber);
        intent.putExtra("contactName", contactName);
        intent.putExtra("location", location);
        intent.putExtra("deviceName", deviceName);
        Intent intent2 = new Intent(context, context.getClass());
        intent2.setFlags(268468224);
        intent2.putExtra("callerName", str);
        intent2.putExtra("callType", getCallTypeString(state));
        intent2.putExtra("callId", callId);
        intent2.putExtra("phoneNumber", phoneNumber);
        intent2.putExtra("contactName", contactName);
        intent2.putExtra("location", location);
        intent2.putExtra("deviceName", deviceName);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 201326592);
        PendingIntent activity2 = PendingIntent.getActivity(context, 1, intent, 201326592);
        PendingIntent activity3 = PendingIntent.getActivity(context, 2, intent2, 201326592);
        Notification.Builder contentText = new Notification.Builder(context, CHANNEL_ID).setSmallIcon(R.drawable.ic_menu_call).setContentTitle(getNotificationTitle(state)).setContentText(getNotificationContent(state, str));
        Intrinsics.checkNotNull(activity);
        Intrinsics.checkNotNull(activity2);
        Notification.Builder autoCancel = contentText.setStyle(getNotificationStyle(state, personBuild, activity, activity2)).setFullScreenIntent(activity3, true).setOngoing(true).setAutoCancel(false);
        Intrinsics.checkNotNullExpressionValue(autoCancel, "setAutoCancel(...)");
        Notification notificationBuild = autoCancel.build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "build(...)");
        NotificationManagerCompat.from(context).notify(callId.hashCode(), notificationBuild);
        d.x(callId.hashCode(), "Call notification shown successfully with ID: ", TAG);
    }
}
