package rm;

import java.util.Comparator;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class l<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Comparator<T> f14587a;

    public l(@os.l Comparator<T> comparator) {
        l0.p(comparator, "comparator");
        this.f14587a = comparator;
    }

    @os.l
    public final Comparator<T> a() {
        return this.f14587a;
    }

    @Override // java.util.Comparator
    public int compare(T t10, T t11) {
        return this.f14587a.compare(t11, t10);
    }

    @Override // java.util.Comparator
    @os.l
    public final Comparator<T> reversed() {
        return this.f14587a;
    }
}
