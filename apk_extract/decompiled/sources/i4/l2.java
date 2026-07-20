package i4;

/* JADX INFO: loaded from: classes.dex */
public abstract class l2 implements p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5636b;

    public l2(Object obj, int i8) {
        this.f5635a = obj;
        this.f5636b = i8;
    }

    @Override // i4.p2
    public final int b() {
        return this.f5636b;
    }

    @Override // i4.p2
    public p2 c() {
        return null;
    }

    @Override // i4.p2
    public final Object getKey() {
        return this.f5635a;
    }
}
