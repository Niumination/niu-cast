package v5;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvj;
import com.google.android.gms.internal.mlkit_vision_barcode.zzvl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import k3.be;
import k3.e0;
import k3.ge;
import k3.he;
import k3.ie;
import k3.je;
import k3.ka;
import k3.mc;
import k3.t;
import m3.s;
import p5.p;
import q3.k;
import tj.w;
import u2.l;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final e0 f10520h = e0.zzh("com.google.android.gms.vision.barcode", "com.google.android.gms.tflite_dynamite");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f10524d;
    public final r5.a e;
    public final be f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ge f10525g;

    public h(Context context, r5.a aVar, be beVar) {
        this.f10524d = context;
        this.e = aVar;
        this.f = beVar;
    }

    public final ge a(g3.d dVar, String str, String str2) {
        IInterface heVar;
        Context context = this.f10524d;
        IBinder iBinderB = g3.e.c(context, dVar, str).b(str2);
        int i8 = ie.f6497c;
        ge geVar = null;
        if (iBinderB == null) {
            heVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator");
            heVar = iInterfaceQueryLocalInterface instanceof je ? (je) iInterfaceQueryLocalInterface : new he(iBinderB, "com.google.mlkit.vision.barcode.aidls.IBarcodeScannerCreator", 2);
        }
        f3.b bVar = new f3.b(context);
        zzvl zzvlVar = new zzvl(this.e.f9381a, false);
        he heVar2 = (he) heVar;
        Parcel parcelI = heVar2.i();
        t.a(parcelI, bVar);
        parcelI.writeInt(1);
        zzvlVar.writeToParcel(parcelI, 0);
        Parcel parcelJ = heVar2.j(parcelI, 1);
        IBinder strongBinder = parcelJ.readStrongBinder();
        if (strongBinder != null) {
            IInterface iInterfaceQueryLocalInterface2 = strongBinder.queryLocalInterface("com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
            geVar = iInterfaceQueryLocalInterface2 instanceof ge ? (ge) iInterfaceQueryLocalInterface2 : new ge(strongBinder, "com.google.mlkit.vision.barcode.aidls.IBarcodeScanner", 2);
        }
        parcelJ.recycle();
        return geVar;
    }

    @Override // v5.g
    public final boolean c() throws l5.a {
        boolean z2 = false;
        if (this.f10525g != null) {
            return this.f10522b;
        }
        Context context = this.f10524d;
        boolean z3 = g3.e.a(context, ModuleDescriptor.MODULE_ID) > 0;
        be beVar = this.f;
        if (z3) {
            this.f10522b = true;
            try {
                this.f10525g = a(g3.e.f5098c, ModuleDescriptor.MODULE_ID, "com.google.mlkit.vision.barcode.bundled.internal.ThickBarcodeScannerCreator");
            } catch (RemoteException e) {
                throw new l5.a("Failed to create thick barcode scanner.", 13, e);
            } catch (g3.a e4) {
                throw new l5.a("Failed to load the bundled barcode module.", 13, e4);
            }
        } else {
            this.f10522b = false;
            Feature[] featureArr = p5.h.f8680a;
            p2.b.f8650b.getClass();
            int iA = p2.b.a(context);
            e0 e0Var = f10520h;
            if (iA >= 221500000) {
                try {
                    k kVarC = new y2.f(context, y2.f.f11029i, q2.b.f8941g, q2.e.f8942b).c(new p(p5.h.b(p5.h.f8683d, e0Var), 0));
                    p5.b bVar = p5.b.f8666b;
                    kVarC.getClass();
                    kVarC.e(q3.h.f8951a, bVar);
                    z2 = ((ModuleAvailabilityResponse) mc.a(kVarC)).f1912a;
                } catch (InterruptedException | ExecutionException e10) {
                    Log.e("OptionalModuleUtils", "Failed to complete the task of features availability check", e10);
                }
            } else {
                try {
                    Iterator it = e0Var.iterator();
                    while (it.hasNext()) {
                        g3.e.c(context, g3.e.f5097b, (String) it.next());
                    }
                    z2 = true;
                } catch (g3.a unused) {
                }
            }
            if (!z2) {
                if (!this.f10523c) {
                    p5.h.a(context, e0.zzh("barcode", "tflite_dynamite"));
                    this.f10523c = true;
                }
                a.b(beVar, ka.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new l5.a("Waiting for the barcode module to be downloaded. Please wait.", 14);
            }
            try {
                this.f10525g = a(g3.e.f5097b, "com.google.android.gms.vision.barcode", "com.google.android.gms.vision.barcode.mlkit.BarcodeScannerCreator");
            } catch (RemoteException | g3.a e11) {
                a.b(beVar, ka.OPTIONAL_MODULE_INIT_ERROR);
                throw new l5.a("Failed to create thin barcode scanner.", 13, e11);
            }
        }
        a.b(beVar, ka.NO_ERROR);
        return this.f10522b;
    }

    @Override // v5.g
    public final ArrayList e(w5.a aVar) throws l5.a {
        f3.b bVar;
        if (this.f10525g == null) {
            c();
        }
        ge geVar = this.f10525g;
        l.e(geVar);
        if (!this.f10521a) {
            try {
                geVar.k(geVar.i(), 1);
                this.f10521a = true;
            } catch (RemoteException e) {
                throw new l5.a("Failed to init barcode scanner.", 13, e);
            }
        }
        int rowStride = aVar.f10663c;
        if (aVar.f == 35) {
            Image.Plane[] planeArrA = aVar.a();
            l.e(planeArrA);
            rowStride = planeArrA[0].getRowStride();
        }
        zzwc zzwcVar = new zzwc(aVar.f, rowStride, aVar.f10664d, s.a(aVar.e), SystemClock.elapsedRealtime());
        int i8 = aVar.f;
        if (i8 != -1) {
            if (i8 != 17) {
                if (i8 == 35) {
                    bVar = new f3.b(aVar.f10662b != null ? (Image) aVar.f10662b.f8405a : null);
                } else if (i8 != 842094169) {
                    throw new l5.a(a1.a.o(aVar.f, "Unsupported image format: "), 3);
                }
            }
            l.e(null);
            throw null;
        }
        Bitmap bitmap = aVar.f10661a;
        l.e(bitmap);
        bVar = new f3.b(bitmap);
        try {
            Parcel parcelI = geVar.i();
            t.a(parcelI, bVar);
            parcelI.writeInt(1);
            zzwcVar.writeToParcel(parcelI, 0);
            Parcel parcelJ = geVar.j(parcelI, 3);
            ArrayList arrayListCreateTypedArrayList = parcelJ.createTypedArrayList(zzvj.CREATOR);
            parcelJ.recycle();
            ArrayList arrayList = new ArrayList();
            Iterator it = arrayListCreateTypedArrayList.iterator();
            while (it.hasNext()) {
                arrayList.add(new t5.a(new w((zzvj) it.next(), 19), aVar.f10665g));
            }
            return arrayList;
        } catch (RemoteException e4) {
            throw new l5.a("Failed to run barcode scanner.", 13, e4);
        }
    }

    @Override // v5.g
    public final void f() {
        ge geVar = this.f10525g;
        if (geVar != null) {
            try {
                geVar.k(geVar.i(), 2);
            } catch (RemoteException e) {
                Log.e("DecoupledBarcodeScanner", "Failed to release barcode scanner.", e);
            }
            this.f10525g = null;
            this.f10521a = false;
        }
    }
}
