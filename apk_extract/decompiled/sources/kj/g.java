package kj;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d[] f6917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map f6918b;

    static {
        d dVar = new d("", d.f6898i);
        qj.j jVar = d.f;
        d dVar2 = new d("GET", jVar);
        d dVar3 = new d("POST", jVar);
        qj.j jVar2 = d.f6896g;
        d dVar4 = new d("/", jVar2);
        d dVar5 = new d("/index.html", jVar2);
        qj.j jVar3 = d.f6897h;
        d dVar6 = new d("http", jVar3);
        d dVar7 = new d("https", jVar3);
        qj.j jVar4 = d.e;
        d[] dVarArr = {dVar, dVar2, dVar3, dVar4, dVar5, dVar6, dVar7, new d("200", jVar4), new d("204", jVar4), new d("206", jVar4), new d("304", jVar4), new d("400", jVar4), new d("404", jVar4), new d("500", jVar4), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d("content-location", ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d("from", ""), new d("host", ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d("link", ""), new d("location", ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
        f6917a = dVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(61);
        for (int i8 = 0; i8 < 61; i8++) {
            if (!linkedHashMap.containsKey(dVarArr[i8].f6900b)) {
                linkedHashMap.put(dVarArr[i8].f6900b, Integer.valueOf(i8));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "Collections.unmodifiableMap(result)");
        f6918b = mapUnmodifiableMap;
    }

    public static void a(qj.j name) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = name.size();
        for (int i8 = 0; i8 < size; i8++) {
            byte b9 = (byte) 65;
            byte b10 = (byte) 90;
            byte b11 = name.getByte(i8);
            if (b9 <= b11 && b10 >= b11) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.utf8());
            }
        }
    }
}
