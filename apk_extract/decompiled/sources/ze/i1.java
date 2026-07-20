package ze;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public final class i1 implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11364a;

    public /* synthetic */ i1(int i8) {
        this.f11364a = i8;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f11364a) {
            case 0:
                return ((h1) obj).c() - ((h1) obj2).c();
            default:
                return ((i2) obj).c() - ((i2) obj2).c();
        }
    }
}
