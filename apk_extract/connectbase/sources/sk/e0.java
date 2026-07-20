package sk;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final b f15113e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final Map<Object, Object> f15114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f15115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15117d;

    public static final class a extends e0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15118f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@os.l Map<Object, Object> map) {
            super(map);
            kn.l0.p(map, "customOptions");
            this.f15118f = FrameMetricsAggregator.EVERY_DURATION;
        }

        @Override // sk.e0
        @os.l
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public a b() {
            a aVar = new a(new HashMap(this.f15114a));
            aVar.c(this);
            return aVar;
        }

        public final int m() {
            return this.f15118f;
        }

        public final void n(int i10) {
            this.f15118f = i10;
        }
    }

    public static final class b {
        public b() {
        }

        @os.l
        public final e0 a() {
            return new c(new HashMap());
        }

        public b(kn.w wVar) {
        }
    }

    public static final class c extends e0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@os.l Map<Object, Object> map) {
            super(map);
            kn.l0.p(map, "customOptions");
        }

        @Override // sk.e0
        @os.l
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public c b() {
            c cVar = new c(new HashMap(this.f15114a));
            cVar.c(this);
            return cVar;
        }
    }

    public static class d extends e0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f15119f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f15120g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(@os.l Map<Object, Object> map) {
            super(map);
            kn.l0.p(map, "customOptions");
            this.f15119f = -1;
            this.f15120g = -1;
        }

        @Override // sk.e0
        public void c(@os.l e0 e0Var) {
            kn.l0.p(e0Var, TypedValues.TransitionType.S_FROM);
            super.c(e0Var);
            if (e0Var instanceof d) {
                d dVar = (d) e0Var;
                this.f15119f = dVar.f15119f;
                this.f15120g = dVar.f15120g;
            }
        }

        @Override // sk.e0
        @os.l
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public d b() {
            d dVar = new d(new HashMap(this.f15114a));
            dVar.c(this);
            return dVar;
        }

        public final int m() {
            return this.f15120g;
        }

        public final int n() {
            return this.f15119f;
        }

        public final void o(int i10) {
            this.f15120g = i10;
        }

        public final void p(int i10) {
            this.f15119f = i10;
        }

        @os.l
        public final e q() {
            e eVar = new e(new HashMap(this.f15114a));
            c(this);
            return eVar;
        }

        @os.l
        public final f r() {
            f fVar = new f(new HashMap(this.f15114a));
            c(this);
            return fVar;
        }
    }

    public static final class e extends d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f15121h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f15122i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @os.m
        public Boolean f15123j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public long f15124k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@os.l Map<Object, Object> map) {
            super(map);
            kn.l0.p(map, "customOptions");
            this.f15121h = true;
            this.f15122i = -1;
            this.f15124k = Long.MAX_VALUE;
        }

        public final void A(long j10) {
            this.f15124k = j10;
        }

        @Override // sk.e0.d, sk.e0
        public void c(@os.l e0 e0Var) {
            kn.l0.p(e0Var, TypedValues.TransitionType.S_FROM);
            super.c(e0Var);
            if (e0Var instanceof e) {
                e eVar = (e) e0Var;
                this.f15121h = eVar.f15121h;
                this.f15122i = eVar.f15122i;
                this.f15123j = eVar.f15123j;
            }
        }

        @Override // sk.e0.d
        @os.l
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public e b() {
            e eVar = new e(new HashMap(this.f15114a));
            eVar.c(this);
            return eVar;
        }

        @os.m
        public final Boolean t() {
            return this.f15123j;
        }

        public final int u() {
            return this.f15122i;
        }

        public final boolean v() {
            return this.f15121h;
        }

        public final long w() {
            return this.f15124k;
        }

        public final void x(@os.m Boolean bool) {
            this.f15123j = bool;
        }

        public final void y(int i10) {
            this.f15122i = i10;
        }

        public final void z(boolean z10) {
            this.f15121h = z10;
        }
    }

    public static final class f extends d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f15125h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(@os.l Map<Object, Object> map) {
            super(map);
            kn.l0.p(map, "customOptions");
        }

        @Override // sk.e0.d, sk.e0
        public void c(@os.l e0 e0Var) {
            kn.l0.p(e0Var, TypedValues.TransitionType.S_FROM);
            super.c(e0Var);
            if (e0Var instanceof f) {
                this.f15125h = ((f) e0Var).f15125h;
            }
        }

        @Override // sk.e0.d
        @os.l
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public f b() {
            f fVar = new f(new HashMap(this.f15114a));
            fVar.c(this);
            return fVar;
        }

        public final boolean t() {
            return this.f15125h;
        }

        public final void u(boolean z10) {
            this.f15125h = z10;
        }
    }

    public /* synthetic */ e0(Map map, kn.w wVar) {
        this(map);
    }

    @os.l
    public final a a() {
        a aVar = new a(new HashMap(this.f15114a));
        aVar.c(this);
        return aVar;
    }

    @os.l
    public abstract e0 b();

    public void c(@os.l e0 e0Var) {
        kn.l0.p(e0Var, TypedValues.TransitionType.S_FROM);
        this.f15115b = e0Var.f15115b;
        this.f15116c = e0Var.f15116c;
        this.f15117d = e0Var.f15117d;
    }

    @os.l
    public final Map<Object, Object> d() {
        return this.f15114a;
    }

    public final boolean e() {
        return this.f15116c;
    }

    public final boolean f() {
        return this.f15117d;
    }

    public final byte g() {
        return this.f15115b;
    }

    @os.l
    public final d h() {
        d dVar = new d(new HashMap(this.f15114a));
        c(this);
        return dVar;
    }

    public final void i(boolean z10) {
        this.f15116c = z10;
    }

    public final void j(boolean z10) {
        this.f15117d = z10;
    }

    public final void k(byte b10) {
        this.f15115b = b10;
    }

    public e0(Map<Object, Object> map) {
        this.f15114a = map;
        l0.f15134b.getClass();
        this.f15115b = l0.f15135c;
    }
}
