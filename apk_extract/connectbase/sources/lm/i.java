package lm;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.7")
@p2(markerClass = {r.class})
@um.j
public abstract class i<T, R> {
    public i() {
    }

    @os.m
    public abstract Object a(T t10, @os.l um.d<? super R> dVar);

    @os.m
    public abstract <U, S> Object b(@os.l g<U, S> gVar, U u10, @os.l um.d<? super S> dVar);

    @k(level = m.ERROR, message = "'invoke' should not be called from DeepRecursiveScope. Use 'callRecursive' to do recursion in the heap instead of the call stack.", replaceWith = @a1(expression = "this.callRecursive(value)", imports = {}))
    @os.l
    public final Void d(@os.l g<?, ?> gVar, @os.m Object obj) {
        kn.l0.p(gVar, "<this>");
        throw new UnsupportedOperationException("Should not be called from DeepRecursiveScope");
    }

    public i(kn.w wVar) {
    }
}
