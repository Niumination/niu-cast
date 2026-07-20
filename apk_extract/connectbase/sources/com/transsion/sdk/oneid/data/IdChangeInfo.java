package com.transsion.sdk.oneid.data;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class IdChangeInfo implements Serializable {
    public String id_type;
    public String new_id;
    public String pre_id;

    public IdChangeInfo(String str, String str2, String str3) {
        this.id_type = str;
        this.pre_id = str2;
        this.new_id = str3;
    }
}
