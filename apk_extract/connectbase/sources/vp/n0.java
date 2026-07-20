package vp;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 extends n1 implements yp.k, yp.m {
    @os.l
    public abstract n0 N0(boolean z10);

    @os.l
    public abstract n0 O0(@os.l fo.g gVar);

    @os.l
    public String toString() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        Iterator<fo.c> it = getAnnotations().iterator();
        while (it.hasNext()) {
            jq.b0.k0(sb2, "[", gp.c.u(gp.c.f6770j, it.next(), null, 2, null), "] ");
        }
        sb2.append(G0());
        if (!F0().isEmpty()) {
            nm.h0.j3(F0(), sb2, (y5.a.f20716e0 & 2) != 0 ? ", " : ", ", (y5.a.f20716e0 & 4) != 0 ? "" : "<", (y5.a.f20716e0 & 8) == 0 ? ">" : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : null);
        }
        if (H0()) {
            sb2.append("?");
        }
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
