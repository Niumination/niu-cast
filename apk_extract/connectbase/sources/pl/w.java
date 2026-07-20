package pl;

import java.io.IOException;
import java.nio.ByteBuffer;
import kn.k1;
import lm.d1;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class w {

    public static final class a extends kn.n0 implements jn.l<b0, l2> {
        final /* synthetic */ k1.f $copied;
        final /* synthetic */ ByteBuffer $delimiter;
        final /* synthetic */ ByteBuffer $dst;
        final /* synthetic */ k1.a $endFound;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, k1.a aVar, k1.f fVar) {
            super(1);
            this.$delimiter = byteBuffer;
            this.$dst = byteBuffer2;
            this.$endFound = aVar;
            this.$copied = fVar;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(b0 b0Var) {
            invoke2(b0Var);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l b0 b0Var) {
            kn.l0.p(b0Var, "$this$lookAhead");
            do {
                int iK = w.k(b0Var, this.$delimiter, this.$dst);
                if (iK == 0) {
                    return;
                }
                if (iK < 0) {
                    this.$endFound.element = true;
                    iK = -iK;
                }
                this.$copied.element += iK;
                if (!this.$dst.hasRemaining()) {
                    return;
                }
            } while (!this.$endFound.element);
        }
    }

    @xm.f(c = "io.ktor.utils.io.DelimitedKt", f = "Delimited.kt", i = {0, 0, 0}, l = {71, 101}, m = "readUntilDelimiterSuspend", n = {"$this$readUntilDelimiterSuspend", "dst", "endFound"}, s = {"L$0", "L$1", "L$2"})
    public static final class b extends xm.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
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
            return w.g(null, null, null, 0, this);
        }
    }

    @xm.f(c = "io.ktor.utils.io.DelimitedKt$readUntilDelimiterSuspend$copied$1", f = "Delimited.kt", i = {0, 0, 1, 1}, l = {75, 85}, m = "invokeSuspend", n = {"$this$lookAheadSuspend", "copied", "$this$lookAheadSuspend", "copied"}, s = {"L$0", "I$0", "L$0", "I$0"})
    public static final class c extends xm.o implements jn.p<d0, um.d<? super Integer>, Object> {
        final /* synthetic */ int $copied0;
        final /* synthetic */ ByteBuffer $delimiter;
        final /* synthetic */ ByteBuffer $dst;
        final /* synthetic */ k1.a $endFound;
        final /* synthetic */ k $this_readUntilDelimiterSuspend;
        int I$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(int i10, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, k1.a aVar, k kVar, um.d<? super c> dVar) {
            super(2, dVar);
            this.$copied0 = i10;
            this.$delimiter = byteBuffer;
            this.$dst = byteBuffer2;
            this.$endFound = aVar;
            this.$this_readUntilDelimiterSuspend = kVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            c cVar = new c(this.$copied0, this.$delimiter, this.$dst, this.$endFound, this.$this_readUntilDelimiterSuspend, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0049  */
        /* JADX WARN: Code duplicated, block: B:19:0x0057  */
        /* JADX WARN: Code duplicated, block: B:20:0x005c  */
        /* JADX WARN: Code duplicated, block: B:23:0x0065  */
        /* JADX WARN: Code duplicated, block: B:25:0x0077 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:27:0x007a A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:28:0x007c  */
        /* JADX WARN: Code duplicated, block: B:29:0x0081  */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x008f, code lost:
        
            if (r6.$endFound.element == false) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0078, code lost:
        
            r1 = r1 + r7;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0075 -> B:26:0x0078). Please report as a decompilation issue!!! */
        @Override // xm.a
        @os.m
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r7) {
            /*
                r6 = this;
                wm.a r0 = wm.a.COROUTINE_SUSPENDED
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L28
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                int r1 = r6.I$0
                java.lang.Object r4 = r6.L$0
                pl.d0 r4 = (pl.d0) r4
                lm.d1.n(r7)
                goto L78
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1e:
                int r1 = r6.I$0
                java.lang.Object r4 = r6.L$0
                pl.d0 r4 = (pl.d0) r4
                lm.d1.n(r7)
                goto L3f
            L28:
                lm.d1.n(r7)
                java.lang.Object r7 = r6.L$0
                pl.d0 r7 = (pl.d0) r7
                int r1 = r6.$copied0
            L31:
                r6.L$0 = r7
                r6.I$0 = r1
                r6.label = r3
                java.lang.Object r4 = r7.w(r3, r6)
                if (r4 != r0) goto L3e
                return r0
            L3e:
                r4 = r7
            L3f:
                java.nio.ByteBuffer r7 = r6.$delimiter
                java.nio.ByteBuffer r5 = r6.$dst
                int r7 = pl.w.k(r4, r7, r5)
                if (r7 != 0) goto L7a
                java.nio.ByteBuffer r7 = r6.$delimiter
                int r7 = pl.w.j(r4, r7)
                java.nio.ByteBuffer r5 = r6.$delimiter
                int r5 = r5.remaining()
                if (r7 != r5) goto L5c
                kn.k1$a r6 = r6.$endFound
                r6.element = r3
                goto L91
            L5c:
                pl.k r7 = r6.$this_readUntilDelimiterSuspend
                boolean r7 = r7.e()
                if (r7 == 0) goto L65
                goto L91
            L65:
                java.nio.ByteBuffer r7 = r6.$delimiter
                int r7 = r7.remaining()
                r6.L$0 = r4
                r6.I$0 = r1
                r6.label = r2
                java.lang.Object r7 = r4.w(r7, r6)
                if (r7 != r0) goto L78
                return r0
            L78:
                r7 = r4
                goto L83
            L7a:
                if (r7 > 0) goto L81
                kn.k1$a r5 = r6.$endFound
                r5.element = r3
                int r7 = -r7
            L81:
                int r1 = r1 + r7
                goto L78
            L83:
                java.nio.ByteBuffer r4 = r6.$dst
                boolean r4 = r4.hasRemaining()
                if (r4 == 0) goto L91
                kn.k1$a r4 = r6.$endFound
                boolean r4 = r4.element
                if (r4 == 0) goto L31
            L91:
                java.lang.Integer r6 = new java.lang.Integer
                r6.<init>(r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: pl.w.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l d0 d0Var, @os.m um.d<? super Integer> dVar) {
            return ((c) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public static final class d extends kn.n0 implements jn.l<b0, l2> {
        final /* synthetic */ ByteBuffer $delimiter;
        final /* synthetic */ k1.a $found;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(k1.a aVar, ByteBuffer byteBuffer) {
            super(1);
            this.$found = aVar;
            this.$delimiter = byteBuffer;
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(b0 b0Var) {
            invoke2(b0Var);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l b0 b0Var) {
            kn.l0.p(b0Var, "$this$lookAhead");
            this.$found.element = w.l(b0Var, this.$delimiter) == this.$delimiter.remaining();
        }
    }

    @xm.f(c = "io.ktor.utils.io.DelimitedKt$skipDelimiterSuspend$2", f = "Delimited.kt", i = {0}, l = {57}, m = "invokeSuspend", n = {"$this$lookAheadSuspend"}, s = {"L$0"})
    public static final class e extends xm.o implements jn.p<d0, um.d<? super l2>, Object> {
        final /* synthetic */ ByteBuffer $delimiter;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ByteBuffer byteBuffer, um.d<? super e> dVar) {
            super(2, dVar);
            this.$delimiter = byteBuffer;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            e eVar = new e(this.$delimiter, dVar);
            eVar.L$0 = obj;
            return eVar;
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) throws IOException {
            d0 d0Var;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                d0 d0Var2 = (d0) this.L$0;
                int iRemaining = this.$delimiter.remaining();
                this.L$0 = d0Var2;
                this.label = 1;
                if (d0Var2.w(iRemaining, this) == aVar) {
                    return aVar;
                }
                d0Var = d0Var2;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d0Var = (d0) this.L$0;
                d1.n(obj);
            }
            if (w.l(d0Var, this.$delimiter) == this.$delimiter.remaining()) {
                return l2.f10208a;
            }
            throw new IOException("Broken delimiter occurred");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l d0 d0Var, @os.m um.d<? super l2> dVar) {
            return ((e) create(d0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @os.m
    public static final Object f(@os.l k kVar, @os.l ByteBuffer byteBuffer, @os.l ByteBuffer byteBuffer2, @os.l um.d<? super Integer> dVar) {
        int i10;
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (byteBuffer == byteBuffer2) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        k1.f fVar = new k1.f();
        k1.a aVar = new k1.a();
        kVar.X(new a(byteBuffer, byteBuffer2, aVar, fVar));
        if (fVar.element == 0 && kVar.p0()) {
            i10 = -1;
        } else {
            if (byteBuffer2.hasRemaining() && !aVar.element) {
                return g(kVar, byteBuffer, byteBuffer2, fVar.element, dVar);
            }
            i10 = fVar.element;
        }
        return new Integer(i10);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    public static final Object g(k kVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i10, um.d<? super Integer> dVar) {
        b bVar;
        k kVar2;
        ByteBuffer byteBuffer3;
        k1.a aVar;
        int iIntValue;
        int i11;
        int iIntValue2;
        if (dVar instanceof b) {
            bVar = (b) dVar;
            int i12 = bVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                bVar.label = i12 - Integer.MIN_VALUE;
            } else {
                bVar = new b(dVar);
            }
        } else {
            bVar = new b(dVar);
        }
        b bVar2 = bVar;
        Object objG = bVar2.result;
        wm.a aVar2 = wm.a.COROUTINE_SUSPENDED;
        int i13 = bVar2.label;
        if (i13 != 0) {
            if (i13 == 1) {
                aVar = (k1.a) bVar2.L$2;
                byteBuffer3 = (ByteBuffer) bVar2.L$1;
                kVar2 = (k) bVar2.L$0;
                d1.n(objG);
            } else {
                if (i13 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i11 = bVar2.I$0;
                d1.n(objG);
            }
            iIntValue2 = ((Number) objG).intValue();
            if (iIntValue2 < 0) {
                iIntValue2 = 0;
            }
            iIntValue = iIntValue2 + i11;
            return new Integer(iIntValue);
        }
        d1.n(objG);
        if (byteBuffer == byteBuffer2) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        k1.a aVar3 = new k1.a();
        c cVar = new c(i10, byteBuffer, byteBuffer2, aVar3, kVar, null);
        bVar2.L$0 = kVar;
        bVar2.L$1 = byteBuffer2;
        bVar2.L$2 = aVar3;
        bVar2.label = 1;
        objG = kVar.G(cVar, bVar2);
        if (objG == aVar2) {
            return aVar2;
        }
        kVar2 = kVar;
        byteBuffer3 = byteBuffer2;
        aVar = aVar3;
        iIntValue = ((Number) objG).intValue();
        if (iIntValue > 0 && kVar2.e() && !aVar.element) {
            bVar2.L$0 = null;
            bVar2.L$1 = null;
            bVar2.L$2 = null;
            bVar2.I$0 = iIntValue;
            bVar2.label = 2;
            Object objN0 = kVar2.n0(byteBuffer3, bVar2);
            if (objN0 == aVar2) {
                return aVar2;
            }
            i11 = iIntValue;
            objG = objN0;
            iIntValue2 = ((Number) objG).intValue();
            if (iIntValue2 < 0) {
                iIntValue2 = 0;
            }
            iIntValue = iIntValue2 + i11;
        } else if (iIntValue == 0 && kVar2.p0()) {
            iIntValue = -1;
        }
        return new Integer(iIntValue);
    }

    @os.m
    public static final Object h(@os.l k kVar, @os.l ByteBuffer byteBuffer, @os.l um.d<? super l2> dVar) {
        Object objI;
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        k1.a aVar = new k1.a();
        kVar.X(new d(aVar, byteBuffer));
        return (aVar.element || (objI = i(kVar, byteBuffer, dVar)) != wm.a.COROUTINE_SUSPENDED) ? l2.f10208a : objI;
    }

    public static final Object i(k kVar, ByteBuffer byteBuffer, um.d<? super l2> dVar) {
        Object objG = kVar.G(new e(byteBuffer, null), dVar);
        return objG == wm.a.COROUTINE_SUSPENDED ? objG : l2.f10208a;
    }

    public static final int j(b0 b0Var, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferB = b0Var.b(0, 1);
        if (byteBufferB == null) {
            return 0;
        }
        int iB = wl.n.b(byteBufferB, byteBuffer);
        if (iB != 0) {
            return -1;
        }
        int iMin = Math.min(byteBufferB.remaining() - iB, byteBuffer.remaining());
        int iRemaining = byteBuffer.remaining() - iMin;
        if (iRemaining > 0) {
            ByteBuffer byteBufferB2 = b0Var.b(iB + iMin, iRemaining);
            if (byteBufferB2 == null) {
                return iMin;
            }
            if (!wl.n.h(byteBufferB2, byteBuffer, iMin)) {
                return -1;
            }
        }
        return byteBuffer.remaining();
    }

    public static final int k(b0 b0Var, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int iE;
        boolean z10 = false;
        ByteBuffer byteBufferB = b0Var.b(0, 1);
        if (byteBufferB == null) {
            return 0;
        }
        int iB = wl.n.b(byteBufferB, byteBuffer);
        if (iB != -1) {
            int iMin = Math.min(byteBufferB.remaining() - iB, byteBuffer.remaining());
            int iRemaining = byteBuffer.remaining() - iMin;
            if (iRemaining == 0) {
                iE = wl.n.f(byteBuffer2, byteBufferB, byteBufferB.position() + iB);
            } else {
                ByteBuffer byteBufferDuplicate = byteBufferB.duplicate();
                ByteBuffer byteBufferB2 = b0Var.b(iB + iMin, 1);
                if (byteBufferB2 == null) {
                    kn.l0.o(byteBufferDuplicate, "remembered");
                    iE = wl.n.f(byteBuffer2, byteBufferDuplicate, byteBufferDuplicate.position() + iB);
                } else if (!wl.n.h(byteBufferB2, byteBuffer, iMin)) {
                    kn.l0.o(byteBufferDuplicate, "remembered");
                    iE = wl.n.f(byteBuffer2, byteBufferDuplicate, byteBufferDuplicate.position() + iB + 1);
                } else if (byteBufferB2.remaining() >= iRemaining) {
                    kn.l0.o(byteBufferDuplicate, "remembered");
                    iE = wl.n.f(byteBuffer2, byteBufferDuplicate, byteBufferDuplicate.position() + iB);
                } else {
                    kn.l0.o(byteBufferDuplicate, "remembered");
                    iE = wl.n.f(byteBuffer2, byteBufferDuplicate, byteBufferDuplicate.position() + iB);
                }
            }
            z10 = true;
        } else {
            iE = wl.n.e(byteBuffer2, byteBufferB, 0, 2, null);
        }
        b0Var.b0(iE);
        return z10 ? -iE : iE;
    }

    public static final int l(b0 b0Var, ByteBuffer byteBuffer) throws IOException {
        int iJ = j(b0Var, byteBuffer);
        if (iJ == -1) {
            throw new IOException("Failed to skip delimiter: actual bytes differ from delimiter bytes");
        }
        if (iJ < byteBuffer.remaining()) {
            return iJ;
        }
        b0Var.b0(byteBuffer.remaining());
        return byteBuffer.remaining();
    }
}
