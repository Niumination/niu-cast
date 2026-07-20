package fl;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    @t0
    @os.l
    public static final <T> Set<T> a(@os.l Set<? extends T> set) {
        kn.l0.p(set, "<this>");
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(set);
        kn.l0.o(setUnmodifiableSet, "unmodifiableSet(this)");
        return setUnmodifiableSet;
    }
}
