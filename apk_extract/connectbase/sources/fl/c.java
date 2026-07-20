package fl;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public static final class a {
        @os.l
        public static <T> T a(@os.l c cVar, @os.l b<T> bVar) {
            kn.l0.p(cVar, "this");
            kn.l0.p(bVar, cb.b.c.f1408o);
            T t10 = (T) cVar.b(bVar);
            if (t10 != null) {
                return t10;
            }
            throw new IllegalStateException(kn.l0.C("No instance for key ", bVar));
        }

        @os.l
        public static <T> T b(@os.l c cVar, @os.l b<T> bVar) {
            kn.l0.p(cVar, "this");
            kn.l0.p(bVar, cb.b.c.f1408o);
            T t10 = (T) cVar.h(bVar);
            cVar.c(bVar);
            return t10;
        }

        @os.m
        public static <T> T c(@os.l c cVar, @os.l b<T> bVar) {
            kn.l0.p(cVar, "this");
            kn.l0.p(bVar, cb.b.c.f1408o);
            T t10 = (T) cVar.b(bVar);
            cVar.c(bVar);
            return t10;
        }
    }

    @os.l
    <T> T a(@os.l b<T> bVar, @os.l jn.a<? extends T> aVar);

    @os.m
    <T> T b(@os.l b<T> bVar);

    <T> void c(@os.l b<T> bVar);

    boolean d(@os.l b<?> bVar);

    @os.m
    <T> T e(@os.l b<T> bVar);

    @os.l
    List<b<?>> f();

    <T> void g(@os.l b<T> bVar, @os.l T t10);

    @os.l
    <T> T h(@os.l b<T> bVar);

    @os.l
    <T> T i(@os.l b<T> bVar);
}
