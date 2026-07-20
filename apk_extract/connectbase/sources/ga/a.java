package ga;

import android.view.SurfaceControl;
import android.view.View;
import dc.e;
import fc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6449c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hd.a f6450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p7.a f6451b;

    public boolean a(View view, int i10) {
        if (view != null) {
            return f(b.a.B).c(view, i10);
        }
        throw new IllegalArgumentException("view is null");
    }

    public boolean b(int i10, SurfaceControl surfaceControl, long j10, String str) {
        if (surfaceControl != null) {
            return f(b.a.B).a(i10, surfaceControl, j10, str);
        }
        throw new IllegalArgumentException("surfaceControl is null");
    }

    public boolean c(int i10, View view, long j10, String str) {
        if (view != null) {
            return f(b.a.B).d(i10, view, j10, str);
        }
        throw new IllegalArgumentException("view is null");
    }

    public boolean d(int i10, int i11) {
        return f(b.a.B).b(i10, i11);
    }

    public boolean e(int i10) {
        return f(b.a.B).e(i10);
    }

    public ag.a f(String str) {
        if (b.b(str)) {
            hd.a aVar = this.f6450a;
            if (aVar != null) {
                return aVar;
            }
            hd.a aVar2 = new hd.a();
            this.f6450a = aVar2;
            return aVar2;
        }
        e.f(f6449c, "TranThubInteractionJankMonitor");
        p7.a aVar3 = this.f6451b;
        if (aVar3 != null) {
            return aVar3;
        }
        p7.a aVar4 = new p7.a();
        this.f6451b = aVar4;
        return aVar4;
    }
}
