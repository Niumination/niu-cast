package com.transsion.atomiccore.support.host;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface AtomicIntentType {
    public static final String ACTIVITY = "activity";
    public static final String BROADCAST = "broadcast";
    public static final String FOREGROUND_SERVICE = "foregroundService";
    public static final String PENDING_INTENT = "pendingIntent";
    public static final String SERVICE = "service";
}
