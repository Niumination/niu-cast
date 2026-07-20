package u9;

import android.graphics.Rect;
import android.view.Display;
import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16220c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vc.b f16221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d7.b f16222b;

    public b a(Display display, int i10, int i11) {
        if (display != null) {
            return c(fc.b.a.f5989i).b(display, i10, i11);
        }
        throw new IllegalArgumentException("display cannot be null");
    }

    public b b(SurfaceControl surfaceControl, Rect rect) {
        if (rect != null) {
            return c(fc.b.a.f5989i).a(surfaceControl, rect);
        }
        throw new IllegalArgumentException("Rect cannot be null");
    }

    public of.b c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16220c, "TranThubGraphicBuffer");
            vc.b bVar = this.f16221a;
            if (bVar != null) {
                return bVar;
            }
            vc.b bVar2 = new vc.b();
            this.f16221a = bVar2;
            return bVar2;
        }
        dc.e.f(f16220c, d7.b.f3618a);
        d7.b bVar3 = this.f16222b;
        if (bVar3 != null) {
            return bVar3;
        }
        d7.b bVar4 = new d7.b();
        this.f16222b = bVar4;
        return bVar4;
    }
}
