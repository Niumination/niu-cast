package e1;

import c1.g0;
import c1.h0;
import c1.m0;
import f1.i3;
import f1.k3;
import io.netty.util.internal.StringUtil;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@e1.i
public final class e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final m0 f3912o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final m0 f3913p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final k3<String, m> f3914q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.a
    @b1.e
    public Integer f3915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    @b1.e
    public Long f3916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.a
    @b1.e
    public Long f3917c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @gm.a
    @b1.e
    public Integer f3918d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @gm.a
    @b1.e
    public e1.m.t f3919e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @gm.a
    @b1.e
    public e1.m.t f3920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @gm.a
    @b1.e
    public Boolean f3921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @b1.e
    public long f3922h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @gm.a
    @b1.e
    public TimeUnit f3923i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @b1.e
    public long f3924j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @gm.a
    @b1.e
    public TimeUnit f3925k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @b1.e
    public long f3926l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @gm.a
    @b1.e
    public TimeUnit f3927m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f3928n;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3929a;

        static {
            int[] iArr = new int[e1.m.t.values().length];
            f3929a = iArr;
            try {
                iArr[e1.m.t.WEAK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3929a[e1.m.t.SOFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class b extends d {
        @Override // e1.e.d
        public void b(e spec, long duration, TimeUnit unit) {
            h0.e(spec.f3925k == null, "expireAfterAccess already set");
            spec.f3924j = duration;
            spec.f3925k = unit;
        }
    }

    public static class c extends f {
        @Override // e1.e.f
        public void b(e spec, int value) {
            Integer num = spec.f3918d;
            h0.u(num == null, "concurrency level was already set to %s", num);
            spec.f3918d = Integer.valueOf(value);
        }
    }

    public static abstract class d implements m {
        @Override // e1.e.m
        public void a(e spec, String key, @gm.a String value) {
            TimeUnit timeUnit;
            if (g0.j(value)) {
                throw new IllegalArgumentException(n.a.a("value of key ", key, " omitted"));
            }
            try {
                char cCharAt = value.charAt(value.length() - 1);
                if (cCharAt == 'd') {
                    timeUnit = TimeUnit.DAYS;
                } else if (cCharAt == 'h') {
                    timeUnit = TimeUnit.HOURS;
                } else if (cCharAt == 'm') {
                    timeUnit = TimeUnit.MINUTES;
                } else {
                    if (cCharAt != 's') {
                        throw new IllegalArgumentException(e.a("key %s invalid unit: was %s, must end with one of [dhms]", new Object[]{key, value}));
                    }
                    timeUnit = TimeUnit.SECONDS;
                }
                b(spec, Long.parseLong(value.substring(0, value.length() - 1)), timeUnit);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(e.a("key %s value set to %s, must be integer", new Object[]{key, value}));
            }
        }

        public abstract void b(e spec, long duration, TimeUnit unit);
    }

    /* JADX INFO: renamed from: e1.e$e, reason: collision with other inner class name */
    public static class C0091e extends f {
        @Override // e1.e.f
        public void b(e spec, int value) {
            Integer num = spec.f3915a;
            h0.u(num == null, "initial capacity was already set to %s", num);
            spec.f3915a = Integer.valueOf(value);
        }
    }

    public static abstract class f implements m {
        @Override // e1.e.m
        public void a(e spec, String key, String value) {
            if (g0.j(value)) {
                throw new IllegalArgumentException(n.a.a("value of key ", key, " omitted"));
            }
            try {
                b(spec, Integer.parseInt(value));
            } catch (NumberFormatException e10) {
                throw new IllegalArgumentException(e.a("key %s value set to %s, must be integer", new Object[]{key, value}), e10);
            }
        }

        public abstract void b(e spec, int value);
    }

    public static class g implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e1.m.t f3930a;

        public g(e1.m.t strength) {
            this.f3930a = strength;
        }

        @Override // e1.e.m
        public void a(e spec, String key, @gm.a String value) {
            h0.u(value == null, "key %s does not take values", key);
            e1.m.t tVar = spec.f3919e;
            h0.y(tVar == null, "%s was already set to %s", key, tVar);
            spec.f3919e = this.f3930a;
        }
    }

    public static abstract class h implements m {
        @Override // e1.e.m
        public void a(e spec, String key, String value) {
            if (g0.j(value)) {
                throw new IllegalArgumentException(n.a.a("value of key ", key, " omitted"));
            }
            try {
                b(spec, Long.parseLong(value));
            } catch (NumberFormatException e10) {
                throw new IllegalArgumentException(e.a("key %s value set to %s, must be integer", new Object[]{key, value}), e10);
            }
        }

        public abstract void b(e spec, long value);
    }

    public static class i extends h {
        @Override // e1.e.h
        public void b(e spec, long value) {
            Long l10 = spec.f3916b;
            h0.u(l10 == null, "maximum size was already set to %s", l10);
            Long l11 = spec.f3917c;
            h0.u(l11 == null, "maximum weight was already set to %s", l11);
            spec.f3916b = Long.valueOf(value);
        }
    }

    public static class j extends h {
        @Override // e1.e.h
        public void b(e spec, long value) {
            Long l10 = spec.f3917c;
            h0.u(l10 == null, "maximum weight was already set to %s", l10);
            Long l11 = spec.f3916b;
            h0.u(l11 == null, "maximum size was already set to %s", l11);
            spec.f3917c = Long.valueOf(value);
        }
    }

    public static class k implements m {
        @Override // e1.e.m
        public void a(e spec, String key, @gm.a String value) {
            h0.e(value == null, "recordStats does not take values");
            h0.e(spec.f3921g == null, "recordStats already set");
            spec.f3921g = Boolean.TRUE;
        }
    }

    public static class l extends d {
        @Override // e1.e.d
        public void b(e spec, long duration, TimeUnit unit) {
            h0.e(spec.f3927m == null, "refreshAfterWrite already set");
            spec.f3926l = duration;
            spec.f3927m = unit;
        }
    }

    public interface m {
        void a(e spec, String key, @gm.a String value);
    }

    public static class n implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e1.m.t f3931a;

        public n(e1.m.t strength) {
            this.f3931a = strength;
        }

        @Override // e1.e.m
        public void a(e spec, String key, @gm.a String value) {
            h0.u(value == null, "key %s does not take values", key);
            e1.m.t tVar = spec.f3920f;
            h0.y(tVar == null, "%s was already set to %s", key, tVar);
            spec.f3920f = this.f3931a;
        }
    }

    public static class o extends d {
        @Override // e1.e.d
        public void b(e spec, long duration, TimeUnit unit) {
            h0.e(spec.f3923i == null, "expireAfterWrite already set");
            spec.f3922h = duration;
            spec.f3923i = unit;
        }
    }

    static {
        m0 m0VarH = m0.h(StringUtil.COMMA);
        m0VarH.getClass();
        c1.e.c0 c0Var = c1.e.c0.f1149f;
        f3912o = m0VarH.r(c0Var);
        m0 m0VarH2 = m0.h(fl.h.f6043c);
        m0VarH2.getClass();
        f3913p = m0VarH2.r(c0Var);
        k3.b bVarI = k3.builder().i("initialCapacity", new C0091e()).i("maximumSize", new i()).i("maximumWeight", new j()).i("concurrencyLevel", new c());
        e1.m.t tVar = e1.m.t.WEAK;
        f3914q = bVarI.i("weakKeys", new g(tVar)).i("softValues", new n(e1.m.t.SOFT)).i("weakValues", new n(tVar)).i("recordStats", new k()).i("expireAfterAccess", new b()).i("expireAfterWrite", new o()).i("refreshAfterWrite", new l()).i("refreshInterval", new l()).d();
    }

    public e(String specification) {
        this.f3928n = specification;
    }

    public static String a(String str, Object[] objArr) {
        return String.format(Locale.ROOT, str, objArr);
    }

    public static e b() {
        return e("maximumSize=0");
    }

    @gm.a
    public static Long c(long duration, @gm.a TimeUnit unit) {
        if (unit == null) {
            return null;
        }
        return Long.valueOf(unit.toNanos(duration));
    }

    public static String d(String format, Object... args) {
        return String.format(Locale.ROOT, format, args);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e e(String cacheBuilderSpecification) {
        e eVar = new e(cacheBuilderSpecification);
        if (!cacheBuilderSpecification.isEmpty()) {
            for (String str : f3912o.n(cacheBuilderSpecification)) {
                i3 i3VarCopyOf = i3.copyOf(f3913p.n(str));
                h0.e(!i3VarCopyOf.isEmpty(), "blank key-value pair");
                h0.u(i3VarCopyOf.size() <= 2, "key-value pair %s with more than one equals sign", str);
                String str2 = (String) i3VarCopyOf.get(0);
                m mVar = f3914q.get(str2);
                h0.u(mVar != null, "unknown key %s", str2);
                mVar.a(eVar, str2, i3VarCopyOf.size() == 1 ? null : (String) i3VarCopyOf.get(1));
            }
        }
        return eVar;
    }

    public boolean equals(@gm.a Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return c1.b0.a(this.f3915a, eVar.f3915a) && c1.b0.a(this.f3916b, eVar.f3916b) && c1.b0.a(this.f3917c, eVar.f3917c) && c1.b0.a(this.f3918d, eVar.f3918d) && c1.b0.a(this.f3919e, eVar.f3919e) && c1.b0.a(this.f3920f, eVar.f3920f) && c1.b0.a(this.f3921g, eVar.f3921g) && c1.b0.a(c(this.f3922h, this.f3923i), c(eVar.f3922h, eVar.f3923i)) && c1.b0.a(c(this.f3924j, this.f3925k), c(eVar.f3924j, eVar.f3925k)) && c1.b0.a(c(this.f3926l, this.f3927m), c(eVar.f3926l, eVar.f3927m));
    }

    public e1.d<Object, Object> f() {
        e1.d<Object, Object> dVarD = e1.d.D();
        Integer num = this.f3915a;
        if (num != null) {
            dVarD.x(num.intValue());
        }
        Long l10 = this.f3916b;
        if (l10 != null) {
            dVarD.B(l10.longValue());
        }
        Long l11 = this.f3917c;
        if (l11 != null) {
            dVarD.C(l11.longValue());
        }
        Integer num2 = this.f3918d;
        if (num2 != null) {
            dVarD.e(num2.intValue());
        }
        e1.m.t tVar = this.f3919e;
        if (tVar != null) {
            if (a.f3929a[tVar.ordinal()] != 1) {
                throw new AssertionError();
            }
            dVarD.M();
        }
        e1.m.t tVar2 = this.f3920f;
        if (tVar2 != null) {
            int i10 = a.f3929a[tVar2.ordinal()];
            if (i10 == 1) {
                dVarD.N();
            } else {
                if (i10 != 2) {
                    throw new AssertionError();
                }
                dVarD.J();
            }
        }
        Boolean bool = this.f3921g;
        if (bool != null && bool.booleanValue()) {
            dVarD.f3908p = e1.d.f3890w;
        }
        TimeUnit timeUnit = this.f3923i;
        if (timeUnit != null) {
            dVarD.g(this.f3922h, timeUnit);
        }
        TimeUnit timeUnit2 = this.f3925k;
        if (timeUnit2 != null) {
            dVarD.f(this.f3924j, timeUnit2);
        }
        TimeUnit timeUnit3 = this.f3927m;
        if (timeUnit3 != null) {
            dVarD.F(this.f3926l, timeUnit3);
        }
        return dVarD;
    }

    public String g() {
        return this.f3928n;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3915a, this.f3916b, this.f3917c, this.f3918d, this.f3919e, this.f3920f, this.f3921g, c(this.f3922h, this.f3923i), c(this.f3924j, this.f3925k), c(this.f3926l, this.f3927m)});
    }

    public String toString() {
        c1.z.b bVarC = c1.z.c(this);
        bVarC.h().f1270b = this.f3928n;
        return bVarC.toString();
    }
}
