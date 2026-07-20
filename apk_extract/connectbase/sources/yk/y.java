package yk;

import java.security.KeyStore;
import java.util.List;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    public static final void a(@os.l c cVar, @os.l jn.l<? super w, l2> lVar) {
        l0.p(cVar, "<this>");
        l0.p(lVar, "builder");
        List<x> list = cVar.f21375f;
        w wVar = new w(null, 1, null);
        lVar.invoke(wVar);
        list.add(wVar);
    }

    public static final void b(@os.l c cVar, @os.l KeyStore keyStore, @os.l String str, @os.l jn.a<char[]> aVar, @os.l jn.a<char[]> aVar2, @os.l jn.l<? super b0, l2> lVar) {
        l0.p(cVar, "<this>");
        l0.p(keyStore, "keyStore");
        l0.p(str, "keyAlias");
        l0.p(aVar, "keyStorePassword");
        l0.p(aVar2, "privateKeyPassword");
        l0.p(lVar, "builder");
        List<x> list = cVar.f21375f;
        b0 b0Var = new b0(keyStore, str, aVar, aVar2);
        lVar.invoke(b0Var);
        list.add(b0Var);
    }
}
