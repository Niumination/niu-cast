package gk;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kn.l1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final c f6708d = new c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final fl.b<v> f6709e = new fl.b<>("ContentNegotiation");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<b> f6710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<jn.p<dk.b, List<y>, List<y>>> f6711b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6712c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final List<b> f6713a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final List<jn.p<dk.b, List<y>, List<y>>> f6714b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6715c;

        /* JADX INFO: renamed from: gk.v$a$a, reason: collision with other inner class name */
        public static final class C0173a extends kn.n0 implements jn.l<Object, l2> {
            public static final C0173a INSTANCE = new C0173a();

            public C0173a() {
                super(1);
            }

            public final void invoke(@os.l Object obj) {
                kn.l0.p(obj, "$this$null");
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(Object obj) {
                invoke(obj);
                return l2.f10208a;
            }
        }

        public static /* synthetic */ void f(a aVar, ik.i iVar, u uVar, jn.l lVar, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                lVar = C0173a.INSTANCE;
            }
            aVar.e(iVar, uVar, lVar);
        }

        public final void a(@os.l jn.p<? super dk.b, ? super List<y>, ? extends List<y>> pVar) {
            kn.l0.p(pVar, "contributor");
            this.f6714b.add(pVar);
        }

        @os.l
        public final List<jn.p<dk.b, List<y>, List<y>>> b() {
            return this.f6714b;
        }

        public final boolean c() {
            return this.f6715c;
        }

        @os.l
        public final List<b> d() {
            return this.f6713a;
        }

        public final <T extends u> void e(@os.l ik.i iVar, @os.l T t10, @os.l jn.l<? super T, l2> lVar) {
            kn.l0.p(iVar, "contentType");
            kn.l0.p(t10, "converter");
            kn.l0.p(lVar, "configuration");
            lVar.invoke(t10);
            this.f6713a.add(new b(iVar, t10));
        }

        public final void g(boolean z10) {
            this.f6715c = z10;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final ik.i f6716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final u f6717b;

        public b(@os.l ik.i iVar, @os.l u uVar) {
            kn.l0.p(iVar, "contentType");
            kn.l0.p(uVar, "converter");
            this.f6716a = iVar;
            this.f6717b = uVar;
        }

        public static /* synthetic */ b d(b bVar, ik.i iVar, u uVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                iVar = bVar.f6716a;
            }
            if ((i10 & 2) != 0) {
                uVar = bVar.f6717b;
            }
            return bVar.c(iVar, uVar);
        }

        @os.l
        public final ik.i a() {
            return this.f6716a;
        }

        @os.l
        public final u b() {
            return this.f6717b;
        }

        @os.l
        public final b c(@os.l ik.i iVar, @os.l u uVar) {
            kn.l0.p(iVar, "contentType");
            kn.l0.p(uVar, "converter");
            return new b(iVar, uVar);
        }

        @os.l
        public final ik.i e() {
            return this.f6716a;
        }

        public boolean equals(@os.m Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return kn.l0.g(this.f6716a, bVar.f6716a) && kn.l0.g(this.f6717b, bVar.f6717b);
        }

        @os.l
        public final u f() {
            return this.f6717b;
        }

        public int hashCode() {
            return this.f6717b.hashCode() + (this.f6716a.hashCode() * 31);
        }

        @os.l
        public String toString() {
            return "ConverterRegistration(contentType=" + this.f6716a + ", converter=" + this.f6717b + ')';
        }
    }

    public static final class c implements dk.h<dk.c, a, v> {

        @xm.f(c = "io.ktor.features.ContentNegotiation$Feature$install$1", f = "ContentNegotiation.kt", i = {0}, l = {145, 320}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
        public static final class a extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            public a(um.d<? super a> dVar) {
                super(3, dVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [nl.f] */
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v6 */
            /* JADX WARN: Type inference failed for: r1v9 */
            /* JADX WARN: Type inference failed for: r5v0, types: [gk.v$c$a, um.d] */
            /* JADX WARN: Type inference failed for: r5v1, types: [gk.v$c$a, um.d] */
            /* JADX WARN: Type inference failed for: r5v5 */
            /* JADX WARN: Type inference failed for: r5v7 */
            /* JADX WARN: Type inference failed for: r5v8 */
            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                ?? r10 = this.label;
                try {
                    if (r10 != 0) {
                        if (r10 == 1) {
                            nl.f fVar = (nl.f) this.L$0;
                            lm.d1.n(obj);
                            r10 = fVar;
                            this = this;
                        } else {
                            if (r10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            lm.d1.n(obj);
                        }
                        return l2.f10208a;
                    }
                    lm.d1.n(obj);
                    nl.f fVar2 = (nl.f) this.L$0;
                    this.L$0 = fVar2;
                    this.label = 1;
                    Object objJ0 = fVar2.J0(this);
                    r10 = fVar2;
                    this = objJ0;
                    if (objJ0 == aVar) {
                        return aVar;
                    }
                } catch (c1 unused) {
                    dk.b bVar = (dk.b) r10.getContext();
                    ik.r0.f8158c.getClass();
                    ik.r0 r0Var = ik.r0.M;
                    if (!(r0Var instanceof byte[])) {
                        try {
                            vk.i.b(bVar.e(), l1.A(ik.r0.class));
                        } catch (Throwable unused2) {
                        }
                    }
                    vk.d dVarC = bVar.e().c();
                    this.L$0 = null;
                    this.label = 2;
                    if (dVarC.g(bVar, r0Var, this) == aVar) {
                        return aVar;
                    }
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
                a aVar = new a(dVar);
                aVar.L$0 = fVar;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        @xm.f(c = "io.ktor.features.ContentNegotiation$Feature$install$2", f = "ContentNegotiation.kt", i = {1, 1, 1}, l = {185, 192, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 202}, m = "invokeSuspend", n = {"$this$intercept", "subject", "acceptItems"}, s = {"L$0", "L$1", "L$2"})
        public static final class b extends xm.o implements jn.q<nl.f<Object, dk.b>, Object, um.d<? super l2>, Object> {
            final /* synthetic */ v $feature;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            Object L$2;
            Object L$3;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(v vVar, um.d<? super b> dVar) {
                super(3, dVar);
                this.$feature = vVar;
            }

            /* JADX WARN: Code duplicated, block: B:59:0x0166 A[PHI: r2 r6 r8 r9
              0x0166: PHI (r2v12 java.util.Iterator) = (r2v5 java.util.Iterator), (r2v13 java.util.Iterator) binds: [B:58:0x015d, B:64:0x0188] A[DONT_GENERATE, DONT_INLINE]
              0x0166: PHI (r6v3 java.util.List<gk.y>) = (r6v1 java.util.List<gk.y>), (r6v4 java.util.List<gk.y>) binds: [B:58:0x015d, B:64:0x0188] A[DONT_GENERATE, DONT_INLINE]
              0x0166: PHI (r8v2 java.lang.Object) = (r8v0 java.lang.Object), (r8v3 java.lang.Object) binds: [B:58:0x015d, B:64:0x0188] A[DONT_GENERATE, DONT_INLINE]
              0x0166: PHI (r9v4 nl.f<java.lang.Object, dk.b>) = (r9v2 nl.f<java.lang.Object, dk.b>), (r9v5 nl.f<java.lang.Object, dk.b>) binds: [B:58:0x015d, B:64:0x0188] A[DONT_GENERATE, DONT_INLINE]] */
            /* JADX WARN: Code duplicated, block: B:61:0x016c  */
            /* JADX WARN: Code duplicated, block: B:63:0x0187 A[RETURN] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0185 -> B:64:0x0188). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // xm.a
            @os.m
            public final java.lang.Object invokeSuspend(@os.l java.lang.Object r17) {
                /*
                    Method dump skipped, instruction units count: 497
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: gk.v.c.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj, @os.m um.d<? super l2> dVar) {
                b bVar = new b(this.$feature, dVar);
                bVar.L$0 = fVar;
                bVar.L$1 = obj;
                return bVar.invokeSuspend(l2.f10208a);
            }
        }

        /* JADX INFO: renamed from: gk.v$c$c, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.features.ContentNegotiation$Feature$install$3", f = "ContentNegotiation.kt", i = {0, 0, 0}, l = {224, 227}, m = "invokeSuspend", n = {"$this$intercept", "receive", "requestContentType"}, s = {"L$0", "L$1", "L$2"})
        public static final class C0174c extends xm.o implements jn.q<nl.f<uk.c, dk.b>, uk.c, um.d<? super l2>, Object> {
            final /* synthetic */ v $feature;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            Object L$2;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0174c(v vVar, um.d<? super C0174c> dVar) {
                super(3, dVar);
                this.$feature = vVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) throws c1, gk.c {
                nl.f<uk.c, dk.b> fVar;
                uk.c cVar;
                ik.i iVarK;
                Object next;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        iVarK = (ik.i) this.L$2;
                        cVar = (uk.c) this.L$1;
                        fVar = (nl.f) this.L$0;
                        lm.d1.n(obj);
                    } else {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        lm.d1.n(obj);
                    }
                    return l2.f10208a;
                }
                lm.d1.n(obj);
                fVar = (nl.f) this.L$0;
                cVar = (uk.c) this.L$1;
                if ((fVar.E().f16295b instanceof pl.k) && !kn.l0.g(wn.d.b(fVar.E().f16294a), l1.d(pl.k.class))) {
                    try {
                        iVarK = uk.e.l(fVar.getContext().d()).k();
                        Iterator<T> it = this.$feature.f6710a.iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (!iVarK.h(((b) next).f6716a));
                        b bVar = (b) next;
                        if (bVar == null) {
                            throw new c1(iVarK);
                        }
                        u uVar = bVar.f6717b;
                        this.L$0 = fVar;
                        this.L$1 = cVar;
                        this.L$2 = iVarK;
                        this.label = 1;
                        obj = uVar.a(fVar, this);
                        if (obj == aVar) {
                            return aVar;
                        }
                    } catch (ik.c e10) {
                        ik.b0 b0VarB = fVar.getContext().d().b();
                        ik.j0.f8048a.getClass();
                        throw new gk.c(kn.l0.C("Illegal Content-Type header format: ", b0VarB.get(ik.j0.f8086t)), e10);
                    }
                }
                return l2.f10208a;
                if (obj == null) {
                    throw new c1(iVarK);
                }
                uk.c cVar2 = new uk.c(cVar.f16294a, obj, true);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (fVar.v0(cVar2, this) == aVar) {
                    return aVar;
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<uk.c, dk.b> fVar, @os.l uk.c cVar, @os.m um.d<? super l2> dVar) {
                C0174c c0174c = new C0174c(this.$feature, dVar);
                c0174c.L$0 = fVar;
                c0174c.L$1 = cVar;
                return c0174c.invokeSuspend(l2.f10208a);
            }
        }

        public c() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public v a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar = new a();
            lVar.invoke(aVar);
            v vVar = new v(aVar.f6713a, aVar.f6714b, aVar.f6715c);
            dk.c.f3706v.getClass();
            cVar.x(dk.c.f3709y, new a(null));
            vk.d dVar = cVar.f3713p;
            vk.d.f17581n.getClass();
            dVar.x(vk.d.f17584w, new b(vVar, null));
            uk.b bVar = cVar.f3712n;
            uk.b.f16289n.getClass();
            bVar.x(uk.b.f16291v, new C0174c(vVar, null));
            return vVar;
        }

        @Override // dk.h
        @os.l
        public fl.b<v> getKey() {
            return v.f6709e;
        }

        public c(kn.w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@os.l List<b> list, @os.l List<? extends jn.p<? super dk.b, ? super List<y>, ? extends List<y>>> list2, boolean z10) {
        kn.l0.p(list, "registrations");
        kn.l0.p(list2, "acceptContributors");
        this.f6710a = list;
        this.f6711b = list2;
        this.f6712c = z10;
    }

    public final boolean d(@os.l List<y> list, @os.m ik.i iVar) {
        kn.l0.p(list, "acceptItems");
        if (!this.f6712c || list.isEmpty() || iVar == null) {
            return true;
        }
        List<y> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (iVar.h(((y) it.next()).f6740a)) {
                    return true;
                }
            }
        }
        return false;
    }

    @os.l
    public final List<b> e() {
        return this.f6710a;
    }

    public /* synthetic */ v(List list, List list2, boolean z10, int i10, kn.w wVar) {
        this(list, list2, (i10 & 4) != 0 ? false : z10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @lm.k(level = lm.m.HIDDEN, message = "This will become internal")
    public /* synthetic */ v(List list, List list2) {
        this(list, list2, false);
        kn.l0.p(list, "registrations");
        kn.l0.p(list2, "acceptContributors");
    }
}
