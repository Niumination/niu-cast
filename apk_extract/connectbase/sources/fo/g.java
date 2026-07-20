package fo;

import java.util.Iterator;
import java.util.List;
import kn.l0;
import nm.k0;

/* JADX INFO: loaded from: classes3.dex */
public interface g extends Iterable<c>, ln.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final a f6167h = a.f6168a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f6168a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public static final g f6169b = new C0146a();

        /* JADX INFO: renamed from: fo.g$a$a, reason: collision with other inner class name */
        public static final class C0146a implements g {
            @os.m
            public Void a(@os.l dp.c cVar) {
                l0.p(cVar, "fqName");
                return null;
            }

            @Override // fo.g
            public /* bridge */ /* synthetic */ c d(dp.c cVar) {
                return (c) a(cVar);
            }

            @Override // fo.g
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            @os.l
            public Iterator<c> iterator() {
                return k0.INSTANCE.iterator();
            }

            @Override // fo.g
            public boolean p(@os.l dp.c cVar) {
                return b.b(this, cVar);
            }

            @os.l
            public String toString() {
                return "EMPTY";
            }
        }

        @os.l
        public final g a(@os.l List<? extends c> list) {
            l0.p(list, "annotations");
            return list.isEmpty() ? f6169b : new h(list);
        }

        @os.l
        public final g b() {
            return f6169b;
        }
    }

    public static final class b {
        @os.m
        public static c a(@os.l g gVar, @os.l dp.c cVar) {
            c next;
            l0.p(gVar, "this");
            l0.p(cVar, "fqName");
            Iterator<c> it = gVar.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (l0.g(next.e(), cVar)) {
                    return next;
                }
            }
            next = null;
            return next;
        }

        public static boolean b(@os.l g gVar, @os.l dp.c cVar) {
            l0.p(gVar, "this");
            l0.p(cVar, "fqName");
            return gVar.d(cVar) != null;
        }
    }

    @os.m
    c d(@os.l dp.c cVar);

    boolean isEmpty();

    boolean p(@os.l dp.c cVar);
}
