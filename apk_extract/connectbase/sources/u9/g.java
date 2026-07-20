package u9;

import android.graphics.drawable.VectorDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16238a = "g";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static vc.g f16239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d7.f f16240c;

    public static of.f a(String str) {
        if (fc.b.b(str)) {
            vc.g gVar = f16239b;
            if (gVar != null) {
                return gVar;
            }
            vc.g gVar2 = new vc.g();
            f16239b = gVar2;
            return gVar2;
        }
        dc.e.f(f16238a, "TranAospVectorDrawable");
        d7.f fVar = f16240c;
        if (fVar != null) {
            return fVar;
        }
        d7.f fVar2 = new d7.f();
        f16240c = fVar2;
        return fVar2;
    }

    public boolean b(VectorDrawable vectorDrawable, int i10, int i11, int i12, String str) {
        if (!fc.a.f()) {
            return false;
        }
        if (vectorDrawable != null) {
            return a(fc.b.a.A).a(vectorDrawable, i10, i11, i12, str);
        }
        throw new NullPointerException("VectorDrawable is null");
    }
}
