package hg;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f5333a;

    static {
        p pVar = p.RSA;
        jg.b bVar = jg.b.SHA256;
        jg.j jVar = jg.j.RSA;
        int i8 = 128;
        c cVar = new c((short) 156, "TLS_RSA_WITH_AES_128_GCM_SHA256", "AES128-GCM-SHA256", pVar, i8, bVar, jVar);
        p pVar2 = p.ECDHE;
        jg.b bVar2 = jg.b.SHA384;
        jg.j jVar2 = jg.j.ECDSA;
        c cVar2 = new c((short) -16340, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "ECDHE-ECDSA-AES256-GCM-SHA384", pVar2, 256, bVar2, jVar2);
        c cVar3 = new c((short) -16341, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "ECDHE-ECDSA-AES128-GCM-SHA256", pVar2, i8, bVar, jVar2);
        c cVar4 = new c((short) -16336, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "ECDHE-RSA-AES256-GCM-SHA384", pVar2, 256, bVar2, jVar);
        c cVar5 = new c((short) -16337, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "ECDHE-RSA-AES128-GCM-SHA256", pVar2, 128, bVar, jVar);
        d dVar = d.CBC;
        List listListOf = CollectionsKt.listOf((Object[]) new c[]{cVar2, cVar4, cVar3, cVar5, cVar, new c((short) 53, "TLS_RSA_WITH_AES_256_CBC_SHA", "AES-256-CBC-SHA", pVar, "AES/CBC/NoPadding", 256, 16, 48, 20, "HmacSHA1", 160, bVar, jVar, dVar), new c((short) 47, "TLS_RSA_WITH_AES_128_CBC_SHA", "AES-128-CBC-SHA", pVar, "AES/CBC/NoPadding", 128, 16, 48, 20, "HmacSHA1", 160, bVar, jVar, dVar)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            c cVar6 = (c) obj;
            Intrinsics.checkNotNullParameter(cVar6, "<this>");
            Lazy lazy = kg.b.f6873a;
            String str = ((kg.a) lazy.getValue()).f6871a;
            int iHashCode = str.hashCode();
            if (iHashCode != 46676283) {
                if (iHashCode != 46677244) {
                    if (iHashCode != 46678205 || !str.equals("1.8.0") || ((kg.a) lazy.getValue()).f6872b >= 161 || cVar6.f <= 128) {
                        arrayList.add(obj);
                    }
                } else if (!str.equals("1.7.0") || ((kg.a) lazy.getValue()).f6872b >= 171 || cVar6.f <= 128) {
                    arrayList.add(obj);
                }
            } else if (!str.equals("1.6.0") || ((kg.a) lazy.getValue()).f6872b >= 181 || cVar6.f <= 128) {
                arrayList.add(obj);
            }
        }
        f5333a = arrayList;
    }
}
