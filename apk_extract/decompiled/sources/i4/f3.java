package i4;

/* JADX INFO: loaded from: classes.dex */
public class f3 extends l2 implements q3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile r3 f5586c;

    public f3(Object obj, int i8) {
        super(obj, i8);
        this.f5586c = u3.unsetWeakValueReference();
    }

    @Override // i4.q3
    public final r3 a() {
        return this.f5586c;
    }

    @Override // i4.p2
    public final Object getValue() {
        return this.f5586c.get();
    }
}
