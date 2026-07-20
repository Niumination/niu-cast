package am;

import bm.h;
import java.nio.channels.WritableByteChannel;
import kn.l0;
import os.l;
import tl.q0;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    @l
    public static final q0 a(@l WritableByteChannel writableByteChannel, @l h<ul.b> hVar) {
        l0.p(writableByteChannel, "<this>");
        l0.p(hVar, "pool");
        return new b(hVar, writableByteChannel);
    }

    public static q0 b(WritableByteChannel writableByteChannel, h hVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ul.b.f16311i.getClass();
            hVar = ul.b.f16315w;
        }
        return a(writableByteChannel, hVar);
    }
}
