package ik;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements ek.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ck.c f5890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5891b;

    public h(ck.c cVar, int i8) {
        this.f5890a = cVar;
        this.f5891b = i8;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        this.f5890a.getClass();
        int i8 = this.f5891b;
        return i8 == Integer.MAX_VALUE ? fk.u.b(fk.u.f5091c) : fk.u.b(new fk.j(i8));
    }
}
