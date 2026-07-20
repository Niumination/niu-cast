package yk;

import androidx.constraintlayout.widget.ConstraintLayout;
import ik.b1;
import ik.c1;
import ik.h1;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import kn.l0;
import kn.l1;
import kn.m1;
import lm.d1;
import lm.l2;
import nq.k1;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final un.d<? extends Object>[] f21432a;

    @xm.f(c = "io.ktor.server.engine.DefaultTransformKt$installDefaultTransformations$1", f = "DefaultTransform.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends xm.o implements jn.q<nl.f<Object, dk.b>, Object, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public a(um.d<? super a> dVar) {
            super(3, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                nl.f fVar = (nl.f) this.L$0;
                nk.s sVarA = nk.h.a(fVar, this.L$1);
                if (sVarA != null) {
                    this.L$0 = null;
                    this.label = 1;
                    if (fVar.v0(sVarA, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<Object, dk.b> fVar, @os.l Object obj, @os.m um.d<? super l2> dVar) {
            a aVar = new a(dVar);
            aVar.L$0 = fVar;
            aVar.L$1 = obj;
            return aVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.server.engine.DefaultTransformKt$installDefaultTransformations$2", f = "DefaultTransform.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_EDITOR_ABSOLUTEX, 52, 60, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT, 82}, m = "invokeSuspend", n = {"$this$intercept", "query", "$this$intercept", "query", "$this$intercept", "query", "$this$intercept", "query"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    public static final class b extends xm.o implements jn.q<nl.f<uk.c, dk.b>, uk.c, um.d<? super l2>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        Object L$2;
        int label;

        @xm.f(c = "io.ktor.server.engine.DefaultTransformKt$installDefaultTransformations$2$transformed$2$1", f = "DefaultTransform.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends xm.o implements jn.p<nk.u, um.d<? super l2>, Object> {
            final /* synthetic */ c1 $this_build;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c1 c1Var, um.d<? super a> dVar) {
                super(2, dVar);
                this.$this_build = c1Var;
            }

            @Override // xm.a
            @os.l
            public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
                a aVar = new a(this.$this_build, dVar);
                aVar.L$0 = obj;
                return aVar;
            }

            @Override // xm.a
            @os.m
            public final Object invokeSuspend(@os.l Object obj) {
                String strE;
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
                nk.u uVar = (nk.u) this.L$0;
                if ((uVar instanceof nk.u.c) && (strE = uVar.e()) != null) {
                    this.$this_build.a(strE, ((nk.u.c) uVar).f11551e);
                }
                uVar.f11544a.invoke();
                return l2.f10208a;
            }

            @Override // jn.p
            @os.m
            public final Object invoke(@os.l nk.u uVar, @os.m um.d<? super l2> dVar) {
                return ((a) create(uVar, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        public b(um.d<? super b> dVar) {
            super(3, dVar);
        }

        /* JADX WARN: Code duplicated, block: B:77:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:79:0x01e6 A[RETURN] */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws gk.c {
            nl.f fVar;
            uk.c cVar;
            pl.k kVar;
            Object objH;
            uk.c cVar2;
            c1 c1Var;
            nl.f fVar2;
            nl.f fVar3;
            Object objI;
            pl.k kVar2;
            Object objD;
            uk.c cVar3;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                fVar = (nl.f) this.L$0;
                cVar = (uk.c) this.L$1;
                Object obj2 = cVar.f16295b;
                if (obj2 instanceof pl.k) {
                    kVar2 = (pl.k) obj2;
                } else {
                    kVar = null;
                }
                if (kVar == null) {
                    kVar = kVar2;
                    return l2.f10208a;
                }
                un.d<?> dVarB = wn.d.b(cVar.f16294a);
                if (!l0.g(dVarB, l1.d(pl.k.class))) {
                    m1 m1Var = l1.f9319a;
                    if (l0.g(dVarB, m1Var.d(byte[].class))) {
                        this.L$0 = fVar;
                        this.L$1 = cVar;
                        this.label = 1;
                        objI = gl.k.b(kVar, 0, this, 1, null);
                        if (objI == aVar) {
                            kVar = kVar2;
                            objH = kVar;
                            return aVar;
                        }
                    } else if (l0.g(dVarB, m1Var.d(InputStream.class))) {
                        kVar = kVar2;
                        objH = kVar;
                        objH = s.j(kVar);
                    } else if (l0.g(dVarB, m1Var.d(nk.p.class))) {
                        kVar = kVar2;
                        objH = kVar;
                        objH = s.h(fVar, kVar);
                    } else if (l0.g(dVarB, m1Var.d(String.class))) {
                        kVar = kVar2;
                        objH = kVar;
                        dk.b bVar = (dk.b) fVar.getContext();
                        try {
                            Charset charsetK = uk.e.k(((dk.b) fVar.getContext()).d());
                            if (charsetK == null) {
                                charsetK = jq.f.f8805g;
                            }
                            this.L$0 = fVar;
                            this.L$1 = cVar;
                            this.label = 2;
                            objI = s.i(kVar, charsetK, this);
                            if (objI == aVar) {
                                return aVar;
                            }
                        } catch (ik.c e10) {
                            ik.b0 b0VarB = bVar.d().b();
                            ik.j0.f8048a.getClass();
                            throw new gk.c(l0.C("Illegal Content-Type header format: ", b0VarB.get(ik.j0.f8086t)), e10);
                        }
                    } else {
                        if (l0.g(dVarB, m1Var.d(b1.class))) {
                            kVar = kVar2;
                            objH = kVar;
                            dk.b bVar2 = (dk.b) fVar.getContext();
                            try {
                                ik.i iVarL = uk.e.l(((dk.b) fVar.getContext()).d());
                                ik.i.a.f7985a.getClass();
                                if (iVarL.h(ik.i.a.f7999o)) {
                                    Charset charsetK2 = uk.e.k(((dk.b) fVar.getContext()).d());
                                    if (charsetK2 == null) {
                                        charsetK2 = jq.f.f8805g;
                                    }
                                    this.L$0 = fVar;
                                    this.L$1 = cVar;
                                    this.label = 3;
                                    Object objI2 = s.i(kVar, charsetK2, this);
                                    if (objI2 == aVar) {
                                        return aVar;
                                    }
                                    fVar3 = fVar;
                                    obj = objI2;
                                    objD = h1.d((String) obj, 0, 0, 6, null);
                                    fVar = fVar3;
                                    objH = objD;
                                } else {
                                    ik.i.f.f8020a.getClass();
                                    if (iVarL.h(ik.i.f.f8025f)) {
                                        b1.a aVar2 = b1.f7942c;
                                        c1 c1Var2 = new c1(0, null, 3, null);
                                        nk.p pVarH = s.h(fVar, kVar);
                                        a aVar3 = new a(c1Var2, null);
                                        this.L$0 = fVar;
                                        this.L$1 = cVar;
                                        this.L$2 = c1Var2;
                                        this.label = 4;
                                        if (nk.r.a(pVarH, aVar3, this) == aVar) {
                                            return aVar;
                                        }
                                        cVar2 = cVar;
                                        c1Var = c1Var2;
                                        fVar2 = fVar;
                                        b1 b1VarF = c1Var.f();
                                        cVar = cVar2;
                                        fVar = fVar2;
                                        objH = b1VarF;
                                    }
                                }
                            } catch (ik.c e11) {
                                ik.b0 b0VarB2 = bVar2.d().b();
                                ik.j0.f8048a.getClass();
                                throw new gk.c(l0.C("Illegal Content-Type header format: ", b0VarB2.get(ik.j0.f8086t)), e11);
                            }
                        }
                        kVar = kVar2;
                        objH = kVar;
                        objH = null;
                    }
                    kVar = kVar2;
                    objH = kVar;
                    Object obj3 = objI;
                    fVar3 = fVar;
                    obj = obj3;
                    objD = obj;
                    fVar = fVar3;
                    objH = objD;
                }
                if (objH != null) {
                    cVar3 = new uk.c(cVar.f16294a, objH, nm.r.s8(s.f21432a, wn.d.b(cVar.f16294a)));
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (fVar.v0(cVar3, this) == aVar) {
                        return aVar;
                    }
                }
            } else if (i10 == 1 || i10 == 2) {
                cVar = (uk.c) this.L$1;
                fVar3 = (nl.f) this.L$0;
                d1.n(obj);
                objD = obj;
                fVar = fVar3;
                objH = objD;
                if (objH != null) {
                    cVar3 = new uk.c(cVar.f16294a, objH, nm.r.s8(s.f21432a, wn.d.b(cVar.f16294a)));
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (fVar.v0(cVar3, this) == aVar) {
                        return aVar;
                    }
                }
            } else if (i10 == 3) {
                cVar = (uk.c) this.L$1;
                fVar3 = (nl.f) this.L$0;
                d1.n(obj);
                objD = h1.d((String) obj, 0, 0, 6, null);
                fVar = fVar3;
                objH = objD;
                if (objH != null) {
                    cVar3 = new uk.c(cVar.f16294a, objH, nm.r.s8(s.f21432a, wn.d.b(cVar.f16294a)));
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (fVar.v0(cVar3, this) == aVar) {
                        return aVar;
                    }
                }
            } else if (i10 == 4) {
                c1Var = (c1) this.L$2;
                cVar2 = (uk.c) this.L$1;
                fVar2 = (nl.f) this.L$0;
                d1.n(obj);
                b1 b1VarF2 = c1Var.f();
                cVar = cVar2;
                fVar = fVar2;
                objH = b1VarF2;
                if (objH != null) {
                    cVar3 = new uk.c(cVar.f16294a, objH, nm.r.s8(s.f21432a, wn.d.b(cVar.f16294a)));
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (fVar.v0(cVar3, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i10 != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }

        @Override // jn.q
        @os.m
        public final Object invoke(@os.l nl.f<uk.c, dk.b> fVar, @os.l uk.c cVar, @os.m um.d<? super l2> dVar) {
            b bVar = new b(dVar);
            bVar.L$0 = fVar;
            bVar.L$1 = cVar;
            return bVar.invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.server.engine.DefaultTransformKt", f = "DefaultTransform.kt", i = {0}, l = {125}, m = "readText", n = {"charset"}, s = {"L$0"})
    public static final class c extends xm.d {
        Object L$0;
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
            return s.i(null, null, this);
        }
    }

    static {
        un.d<? extends Object> dVarD = l1.d(byte[].class);
        m1 m1Var = l1.f9319a;
        f21432a = new un.d[]{dVarD, m1Var.d(String.class), m1Var.d(b1.class)};
    }

    public static final void e() {
        if (!m.b()) {
            throw new IllegalStateException("Acquiring blocking primitives on this dispatcher is not allowed. Consider using async channel or doing withContext(Dispatchers.IO) { call.receive<InputStream>().use { ... } } instead.");
        }
    }

    @v
    public static final void f(@os.l uk.b bVar) {
        l0.p(bVar, "<this>");
        uk.b.f16289n.getClass();
        bVar.x(uk.b.f16291v, new b(null));
    }

    @v
    public static final void g(@os.l vk.d dVar) {
        l0.p(dVar, "<this>");
        vk.d.f17581n.getClass();
        dVar.x(vk.d.f17584w, new a(null));
    }

    public static final nk.p h(nl.f<?, dk.b> fVar, pl.k kVar) {
        uk.d dVarD = fVar.getContext().d();
        ik.j0 j0Var = ik.j0.f8048a;
        j0Var.getClass();
        String strQ = uk.e.q(dVarD, ik.j0.f8086t);
        if (strQ == null) {
            throw new IllegalStateException("Content-Type header is required for multipart processing");
        }
        uk.d dVarD2 = fVar.getContext().d();
        j0Var.getClass();
        String strQ2 = uk.e.q(dVarD2, ik.j0.f8080q);
        return new kk.b(fVar.getCoroutineContext().plus(k1.g()), kVar, strQ, strQ2 == null ? null : Long.valueOf(Long.parseLong(strQ2)), 0, 0, 48, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object i(pl.k kVar, Charset charset, um.d<? super String> dVar) {
        c cVar;
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
        Object objE = cVar.result;
        Object obj = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 == 0) {
            d1.n(objE);
            cVar.L$0 = charset;
            cVar.label = 1;
            objE = kVar.E(Long.MAX_VALUE, 0, cVar);
            if (objE == obj) {
                return obj;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            charset = (Charset) cVar.L$0;
            d1.n(objE);
        }
        tl.v vVar = (tl.v) objE;
        if (vVar.B1()) {
            return "";
        }
        try {
            return l0.g(charset, jq.f.f8800b) ? tl.a.v2(vVar, 0, 0, 3, null) : dn.y.k(new InputStreamReader(cm.f.b(vVar), charset));
        } finally {
            vVar.z2();
        }
    }

    public static final InputStream j(pl.k kVar) {
        e();
        return yl.b.f(kVar, null, 1, null);
    }

    public static final <R> R k(dk.b bVar, jn.a<? extends R> aVar) throws gk.c {
        try {
            return aVar.invoke();
        } catch (ik.c e10) {
            ik.b0 b0VarB = bVar.d().b();
            ik.j0.f8048a.getClass();
            throw new gk.c(l0.C("Illegal Content-Type header format: ", b0VarB.get(ik.j0.f8086t)), e10);
        }
    }
}
