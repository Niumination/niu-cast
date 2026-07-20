package tj;

import af.j3;
import af.l1;
import af.o2;
import af.q3;
import af.t5;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.os.DeadObjectException;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import androidx.databinding.InverseBindingListener;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.lifecycle.MutableLiveData;
import cf.h0;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.transsion.iotservice.multiscreen.pc.databinding.DialogPcRequestConnectBindingImpl;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.PcRequestConnectViewModel;
import com.transsion.widgetslib.widget.shadow.SpringFloatingOvalButton;
import java.util.Map;
import k3.o9;
import ze.c2;
import ze.d2;
import ze.q2;
import ze.y;
import zj.o0;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements q3, ze.t, c8.b, o2, jd.g, ck.b, d2, ba.a, q3.d, hf.r, hf.s, hf.p, InverseBindingListener, u5.a, f8.b, zj.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile x f10263b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f10264a;

    public /* synthetic */ x(Object obj) {
        this.f10264a = obj;
    }

    public static x n() {
        if (f10263b == null) {
            synchronized (x.class) {
                try {
                    if (f10263b == null) {
                        f10263b = new x();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f10263b;
    }

    @Override // c8.b, tk.a
    public boolean a() {
        return !((c8.c) this.f10264a).f1454a.canScrollHorizontally(1);
    }

    @Override // c8.b, tk.a
    public boolean b() {
        return !((c8.c) this.f10264a).f1454a.canScrollHorizontally(-1);
    }

    @Override // jd.g
    public void c(DynamicAnimation dynamicAnimation, boolean z2, float f, float f4) {
        jd.g gVar = ((SpringFloatingOvalButton) this.f10264a).f3659d;
        if (gVar != null) {
            gVar.c(dynamicAnimation, z2, f, f4);
        }
    }

    @Override // ek.g
    public Object call(Object obj) {
        ck.i iVar = (ck.i) obj;
        fk.g gVar = new fk.g(iVar, (ek.g) this.f10264a, 0);
        iVar.f1736a.a(gVar);
        return gVar;
    }

    @Override // zj.f
    public void d(zj.c cVar, o0 o0Var) {
        ((zj.g) this.f10264a).complete(o0Var);
    }

    @Override // ze.d2
    public ze.i e(c2 c2Var) {
        hf.o oVar = new hf.o(c2Var, true);
        hf.v vVarInvoke = ((hf.p) this.f10264a).invoke(oVar);
        c2Var.b(1);
        return new hf.q(vVarInvoke, oVar, c2Var);
    }

    @Override // af.o2
    public void f() {
        synchronized (((h0) this.f10264a).f1546n) {
            ((h0) this.f10264a).f1548r.j(false, 0, 57005);
            ((h0) this.f10264a).f1548r.flush();
        }
        ((h0) this.f10264a).f1537c.getClass();
    }

    @Override // u5.a
    public Rect g() {
        zzu zzuVar = (zzu) this.f10264a;
        if (zzuVar.e == null) {
            return null;
        }
        int i8 = 0;
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        while (true) {
            Point[] pointArr = zzuVar.e;
            if (i8 >= pointArr.length) {
                return new Rect(iMin, iMin2, iMax, iMax2);
            }
            Point point = pointArr[i8];
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
            i8++;
        }
    }

    @Override // u5.a
    public int getFormat() {
        return ((zzu) this.f10264a).f2046a;
    }

    @Override // ba.a
    public String[] getTetherableUsbRegexs() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f10264a;
        Object objE = o9.e(connectivityManager, o9.d(connectivityManager.getClass(), "getTetherableUsbRegexs", new Class[0]), new Object[0]);
        if (objE instanceof String[]) {
            return (String[]) objE;
        }
        return null;
    }

    @Override // u5.a
    public String h() {
        return ((zzu) this.f10264a).f2047b;
    }

    @Override // u5.a
    public int i() {
        return ((zzu) this.f10264a).f2049d;
    }

    @Override // hf.s
    public void invoke(Object obj, hf.v vVar) {
        qa.f fVar = (qa.f) obj;
        ((p2.d) this.f10264a).getClass();
        StringBuilder sb2 = new StringBuilder("request:");
        sb2.append(fVar != null ? fVar.f8972a : null);
        Log.d("LifeCycleServer", sb2.toString());
        qa.b bVar = (qa.b) qa.c.f8967a.createBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(fVar != null ? fVar.f8972a : null);
        sb3.append("+Reply");
        bVar.a(sb3.toString());
        vVar.onNext((qa.c) bVar.build());
        vVar.onCompleted();
    }

    @Override // af.o2
    public void j() {
        synchronized (((h0) this.f10264a).f1546n) {
            ((h0) this.f10264a).f1552w = q2.f11411n.h("Keepalive failed. Considering connection dead");
            l1.b(((h0) this.f10264a).e);
        }
    }

    @Override // ba.a
    public void k(boolean z2) {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f10264a;
        o9.e(connectivityManager, o9.d(connectivityManager.getClass(), "setUsbTethering", Boolean.TYPE), Boolean.valueOf(z2));
    }

    @Override // u5.a
    public Point[] l() {
        return ((zzu) this.f10264a).e;
    }

    @Override // ze.t
    public void m(y yVar) {
        q2 q2VarS = ze.i.s(yVar);
        if (q2.f11405h.f11413a.equals(q2VarS.f11413a)) {
            ((t5) this.f10264a).f600i.h(q2VarS);
        }
    }

    public boolean o() {
        try {
            Log.i("ProximityManager", "getProxityServiceState.");
            v vVar = (v) this.f10264a;
            if (vVar != null) {
                t tVar = (t) vVar;
                tVar.getClass();
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("org.appspot.transsion.aiot.aidl.IMulCooperateProximityInterface");
                    tVar.f10257b.transact(10, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        } catch (RemoteException e) {
            if (!(e.getCause() instanceof DeadObjectException)) {
                throw new RuntimeException(e);
            }
            Log.i("ProximityManager", "getProxityServiceState dead");
        }
        return false;
    }

    @Override // androidx.databinding.InverseBindingListener
    public void onChange() {
        MutableLiveData mutableLiveData;
        DialogPcRequestConnectBindingImpl dialogPcRequestConnectBindingImpl = (DialogPcRequestConnectBindingImpl) this.f10264a;
        boolean zIsChecked = dialogPcRequestConnectBindingImpl.f2526a.isChecked();
        PcRequestConnectViewModel pcRequestConnectViewModel = dialogPcRequestConnectBindingImpl.f2529d;
        if (pcRequestConnectViewModel == null || (mutableLiveData = pcRequestConnectViewModel.e) == null) {
            return;
        }
        mutableLiveData.setValue(Boolean.valueOf(zIsChecked));
    }

    @Override // zj.f
    public void onFailure(Throwable th2) {
        ((zj.g) this.f10264a).completeExceptionally(th2);
    }

    @Override // f8.b
    public void onInitFail() {
    }

    @Override // f8.b
    public void onInitSuccess(Map map) {
        ((x6.c) this.f10264a).f10875j = map.toString();
    }

    @Override // q3.d
    public void onSuccess(Object obj) {
        ((q3.g) ((se.e) this.f10264a).f9720b).f8950a.h();
    }

    public void p(a aVar) {
        try {
            Log.i("ProximityManager", "registerProxityService.");
            v vVar = (v) this.f10264a;
            if (vVar != null) {
                t tVar = (t) vVar;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("org.appspot.transsion.aiot.aidl.IMulCooperateProximityInterface");
                    parcelObtain.writeStrongInterface(aVar);
                    tVar.f10257b.transact(8, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        } catch (RemoteException e) {
            if (!(e.getCause() instanceof DeadObjectException)) {
                throw new RuntimeException(e);
            }
            Log.i("ProximityManager", "registerProxityService dead");
        }
    }

    public void q(boolean z2) {
        j3 j3Var = (j3) this.f10264a;
        j3Var.Z.l(j3Var.D, z2);
    }

    public void r() {
        try {
            Log.i("ProximityManager", "unRegisterProxityService.");
            v vVar = (v) this.f10264a;
            if (vVar != null) {
                t tVar = (t) vVar;
                tVar.getClass();
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("org.appspot.transsion.aiot.aidl.IMulCooperateProximityInterface");
                    tVar.f10257b.transact(9, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        } catch (RemoteException e) {
            if (!(e.getCause() instanceof DeadObjectException)) {
                throw new RuntimeException(e);
            }
            Log.i("ProximityManager", "unRegisterProxityService dead");
        }
    }

    @Override // hf.p
    public hf.v invoke(hf.v vVar) {
        throw new AssertionError();
    }
}
