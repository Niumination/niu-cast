package cm;

import bm.h;
import java.io.InputStream;
import kn.l0;
import os.l;
import tl.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    @l
    public static final g0 a(@l InputStream inputStream, @l h<ul.b> hVar) {
        l0.p(inputStream, "<this>");
        l0.p(hVar, "pool");
        return new c(inputStream, hVar);
    }

    public static g0 b(InputStream inputStream, h hVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ul.b.f16311i.getClass();
            hVar = ul.b.f16315w;
        }
        return a(inputStream, hVar);
    }
}
