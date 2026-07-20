package b5;

import com.transsion.connectx.mirror.source.SourceApplication;
import w4.l1;

/* JADX INFO: loaded from: classes2.dex */
public class t implements ji.a<Object> {
    @Override // ji.a
    public Short a() {
        return Short.valueOf(v4.g.f16542i0);
    }

    @Override // ji.a
    public void b(Object obj) {
        n2.d dVar = (n2.d) ji.a.f8709a.a(String.valueOf(obj), n2.d.class);
        if (dVar == null || !l1.h.f18073a.f18050t) {
            return;
        }
        y5.c.d(SourceApplication.b()).h(dVar.a());
    }
}
