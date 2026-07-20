package vj;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@gm.c
@hm.b
public final class e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final e f17085l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.j
    public final y f17086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.j
    public final Executor f17087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.j
    public final String f17088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @gm.j
    public final d f17089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @gm.j
    public final String f17090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object[][] f17091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<n.a> f17092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @gm.j
    public final Boolean f17093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @gm.j
    public final Integer f17094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @gm.j
    public final Integer f17095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @gm.j
    public final Integer f17096k;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public y f17097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f17098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f17099c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f17100d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f17101e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object[][] f17102f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List<n.a> f17103g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Boolean f17104h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Integer f17105i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Integer f17106j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f17107k;

        public static e a(b bVar) {
            bVar.getClass();
            return new e(bVar);
        }

        public final e b() {
            return new e(this);
        }
    }

    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f17109b;

        public c(String str, T t10) {
            this.f17108a = str;
            this.f17109b = t10;
        }

        public static <T> c<T> b(String str) {
            c1.h0.F(str, "debugString");
            return new c<>(str, null);
        }

        public static <T> c<T> c(String str, T t10) {
            c1.h0.F(str, "debugString");
            return new c<>(str, t10);
        }

        @Deprecated
        @e0("https://github.com/grpc/grpc-java/issues/1869")
        public static <T> c<T> e(String str, T t10) {
            c1.h0.F(str, "debugString");
            return new c<>(str, t10);
        }

        public T d() {
            return this.f17109b;
        }

        public String toString() {
            return this.f17108a;
        }
    }

    static {
        b bVar = new b();
        bVar.f17102f = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        bVar.f17103g = Collections.emptyList();
        f17085l = b.a(bVar);
    }

    public static b n(e eVar) {
        b bVar = new b();
        bVar.f17097a = eVar.f17086a;
        bVar.f17098b = eVar.f17087b;
        bVar.f17099c = eVar.f17088c;
        bVar.f17100d = eVar.f17089d;
        bVar.f17101e = eVar.f17090e;
        bVar.f17102f = eVar.f17091f;
        bVar.f17103g = eVar.f17092g;
        bVar.f17104h = eVar.f17093h;
        bVar.f17105i = eVar.f17094i;
        bVar.f17106j = eVar.f17095j;
        return bVar;
    }

    public e A() {
        b bVarN = n(this);
        bVarN.f17104h = Boolean.FALSE;
        return b.a(bVarN);
    }

    @e0("https://github.com/grpc/grpc-java/issues/11021")
    public e a() {
        b bVarN = n(this);
        bVarN.f17107k = null;
        return b.a(bVarN);
    }

    @gm.j
    @e0("https://github.com/grpc/grpc-java/issues/1767")
    public String b() {
        return this.f17088c;
    }

    @gm.j
    public String c() {
        return this.f17090e;
    }

    @gm.j
    public d d() {
        return this.f17089d;
    }

    @gm.j
    public y e() {
        return this.f17086a;
    }

    @gm.j
    public Executor f() {
        return this.f17087b;
    }

    @gm.j
    @e0("https://github.com/grpc/grpc-java/issues/2563")
    public Integer g() {
        return this.f17094i;
    }

    @gm.j
    @e0("https://github.com/grpc/grpc-java/issues/2563")
    public Integer h() {
        return this.f17095j;
    }

    @gm.j
    @e0("https://github.com/grpc/grpc-java/issues/11021")
    public Integer i() {
        return this.f17096k;
    }

    @e0("https://github.com/grpc/grpc-java/issues/1869")
    public <T> T j(c<T> cVar) {
        c1.h0.F(cVar, cb.b.c.f1408o);
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.f17091f;
            if (i10 >= objArr.length) {
                return cVar.f17109b;
            }
            if (cVar.equals(objArr[i10][0])) {
                return (T) this.f17091f[i10][1];
            }
            i10++;
        }
    }

    @e0("https://github.com/grpc/grpc-java/issues/2861")
    public List<n.a> k() {
        return this.f17092g;
    }

    public Boolean l() {
        return this.f17093h;
    }

    public boolean m() {
        return Boolean.TRUE.equals(this.f17093h);
    }

    @e0("https://github.com/grpc/grpc-java/issues/1767")
    public e o(@gm.j String str) {
        b bVarN = n(this);
        bVarN.f17099c = str;
        return b.a(bVarN);
    }

    public e p(@gm.j d dVar) {
        b bVarN = n(this);
        bVarN.f17100d = dVar;
        return b.a(bVarN);
    }

    public e q(@gm.j String str) {
        b bVarN = n(this);
        bVarN.f17101e = str;
        return b.a(bVarN);
    }

    public e r(@gm.j y yVar) {
        b bVarN = n(this);
        bVarN.f17097a = yVar;
        return b.a(bVarN);
    }

    public e s(long j10, TimeUnit timeUnit) {
        return r(y.a(j10, timeUnit));
    }

    public e t(@gm.j Executor executor) {
        b bVarN = n(this);
        bVarN.f17098b = executor;
        return b.a(bVarN);
    }

    public String toString() {
        c1.z.b bVarJ = c1.z.c(this).j("deadline", this.f17086a).j("authority", this.f17088c).j("callCredentials", this.f17089d);
        Executor executor = this.f17087b;
        return bVarJ.j("executor", executor != null ? executor.getClass() : null).j("compressorName", this.f17090e).j("customOptions", Arrays.deepToString(this.f17091f)).g("waitForReady", m()).j("maxInboundMessageSize", this.f17094i).j("maxOutboundMessageSize", this.f17095j).j("streamTracerFactories", this.f17092g).toString();
    }

    @e0("https://github.com/grpc/grpc-java/issues/2563")
    public e u(int i10) {
        c1.h0.k(i10 >= 0, "invalid maxsize %s", i10);
        b bVarN = n(this);
        bVarN.f17105i = Integer.valueOf(i10);
        return b.a(bVarN);
    }

    @e0("https://github.com/grpc/grpc-java/issues/2563")
    public e v(int i10) {
        c1.h0.k(i10 >= 0, "invalid maxsize %s", i10);
        b bVarN = n(this);
        bVarN.f17106j = Integer.valueOf(i10);
        return b.a(bVarN);
    }

    @e0("https://github.com/grpc/grpc-java/issues/11021")
    public e w(int i10) {
        c1.h0.k(i10 > 0, "numBytes must be positive: %s", i10);
        b bVarN = n(this);
        bVarN.f17107k = Integer.valueOf(i10);
        return b.a(bVarN);
    }

    public <T> e x(c<T> cVar, T t10) {
        c1.h0.F(cVar, cb.b.c.f1408o);
        c1.h0.F(t10, "value");
        b bVarN = n(this);
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.f17091f;
            if (i10 >= objArr.length) {
                i10 = -1;
                break;
            }
            if (cVar.equals(objArr[i10][0])) {
                break;
            }
            i10++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.f17091f.length + (i10 == -1 ? 1 : 0), 2);
        bVarN.f17102f = objArr2;
        Object[][] objArr3 = this.f17091f;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i10 == -1) {
            bVarN.f17102f[this.f17091f.length] = new Object[]{cVar, t10};
        } else {
            bVarN.f17102f[i10] = new Object[]{cVar, t10};
        }
        return b.a(bVarN);
    }

    @e0("https://github.com/grpc/grpc-java/issues/2861")
    public e y(n.a aVar) {
        ArrayList arrayList = new ArrayList(this.f17092g.size() + 1);
        arrayList.addAll(this.f17092g);
        arrayList.add(aVar);
        b bVarN = n(this);
        bVarN.f17103g = Collections.unmodifiableList(arrayList);
        return b.a(bVarN);
    }

    public e z() {
        b bVarN = n(this);
        bVarN.f17104h = Boolean.TRUE;
        return b.a(bVarN);
    }

    public e(b bVar) {
        this.f17086a = bVar.f17097a;
        this.f17087b = bVar.f17098b;
        this.f17088c = bVar.f17099c;
        this.f17089d = bVar.f17100d;
        this.f17090e = bVar.f17101e;
        this.f17091f = bVar.f17102f;
        this.f17092g = bVar.f17103g;
        this.f17093h = bVar.f17104h;
        this.f17094i = bVar.f17105i;
        this.f17095j = bVar.f17106j;
        this.f17096k = bVar.f17107k;
    }
}
