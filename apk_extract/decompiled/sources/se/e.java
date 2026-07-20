package se;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.sqlite.SQLiteDatabase;
import android.location.LocationManager;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Bundle;
import android.os.Parcel;
import android.os.UserHandle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearNetworkElement;
import com.welink.protocol.nfbd.TranConnectionController$P2pDeviceInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import k3.ce;
import k3.o9;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements f, ze.t, k2.b, f2.b, aa.a, q1.e, jd.h, r2.h, zj.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f9720b;

    public /* synthetic */ e(Object obj, int i8) {
        this.f9719a = i8;
        this.f9720b = obj;
    }

    public static /* synthetic */ List z(e eVar, CharSequence charSequence, int i8, int i9, boolean z2, Function2 function2, int i10) {
        int i11 = (i10 & 2) != 0 ? 0 : i8;
        if ((i10 & 4) != 0) {
            i9 = charSequence.length();
        }
        return eVar.y(charSequence, i11, i9, (i10 & 8) != 0 ? false : z2, function2);
    }

    public void A(ze.p1 p1Var, byte[] bArr) {
        ph.b.d();
        try {
            String str = "/" + ((cf.n) this.f9720b).f1596j.f11423b;
            if (bArr != null) {
                ((cf.n) this.f9720b).q = true;
                str = str + "?" + j4.e.f6102c.c(bArr);
            }
            synchronized (((cf.n) this.f9720b).f1600n.f1591w) {
                cf.m.v(((cf.n) this.f9720b).f1600n, p1Var, str);
            }
            ph.b.f8887a.getClass();
        } catch (Throwable th2) {
            try {
                ph.b.f8887a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // aa.a
    public void a() {
        UserHandle userHandle = z8.a.f11265a;
        LocationManager locationManager = (LocationManager) this.f9720b;
        o9.e(locationManager, o9.d(locationManager.getClass(), "setLocationEnabledForUser", Boolean.TYPE, UserHandle.class), Boolean.TRUE, userHandle);
    }

    @Override // r2.h
    public void accept(Object obj, Object obj2) {
        y2.e eVar = new y2.e((q3.g) obj2, 1);
        y2.d dVar = (y2.d) ((y2.g) obj).o();
        ApiFeatureRequest apiFeatureRequest = (ApiFeatureRequest) this.f9720b;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(dVar.f5236d);
        h3.c.d(parcelObtain, eVar);
        h3.c.c(parcelObtain, apiFeatureRequest);
        parcelObtain.writeStrongBinder(null);
        dVar.e(parcelObtain, 2);
    }

    @Override // jd.h
    public void b(View view, boolean z2) {
        Function0 function0;
        if (z2 || (function0 = (Function0) ((WeakReference) this.f9720b).get()) == null) {
            return;
        }
        function0.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.List] */
    public ArrayList c() {
        ?? arrayList;
        ArrayList arrayList2 = new ArrayList();
        Context context = (Context) this.f9720b;
        Bundle bundle = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                Log.w("ComponentDiscovery", "Context has no PackageManager.");
            } else {
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) MlKitComponentDiscoveryService.class), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", MlKitComponentDiscoveryService.class + " has no service info.");
                } else {
                    bundle = serviceInfo.metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("ComponentDiscovery", "Application info not found.");
        }
        if (bundle == null) {
            Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList();
            for (String str : bundle.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundle.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new ce((String) it.next(), 4));
        }
        return arrayList2;
    }

    @Override // zj.f
    public void d(zj.c cVar, zj.o0 o0Var) {
        switch (this.f9719a) {
            case 23:
                boolean zC = o0Var.f11691a.c();
                zj.g gVar = (zj.g) this.f9720b;
                if (!zC) {
                    gVar.completeExceptionally(new zj.m(o0Var));
                } else {
                    gVar.complete(o0Var.f11692b);
                }
                break;
            default:
                ((li.l) this.f9720b).resumeWith(Result.m159constructorimpl(o0Var));
                break;
        }
    }

    @Override // se.f
    public boolean e(NearDevice device, com.welink.protocol.nfbd.z manager, Function1 function1) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        device.A(1005);
        device.f(manager, new a8.a(device), function1);
        Intrinsics.checkNotNullParameter(device, "device");
        h newState = new h();
        Intrinsics.checkNotNullParameter(newState, "newState");
        device.I = newState;
        return true;
    }

    @Override // k2.b
    public Object execute() {
        i2.j jVar = (i2.j) this.f9720b;
        SQLiteDatabase sQLiteDatabaseA = ((j2.h) jVar.f5555b).a();
        sQLiteDatabaseA.beginTransaction();
        try {
            List list = (List) j2.h.k(sQLiteDatabaseA.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), j2.e.f6044c);
            sQLiteDatabaseA.setTransactionSuccessful();
            sQLiteDatabaseA.endTransaction();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jVar.f5556c.a((d2.j) it.next(), 1, false);
            }
            return null;
        } catch (Throwable th2) {
            sQLiteDatabaseA.endTransaction();
            throw th2;
        }
    }

    @Override // se.f
    public boolean f(NearDevice device, com.welink.protocol.nfbd.z manager, ConnectRequest connectRequest, r6 r6Var) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(connectRequest, "request");
        a8.a resultCallback = new a8.a(device);
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(connectRequest, "request");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        bb.f fVar = new bb.f(device, 5, r6Var, resultCallback);
        manager.getClass();
        Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
        manager.p(device, fVar, true);
        Intent intent = new Intent();
        intent.setAction("com.welink.service.ACTION_P2P_INVITATION_ACCEPTED");
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", device);
        intent.putExtra("com.welink.service.EXTRA_BLE_CONNECTED_EXCHANGE_REQUEST", connectRequest);
        com.welink.protocol.nfbd.g gVar = manager.f4207i;
        if (gVar != null) {
            gVar.w(intent, 0);
        }
        return true;
    }

    @Override // q1.e
    public m1.e g() {
        ArrayList arrayList = (ArrayList) this.f9720b;
        return ((x1.a) arrayList.get(0)).c() ? new m1.j(arrayList, 1) : new m1.m(arrayList);
    }

    @Override // yh.a
    public Object get() {
        Context context = (Context) ((tj.w) this.f9720b).f10262b;
        j2.d.f6042a.get();
        Integer num = 4;
        return new j2.k(context, num.intValue(), "com.google.android.datatransport.events");
    }

    @Override // q1.e
    public List getKeyframes() {
        return (ArrayList) this.f9720b;
    }

    @Override // se.f
    public boolean h(NearDevice device, com.welink.protocol.nfbd.z manager) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Log.e("ConnectingState", "flushDevice not support in ConnectingState");
        return false;
    }

    @Override // se.f
    public boolean i(NearDevice device, com.welink.protocol.nfbd.z manager, g5 g5Var, Function1 function1) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        return false;
    }

    @Override // q1.e
    public boolean isStatic() {
        ArrayList arrayList = (ArrayList) this.f9720b;
        return arrayList.size() == 1 && ((x1.a) arrayList.get(0)).c();
    }

    @Override // se.f
    public boolean j(NearDevice device, com.welink.protocol.nfbd.z manager, int i8, int i9, r6 r6Var) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        a8.a resultCallback = new a8.a(device);
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
        manager.p(device, new bb.f(device, 4, r6Var, resultCallback), true);
        Intent intent = new Intent();
        intent.setAction("com.welink.service.ACTION_BLE_CONNECTED_EXCHANGE_RESPONSE");
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", device);
        intent.putExtra("isBusy", false);
        intent.putExtra("requestId", i8);
        intent.putExtra(TypedValues.CycleType.S_WAVE_OFFSET, i9);
        com.welink.protocol.nfbd.g gVar = manager.f4207i;
        if (gVar != null) {
            gVar.w(intent, 0);
        }
        return true;
    }

    public boolean k(CharSequence charSequence, e5.n nVar) {
        String nationalNumberPattern = nVar.getNationalNumberPattern();
        if (nationalNumberPattern.length() == 0) {
            return false;
        }
        Matcher matcher = ((tj.w) this.f9720b).E(nationalNumberPattern).matcher(charSequence);
        if (matcher.lookingAt()) {
            return matcher.matches();
        }
        return false;
    }

    public void l(int i8) {
        b1 b1Var = (b1) this.f9720b;
        int size = b1Var.f9653a.size();
        for (int i9 = 0; i9 < size; i9++) {
            z0 z0Var = (z0) b1Var.f9653a.valueAt(i9);
            z0Var.getClass();
            we.h.b("NearConnectionManager", "onBleAdvertisingStartFailed: " + i8);
            z0Var.f10075a.execute(new v0(z0Var, i8));
        }
    }

    @Override // ze.t
    public void m(ze.y yVar) {
        if (yVar.g() != null) {
            ((af.p5) ((u6.a) this.f9720b).f10378b).f515h = true;
        }
    }

    public void n() {
        b1 b1Var = (b1) this.f9720b;
        int size = b1Var.f9653a.size();
        for (int i8 = 0; i8 < size; i8++) {
            z0 z0Var = (z0) b1Var.f9653a.valueAt(i8);
            z0Var.getClass();
            we.h.b("NearConnectionManager", "onBleAdvertisingStarted");
            z0Var.f10075a.execute(new v0(z0Var, 1, (byte) 0));
        }
    }

    public void o() {
        b1 b1Var = (b1) this.f9720b;
        int size = b1Var.f9653a.size();
        for (int i8 = 0; i8 < size; i8++) {
            z0 z0Var = (z0) b1Var.f9653a.valueAt(i8);
            z0Var.getClass();
            we.h.b("NearConnectionManager", "onBleAdvertisingStopFailed: 0");
            z0Var.f10075a.execute(new v0(z0Var, 5, (byte) 0));
        }
    }

    @Override // zj.f
    public void onFailure(Throwable th2) {
        switch (this.f9719a) {
            case 23:
                ((zj.g) this.f9720b).completeExceptionally(th2);
                break;
            default:
                Result.Companion companion = Result.INSTANCE;
                ((li.l) this.f9720b).resumeWith(Result.m159constructorimpl(ResultKt.createFailure(th2)));
                break;
        }
    }

    public void p() {
        b1 b1Var = (b1) this.f9720b;
        int size = b1Var.f9653a.size();
        for (int i8 = 0; i8 < size; i8++) {
            z0 z0Var = (z0) b1Var.f9653a.valueAt(i8);
            z0Var.getClass();
            we.h.b("NearConnectionManager", "onBleAdvertisingStopped");
            z0Var.f10075a.execute(new v0(z0Var, 3, (byte) 0));
        }
    }

    public void q(NearDevice device, int i8) {
        Intrinsics.checkNotNullParameter(device, "device");
        b1 b1Var = (b1) this.f9720b;
        b1Var.f9654b.remove(device);
        SparseArray sparseArray = b1Var.f9653a;
        int size = sparseArray.size();
        for (int i9 = 0; i9 < size; i9++) {
            z0 z0Var = (z0) sparseArray.valueAt(i9);
            z0Var.getClass();
            Intrinsics.checkNotNullParameter(device, "device");
            z0Var.f10075a.execute(new y0(z0Var, device, i8, 1));
        }
    }

    public void r(NearDevice device, NearNetworkElement.Wifi wifi) {
        Intrinsics.checkNotNullParameter(device, "device");
        b1 b1Var = (b1) this.f9720b;
        if (!b1Var.f9654b.contains(device)) {
            b1Var.f9654b.add(device);
        }
        Iterator it = b1Var.f9654b.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((NearDevice) it.next(), device)) {
                we.h.b("NearConnectionManager", "device connected: " + device);
                SparseArray sparseArray = b1Var.f9653a;
                int size = sparseArray.size();
                for (int i8 = 0; i8 < size; i8++) {
                    z0 z0Var = (z0) sparseArray.valueAt(i8);
                    z0Var.getClass();
                    Intrinsics.checkNotNullParameter(device, "device");
                    z0Var.f10075a.execute(new a0.g(z0Var, 8, device, wifi));
                }
            }
        }
    }

    public void s(NearDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        b1 b1Var = (b1) this.f9720b;
        int size = b1Var.f9653a.size();
        for (int i8 = 0; i8 < size; i8++) {
            z0 z0Var = (z0) b1Var.f9653a.valueAt(i8);
            z0Var.getClass();
            Intrinsics.checkNotNullParameter(device, "device");
            we.h.b("NearConnectionManager", "onDeviceReject: " + device);
            z0Var.f10075a.execute(new w0(z0Var, device, 7, (byte) 0));
        }
    }

    public void t(NearDevice device, boolean z2) {
        Intrinsics.checkNotNullParameter(device, "device");
        b1 b1Var = (b1) this.f9720b;
        int size = b1Var.f9653a.size();
        for (int i8 = 0; i8 < size; i8++) {
            z0 z0Var = (z0) b1Var.f9653a.valueAt(i8);
            z0Var.getClass();
            Intrinsics.checkNotNullParameter(device, "device");
            we.h.b("NearConnectionManager", "onDeviceTrusted: " + device + ", " + z2);
            z0Var.f10075a.execute(new w0(z0Var, device, z2));
        }
    }

    public String toString() {
        switch (this.f9719a) {
            case 6:
                StringBuilder sb2 = new StringBuilder();
                String[] strArr = (String[]) this.f9720b;
                int length = strArr.length / 2;
                for (int i8 = 0; i8 < length; i8++) {
                    int i9 = i8 * 2;
                    String str = null;
                    sb2.append((i9 < 0 || i9 >= strArr.length) ? null : strArr[i9]);
                    sb2.append(": ");
                    int i10 = i9 + 1;
                    if (i10 >= 0 && i10 < strArr.length) {
                        str = strArr[i10];
                    }
                    sb2.append(str);
                    sb2.append("\n");
                }
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public void u(NearDevice device, int i8) {
        Intrinsics.checkNotNullParameter(device, "device");
        b1 b1Var = (b1) this.f9720b;
        b1Var.f9654b.remove(device);
        SparseArray sparseArray = b1Var.f9653a;
        int size = sparseArray.size();
        for (int i9 = 0; i9 < size; i9++) {
            z0 z0Var = (z0) sparseArray.valueAt(i9);
            z0Var.getClass();
            Intrinsics.checkNotNullParameter(device, "device");
            z0Var.f10075a.execute(new y0(z0Var, device, i8, 0));
        }
    }

    public void v(NearDevice device, int i8, int i9) {
        Intrinsics.checkNotNullParameter(device, "device");
        b1 b1Var = (b1) this.f9720b;
        b1Var.f9654b.remove(device);
        SparseArray sparseArray = b1Var.f9653a;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            z0 z0Var = (z0) sparseArray.valueAt(i10);
            z0Var.getClass();
            Intrinsics.checkNotNullParameter(device, "device");
            w0 w0Var = new w0(z0Var, device, i8);
            we.i iVar = z0Var.f10075a;
            iVar.execute(w0Var);
            iVar.execute(new x0(i8, z0Var, device, i9, 0));
        }
    }

    public void w(NearDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        b1 b1Var = (b1) this.f9720b;
        CollectionsKt__MutableCollectionsKt.removeAll(b1Var.f9654b, new sb.a(device, 1));
        b1Var.f9654b.add(device);
        int i8 = device.f3889j;
        if ((i8 == 15 || i8 == 16 || i8 == 17) && device.e == 1) {
            h0.a.C(device.E, "Apple onExchangeRequest iphoneRequestResult: ", "NearConnectionManager");
        }
        SparseArray sparseArray = b1Var.f9653a;
        int size = sparseArray.size();
        for (int i9 = 0; i9 < size; i9++) {
            z0 z0Var = (z0) sparseArray.valueAt(i9);
            z0Var.getClass();
            Intrinsics.checkNotNullParameter(device, "device");
            we.h.b("NearConnectionManager", "onExchangeRequest: " + device);
            z0Var.f10075a.execute(new w0(z0Var, device, 6, (byte) 0));
        }
    }

    public void x(NearDevice device, WifiP2pDevice wifiP2pDevice, TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo) {
        Object next;
        Intrinsics.checkNotNullParameter(device, "device");
        b1 b1Var = (b1) this.f9720b;
        Iterator it = b1Var.f9654b.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual((NearDevice) next, device));
        if (((NearDevice) next) == null) {
            b1Var.f9654b.add(device);
        }
        SparseArray sparseArray = b1Var.f9653a;
        int size = sparseArray.size();
        for (int i8 = 0; i8 < size; i8++) {
            z0 z0Var = (z0) sparseArray.valueAt(i8);
            z0Var.getClass();
            Intrinsics.checkNotNullParameter(device, "device");
            int i9 = device.f3890k;
            if (i9 == 11 || i9 == 10) {
                we.h.b("NearConnectionManager", "onP2pOwnerAvailable: " + device + ", " + wifiP2pDevice + ", " + tranConnectionController$P2pDeviceInfo);
                z0Var.f10075a.execute(new d6.q(3, z0Var, device, wifiP2pDevice, tranConnectionController$P2pDeviceInfo));
            }
        }
    }

    public List y(CharSequence sequence, int i8, int i9, boolean z2, Function2 stopPredicate) {
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        Intrinsics.checkNotNullParameter(stopPredicate, "stopPredicate");
        if (sequence.length() == 0) {
            throw new IllegalArgumentException("Couldn't search in char tree for empty string");
        }
        bg.a aVar = (bg.a) this.f9720b;
        while (i8 < i9) {
            char cCharAt = sequence.charAt(i8);
            if (((Boolean) stopPredicate.invoke(Character.valueOf(cCharAt), Integer.valueOf(cCharAt))).booleanValue()) {
                break;
            }
            bg.a[] aVarArr = aVar.f1309d;
            bg.a aVar2 = aVarArr[cCharAt];
            if (aVar2 == null) {
                aVar = z2 ? aVarArr[Character.toLowerCase(cCharAt)] : null;
                if (aVar == null) {
                    return CollectionsKt.emptyList();
                }
            } else {
                aVar = aVar2;
            }
            i8++;
        }
        return aVar.f1307b;
    }

    public /* synthetic */ e(y2.f fVar, ApiFeatureRequest apiFeatureRequest) {
        this.f9719a = 22;
        this.f9720b = apiFeatureRequest;
    }

    public e(bg.a root) {
        this.f9719a = 4;
        Intrinsics.checkNotNullParameter(root, "root");
        this.f9720b = root;
    }

    public e(Regex expression, LinkedHashMap indexes) {
        this.f9719a = 7;
        Intrinsics.checkNotNullParameter(expression, "expression");
        Intrinsics.checkNotNullParameter(indexes, "indexes");
        this.f9720b = expression;
    }

    public e(af.t1 t1Var) {
        this.f9719a = 6;
        ArrayList arrayList = t1Var.f594b;
        this.f9720b = (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public e(int i8) {
        this.f9719a = i8;
        switch (i8) {
            case 8:
                this.f9720b = new AtomicReference(null);
                break;
            case 9:
                this.f9720b = new tj.w(9);
                break;
            case 13:
                break;
            default:
                this.f9720b = new LinkedHashMap();
                break;
        }
    }

    public e(Context context, o4.r rVar) {
        this.f9719a = 14;
        this.f9720b = context;
    }

    public e(NearDevice device, Function1 function1) {
        this.f9719a = 0;
        Intrinsics.checkNotNullParameter(device, "device");
        this.f9720b = function1;
    }

    public e(Function0 function0) {
        this.f9719a = 21;
        this.f9720b = new WeakReference(function0);
    }
}
