package ko;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends f implements uo.o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Object f9435c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(@os.m dp.f fVar, @os.l Object obj) {
        super(fVar);
        l0.p(obj, "value");
        this.f9435c = obj;
    }

    @Override // uo.o
    @os.l
    public Object getValue() {
        return this.f9435c;
    }
}
