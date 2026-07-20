package pl;

import lm.d1;
import lm.l2;
import lm.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13209a;

        static {
            int[] iArr = new int[tl.q.values().length];
            iArr[tl.q.LITTLE_ENDIAN.ordinal()] = 1;
            iArr[tl.q.BIG_ENDIAN.ordinal()] = 2;
            f13209a = iArr;
        }
    }

    @xm.f(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {23}, m = "readDouble", n = {"byteOrder"}, s = {"L$0"})
    public static final class b extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.a(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {43}, m = "readDoubleLittleEndian", n = {}, s = {})
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
            return q.c(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {19}, m = "readFloat", n = {"byteOrder"}, s = {"L$0"})
    public static final class d extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.e(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {39}, m = "readFloatLittleEndian", n = {}, s = {})
    public static final class e extends xm.d {
        Object L$0;
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
            return q.g(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {11}, m = "readInt", n = {"byteOrder"}, s = {"L$0"})
    public static final class f extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public f(um.d<? super f> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.i(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {31}, m = "readIntLittleEndian", n = {}, s = {})
    public static final class g extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public g(um.d<? super g> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.k(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {15}, m = "readLong", n = {"byteOrder"}, s = {"L$0"})
    public static final class h extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public h(um.d<? super h> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.m(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {35}, m = "readLongLittleEndian", n = {}, s = {})
    public static final class i extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public i(um.d<? super i> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.o(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {0}, l = {7}, m = "readShort", n = {"byteOrder"}, s = {"L$0"})
    public static final class j extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public j(um.d<? super j> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.q(null, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ChannelLittleEndianKt", f = "ChannelLittleEndian.kt", i = {}, l = {27}, m = "readShortLittleEndian", n = {}, s = {})
    public static final class k extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public k(um.d<? super k> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.s(null, this);
        }
    }

    @os.m
    public static final Object A(@os.l n nVar, float f10, @os.l um.d<? super l2> dVar) {
        if (a.f13209a[nVar.o0().ordinal()] != 1) {
            f10 = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f10)));
        }
        Object objF0 = nVar.f0(f10, dVar);
        return objF0 == wm.a.COROUTINE_SUSPENDED ? objF0 : l2.f10208a;
    }

    @os.m
    public static final Object B(@os.l n nVar, int i10, @os.l tl.q qVar, @os.l um.d<? super l2> dVar) {
        if (a.f13209a[qVar.ordinal()] != 2) {
            i10 = Integer.reverseBytes(i10);
        }
        Object objH0 = nVar.h0(i10, dVar);
        return objH0 == wm.a.COROUTINE_SUSPENDED ? objH0 : l2.f10208a;
    }

    @os.m
    public static final Object C(@os.l n nVar, int i10, @os.l um.d<? super l2> dVar) {
        if (a.f13209a[nVar.o0().ordinal()] != 1) {
            i10 = Integer.reverseBytes(i10);
        }
        Object objH0 = nVar.h0(i10, dVar);
        return objH0 == wm.a.COROUTINE_SUSPENDED ? objH0 : l2.f10208a;
    }

    @os.m
    public static final Object D(@os.l n nVar, long j10, @os.l tl.q qVar, @os.l um.d<? super l2> dVar) {
        if (a.f13209a[qVar.ordinal()] != 2) {
            j10 = Long.reverseBytes(j10);
        }
        Object objA = nVar.A(j10, dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }

    @os.m
    public static final Object E(@os.l n nVar, long j10, @os.l um.d<? super l2> dVar) {
        if (a.f13209a[nVar.o0().ordinal()] != 1) {
            j10 = Long.reverseBytes(j10);
        }
        Object objA = nVar.A(j10, dVar);
        return objA == wm.a.COROUTINE_SUSPENDED ? objA : l2.f10208a;
    }

    @os.m
    public static final Object F(@os.l n nVar, short s10, @os.l tl.q qVar, @os.l um.d<? super l2> dVar) {
        if (a.f13209a[qVar.ordinal()] != 2) {
            s10 = Short.reverseBytes(s10);
        }
        Object objE0 = nVar.e0(s10, dVar);
        return objE0 == wm.a.COROUTINE_SUSPENDED ? objE0 : l2.f10208a;
    }

    @os.m
    public static final Object G(@os.l n nVar, short s10, @os.l um.d<? super l2> dVar) {
        if (a.f13209a[nVar.o0().ordinal()] != 1) {
            s10 = Short.reverseBytes(s10);
        }
        Object objE0 = nVar.e0(s10, dVar);
        return objE0 == wm.a.COROUTINE_SUSPENDED ? objE0 : l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object a(@os.l pl.k kVar, @os.l tl.q qVar, @os.l um.d<? super Double> dVar) {
        b bVar;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        Object objT = bVar.result;
        Object obj = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        if (i11 == 0) {
            d1.n(objT);
            bVar.L$0 = qVar;
            bVar.label = 1;
            objT = kVar.T(bVar);
            if (objT == obj) {
                return obj;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            qVar = (tl.q) bVar.L$0;
            d1.n(objT);
        }
        return a.f13209a[qVar.ordinal()] == 2 ? objT : new Double(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) objT).doubleValue()))));
    }

    public static final Object b(pl.k kVar, tl.q qVar, um.d<? super Double> dVar) {
        Object objT = kVar.T(dVar);
        return a.f13209a[qVar.ordinal()] == 2 ? objT : Double.valueOf(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) objT).doubleValue()))));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object c(@os.l pl.k kVar, @os.l um.d<? super Double> dVar) {
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
        Object objT = cVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 == 0) {
            d1.n(objT);
            cVar.L$0 = kVar;
            cVar.label = 1;
            objT = kVar.T(cVar);
            if (objT == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kVar = (pl.k) cVar.L$0;
            d1.n(objT);
        }
        return a.f13209a[kVar.R().ordinal()] == 1 ? objT : new Double(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) objT).doubleValue()))));
    }

    public static final Object d(pl.k kVar, um.d<? super Double> dVar) {
        Object objT = kVar.T(dVar);
        return a.f13209a[kVar.R().ordinal()] == 1 ? objT : Double.valueOf(Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(((Number) objT).doubleValue()))));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object e(@os.l pl.k kVar, @os.l tl.q qVar, @os.l um.d<? super Float> dVar) {
        d dVar2;
        if (dVar instanceof d) {
            dVar2 = (d) dVar;
            int i10 = dVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                dVar2 = new d(dVar);
            }
        } else {
            dVar2 = new d(dVar);
        }
        Object objB = dVar2.result;
        Object obj = wm.a.COROUTINE_SUSPENDED;
        int i11 = dVar2.label;
        if (i11 == 0) {
            d1.n(objB);
            dVar2.L$0 = qVar;
            dVar2.label = 1;
            objB = kVar.B(dVar2);
            if (objB == obj) {
                return obj;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            qVar = (tl.q) dVar2.L$0;
            d1.n(objB);
        }
        return a.f13209a[qVar.ordinal()] == 2 ? objB : new Float(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) objB).floatValue()))));
    }

    public static final Object f(pl.k kVar, tl.q qVar, um.d<? super Float> dVar) {
        Object objB = kVar.B(dVar);
        return a.f13209a[qVar.ordinal()] == 2 ? objB : Float.valueOf(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) objB).floatValue()))));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object g(@os.l pl.k kVar, @os.l um.d<? super Float> dVar) {
        e eVar;
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
        Object objB = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        if (i11 == 0) {
            d1.n(objB);
            eVar.L$0 = kVar;
            eVar.label = 1;
            objB = kVar.B(eVar);
            if (objB == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kVar = (pl.k) eVar.L$0;
            d1.n(objB);
        }
        return a.f13209a[kVar.R().ordinal()] == 1 ? objB : new Float(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) objB).floatValue()))));
    }

    public static final Object h(pl.k kVar, um.d<? super Float> dVar) {
        Object objB = kVar.B(dVar);
        return a.f13209a[kVar.R().ordinal()] == 1 ? objB : Float.valueOf(Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(((Number) objB).floatValue()))));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object i(@os.l pl.k kVar, @os.l tl.q qVar, @os.l um.d<? super Integer> dVar) {
        f fVar;
        if (dVar instanceof f) {
            fVar = (f) dVar;
            int i10 = fVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                fVar.label = i10 - Integer.MIN_VALUE;
            } else {
                fVar = new f(dVar);
            }
        } else {
            fVar = new f(dVar);
        }
        Object objX = fVar.result;
        Object obj = wm.a.COROUTINE_SUSPENDED;
        int i11 = fVar.label;
        if (i11 == 0) {
            d1.n(objX);
            fVar.L$0 = qVar;
            fVar.label = 1;
            objX = kVar.x(fVar);
            if (objX == obj) {
                return obj;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            qVar = (tl.q) fVar.L$0;
            d1.n(objX);
        }
        return a.f13209a[qVar.ordinal()] == 2 ? objX : new Integer(Integer.reverseBytes(((Number) objX).intValue()));
    }

    public static final Object j(pl.k kVar, tl.q qVar, um.d<? super Integer> dVar) {
        Object objX = kVar.x(dVar);
        return a.f13209a[qVar.ordinal()] == 2 ? objX : Integer.valueOf(Integer.reverseBytes(((Number) objX).intValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object k(@os.l pl.k kVar, @os.l um.d<? super Integer> dVar) {
        g gVar;
        if (dVar instanceof g) {
            gVar = (g) dVar;
            int i10 = gVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                gVar.label = i10 - Integer.MIN_VALUE;
            } else {
                gVar = new g(dVar);
            }
        } else {
            gVar = new g(dVar);
        }
        Object objX = gVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = gVar.label;
        if (i11 == 0) {
            d1.n(objX);
            gVar.L$0 = kVar;
            gVar.label = 1;
            objX = kVar.x(gVar);
            if (objX == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kVar = (pl.k) gVar.L$0;
            d1.n(objX);
        }
        return a.f13209a[kVar.R().ordinal()] == 1 ? objX : new Integer(Integer.reverseBytes(((Number) objX).intValue()));
    }

    public static final Object l(pl.k kVar, um.d<? super Integer> dVar) {
        Object objX = kVar.x(dVar);
        return a.f13209a[kVar.R().ordinal()] == 1 ? objX : Integer.valueOf(Integer.reverseBytes(((Number) objX).intValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object m(@os.l pl.k kVar, @os.l tl.q qVar, @os.l um.d<? super Long> dVar) {
        h hVar;
        if (dVar instanceof h) {
            hVar = (h) dVar;
            int i10 = hVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                hVar.label = i10 - Integer.MIN_VALUE;
            } else {
                hVar = new h(dVar);
            }
        } else {
            hVar = new h(dVar);
        }
        Object objD = hVar.result;
        Object obj = wm.a.COROUTINE_SUSPENDED;
        int i11 = hVar.label;
        if (i11 == 0) {
            d1.n(objD);
            hVar.L$0 = qVar;
            hVar.label = 1;
            objD = kVar.D(hVar);
            if (objD == obj) {
                return obj;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            qVar = (tl.q) hVar.L$0;
            d1.n(objD);
        }
        return a.f13209a[qVar.ordinal()] == 2 ? objD : new Long(Long.reverseBytes(((Number) objD).longValue()));
    }

    public static final Object n(pl.k kVar, tl.q qVar, um.d<? super Long> dVar) {
        Object objD = kVar.D(dVar);
        return a.f13209a[qVar.ordinal()] == 2 ? objD : Long.valueOf(Long.reverseBytes(((Number) objD).longValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object o(@os.l pl.k kVar, @os.l um.d<? super Long> dVar) {
        i iVar;
        if (dVar instanceof i) {
            iVar = (i) dVar;
            int i10 = iVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                iVar.label = i10 - Integer.MIN_VALUE;
            } else {
                iVar = new i(dVar);
            }
        } else {
            iVar = new i(dVar);
        }
        Object objD = iVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = iVar.label;
        if (i11 == 0) {
            d1.n(objD);
            iVar.L$0 = kVar;
            iVar.label = 1;
            objD = kVar.D(iVar);
            if (objD == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kVar = (pl.k) iVar.L$0;
            d1.n(objD);
        }
        return a.f13209a[kVar.R().ordinal()] == 1 ? objD : new Long(Long.reverseBytes(((Number) objD).longValue()));
    }

    public static final Object p(pl.k kVar, um.d<? super Long> dVar) {
        Object objD = kVar.D(dVar);
        return a.f13209a[kVar.R().ordinal()] == 1 ? objD : Long.valueOf(Long.reverseBytes(((Number) objD).longValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object q(@os.l pl.k kVar, @os.l tl.q qVar, @os.l um.d<? super Short> dVar) {
        j jVar;
        if (dVar instanceof j) {
            jVar = (j) dVar;
            int i10 = jVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                jVar.label = i10 - Integer.MIN_VALUE;
            } else {
                jVar = new j(dVar);
            }
        } else {
            jVar = new j(dVar);
        }
        Object objC = jVar.result;
        Object obj = wm.a.COROUTINE_SUSPENDED;
        int i11 = jVar.label;
        if (i11 == 0) {
            d1.n(objC);
            jVar.L$0 = qVar;
            jVar.label = 1;
            objC = kVar.C(jVar);
            if (objC == obj) {
                return obj;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            qVar = (tl.q) jVar.L$0;
            d1.n(objC);
        }
        return a.f13209a[qVar.ordinal()] == 2 ? objC : new Short(Short.reverseBytes(((Number) objC).shortValue()));
    }

    public static final Object r(pl.k kVar, tl.q qVar, um.d<? super Short> dVar) {
        Object objC = kVar.C(dVar);
        return a.f13209a[qVar.ordinal()] == 2 ? objC : Short.valueOf(Short.reverseBytes(((Number) objC).shortValue()));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @os.m
    public static final Object s(@os.l pl.k kVar, @os.l um.d<? super Short> dVar) {
        k kVar2;
        if (dVar instanceof k) {
            kVar2 = (k) dVar;
            int i10 = kVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                kVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                kVar2 = new k(dVar);
            }
        } else {
            kVar2 = new k(dVar);
        }
        Object objC = kVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = kVar2.label;
        if (i11 == 0) {
            d1.n(objC);
            kVar2.L$0 = kVar;
            kVar2.label = 1;
            objC = kVar.C(kVar2);
            if (objC == aVar) {
                return aVar;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kVar = (pl.k) kVar2.L$0;
            d1.n(objC);
        }
        return a.f13209a[kVar.R().ordinal()] == 1 ? objC : new Short(Short.reverseBytes(((Number) objC).shortValue()));
    }

    public static final Object t(pl.k kVar, um.d<? super Short> dVar) {
        Object objC = kVar.C(dVar);
        return a.f13209a[kVar.R().ordinal()] == 1 ? objC : Short.valueOf(Short.reverseBytes(((Number) objC).shortValue()));
    }

    @z0
    public static final <T> T u(T t10, @os.l tl.q qVar, @os.l jn.l<? super T, ? extends T> lVar) {
        kn.l0.p(qVar, "byteOrder");
        kn.l0.p(lVar, "reverseBlock");
        return a.f13209a[qVar.ordinal()] == 2 ? t10 : lVar.invoke(t10);
    }

    @z0
    public static final <T> T v(@os.l pl.k kVar, T t10, @os.l jn.l<? super T, ? extends T> lVar) {
        kn.l0.p(kVar, "<this>");
        kn.l0.p(lVar, "reverseBlock");
        return a.f13209a[kVar.R().ordinal()] == 1 ? t10 : lVar.invoke(t10);
    }

    public static final <T> T w(n nVar, T t10, jn.l<? super T, ? extends T> lVar) {
        return a.f13209a[nVar.o0().ordinal()] == 1 ? t10 : lVar.invoke(t10);
    }

    @os.m
    public static final Object x(@os.l n nVar, double d10, @os.l tl.q qVar, @os.l um.d<? super l2> dVar) {
        if (a.f13209a[qVar.ordinal()] != 2) {
            d10 = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d10)));
        }
        Object objT = nVar.t(d10, dVar);
        return objT == wm.a.COROUTINE_SUSPENDED ? objT : l2.f10208a;
    }

    @os.m
    public static final Object y(@os.l n nVar, double d10, @os.l um.d<? super l2> dVar) {
        if (a.f13209a[nVar.o0().ordinal()] != 1) {
            d10 = Double.longBitsToDouble(Long.reverseBytes(Double.doubleToRawLongBits(d10)));
        }
        Object objT = nVar.t(d10, dVar);
        return objT == wm.a.COROUTINE_SUSPENDED ? objT : l2.f10208a;
    }

    @os.m
    public static final Object z(@os.l n nVar, float f10, @os.l tl.q qVar, @os.l um.d<? super l2> dVar) {
        if (a.f13209a[qVar.ordinal()] != 2) {
            f10 = Float.intBitsToFloat(Integer.reverseBytes(Float.floatToRawIntBits(f10)));
        }
        Object objF0 = nVar.f0(f10, dVar);
        return objF0 == wm.a.COROUTINE_SUSPENDED ? objF0 : l2.f10208a;
    }
}
