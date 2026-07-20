package i4;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class x1 extends q1 {
    public final Comparator f;

    public x1(Comparator comparator) {
        super(4);
        comparator.getClass();
        this.f = comparator;
    }

    @Override // i4.q1
    public final q1 d(Object obj) {
        super.d(obj);
        return this;
    }

    @Override // i4.q1
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final z1 e() {
        z1 z1VarConstruct = z1.construct(this.f, this.f5713b, this.f5712a);
        this.f5713b = z1VarConstruct.size();
        this.f5714c = true;
        return z1VarConstruct;
    }
}
