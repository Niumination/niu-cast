package e3;

import h3.b;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import jq.h0;
import kn.l0;
import kn.r1;
import os.l;
import q2.c;
import s2.e;
import z2.d;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nDataTransmissionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataTransmissionManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/DataTransmissionManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,54:1\n1603#2,9:55\n1855#2:64\n1856#2:66\n1612#2:67\n1855#2,2:68\n1855#2,2:70\n1855#2,2:72\n1#3:65\n*S KotlinDebug\n*F\n+ 1 DataTransmissionManager.kt\ncom/transsion/airtransfer/filetransfer/transmission/DataTransmissionManager\n*L\n27#1:55,9\n27#1:64\n27#1:66\n27#1:67\n27#1:68,2\n39#1:70,2\n47#1:72,2\n27#1:65\n*E\n"})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final a f4044a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final Set<d.a> f4045b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final Set<d> f4046c = new LinkedHashSet();

    public final void a(@l d.a aVar) {
        l0.p(aVar, "factory");
        f4045b.add(aVar);
    }

    public final void b(String str) {
        Set<d.a> set = f4045b;
        ArrayList<d> arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            d dVarA = ((d.a) it.next()).a(str);
            if (dVarA != null) {
                arrayList.add(dVarA);
            }
        }
        for (d dVar : arrayList) {
            c cVar = c.f13803b;
            String simpleName = dVar.getClass().getSimpleName();
            l0.o(simpleName, "getSimpleName(...)");
            cVar.r(simpleName);
            f4046c.add(dVar);
        }
    }

    public final void c(@l String str) {
        l0.p(str, RtspHeaders.Values.URL);
        if (str.length() == 0 || e.a(str)) {
            b(e.e(str));
            b(e.d(str));
        } else {
            Iterator it = h0.R4(str, new String[]{";"}, false, 0, 6, null).iterator();
            while (it.hasNext()) {
                f4044a.b((String) it.next());
            }
        }
    }

    public final synchronized void d() {
        try {
            Iterator<T> it = f4046c.iterator();
            while (it.hasNext()) {
                ((d) it.next()).disconnect();
            }
            f4046c.clear();
            b.f6969a.c();
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
