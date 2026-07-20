package v5;

import af.i;
import af.r4;
import af.r5;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.SystemClock;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.TelemetryData;
import df.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import k3.ae;
import k3.b0;
import k3.be;
import k3.g1;
import k3.ja;
import k3.ka;
import k3.la;
import k3.u9;
import k3.ua;
import k3.v9;
import k3.va;
import k3.wa;
import k3.z9;
import q3.k;
import tj.w;
import u2.l;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f10512j = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r5.a f10516d;
    public final g e;
    public final be f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u6.c f10517g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10519i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f10514b = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f10515c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o6.a f10513a = new o6.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x5.a f10518h = new x5.a();

    public f(p5.f fVar, r5.a aVar, g gVar, be beVar) {
        l.f(fVar, "MlKitContext can not be null");
        this.f10516d = aVar;
        this.e = gVar;
        this.f = beVar;
        this.f10517g = new u6.c(fVar.b(), 3);
    }

    public final k a(final Executor executor, Callable callable, final o5.c cVar) {
        if (this.f10514b.get() <= 0) {
            throw new IllegalStateException();
        }
        if (((k) cVar.f8405a).c()) {
            k kVar = new k();
            kVar.h();
            return kVar;
        }
        final w wVar = new w(14);
        final q3.g gVar = new q3.g((o5.c) wVar.f10262b);
        Executor executor2 = new Executor() { // from class: p5.o
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                try {
                    executor.execute(runnable);
                } catch (RuntimeException e) {
                    if (((q3.k) cVar.f8405a).c()) {
                        wVar.o();
                    } else {
                        gVar.f8950a.f(e);
                    }
                    throw e;
                }
            }
        };
        this.f10513a.j(new r4(this, cVar, wVar, callable, gVar, 1), executor2);
        return gVar.f8950a;
    }

    public final List b(w5.a aVar) {
        ArrayList arrayListE;
        synchronized (this) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.f10518h.a(aVar);
            try {
                arrayListE = this.e.e(aVar);
                c(ka.NO_ERROR, jElapsedRealtime, aVar, arrayListE);
                f10512j = false;
            } catch (l5.a e) {
                c(e.getErrorCode() == 14 ? ka.MODEL_NOT_DOWNLOADED : ka.UNKNOWN_ERROR, jElapsedRealtime, aVar, null);
                throw e;
            }
        }
        return arrayListE;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0038  */
    /* JADX WARN: Code duplicated, block: B:18:0x004d  */
    /* JADX WARN: Code duplicated, block: B:45:0x004f A[SYNTHETIC] */
    public final void c(final ka kaVar, long j8, final w5.a aVar, List list) {
        ua uaVar;
        va vaVar;
        final b0 b0Var = new b0();
        final b0 b0Var2 = new b0();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                t5.a aVar2 = (t5.a) it.next();
                int format = aVar2.f10166a.getFormat();
                int i8 = -1;
                if (format <= 4096) {
                    if (format != 0) {
                    }
                    uaVar = (ua) a.f10497a.get(i8);
                    if (uaVar == null) {
                        uaVar = ua.FORMAT_UNKNOWN;
                    }
                    b0Var.a(uaVar);
                    vaVar = (va) a.f10498b.get(aVar2.f10166a.i());
                    if (vaVar == null) {
                        vaVar = va.TYPE_UNKNOWN;
                    }
                    b0Var2.a(vaVar);
                } else {
                    format = -1;
                }
                i8 = format;
                uaVar = (ua) a.f10497a.get(i8);
                if (uaVar == null) {
                    uaVar = ua.FORMAT_UNKNOWN;
                }
                b0Var.a(uaVar);
                vaVar = (va) a.f10498b.get(aVar2.f10166a.i());
                if (vaVar == null) {
                    vaVar = va.TYPE_UNKNOWN;
                }
                b0Var2.a(vaVar);
            }
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime() - j8;
        this.f.b(new ae() { // from class: v5.e
            @Override // k3.ae
            public final m zza() {
                int iLimit;
                u9 u9Var;
                f fVar = this.f10507a;
                long j10 = jElapsedRealtime;
                ka kaVar2 = kaVar;
                b0 b0Var3 = b0Var;
                b0 b0Var4 = b0Var2;
                w5.a aVar3 = aVar;
                fVar.getClass();
                r5 r5Var = new r5(6, false);
                r5 r5Var2 = new r5(5, false);
                r5Var2.f557b = Long.valueOf(j10 & Long.MAX_VALUE);
                r5Var2.f558c = kaVar2;
                r5Var2.f559d = Boolean.valueOf(f.f10512j);
                Boolean bool = Boolean.TRUE;
                r5Var2.e = bool;
                r5Var2.f560h = bool;
                r5Var.f557b = new z9(r5Var2);
                r5Var.f558c = a.a(fVar.f10516d);
                r5Var.f559d = b0Var3.c();
                r5Var.e = b0Var4.c();
                int i9 = aVar3.f;
                if (i9 == -1) {
                    Bitmap bitmap = aVar3.f10661a;
                    l.e(bitmap);
                    iLimit = bitmap.getAllocationByteCount();
                } else {
                    if (i9 == 17 || i9 == 842094169) {
                        l.e(null);
                        throw null;
                    }
                    if (i9 != 35) {
                        iLimit = 0;
                    } else {
                        Image.Plane[] planeArrA = aVar3.a();
                        l.e(planeArrA);
                        iLimit = (planeArrA[0].getBuffer().limit() * 3) / 2;
                    }
                }
                tc.d dVar = new tc.d();
                if (i9 == -1) {
                    u9Var = u9.BITMAP;
                } else if (i9 == 35) {
                    u9Var = u9.YUV_420_888;
                } else if (i9 == 842094169) {
                    u9Var = u9.YV12;
                } else if (i9 != 16) {
                    u9Var = i9 != 17 ? u9.UNKNOWN_FORMAT : u9.NV21;
                } else {
                    u9Var = u9.NV16;
                }
                dVar.f10209a = u9Var;
                dVar.f10210b = Integer.valueOf(iLimit & Integer.MAX_VALUE);
                r5Var.f560h = new v9(dVar);
                d2.a aVar4 = new d2.a();
                aVar4.f4259c = fVar.f10519i ? ja.TYPE_THICK : ja.TYPE_THIN;
                aVar4.f4260d = new wa(r5Var);
                return new m(aVar4, 0);
            }
        }, la.ON_DEVICE_BARCODE_DETECT);
        r5 r5Var = new r5(4, false);
        r5Var.f557b = kaVar;
        r5Var.f558c = Boolean.valueOf(f10512j);
        r5Var.f559d = a.a(this.f10516d);
        r5Var.e = b0Var.c();
        r5Var.f560h = b0Var2.c();
        final g1 g1Var = new g1(r5Var);
        final se.e eVar = new se.e(this, 20);
        final be beVar = this.f;
        final la laVar = la.AGGREGATED_ON_DEVICE_BARCODE_DETECTION;
        p5.l.INSTANCE.execute(new Runnable() { // from class: k3.zd
            @Override // java.lang.Runnable
            public final void run() {
                be beVar2 = beVar;
                HashMap map = beVar2.f6389j;
                la laVar2 = laVar;
                if (!map.containsKey(laVar2)) {
                    map.put(laVar2, s.zzz());
                }
                ((g) map.get(laVar2)).zzt(g1Var, Long.valueOf(jElapsedRealtime));
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                if (beVar2.d(laVar2, jElapsedRealtime2)) {
                    beVar2.f6388i.put(laVar2, Long.valueOf(jElapsedRealtime2));
                    p5.l.INSTANCE.execute(new af.m0(beVar2, laVar2, eVar, 8, false));
                }
            }
        });
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = this.f10519i;
        long j10 = jCurrentTimeMillis - jElapsedRealtime;
        u6.c cVar = this.f10517g;
        int i9 = true != z2 ? 24301 : 24302;
        int iZza = kaVar.zza();
        synchronized (cVar) {
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            if (((AtomicLong) cVar.f10387b).get() != -1 && jElapsedRealtime2 - ((AtomicLong) cVar.f10387b).get() <= TimeUnit.MINUTES.toMillis(30L)) {
                return;
            }
            k kVarC = ((w2.b) cVar.f10388c).c(new TelemetryData(0, Arrays.asList(new MethodInvocation(i9, iZza, 0, j10, jCurrentTimeMillis, null, null, 0, -1))));
            i iVar = new i(cVar, jElapsedRealtime2);
            kVarC.getClass();
            kVarC.e(q3.h.f8951a, iVar);
        }
    }
}
