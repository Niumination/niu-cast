package o9;

import dc.e;
import pc.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f12107c = "a";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f12108d = "package name should not be null";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12109e = "userId is wrong";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f12110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w6.a f12111b;

    public p000if.a a(String str) {
        if (fc.b.b(str)) {
            e.f(f12107c, "TranThubOverlayManager");
            b bVar = this.f12110a;
            if (bVar != null) {
                return bVar;
            }
            b bVar2 = new b();
            this.f12110a = bVar2;
            return bVar2;
        }
        e.f(f12107c, "TranAospOverlayManager");
        w6.a aVar = this.f12111b;
        if (aVar != null) {
            return aVar;
        }
        w6.a aVar2 = new w6.a();
        this.f12111b = aVar2;
        return aVar2;
    }

    @yb.a(level = 1)
    public void b(String str, int i10) {
        if (str == null) {
            throw new IllegalArgumentException("package name should not be null");
        }
        if (i10 <= Integer.MIN_VALUE || i10 >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("userId is wrong");
        }
        a(fc.b.a.f5988h).a(str, i10);
    }
}
