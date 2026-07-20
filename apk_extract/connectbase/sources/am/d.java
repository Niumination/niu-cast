package am;

import bm.h;
import java.nio.channels.ReadableByteChannel;
import kn.l0;
import os.l;
import tl.g0;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    @l
    public static final g0 a(@l ReadableByteChannel readableByteChannel, @l h<ul.b> hVar) {
        l0.p(readableByteChannel, "<this>");
        l0.p(hVar, "pool");
        return new a(readableByteChannel, hVar);
    }

    public static g0 b(ReadableByteChannel readableByteChannel, h hVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ul.b.f16311i.getClass();
            hVar = ul.b.f16315w;
        }
        return a(readableByteChannel, hVar);
    }
}
