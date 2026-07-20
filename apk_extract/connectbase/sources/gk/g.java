package gk;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import kn.l1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final b f6599d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final nl.j f6600e = new nl.j("CallId");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final fl.b<String> f6601f = new fl.b<>("ExtractedCallId");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final fl.b<g> f6602g = new fl.b<>("CallId");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final lm.d0<ps.a> f6603h = lm.f0.b(c.INSTANCE);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final jn.l<dk.b, String>[] f6604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final jn.p<dk.b, String, l2>[] f6605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.l<String, Boolean> f6606c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final ArrayList<jn.l<dk.b, String>> f6607a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final ArrayList<jn.l<dk.b, String>> f6608b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final ArrayList<jn.p<dk.b, String, l2>> f6609c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public jn.l<? super String, Boolean> f6610d = c.INSTANCE;

        /* JADX INFO: renamed from: gk.g$a$a, reason: collision with other inner class name */
        public static final class C0164a extends kn.n0 implements jn.p<dk.b, String, l2> {
            final /* synthetic */ String $headerName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0164a(String str) {
                super(2);
                this.$headerName = str;
            }

            @Override // jn.p
            public /* bridge */ /* synthetic */ l2 invoke(dk.b bVar, String str) {
                invoke2(bVar, str);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.l dk.b bVar, @os.l String str) {
                kn.l0.p(bVar, NotificationCompat.CATEGORY_CALL);
                kn.l0.p(str, "callId");
                vk.c.m(bVar.e(), this.$headerName, str);
            }
        }

        public static final class b extends kn.n0 implements jn.l<dk.b, String> {
            final /* synthetic */ String $headerName;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.$headerName = str;
            }

            @Override // jn.l
            @os.m
            public final String invoke(@os.l dk.b bVar) {
                kn.l0.p(bVar, "it");
                return bVar.d().b().get(this.$headerName);
            }
        }

        public static final class c extends kn.n0 implements jn.l<String, Boolean> {
            public static final c INSTANCE = new c();

            public c() {
                super(1);
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l String str) {
                kn.l0.p(str, "it");
                return Boolean.FALSE;
            }
        }

        public static final class d extends kn.n0 implements jn.l<String, Boolean> {
            final /* synthetic */ boolean $reject;
            final /* synthetic */ char[] $sortedDictionary;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(char[] cArr, boolean z10) {
                super(1);
                this.$sortedDictionary = cArr;
                this.$reject = z10;
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l String str) {
                boolean z10;
                kn.l0.p(str, "callId");
                if (h.j(str, this.$sortedDictionary)) {
                    z10 = true;
                } else {
                    if (this.$reject) {
                        throw new y0(str);
                    }
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }

        public a() {
            n(this, h.f6619a, false, 2, null);
        }

        public static /* synthetic */ void n(a aVar, String str, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            aVar.l(str, z10);
        }

        public final void a(@os.l jn.l<? super dk.b, String> lVar) {
            kn.l0.p(lVar, "block");
            this.f6608b.add(lVar);
        }

        @os.l
        public final ArrayList<jn.l<dk.b, String>> b() {
            return this.f6608b;
        }

        @os.l
        public final ArrayList<jn.p<dk.b, String, l2>> c() {
            return this.f6609c;
        }

        @os.l
        public final ArrayList<jn.l<dk.b, String>> d() {
            return this.f6607a;
        }

        @os.l
        public final jn.l<String, Boolean> e() {
            return this.f6610d;
        }

        public final void f(@os.l String str) {
            kn.l0.p(str, "headerName");
            j(str);
            h(str);
        }

        public final void g(@os.l jn.p<? super dk.b, ? super String, l2> pVar) {
            kn.l0.p(pVar, "block");
            this.f6609c.add(pVar);
        }

        public final void h(@os.l String str) {
            kn.l0.p(str, "headerName");
            g(new C0164a(str));
        }

        public final void i(@os.l jn.l<? super dk.b, String> lVar) {
            kn.l0.p(lVar, "block");
            this.f6607a.add(lVar);
        }

        public final void j(@os.l String str) {
            kn.l0.p(str, "headerName");
            i(new b(str));
        }

        public final void k(@os.l jn.l<? super String, Boolean> lVar) {
            kn.l0.p(lVar, "<set-?>");
            this.f6610d = lVar;
        }

        public final void l(@os.l String str, boolean z10) {
            kn.l0.p(str, "dictionary");
            m(new d(nm.h0.P5(nm.h0.q5(jq.j0.e9(str))), z10));
        }

        public final void m(@os.l jn.l<? super String, Boolean> lVar) {
            kn.l0.p(lVar, "predicate");
            this.f6610d = lVar;
        }
    }

    public static final class b implements dk.h<dk.c, a, g> {

        @xm.f(c = "io.ktor.features.CallId$Feature$install$1", f = "CallId.kt", i = {0}, l = {310}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
        public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ g $instance;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g gVar, um.d<? super a> dVar) {
                super(3, dVar);
                this.$instance = gVar;
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
                    dk.b bVar = (dk.b) fVar2.getContext();
                    jn.l[] lVarArr = this.$instance.f6604a;
                    try {
                        int length = lVarArr.length;
                        int i11 = 0;
                        while (i11 < length) {
                            int i12 = i11 + 1;
                            String str = (String) lVarArr[i11].invoke(bVar);
                            if (str != null && this.$instance.f6606c.invoke(str).booleanValue()) {
                                fl.c cVarC = bVar.c();
                                g.f6599d.getClass();
                                cVarC.g(g.f6601f, str);
                                jn.p<dk.b, String, l2>[] pVarArr = this.$instance.f6605b;
                                int length2 = pVarArr.length;
                                int i13 = 0;
                                while (i13 < length2) {
                                    int i14 = i13 + 1;
                                    pVarArr[i13].invoke(bVar, str);
                                    i13 = i14;
                                }
                                break;
                            }
                            i11 = i12;
                        }
                    } catch (y0 e10) {
                        g.f6599d.d().warn(kn.l0.C("Illegal call id retrieved or generated that is rejected by call id verifier: (url-encoded) ", ik.e.n(e10.getIllegalCallId(), false, 1, null)));
                        ik.r0.f8158c.getClass();
                        ik.r0 r0Var = ik.r0.f8182x;
                        if (!(r0Var instanceof byte[])) {
                            try {
                                vk.i.b(bVar.e(), l1.A(ik.r0.class));
                            } catch (Throwable unused) {
                            }
                        }
                        vk.d dVarC = bVar.e().c();
                        this.L$0 = fVar2;
                        this.label = 1;
                        if (dVarC.g(bVar, r0Var, this) == aVar) {
                            return aVar;
                        }
                        fVar = fVar2;
                        fVar.finish();
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
                a aVar = new a(this.$instance, dVar);
                aVar.L$0 = fVar;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public b() {
        }

        @os.l
        public final fl.b<String> c() {
            return g.f6601f;
        }

        public final ps.a d() {
            return (ps.a) g.f6603h.getValue();
        }

        @os.l
        public final nl.j e() {
            return g.f6600e;
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public g a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar = new a();
            lVar.invoke(aVar);
            Object[] array = nm.h0.E4(aVar.f6607a, aVar.f6608b).toArray(new jn.l[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            jn.l[] lVarArr = (jn.l[]) array;
            Object[] array2 = aVar.f6609c.toArray(new jn.p[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            g gVar = new g(lVarArr, (jn.p[]) array2, aVar.f6610d);
            dk.c.f3706v.getClass();
            cVar.v(dk.c.f3707w, g.f6600e);
            if (gVar.f6604a.length == 0) {
                d().warn("CallId feature is not configured: neither retrievers nor generators were configured");
                return gVar;
            }
            cVar.x(g.f6600e, new a(gVar, null));
            return gVar;
        }

        @Override // dk.h
        @os.l
        public fl.b<g> getKey() {
            return g.f6602g;
        }

        public b(kn.w wVar) {
        }
    }

    public static final class c extends kn.n0 implements jn.a<ps.a> {
        public static final c INSTANCE = new c();

        public c() {
            super(0);
        }

        @Override // jn.a
        public final ps.a invoke() {
            return ps.b.j(wn.c.a(l1.d(g.class)));
        }
    }

    public /* synthetic */ g(jn.l[] lVarArr, jn.p[] pVarArr, jn.l lVar, kn.w wVar) {
        this(lVarArr, pVarArr, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(jn.l<dk.b, String>[] lVarArr, jn.p<dk.b, String, l2>[] pVarArr, jn.l<? super String, Boolean> lVar) {
        this.f6604a = lVarArr;
        this.f6605b = pVarArr;
        this.f6606c = lVar;
    }
}
