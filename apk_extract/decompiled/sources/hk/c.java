package hk;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements ek.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5485c;

    public /* synthetic */ c(int i8, Object obj, Object obj2) {
        this.f5483a = i8;
        this.f5485c = obj;
        this.f5484b = obj2;
    }

    @Override // ek.a
    public final void call() {
        switch (this.f5483a) {
            case 0:
                if (!((d) this.f5485c).f5486a.f9239b) {
                    ((ek.a) this.f5484b).call();
                    break;
                }
                break;
            case 1:
                if (!((g) this.f5485c).f5496c.f5909b) {
                    ((fk.h) this.f5484b).call();
                    break;
                }
                break;
            case 2:
                if (!((g) this.f5485c).f5496c.f5909b) {
                    ((ck.f) this.f5484b).call();
                    break;
                }
                break;
            default:
                ((pk.f) this.f5485c).remove((pk.e) this.f5484b);
                break;
        }
    }
}
