package ki;

import android.os.Environment;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        sb2.append("/");
        return j.c.a(sb2, Environment.DIRECTORY_DOCUMENTS, "/.sys_id.dat");
    }
}
