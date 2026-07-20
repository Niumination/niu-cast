package nq;

/* JADX INFO: loaded from: classes3.dex */
public interface p<T> extends um.d<T> {

    public static final class a {
        public static /* synthetic */ boolean a(p pVar, Throwable th2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i10 & 1) != 0) {
                th2 = null;
            }
            return pVar.c(th2);
        }

        public static /* synthetic */ Object b(p pVar, Object obj, Object obj2, int i10, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i10 & 2) != 0) {
                obj2 = null;
            }
            return pVar.e(obj, obj2);
        }
    }

    @g2
    void F();

    @a2
    void G(@os.l n0 n0Var, T t10);

    void H(@os.l jn.l<? super Throwable, lm.l2> lVar);

    @os.m
    @g2
    Object I(T t10, @os.m Object obj, @os.m jn.l<? super Throwable, lm.l2> lVar);

    @g2
    void M(@os.l Object obj);

    boolean c(@os.m Throwable th2);

    @os.m
    @g2
    Object e(T t10, @os.m Object obj);

    @a2
    void g(T t10, @os.m jn.l<? super Throwable, lm.l2> lVar);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @os.m
    @g2
    Object j(@os.l Throwable th2);

    @a2
    void l(@os.l n0 n0Var, @os.l Throwable th2);
}
