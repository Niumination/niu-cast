package nm;

import java.util.Iterator;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public class b0 extends a0 {
    public static final <T> void g0(@os.l Iterator<? extends T> it, @os.l jn.l<? super T, l2> lVar) {
        kn.l0.p(it, "<this>");
        kn.l0.p(lVar, "operation");
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final <T> Iterator<T> h0(Iterator<? extends T> it) {
        kn.l0.p(it, "<this>");
        return it;
    }

    @os.l
    public static final <T> Iterator<s0<T>> i0(@os.l Iterator<? extends T> it) {
        kn.l0.p(it, "<this>");
        return new u0(it);
    }
}
