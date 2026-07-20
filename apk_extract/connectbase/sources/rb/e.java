package rb;

import android.view.DisplayCutout;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f14379c = "e";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public re.d f14380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b9.c f14381b;

    public lh.c a(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f14379c, "TranThubDisplayCutout");
            re.d dVar = this.f14380a;
            if (dVar != null) {
                return dVar;
            }
            re.d dVar2 = new re.d();
            this.f14380a = dVar2;
            return dVar2;
        }
        dc.e.f(f14379c, "TranAospDisplayCutout");
        b9.c cVar = this.f14381b;
        if (cVar != null) {
            return cVar;
        }
        b9.c cVar2 = new b9.c();
        this.f14381b = cVar2;
        return cVar2;
    }

    public boolean b(DisplayCutout displayCutout) {
        if (displayCutout != null) {
            return a(fc.b.a.f6001u).a(displayCutout);
        }
        throw new IllegalArgumentException("cutout is null");
    }
}
