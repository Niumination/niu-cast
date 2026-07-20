package u2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class o implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f10354b;

    public o(com.google.android.gms.common.internal.a aVar, int i8) {
        this.f10354b = aVar;
        this.f10353a = i8;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i8;
        int i9;
        if (iBinder == null) {
            com.google.android.gms.common.internal.a aVar = this.f10354b;
            synchronized (aVar.f1880h) {
                i8 = aVar.f1887o;
            }
            if (i8 == 3) {
                aVar.f1891v = true;
                i9 = 5;
            } else {
                i9 = 4;
            }
            m mVar = aVar.e;
            mVar.sendMessage(mVar.obtainMessage(i9, aVar.f1893x.get(), 16));
            return;
        }
        synchronized (this.f10354b.f1881i) {
            try {
                com.google.android.gms.common.internal.a aVar2 = this.f10354b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                aVar2.f1882j = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof k)) ? new k(iBinder) : (k) iInterfaceQueryLocalInterface;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        com.google.android.gms.common.internal.a aVar3 = this.f10354b;
        int i10 = this.f10353a;
        aVar3.getClass();
        q qVar = new q(aVar3, 0);
        m mVar2 = aVar3.e;
        mVar2.sendMessage(mVar2.obtainMessage(7, i10, -1, qVar));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.common.internal.a aVar;
        synchronized (this.f10354b.f1881i) {
            aVar = this.f10354b;
            aVar.f1882j = null;
        }
        m mVar = aVar.e;
        mVar.sendMessage(mVar.obtainMessage(6, this.f10353a, 1));
    }
}
