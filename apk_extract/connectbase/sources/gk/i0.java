package gk;

import androidx.core.app.NotificationCompat;
import ik.l1;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import lm.l2;
import wj.h2;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f6644c = 31536000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f6646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final b f6643b = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final fl.b<i0> f6645d = new fl.b<>("HSTS");

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f6647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6648b = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f6649c = i0.f6644c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final Map<String, String> f6650d = new HashMap();

        @lm.k(level = lm.m.HIDDEN, message = "Use maxAgeInSeconds or maxAgeDuration instead.")
        public static /* synthetic */ void d() {
        }

        @os.l
        public final Map<String, String> a() {
            return this.f6650d;
        }

        public final boolean b() {
            return this.f6648b;
        }

        public final /* synthetic */ Duration c() {
            return l0.b(this);
        }

        public final long e() {
            return this.f6649c;
        }

        public final boolean f() {
            return this.f6647a;
        }

        public final void g(boolean z10) {
            this.f6648b = z10;
        }

        public final /* synthetic */ void h(Duration duration) {
            kn.l0.p(duration, "newDuration");
            l0.f(this, duration);
        }

        public final void i(long j10) {
            if (j10 < 0) {
                throw new IllegalStateException(kn.l0.C("maxAgeInSeconds shouldn't be negative: ", Long.valueOf(j10)).toString());
            }
            this.f6649c = j10;
        }

        public final void j(boolean z10) {
            this.f6647a = z10;
        }
    }

    public static final class b implements dk.h<dk.c, a, i0> {

        @xm.f(c = "io.ktor.features.HSTS$Feature$install$1", f = "HSTS.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ i0 $feature;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(i0 i0Var, um.d<? super a> dVar) {
                super(3, dVar);
                this.$feature = i0Var;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
                this.$feature.d((dk.b) ((nl.f) this.L$0).getContext());
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

        public b() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i0 a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar = new a();
            lVar.invoke(aVar);
            i0 i0Var = new i0(aVar);
            dk.c.f3706v.getClass();
            cVar.x(dk.c.f3709y, new a(i0Var, null));
            return i0Var;
        }

        @Override // dk.h
        @os.l
        public fl.b<i0> getKey() {
            return i0.f6645d;
        }

        public b(kn.w wVar) {
        }
    }

    public static final class c extends kn.n0 implements jn.l<Map.Entry<String, String>, CharSequence> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final CharSequence invoke(@os.l Map.Entry<String, String> entry) {
            kn.l0.p(entry, "it");
            if (entry.getValue() == null) {
                return ik.a0.d(entry.getKey());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ik.a0.d(entry.getKey()));
            sb2.append(fl.h.f6043c);
            String value = entry.getValue();
            sb2.append((Object) (value == null ? null : ik.a0.d(value)));
            return sb2.toString();
        }
    }

    public i0(@os.l a aVar) throws IOException {
        kn.l0.p(aVar, "config");
        StringBuilder sbA = k.a.a("max-age=");
        sbA.append(aVar.f6649c);
        if (aVar.f6648b) {
            sbA.append("; includeSubDomains");
        }
        if (aVar.f6647a) {
            sbA.append("; preload");
        }
        if (!aVar.f6650d.isEmpty()) {
            nm.h0.j3(aVar.f6650d.entrySet(), sbA, (y5.a.f20716e0 & 2) != 0 ? ", " : "; ", (y5.a.f20716e0 & 4) != 0 ? "" : "; ", (y5.a.f20716e0 & 8) == 0 ? null : "", (y5.a.f20716e0 & 16) != 0 ? -1 : 0, (y5.a.f20716e0 & 32) != 0 ? "..." : null, (y5.a.f20716e0 & 64) != 0 ? null : c.INSTANCE);
        }
        String string = sbA.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        this.f6646a = string;
    }

    public static /* synthetic */ void c() {
    }

    @os.l
    public final String b() {
        return this.f6646a;
    }

    public final void d(@os.l dk.b bVar) {
        kn.l0.p(bVar, NotificationCompat.CATEGORY_CALL);
        l1 l1VarE = u0.e(bVar.d());
        if (kn.l0.g(l1VarE.d(), h2.f18719h) && l1VarE.a() == 443) {
            vk.a aVarE = bVar.e();
            ik.j0.f8048a.getClass();
            vk.c.m(aVarE, ik.j0.f8087t0, this.f6646a);
        }
    }
}
