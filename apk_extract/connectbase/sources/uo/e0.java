package uo;

import java.util.Iterator;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public interface e0 extends d {

    public static final class a {
        @os.m
        public static uo.a a(@os.l e0 e0Var, @os.l dp.c cVar) {
            Object obj;
            Object next;
            dp.b bVarF;
            l0.p(e0Var, "this");
            l0.p(cVar, "fqName");
            Iterator<T> it = e0Var.getAnnotations().iterator();
            do {
                obj = null;
                if (it.hasNext()) {
                    next = it.next();
                    bVarF = ((uo.a) next).f();
                }
                return (uo.a) obj;
            } while (!l0.g(bVarF != null ? bVarF.b() : null, cVar));
            obj = next;
            return (uo.a) obj;
        }
    }
}
