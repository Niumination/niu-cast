package vq;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final void a(@os.l um.g gVar, @os.l Throwable th2) {
        Iterator<nq.o0> it = i.b().iterator();
        while (it.hasNext()) {
            try {
                it.next().g0(gVar, th2);
            } catch (o unused) {
                return;
            } catch (Throwable th3) {
                i.c(nq.p0.c(th2, th3));
            }
        }
        try {
            lm.p.a(th2, new l(gVar));
        } catch (Throwable unused2) {
        }
        i.c(th2);
    }
}
