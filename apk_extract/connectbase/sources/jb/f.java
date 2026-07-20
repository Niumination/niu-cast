package jb;

import android.net.Uri;
import android.telephony.SubscriptionInfo;
import gm.i;
import java.util.List;
import je.l;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8646c = "f";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @i
    public static final Uri f8647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @i
    public static final Uri f8648e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f8649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t8.e f8650b;

    static {
        Uri uri = Uri.parse("content://telephony/siminfo");
        f8647d = uri;
        f8648e = Uri.withAppendedPath(uri, "advanced_calling");
    }

    public int[] a() {
        return f(fc.b.a.f5984d).c();
    }

    @yb.a(level = 1)
    public int b() {
        return f(fc.b.a.f5989i).i();
    }

    @yb.a(level = 1)
    public List<SubscriptionInfo> c() {
        return f(fc.b.a.f5989i).h();
    }

    public SubscriptionInfo d() {
        return f(fc.b.a.f5989i).e();
    }

    public int e(int i10) {
        return f(fc.b.a.f5998r).k(i10);
    }

    public dh.e f(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f8646c, "TranThubSubscriptionManager");
            l lVar = this.f8649a;
            if (lVar != null) {
                return lVar;
            }
            l lVar2 = new l();
            this.f8649a = lVar2;
            return lVar2;
        }
        dc.e.f(f8646c, "TranAospSubscriptionManager");
        t8.e eVar = this.f8650b;
        if (eVar != null) {
            return eVar;
        }
        t8.e eVar2 = new t8.e();
        this.f8650b = eVar2;
        return eVar2;
    }

    public int g(int i10) {
        return f(fc.b.a.f5985e).a(i10);
    }

    public int[] h(int i10) {
        return f(fc.b.a.f5985e).f(i10);
    }

    public boolean i(int i10) {
        return f(fc.b.a.f5998r).g(i10);
    }

    public void j(int i10) {
        f(fc.b.a.f5985e).b(i10);
    }

    public void k(int i10, int i11) {
        f(fc.b.a.G).j(i10, i11);
    }

    public void l(int i10) {
        f(fc.b.a.f5992l).d(i10);
    }
}
