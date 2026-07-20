package i4;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class k1 extends h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f5619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5 f5620c;

    public k1(h5 h5Var) {
        this.f5620c = h5Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5618a > 0 || this.f5620c.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f5618a <= 0) {
            b4 b4Var = (b4) this.f5620c.next();
            this.f5619b = b4Var.getElement();
            this.f5618a = b4Var.getCount();
        }
        this.f5618a--;
        Object obj = this.f5619b;
        Objects.requireNonNull(obj);
        return obj;
    }
}
