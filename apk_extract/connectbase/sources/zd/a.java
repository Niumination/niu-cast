package zd;

import com.transsion.hubsdk.powerhalmgr.TranPowerHalMgr;

/* JADX INFO: loaded from: classes2.dex */
public class a implements tg.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f21922b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranPowerHalMgr f21923a = new TranPowerHalMgr();

    @Override // tg.a
    public int a(int i10, int i11, int[] iArr) {
        return this.f21923a.perfLockAcquire(i10, i11, iArr);
    }

    @Override // tg.a
    public void b(int i10) {
        this.f21923a.perfLockRelease(i10);
    }
}
