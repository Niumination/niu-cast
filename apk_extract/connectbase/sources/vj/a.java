package vj;

import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@hm.b
@e0("https://github.com/grpc/grpc-java/issues/1764")
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IdentityHashMap<c<?>, Object> f17045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f17046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ boolean f17047d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap<c<?>, Object> f17048a;

    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ boolean f17049c = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a f17050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public IdentityHashMap<c<?>, Object> f17051b;

        public a a() {
            if (this.f17051b != null) {
                for (Map.Entry entry : this.f17050a.f17048a.entrySet()) {
                    if (!this.f17051b.containsKey(entry.getKey())) {
                        this.f17051b.put((c) entry.getKey(), entry.getValue());
                    }
                }
                this.f17050a = new a(this.f17051b);
                this.f17051b = null;
            }
            return this.f17050a;
        }

        public final IdentityHashMap<c<?>, Object> b(int i10) {
            if (this.f17051b == null) {
                this.f17051b = new IdentityHashMap<>(i10);
            }
            return this.f17051b;
        }

        public <T> b c(c<T> cVar) {
            if (this.f17050a.f17048a.containsKey(cVar)) {
                IdentityHashMap identityHashMap = new IdentityHashMap(this.f17050a.f17048a);
                identityHashMap.remove(cVar);
                this.f17050a = new a(identityHashMap);
            }
            IdentityHashMap<c<?>, Object> identityHashMap2 = this.f17051b;
            if (identityHashMap2 != null) {
                identityHashMap2.remove(cVar);
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <T> b d(c<T> cVar, T t10) {
            b(1).put(cVar, t10);
            return this;
        }

        public b e(a aVar) {
            b(aVar.f17048a.size()).putAll(aVar.f17048a);
            return this;
        }

        public b(a aVar) {
            this.f17050a = aVar;
        }
    }

    @hm.b
    public static final class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17052a;

        public c(String str) {
            this.f17052a = str;
        }

        public static <T> c<T> a(String str) {
            return new c<>(str);
        }

        @Deprecated
        public static <T> c<T> b(String str) {
            return new c<>(str);
        }

        public String toString() {
            return this.f17052a;
        }
    }

    static {
        IdentityHashMap<c<?>, Object> identityHashMap = new IdentityHashMap<>();
        f17045b = identityHashMap;
        f17046c = new a(identityHashMap);
    }

    public static b e() {
        return new b(f17046c);
    }

    @Deprecated
    public static b f(a aVar) {
        c1.h0.F(aVar, "base");
        return new b(aVar);
    }

    @gm.j
    public <T> T b(c<T> cVar) {
        return (T) this.f17048a.get(cVar);
    }

    @Deprecated
    public Set<c<?>> c() {
        return Collections.unmodifiableSet(this.f17048a.keySet());
    }

    public Set<c<?>> d() {
        return Collections.unmodifiableSet(this.f17048a.keySet());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f17048a.size() != aVar.f17048a.size()) {
            return false;
        }
        for (Map.Entry<c<?>, Object> entry : this.f17048a.entrySet()) {
            if (!aVar.f17048a.containsKey(entry.getKey()) || !c1.b0.a(entry.getValue(), aVar.f17048a.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public b g() {
        return new b(this);
    }

    public int hashCode() {
        int iHashCode = 0;
        for (Map.Entry<c<?>, Object> entry : this.f17048a.entrySet()) {
            iHashCode += Arrays.hashCode(new Object[]{entry.getKey(), entry.getValue()});
        }
        return iHashCode;
    }

    public String toString() {
        return this.f17048a.toString();
    }

    public a(IdentityHashMap<c<?>, Object> identityHashMap) {
        this.f17048a = identityHashMap;
    }
}
