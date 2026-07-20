package q2;

import android.content.Context;
import android.os.SystemClock;
import androidx.collection.ArraySet;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Set;
import r2.p;
import r2.r;
import r2.u;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u6.c f8946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f8947d;
    public final r2.a e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p2.d f8948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r2.c f8949h;

    public f(Context context, u6.c cVar, b bVar, e eVar) {
        u2.l.f(context, "Null context is not permitted.");
        u2.l.f(cVar, "Api must not be null.");
        u2.l.f(eVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f8944a = context.getApplicationContext();
        String str = null;
        try {
            str = (String) Context.class.getMethod("getAttributionTag", null).invoke(context, null);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        this.f8945b = str;
        this.f8946c = cVar;
        this.f8947d = bVar;
        this.e = new r2.a(cVar, bVar, str);
        r2.c cVarE = r2.c.e(this.f8944a);
        this.f8949h = cVarE;
        this.f = cVarE.f9329j.getAndIncrement();
        this.f8948g = eVar.f8943a;
        h3.e eVar2 = cVarE.f9334o;
        eVar2.sendMessage(eVar2.obtainMessage(7, this));
    }

    public final u6.a a() {
        u6.a aVar = new u6.a(13, false);
        Set setEmptySet = Collections.emptySet();
        if (((ArraySet) aVar.f10378b) == null) {
            aVar.f10378b = new ArraySet();
        }
        ((ArraySet) aVar.f10378b).addAll(setEmptySet);
        Context context = this.f8944a;
        aVar.f10379c = context.getClass().getName();
        aVar.f10380d = context.getPackageName();
        return aVar;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    /* JADX WARN: Code duplicated, block: B:29:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    public final q3.k b(int i8, r2.i iVar) {
        long jCurrentTimeMillis;
        q3.g gVar = new q3.g();
        r2.c cVar = this.f8949h;
        cVar.getClass();
        int i9 = iVar.f9337c;
        if (i9 != 0) {
            r2.a aVar = this.e;
            p pVar = null;
            if (cVar.a()) {
                RootTelemetryConfiguration rootTelemetryConfiguration = (RootTelemetryConfiguration) u2.e.b().f10334a;
                boolean z2 = true;
                if (rootTelemetryConfiguration == null) {
                    if (z2) {
                        jCurrentTimeMillis = System.currentTimeMillis();
                    } else {
                        jCurrentTimeMillis = 0;
                    }
                    pVar = new p(cVar, i9, aVar, jCurrentTimeMillis, z2 ? SystemClock.elapsedRealtime() : 0L);
                } else if (rootTelemetryConfiguration.f1870b) {
                    r2.l lVar = (r2.l) cVar.f9331l.get(aVar);
                    if (lVar != null) {
                        c cVar2 = lVar.f9341c;
                        if (cVar2 instanceof com.google.android.gms.common.internal.a) {
                            com.google.android.gms.common.internal.a aVar2 = (com.google.android.gms.common.internal.a) cVar2;
                            if (aVar2.f1892w == null || aVar2.a()) {
                                z2 = rootTelemetryConfiguration.f1871c;
                            } else {
                                ConnectionTelemetryConfiguration connectionTelemetryConfigurationB = p.b(lVar, aVar2, i9);
                                if (connectionTelemetryConfigurationB != null) {
                                    lVar.f9349m++;
                                    z2 = connectionTelemetryConfigurationB.f1845c;
                                }
                            }
                            if (z2) {
                                jCurrentTimeMillis = System.currentTimeMillis();
                            } else {
                                jCurrentTimeMillis = 0;
                            }
                            if (z2) {
                            }
                            pVar = new p(cVar, i9, aVar, jCurrentTimeMillis, z2 ? SystemClock.elapsedRealtime() : 0L);
                        }
                    } else {
                        z2 = rootTelemetryConfiguration.f1871c;
                        if (z2) {
                            jCurrentTimeMillis = System.currentTimeMillis();
                        } else {
                            jCurrentTimeMillis = 0;
                        }
                        if (z2) {
                        }
                        pVar = new p(cVar, i9, aVar, jCurrentTimeMillis, z2 ? SystemClock.elapsedRealtime() : 0L);
                    }
                }
            }
            if (pVar != null) {
                q3.k kVar = gVar.f8950a;
                h3.e eVar = cVar.f9334o;
                eVar.getClass();
                d2.h hVar = new d2.h(eVar, 2);
                kVar.getClass();
                kVar.f8958b.k(new q3.i(hVar, pVar));
                kVar.j();
            }
        }
        u uVar = new u(i8, iVar, gVar, this.f8948g);
        h3.e eVar2 = cVar.f9334o;
        eVar2.sendMessage(eVar2.obtainMessage(4, new r(uVar, cVar.f9330k.get(), this)));
        return gVar.f8950a;
    }
}
