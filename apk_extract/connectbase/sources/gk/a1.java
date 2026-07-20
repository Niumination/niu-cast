package gk;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final b f6520c = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public static final fl.b<a1> f6521d = new fl.b<>("Status Pages");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final HashMap<Class<?>, jn.q<nl.f<?, dk.b>, Throwable, um.d<? super l2>, Object>> f6522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final HashMap<ik.r0, jn.q<nl.f<?, dk.b>, ik.r0, um.d<? super l2>, Object>> f6523b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Map<Class<?>, jn.q<nl.f<?, dk.b>, Throwable, um.d<? super l2>, Object>> f6524a = new LinkedHashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final Map<ik.r0, jn.q<nl.f<?, dk.b>, ik.r0, um.d<? super l2>, Object>> f6525b = new LinkedHashMap();

        public final <T extends Throwable> void a(@os.l Class<T> cls, @os.l jn.q<? super nl.f<l2, dk.b>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar) {
            kn.l0.p(cls, "klass");
            kn.l0.p(qVar, "handler");
            this.f6524a.put(cls, qVar);
        }

        public final <T extends Throwable> void b(jn.q<? super nl.f<l2, dk.b>, ? super T, ? super um.d<? super l2>, ? extends Object> qVar) {
            kn.l0.p(qVar, "handler");
            kn.l0.P();
            a(Throwable.class, qVar);
        }

        @os.l
        public final Map<Class<?>, jn.q<nl.f<?, dk.b>, Throwable, um.d<? super l2>, Object>> c() {
            return this.f6524a;
        }

        @os.l
        public final Map<ik.r0, jn.q<nl.f<?, dk.b>, ik.r0, um.d<? super l2>, Object>> d() {
            return this.f6525b;
        }

        public final void e(@os.l ik.r0[] r0VarArr, @os.l jn.q<? super nl.f<?, dk.b>, ? super ik.r0, ? super um.d<? super l2>, ? extends Object> qVar) {
            kn.l0.p(r0VarArr, NotificationCompat.CATEGORY_STATUS);
            kn.l0.p(qVar, "handler");
            int length = r0VarArr.length;
            int i10 = 0;
            while (i10 < length) {
                ik.r0 r0Var = r0VarArr[i10];
                i10++;
                this.f6525b.put(r0Var, qVar);
            }
        }
    }

    public static final class b implements dk.h<dk.c, a, a1> {

        @xm.f(c = "io.ktor.features.StatusPages$Feature$install$1", f = "StatusPages.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.q<nl.f<Object, dk.b>, Object, um.d<? super l2>, Object> {
            final /* synthetic */ a1 $feature;
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(a1 a1Var, um.d<? super a> dVar) {
                super(3, dVar);
                this.$feature = a1Var;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    nl.f fVar = (nl.f) this.L$0;
                    Object obj2 = this.L$1;
                    a1 a1Var = this.$feature;
                    this.L$0 = null;
                    this.label = 1;
                    if (a1Var.i(fVar, obj2, this) == aVar) {
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

        /* JADX INFO: renamed from: gk.a1$b$b, reason: collision with other inner class name */
        @xm.f(c = "io.ktor.features.StatusPages$Feature$install$2", f = "StatusPages.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0158b extends xm.o implements jn.q<nl.f<l2, dk.b>, l2, um.d<? super l2>, Object> {
            final /* synthetic */ a1 $feature;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0158b(a1 a1Var, um.d<? super C0158b> dVar) {
                super(3, dVar);
                this.$feature = a1Var;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    lm.d1.n(obj);
                    nl.f fVar = (nl.f) this.L$0;
                    a1 a1Var = this.$feature;
                    this.label = 1;
                    if (a1Var.h(fVar, this) == aVar) {
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
            public final Object invoke(@os.l nl.f<l2, dk.b> fVar, @os.l l2 l2Var, @os.m um.d<? super l2> dVar) {
                C0158b c0158b = new C0158b(this.$feature, dVar);
                c0158b.L$0 = fVar;
                return c0158b.invokeSuspend(l2.f10208a);
            }
        }

        public b() {
        }

        @Override // dk.h
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a1 a(@os.l dk.c cVar, @os.l jn.l<? super a, l2> lVar) throws nl.c {
            kn.l0.p(cVar, "pipeline");
            kn.l0.p(lVar, "configure");
            a aVar = new a();
            lVar.invoke(aVar);
            a1 a1Var = new a1(aVar);
            if (!a1Var.f6523b.isEmpty()) {
                vk.d dVar = cVar.f3713p;
                vk.d.f17581n.getClass();
                dVar.x(vk.d.f17587z, new a(a1Var, null));
            }
            if (!a1Var.f6522a.isEmpty()) {
                dk.c.f3706v.getClass();
                cVar.x(dk.c.f3708x, new C0158b(a1Var, null));
            }
            return a1Var;
        }

        @Override // dk.h
        @os.l
        public fl.b<a1> getKey() {
            return a1.f6521d;
        }

        public b(kn.w wVar) {
        }
    }

    @xm.f(c = "io.ktor.features.StatusPages", f = "StatusPages.kt", i = {0, 0, 1, 1}, l = {101, y5.a.Z}, m = "interceptCall", n = {"this", "context", "this", "context"}, s = {"L$0", "L$1", "L$0", "L$1"})
    public static final class c extends xm.d {
        Object L$0;
        Object L$1;
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
            return a1.this.h(null, this);
        }
    }

    @xm.f(c = "io.ktor.features.StatusPages$interceptCall$2", f = "StatusPages.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends xm.o implements jn.p<nq.s0, um.d<? super l2>, Object> {
        final /* synthetic */ nl.f<l2, dk.b> $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(nl.f<l2, dk.b> fVar, um.d<? super d> dVar) {
            super(2, dVar);
            this.$context = fVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new d(this.$context, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                lm.d1.n(obj);
                nl.f<l2, dk.b> fVar = this.$context;
                this.label = 1;
                if (fVar.J0(this) == aVar) {
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

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l nq.s0 s0Var, @os.m um.d<? super l2> dVar) {
            return ((d) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.features.StatusPages", f = "StatusPages.kt", i = {0, 0}, l = {87}, m = "interceptResponse", n = {"this", "context"}, s = {"L$0", "L$1"})
    public static final class e extends xm.d {
        Object L$0;
        Object L$1;
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
            return a1.this.i(null, null, this);
        }
    }

    public a1(@os.l a aVar) {
        kn.l0.p(aVar, "config");
        this.f6522a = new HashMap<>(aVar.f6524a);
        this.f6523b = new HashMap<>(aVar.f6525b);
    }

    public final jn.q<nl.f<l2, dk.b>, Throwable, um.d<? super l2>, Object> f(Class<?> cls) {
        Class<? super Object> superclass;
        jn.q<nl.f<l2, dk.b>, Throwable, um.d<? super l2>, Object> qVarF = (jn.q) this.f6522a.get(cls);
        if (qVarF != null || ((superclass = cls.getSuperclass()) != null && (qVarF = f(superclass)) != null)) {
            return qVarF;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        kn.l0.o(interfaces, "clazz.interfaces");
        int length = interfaces.length;
        int i10 = 0;
        while (i10 < length) {
            Class<?> cls2 = interfaces[i10];
            i10++;
            kn.l0.o(cls2, "it");
            jn.q<nl.f<l2, dk.b>, Throwable, um.d<? super l2>, Object> qVarF2 = f(cls2);
            if (qVarF2 != null) {
                return qVarF2;
            }
        }
        return null;
    }

    public final void g(nl.f<?, dk.b> fVar) {
        if (fVar.getContext().e().status() != null) {
            fVar.finish();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object h(nl.f<l2, dk.b> fVar, um.d<? super l2> dVar) {
        c cVar;
        a1 a1Var;
        nl.f<?, dk.b> fVar2;
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
        Object obj = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        try {
            if (i11 == 0) {
                lm.d1.n(obj);
                d dVar2 = new d(fVar, null);
                cVar.L$0 = this;
                cVar.L$1 = fVar;
                cVar.label = 1;
                Object objG = nq.t0.g(dVar2, cVar);
                this = objG;
                if (objG == aVar) {
                    return aVar;
                }
            } else {
                if (i11 != 1) {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    fVar2 = (nl.f) cVar.L$1;
                    a1 a1Var2 = (a1) cVar.L$0;
                    lm.d1.n(obj);
                    a1Var = a1Var2;
                    a1Var.g(fVar2);
                    return l2.f10208a;
                }
                fVar = (nl.f) cVar.L$1;
                a1 a1Var3 = (a1) cVar.L$0;
                lm.d1.n(obj);
                this = a1Var3;
            }
        } catch (Throwable th2) {
            jn.q<nl.f<l2, dk.b>, Throwable, um.d<? super l2>, Object> qVarF = this.f(th2.getClass());
            if (qVarF == null || fVar.getContext().e().status() != null) {
                throw th2;
            }
            cVar.L$0 = this;
            cVar.L$1 = fVar;
            cVar.label = 2;
            if (qVarF.invoke(fVar, th2, cVar) == aVar) {
                return aVar;
            }
            nl.f<?, dk.b> fVar3 = fVar;
            a1Var = this;
            fVar2 = fVar3;
        }
        return l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object i(nl.f<?, dk.b> fVar, Object obj, um.d<? super l2> dVar) {
        e eVar;
        ik.r0 r0VarG;
        jn.q<nl.f<?, dk.b>, ik.r0, um.d<? super l2>, Object> qVar;
        if (dVar instanceof e) {
            eVar = (e) dVar;
            int i10 = eVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                eVar.label = i10 - Integer.MIN_VALUE;
            } else {
                eVar = new e(dVar);
            }
        } else {
            eVar = new e(dVar);
        }
        Object obj2 = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        if (i11 == 0) {
            lm.d1.n(obj2);
            dk.b context = fVar.getContext();
            fl.c cVarC = context.c();
            fl.b<a1> bVar = f6521d;
            if (cVarC.d(bVar)) {
                return l2.f10208a;
            }
            if (obj instanceof nk.s) {
                r0VarG = ((nk.s) obj).g();
            } else {
                r0VarG = obj instanceof ik.r0 ? (ik.r0) obj : null;
            }
            if (r0VarG != null && (qVar = this.f6523b.get(r0VarG)) != null) {
                context.c().g(bVar, this);
                eVar.L$0 = this;
                eVar.L$1 = fVar;
                eVar.label = 1;
                if (qVar.invoke(fVar, r0VarG, eVar) == aVar) {
                    return aVar;
                }
            }
            return l2.f10208a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        fVar = (nl.f) eVar.L$1;
        this = (a1) eVar.L$0;
        lm.d1.n(obj2);
        this.g(fVar);
        return l2.f10208a;
    }
}
