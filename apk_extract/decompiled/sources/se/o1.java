package se;

import com.welink.protocol.nfbd.NearDevice;
import kotlin.Unit;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t1 f9910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NearDevice f9911c;

    public /* synthetic */ o1(t1 t1Var, NearDevice nearDevice, int i8) {
        this.f9909a = i8;
        this.f9910b = t1Var;
        this.f9911c = nearDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9909a) {
            case 0:
                NearDevice nearDevice = this.f9911c;
                t4 t4Var = t4.LE_DEVICE;
                t1 t1Var = this.f9910b;
                t1Var.getClass();
                t1Var.f(new n1(t1Var, nearDevice, t4Var, 1));
                return;
            default:
                t1 t1Var2 = this.f9910b;
                NearDevice nearDevice2 = this.f9911c;
                synchronized (t1Var2.f9990d) {
                    t1Var2.H(nearDevice2, t1.w(nearDevice2), true, false);
                    Unit unit = Unit.INSTANCE;
                }
                return;
        }
    }
}
