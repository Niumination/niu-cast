package y4;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements v4.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11072b;

    public /* synthetic */ v(Object obj, int i8) {
        this.f11071a = i8;
        this.f11072b = obj;
    }

    @Override // v4.q0
    public final v4.p0 create(v4.q qVar, c5.a aVar) {
        switch (this.f11071a) {
            case 0:
                if (aVar.getRawType() == Number.class) {
                    return (x) this.f11072b;
                }
                return null;
            default:
                if (aVar.getRawType() == Object.class) {
                    return new z(qVar, (v4.n0) this.f11072b, 0);
                }
                return null;
        }
    }
}
