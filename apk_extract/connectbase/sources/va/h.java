package va;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16775c = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public vd.k f16776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e8.g f16777b;

    @yb.a(level = 2)
    public boolean a() {
        if (fc.a.h()) {
            return c(fc.b.a.G).b();
        }
        return false;
    }

    @yb.a(level = 2)
    public boolean b(String str) {
        if (fc.a.h()) {
            return c(fc.b.a.G).d(str);
        }
        return false;
    }

    public pg.g c(String str) {
        if (fc.b.b(str)) {
            dc.e.f(f16775c, "TranThubNvramManager");
            vd.k kVar = this.f16776a;
            if (kVar != null) {
                return kVar;
            }
            vd.k kVar2 = new vd.k();
            this.f16776a = kVar2;
            return kVar2;
        }
        dc.e.f(f16775c, "TranAospNvramManager");
        e8.g gVar = this.f16777b;
        if (gVar != null) {
            return gVar;
        }
        e8.g gVar2 = new e8.g();
        this.f16777b = gVar2;
        return gVar2;
    }

    @yb.a(level = 2)
    public String d(String str, int i10) {
        if (str != null) {
            return c(fc.b.a.f5982b).c(str, i10);
        }
        throw new IllegalArgumentException("fileName cannot be null");
    }

    @yb.a(level = 2)
    public byte e(String str, int i10, List list) {
        return c(fc.b.a.f5982b).a(str, i10, list);
    }
}
