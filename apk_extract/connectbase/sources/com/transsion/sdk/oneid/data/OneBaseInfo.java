package com.transsion.sdk.oneid.data;

import androidx.annotation.NonNull;
import ki.d;
import v1.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OneBaseInfo {
    @NonNull
    public String toString() {
        try {
            return new e().toJson(this);
        } catch (Exception e10) {
            d.m(e10);
            return "";
        }
    }
}
