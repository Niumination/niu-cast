package c1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@k
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1.e f1203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f1205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1206d;

    public class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c1.e f1207a;

        /* JADX INFO: renamed from: c1.m0$a$a, reason: collision with other inner class name */
        public class C0052a extends g {
            public C0052a(m0 splitter, CharSequence toSplit) {
                super(splitter, toSplit);
            }

            @Override // c1.m0.g
            public int e(int separatorPosition) {
                return separatorPosition + 1;
            }

            @Override // c1.m0.g
            public int f(int start) {
                return a.this.f1207a.o(this.f1220c, start);
            }
        }

        public a(final c1.e val$separatorMatcher) {
            this.f1207a = val$separatorMatcher;
        }

        @Override // c1.m0.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(m0 splitter, final CharSequence toSplit) {
            return new C0052a(splitter, toSplit);
        }
    }

    public class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1209a;

        public class a extends g {
            public a(m0 splitter, CharSequence toSplit) {
                super(splitter, toSplit);
            }

            @Override // c1.m0.g
            public int e(int separatorPosition) {
                return b.this.f1209a.length() + separatorPosition;
            }

            @Override // c1.m0.g
            public int f(int start) {
                int length = b.this.f1209a.length();
                int length2 = this.f1220c.length() - length;
                while (start <= length2) {
                    for (int i10 = 0; i10 < length; i10++) {
                        if (this.f1220c.charAt(i10 + start) != b.this.f1209a.charAt(i10)) {
                            start++;
                        }
                    }
                    return start;
                }
                return -1;
            }
        }

        public b(final String val$separator) {
            this.f1209a = val$separator;
        }

        @Override // c1.m0.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(m0 splitter, CharSequence toSplit) {
            return new a(splitter, toSplit);
        }
    }

    public class c implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c1.h f1211a;

        public class a extends g {

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ c1.g f1212i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(final c this$0, m0 splitter, CharSequence toSplit, final c1.g val$matcher) {
                super(splitter, toSplit);
                this.f1212i = val$matcher;
            }

            @Override // c1.m0.g
            public int e(int separatorPosition) {
                return this.f1212i.a();
            }

            @Override // c1.m0.g
            public int f(int start) {
                if (this.f1212i.c(start)) {
                    return this.f1212i.f();
                }
                return -1;
            }
        }

        public c(final c1.h val$separatorPattern) {
            this.f1211a = val$separatorPattern;
        }

        @Override // c1.m0.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(final m0 splitter, CharSequence toSplit) {
            return new a(this, splitter, toSplit, this.f1211a.matcher(toSplit));
        }
    }

    public class d implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1213a;

        public class a extends g {
            public a(m0 splitter, CharSequence toSplit) {
                super(splitter, toSplit);
            }

            @Override // c1.m0.g
            public int e(int separatorPosition) {
                return separatorPosition;
            }

            @Override // c1.m0.g
            public int f(int start) {
                int i10 = start + d.this.f1213a;
                if (i10 < this.f1220c.length()) {
                    return i10;
                }
                return -1;
            }
        }

        public d(final int val$length) {
            this.f1213a = val$length;
        }

        @Override // c1.m0.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(final m0 splitter, CharSequence toSplit) {
            return new a(splitter, toSplit);
        }
    }

    public class e implements Iterable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f1215a;

        public e(final CharSequence val$sequence) {
            this.f1215a = val$sequence;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            m0 m0Var = m0.this;
            return m0Var.f1205c.a(m0Var, this.f1215a);
        }

        public String toString() {
            y yVar = new y(", ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ks.a.f9445d);
            StringBuilder sbF = yVar.f(sb2, this);
            sbF.append(']');
            return sbF.toString();
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f1217c = "Chunk [%s] is not a valid entry";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m0 f1218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m0 f1219b;

        public /* synthetic */ f(m0 m0Var, m0 m0Var2, a aVar) {
            this(m0Var, m0Var2);
        }

        public Map<String, String> a(CharSequence sequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.f1218a.n(sequence)) {
                m0 m0Var = this.f1219b;
                Iterator<String> itA = m0Var.f1205c.a(m0Var, str);
                h0.u(itA.hasNext(), f1217c, str);
                String next = itA.next();
                h0.u(!linkedHashMap.containsKey(next), "Duplicate key [%s] found.", next);
                h0.u(itA.hasNext(), f1217c, str);
                linkedHashMap.put(next, itA.next());
                h0.u(!itA.hasNext(), f1217c, str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }

        public f(m0 outerSplitter, m0 entrySplitter) {
            this.f1218a = outerSplitter;
            entrySplitter.getClass();
            this.f1219b = entrySplitter;
        }
    }

    public static abstract class g extends c1.b<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CharSequence f1220c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c1.e f1221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f1222e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1223f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1224g;

        public g(m0 splitter, CharSequence toSplit) {
            this.f1221d = splitter.f1203a;
            this.f1222e = splitter.f1204b;
            this.f1224g = splitter.f1206d;
            this.f1220c = toSplit;
        }

        @Override // c1.b
        @gm.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int i10 = this.f1223f;
            while (true) {
                int i11 = this.f1223f;
                if (i11 == -1) {
                    this.f1103a = c1.b.EnumC0047b.DONE;
                    return null;
                }
                int iF = f(i11);
                if (iF == -1) {
                    iF = this.f1220c.length();
                    this.f1223f = -1;
                } else {
                    this.f1223f = e(iF);
                }
                int i12 = this.f1223f;
                if (i12 == i10) {
                    int i13 = i12 + 1;
                    this.f1223f = i13;
                    if (i13 > this.f1220c.length()) {
                        this.f1223f = -1;
                    }
                } else {
                    while (i10 < iF && this.f1221d.B(this.f1220c.charAt(i10))) {
                        i10++;
                    }
                    while (iF > i10 && this.f1221d.B(this.f1220c.charAt(iF - 1))) {
                        iF--;
                    }
                    if (!this.f1222e || i10 != iF) {
                        int i14 = this.f1224g;
                        if (i14 == 1) {
                            iF = this.f1220c.length();
                            this.f1223f = -1;
                            while (iF > i10 && this.f1221d.B(this.f1220c.charAt(iF - 1))) {
                                iF--;
                            }
                        } else {
                            this.f1224g = i14 - 1;
                        }
                        return this.f1220c.subSequence(i10, iF).toString();
                    }
                    i10 = this.f1223f;
                }
            }
        }

        public abstract int e(int separatorPosition);

        public abstract int f(int start);
    }

    public interface h {
        Iterator<String> a(m0 splitter, CharSequence toSplit);
    }

    public m0(h strategy, boolean omitEmptyStrings, c1.e trimmer, int limit) {
        this.f1205c = strategy;
        this.f1204b = omitEmptyStrings;
        this.f1203a = trimmer;
        this.f1206d = limit;
    }

    public static Iterator a(m0 m0Var, CharSequence charSequence) {
        return m0Var.f1205c.a(m0Var, charSequence);
    }

    public static m0 e(final int length) {
        h0.e(length > 0, "The length may not be less than 1");
        return new m0(new d(length));
    }

    public static m0 h(char separator) {
        return i(new c1.e.m(separator));
    }

    public static m0 i(final c1.e separatorMatcher) {
        separatorMatcher.getClass();
        return new m0(new a(separatorMatcher));
    }

    public static m0 j(final String separator) {
        h0.e(separator.length() != 0, "The separator may not be the empty string.");
        return separator.length() == 1 ? h(separator.charAt(0)) : new m0(new b(separator));
    }

    @b1.c
    @b1.d
    public static m0 k(Pattern separatorPattern) {
        return m(new x(separatorPattern));
    }

    @b1.c
    @b1.d
    public static m0 l(String separatorPattern) {
        return m(g0.a(separatorPattern));
    }

    public static m0 m(final c1.h separatorPattern) {
        h0.u(!separatorPattern.matcher("").d(), "The pattern may not match the empty string: %s", separatorPattern);
        return new m0(new c(separatorPattern));
    }

    public m0 f(int maxItems) {
        h0.k(maxItems > 0, "must be greater than zero: %s", maxItems);
        return new m0(this.f1205c, this.f1204b, this.f1203a, maxItems);
    }

    public m0 g() {
        return new m0(this.f1205c, true, this.f1203a, this.f1206d);
    }

    public Iterable<String> n(final CharSequence sequence) {
        sequence.getClass();
        return new e(sequence);
    }

    public List<String> o(CharSequence sequence) {
        sequence.getClass();
        Iterator<String> itA = this.f1205c.a(this, sequence);
        ArrayList arrayList = new ArrayList();
        while (itA.hasNext()) {
            arrayList.add(itA.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterator<String> p(CharSequence sequence) {
        return this.f1205c.a(this, sequence);
    }

    public m0 q() {
        return r(c1.e.c0.f1149f);
    }

    public m0 r(c1.e trimmer) {
        trimmer.getClass();
        return new m0(this.f1205c, this.f1204b, trimmer, this.f1206d);
    }

    public f s(char separator) {
        return new f(this, h(separator));
    }

    public f t(m0 keyValueSplitter) {
        return new f(this, keyValueSplitter);
    }

    public f u(String separator) {
        return new f(this, j(separator));
    }

    public m0(h strategy) {
        this(strategy, false, c1.e.y.f1174c, Integer.MAX_VALUE);
    }
}
