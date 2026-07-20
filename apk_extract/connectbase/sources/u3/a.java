package u3;

import android.content.Context;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.transsion.athena.data.AppIdData;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import k6.i;
import k6.l;
import s3.f;
import s3.g;
import w3.r;
import y3.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @b.a({"StaticFieldLeak"})
    public static volatile a f16179d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f16180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f16181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f16182c;

    /* JADX INFO: renamed from: u3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0430a {
        void a(w3.c cVar);
    }

    public a(Context context) {
        try {
            this.f16180a = context;
            this.f16181b = b.e(context);
            this.f16182c = context.getFilesDir().getPath();
        } catch (Exception e10) {
            y3.b.a(e10);
        }
    }

    public static a e(Context context) {
        if (f16179d == null) {
            synchronized (a.class) {
                try {
                    if (f16179d == null) {
                        f16179d = new a(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f16179d;
    }

    public int a(int i10, d<String> dVar) {
        try {
            return this.f16181b.a(b.a.f16186a, i10, dVar);
        } catch (i e10) {
            int i11 = i.f9131a;
            l.f9150b.c(e10);
            return -1;
        }
    }

    public int b(ArrayList<t3.a> arrayList, d<LongSparseArray<Integer>> dVar) {
        try {
            return this.f16181b.r(b.a.f16186a, arrayList, dVar);
        } catch (i e10) {
            int i10 = i.f9131a;
            l.f9150b.c(e10);
            return 0;
        }
    }

    public int c(t3.a aVar) {
        int i10 = 1;
        if (aVar.h() != 1 && aVar.h() != 2) {
            i10 = 0;
        }
        try {
            return this.f16181b.b(b.a.f16186a, aVar, i10);
        } catch (i e10) {
            int i11 = i.f9131a;
            l.f9150b.c(e10);
            return 0;
        }
    }

    public synchronized t3.c d(long j10, long j11, String str, int i10, int i11) {
        try {
        } catch (i e10) {
            int i12 = i.f9131a;
            l.f9150b.c(e10);
            return null;
        }
        return this.f16181b.d(b.a.f16186a, j10, j11, str, i10, i11);
    }

    public synchronized void f() {
        this.f16181b.f();
        try {
            Context context = this.f16180a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f16182c);
            String str = File.separator;
            sb2.append(str);
            sb2.append(g.f14978k);
            e.h(context, sb2.toString());
            e.h(this.f16180a, this.f16182c + str + g.f14979l);
        } catch (Exception e10) {
            y3.b.d(Log.getStackTraceString(e10));
        }
    }

    public synchronized void g(long j10, InterfaceC0430a interfaceC0430a) {
        try {
            String str = this.f16182c + File.separator + g.f14978k;
            if (new File(str).exists()) {
                for (File file : e.c(str, j10)) {
                    if (!file.getName().contains("upload")) {
                        if (file.getName().startsWith("f_") || file.getName().startsWith("r_")) {
                            File file2 = new File(file.getPath() + "upload" + System.currentTimeMillis());
                            file = !file.renameTo(file2) ? null : file2;
                        }
                    }
                    if (file != null) {
                        interfaceC0430a.a(new r(j10, file, n3.b.l().e(j10)));
                    }
                }
            }
            String str2 = this.f16182c + File.separator + g.f14979l;
            if (new File(str2).exists()) {
                try {
                    e.h(this.f16180a, str2);
                } catch (Exception e10) {
                    y3.b.d(Log.getStackTraceString(e10));
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void h(AppIdData appIdData) {
        try {
            this.f16181b.h(b.a.f16189d, appIdData);
        } catch (i e10) {
            int i10 = i.f9131a;
            l.f9150b.c(e10);
        }
    }

    public synchronized void i(String str, long j10) {
        try {
            this.f16181b.i(b.a.f16186a, str, j10);
        } catch (i e10) {
            int i10 = i.f9131a;
            l.f9150b.c(e10);
        }
    }

    public synchronized void j(List<AppIdData> list) {
        try {
            this.f16181b.j(b.a.f16189d, list);
        } catch (i e10) {
            int i10 = i.f9131a;
            l.f9150b.c(e10);
        }
    }

    public synchronized void k(List<AppIdData> list, int i10) {
        try {
            this.f16181b.k(b.a.f16189d, list, i10);
        } catch (i e10) {
            int i11 = i.f9131a;
            l.f9150b.c(e10);
        }
    }

    public synchronized void l(List<AppIdData> list, long j10, String str, d<SparseArray<t3.e>> dVar) {
        try {
            this.f16181b.l(b.a.f16186a, list, j10, str, dVar);
        } catch (i e10) {
            int i10 = i.f9131a;
            l.f9150b.c(e10);
        }
    }

    public synchronized void m(List<AppIdData> list, String str) {
        try {
            this.f16181b.m(b.a.f16186a, list, str);
        } catch (i e10) {
            int i10 = i.f9131a;
            l.f9150b.c(e10);
        }
    }

    public synchronized void n(List<Long> list, boolean z10, d<String> dVar) {
        if (z10) {
            try {
                String str = this.f16182c + File.separator + g.f14978k;
                if (new File(str).exists()) {
                    for (File file : e.b(str)) {
                        String name = file.getName();
                        if (!name.startsWith("f_") && !name.startsWith("r_")) {
                            y3.b.b("cleanupEvents deleteFile " + name + " " + e.m(this.f16180a, file));
                        } else if (list.contains(Long.valueOf(Long.parseLong(name.substring(2, name.indexOf(45)))))) {
                            y3.b.b("cleanupEvents deleteFile " + name + " " + e.m(this.f16180a, file));
                        }
                    }
                }
                String str2 = this.f16182c + File.separator + g.f14979l;
                if (new File(str2).exists()) {
                    try {
                        e.h(this.f16180a, str2);
                    } catch (Exception e10) {
                        y3.b.d(Log.getStackTraceString(e10));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        try {
            this.f16181b.n(b.a.f16186a, list, dVar);
        } catch (i e11) {
            int i10 = i.f9131a;
            l.f9150b.c(e11);
        }
    }

    public synchronized void o(f fVar, boolean z10) {
        try {
            this.f16181b.o(b.a.f16189d, fVar, z10);
        } catch (i e10) {
            int i10 = i.f9131a;
            l.f9150b.c(e10);
        }
    }

    public void p(d<SparseArray<f>> dVar) {
        try {
            this.f16181b.p(dVar);
        } catch (i e10) {
            int i10 = i.f9131a;
            l.f9150b.c(e10);
        }
    }

    public synchronized boolean q(int i10) {
        try {
        } catch (i e10) {
            int i11 = i.f9131a;
            l.f9150b.c(e10);
            return false;
        }
        return this.f16181b.q(b.a.f16186a, i10);
    }

    public List<AppIdData> r() {
        try {
            return this.f16181b.c(b.a.f16189d);
        } catch (i e10) {
            int i10 = i.f9131a;
            l.f9150b.c(e10);
            return null;
        }
    }
}
