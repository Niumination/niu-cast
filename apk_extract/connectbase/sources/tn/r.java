package tn;

import java.lang.Comparable;
import kn.l0;
import lm.f1;
import lm.p2;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.9")
@p2(markerClass = {lm.r.class})
public interface r<T extends Comparable<? super T>> {

    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@os.l r<T> rVar, @os.l T t10) {
            l0.p(t10, "value");
            return t10.compareTo(rVar.getStart()) >= 0 && t10.compareTo(rVar.c()) < 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@os.l r<T> rVar) {
            return rVar.getStart().compareTo(rVar.c()) >= 0;
        }
    }

    @os.l
    T c();

    boolean contains(@os.l T t10);

    @os.l
    T getStart();

    boolean isEmpty();
}
