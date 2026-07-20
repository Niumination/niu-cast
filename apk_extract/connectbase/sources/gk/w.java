package gk;

import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return rm.g.l(Double.valueOf(((y) t11).f6741b), Double.valueOf(((y) t10).f6741b));
        }
    }

    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f6718a;

        public b(Comparator comparator) {
            this.f6718a = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f6718a.compare(t10, t11);
            if (iCompare != 0) {
                return iCompare;
            }
            ik.i iVar = ((y) t10).f6740a;
            int i10 = kn.l0.g(iVar.f7983d, "*") ? 2 : 0;
            if (kn.l0.g(iVar.f7984e, "*")) {
                i10++;
            }
            Integer numValueOf = Integer.valueOf(i10);
            ik.i iVar2 = ((y) t11).f6740a;
            int i11 = kn.l0.g(iVar2.f7983d, "*") ? 2 : 0;
            if (kn.l0.g(iVar2.f7984e, "*")) {
                i11++;
            }
            return rm.g.l(numValueOf, Integer.valueOf(i11));
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f6719a;

        public c(Comparator comparator) {
            this.f6719a = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f6719a.compare(t10, t11);
            return iCompare != 0 ? iCompare : rm.g.l(Integer.valueOf(((y) t11).f6740a.f8236b.size()), Integer.valueOf(((y) t10).f6740a.f8236b.size()));
        }
    }

    public static final <F, T> T a(Iterable<? extends F> iterable, jn.l<? super F, ? extends T> lVar) {
        Iterator<? extends F> it = iterable.iterator();
        while (it.hasNext()) {
            T tInvoke = lVar.invoke(it.next());
            if (tInvoke != null) {
                return tInvoke;
            }
        }
        return null;
    }

    @os.l
    public static final List<y> b(@os.l List<y> list) {
        kn.l0.p(list, "<this>");
        return nm.h0.u5(list, new c(new b(new a())));
    }

    @os.l
    public static final Charset c(@os.l dk.b bVar, @os.l Charset charset) {
        kn.l0.p(bVar, "<this>");
        kn.l0.p(charset, "defaultCharset");
        Iterator<ik.x> it = uk.e.c(bVar.d()).iterator();
        while (it.hasNext()) {
            String str = it.next().f8200a;
            if (kn.l0.g(str, "*")) {
                return charset;
            }
            if (Charset.isSupported(str)) {
                Charset charsetForName = Charset.forName(str);
                kn.l0.o(charsetForName, "forName(charset)");
                return charsetForName;
            }
        }
        return charset;
    }

    public static /* synthetic */ Charset d(dk.b bVar, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        return c(bVar, charset);
    }
}
