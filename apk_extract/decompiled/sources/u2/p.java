package u2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class p extends j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f10355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f10356h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(com.google.android.gms.common.internal.a aVar, int i8, IBinder iBinder, Bundle bundle) {
        super(aVar, i8, bundle);
        this.f10356h = aVar;
        this.f10355g = iBinder;
    }

    @Override // u2.j
    public final void a(ConnectionResult connectionResult) {
        e eVar = this.f10356h.q;
        if (eVar != null) {
            ((q2.h) eVar.f10334a).g(connectionResult);
        }
        System.currentTimeMillis();
    }

    @Override // u2.j
    public final boolean b() {
        IBinder iBinder = this.f10355g;
        try {
            l.e(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            com.google.android.gms.common.internal.a aVar = this.f10356h;
            if (!aVar.p().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + aVar.p() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceL = aVar.l(iBinder);
            if (iInterfaceL == null || !(com.google.android.gms.common.internal.a.s(aVar, 2, 4, iInterfaceL) || com.google.android.gms.common.internal.a.s(aVar, 3, 4, iInterfaceL))) {
                return false;
            }
            aVar.u = null;
            e eVar = aVar.p;
            if (eVar == null) {
                return true;
            }
            ((q2.g) eVar.f10334a).onConnected();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
