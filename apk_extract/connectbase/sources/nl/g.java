package nl;

import java.util.List;
import jn.q;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    @lm.k(message = "This is going to become internal. Use Pipeline.execute() instead.")
    @os.l
    public static final <TSubject, TContext> h<TSubject> a(@os.l TContext tcontext, @os.l List<? extends q<? super f<TSubject, TContext>, ? super TSubject, ? super um.d<? super l2>, ? extends Object>> list, @os.l TSubject tsubject) {
        l0.p(tcontext, "context");
        l0.p(list, "interceptors");
        l0.p(tsubject, "subject");
        return new p(tsubject, tcontext, list);
    }

    @os.l
    public static final <TSubject, TContext> h<TSubject> b(@os.l TContext tcontext, @os.l List<? extends q<? super f<TSubject, TContext>, ? super TSubject, ? super um.d<? super l2>, ? extends Object>> list, @os.l TSubject tsubject, @os.l um.g gVar, boolean z10) {
        l0.p(tcontext, "context");
        l0.p(list, "interceptors");
        l0.p(tsubject, "subject");
        l0.p(gVar, "coroutineContext");
        return z10 ? new b(tcontext, list, tsubject, gVar) : new p(tsubject, tcontext, list);
    }

    public static /* synthetic */ h c(Object obj, List list, Object obj2, um.g gVar, boolean z10, int i10, Object obj3) {
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        return b(obj, list, obj2, gVar, z10);
    }
}
