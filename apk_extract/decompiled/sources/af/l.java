package af;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends ze.z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f407a;

    public /* synthetic */ l(int i8) {
        this.f407a = i8;
    }

    @Override // ze.z0
    public final ze.x0 a(i4 i4Var) {
        switch (this.f407a) {
            case 0:
                break;
            case 1:
                break;
        }
        return ze.x0.e;
    }

    public final String toString() {
        switch (this.f407a) {
            case 0:
                return new o6.a(l.class.getSimpleName()).toString();
            case 1:
                return "BUFFER_PICKER";
            default:
                return "EMPTY_PICKER";
        }
    }
}
