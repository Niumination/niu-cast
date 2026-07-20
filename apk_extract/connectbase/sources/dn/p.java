package dn;

import java.io.File;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public class p extends o {
    @os.l
    public static final k J(@os.l File file, @os.l l lVar) {
        l0.p(file, "<this>");
        l0.p(lVar, "direction");
        return new k(file, lVar);
    }

    public static /* synthetic */ k K(File file, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            lVar = l.TOP_DOWN;
        }
        return J(file, lVar);
    }

    @os.l
    public static final k L(@os.l File file) {
        l0.p(file, "<this>");
        return J(file, l.BOTTOM_UP);
    }

    @os.l
    public static final k M(@os.l File file) {
        l0.p(file, "<this>");
        return J(file, l.TOP_DOWN);
    }
}
