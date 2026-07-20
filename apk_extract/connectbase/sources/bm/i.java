package bm;

import kn.l0;
import lm.a1;
import lm.k;
import os.l;

/* JADX INFO: loaded from: classes2.dex */
public final class i {
    @k(message = "Use useInstance instead", replaceWith = @a1(expression = "useInstance(block)", imports = {}))
    public static final <T, R> R a(@l h<T> hVar, @l jn.l<? super T, ? extends R> lVar) {
        l0.p(hVar, "<this>");
        l0.p(lVar, "block");
        T tW0 = hVar.W0();
        try {
            return lVar.invoke(tW0);
        } finally {
            hVar.recycle(tW0);
        }
    }

    public static final <T, R> R b(@l h<T> hVar, @l jn.l<? super T, ? extends R> lVar) {
        l0.p(hVar, "<this>");
        l0.p(lVar, "block");
        T tW0 = hVar.W0();
        try {
            return lVar.invoke(tW0);
        } finally {
            hVar.recycle(tW0);
        }
    }
}
