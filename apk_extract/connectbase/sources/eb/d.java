package eb;

import android.os.Bundle;
import com.android.internal.annotations.VisibleForTesting;
import ee.s;
import qb.e;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4237b = "d";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4238c = "service is Null";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f4239d = "adapter is Null";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f4240e = "Callback must not null!!!";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yg.a f4241a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e.a<yg.a> f4242a = new C0099a();

        /* JADX INFO: renamed from: eb.d$a$a, reason: collision with other inner class name */
        public class C0099a extends e.a<yg.a> {
            @Override // qb.e.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public yg.a b() {
                if (fc.b.b(fc.b.a.f5981a)) {
                    dc.e.f(d.f4237b, "TranThubResMonitorManager");
                    return new s();
                }
                dc.e.f(d.f4237b, "TranAospResMonitorManager");
                return new o8.a();
            }
        }

        @VisibleForTesting
        public static void a() {
            f4242a.f13899a = null;
        }

        @VisibleForTesting
        public static yg.a b() {
            return f4242a.c();
        }
    }

    public d() {
        if (fc.b.b(fc.b.a.f5981a)) {
            this.f4241a = new s();
            dc.e.f(f4237b, "TranThubResMonitorManager");
        } else {
            this.f4241a = new o8.a();
            dc.e.f(f4237b, "TranAospResMonitorManager");
        }
    }

    public static void d(int i10, String str, b bVar) {
        yg.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException(f4239d);
        }
        if (bVar == null) {
            throw new NullPointerException(f4240e);
        }
        aVarB.l(i10, str, bVar);
    }

    public static void g(Bundle bundle, b bVar) {
        yg.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException(f4239d);
        }
        if (bVar == null) {
            throw new NullPointerException(f4240e);
        }
        aVarB.p(bundle, bVar);
    }

    @Deprecated
    public static Bundle[] h(Bundle bundle, Bundle[] bundleArr) {
        yg.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.j(bundle, bundleArr);
        }
        throw new NullPointerException(f4239d);
    }

    public static String i(int i10, String str) {
        yg.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.a(i10, str);
        }
        throw new NullPointerException(f4239d);
    }

    public static void l(int i10, eb.a aVar, int i11, int i12, int i13, int i14) {
        yg.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException(f4239d);
        }
        if (aVar == null) {
            throw new NullPointerException(f4240e);
        }
        aVarB.m(i10, aVar, i11, i12, i13, i14);
    }

    @Deprecated
    public static void o(Bundle bundle, Bundle[] bundleArr) {
        yg.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException(f4239d);
        }
        aVarB.c(bundle, bundleArr);
    }

    public static void p(int i10, String str) {
        yg.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException(f4239d);
        }
        aVarB.n(i10, str);
    }

    public static void s(eb.a aVar) {
        yg.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException(f4239d);
        }
        if (aVar == null) {
            throw new NullPointerException(f4240e);
        }
        aVarB.k(aVar);
    }

    public String b(int i10, String str) {
        yg.a aVar = this.f4241a;
        if (aVar != null) {
            return aVar.g(i10, str);
        }
        throw new NullPointerException("service is Null");
    }

    public void c(int i10, String str, b bVar) {
        yg.a aVar = this.f4241a;
        if (aVar == null) {
            throw new NullPointerException("service is Null");
        }
        if (bVar == null) {
            throw new NullPointerException(f4240e);
        }
        aVar.d(i10, str, bVar);
    }

    @Deprecated
    public Bundle[] e(Bundle bundle, Bundle[] bundleArr) {
        yg.a aVar = this.f4241a;
        if (aVar != null) {
            return aVar.b(bundle, bundleArr);
        }
        throw new NullPointerException("service is Null");
    }

    public void f(Bundle bundle, b bVar) {
        yg.a aVar = this.f4241a;
        if (aVar == null) {
            throw new NullPointerException("service is Null");
        }
        if (bVar == null) {
            throw new NullPointerException(f4240e);
        }
        aVar.e(bundle, bVar);
    }

    @VisibleForTesting
    public yg.a j() {
        return this.f4241a;
    }

    public void k(int i10, eb.a aVar, int i11, int i12, int i13, int i14) {
        yg.a aVar2 = this.f4241a;
        if (aVar2 == null) {
            throw new NullPointerException("service is Null");
        }
        if (aVar == null) {
            throw new NullPointerException(f4240e);
        }
        aVar2.f(i10, aVar, i11, i12, i13, i14);
    }

    public void m(int i10, String str) {
        yg.a aVar = this.f4241a;
        if (aVar == null) {
            throw new NullPointerException("service is Null");
        }
        aVar.h(i10, str);
    }

    @Deprecated
    public void n(Bundle bundle, Bundle[] bundleArr) {
        yg.a aVar = this.f4241a;
        if (aVar == null) {
            throw new NullPointerException("service is Null");
        }
        aVar.i(bundle, bundleArr);
    }

    @VisibleForTesting
    public void q(yg.a aVar) {
        this.f4241a = aVar;
    }

    public void r(eb.a aVar) {
        yg.a aVar2 = this.f4241a;
        if (aVar2 == null) {
            throw new NullPointerException("service is Null");
        }
        if (aVar == null) {
            throw new NullPointerException(f4240e);
        }
        aVar2.o(aVar);
    }
}
