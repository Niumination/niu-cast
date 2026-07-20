package rn;

import an.m;
import java.util.Random;
import kn.l0;
import lm.f1;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    @f1(version = "1.3")
    @l
    public static final Random a(@l f fVar) {
        Random impl;
        l0.p(fVar, "<this>");
        a aVar = fVar instanceof a ? (a) fVar : null;
        return (aVar == null || (impl = aVar.getImpl()) == null) ? new c(fVar) : impl;
    }

    @f1(version = "1.3")
    @l
    public static final f b(@l Random random) {
        f impl;
        l0.p(random, "<this>");
        c cVar = random instanceof c ? (c) random : null;
        return (cVar == null || (impl = cVar.getImpl()) == null) ? new d(random) : impl;
    }

    @an.f
    public static final f c() {
        return m.f417a.b();
    }

    public static final double d(int i10, int i11) {
        return ((((long) i10) << 27) + ((long) i11)) / 9.007199254740992E15d;
    }
}
