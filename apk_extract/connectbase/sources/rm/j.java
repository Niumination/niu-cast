package rm;

import java.util.Comparator;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements Comparator<Comparable<? super Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final j f14585a = new j();

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@os.l Comparable<Object> comparable, @os.l Comparable<Object> comparable2) {
        l0.p(comparable, "a");
        l0.p(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    @Override // java.util.Comparator
    @os.l
    public final Comparator<Comparable<? super Object>> reversed() {
        return k.f14586a;
    }
}
