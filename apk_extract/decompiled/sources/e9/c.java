package e9;

import android.os.Environment;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static String a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb2.append("/");
        return h0.a.n(sb2, Environment.DIRECTORY_DOCUMENTS, "/.sys_id.dat");
    }
}
