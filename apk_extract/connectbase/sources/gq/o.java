package gq;

import java.util.Collection;
import java.util.Iterator;
import lm.f1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
@um.j
public abstract class o<T> {
    @os.m
    public abstract Object a(T t10, @os.l um.d<? super l2> dVar);

    @os.m
    public final Object f(@os.l m<? extends T> mVar, @os.l um.d<? super l2> dVar) {
        Object objI = i(mVar.iterator(), dVar);
        return objI == wm.a.COROUTINE_SUSPENDED ? objI : l2.f10208a;
    }

    @os.m
    public final Object h(@os.l Iterable<? extends T> iterable, @os.l um.d<? super l2> dVar) {
        Object objI;
        return (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) && (objI = i(iterable.iterator(), dVar)) == wm.a.COROUTINE_SUSPENDED) ? objI : l2.f10208a;
    }

    @os.m
    public abstract Object i(@os.l Iterator<? extends T> it, @os.l um.d<? super l2> dVar);
}
