package tn;

import java.lang.Comparable;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public interface g<T extends Comparable<? super T>> {

    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@os.l g<T> gVar, @os.l T t10) {
            l0.p(t10, "value");
            return t10.compareTo(gVar.getStart()) >= 0 && t10.compareTo(gVar.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@os.l g<T> gVar) {
            return gVar.getStart().compareTo(gVar.getEndInclusive()) > 0;
        }
    }

    boolean contains(@os.l T t10);

    @os.l
    T getEndInclusive();

    @os.l
    T getStart();

    boolean isEmpty();
}
