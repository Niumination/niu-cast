package com.transsion.sdk.oneid.data;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import b.a;
import java.io.Serializable;
import ki.d;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintInfo extends OneBaseInfo implements Serializable {
    public String gsf;
    public String hdid;

    @a({"HardwareIds", "MissingPermission"})
    public FingerprintInfo(Context context) {
        this.gsf = "";
        this.hdid = "";
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.google.android.gsf.gservices"), null, null, new String[]{"android_id"}, null);
            if (cursorQuery == null || !cursorQuery.moveToNext()) {
                this.gsf = "";
            } else {
                this.gsf = Long.toHexString(cursorQuery.getLong(1));
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused) {
        }
        this.hdid = d.a();
    }
}
