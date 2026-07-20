package jq;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Matcher f8890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final CharSequence f8891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final n f8892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public List<String> f8893d;

    public q(@os.l Matcher matcher, @os.l CharSequence charSequence) {
        kn.l0.p(matcher, "matcher");
        kn.l0.p(charSequence, "input");
        this.f8890a = matcher;
        this.f8891b = charSequence;
        this.f8892c = new b();
    }

    public static final MatchResult e(q qVar) {
        return qVar.f8890a;
    }

    @Override // jq.p
    @os.l
    public p.b a() {
        return new p.b(this);
    }

    @Override // jq.p
    @os.l
    public List<String> b() {
        if (this.f8893d == null) {
            this.f8893d = new a();
        }
        List<String> list = this.f8893d;
        kn.l0.m(list);
        return list;
    }

    @Override // jq.p
    @os.l
    public tn.l c() {
        return s.i(this.f8890a);
    }

    @Override // jq.p
    @os.l
    public n d() {
        return this.f8892c;
    }

    public final MatchResult f() {
        return this.f8890a;
    }

    @Override // jq.p
    @os.l
    public String getValue() {
        String strGroup = this.f8890a.group();
        kn.l0.o(strGroup, "group(...)");
        return strGroup;
    }

    @Override // jq.p
    @os.m
    public p next() {
        int iEnd = this.f8890a.end() + (this.f8890a.end() == this.f8890a.start() ? 1 : 0);
        if (iEnd > this.f8891b.length()) {
            return null;
        }
        Matcher matcher = this.f8890a.pattern().matcher(this.f8891b);
        kn.l0.o(matcher, "matcher(...)");
        return s.f(matcher, iEnd, this.f8891b);
    }

    public static final class a extends nm.c<String> {
        public a() {
        }

        @Override // nm.c, java.util.List
        @os.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String get(int i10) {
            String strGroup = q.this.f8890a.group(i10);
            return strGroup == null ? "" : strGroup;
        }

        public /* bridge */ int c(String str) {
            return super.indexOf(str);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return super.contains((String) obj);
            }
            return false;
        }

        public /* bridge */ int e(String str) {
            return super.lastIndexOf(str);
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return q.this.f8890a.groupCount() + 1;
        }

        @Override // nm.c, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return super.indexOf((String) obj);
            }
            return -1;
        }

        @Override // nm.c, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return super.lastIndexOf((String) obj);
            }
            return -1;
        }

        public /* bridge */ boolean contains(String str) {
            return super.contains(str);
        }
    }

    public static final class b extends nm.a<m> implements o {

        public static final class a extends kn.n0 implements jn.l<Integer, m> {
            public a() {
                super(1);
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ m invoke(Integer num) {
                return invoke(num.intValue());
            }

            @os.m
            public final m invoke(int i10) {
                return b.this.get(i10);
            }
        }

        public b() {
        }

        public /* bridge */ boolean a(m mVar) {
            return super.contains(mVar);
        }

        @Override // nm.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof m) {
                return super.contains((m) obj);
            }
            return false;
        }

        @Override // jq.n
        @os.m
        public m get(int i10) {
            tn.l lVarJ = s.j(q.this.f8890a, i10);
            if (lVarJ.f15911a < 0) {
                return null;
            }
            String strGroup = q.this.f8890a.group(i10);
            kn.l0.o(strGroup, "group(...)");
            return new m(strGroup, lVarJ);
        }

        @Override // nm.a
        public int getSize() {
            return q.this.f8890a.groupCount() + 1;
        }

        @Override // nm.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // nm.a, java.util.Collection, java.lang.Iterable
        @os.l
        public Iterator<m> iterator() {
            return gq.v.k1(nm.h0.A1(nm.y.I(this)), new a()).iterator();
        }

        @Override // jq.o
        @os.m
        public m get(@os.l String str) {
            kn.l0.p(str, "name");
            return an.m.f417a.c(q.this.f8890a, str);
        }
    }
}
