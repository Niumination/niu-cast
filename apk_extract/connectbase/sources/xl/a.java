package xl;

import kn.l0;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    @z0
    @l
    public static final Void a() {
        throw new IllegalStateException("Limit change is now allowed");
    }

    @z0
    @l
    public static final Void b(int i10) {
        throw new IllegalStateException(l0.C("Wrong buffer position change: negative shift ", Integer.valueOf(i10)));
    }

    @z0
    @l
    public static final Void c(int i10, int i11) {
        throw new IllegalStateException("Wrong buffer position change: " + i10 + ". Position should be moved forward only by at most size bytes (size = " + i11 + ')');
    }
}
