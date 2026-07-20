package af;

import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class v2 extends ze.z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f633b;

    public /* synthetic */ v2(Object obj, int i8) {
        this.f632a = i8;
        this.f633b = obj;
    }

    @Override // ze.z0
    public final ze.x0 a(i4 i4Var) {
        switch (this.f632a) {
            case 0:
                return (ze.x0) this.f633b;
            case 1:
                return (ze.x0) this.f633b;
            default:
                return ze.x0.a((ze.q2) this.f633b);
        }
    }

    public String toString() {
        switch (this.f632a) {
            case 0:
                o6.a aVar = new o6.a(v2.class.getSimpleName());
                aVar.d((ze.x0) this.f633b, "panicPickResult");
                return aVar.toString();
            case 1:
                return "FixedResultPicker(" + ((ze.x0) this.f633b) + ")";
            default:
                return super.toString();
        }
    }

    public v2(Throwable th2) {
        this.f632a = 0;
        ze.q2 q2VarG = ze.q2.f11410m.h("Panic! This is a bug!").g(th2);
        ze.x0 x0Var = ze.x0.e;
        v8.c("drop status shouldn't be OK", !q2VarG.e());
        this.f633b = new ze.x0(null, null, q2VarG, true);
    }
}
