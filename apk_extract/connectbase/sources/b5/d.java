package b5;

import w4.l1;

/* JADX INFO: loaded from: classes2.dex */
public class d implements ji.a<Object> {
    @Override // ji.a
    public Short a() {
        return Short.valueOf(v4.g.f16548l0);
    }

    @Override // ji.a
    public void b(Object obj) {
        z4.i iVar = (z4.i) k4.j.a.f8962a.a(obj.toString(), z4.i.class);
        if (iVar == null) {
            k4.m.e("CustomOpenMainScreenController", "close from pc");
            l1.h.f18073a.H0("phone_mirror_pad");
            return;
        }
        k4.m.e("CustomOpenMainScreenController", iVar.toString());
        if ("phone_mirror_pad".equals(iVar.f())) {
            l1.h.f18073a.H0("phone_mirror_pad");
        } else if (z4.e.f21818e.equals(iVar.f())) {
            l1.h.f18073a.G0(iVar.e());
        }
    }
}
