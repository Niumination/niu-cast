package ye;

import android.os.RemoteException;
import java.util.TimerTask;
import k3.lb;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f11188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f11189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f11190c;

    public e(Ref.IntRef intRef, Function0 function0, Function0 function1) {
        this.f11188a = intRef;
        this.f11189b = function0;
        this.f11190c = function1;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        Ref.IntRef intRef = this.f11188a;
        intRef.element++;
        tc.d dVarH = tc.d.h();
        String strJ = "";
        if (!dVarH.k()) {
            vc.a.b("KolunScannerManager", "mKolunScanner is dead");
        } else if (dVarH.i().isEmpty()) {
            vc.a.b("KolunScannerManager", "mContext is null");
        } else {
            try {
                strJ = ((tc.a) ((tc.c) dVarH.f10209a)).j(dVarH.i(), "/proc/net/arp");
            } catch (RemoteException e) {
                vc.a.a(5, "KolunScannerManager", "readFileUserSystemPermission,err:", e);
            }
        }
        we.h.g("readArpFile artFileContent :" + strJ + " ");
        we.h.g("readArpFile CommonConstant.mRemoteIpAddress :" + lb.f6528b + " ");
        Intrinsics.checkNotNull(strJ);
        boolean zContains$default = StringsKt__StringsKt.contains$default(strJ, String.valueOf(lb.f6528b), false, 2, (Object) null);
        if (intRef.element >= 60) {
            cancel();
            this.f11189b.invoke();
        }
        if (zContains$default) {
            cancel();
            this.f11190c.invoke();
        }
        we.h.g("readArpFile containsMac :" + zContains$default);
    }
}
