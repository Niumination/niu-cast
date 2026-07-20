package com.transsion.message.cast.notification.impl;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.transsion.atomiccore.support.host.AtomicIntentType;
import com.transsion.message.cast.R;
import com.transsion.message.cast.notification.NotificationActionReceiver;
import com.transsion.message.cast.notification.SmsReplyDispatcher;
import com.transsion.message.cast.notification.i.SmsNotificationInterface;
import h0.a;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0015"}, d2 = {"Lcom/transsion/message/cast/notification/impl/SmsNotificationImpl;", "Lcom/transsion/message/cast/notification/i/SmsNotificationInterface;", "<init>", "()V", "showSmsNotification", "", AtomicIntentType.ACTIVITY, "Landroid/content/Context;", "smsId", "", "phoneNumber", "contactName", "content", "timestamp", "", "deviceName", "loadContactPhoto", "Landroid/graphics/Bitmap;", "createNotificationChannel", "cancelSmsNotification", "Companion", "messagecast_release"}, k = 1, mv = {2, 0, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nSmsNotificationImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SmsNotificationImpl.kt\ncom/transsion/message/cast/notification/impl/SmsNotificationImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,248:1\n1#2:249\n*E\n"})
public final class SmsNotificationImpl implements SmsNotificationInterface {
    private static final String SMS_CHANNEL_ID = "sms_message_channel";
    private static final String TAG = "SmsNotificationImpl";
    private static Integer lastSmsNotificationId;

    /* JADX WARN: Code duplicated, block: B:30:0x006d  */
    private final Bitmap loadContactPhoto(Context activity, String phoneNumber) {
        Bitmap bitmapDecodeStream;
        try {
            if (ContextCompat.checkSelfPermission(activity, "android.permission.READ_CONTACTS") != 0) {
                return null;
            }
            Cursor cursorQuery = activity.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(phoneNumber)), new String[]{"_id", "photo_uri"}, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            Cursor cursor = cursorQuery;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.moveToFirst()) {
                    int columnIndex = cursor2.getColumnIndex("photo_uri");
                    int columnIndex2 = cursor2.getColumnIndex("_id");
                    String string = columnIndex != -1 ? cursor2.getString(columnIndex) : null;
                    if (string == null || string.length() == 0) {
                        Long lValueOf = columnIndex2 != -1 ? Long.valueOf(cursor2.getLong(columnIndex2)) : null;
                        if (lValueOf != null) {
                            Uri uriWithAppendedId = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, lValueOf.longValue());
                            Intrinsics.checkNotNullExpressionValue(uriWithAppendedId, "withAppendedId(...)");
                            InputStream inputStreamOpenContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(activity.getContentResolver(), uriWithAppendedId, true);
                            if (inputStreamOpenContactPhotoInputStream != null) {
                                try {
                                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenContactPhotoInputStream);
                                    CloseableKt.closeFinally(inputStreamOpenContactPhotoInputStream, null);
                                } catch (Throwable th2) {
                                    try {
                                        throw th2;
                                    } catch (Throwable th3) {
                                        CloseableKt.closeFinally(inputStreamOpenContactPhotoInputStream, th2);
                                        throw th3;
                                    }
                                }
                            } else {
                                bitmapDecodeStream = null;
                            }
                        } else {
                            bitmapDecodeStream = null;
                        }
                    } else {
                        InputStream inputStreamOpenInputStream = activity.getContentResolver().openInputStream(Uri.parse(string));
                        if (inputStreamOpenInputStream != null) {
                            try {
                                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
                                CloseableKt.closeFinally(inputStreamOpenInputStream, null);
                            } catch (Throwable th4) {
                                try {
                                    throw th4;
                                } catch (Throwable th5) {
                                    CloseableKt.closeFinally(inputStreamOpenInputStream, th4);
                                    throw th5;
                                }
                            }
                        } else {
                            bitmapDecodeStream = null;
                        }
                    }
                } else {
                    bitmapDecodeStream = null;
                }
                CloseableKt.closeFinally(cursor, null);
                return bitmapDecodeStream;
            } catch (Throwable th6) {
                try {
                    throw th6;
                } catch (Throwable th7) {
                    CloseableKt.closeFinally(cursor, th6);
                    throw th7;
                }
            }
        } catch (Exception e) {
            a.w("Error loading contact photo: ", e.getMessage(), TAG);
            return null;
        }
    }

    @Override // com.transsion.message.cast.notification.i.SmsNotificationInterface
    public void cancelSmsNotification(Context activity, String phoneNumber, long timestamp) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        int iHashCode = (phoneNumber + timestamp).hashCode();
        Log.d(TAG, "Cancelling SMS notification: phoneNumber=" + phoneNumber + ", timestamp=" + timestamp + ", notificationId=" + iHashCode);
        NotificationManagerCompat.from(activity).cancel(iHashCode);
        StringBuilder sb2 = new StringBuilder("SMS notification cancelled: phoneNumber=");
        sb2.append(phoneNumber);
        sb2.append(", timestamp=");
        sb2.append(timestamp);
        Log.d(TAG, sb2.toString());
    }

    @Override // com.transsion.message.cast.notification.i.SmsNotificationInterface
    public void createNotificationChannel(Context activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Log.d(TAG, "Creating notification channels");
        NotificationChannel notificationChannel = new NotificationChannel(SMS_CHANNEL_ID, "SMS Notification", 4);
        notificationChannel.setDescription("Used to display SMS notifications");
        notificationChannel.enableVibration(true);
        notificationChannel.enableLights(true);
        Object systemService = activity.getSystemService((Class<Object>) NotificationManager.class);
        Intrinsics.checkNotNullExpressionValue(systemService, "getSystemService(...)");
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
        Log.d(TAG, "SMS notification channel created successfully");
    }

    @Override // com.transsion.message.cast.notification.i.SmsNotificationInterface
    public void showSmsNotification(Context activity, String smsId, String phoneNumber, String contactName, String content, long timestamp, String deviceName) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(smsId, "smsId");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        StringBuilder sb2 = new StringBuilder("Showing SMS notification: phoneNumber=");
        d.A(sb2, phoneNumber, ", contactName=", contactName, ", content=");
        sb2.append(content);
        Log.d(TAG, sb2.toString());
        if (ContextCompat.checkSelfPermission(activity, "android.permission.POST_NOTIFICATIONS") != 0) {
            Log.w(TAG, "Notification permission not granted; skipping showSmsNotification");
            return;
        }
        try {
            Intent intent = new Intent("com.transsion.message.cast.SMS_MESSAGE_NEW");
            intent.putExtra("phoneNumber", phoneNumber);
            intent.putExtra("content", content);
            intent.putExtra("timestamp", timestamp);
            intent.putExtra("smsId", smsId);
            activity.sendBroadcast(intent);
        } catch (Exception unused) {
        }
        try {
            SmsReplyDispatcher.dispatchNewSms(phoneNumber, smsId, content, timestamp);
        } catch (Exception unused2) {
        }
        Intent intent2 = new Intent();
        intent2.setClassName(activity, "com.transsion.message.cast.ChatActivity");
        intent2.setFlags(603979776);
        intent2.putExtra("phoneNumber", phoneNumber);
        intent2.putExtra("contactName", contactName);
        intent2.putExtra("deviceName", deviceName);
        intent2.putExtra("timestamp", timestamp);
        intent2.putExtra("smsId", smsId);
        intent2.putExtra("content", content);
        intent2.putExtra("address", deviceName);
        intent2.putExtra("openFromNotification", true);
        int iHashCode = (phoneNumber + timestamp).hashCode();
        PendingIntent activity2 = PendingIntent.getActivity(activity, iHashCode, intent2, 201326592);
        Intent intent3 = new Intent(activity, (Class<?>) NotificationActionReceiver.class);
        intent3.setAction(NotificationActionReceiver.ACTION_REPLY_AND_OPEN_CHAT);
        intent3.putExtra(NotificationActionReceiver.EXTRA_NOTIFICATION_ID, iHashCode);
        intent3.putExtra(NotificationActionReceiver.EXTRA_PHONE_NUMBER, phoneNumber);
        intent3.putExtra(NotificationActionReceiver.EXTRA_SMS_ID, smsId);
        intent3.putExtra("contactName", contactName);
        intent3.putExtra("deviceName", deviceName);
        intent3.putExtra("timestamp", timestamp);
        intent3.putExtra("smsId", smsId);
        intent3.putExtra("content", content);
        intent3.putExtra("address", deviceName);
        intent3.putExtra("openFromNotification", true);
        NotificationCompat.Action actionBuild = new NotificationCompat.Action.Builder(R.drawable.ic_notification, activity.getString(R.string.sms_reply), PendingIntent.getBroadcast(activity, iHashCode, intent3, 201326592)).build();
        Intent intent4 = new Intent(activity, (Class<?>) NotificationActionReceiver.class);
        intent4.setAction(NotificationActionReceiver.ACTION_MARK_READ);
        intent4.putExtra(NotificationActionReceiver.EXTRA_NOTIFICATION_ID, iHashCode);
        intent4.putExtra(NotificationActionReceiver.EXTRA_PHONE_NUMBER, phoneNumber);
        intent4.putExtra(NotificationActionReceiver.EXTRA_SMS_ID, smsId);
        PendingIntent.getBroadcast(activity, iHashCode + 1, intent4, 201326592);
        NotificationCompat.Builder when = new NotificationCompat.Builder(activity, SMS_CHANNEL_ID).setSmallIcon(R.drawable.ic_notification).setContentTitle(contactName).setContentText(content).setContentIntent(activity2).addAction(actionBuild).setPriority(1).setDefaults(3).setCategory(NotificationCompat.CATEGORY_MESSAGE).setAutoCancel(true).setWhen(timestamp);
        Bitmap bitmapLoadContactPhoto = loadContactPhoto(activity, phoneNumber);
        if (bitmapLoadContactPhoto != null) {
            when.setLargeIcon(bitmapLoadContactPhoto);
        }
        Notification notificationBuild = when.build();
        Integer num = lastSmsNotificationId;
        if (num != null) {
            NotificationManagerCompat.from(activity).cancel(num.intValue());
        }
        NotificationManagerCompat.from(activity).notify(iHashCode, notificationBuild);
        lastSmsNotificationId = Integer.valueOf(iHashCode);
        d.x(iHashCode, "SMS notification shown successfully with ID: ", TAG);
    }
}
