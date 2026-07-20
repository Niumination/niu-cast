package o6;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import e8.b;
import e8.d;
import e8.g;
import h4.o;
import i2.e;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import k3.dd;
import k3.nc;
import m3.g0;
import p5.q;
import qf.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static volatile a f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f8407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f8409d;
    public Object e;

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b.f4712i.getFilesDir());
        String str2 = File.separator;
        this.f8407b = h0.a.n(sb2, str2, str);
        if (!b()) {
            this.f8407b = b.f4712i.getFilesDir().getPath();
        }
        this.e = ((String) this.f8407b) + str2 + "remote_config.cfg";
    }

    public boolean b() {
        if (!this.f8408c) {
            File file = new File((String) this.f8407b);
            try {
                if (file.exists()) {
                    this.f8408c = true;
                } else {
                    this.f8408c = file.mkdirs();
                }
            } catch (Exception e) {
                z6.a.c(Log.getStackTraceString(e));
            }
        }
        return this.f8408c;
    }

    public void c(int i8, String str) {
        g(str, String.valueOf(i8));
    }

    public void d(Object obj, String str) {
        c cVar = new c();
        ((c) this.e).f9049d = cVar;
        this.e = cVar;
        cVar.f9048c = obj;
        cVar.f9047b = str;
    }

    public void e(String str, long j8) {
        g(str, String.valueOf(j8));
    }

    public void f(String str, boolean z2) {
        g(str, String.valueOf(z2));
    }

    public void g(String str, String str2) {
        o oVar = new o();
        ((c) this.e).f9049d = oVar;
        this.e = oVar;
        oVar.f9048c = str2;
        oVar.f9047b = str;
    }

    public void h(String str) {
        if (!TextUtils.isEmpty((String) this.f8407b) && b()) {
            File file = new File((String) this.e);
            try {
                nc.c(file, str, (byte[]) this.f8409d);
            } catch (Exception e) {
                g.f4735b.a(new d("bufferSave", e));
                try {
                    if (file.isDirectory()) {
                        g0.e(b.f4712i, (String) this.e);
                    }
                } catch (Exception unused) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String i() {
        if (!TextUtils.isEmpty((String) this.f8407b) && b()) {
            File file = new File((String) this.e);
            try {
                return nc.a(file, (byte[]) this.f8409d);
            } catch (Exception e) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString("e", e.getClass().getSimpleName());
                    bundle.putString("pwd", dd.k((byte[]) this.f8409d));
                    bundle.putLong("len", file.length());
                    g.f4735b.a(new d("bufferRead", bundle));
                    g0.j(b.f4712i, file);
                } catch (Exception unused) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void j(Runnable runnable, Executor executor) {
        synchronized (this.f8409d) {
            try {
                if (this.f8408c) {
                    ((ArrayDeque) this.f8407b).add(new q(runnable, executor));
                } else {
                    this.f8408c = true;
                    l(runnable, executor);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void k() {
        synchronized (this.f8409d) {
            try {
                if (((ArrayDeque) this.f8407b).isEmpty()) {
                    this.f8408c = false;
                    return;
                }
                q qVar = (q) ((ArrayDeque) this.f8407b).remove();
                l(qVar.f8699b, qVar.f8698a);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void l(Runnable runnable, Executor executor) {
        try {
            executor.execute(new e(8, this, runnable));
        } catch (RejectedExecutionException unused) {
            k();
        }
    }

    public String toString() {
        switch (this.f8406a) {
            case 1:
                boolean z2 = this.f8408c;
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append((String) this.f8407b);
                sb2.append('{');
                String str = "";
                for (c cVar = (c) ((c) this.f8409d).f9049d; cVar != null; cVar = (c) cVar.f9049d) {
                    Object obj = cVar.f9048c;
                    if ((cVar instanceof o) || obj != null || !z2) {
                        sb2.append(str);
                        String str2 = (String) cVar.f9047b;
                        if (str2 != null) {
                            sb2.append(str2);
                            sb2.append('=');
                        }
                        if (obj == null || !obj.getClass().isArray()) {
                            sb2.append(obj);
                        } else {
                            String strDeepToString = Arrays.deepToString(new Object[]{obj});
                            sb2.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
                        }
                        str = ", ";
                    }
                }
                sb2.append('}');
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public a() {
        this.f8406a = 3;
        this.f8409d = new Object();
        this.f8407b = new ArrayDeque();
        this.e = new AtomicReference();
    }

    public a(String str) {
        this.f8406a = 1;
        c cVar = new c();
        this.f8409d = cVar;
        this.e = cVar;
        this.f8408c = false;
        this.f8407b = str;
    }
}
