package vj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class w2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Collection<w1<?, ?>> f17500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f17501c;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<w1<?, ?>> f17503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f17504c;

        public static b a(b bVar, Collection collection) {
            bVar.f17503b.addAll(collection);
            return bVar;
        }

        public final b e(Collection<w1<?, ?>> collection) {
            this.f17503b.addAll(collection);
            return this;
        }

        public b f(w1<?, ?> w1Var) {
            this.f17503b.add((w1) c1.h0.F(w1Var, "method"));
            return this;
        }

        public w2 g() {
            return new w2(this);
        }

        @e0("https://github.com/grpc/grpc-java/issues/2666")
        public b h(String str) {
            this.f17502a = (String) c1.h0.F(str, "name");
            return this;
        }

        public b i(@gm.j Object obj) {
            this.f17504c = obj;
            return this;
        }

        public b(String str) {
            this.f17503b = new ArrayList();
            h(str);
        }
    }

    public static b d(String str) {
        return new b(str);
    }

    public static void e(String str, Collection<w1<?, ?>> collection) {
        HashSet hashSet = new HashSet(collection.size());
        for (w1<?, ?> w1Var : collection) {
            c1.h0.F(w1Var, "method");
            String str2 = w1Var.f17482c;
            c1.h0.y(str.equals(str2), "service names %s != %s", str2, str);
            c1.h0.u(hashSet.add(w1Var.f17481b), "duplicate name %s", w1Var.f17481b);
        }
    }

    public Collection<w1<?, ?>> a() {
        return this.f17500b;
    }

    public String b() {
        return this.f17499a;
    }

    @gm.j
    @e0("https://github.com/grpc/grpc-java/issues/2222")
    public Object c() {
        return this.f17501c;
    }

    public String toString() {
        c1.z.b bVarJ = c1.z.c(this).j("name", this.f17499a).j("schemaDescriptor", this.f17501c).j("methods", this.f17500b);
        bVarJ.f1267d = true;
        return bVarJ.toString();
    }

    public w2(String str, w1<?, ?>... w1VarArr) {
        this(str, Arrays.asList(w1VarArr));
    }

    public w2(b bVar) {
        String str = bVar.f17502a;
        this.f17499a = str;
        e(str, bVar.f17503b);
        this.f17500b = Collections.unmodifiableList(new ArrayList(bVar.f17503b));
        this.f17501c = bVar.f17504c;
    }

    public w2(String str, Collection<w1<?, ?>> collection) {
        b bVar = new b(str);
        bVar.f17503b.addAll((Collection) c1.h0.F(collection, "methods"));
        this(bVar);
    }
}
