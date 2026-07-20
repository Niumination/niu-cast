package x9;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yc.a f20124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g7.a f20125b;

    public int a(Context context) {
        return d(fc.b.a.f5988h).b(context);
    }

    public int b(Context context) {
        return d(fc.b.a.f5988h).f(context);
    }

    public int c() {
        return d(fc.b.a.f5988h).g();
    }

    public rf.a d(String str) {
        if (fc.b.b(str)) {
            yc.a aVar = this.f20124a;
            if (aVar != null) {
                return aVar;
            }
            yc.a aVar2 = new yc.a();
            this.f20124a = aVar2;
            return aVar2;
        }
        g7.a aVar3 = this.f20125b;
        if (aVar3 != null) {
            return aVar3;
        }
        g7.a aVar4 = new g7.a();
        this.f20125b = aVar4;
        return aVar4;
    }

    @yb.a(level = 0)
    public boolean e() {
        return d(fc.b.a.f5982b).e();
    }

    public boolean f(Context context) {
        return d(fc.b.a.f5988h).c(context);
    }

    public void g(String str, int i10, boolean z10, int i11, int i12, Bundle bundle) {
        d(fc.b.a.G).a(str, i10, z10, i11, i12, bundle);
    }

    @yb.a(level = 2)
    public boolean h(boolean z10) {
        return d(fc.b.a.f5982b).d(z10);
    }

    public boolean i(int i10) {
        return d(fc.b.a.f5988h).h(i10);
    }
}
