package p3;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import j.c;
import java.io.File;
import k6.g;
import k6.i;
import k6.l;
import y3.b;
import y3.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f12766e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f12767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    public boolean f12768b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f12769c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f12770d;

    public static a d() {
        if (f12766e == null) {
            synchronized (a.class) {
                try {
                    if (f12766e == null) {
                        f12766e = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f12766e;
    }

    public void a(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(g.h0().getFilesDir());
        String str2 = File.separator;
        this.f12769c = c.a(sb2, str2, str);
        if (!c()) {
            this.f12769c = g.f9114q.getFilesDir().getPath();
        }
        this.f12770d = this.f12769c + str2 + "remote_config.cfg";
    }

    public void b(byte[] bArr) {
        this.f12767a = bArr;
    }

    public final boolean c() {
        if (!this.f12768b) {
            File file = new File(this.f12769c);
            try {
                if (file.exists()) {
                    this.f12768b = true;
                } else {
                    this.f12768b = file.mkdirs();
                }
            } catch (Exception e10) {
                b.d(Log.getStackTraceString(e10));
            }
        }
        return this.f12768b;
    }

    public void e(String str) throws Throwable {
        if (!TextUtils.isEmpty(this.f12769c) && c()) {
            File file = new File(this.f12770d);
            try {
                q3.b.d(file, str, this.f12767a);
            } catch (Exception e10) {
                l.f9150b.c(new i("bufferSave", e10));
                try {
                    if (file.isDirectory()) {
                        e.h(g.h0(), this.f12770d);
                    }
                } catch (Exception unused) {
                    e10.printStackTrace();
                }
            }
        }
    }

    @Nullable
    public String f() throws Throwable {
        if (!TextUtils.isEmpty(this.f12769c) && c()) {
            File file = new File(this.f12770d);
            try {
                return q3.b.a(file, this.f12767a);
            } catch (Exception e10) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("e", e10.getClass().getSimpleName());
                    bundle.putString("pwd", s3.e.o(this.f12767a));
                    bundle.putLong("len", file.length());
                    l.f9150b.c(new i("bufferRead", bundle));
                    e.m(g.h0(), file);
                } catch (Exception unused) {
                    e10.printStackTrace();
                }
            }
        }
        return null;
    }
}
