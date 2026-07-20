package ze;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o5.c f11323c = new o5.c(String.valueOf(','));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b0 f11324d = new b0(o.f11387b, false, new b0(new o(1), true, new b0()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f11326b;

    public b0(o oVar, boolean z2, b0 b0Var) {
        String strA = oVar.a();
        v8.c("Comma is currently not allowed in message encoding", !strA.contains(","));
        int size = b0Var.f11325a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(b0Var.f11325a.containsKey(oVar.a()) ? size : size + 1);
        for (a0 a0Var : b0Var.f11325a.values()) {
            String strA2 = a0Var.f11319a.a();
            if (!strA2.equals(strA)) {
                linkedHashMap.put(strA2, new a0(a0Var.f11319a, a0Var.f11320b));
            }
        }
        linkedHashMap.put(strA, new a0(oVar, z2));
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        this.f11325a = mapUnmodifiableMap;
        HashSet hashSet = new HashSet(mapUnmodifiableMap.size());
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            if (((a0) entry.getValue()).f11320b) {
                hashSet.add((String) entry.getKey());
            }
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        o5.c cVar = f11323c;
        cVar.getClass();
        Iterator it = setUnmodifiableSet.iterator();
        StringBuilder sb2 = new StringBuilder();
        cVar.a(sb2, it);
        this.f11326b = sb2.toString().getBytes(Charset.forName("US-ASCII"));
    }

    public b0() {
        this.f11325a = new LinkedHashMap(0);
        this.f11326b = new byte[0];
    }
}
