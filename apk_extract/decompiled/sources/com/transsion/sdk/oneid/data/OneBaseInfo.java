package com.transsion.sdk.oneid.data;

import ad.c;
import androidx.annotation.NonNull;
import v4.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OneBaseInfo {
    @NonNull
    public String toString() {
        try {
            return new q().toJson(this);
        } catch (Exception e) {
            c.h(e);
            return "";
        }
    }
}
