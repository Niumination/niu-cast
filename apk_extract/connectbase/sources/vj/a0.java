package vj;

import io.netty.util.internal.StringUtil;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
@e0("https://github.com/grpc/grpc-java/issues/1704")
public final class a0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c1.y f17053c = c1.y.o(StringUtil.COMMA);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a0 f17054d = new a0(p.b.f17223a, false, new a0(new p.a(), true, new a0()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f17055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f17056b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f17057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17058b;

        public a(z zVar, boolean z10) {
            this.f17057a = (z) c1.h0.F(zVar, "decompressor");
            this.f17058b = z10;
        }
    }

    public a0(z zVar, boolean z10, a0 a0Var) {
        String strA = zVar.a();
        c1.h0.e(!strA.contains(ks.g.f9491d), "Comma is currently not allowed in message encoding");
        int size = a0Var.f17055a.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(a0Var.f17055a.containsKey(zVar.a()) ? size : size + 1);
        for (a aVar : a0Var.f17055a.values()) {
            String strA2 = aVar.f17057a.a();
            if (!strA2.equals(strA)) {
                linkedHashMap.put(strA2, new a(aVar.f17057a, aVar.f17058b));
            }
        }
        linkedHashMap.put(strA, new a(zVar, z10));
        this.f17055a = Collections.unmodifiableMap(linkedHashMap);
        this.f17056b = f17053c.k(b()).getBytes(Charset.forName("US-ASCII"));
    }

    public static a0 a() {
        return new a0();
    }

    public static a0 c() {
        return f17054d;
    }

    @e0("https://github.com/grpc/grpc-java/issues/1704")
    public Set<String> b() {
        HashSet hashSet = new HashSet(this.f17055a.size());
        for (Map.Entry<String, a> entry : this.f17055a.entrySet()) {
            if (entry.getValue().f17058b) {
                hashSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public Set<String> d() {
        return this.f17055a.keySet();
    }

    public byte[] e() {
        return this.f17056b;
    }

    @gm.j
    public z f(String str) {
        a aVar = this.f17055a.get(str);
        if (aVar != null) {
            return aVar.f17057a;
        }
        return null;
    }

    public a0 g(z zVar, boolean z10) {
        return new a0(zVar, z10, this);
    }

    public a0() {
        this.f17055a = new LinkedHashMap(0);
        this.f17056b = new byte[0];
    }
}
