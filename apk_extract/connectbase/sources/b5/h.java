package b5;

import kn.l0;
import w4.l1;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements ji.a<Object> {
    @Override // ji.a
    @os.l
    public Short a() {
        return Short.valueOf(v4.g.Y);
    }

    @Override // ji.a
    public void b(@os.l Object obj) {
        l0.p(obj, "data");
        z4.d dVar = (z4.d) ji.a.f8709a.a(obj.toString(), z4.d.class);
        k4.m.e("ExtendMirrorController", "data : " + dVar);
        if (dVar == null) {
            k4.m.c("ExtendMirrorController", "onRequestData: data is null");
        } else {
            l1.h.f18073a.x0(dVar.e(), dVar.f());
        }
    }
}
