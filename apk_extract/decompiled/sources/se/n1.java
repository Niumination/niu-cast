package se;

import com.welink.protocol.nfbd.NearDevice;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t1 f9886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NearDevice f9887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t4 f9888d;

    public /* synthetic */ n1(t1 t1Var, NearDevice nearDevice, t4 t4Var, int i8) {
        this.f9885a = i8;
        this.f9886b = t1Var;
        this.f9887c = nearDevice;
        this.f9888d = t4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9885a) {
            case 0:
                NearDevice nearDevice = this.f9887c;
                t1 t1Var = this.f9886b;
                t1Var.getClass();
                t1Var.f(new n1(t1Var, nearDevice, this.f9888d, 1));
                break;
            case 1:
                we.h.h("NearDeviceTableFusion", "Notify device lost");
                this.f9886b.H(this.f9887c, this.f9888d, false, true);
                break;
            case 2:
                t4 t4Var = this.f9888d;
                t1 t1Var2 = this.f9886b;
                t1Var2.getClass();
                t1Var2.f(new n1(t1Var2, this.f9887c, t4Var, 1));
                break;
            default:
                t4 t4Var2 = this.f9888d;
                t1 t1Var3 = this.f9886b;
                t1Var3.getClass();
                t1Var3.f(new n1(t1Var3, this.f9887c, t4Var2, 1));
                break;
        }
    }
}
