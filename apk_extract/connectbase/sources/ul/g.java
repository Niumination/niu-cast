package ul;

import kn.l0;
import lm.z0;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    @z0
    @l
    public static final Void a(long j10, @l String str) {
        l0.p(str, "name");
        throw new IllegalArgumentException("Long value " + j10 + " of " + str + " doesn't fit into 32-bit integer");
    }

    @z0
    public static final int b(long j10, @l String str) {
        l0.p(str, "name");
        if (j10 < 2147483647L) {
            return (int) j10;
        }
        throw ql.d.a(j10, str);
    }
}
