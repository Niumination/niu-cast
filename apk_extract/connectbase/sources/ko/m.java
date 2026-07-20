package ko;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends f implements uo.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Class<?> f9429c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(@os.m dp.f fVar, @os.l Class<?> cls) {
        super(fVar);
        l0.p(cls, "klass");
        this.f9429c = cls;
    }

    @Override // uo.h
    @os.l
    public uo.x b() {
        return z.f9442a.a(this.f9429c);
    }
}
