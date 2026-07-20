package gk;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final b f6699b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final fl.b<r> f6700c = new fl.b<>("Conditional Headers");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<jn.p<nk.s, um.d<? super List<? extends nk.a0>>, Object>> f6701a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final List<jn.p<nk.s, um.d<? super List<? extends nk.a0>>, Object>> f6702a;

        /* JADX INFO: renamed from: gk.r$a$a, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.features.ConditionalHeaders$Configuration$1", f = "ConditionalHeaders.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0172a extends xm.o implements jn.p<nk.s, um.d<? super List<? extends nk.a0>>, Object> {
            /* synthetic */ Object L$0;
            int label;

            public C0172a(um.d<? super C0172a> dVar) {
                super(2, dVar);
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                C0172a c0172a = new C0172a(dVar);
                c0172a.L$0 = obj;
                return c0172a;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj);
                return s.a((nk.s) this.L$0);
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l nk.s sVar, @os.m um.d<? super List<? extends nk.a0>> dVar) {
                return ((C0172a) create(sVar, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f6702a = arrayList;
            arrayList.add(new C0172a(null));
        }

        @os.l
        public final List<jn.p<nk.s, um.d<? super List<? extends nk.a0>>, Object>> a() {
            return this.f6702a;
        }

        public final void b(@os.l jn.p<? super nk.s, ? super um.d<? super List<? extends nk.a0>>, ? extends Object> pVar) {
            kn.l0.p(pVar, "provider");
            this.f6702a.add(pVar);
        }
    }

    public static final class b implements dk.h<dk.c, a, r> {

        @xm.f(c = "io.ktor.features.ConditionalHeaders$Feature$install$1", f = "ConditionalHeaders.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<Object, dk.b>, Object, um.d<? super l2>, Object> {
            final /* synthetic */ r $feature;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(r rVar, um.d<? super a> dVar) {
                super(3, dVar);
                this.$feature = rVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    nl.f<Object, dk.b> fVar = (nl.f) this.L$0;
                    Object obj2 = this.L$1;
                    r rVar = this.$feature;
                    this.L$0 = null;
                    this.label = 1;
                    if (rVar.c(fVar, obj2, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lm.d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.q
            @os.m
            public final Object invoke(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj, @os.m um.d<? super l2> dVar) {
                a aVar = new a(this.$feature, dVar);
                aVar.L$0 = fVar;
                aVar.L$1 = obj;
                return aVar.invokeSuspend(l2.f10208a);
            }
        }

        public b() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public r a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar = new a();
            lVar.invoke(aVar);
            r rVar = new r(aVar.f6702a);
            vk.d dVar = cVar.f3713p;
            vk.d.f17581n.getClass();
            dVar.x(vk.d.f17587z, new a(rVar, null));
            return rVar;
        }

        @Override // dk.h
        @os.l
        public fl.b<r> getKey() {
            return r.f6700c;
        }

        public b(kn.w wVar) {
        }
    }

    @xm.f(c = "io.ktor.features.ConditionalHeaders", f = "ConditionalHeaders.kt", i = {0, 0, 0}, l = {40, 56}, m = "interceptor$ktor_server_core", n = {"this", "context", NotificationCompat.CATEGORY_CALL}, s = {"L$0", "L$1", "L$2"})
    public static final class c extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return r.this.c(null, null, this);
        }
    }

    public static final class d extends kn.n0 implements jn.p<String, List<? extends String>, l2> {
        final /* synthetic */ vk.g $responseHeaders;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(vk.g gVar) {
            super(2);
            this.$responseHeaders = gVar;
        }

        @Override // jn.p
        public /* bridge */ /* synthetic */ l2 invoke(String str, List<? extends String> list) {
            invoke2(str, (List<String>) list);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l String str, @os.l List<String> list) {
            kn.l0.p(str, "name");
            kn.l0.p(list, "values");
            vk.g gVar = this.$responseHeaders;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                vk.g.c(gVar, str, (String) it.next(), false, 4, null);
            }
        }
    }

    @xm.f(c = "io.ktor.features.ConditionalHeaders", f = "ConditionalHeaders.kt", i = {0, 0}, l = {75}, m = "versionsFor", n = {t2.a.f15437d, "destination$iv"}, s = {"L$0", "L$1"})
    public static final class e extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public e(um.d<? super e> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return r.this.d(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(@os.l List<? extends jn.p<? super nk.s, ? super um.d<? super List<? extends nk.a0>>, ? extends Object>> list) {
        kn.l0.p(list, "versionProviders");
        this.f6701a = list;
    }

    public final nk.b0 b(dk.b bVar, List<? extends nk.a0> list) {
        Iterator<? extends nk.a0> it = list.iterator();
        while (it.hasNext()) {
            nk.b0 b0VarA = it.next().a(bVar.d().b());
            if (b0VarA != nk.b0.OK) {
                return b0VarA;
            }
        }
        return nk.b0.OK;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0074  */
    /* JADX WARN: Code duplicated, block: B:28:0x0089 A[LOOP:0: B:26:0x0083->B:28:0x0089, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:32:0x00af  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c6 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public final Object c(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj, @os.l um.d<? super l2> dVar) {
        c cVar;
        dk.b context;
        List<? extends nk.a0> list;
        Object objD;
        nk.b0 b0VarB;
        nk.j jVar;
        ik.c0 c0Var;
        Iterator<T> it;
        if (dVar instanceof c) {
            cVar = (c) dVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(dVar);
            }
        } else {
            cVar = new c(dVar);
        }
        Object obj2 = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                dk.b bVar = (dk.b) cVar.L$2;
                fVar = (nl.f) cVar.L$1;
                r rVar = (r) cVar.L$0;
                lm.d1.n(obj2);
                context = bVar;
                this = rVar;
                objD = obj2;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lm.d1.n(obj2);
            }
            return l2.f10208a;
        }
        lm.d1.n(obj2);
        context = fVar.getContext();
        if (obj instanceof nk.s) {
            cVar.L$0 = this;
            cVar.L$1 = fVar;
            cVar.L$2 = context;
            cVar.label = 1;
            objD = d((nk.s) obj, cVar);
            if (objD == aVar) {
                return aVar;
            }
        } else {
            list = nm.k0.INSTANCE;
        }
        if (!list.isEmpty()) {
            ik.b0.a aVar2 = ik.b0.f7939b;
            c0Var = new ik.c0(0, 1, null);
            it = list.iterator();
            while (it.hasNext()) {
                ((nk.a0) it.next()).b(c0Var);
            }
            c0Var.f().e(new d(context.e().b()));
        }
        b0VarB = this.b(context, list);
        if (b0VarB != nk.b0.OK) {
            return l2.f10208a;
        }
        jVar = new nk.j(b0VarB.getStatusCode());
        cVar.L$0 = null;
        cVar.L$1 = null;
        cVar.L$2 = null;
        cVar.label = 2;
        if (fVar.v0(jVar, cVar) == aVar) {
            return aVar;
        }
        return l2.f10208a;
        list = (List) objD;
        if (!list.isEmpty()) {
            ik.b0.a aVar3 = ik.b0.f7939b;
            c0Var = new ik.c0(0, 1, null);
            it = list.iterator();
            while (it.hasNext()) {
                ((nk.a0) it.next()).b(c0Var);
            }
            c0Var.f().e(new d(context.e().b()));
        }
        b0VarB = this.b(context, list);
        if (b0VarB != nk.b0.OK) {
            return l2.f10208a;
        }
        jVar = new nk.j(b0VarB.getStatusCode());
        cVar.L$0 = null;
        cVar.L$1 = null;
        cVar.L$2 = null;
        cVar.label = 2;
        if (fVar.v0(jVar, cVar) == aVar) {
            return aVar;
        }
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0059  */
    /* JADX WARN: Code duplicated, block: B:19:0x006d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x006e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x006e -> B:21:0x0071). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @os.m
    public final java.lang.Object d(@os.l nk.s r6, @os.l um.d<? super java.util.List<? extends nk.a0>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof gk.r.e
            if (r0 == 0) goto L13
            r0 = r7
            gk.r$e r0 = (gk.r.e) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            gk.r$e r0 = new gk.r$e
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r5 = r0.L$2
            java.util.Iterator r5 = (java.util.Iterator) r5
            java.lang.Object r6 = r0.L$1
            java.util.Collection r6 = (java.util.Collection) r6
            java.lang.Object r2 = r0.L$0
            nk.s r2 = (nk.s) r2
            lm.d1.n(r7)
            goto L71
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            lm.d1.n(r7)
            java.util.List<jn.p<nk.s, um.d<? super java.util.List<? extends nk.a0>>, java.lang.Object>> r7 = r5.f6701a
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r2 = new java.util.ArrayList
            java.util.List<jn.p<nk.s, um.d<? super java.util.List<? extends nk.a0>>, java.lang.Object>> r5 = r5.f6701a
            int r5 = r5.size()
            r2.<init>(r5)
            java.util.Iterator r5 = r7.iterator()
            r7 = r6
            r6 = r2
        L53:
            boolean r2 = r5.hasNext()
            if (r2 == 0) goto L7a
            java.lang.Object r2 = r5.next()
            jn.p r2 = (jn.p) r2
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r2 = r2.invoke(r7, r0)
            if (r2 != r1) goto L6e
            return r1
        L6e:
            r4 = r2
            r2 = r7
            r7 = r4
        L71:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            nm.d0.r0(r6, r7)
            r7 = r2
            goto L53
        L7a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: gk.r.d(nk.s, um.d):java.lang.Object");
    }
}
