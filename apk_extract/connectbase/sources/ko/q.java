package ko;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends f implements uo.m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final Enum<?> f9433c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(@os.m dp.f fVar, @os.l Enum<?> r10) {
        super(fVar);
        l0.p(r10, "value");
        this.f9433c = r10;
    }

    @Override // uo.m
    @os.m
    public dp.b d() {
        Class<?> enclosingClass = this.f9433c.getClass();
        if (!enclosingClass.isEnum()) {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        l0.o(enclosingClass, "enumClass");
        return d.a(enclosingClass);
    }

    @Override // uo.m
    @os.m
    public dp.f e() {
        return dp.f.k(this.f9433c.name());
    }
}
