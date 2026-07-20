package y4;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 implements v4.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v4.p0 f11042c;

    public /* synthetic */ c1(Object obj, v4.p0 p0Var, int i8) {
        this.f11040a = i8;
        this.f11041b = obj;
        this.f11042c = p0Var;
    }

    @Override // v4.q0
    public final v4.p0 create(v4.q qVar, c5.a aVar) {
        switch (this.f11040a) {
            case 0:
                if (aVar.getRawType() == ((Class) this.f11041b)) {
                    return this.f11042c;
                }
                return null;
            case 1:
                Class<?> rawType = aVar.getRawType();
                if (((Class) this.f11041b).isAssignableFrom(rawType)) {
                    return new c(this, rawType);
                }
                return null;
            default:
                if (aVar.equals((c5.a) this.f11041b)) {
                    return this.f11042c;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.f11040a) {
            case 0:
                return "Factory[type=" + ((Class) this.f11041b).getName() + ",adapter=" + this.f11042c + "]";
            case 1:
                return "Factory[typeHierarchy=" + ((Class) this.f11041b).getName() + ",adapter=" + this.f11042c + "]";
            default:
                return super.toString();
        }
    }
}
