package lk;

import java.util.Arrays;
import kn.l0;
import os.l;
import tl.d1;
import tl.v;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final boolean a(@l v vVar, @l byte[] bArr) {
        l0.p(vVar, "<this>");
        l0.p(bArr, "data");
        v vVarN2 = vVar.N2();
        vVarN2.t1(vVarN2.S0() - ((long) bArr.length));
        return Arrays.equals(d1.i(vVarN2, 0, 1, null), bArr);
    }
}
