package gk;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final c f6530d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6531e = 1000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final TimeZone f6532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final b f6533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final fl.b<b0> f6534h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ik.b0 f6535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.a<Long> f6536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f6537c;

    @os.l
    private volatile /* synthetic */ Object cachedDateText;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final ik.c0 f6538a = new ik.c0(0, 1, null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public jn.a<Long> f6539b = C0160a.INSTANCE;

        /* JADX INFO: renamed from: gk.b0$a$a, reason: collision with other inner class name */
        public static final class C0160a extends kn.n0 implements jn.a<Long> {
            public static final C0160a INSTANCE = new C0160a();

            public C0160a() {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // jn.a
            @os.l
            public final Long invoke() {
                return Long.valueOf(System.currentTimeMillis());
            }
        }

        @fl.t0
        public static /* synthetic */ void b() {
        }

        @os.l
        public final jn.a<Long> a() {
            return this.f6539b;
        }

        @os.l
        public final ik.c0 c() {
            return this.f6538a;
        }

        public final void d(@os.l String str, @os.l String str2) {
            kn.l0.p(str, "name");
            kn.l0.p(str2, "value");
            this.f6538a.a(str, str2);
        }

        public final void e(@os.l jn.a<Long> aVar) {
            kn.l0.p(aVar, "<set-?>");
            this.f6539b = aVar;
        }
    }

    public static final class b extends ThreadLocal<Calendar> {
        @Override // java.lang.ThreadLocal
        @os.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Calendar initialValue() {
            Calendar calendar = Calendar.getInstance(b0.f6532f, Locale.ROOT);
            kn.l0.o(calendar, "getInstance(GMT_TIMEZONE, Locale.ROOT)");
            return calendar;
        }
    }

    public static final class c implements dk.h<dk.a, a, b0> {

        @xm.f(c = "io.ktor.features.DefaultHeaders$Feature$install$1", f = "DefaultHeaders.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ b0 $feature;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b0 b0Var, um.d<? super a> dVar) {
                super(3, dVar);
                this.$feature = b0Var;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
                this.$feature.e((dk.b) ((nl.f) this.L$0).getContext());
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
                a aVar = new a(this.$feature, dVar);
                aVar.L$0 = fVar;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public c() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b0 a(@os.l dk.a aVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(aVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar2 = new a();
            lVar.invoke(aVar2);
            ik.c0 c0Var = aVar2.f6538a;
            ik.j0 j0Var = ik.j0.f8048a;
            j0Var.getClass();
            String str = ik.j0.f8081q0;
            if (c0Var.m(str) == null) {
                String implementationTitle = dk.a.class.getPackage().getImplementationTitle();
                if (implementationTitle == null) {
                    implementationTitle = "Ktor";
                }
                String implementationVersion = dk.a.class.getPackage().getImplementationVersion();
                if (implementationVersion == null) {
                    implementationVersion = "debug";
                }
                ik.c0 c0Var2 = aVar2.f6538a;
                j0Var.getClass();
                c0Var2.a(str, implementationTitle + el.b0.f4502a + implementationVersion);
            }
            b0 b0Var = new b0(aVar2);
            dk.c.f3706v.getClass();
            aVar.x(dk.c.f3709y, new a(b0Var, null));
            return b0Var;
        }

        @Override // dk.h
        @os.l
        public fl.b<b0> getKey() {
            return b0.f6534h;
        }

        public c(kn.w wVar) {
        }
    }

    public static final class d extends kn.n0 implements jn.p<String, List<? extends String>, l2> {
        final /* synthetic */ dk.b $call;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(dk.b bVar) {
            super(2);
            this.$call = bVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(String str, List<? extends String> list) {
            invoke2(str, (List<String>) list);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l String str, @os.l List<String> list) {
            kn.l0.p(str, "name");
            kn.l0.p(list, "value");
            dk.b bVar = this.$call;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                vk.c.m(bVar.e(), str, (String) it.next());
            }
        }
    }

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        kn.l0.m(timeZone);
        f6532f = timeZone;
        f6533g = new b();
        f6534h = new fl.b<>("Default Headers");
    }

    public b0(@os.l a aVar) {
        kn.l0.p(aVar, "config");
        this.f6535a = aVar.f6538a.f();
        this.f6536b = aVar.f6539b;
        this.cachedDateText = "";
    }

    public final void d(dk.b bVar) {
        long j10 = this.f6537c;
        long jLongValue = this.f6536b.invoke().longValue();
        if (j10 + ((long) 1000) <= jLongValue) {
            this.f6537c = jLongValue;
            this.cachedDateText = ik.r.e(f(jLongValue));
        }
        vk.a aVarE = bVar.e();
        ik.j0.f8048a.getClass();
        vk.c.m(aVarE, ik.j0.f8092w, (String) this.cachedDateText);
    }

    public final void e(dk.b bVar) {
        d(bVar);
        this.f6535a.e(new d(bVar));
    }

    public final kl.d f(long j10) {
        Calendar calendar = f6533g.get();
        kn.l0.o(calendar, "calendar.get()");
        return kl.a.e(calendar, Long.valueOf(j10));
    }
}
