package nm;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
public final class g1<E> extends c<E> implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<E> f11627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11629d;

    /* JADX WARN: Multi-variable type inference failed */
    public g1(@os.l List<? extends E> list) {
        kn.l0.p(list, "list");
        this.f11627b = list;
    }

    public final void a(int i10, int i11) {
        c.Companion.d(i10, i11, this.f11627b.size());
        this.f11628c = i10;
        this.f11629d = i11 - i10;
    }

    @Override // nm.c, java.util.List
    public E get(int i10) {
        c.Companion.b(i10, this.f11629d);
        return this.f11627b.get(this.f11628c + i10);
    }

    @Override // nm.c, nm.a
    public int getSize() {
        return this.f11629d;
    }
}
