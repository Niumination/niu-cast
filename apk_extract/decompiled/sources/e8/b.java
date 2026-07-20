package e8;

import af.h6;
import af.i1;
import af.m0;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import bb.t;
import cf.n;
import com.google.android.gms.common.Feature;
import com.google.android.gms.internal.mlkit_vision_barcode.zzah;
import com.google.android.gms.internal.mlkit_vision_barcode.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode.zzu;
import com.transsion.athena.aidl.AthenaTrackService;
import com.transsion.athena.data.TrackData;
import com.transsion.athena.data.TrackDataWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k3.be;
import k3.ka;
import k3.v8;
import m3.s;
import p5.h;
import tj.x;
import u2.l;
import ze.o;
import ze.p1;
import ze.q1;
import ze.r1;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements i1, v5.g {
    public static volatile b f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile int f4710g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile long f4711h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Context f4712i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static f f4713j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f4716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f4717d;
    public Object e;

    public static boolean j() {
        return f4712i.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") == 0;
    }

    public static void l(boolean z2) {
        c6.a aVarK;
        String str = s6.d.f9538a;
        z6.a.e("setEnable isEnable = " + z2);
        s6.d.f9553t = z2;
        if (f == null) {
            z6.a.a("Init method not called.");
        } else {
            if (f4710g != 0 || (aVarK = f.k()) == null || z2) {
                return;
            }
            aVarK.e();
        }
    }

    public static boolean m() {
        return (f4712i == null || f == null || !s6.d.f9553t) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ff  */
    /* JADX WARN: Instruction removed from duplicated block: B:40:0x00ff, please report this as an issue */
    public static b n(long j8) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (f == null) {
            synchronized (b.class) {
                try {
                    if (f == null) {
                        b bVar = new b();
                        bVar.f4716c = null;
                        bVar.e = new CopyOnWriteArrayList();
                        f = bVar;
                        if (f4710g == 0) {
                            c6.a aVarK = f.k();
                            Handler handler = new Handler(Looper.getMainLooper());
                            aVarK.c(new a4.c(aVarK, 14));
                            af.f fVar = new af.f();
                            fVar.f253b = aVarK;
                            aVarK.a(3000L, fVar);
                            aVarK.a(6000L, new t(3));
                            handler.postDelayed(new t(2), 6000L);
                            handler.postDelayed(new m0(handler), 3600000L);
                            aVarK.c(new t(4));
                        } else {
                            b bVar2 = f;
                            Context context = f4712i;
                            bVar2.getClass();
                            try {
                                z6.a.e("AthenaAnalytics bindTrackService");
                                Intent intent = new Intent(context, (Class<?>) AthenaTrackService.class);
                                intent.setPackage(context.getApplicationInfo().packageName);
                                context.bindService(intent, new c(bVar2), 1);
                            } catch (Exception e) {
                                z6.a.c(Log.getStackTraceString(e));
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        String str = z6.b.f11259a;
        if (j8 > 999 && j8 <= 9999) {
            int i8 = (int) j8;
            if (f4710g == 0) {
                CopyOnWriteArrayList copyOnWriteArrayList2 = t6.d.f10185b;
                if (!copyOnWriteArrayList2.contains(Integer.valueOf(i8)) ? copyOnWriteArrayList2.add(Integer.valueOf(i8)) : false) {
                    Message message = new Message();
                    message.what = 400;
                    message.arg1 = i8;
                    f.k().b(message, 0L);
                } else if (f4710g == 1) {
                    copyOnWriteArrayList = t6.d.f10185b;
                    if (copyOnWriteArrayList.contains(Integer.valueOf(i8)) ? false : copyOnWriteArrayList.add(Integer.valueOf(i8))) {
                        z6.a.a("multi process appid " + i8 + " register successful");
                    }
                }
            } else if (f4710g == 1) {
                copyOnWriteArrayList = t6.d.f10185b;
                if (copyOnWriteArrayList.contains(Integer.valueOf(i8)) ? false : copyOnWriteArrayList.add(Integer.valueOf(i8))) {
                    z6.a.a("multi process appid " + i8 + " register successful");
                }
            }
        }
        return f;
    }

    @Override // af.i1
    public i1 a(o oVar) {
        return this;
    }

    @Override // af.i1
    public void b(int i8) {
    }

    @Override // v5.g
    public boolean c() throws l5.a {
        k3.e cVar;
        Context context = (Context) this.f4715b;
        if (((k3.b) this.e) != null) {
            return false;
        }
        try {
            IBinder iBinderB = g3.e.c(context, g3.e.f5097b, "com.google.android.gms.vision.dynamite").b("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator");
            int i8 = k3.d.f6401c;
            if (iBinderB == null) {
                cVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
                cVar = iInterfaceQueryLocalInterface instanceof k3.e ? (k3.e) iInterfaceQueryLocalInterface : new k3.c(iBinderB, "com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator", 2);
            }
            k3.b bVarL = ((k3.c) cVar).l(new f3.b(context), (zzah) this.f4716c);
            this.e = bVarL;
            be beVar = (be) this.f4717d;
            if (bVarL == null && !this.f4714a) {
                Log.d("LegacyBarcodeScanner", "Request optional module download.");
                Feature[] featureArr = h.f8680a;
                h.a(context, j3.d.zzh("barcode"));
                this.f4714a = true;
                v5.a.b(beVar, ka.OPTIONAL_MODULE_NOT_AVAILABLE);
                throw new l5.a("Waiting for the barcode module to be downloaded. Please wait.", 14);
            }
            v5.a.b(beVar, ka.NO_ERROR);
            return false;
        } catch (RemoteException e) {
            throw new l5.a("Failed to create legacy barcode detector.", 13, e);
        } catch (g3.a e4) {
            throw new l5.a("Failed to load deprecated vision dynamite module.", 13, e4);
        }
    }

    @Override // af.i1
    public void close() {
        this.f4714a = true;
        v8.n(((byte[]) this.f4717d) != null, "Lack of request message. GET request is only supported for unary requests");
        ((n) ((af.c) this.e)).f1601o.A((p1) this.f4715b, (byte[]) this.f4717d);
        this.f4717d = null;
        this.f4715b = null;
    }

    @Override // af.i1
    public void d(gf.a aVar) {
        v8.n(((byte[]) this.f4717d) == null, "writePayload should not be called multiple times");
        try {
            this.f4717d = j4.g.b(aVar);
            h6 h6Var = (h6) this.f4716c;
            for (ze.n nVar : h6Var.f312a) {
                nVar.i(0);
            }
            byte[] bArr = (byte[]) this.f4717d;
            long length = bArr.length;
            long length2 = bArr.length;
            for (ze.n nVar2 : h6Var.f312a) {
                nVar2.j(0, length, length2);
            }
            long length3 = ((byte[]) this.f4717d).length;
            ze.n[] nVarArr = h6Var.f312a;
            for (ze.n nVar3 : nVarArr) {
                nVar3.k(length3);
            }
            long length4 = ((byte[]) this.f4717d).length;
            for (ze.n nVar4 : nVarArr) {
                nVar4.l(length4);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // v5.g
    public ArrayList e(w5.a aVar) throws l5.a {
        zzu[] zzuVarArrL;
        if (((k3.b) this.e) == null) {
            c();
        }
        k3.b bVar = (k3.b) this.e;
        if (bVar == null) {
            throw new l5.a("Error initializing the legacy barcode scanner.", 14);
        }
        zzan zzanVar = new zzan(aVar.f10663c, aVar.f10664d, 0, s.a(aVar.e), 0L);
        try {
            int i8 = aVar.f;
            if (i8 == -1) {
                f3.b bVar2 = new f3.b(aVar.f10661a);
                Parcel parcelI = bVar.i();
                k3.t.a(parcelI, bVar2);
                parcelI.writeInt(1);
                zzanVar.writeToParcel(parcelI, 0);
                Parcel parcelJ = bVar.j(parcelI, 2);
                zzu[] zzuVarArr = (zzu[]) parcelJ.createTypedArray(zzu.CREATOR);
                parcelJ.recycle();
                zzuVarArrL = zzuVarArr;
            } else if (i8 == 17) {
                zzuVarArrL = bVar.l(new f3.b(null), zzanVar);
            } else if (i8 == 35) {
                Image.Plane[] planeArrA = aVar.a();
                l.e(planeArrA);
                zzanVar.f1988a = planeArrA[0].getRowStride();
                zzuVarArrL = bVar.l(new f3.b(planeArrA[0].getBuffer()), zzanVar);
            } else {
                if (i8 != 842094169) {
                    throw new l5.a("Unsupported image format: " + aVar.f, 3);
                }
                zzuVarArrL = bVar.l(new f3.b(m3.t.a(aVar)), zzanVar);
            }
            ArrayList arrayList = new ArrayList();
            for (zzu zzuVar : zzuVarArrL) {
                arrayList.add(new t5.a(new x(zzuVar), aVar.f10665g));
            }
            return arrayList;
        } catch (RemoteException e) {
            throw new l5.a("Failed to detect with legacy barcode detector", 13, e);
        }
    }

    @Override // v5.g
    public void f() {
        k3.b bVar = (k3.b) this.e;
        if (bVar != null) {
            try {
                bVar.k(bVar.i(), 3);
            } catch (RemoteException e) {
                Log.e("LegacyBarcodeScanner", "Failed to release legacy barcode detector.", e);
            }
            this.e = null;
        }
    }

    @Override // af.i1
    public void flush() {
    }

    public void g(String str, TrackData trackData, long j8) {
        if (f4710g == 0) {
            k().d(str, trackData, j8);
            return;
        }
        if (f4712i != null) {
            String str2 = s6.d.f9538a;
            try {
                if (!TextUtils.isEmpty("")) {
                    trackData.f2318a.put("scode", "");
                }
                if (((ExecutorService) this.f4716c) == null) {
                    this.f4716c = Executors.newSingleThreadExecutor();
                }
                i(str, trackData, j8);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public r1 h() {
        return new r1((q1) this.f4717d, (String) this.e, (gf.b) this.f4715b, (gf.b) this.f4716c, this.f4714a);
    }

    public void i(String str, TrackData trackData, long j8) {
        try {
            if (((k6.b) this.f4717d) == null || !this.f4714a) {
                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.e;
                if (copyOnWriteArrayList.size() < 100) {
                    TrackDataWrapper trackDataWrapper = new TrackDataWrapper();
                    trackDataWrapper.f2321a = str;
                    trackDataWrapper.f2322b = trackData;
                    trackDataWrapper.f2323c = j8;
                    copyOnWriteArrayList.add(trackDataWrapper);
                }
            } else if (trackData.h() < 524288) {
                ((ExecutorService) this.f4716c).submit(new a(this, str, trackData, j8, 0));
            } else {
                z6.a.c("TrackByAidl trackData size is too large, ignored !!");
            }
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
    }

    @Override // af.i1
    public boolean isClosed() {
        return this.f4714a;
    }

    public c6.a k() {
        Context context;
        if (((c6.a) this.f4715b) == null && (context = f4712i) != null) {
            if (x6.c.f10871s == null) {
                synchronized (x6.c.class) {
                    try {
                        if (x6.c.f10871s == null) {
                            x6.c.f10871s = new x6.c(context);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            this.f4715b = x6.c.f10871s;
        }
        return (c6.a) this.f4715b;
    }

    public void o(String str, TrackData trackData, long j8) {
        String str2 = z6.b.f11259a;
        int length = String.valueOf(j8).length();
        if ((length != 8 && length != 12 && length != 4) || TextUtils.isEmpty(str)) {
            z6.a.a("The parameter tid : " + j8 + " or event name : " + str + " is illegal.");
            return;
        }
        if (!t6.d.f10185b.contains(Integer.valueOf(z6.b.a(j8)))) {
            z6.a.a("The tid " + j8 + " is not belong the app");
            return;
        }
        try {
            if (trackData != null) {
                g(str, trackData, j8);
            } else {
                g(str, new TrackData(), j8);
            }
        } catch (Exception e) {
            z6.a.c(Log.getStackTraceString(e));
        }
    }
}
