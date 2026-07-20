package tn;

import java.lang.Comparable;
import kn.l0;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.1")
public interface f<T extends Comparable<? super T>> extends g<T> {

    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@os.l f<T> fVar, @os.l T t10) {
            l0.p(t10, "value");
            return fVar.a(fVar.getStart(), t10) && fVar.a(t10, fVar.getEndInclusive());
        }

        public static <T extends Comparable<? super T>> boolean b(@os.l f<T> fVar) {
            return !fVar.a(fVar.getStart(), fVar.getEndInclusive());
        }
    }

    boolean a(@os.l T t10, @os.l T t11);

    @Override // tn.g
    boolean contains(@os.l T t10);

    @Override // tn.g
    boolean isEmpty();
}
