package u2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.zzj;

/* JADX INFO: loaded from: classes.dex */
public final class n extends h3.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.google.android.gms.common.internal.a f10351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10352d;

    public n(com.google.android.gms.common.internal.a aVar, int i8) {
        super("com.google.android.gms.common.internal.IGmsCallbacks", 1);
        this.f10351c = aVar;
        this.f10352d = i8;
    }

    @Override // h3.b
    public final boolean j(int i8, Parcel parcel, Parcel parcel2) {
        if (i8 == 1) {
            int i9 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) i3.a.a(parcel, Bundle.CREATOR);
            i3.a.b(parcel);
            l.f(this.f10351c, "onPostInitComplete can be called only once per call to getRemoteService");
            com.google.android.gms.common.internal.a aVar = this.f10351c;
            aVar.getClass();
            p pVar = new p(aVar, i9, strongBinder, bundle);
            m mVar = aVar.e;
            mVar.sendMessage(mVar.obtainMessage(1, this.f10352d, -1, pVar));
            this.f10351c = null;
        } else if (i8 == 2) {
            parcel.readInt();
            i3.a.b(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i8 != 3) {
                return false;
            }
            int i10 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            zzj zzjVar = (zzj) i3.a.a(parcel, zzj.CREATOR);
            i3.a.b(parcel);
            com.google.android.gms.common.internal.a aVar2 = this.f10351c;
            l.f(aVar2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            l.e(zzjVar);
            aVar2.f1892w = zzjVar;
            if (aVar2 instanceof y2.g) {
                ConnectionTelemetryConfiguration connectionTelemetryConfiguration = zzjVar.f1911d;
                e eVarB = e.b();
                RootTelemetryConfiguration rootTelemetryConfiguration = connectionTelemetryConfiguration == null ? null : connectionTelemetryConfiguration.f1843a;
                synchronized (eVarB) {
                    try {
                        if (rootTelemetryConfiguration == null) {
                            rootTelemetryConfiguration = e.f10332c;
                        } else {
                            RootTelemetryConfiguration rootTelemetryConfiguration2 = (RootTelemetryConfiguration) eVarB.f10334a;
                            if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.f1869a < rootTelemetryConfiguration.f1869a) {
                            }
                        }
                        eVarB.f10334a = rootTelemetryConfiguration;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            Bundle bundle2 = zzjVar.f1908a;
            l.f(this.f10351c, "onPostInitComplete can be called only once per call to getRemoteService");
            com.google.android.gms.common.internal.a aVar3 = this.f10351c;
            aVar3.getClass();
            p pVar2 = new p(aVar3, i10, strongBinder2, bundle2);
            m mVar2 = aVar3.e;
            mVar2.sendMessage(mVar2.obtainMessage(1, this.f10352d, -1, pVar2));
            this.f10351c = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
