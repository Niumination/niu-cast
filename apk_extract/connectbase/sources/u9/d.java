package u9;

import android.graphics.Bitmap;
import android.graphics.RenderNode;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16223a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static vc.d f16224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d7.c f16225c;

    public static Bitmap a(RenderNode renderNode, int i10, int i11) {
        if (renderNode != null) {
            return b(fc.b.a.f5992l).a(renderNode, i10, i11);
        }
        throw new IllegalArgumentException("RenderNode is null.");
    }

    public static of.c b(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16223a, "TranThubHardwareRendererManager");
            vc.d dVar = f16224b;
            if (dVar != null) {
                return dVar;
            }
            vc.d dVar2 = new vc.d();
            f16224b = dVar2;
            return dVar2;
        }
        dc.e.f(f16223a, "TranAospHardwareRendererManager");
        d7.c cVar = f16225c;
        if (cVar != null) {
            return cVar;
        }
        d7.c cVar2 = new d7.c();
        f16225c = cVar2;
        return cVar2;
    }
}
