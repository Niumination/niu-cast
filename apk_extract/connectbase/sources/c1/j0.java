package c1;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@c1.k
public final class j0 {

    public static class b<T> implements i0<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends i0<? super T>> components;

        @Override // c1.i0
        public boolean apply(@e0 T t10) {
            for (int i10 = 0; i10 < this.components.size(); i10++) {
                if (!this.components.get(i10).apply(t10)) {
                    return false;
                }
            }
            return true;
        }

        @Override // c1.i0
        public boolean equals(@gm.a Object obj) {
            if (obj instanceof b) {
                return this.components.equals(((b) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        public String toString() {
            return j0.w("and", this.components);
        }

        public b(List<? extends i0<? super T>> components) {
            this.components = components;
        }
    }

    public static class c<A, B> implements i0<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final t<A, ? extends B> f1192f;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final i0<B> f1193p;

        @Override // c1.i0
        public boolean apply(@e0 A a10) {
            return this.f1193p.apply(this.f1192f.apply(a10));
        }

        @Override // c1.i0
        public boolean equals(@gm.a Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f1192f.equals(cVar.f1192f) && this.f1193p.equals(cVar.f1193p);
        }

        public int hashCode() {
            return this.f1193p.hashCode() ^ this.f1192f.hashCode();
        }

        public String toString() {
            return this.f1193p + "(" + this.f1192f + ")";
        }

        public c(i0<B> p10, t<A, ? extends B> f10) {
            p10.getClass();
            this.f1193p = p10;
            f10.getClass();
            this.f1192f = f10;
        }
    }

    @b1.c
    @b1.d
    public static class d extends e {
        private static final long serialVersionUID = 0;

        public d(String string) {
            super(g0.a(string));
        }

        @Override // c1.j0.e
        public String toString() {
            return "Predicates.containsPattern(" + this.pattern.pattern() + ")";
        }
    }

    @b1.c
    @b1.d
    public static class e implements i0<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        final c1.h pattern;

        public e(c1.h pattern) {
            pattern.getClass();
            this.pattern = pattern;
        }

        @Override // c1.i0
        public boolean equals(@gm.a Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return b0.a(this.pattern.pattern(), eVar.pattern.pattern()) && this.pattern.flags() == eVar.pattern.flags();
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.pattern.pattern(), Integer.valueOf(this.pattern.flags())});
        }

        public String toString() {
            return n.a.a("Predicates.contains(", z.c(this.pattern).j("pattern", this.pattern.pattern()).d("pattern.flags", this.pattern.flags()).toString(), ")");
        }

        @Override // c1.i0
        public boolean apply(CharSequence t10) {
            return this.pattern.matcher(t10).b();
        }
    }

    public static class f<T> implements i0<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        @Override // c1.i0
        public boolean apply(@e0 T t10) {
            try {
                return this.target.contains(t10);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // c1.i0
        public boolean equals(@gm.a Object obj) {
            if (obj instanceof f) {
                return this.target.equals(((f) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }

        public f(Collection<?> target) {
            target.getClass();
            this.target = target;
        }
    }

    @b1.c
    public static class g<T> implements i0<T>, Serializable {

        @b1.d
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        @Override // c1.i0
        public boolean apply(@e0 T o10) {
            return this.clazz.isInstance(o10);
        }

        @Override // c1.i0
        public boolean equals(@gm.a Object obj) {
            return (obj instanceof g) && this.clazz == ((g) obj).clazz;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.clazz.getName() + ")";
        }

        public g(Class<?> clazz) {
            clazz.getClass();
            this.clazz = clazz;
        }
    }

    public static class h implements i0<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Object target;

        @Override // c1.i0
        public boolean apply(@gm.a Object o10) {
            return this.target.equals(o10);
        }

        @Override // c1.i0
        public boolean equals(@gm.a Object obj) {
            if (obj instanceof h) {
                return this.target.equals(((h) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return j.e.a(new StringBuilder("Predicates.equalTo("), this.target, ")");
        }

        public <T> i0<T> withNarrowedType() {
            return this;
        }

        public h(Object target) {
            this.target = target;
        }
    }

    public static class i<T> implements i0<T>, Serializable {
        private static final long serialVersionUID = 0;
        final i0<T> predicate;

        public i(i0<T> predicate) {
            predicate.getClass();
            this.predicate = predicate;
        }

        @Override // c1.i0
        public boolean apply(@e0 T t10) {
            return !this.predicate.apply(t10);
        }

        @Override // c1.i0
        public boolean equals(@gm.a Object obj) {
            if (obj instanceof i) {
                return this.predicate.equals(((i) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class j implements i0<Object> {
        public static final j ALWAYS_TRUE = new a("ALWAYS_TRUE", 0);
        public static final j ALWAYS_FALSE = new b("ALWAYS_FALSE", 1);
        public static final j IS_NULL = new c("IS_NULL", 2);
        public static final j NOT_NULL = new d("NOT_NULL", 3);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ j[] f1194a = a();

        public final enum a extends j {
            public a(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // c1.i0
            public boolean apply(@gm.a Object o10) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        }

        public final enum b extends j {
            public b(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // c1.i0
            public boolean apply(@gm.a Object o10) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        }

        public final enum c extends j {
            public c(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // c1.i0
            public boolean apply(@gm.a Object o10) {
                return o10 == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        }

        public final enum d extends j {
            public d(String $enum$name, int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }

            @Override // c1.i0
            public boolean apply(@gm.a Object o10) {
                return o10 != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        }

        public j(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static /* synthetic */ j[] a() {
            return new j[]{ALWAYS_TRUE, ALWAYS_FALSE, IS_NULL, NOT_NULL};
        }

        public static j valueOf(String name) {
            return (j) Enum.valueOf(j.class, name);
        }

        public static j[] values() {
            return (j[]) f1194a.clone();
        }

        public <T> i0<T> withNarrowedType() {
            return this;
        }

        public j(String str, int i10, a aVar) {
            super(str, i10);
        }
    }

    public static class k<T> implements i0<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends i0<? super T>> components;

        @Override // c1.i0
        public boolean apply(@e0 T t10) {
            for (int i10 = 0; i10 < this.components.size(); i10++) {
                if (this.components.get(i10).apply(t10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // c1.i0
        public boolean equals(@gm.a Object obj) {
            if (obj instanceof k) {
                return this.components.equals(((k) obj).components);
            }
            return false;
        }

        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        public String toString() {
            return j0.w("or", this.components);
        }

        public k(List<? extends i0<? super T>> components) {
            this.components = components;
        }
    }

    @b1.c
    @b1.d
    public static class l implements i0<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        @Override // c1.i0
        public boolean equals(@gm.a Object obj) {
            return (obj instanceof l) && this.clazz == ((l) obj).clazz;
        }

        public int hashCode() {
            return this.clazz.hashCode();
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.clazz.getName() + ")";
        }

        public l(Class<?> clazz) {
            clazz.getClass();
            this.clazz = clazz;
        }

        @Override // c1.i0
        public boolean apply(Class<?> input) {
            return this.clazz.isAssignableFrom(input);
        }
    }

    @b1.b(serializable = true)
    public static <T> i0<T> b() {
        return j.ALWAYS_FALSE.withNarrowedType();
    }

    @b1.b(serializable = true)
    public static <T> i0<T> c() {
        return j.ALWAYS_TRUE.withNarrowedType();
    }

    public static <T> i0<T> d(i0<? super T> first, i0<? super T> second) {
        first.getClass();
        second.getClass();
        return new b(g(first, second));
    }

    public static <T> i0<T> e(Iterable<? extends i0<? super T>> components) {
        return new b(k(components));
    }

    @SafeVarargs
    public static <T> i0<T> f(i0<? super T>... components) {
        return new b(l(components));
    }

    public static <T> List<i0<? super T>> g(i0<? super T> first, i0<? super T> second) {
        return Arrays.asList(first, second);
    }

    public static <A, B> i0<A> h(i0<B> predicate, t<A, ? extends B> function) {
        return new c(predicate, function);
    }

    @b1.c("java.util.regex.Pattern")
    @b1.d
    public static i0<CharSequence> i(Pattern pattern) {
        return new e(new x(pattern));
    }

    @b1.c
    @b1.d
    public static i0<CharSequence> j(String pattern) {
        return new d(pattern);
    }

    public static <T> List<T> k(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T t10 : iterable) {
            t10.getClass();
            arrayList.add(t10);
        }
        return arrayList;
    }

    public static <T> List<T> l(T... array) {
        return k(Arrays.asList(array));
    }

    public static <T> i0<T> m(@e0 T target) {
        return target == null ? j.IS_NULL.withNarrowedType() : new h(target).withNarrowedType();
    }

    public static <T> i0<T> n(Collection<? extends T> target) {
        return new f(target);
    }

    @b1.c
    public static <T> i0<T> o(Class<?> clazz) {
        return new g(clazz);
    }

    @b1.b(serializable = true)
    public static <T> i0<T> p() {
        return j.IS_NULL.withNarrowedType();
    }

    public static <T> i0<T> q(i0<T> predicate) {
        return new i(predicate);
    }

    @b1.b(serializable = true)
    public static <T> i0<T> r() {
        return j.NOT_NULL.withNarrowedType();
    }

    public static <T> i0<T> s(i0<? super T> first, i0<? super T> second) {
        first.getClass();
        second.getClass();
        return new k(g(first, second));
    }

    public static <T> i0<T> t(Iterable<? extends i0<? super T>> components) {
        return new k(k(components));
    }

    @SafeVarargs
    public static <T> i0<T> u(i0<? super T>... components) {
        return new k(l(components));
    }

    @b1.c
    @b1.d
    public static i0<Class<?>> v(Class<?> clazz) {
        return new l(clazz);
    }

    public static String w(String methodName, Iterable<?> components) {
        StringBuilder sb2 = new StringBuilder("Predicates.");
        sb2.append(methodName);
        sb2.append('(');
        boolean z10 = true;
        for (Object obj : components) {
            if (!z10) {
                sb2.append(StringUtil.COMMA);
            }
            sb2.append(obj);
            z10 = false;
        }
        sb2.append(')');
        return sb2.toString();
    }
}
