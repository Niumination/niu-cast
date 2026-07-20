package tj;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f10238a;

    public b(c cVar) {
        this.f10238a = cVar;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        Log.d("AIotSDK", "onBindingDied");
        this.f10238a.f10244g = false;
        c.a(this.f10238a, false);
        try {
            x.n().r();
        } catch (Exception e) {
            Log.w("AIotSDK", "Error unregistering proximity service", e);
        }
        c cVar = this.f10238a;
        cVar.f10240a = null;
        cVar.f10241b = null;
        cVar.f10243d = null;
        cVar.f10242c = null;
        if (cVar.e.isEmpty() || this.f10238a.f == null) {
            return;
        }
        Log.d("AIotSDK", "Attempting to rebind service after binding died");
        this.f10238a.b();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        p pVar;
        v vVar;
        j jVar;
        Log.d("AIotSDK", "onServiceConnected");
        c cVar = this.f10238a;
        int i8 = o.f10254b;
        s sVar = null;
        if (iBinder == null) {
            pVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("org.appspot.transsion.aiot.aidl.IMulCooperateCommonInterface");
            if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof p)) {
                n nVar = new n();
                nVar.f10253b = iBinder;
                pVar = nVar;
            } else {
                pVar = (p) iInterfaceQueryLocalInterface;
            }
        }
        cVar.f10240a = pVar;
        try {
            n nVar2 = (n) this.f10238a.f10240a;
            nVar2.getClass();
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("org.appspot.transsion.aiot.aidl.IMulCooperateCommonInterface");
                nVar2.f10253b.transact(2, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                IBinder strongBinder = parcelObtain2.readStrongBinder();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                Log.d("AIotSDK", "onServiceConnected proxi begin");
                c cVar2 = this.f10238a;
                int i9 = u.f10258b;
                if (strongBinder == null) {
                    vVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder.queryLocalInterface("org.appspot.transsion.aiot.aidl.IMulCooperateProximityInterface");
                    if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof v)) {
                        t tVar = new t();
                        tVar.f10257b = strongBinder;
                        vVar = tVar;
                    } else {
                        vVar = (v) iInterfaceQueryLocalInterface2;
                    }
                }
                cVar2.f10241b = vVar;
                Log.d("AIotSDK", "onServiceConnected proxi end");
                x xVarN = x.n();
                xVarN.f10264a = this.f10238a.f10241b;
                Log.i("ProximityManager", "mProximityInterface" + ((v) xVarN.f10264a));
                n nVar3 = (n) this.f10238a.f10240a;
                nVar3.getClass();
                Parcel parcelObtain3 = Parcel.obtain();
                Parcel parcelObtain4 = Parcel.obtain();
                try {
                    parcelObtain3.writeInterfaceToken("org.appspot.transsion.aiot.aidl.IMulCooperateCommonInterface");
                    nVar3.f10253b.transact(5, parcelObtain3, parcelObtain4, 0);
                    parcelObtain4.readException();
                    IBinder strongBinder2 = parcelObtain4.readStrongBinder();
                    parcelObtain4.recycle();
                    parcelObtain3.recycle();
                    Log.d("AIotSDK", "onServiceConnected cellular begin");
                    c cVar3 = this.f10238a;
                    int i10 = i.f10251b;
                    if (strongBinder2 == null) {
                        jVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface3 = strongBinder2.queryLocalInterface("org.appspot.transsion.aiot.aidl.ICellularShareService");
                        if (iInterfaceQueryLocalInterface3 == null || !(iInterfaceQueryLocalInterface3 instanceof j)) {
                            h hVar = new h();
                            hVar.f10250b = strongBinder2;
                            jVar = hVar;
                        } else {
                            jVar = (j) iInterfaceQueryLocalInterface3;
                        }
                    }
                    cVar3.f10243d = jVar;
                    Log.d("AIotSDK", "onServiceConnected cellular end");
                    d dVarB = d.b();
                    dVarB.f10248a = this.f10238a.f10243d;
                    Log.i("CellularShareManager", "CellularShareManager initialized with service: " + dVarB.f10248a);
                    n nVar4 = (n) this.f10238a.f10240a;
                    nVar4.getClass();
                    Parcel parcelObtain5 = Parcel.obtain();
                    Parcel parcelObtain6 = Parcel.obtain();
                    try {
                        parcelObtain5.writeInterfaceToken("org.appspot.transsion.aiot.aidl.IMulCooperateCommonInterface");
                        nVar4.f10253b.transact(6, parcelObtain5, parcelObtain6, 0);
                        parcelObtain6.readException();
                        IBinder strongBinder3 = parcelObtain6.readStrongBinder();
                        parcelObtain6.recycle();
                        parcelObtain5.recycle();
                        Log.d("AIotSDK", "onServiceConnected keyMouse begin");
                        c cVar4 = this.f10238a;
                        int i11 = r.f10256b;
                        if (strongBinder3 != null) {
                            IInterface iInterfaceQueryLocalInterface4 = strongBinder3.queryLocalInterface("org.appspot.transsion.aiot.aidl.IMulCooperateKeyMouseShareInterface");
                            if (iInterfaceQueryLocalInterface4 == null || !(iInterfaceQueryLocalInterface4 instanceof s)) {
                                q qVar = new q();
                                qVar.f10255b = strongBinder3;
                                sVar = qVar;
                            } else {
                                sVar = (s) iInterfaceQueryLocalInterface4;
                            }
                        }
                        cVar4.f10242c = sVar;
                        Log.d("AIotSDK", "onServiceConnected keyMouse end");
                        if (w.f10259c == null) {
                            synchronized (w.class) {
                                try {
                                    if (w.f10259c == null) {
                                        w.f10259c = new w(0);
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        }
                        w wVar = w.f10259c;
                        wVar.f10262b = this.f10238a.f10242c;
                        Log.i("KeyMouseShareManager", "KeyMouseShareManager initialized: " + ((s) wVar.f10262b));
                        Log.d("AIotSDK", "ProximityManager.getInstance().getProxityServiceState()" + x.n().o());
                        if (!x.n().o()) {
                            x.n().p(this.f10238a.f10245h);
                            return;
                        }
                        this.f10238a.f10244g = true;
                        Log.d("AIotSDK", "connect callback");
                        c.a(this.f10238a, true);
                    } catch (Throwable th3) {
                        parcelObtain6.recycle();
                        parcelObtain5.recycle();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    parcelObtain4.recycle();
                    parcelObtain3.recycle();
                    throw th4;
                }
            } catch (Throwable th5) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                throw th5;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Log.d("AIotSDK", "onServiceDisconnected");
        this.f10238a.f10244g = false;
        c.a(this.f10238a, false);
        try {
            x.n().r();
        } catch (Exception e) {
            Log.w("AIotSDK", "Error unregistering proximity service", e);
        }
        c cVar = this.f10238a;
        cVar.f10240a = null;
        cVar.f10241b = null;
        cVar.f10243d = null;
        cVar.f10242c = null;
    }
}
