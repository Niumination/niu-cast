package j3;

import android.util.Log;
import j.c;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final b f8554a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f8555b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f8556c;

    public static /* synthetic */ void g(b bVar, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 3;
        }
        bVar.f(str, i10);
    }

    public final void a(@l String str, @l String str2) {
        l0.p(str, "tag");
        l0.p(str2, "log");
        if (f8555b <= 7) {
            StringBuilder sb2 = new StringBuilder();
            String str3 = f8556c;
            if (str3 == null) {
                l0.S("mLogTag");
                str3 = null;
            }
            sb2.append(str3);
            sb2.append(str);
            Log.v(sb2.toString(), str2);
        }
    }

    public final void b(@l String str, @l String str2) {
        l0.p(str, "tag");
        l0.p(str2, "log");
        if (f8555b <= 3) {
            StringBuilder sb2 = new StringBuilder();
            String str3 = f8556c;
            if (str3 == null) {
                l0.S("mLogTag");
                str3 = null;
            }
            sb2.append(str3);
            sb2.append(str);
            Log.d(sb2.toString(), str2);
        }
    }

    public final void c(@l String str, @l String str2) {
        l0.p(str, "tag");
        l0.p(str2, "log");
        if (f8555b <= 6) {
            StringBuilder sb2 = new StringBuilder();
            String str3 = f8556c;
            if (str3 == null) {
                l0.S("mLogTag");
                str3 = null;
            }
            sb2.append(str3);
            sb2.append(str);
            Log.e(sb2.toString(), str2);
        }
    }

    public final void d(@l String str, @l Throwable th2) {
        l0.p(str, "tag");
        l0.p(th2, "e");
        StackTraceElement[] stackTrace = th2.getStackTrace();
        l0.o(stackTrace, "getStackTrace(...)");
        for (StackTraceElement stackTraceElement : stackTrace) {
            StringBuilder sb2 = new StringBuilder();
            String str2 = f8556c;
            if (str2 == null) {
                l0.S("mLogTag");
                str2 = null;
            }
            Log.e(c.a(sb2, str2, str), stackTraceElement.toString());
        }
    }

    public final void e(@l String str, @l String str2) {
        l0.p(str, "tag");
        l0.p(str2, "log");
        if (f8555b <= 4) {
            StringBuilder sb2 = new StringBuilder();
            String str3 = f8556c;
            if (str3 == null) {
                l0.S("mLogTag");
                str3 = null;
            }
            sb2.append(str3);
            sb2.append(str);
            Log.i(sb2.toString(), str2);
        }
    }

    public final void f(@l String str, int i10) {
        l0.p(str, "logTag");
        f8556c = str;
    }

    public final void h(@l String str, @l String str2) {
        l0.p(str, "tag");
        l0.p(str2, "log");
        if (f8555b <= 2) {
            StringBuilder sb2 = new StringBuilder();
            String str3 = f8556c;
            if (str3 == null) {
                l0.S("mLogTag");
                str3 = null;
            }
            sb2.append(str3);
            sb2.append(str);
            Log.v(sb2.toString(), str2);
        }
    }

    public final void i(@l String str, @l String str2) {
        l0.p(str, "tag");
        l0.p(str2, "log");
        if (f8555b <= 5) {
            StringBuilder sb2 = new StringBuilder();
            String str3 = f8556c;
            if (str3 == null) {
                l0.S("mLogTag");
                str3 = null;
            }
            sb2.append(str3);
            sb2.append(str);
            Log.w(sb2.toString(), str2);
        }
    }
}
