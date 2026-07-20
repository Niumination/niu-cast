package h9;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.service.notification.Condition;
import ic.m1;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7062c = "p";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m1 f7063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p6.r f7064b;

    public static Condition C(Context context, int i10, int i11) {
        return c8.c.a(context, i10, i11);
    }

    public void A(int i10, Uri uri, String str) {
        l(fc.b.a.f5984d).y(i10, uri, str);
    }

    public int B(String str, int i10) {
        if (fc.a.h()) {
            return l(fc.b.a.G).B(str, i10);
        }
        return -1;
    }

    public void D() {
        if (fc.a.h()) {
            l(fc.b.a.E).l();
        }
    }

    public void E(String str, int i10, NotificationChannel notificationChannel) {
        l(fc.b.a.f5987g).b(str, i10, notificationChannel);
    }

    @yb.a(level = 1)
    public boolean a(String str, int i10) {
        return l(fc.b.a.f5989i).h(str, i10);
    }

    public boolean b(String str, int i10) {
        return l(fc.b.a.f5999s).s(str, i10);
    }

    public boolean c(String str, int i10) {
        return l(fc.b.a.f5999s).n(str, i10);
    }

    @yb.a(level = 1)
    public boolean d(String str, int i10) {
        return l(fc.b.a.f5989i).g(str, i10);
    }

    public void e(String str, int i10, List list) {
        if (str == null || list == null) {
            throw new IllegalArgumentException("params cannot be null");
        }
        l(fc.b.a.C).o(str, i10, list);
    }

    @yb.a(level = 1)
    public NotificationChannel f(String str, int i10, String str2, String str3, boolean z10) {
        return l(fc.b.a.f5989i).C(str, i10, str2, str3, z10);
    }

    @yb.a(level = 1)
    public p9.h<NotificationChannelGroup> g(String str, int i10, boolean z10) {
        return l(fc.b.a.f5989i).k(str, i10, z10);
    }

    @yb.a(level = 1)
    public p9.h h(String str, String str2, int i10) {
        return l(fc.b.a.f5989i).f(str, str2, i10);
    }

    public p9.h<NotificationChannel> i(String str, int i10, boolean z10) {
        if (str != null) {
            return l(fc.b.a.f6001u).v(str, i10, z10);
        }
        throw new IllegalArgumentException("package cannot be null");
    }

    public int j(String str, int i10) {
        if (fc.a.f()) {
            return l(fc.b.a.f6001u).i(str, i10);
        }
        return 0;
    }

    @yb.a(level = 1)
    public int k(String str, int i10, boolean z10) {
        return l(fc.b.a.f5989i).a(str, i10, z10);
    }

    public bf.n l(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f7062c, "TranThubNotificationManager");
            m1 m1Var = this.f7063a;
            if (m1Var != null) {
                return m1Var;
            }
            m1 m1Var2 = new m1();
            this.f7063a = m1Var2;
            return m1Var2;
        }
        dc.e.f(f7062c, "TranAospNotificationManager");
        p6.r rVar = this.f7064b;
        if (rVar != null) {
            return rVar;
        }
        p6.r rVar2 = new p6.r();
        this.f7064b = rVar2;
        return rVar2;
    }

    public int m(String str, int i10) {
        if (fc.a.h()) {
            return l(fc.b.a.E).q(str, i10);
        }
        return -1;
    }

    public int n() {
        return l(fc.b.a.f5984d).d();
    }

    @yb.a(level = 1)
    public boolean o(String str, int i10) {
        return l(fc.b.a.f5989i).j(str, i10);
    }

    public void p(String str, int i10) {
        if (fc.a.h()) {
            l(fc.b.a.E).r(str, i10);
        }
    }

    public void q(String str, int i10) {
        if (fc.a.h()) {
            l(fc.b.a.E).u(str, i10);
        }
    }

    public boolean r(String str, int i10) {
        return l(fc.b.a.f5989i).t(str, i10);
    }

    public void s(b bVar) {
        if (fc.a.h()) {
            l(fc.b.a.E).m(bVar);
        }
    }

    public void t(String str, int i10, int i11) {
        if (fc.a.f()) {
            l(fc.b.a.f6001u).e(str, i10, i11);
        }
    }

    public void u(ComponentName componentName, boolean z10) {
        l(fc.b.a.f5987g).z(componentName, z10);
    }

    @yb.a(level = 2)
    public void v(String str, int i10, boolean z10) {
        l(fc.b.a.f5989i).c(str, i10, z10);
    }

    public void w(String str, int i10, boolean z10) {
        l(fc.b.a.f5999s).A(str, i10, z10);
    }

    public void x(String str, int i10, boolean z10) {
        l(fc.b.a.f5999s).w(str, i10, z10);
    }

    @yb.a(level = 2)
    public void y(String str, int i10, boolean z10) {
        l(fc.b.a.f5989i).p(str, i10, z10);
    }

    public void z(String str, int i10, int i11) {
        if (fc.a.h()) {
            l(fc.b.a.E).x(str, i10, i11);
        }
    }
}
