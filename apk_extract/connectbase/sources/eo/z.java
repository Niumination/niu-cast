package eo;

import yp.k;

/* JADX INFO: loaded from: classes3.dex */
public final class z<Type extends yp.k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final dp.f f4652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Type f4653b;

    public z(@os.l dp.f fVar, @os.l Type type) {
        kn.l0.p(fVar, "underlyingPropertyName");
        kn.l0.p(type, "underlyingType");
        this.f4652a = fVar;
        this.f4653b = type;
    }

    @os.l
    public final dp.f a() {
        return this.f4652a;
    }

    @os.l
    public final Type b() {
        return this.f4653b;
    }
}
