package iq;

import in.i;
import kn.l0;
import lm.l2;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@i(name = "TimingKt")
public final class b {
    public static final long a(@l jn.a<l2> aVar) {
        l0.p(aVar, "block");
        long jNanoTime = System.nanoTime();
        aVar.invoke();
        return System.nanoTime() - jNanoTime;
    }

    public static final long b(@l jn.a<l2> aVar) {
        l0.p(aVar, "block");
        long jCurrentTimeMillis = System.currentTimeMillis();
        aVar.invoke();
        return System.currentTimeMillis() - jCurrentTimeMillis;
    }
}
