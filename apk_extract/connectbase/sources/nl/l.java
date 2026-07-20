package nl;

import kn.l0;
import pl.x;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    @os.l
    public static final Throwable a(@os.l Throwable th2, @os.m Throwable th3) {
        Throwable thG;
        l0.p(th2, "<this>");
        if (th3 == null || l0.g(th2.getCause(), th3) || (thG = x.g(th2, th3)) == null) {
            return th2;
        }
        thG.setStackTrace(th2.getStackTrace());
        return thG;
    }
}
