package af;

/* JADX INFO: loaded from: classes3.dex */
public final class d5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l6 f220b;

    public /* synthetic */ d5(l6 l6Var, int i8) {
        this.f219a = i8;
        this.f220b = l6Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f219a) {
            case 0:
                x2 x2Var = (x2) this.f220b.f447c;
                x2Var.f703z = true;
                d0 d0Var = x2Var.u;
                qf.c cVar = x2Var.f697s;
                d0Var.l((ze.q2) cVar.f9047b, (c0) cVar.f9048c, (ze.p1) cVar.f9049d);
                break;
            default:
                x2 x2Var2 = (x2) this.f220b.f447c;
                if (!x2Var2.f703z) {
                    x2Var2.u.q();
                }
                break;
        }
    }
}
