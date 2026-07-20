package q2;

import android.os.Environment;
import java.io.File;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f13797a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final String f13798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static String f13799c;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Environment.DIRECTORY_DOWNLOADS);
        String strA = j.c.a(sb2, File.separator, "AirTransfer");
        f13798b = strA;
        f13799c = strA;
    }

    @l
    public final String a() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + f13799c;
    }

    @l
    public final String b() {
        return f13799c;
    }

    public final void c(@l String str) {
        l0.p(str, "<set-?>");
        f13799c = str;
    }
}
