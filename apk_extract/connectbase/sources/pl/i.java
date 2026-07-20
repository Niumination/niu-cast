package pl;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.EOFException;
import java.nio.ByteBuffer;
import lm.d1;
import nq.l2;
import tl.r0;

/* JADX INFO: loaded from: classes2.dex */
@tl.f0
public final class i extends pl.f {

    @os.m
    private volatile l2 attachedJob;

    public static final class a implements d0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final i f13202b;

        public a(@os.l i iVar) {
            kn.l0.p(iVar, "channel");
            this.f13202b = iVar;
        }

        @Override // pl.b0
        @os.m
        public ByteBuffer b(int i10, int i11) throws Throwable {
            Throwable thB = this.f13202b.f13192c.b();
            if (thB != null) {
                throw thB;
            }
            if (this.f13202b.p0()) {
                return null;
            }
            if (this.f13202b.f13194e.B1()) {
                this.f13202b.k1();
            }
            ul.b bVarP0 = this.f13202b.f13194e.p0();
            tl.m mVar = bVarP0.f15821b;
            if (mVar.f15874c - mVar.f15873b < i11 + i10) {
                return null;
            }
            ByteBuffer byteBufferSlice = bVarP0.f15820a.slice();
            byteBufferSlice.position(bVarP0.f15821b.f15873b + i10);
            byteBufferSlice.limit(bVarP0.f15821b.f15874c);
            return byteBufferSlice;
        }

        @Override // pl.b0
        public void b0(int i10) throws Throwable {
            Throwable thB = this.f13202b.f13192c.b();
            if (thB != null) {
                throw thB;
            }
            this.f13202b.b0(i10);
        }

        @Override // pl.d0
        @os.m
        public Object w(int i10, @os.l um.d<? super Boolean> dVar) throws Throwable {
            Throwable thB = this.f13202b.f13192c.b();
            if (thB != null) {
                throw thB;
            }
            i iVar = this.f13202b;
            iVar.getClass();
            return pl.f.K0(iVar, i10, dVar);
        }
    }

    public static final class b extends kn.n0 implements jn.l<Throwable, lm.l2> {
        public b() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(Throwable th2) {
            invoke2(th2);
            return lm.l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.m Throwable th2) {
            i.this.attachedJob = null;
            if (th2 != null) {
                i.this.c(y.a(th2));
            }
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0, 0}, l = {162}, m = "consumeEachBufferRange", n = {"this", "visitor", "readable", "invokedWithLast"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class c extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
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
            return i.this.Q(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {211}, m = "read", n = {"this", "consumer", "min"}, s = {"L$0", "L$1", "I$0"})
    public static final class d extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
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
            return i.this.I(0, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0}, l = {108, 109}, m = "readAvailableSuspend", n = {"this", "dst"}, s = {"L$0", "L$1"})
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
            return i.this.A2(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {124}, m = "readFullySuspend", n = {"this", "dst", "count"}, s = {"L$0", "L$1", "I$0"})
    public static final class f extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
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
            return i.this.B2(null, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {246}, m = "write", n = {"this", "block", "min"}, s = {"L$0", "L$1", "I$0"})
    public static final class g extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
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
            return i.this.k0(0, null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0}, l = {38, 39}, m = "writeAvailableSuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
    public static final class h extends xm.d {
        Object L$0;
        Object L$1;
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
            return i.this.E2(null, this);
        }
    }

    /* JADX INFO: renamed from: pl.i$i, reason: collision with other inner class name */
    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG}, m = "writeFullySuspend", n = {"this", "src"}, s = {"L$0", "L$1"})
    public static final class C0328i extends xm.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C0328i(um.d<? super C0328i> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return i.this.F2(null, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.ByteChannelSequentialJVM", f = "ByteChannelSequentialJVM.kt", i = {0, 0, 0}, l = {258}, m = "writeWhile", n = {"this", "block", "shouldContinue"}, s = {"L$0", "L$1", "L$2"})
    public static final class j extends xm.d {
        Object L$0;
        Object L$1;
        Object L$2;
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
            return i.this.g0(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@os.l tl.o0 o0Var, boolean z10) {
        super(o0Var, z10, null, 4, null);
        kn.l0.p(o0Var, "initial");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object A2(ByteBuffer byteBuffer, um.d<? super Integer> dVar) throws Throwable {
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
        Object objK0 = eVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = eVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                byteBuffer = (ByteBuffer) eVar.L$1;
                this = (i) eVar.L$0;
                d1.n(objK0);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objK0);
            }
        }
        d1.n(objK0);
        eVar.L$0 = this;
        eVar.L$1 = byteBuffer;
        eVar.label = 1;
        objK0 = pl.f.K0(this, 1, eVar);
        if (objK0 == aVar) {
            return aVar;
        }
        if (!((Boolean) objK0).booleanValue()) {
            return new Integer(-1);
        }
        eVar.L$0 = null;
        eVar.L$1 = null;
        eVar.label = 2;
        objK0 = this.n0(byteBuffer, eVar);
        return objK0 == aVar ? aVar : objK0;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0045  */
    /* JADX WARN: Code duplicated, block: B:19:0x0053 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x005e  */
    /* JADX WARN: Code duplicated, block: B:24:0x0065  */
    /* JADX WARN: Code duplicated, block: B:27:0x006d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0051 -> B:20:0x0054). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object B2(java.nio.ByteBuffer r7, int r8, um.d<? super java.lang.Integer> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof pl.i.f
            if (r0 == 0) goto L13
            r0 = r9
            pl.i$f r0 = (pl.i.f) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.i$f r0 = new pl.i$f
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r0.L$0
            pl.i r8 = (pl.i) r8
            lm.d1.n(r9)
            r5 = r8
            r8 = r6
            r6 = r5
            goto L54
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            lm.d1.n(r9)
        L3f:
            boolean r9 = r7.hasRemaining()
            if (r9 == 0) goto L73
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.label = r3
            java.lang.Object r9 = pl.f.K0(r6, r3, r0)
            if (r9 != r1) goto L54
            return r1
        L54:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            java.lang.String r2 = "Channel closed"
            if (r9 == 0) goto L6d
            int r9 = r6.C2(r7)
            r4 = -1
            if (r9 == r4) goto L67
            int r8 = r8 + r9
            goto L3f
        L67:
            java.io.EOFException r6 = new java.io.EOFException
            r6.<init>(r2)
            throw r6
        L6d:
            java.io.EOFException r6 = new java.io.EOFException
            r6.<init>(r2)
            throw r6
        L73:
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.i.B2(java.nio.ByteBuffer, int, um.d):java.lang.Object");
    }

    public final int C2(ByteBuffer byteBuffer) throws Throwable {
        Throwable thB = this.f13192c.b();
        if (thB != null) {
            throw thB;
        }
        if (this.f13192c.a() && d() == 0) {
            return -1;
        }
        if (!this.f13194e.k()) {
            k1();
        }
        int iK = tl.p.k(this.f13194e, byteBuffer);
        H0(iK);
        return iK;
    }

    public final int D2(ByteBuffer byteBuffer) throws Throwable {
        int iRemaining = byteBuffer.remaining();
        int iQ = q();
        if (this.f13192c.a()) {
            Throwable thB = this.f13192c.b();
            if (thB == null) {
                throw new pq.w("Channel closed for write");
            }
            throw thB;
        }
        if (iRemaining != 0) {
            if (iRemaining <= iQ) {
                r0.a(this.f13193d, byteBuffer);
                return iRemaining;
            }
            if (iQ != 0) {
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(byteBuffer.position() + iQ);
                r0.a(this.f13193d, byteBuffer);
                byteBuffer.limit(iLimit);
                return iQ;
            }
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object E2(ByteBuffer byteBuffer, um.d<? super Integer> dVar) throws Throwable {
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
        Object objJ0 = hVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = hVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                byteBuffer = (ByteBuffer) hVar.L$1;
                this = (i) hVar.L$0;
                d1.n(objJ0);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objJ0);
            }
        }
        d1.n(objJ0);
        hVar.L$0 = this;
        hVar.L$1 = byteBuffer;
        hVar.label = 1;
        if (M0(1, hVar) == aVar) {
            return aVar;
        }
        hVar.L$0 = null;
        hVar.L$1 = null;
        hVar.label = 2;
        objJ0 = this.j0(byteBuffer, hVar);
        return objJ0 == aVar ? aVar : objJ0;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0043  */
    /* JADX WARN: Code duplicated, block: B:19:0x004f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x004d -> B:20:0x0050). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object F2(java.nio.ByteBuffer r6, um.d<? super lm.l2> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof pl.i.C0328i
            if (r0 == 0) goto L13
            r0 = r7
            pl.i$i r0 = (pl.i.C0328i) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.i$i r0 = new pl.i$i
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r5 = r0.L$1
            java.nio.ByteBuffer r5 = (java.nio.ByteBuffer) r5
            java.lang.Object r6 = r0.L$0
            pl.i r6 = (pl.i) r6
            lm.d1.n(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L50
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            lm.d1.n(r7)
        L3d:
            boolean r7 = r6.hasRemaining()
            if (r7 == 0) goto L58
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.M0(r3, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            int r7 = r5.D2(r6)
            r5.J0(r7)
            goto L3d
        L58:
            lm.l2 r5 = lm.l2.f10208a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.i.F2(java.nio.ByteBuffer, um.d):java.lang.Object");
    }

    @Override // pl.k
    @os.m
    public <R> Object G(@os.l jn.p<? super d0, ? super um.d<? super R>, ? extends Object> pVar, @os.l um.d<? super R> dVar) {
        return pVar.invoke(new a(this), dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    @Override // pl.k
    @os.m
    public Object I(int i10, @os.l jn.l<? super ByteBuffer, lm.l2> lVar, @os.l um.d<? super lm.l2> dVar) throws EOFException {
        d dVar2;
        if (dVar instanceof d) {
            dVar2 = (d) dVar;
            int i11 = dVar2.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                dVar2.label = i11 - Integer.MIN_VALUE;
            } else {
                dVar2 = new d(dVar);
            }
        } else {
            dVar2 = new d(dVar);
        }
        Object objK0 = dVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = dVar2.label;
        if (i12 == 0) {
            d1.n(objK0);
            if (i10 < 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            dVar2.L$0 = this;
            dVar2.L$1 = lVar;
            dVar2.I$0 = i10;
            dVar2.label = 1;
            objK0 = pl.f.K0(this, i10, dVar2);
            if (objK0 == aVar) {
                return aVar;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = dVar2.I$0;
            lVar = (jn.l) dVar2.L$1;
            this = (i) dVar2.L$0;
            d1.n(objK0);
        }
        if (!((Boolean) objK0).booleanValue()) {
            throw new EOFException(k.b.a("Channel closed while ", i10, " bytes expected"));
        }
        tl.v vVar = this.f13194e;
        ul.b bVarI2 = vVar.i2(i10);
        if (bVarI2 == null) {
            throw pl.h.a(i10);
        }
        tl.m mVar = bVarI2.f15821b;
        int i13 = mVar.f15873b;
        try {
            ByteBuffer byteBuffer = bVarI2.f15820a;
            int i14 = mVar.f15874c - i13;
            ByteBuffer byteBufferN = ql.f.n(byteBuffer, i13, i14);
            lVar.invoke(byteBufferN);
            if (byteBufferN.limit() != i14) {
                throw new IllegalStateException("Buffer's limit change is not allowed");
            }
            bVarI2.h(byteBufferN.position());
            tl.m mVar2 = bVarI2.f15821b;
            int i15 = mVar2.f15873b;
            if (i15 < i13) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i15 == mVar2.f15874c) {
                vVar.E(bVarI2);
            } else {
                vVar.f15790b.f15800c = i15;
            }
            return lm.l2.f10208a;
        } catch (Throwable th2) {
            tl.m mVar3 = bVarI2.f15821b;
            int i16 = mVar3.f15873b;
            if (i16 < i13) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i16 == mVar3.f15874c) {
                vVar.E(bVarI2);
            } else {
                vVar.f15790b.f15800c = i16;
            }
            throw th2;
        }
    }

    @Override // pl.k
    @os.m
    public Object K(@os.l ByteBuffer byteBuffer, @os.l um.d<? super Integer> dVar) throws Throwable {
        int iC2 = C2(byteBuffer);
        if (iC2 != -1) {
            return !byteBuffer.hasRemaining() ? new Integer(iC2) : B2(byteBuffer, iC2, dVar);
        }
        throw new EOFException("Channel closed");
    }

    @Override // pl.n
    @os.m
    public Object M(@os.l ByteBuffer byteBuffer, @os.l um.d<? super lm.l2> dVar) throws Throwable {
        Object objF2;
        D2(byteBuffer);
        return (byteBuffer.hasRemaining() && (objF2 = F2(byteBuffer, dVar)) == wm.a.COROUTINE_SUSPENDED) ? objF2 : lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0059  */
    /* JADX WARN: Code duplicated, block: B:20:0x006e A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:18:0x005d, B:20:0x006e, B:26:0x007e, B:28:0x0087, B:29:0x0089, B:31:0x008f, B:52:0x00e4, B:53:0x00eb), top: B:65:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:25:0x007d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0087 A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:18:0x005d, B:20:0x006e, B:26:0x007e, B:28:0x0087, B:29:0x0089, B:31:0x008f, B:52:0x00e4, B:53:0x00eb), top: B:65:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:31:0x008f A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #0 {all -> 0x007a, blocks: (B:18:0x005d, B:20:0x006e, B:26:0x007e, B:28:0x0087, B:29:0x0089, B:31:0x008f, B:52:0x00e4, B:53:0x00eb), top: B:65:0x005d }] */
    /* JADX WARN: Code duplicated, block: B:34:0x009c  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00da  */
    /* JADX WARN: Code duplicated, block: B:50:0x00de  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00b9 -> B:42:0x00bd). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // pl.f, pl.k
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public java.lang.Object Q(jn.p r14, um.d r15) {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.i.Q(jn.p, um.d):java.lang.Object");
    }

    @Override // pl.k
    public int S(int i10, @os.l jn.l<? super ByteBuffer, lm.l2> lVar) throws Throwable {
        kn.l0.p(lVar, "block");
        if (this.f13192c.a()) {
            Throwable thB = this.f13192c.b();
            if (thB == null) {
                throw new pq.w("Channel closed for read");
            }
            throw thB;
        }
        if (d() < i10) {
            return -1;
        }
        k1();
        tl.v vVar = this.f13194e;
        ul.b bVarI2 = vVar.i2(i10);
        if (bVarI2 == null) {
            throw pl.h.a(i10);
        }
        tl.m mVar = bVarI2.f15821b;
        int i11 = mVar.f15873b;
        try {
            ByteBuffer byteBuffer = bVarI2.f15820a;
            int i12 = mVar.f15874c - i11;
            ByteBuffer byteBufferN = ql.f.n(byteBuffer, i11, i12);
            int iPosition = byteBufferN.position();
            lVar.invoke(byteBufferN);
            int iPosition2 = byteBufferN.position() - iPosition;
            if (byteBufferN.limit() != i12) {
                throw new IllegalStateException("Buffer's limit change is not allowed");
            }
            bVarI2.h(byteBufferN.position());
            tl.m mVar2 = bVarI2.f15821b;
            int i13 = mVar2.f15873b;
            if (i13 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i13 == mVar2.f15874c) {
                vVar.E(bVarI2);
            } else {
                vVar.f15790b.f15800c = i13;
            }
            return iPosition2;
        } catch (Throwable th2) {
            tl.m mVar3 = bVarI2.f15821b;
            int i14 = mVar3.f15873b;
            if (i14 < i11) {
                throw new IllegalStateException("Buffer's position shouldn't be rewinded");
            }
            if (i14 == mVar3.f15874c) {
                vVar.E(bVarI2);
            } else {
                vVar.f15790b.f15800c = i14;
            }
            throw th2;
        }
    }

    @Override // pl.k
    public <R> R X(@os.l jn.l<? super b0, ? extends R> lVar) {
        kn.l0.p(lVar, "visitor");
        return lVar.invoke(new a(this));
    }

    @Override // pl.k
    @os.m
    public Object Y(@os.l um.d<? super lm.l2> dVar) {
        Object objK0 = pl.f.K0(this, 1, dVar);
        return objK0 == wm.a.COROUTINE_SUSPENDED ? objK0 : lm.l2.f10208a;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048  */
    /* JADX WARN: Code duplicated, block: B:19:0x0050  */
    /* JADX WARN: Code duplicated, block: B:21:0x0058  */
    /* JADX WARN: Code duplicated, block: B:23:0x006b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x0091 A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #0 {all -> 0x00af, blocks: (B:25:0x0072, B:27:0x0091, B:33:0x00a7, B:34:0x00ae, B:37:0x00b1, B:38:0x00b8), top: B:41:0x0072 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x009a  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0069 -> B:24:0x006c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // pl.n
    @os.m
    public java.lang.Object g0(@os.l jn.l<? super java.nio.ByteBuffer, java.lang.Boolean> r9, @os.l um.d<? super lm.l2> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof pl.i.j
            if (r0 == 0) goto L13
            r0 = r10
            pl.i$j r0 = (pl.i.j) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            pl.i$j r0 = new pl.i$j
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            wm.a r1 = wm.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r8 = r0.L$2
            kn.k1$a r8 = (kn.k1.a) r8
            java.lang.Object r9 = r0.L$1
            jn.l r9 = (jn.l) r9
            java.lang.Object r2 = r0.L$0
            pl.i r2 = (pl.i) r2
            lm.d1.n(r10)
            r10 = r8
            r8 = r2
            goto L6c
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            lm.d1.n(r10)
        L40:
            pl.g r10 = r8.f13192c
            boolean r10 = r10.a()
            if (r10 == 0) goto L58
            pl.g r8 = r8.f13192c
            java.lang.Throwable r8 = r8.b()
            if (r8 != 0) goto L57
            pq.w r8 = new pq.w
            java.lang.String r9 = "Channel closed for write"
            r8.<init>(r9)
        L57:
            throw r8
        L58:
            kn.k1$a r10 = new kn.k1$a
            r10.<init>()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r3
            java.lang.Object r2 = r8.M0(r3, r0)
            if (r2 != r1) goto L6c
            return r1
        L6c:
            tl.s r2 = r8.f13193d
            ul.b r4 = r2.T0(r3)
            java.nio.ByteBuffer r5 = r4.f15820a     // Catch: java.lang.Throwable -> Laf
            tl.m r6 = r4.f15821b     // Catch: java.lang.Throwable -> Laf
            int r7 = r6.f15874c     // Catch: java.lang.Throwable -> Laf
            int r6 = r6.f15872a     // Catch: java.lang.Throwable -> Laf
            int r6 = r6 - r7
            java.nio.ByteBuffer r5 = ql.f.n(r5, r7, r6)     // Catch: java.lang.Throwable -> Laf
            java.lang.Object r7 = r9.invoke(r5)     // Catch: java.lang.Throwable -> Laf
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> Laf
            boolean r7 = r7.booleanValue()     // Catch: java.lang.Throwable -> Laf
            r10.element = r7     // Catch: java.lang.Throwable -> Laf
            int r7 = r5.limit()     // Catch: java.lang.Throwable -> Laf
            if (r7 != r6) goto Lb1
            int r5 = r5.position()     // Catch: java.lang.Throwable -> Laf
            r4.b(r5)     // Catch: java.lang.Throwable -> Laf
            if (r5 < 0) goto La7
            r2.d()
            r8.J0(r5)
            boolean r10 = r10.element
            if (r10 != 0) goto L40
            lm.l2 r8 = lm.l2.f10208a
            return r8
        La7:
            java.lang.String r8 = "The returned value shouldn't be negative"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Laf
            r9.<init>(r8)     // Catch: java.lang.Throwable -> Laf
            throw r9     // Catch: java.lang.Throwable -> Laf
        Laf:
            r8 = move-exception
            goto Lb9
        Lb1:
            java.lang.String r8 = "Buffer's limit change is not allowed"
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Laf
            r9.<init>(r8)     // Catch: java.lang.Throwable -> Laf
            throw r9     // Catch: java.lang.Throwable -> Laf
        Lb9:
            r2.d()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: pl.i.g0(jn.l, um.d):java.lang.Object");
    }

    @Override // pl.c
    public void j(@os.l l2 l2Var) {
        kn.l0.p(l2Var, "job");
        l2 l2Var2 = this.attachedJob;
        if (l2Var2 != null) {
            l2.a.b(l2Var2, null, 1, null);
        }
        this.attachedJob = l2Var;
        l2.a.g(l2Var, true, false, new b(), 2, null);
    }

    @Override // pl.n
    @os.m
    public Object j0(@os.l ByteBuffer byteBuffer, @os.l um.d<? super Integer> dVar) throws Throwable {
        int iD2 = D2(byteBuffer);
        if (iD2 <= 0) {
            if (byteBuffer.hasRemaining()) {
                return E2(byteBuffer, dVar);
            }
            iD2 = 0;
        }
        return new Integer(iD2);
    }

    @Override // pl.n
    public int k(int i10, @os.l jn.l<? super ByteBuffer, lm.l2> lVar) throws Throwable {
        kn.l0.p(lVar, "block");
        if (this.f13192c.a()) {
            Throwable thB = this.f13192c.b();
            if (thB == null) {
                throw new pq.w("Channel closed for write");
            }
            throw thB;
        }
        if (q() < i10) {
            return 0;
        }
        tl.s sVar = this.f13193d;
        ul.b bVarT0 = sVar.T0(i10);
        try {
            ByteBuffer byteBuffer = bVarT0.f15820a;
            tl.m mVar = bVarT0.f15821b;
            int i11 = mVar.f15874c;
            int i12 = mVar.f15872a - i11;
            ByteBuffer byteBufferN = ql.f.n(byteBuffer, i11, i12);
            int iPosition = byteBufferN.position();
            lVar.invoke(byteBufferN);
            int iPosition2 = byteBufferN.position() - iPosition;
            if (byteBufferN.limit() != i12) {
                throw new IllegalStateException("Buffer's limit change is not allowed");
            }
            int iPosition3 = byteBufferN.position();
            bVarT0.b(iPosition3);
            if (iPosition3 < 0) {
                throw new IllegalStateException("The returned value shouldn't be negative");
            }
            sVar.d();
            return iPosition2;
        } catch (Throwable th2) {
            sVar.d();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // pl.n
    @os.m
    public Object k0(int i10, @os.l jn.l<? super ByteBuffer, lm.l2> lVar, @os.l um.d<? super lm.l2> dVar) throws Throwable {
        g gVar;
        if (dVar instanceof g) {
            gVar = (g) dVar;
            int i11 = gVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                gVar.label = i11 - Integer.MIN_VALUE;
            } else {
                gVar = new g(dVar);
            }
        } else {
            gVar = new g(dVar);
        }
        Object obj = gVar.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i12 = gVar.label;
        if (i12 == 0) {
            d1.n(obj);
            if (this.f13192c.a()) {
                Throwable thB = this.f13192c.b();
                if (thB == null) {
                    throw new pq.w("Channel closed for write");
                }
                throw thB;
            }
            gVar.L$0 = this;
            gVar.L$1 = lVar;
            gVar.I$0 = i10;
            gVar.label = 1;
            if (M0(i10, gVar) == aVar) {
                return aVar;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = gVar.I$0;
            lVar = (jn.l) gVar.L$1;
            this = (i) gVar.L$0;
            d1.n(obj);
        }
        tl.s sVar = this.f13193d;
        ul.b bVarT0 = sVar.T0(i10);
        try {
            ByteBuffer byteBuffer = bVarT0.f15820a;
            tl.m mVar = bVarT0.f15821b;
            int i13 = mVar.f15874c;
            int i14 = mVar.f15872a - i13;
            ByteBuffer byteBufferN = ql.f.n(byteBuffer, i13, i14);
            lVar.invoke(byteBufferN);
            if (byteBufferN.limit() != i14) {
                throw new IllegalStateException("Buffer's limit change is not allowed");
            }
            int iPosition = byteBufferN.position();
            bVarT0.b(iPosition);
            if (iPosition < 0) {
                throw new IllegalStateException("The returned value shouldn't be negative");
            }
            sVar.d();
            this.J0(iPosition);
            return lm.l2.f10208a;
        } catch (Throwable th2) {
            sVar.d();
            throw th2;
        }
    }

    @Override // pl.k
    @os.m
    public Object n0(@os.l ByteBuffer byteBuffer, @os.l um.d<? super Integer> dVar) throws Throwable {
        int iC2 = C2(byteBuffer);
        if (iC2 != 0) {
            return new Integer(iC2);
        }
        return !byteBuffer.hasRemaining() ? new Integer(0) : A2(byteBuffer, dVar);
    }
}
