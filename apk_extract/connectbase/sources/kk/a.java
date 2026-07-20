package kk;

import fl.t0;
import gq.v;
import ik.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;
import lm.h0;
import lm.l2;
import nm.v0;
import nm.x;
import nm.z;
import tn.u;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class a implements b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final f f9189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final d0 f9190e;

    /* JADX INFO: renamed from: kk.a$a, reason: collision with other inner class name */
    public final class C0241a implements Map.Entry<String, List<? extends String>>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f9191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f9192b;

        public C0241a(a aVar, int i10) {
            l0.p(aVar, "this$0");
            this.f9192b = aVar;
            this.f9191a = i10;
        }

        @Override // java.util.Map.Entry
        @os.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String getKey() {
            return this.f9192b.f9189d.h(this.f9191a).toString();
        }

        @Override // java.util.Map.Entry
        @os.l
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> getValue() {
            return x.k(this.f9192b.f9189d.k(this.f9191a).toString());
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List<String> setValue(List<String> list) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class b extends n0 implements jn.l<CharSequence, String> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final String invoke(@os.l CharSequence charSequence) {
            l0.p(charSequence, "it");
            return charSequence.toString();
        }
    }

    public static final class c extends n0 implements jn.a<LinkedHashSet<String>> {
        public c() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final LinkedHashSet<String> invoke() {
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(a.this.f9189d.f9214b);
            a aVar = a.this;
            int i10 = aVar.f9189d.f9214b;
            for (int i11 = 0; i11 < i10; i11++) {
                linkedHashSet.add(aVar.f9189d.h(i11).toString());
            }
            return linkedHashSet;
        }
    }

    public a(@os.l f fVar) {
        l0.p(fVar, "headers");
        this.f9189d = fVar;
        this.f9190e = f0.c(h0.NONE, new c());
    }

    @Override // fl.o1
    public boolean a() {
        return true;
    }

    @Override // fl.o1
    @os.m
    public List<String> b(@os.l String str) {
        l0.p(str, "name");
        List<String> listC3 = v.c3(v.k1(this.f9189d.f(str), b.INSTANCE));
        if (listC3.isEmpty()) {
            return null;
        }
        return listC3;
    }

    @Override // fl.o1
    public boolean contains(@os.l String str) {
        return b0.b.a(this, str);
    }

    @Override // fl.o1
    public boolean d(@os.l String str, @os.l String str2) {
        return b0.b.b(this, str, str2);
    }

    @Override // fl.o1
    public void e(@os.l jn.p<? super String, ? super List<String>, l2> pVar) {
        b0.b.c(this, pVar);
    }

    @Override // fl.o1
    @os.l
    public Set<Map.Entry<String, List<String>>> entries() {
        tn.l lVarW1 = u.W1(0, this.f9189d.f9214b);
        ArrayList arrayList = new ArrayList(z.b0(lVarW1, 10));
        Iterator<Integer> it = lVarW1.iterator();
        while (it.hasNext()) {
            arrayList.add(new C0241a(this, ((v0) it).nextInt()));
        }
        return nm.h0.a6(arrayList);
    }

    public final Set<String> g() {
        return (Set) this.f9190e.getValue();
    }

    @Override // fl.o1
    @os.m
    public String get(@os.l String str) {
        l0.p(str, "name");
        CharSequence charSequenceE = this.f9189d.e(str);
        if (charSequenceE == null) {
            return null;
        }
        return charSequenceE.toString();
    }

    @Override // fl.o1
    public boolean isEmpty() {
        return this.f9189d.f9214b == 0;
    }

    @Override // fl.o1
    @os.l
    public Set<String> names() {
        return g();
    }
}
