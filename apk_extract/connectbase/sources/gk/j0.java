package gk;

import androidx.core.app.NotificationCompat;
import fl.v1;
import ik.n1;
import ik.t1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final b f6651d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final fl.b<j0> f6652e = new fl.b<>("HttpsRedirect");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final List<jn.l<dk.b, Boolean>> f6655c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f6657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final List<jn.l<dk.b, Boolean>> f6658c;

        /* JADX INFO: renamed from: gk.j0$a$a, reason: collision with other inner class name */
        public static final class C0167a extends kn.n0 implements jn.l<dk.b, Boolean> {
            final /* synthetic */ String $pathPrefix;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0167a(String str) {
                super(1);
                this.$pathPrefix = str;
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l dk.b bVar) {
                kn.l0.p(bVar, NotificationCompat.CATEGORY_CALL);
                return Boolean.valueOf(jq.e0.s2(u0.e(bVar.d()).getUri(), this.$pathPrefix, false, 2, null));
            }
        }

        public static final class b extends kn.n0 implements jn.l<dk.b, Boolean> {
            final /* synthetic */ String $pathSuffix;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.$pathSuffix = str;
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l dk.b bVar) {
                kn.l0.p(bVar, NotificationCompat.CATEGORY_CALL);
                return Boolean.valueOf(jq.e0.J1(u0.e(bVar.d()).getUri(), this.$pathSuffix, false, 2, null));
            }
        }

        public a() {
            t1.f8189c.getClass();
            this.f6656a = t1.f8191e.f8197b;
            this.f6657b = true;
            this.f6658c = new ArrayList();
        }

        public final void a(@os.l jn.l<? super dk.b, Boolean> lVar) {
            kn.l0.p(lVar, "predicate");
            this.f6658c.add(lVar);
        }

        public final void b(@os.l String str) {
            kn.l0.p(str, "pathPrefix");
            a(new C0167a(str));
        }

        public final void c(@os.l String str) {
            kn.l0.p(str, "pathSuffix");
            a(new b(str));
        }

        @os.l
        public final List<jn.l<dk.b, Boolean>> d() {
            return this.f6658c;
        }

        public final boolean e() {
            return this.f6657b;
        }

        public final int f() {
            return this.f6656a;
        }

        public final void g(boolean z10) {
            this.f6657b = z10;
        }

        public final void h(int i10) {
            this.f6656a = i10;
        }
    }

    public static final class b implements dk.h<dk.c, a, j0> {

        @xm.f(c = "io.ktor.features.HttpsRedirect$Feature$install$1", f = "HttpsRedirect.kt", i = {0}, l = {90}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
        public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ j0 $feature;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(j0 j0Var, um.d<? super a> dVar) {
                super(3, dVar);
                this.$feature = j0Var;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                nl.f fVar;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    nl.f fVar2 = (nl.f) this.L$0;
                    if (kn.l0.g(u0.e(((dk.b) fVar2.getContext()).d()).d(), "http")) {
                        List<jn.l<dk.b, Boolean>> list = this.$feature.f6655c;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                if (((Boolean) ((jn.l) it.next()).invoke((dk.b) fVar2.getContext())).booleanValue()) {
                                }
                            }
                        }
                        dk.b bVar = (dk.b) fVar2.getContext();
                        j0 j0Var = this.$feature;
                        n1 n1VarA = v1.a(n1.f8120j, bVar);
                        t1.f8189c.getClass();
                        n1VarA.t(t1.f8191e);
                        n1VarA.f8123c = j0Var.f6653a;
                        String strC = n1VarA.c();
                        dk.b bVar2 = (dk.b) fVar2.getContext();
                        boolean z10 = this.$feature.f6654b;
                        this.L$0 = fVar2;
                        this.label = 1;
                        if (vk.b.r(bVar2, strC, z10, this) == aVar) {
                            return aVar;
                        }
                        fVar = fVar2;
                    }
                    return l2.f10208a;
                }
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                fVar = (nl.f) this.L$0;
                lm.d1.n(obj);
                fVar.finish();
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
        public j0 a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar = new a();
            lVar.invoke(aVar);
            j0 j0Var = new j0(aVar);
            dk.c.f3706v.getClass();
            cVar.x(dk.c.f3709y, new a(j0Var, null));
            return j0Var;
        }

        @Override // dk.h
        @os.l
        public fl.b<j0> getKey() {
            return j0.f6652e;
        }

        public b(kn.w wVar) {
        }
    }

    public j0(@os.l a aVar) {
        kn.l0.p(aVar, "config");
        this.f6653a = aVar.f6656a;
        this.f6654b = aVar.f6657b;
        this.f6655c = nm.h0.V5(aVar.f6658c);
    }

    @os.l
    public final List<jn.l<dk.b, Boolean>> b() {
        return this.f6655c;
    }

    public final boolean c() {
        return this.f6654b;
    }

    public final int d() {
        return this.f6653a;
    }
}
