package fl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
@t0
public class s1 implements o1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f6097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final String f6098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final List<String> f6099f;

    public static final class a implements Map.Entry<String, List<? extends String>>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final String f6100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final List<String> f6101b;

        public a() {
            this.f6100a = s1.this.f6098e;
            this.f6101b = s1.this.f6099f;
        }

        @os.l
        public String a() {
            return this.f6100a;
        }

        @os.l
        public List<String> c() {
            return this.f6101b;
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List<String> setValue(List<String> list) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return this.f6100a;
        }

        @Override // java.util.Map.Entry
        public List<? extends String> getValue() {
            return this.f6101b;
        }

        @os.l
        public String toString() {
            return this.f6100a + h.f6043c + this.f6101b;
        }
    }

    public s1(boolean z10, @os.l String str, @os.l List<String> list) {
        kn.l0.p(str, "name");
        kn.l0.p(list, "values");
        this.f6097d = z10;
        this.f6098e = str;
        this.f6099f = list;
    }

    @Override // fl.o1
    public boolean a() {
        return this.f6097d;
    }

    @Override // fl.o1
    @os.m
    public List<String> b(@os.l String str) {
        kn.l0.p(str, "name");
        if (jq.e0.K1(this.f6098e, str, a())) {
            return this.f6099f;
        }
        return null;
    }

    @Override // fl.o1
    public boolean contains(@os.l String str) {
        kn.l0.p(str, "name");
        return jq.e0.K1(str, this.f6098e, a());
    }

    @Override // fl.o1
    public boolean d(@os.l String str, @os.l String str2) {
        kn.l0.p(str, "name");
        kn.l0.p(str2, "value");
        return jq.e0.K1(str, this.f6098e, a()) && this.f6099f.contains(str2);
    }

    @Override // fl.o1
    public void e(@os.l jn.p<? super String, ? super List<String>, l2> pVar) {
        kn.l0.p(pVar, "body");
        pVar.invoke(this.f6098e, this.f6099f);
    }

    @Override // fl.o1
    @os.l
    public Set<Map.Entry<String, List<String>>> entries() {
        return nm.n1.f(new a());
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        if (a() != o1Var.a()) {
            return false;
        }
        return kn.l0.g(entries(), o1Var.entries());
    }

    @os.l
    public final String f() {
        return this.f6098e;
    }

    @os.l
    public final List<String> g() {
        return this.f6099f;
    }

    @Override // fl.o1
    @os.m
    public String get(@os.l String str) {
        kn.l0.p(str, "name");
        if (jq.e0.K1(str, this.f6098e, a())) {
            return (String) nm.h0.G2(this.f6099f);
        }
        return null;
    }

    public int hashCode() {
        return r1.g(entries(), Boolean.hashCode(a()) * 31);
    }

    @Override // fl.o1
    public boolean isEmpty() {
        return false;
    }

    @Override // fl.o1
    @os.l
    public Set<String> names() {
        return nm.n1.f(this.f6098e);
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("StringValues(case=");
        sb2.append(!a());
        sb2.append(") ");
        sb2.append(entries());
        return sb2.toString();
    }
}
