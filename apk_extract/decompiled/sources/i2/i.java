package i2;

import android.content.Context;
import android.util.Log;
import c2.k;
import c2.l;
import c2.m;
import c2.o;
import c2.q;
import c2.u;
import c2.v;
import c2.x;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import k3.d2;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e2.f f5550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j2.c f5551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f5552d;
    public final Executor e;
    public final k2.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l2.a f5553g;

    public i(Context context, e2.f fVar, j2.c cVar, d dVar, Executor executor, k2.c cVar2, l2.a aVar) {
        this.f5549a = context;
        this.f5550b = fVar;
        this.f5551c = cVar;
        this.f5552d = dVar;
        this.e = executor;
        this.f = cVar2;
        this.f5553g = aVar;
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [byte[], java.io.Serializable] */
    public final void a(d2.d dVar, int i8) {
        e2.a aVar;
        String str;
        b2.c cVarC;
        String str2;
        Integer numValueOf;
        k kVar;
        e2.g gVarA = this.f5550b.a(dVar.f4269a);
        u6.c cVar = new u6.c(this, dVar);
        j2.h hVar = (j2.h) this.f;
        Iterable iterable = (Iterable) hVar.h(cVar);
        if (iterable.iterator().hasNext()) {
            if (gVarA == null) {
                d2.a(dVar, "Uploader", "Unknown backend for %s, deleting event batch for it...");
                aVar = new e2.a(e2.c.FATAL_ERROR, -1L);
            } else {
                ArrayList<d2.b> arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((j2.b) it.next()).f6041c);
                }
                b2.d dVar2 = (b2.d) gVarA;
                HashMap map = new HashMap();
                for (d2.b bVar : arrayList) {
                    String str3 = bVar.f4262a;
                    if (map.containsKey(str3)) {
                        ((List) map.get(str3)).add(bVar);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(bVar);
                        map.put(str3, arrayList2);
                    }
                }
                ArrayList arrayList3 = new ArrayList();
                Iterator it2 = map.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    d2.b bVar2 = (d2.b) ((List) entry.getValue()).get(0);
                    x xVar = x.DEFAULT;
                    long jA = dVar2.f.a();
                    long jA2 = dVar2.e.a();
                    c2.j jVar = new c2.j(q.ANDROID_FIREBASE, new c2.h(Integer.valueOf(bVar2.b("sdk-version")), bVar2.a("model"), bVar2.a("hardware"), bVar2.a("device"), bVar2.a("product"), bVar2.a("os-uild"), bVar2.a("manufacturer"), bVar2.a("fingerprint"), bVar2.a("locale"), bVar2.a("country"), bVar2.a("mcc_mnc"), bVar2.a("application_build")));
                    try {
                        numValueOf = Integer.valueOf(Integer.parseInt((String) entry.getKey()));
                        str2 = null;
                    } catch (NumberFormatException unused) {
                        str2 = (String) entry.getKey();
                        numValueOf = null;
                    }
                    ArrayList arrayList4 = new ArrayList();
                    for (d2.b bVar3 : (List) entry.getValue()) {
                        d2.f fVar = bVar3.f4264c;
                        a2.b bVar4 = fVar.f4276a;
                        Iterator it3 = it2;
                        boolean zEquals = bVar4.equals(new a2.b("proto"));
                        ?? r7 = fVar.f4277b;
                        if (zEquals) {
                            kVar = new k();
                            kVar.e = r7;
                        } else {
                            if (bVar4.equals(new a2.b("json"))) {
                                String str4 = new String((byte[]) r7, Charset.forName("UTF-8"));
                                k kVar2 = new k();
                                kVar2.f = str4;
                                kVar = kVar2;
                            } else {
                                Log.w("TransportRuntime.".concat("CctTransportBackend"), "Received event of unsupported encoding " + bVar4 + ". Skipping...");
                            }
                            it2 = it3;
                        }
                        kVar.f1407a = Long.valueOf(bVar3.f4265d);
                        kVar.f1409c = Long.valueOf(bVar3.e);
                        String str5 = (String) bVar3.f.get("tz-offset");
                        kVar.f1410d = Long.valueOf(str5 == null ? 0L : Long.valueOf(str5).longValue());
                        kVar.f1411g = new o(v.forNumber(bVar3.b("net-type")), u.forNumber(bVar3.b("mobile-subtype")));
                        Integer num = bVar3.f4263b;
                        if (num != null) {
                            kVar.f1408b = num;
                        }
                        String strB = ((Long) kVar.f1407a) == null ? " eventTimeMs" : "";
                        if (((Long) kVar.f1409c) == null) {
                            strB = strB.concat(" eventUptimeMs");
                        }
                        if (((Long) kVar.f1410d) == null) {
                            strB = h0.a.B(strB, " timezoneOffsetSeconds");
                        }
                        if (!strB.isEmpty()) {
                            throw new IllegalStateException("Missing required properties:".concat(strB));
                        }
                        arrayList4.add(new l(((Long) kVar.f1407a).longValue(), kVar.f1408b, ((Long) kVar.f1409c).longValue(), (byte[]) kVar.e, (String) kVar.f, ((Long) kVar.f1410d).longValue(), (o) kVar.f1411g));
                        it2 = it3;
                    }
                    arrayList3.add(new m(jA, jA2, jVar, numValueOf, str2, arrayList4, xVar));
                    it2 = it2;
                }
                c2.i iVar = new c2.i(arrayList3);
                byte[] bArr = dVar.f4270b;
                URL urlB = dVar2.f1192d;
                if (bArr != null) {
                    try {
                        b2.a aVarA = b2.a.a(bArr);
                        str = aVarA.f1182b;
                        if (str == null) {
                            str = null;
                        }
                        String str6 = aVarA.f1181a;
                        if (str6 != null) {
                            urlB = b2.d.b(str6);
                        }
                    } catch (IllegalArgumentException unused2) {
                        aVar = new e2.a(e2.c.FATAL_ERROR, -1L);
                    }
                } else {
                    str = null;
                }
                try {
                    b2.b bVar5 = new b2.b(urlB, iVar, str);
                    o5.c cVar2 = new o5.c(dVar2);
                    int i9 = 5;
                    do {
                        cVarC = cVar2.c(bVar5);
                        URL url = cVarC.f1187b;
                        if (url != null) {
                            d2.a(url, "CctTransportBackend", "Following redirect to: %s");
                            bVar5 = new b2.b(url, bVar5.f1184b, bVar5.f1185c);
                        } else {
                            bVar5 = null;
                        }
                        if (bVar5 == null) {
                            break;
                        } else {
                            i9--;
                        }
                    } while (i9 >= 1);
                    int i10 = cVarC.f1186a;
                    aVar = i10 == 200 ? new e2.a(e2.c.OK, cVarC.f1188c) : (i10 >= 500 || i10 == 404) ? new e2.a(e2.c.TRANSIENT_ERROR, -1L) : new e2.a(e2.c.FATAL_ERROR, -1L);
                } catch (IOException e) {
                    Log.e("TransportRuntime.".concat("CctTransportBackend"), "Could not make request to the backend", e);
                    aVar = new e2.a(e2.c.TRANSIENT_ERROR, -1L);
                }
            }
            hVar.h(new h(this, aVar, iterable, dVar, i8));
        }
    }
}
