package f1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class w4<K0, V0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5525a = 8;

    public class a extends k<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f5526b;

        public a(final int val$expectedKeys) {
            this.f5526b = val$expectedKeys;
        }

        @Override // f1.w4.k
        public <K, V> Map<K, Collection<V>> c() {
            return d0.createWithExpectedSize(this.f5526b);
        }
    }

    public class b extends k<Object> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f5527b;

        public b(final int val$expectedKeys) {
            this.f5527b = val$expectedKeys;
        }

        @Override // f1.w4.k
        public <K, V> Map<K, Collection<V>> c() {
            return g0.createWithExpectedSize(this.f5527b);
        }
    }

    public class c extends k<K0> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator f5528b;

        public c(final Comparator val$comparator) {
            this.f5528b = val$comparator;
        }

        @Override // f1.w4.k
        public <K extends K0, V> Map<K, Collection<V>> c() {
            return new TreeMap(this.f5528b);
        }
    }

    public class d extends k<K0> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f5529b;

        public d(final Class val$keyClass) {
            this.f5529b = val$keyClass;
        }

        @Override // f1.w4.k
        public <K extends K0, V> Map<K, Collection<V>> c() {
            return new EnumMap(this.f5529b);
        }
    }

    public static final class e<V> implements c1.q0<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        public e(int expectedValuesPerKey) {
            this.expectedValuesPerKey = b0.b(expectedValuesPerKey, "expectedValuesPerKey");
        }

        @Override // c1.q0
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    public static final class f<V extends Enum<V>> implements c1.q0<Set<V>>, Serializable {
        private final Class<V> clazz;

        public f(Class<V> clazz) {
            clazz.getClass();
            this.clazz = clazz;
        }

        @Override // c1.q0
        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }
    }

    public static final class g<V> implements c1.q0<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public g(int expectedValuesPerKey) {
            this.expectedValuesPerKey = b0.b(expectedValuesPerKey, "expectedValuesPerKey");
        }

        @Override // c1.q0
        public Set<V> get() {
            return e0.createWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    public static final class h<V> implements c1.q0<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        public h(int expectedValuesPerKey) {
            this.expectedValuesPerKey = b0.b(expectedValuesPerKey, "expectedValuesPerKey");
        }

        @Override // c1.q0
        public Set<V> get() {
            return h0.createWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    public enum i implements c1.q0<List<?>> {
        INSTANCE;

        public static /* synthetic */ i[] a() {
            return new i[]{INSTANCE};
        }

        public static <V> c1.q0<List<V>> instance() {
            return INSTANCE;
        }

        @Override // c1.q0
        public List<?> get() {
            return new LinkedList();
        }
    }

    public static abstract class j<K0, V0> extends w4<K0, V0> {
        @Override // f1.w4
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public abstract <K extends K0, V extends V0> o4<K, V> a();

        @Override // f1.w4
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public <K extends K0, V extends V0> o4<K, V> b(v4<? extends K, ? extends V> multimap) {
            return (o4) super.b(multimap);
        }
    }

    public static abstract class k<K0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f5531a = 2;

        public class a extends j<K0, Object> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f5532b;

            public a(final int val$expectedValuesPerKey) {
                this.f5532b = val$expectedValuesPerKey;
            }

            @Override // f1.w4.j, f1.w4
            /* JADX INFO: renamed from: j */
            public <K extends K0, V> o4<K, V> a() {
                return new y4.b(k.this.c(), new e(this.f5532b));
            }
        }

        public class b extends j<K0, Object> {
            public b() {
            }

            @Override // f1.w4.j, f1.w4
            /* JADX INFO: renamed from: j */
            public <K extends K0, V> o4<K, V> a() {
                return new y4.b(k.this.c(), i.instance());
            }
        }

        public class c extends l<K0, Object> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f5535b;

            public c(final int val$expectedValuesPerKey) {
                this.f5535b = val$expectedValuesPerKey;
            }

            @Override // f1.w4.l, f1.w4
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public <K extends K0, V> j6<K, V> a() {
                return new y4.d(k.this.c(), new g(this.f5535b));
            }
        }

        public class d extends l<K0, Object> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f5537b;

            public d(final int val$expectedValuesPerKey) {
                this.f5537b = val$expectedValuesPerKey;
            }

            @Override // f1.w4.l, f1.w4
            /* JADX INFO: renamed from: j */
            public <K extends K0, V> j6<K, V> a() {
                return new y4.d(k.this.c(), new h(this.f5537b));
            }
        }

        public class e extends m<K0, V0> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Comparator f5539b;

            public e(final Comparator val$comparator) {
                this.f5539b = val$comparator;
            }

            @Override // f1.w4.m, f1.w4.l
            /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
            public <K extends K0, V extends V0> u6<K, V> a() {
                return new y4.e(k.this.c(), new n(this.f5539b));
            }
        }

        public class f extends l<K0, V0> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Class f5541b;

            public f(final Class val$valueClass) {
                this.f5541b = val$valueClass;
            }

            @Override // f1.w4.l, f1.w4
            /* JADX INFO: renamed from: j */
            public <K extends K0, V extends V0> j6<K, V> a() {
                return new y4.d(k.this.c(), new f(this.f5541b));
            }
        }

        public j<K0, Object> a() {
            return b(2);
        }

        public j<K0, Object> b(int expectedValuesPerKey) {
            b0.b(expectedValuesPerKey, "expectedValuesPerKey");
            return new a(expectedValuesPerKey);
        }

        public abstract <K extends K0, V> Map<K, Collection<V>> c();

        public <V0 extends Enum<V0>> l<K0, V0> d(Class<V0> valueClass) {
            c1.h0.F(valueClass, "valueClass");
            return new f(valueClass);
        }

        public l<K0, Object> e() {
            return f(2);
        }

        public l<K0, Object> f(int expectedValuesPerKey) {
            b0.b(expectedValuesPerKey, "expectedValuesPerKey");
            return new c(expectedValuesPerKey);
        }

        public l<K0, Object> g() {
            return h(2);
        }

        public l<K0, Object> h(int expectedValuesPerKey) {
            b0.b(expectedValuesPerKey, "expectedValuesPerKey");
            return new d(expectedValuesPerKey);
        }

        public j<K0, Object> i() {
            return new b();
        }

        public m<K0, Comparable> j() {
            return k(l5.natural());
        }

        public <V0> m<K0, V0> k(Comparator<V0> comparator) {
            c1.h0.F(comparator, "comparator");
            return new e(comparator);
        }
    }

    public static abstract class l<K0, V0> extends w4<K0, V0> {
        @Override // f1.w4
        /* JADX INFO: renamed from: j */
        public abstract <K extends K0, V extends V0> j6<K, V> a();

        @Override // f1.w4
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public <K extends K0, V extends V0> j6<K, V> b(v4<? extends K, ? extends V> multimap) {
            return (j6) super.b(multimap);
        }
    }

    public static abstract class m<K0, V0> extends l<K0, V0> {
        @Override // f1.w4.l
        /* JADX INFO: renamed from: l */
        public abstract <K extends K0, V extends V0> u6<K, V> a();

        @Override // f1.w4.l
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public <K extends K0, V extends V0> u6<K, V> b(v4<? extends K, ? extends V> multimap) {
            return (u6) super.b(multimap);
        }
    }

    public static final class n<V> implements c1.q0<SortedSet<V>>, Serializable {
        private final Comparator<? super V> comparator;

        public n(Comparator<? super V> comparator) {
            comparator.getClass();
            this.comparator = comparator;
        }

        @Override // c1.q0
        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }
    }

    public w4() {
    }

    public static <K0 extends Enum<K0>> k<K0> c(Class<K0> keyClass) {
        keyClass.getClass();
        return new d(keyClass);
    }

    public static k<Object> d() {
        return e(8);
    }

    public static k<Object> e(int expectedKeys) {
        b0.b(expectedKeys, "expectedKeys");
        return new a(expectedKeys);
    }

    public static k<Object> f() {
        return g(8);
    }

    public static k<Object> g(int expectedKeys) {
        b0.b(expectedKeys, "expectedKeys");
        return new b(expectedKeys);
    }

    public static k<Comparable> h() {
        return i(l5.natural());
    }

    public static <K0> k<K0> i(Comparator<K0> comparator) {
        comparator.getClass();
        return new c(comparator);
    }

    public abstract <K extends K0, V extends V0> v4<K, V> a();

    public <K extends K0, V extends V0> v4<K, V> b(v4<? extends K, ? extends V> multimap) {
        v4<K, V> v4VarA = a();
        v4VarA.putAll(multimap);
        return v4VarA;
    }

    public w4(a aVar) {
    }
}
