package ed;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.internal.app.ITranAssistUtils;
import com.transsion.hubsdk.internal.app.ITranVoiceInteractionSessionShowCallback;
import ic.n0;

/* JADX INFO: loaded from: classes2.dex */
public class d implements xf.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4258b = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranAssistUtils f4259a = ITranAssistUtils.Stub.asInterface(TranServiceManager.getServiceIBinder("assistutils"));

    public class a extends ITranVoiceInteractionSessionShowCallback.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public da.c.a f4260a;

        public a(da.c.a aVar) {
            this.f4260a = aVar;
        }

        public void a() throws RemoteException {
            da.c.a aVar = this.f4260a;
            if (aVar != null) {
                aVar.a();
            }
        }

        public void b() throws RemoteException {
            da.c.a aVar = this.f4260a;
            if (aVar != null) {
                aVar.onShown();
            }
        }
    }

    @Override // xf.b
    public boolean a(Bundle bundle, int i10, da.c.a aVar, IBinder iBinder) {
        return b(bundle, i10, aVar, iBinder);
    }

    @Override // xf.b
    public boolean b(final Bundle bundle, final int i10, final da.c.a aVar, final IBinder iBinder) {
        boolean zBooleanValue = ((Boolean) new zb.f().c(new zb.f.b() { // from class: ed.c
            @Override // zb.f.b
            public final Object run() {
                return this.f4253a.d(bundle, i10, aVar, iBinder);
            }
        }, "assistutils")).booleanValue();
        n0.a("showSessionForActiveServiceExt result:", zBooleanValue, f4258b);
        return zBooleanValue;
    }

    public final /* synthetic */ Object d(Bundle bundle, int i10, da.c.a aVar, IBinder iBinder) throws RemoteException {
        ITranAssistUtils iTranAssistUtils = this.f4259a;
        return iTranAssistUtils != null ? Boolean.valueOf(iTranAssistUtils.showSessionForActiveServiceExt(bundle, i10, new a(aVar), iBinder)) : Boolean.FALSE;
    }

    @VisibleForTesting
    public void e(ITranAssistUtils iTranAssistUtils) {
        this.f4259a = iTranAssistUtils;
    }
}
