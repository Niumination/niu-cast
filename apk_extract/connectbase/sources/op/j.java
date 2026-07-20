package op;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kn.l0;
import nm.d0;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    @os.m
    public static final Set<dp.f> a(@os.l Iterable<? extends h> iterable) {
        l0.p(iterable, "<this>");
        HashSet hashSet = new HashSet();
        Iterator<? extends h> it = iterable.iterator();
        while (it.hasNext()) {
            Set<dp.f> setH = it.next().h();
            if (setH == null) {
                return null;
            }
            d0.r0(hashSet, setH);
        }
        return hashSet;
    }
}
