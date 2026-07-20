package rk;

import fl.t0;
import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.spi.SelectorProvider;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class k {
    @t0
    @os.l
    public static final j a(@os.l um.g gVar) {
        l0.p(gVar, "dispatcher");
        return new a(gVar);
    }

    public static /* synthetic */ j b(um.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = um.i.INSTANCE;
        }
        return a(gVar);
    }

    public static final <C extends Closeable, R> R c(@os.l j jVar, @os.l jn.l<? super SelectorProvider, ? extends C> lVar, @os.l jn.l<? super C, ? extends R> lVar2) throws IOException {
        l0.p(jVar, "<this>");
        l0.p(lVar, "create");
        l0.p(lVar2, "setup");
        C cInvoke = lVar.invoke(jVar.z());
        try {
            return lVar2.invoke(cInvoke);
        } catch (Throwable th2) {
            cInvoke.close();
            throw th2;
        }
    }
}
