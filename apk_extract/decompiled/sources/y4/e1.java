package y4;

/* JADX INFO: loaded from: classes2.dex */
public final class e1 implements v4.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f11048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Class f11049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ v4.p0 f11050d;

    public /* synthetic */ e1(Class cls, Class cls2, v4.p0 p0Var, int i8) {
        this.f11047a = i8;
        this.f11048b = cls;
        this.f11049c = cls2;
        this.f11050d = p0Var;
    }

    @Override // v4.q0
    public final v4.p0 create(v4.q qVar, c5.a aVar) {
        switch (this.f11047a) {
            case 0:
                Class rawType = aVar.getRawType();
                if (rawType == this.f11048b || rawType == this.f11049c) {
                    return this.f11050d;
                }
                return null;
            default:
                Class rawType2 = aVar.getRawType();
                if (rawType2 == this.f11048b || rawType2 == this.f11049c) {
                    return this.f11050d;
                }
                return null;
        }
    }

    public final String toString() {
        switch (this.f11047a) {
            case 0:
                return "Factory[type=" + this.f11049c.getName() + vj.e.ANY_NON_NULL_MARKER + this.f11048b.getName() + ",adapter=" + this.f11050d + "]";
            default:
                return "Factory[type=" + this.f11048b.getName() + vj.e.ANY_NON_NULL_MARKER + this.f11049c.getName() + ",adapter=" + this.f11050d + "]";
        }
    }
}
