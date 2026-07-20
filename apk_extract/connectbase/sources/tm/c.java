package tm;

import lm.f1;
import lm.v;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
@an.b
@f
public interface c {

    public static final class a {
        public static /* synthetic */ tm.a a(c cVar, v vVar, g gVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callsInPlace");
            }
            if ((i10 & 2) != 0) {
                gVar = g.UNKNOWN;
            }
            return cVar.c(vVar, gVar);
        }
    }

    @an.b
    @l
    h a();

    @an.b
    @l
    h b(@m Object obj);

    @an.b
    @l
    <R> tm.a c(@l v<? extends R> vVar, @l g gVar);

    @an.b
    @l
    i d();
}
