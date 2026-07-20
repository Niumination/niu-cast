package com.transsion.sdk.oneid.data;

import ad.c;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.system.Os;
import android.util.Log;
import java.io.Serializable;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintInfo extends OneBaseInfo implements Serializable {
    public String gsf;
    public String hdid;

    public FingerprintInfo(Context context) {
        String string = "";
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
        try {
            string = UUID.nameUUIDFromBytes(String.valueOf(Os.statvfs(Environment.getExternalStorageDirectory().getPath()).f_fsid).getBytes()).toString();
        } catch (Exception e) {
            c.h(Log.getStackTraceString(e));
        }
        this.hdid = string;
    }
}
