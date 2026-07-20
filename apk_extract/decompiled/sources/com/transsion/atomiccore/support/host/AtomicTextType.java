package com.transsion.atomiccore.support.host;

import androidx.annotation.Keep;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface AtomicTextType {
    public static final int COUNT_DOWN = 0;
    public static final int COUNT_UP = 1;
    public static final int NULL_TYPE = -1;
}
