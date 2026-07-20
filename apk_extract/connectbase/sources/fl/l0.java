package fl;

import java.nio.ByteBuffer;
import java.util.zip.Checksum;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6062a = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public static final k0 f6063b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public static final k0 f6064c = new b();

    public static final class a implements k0 {
        @Override // fl.k0
        @os.l
        public pl.k a(@os.l nq.s0 s0Var, @os.l pl.k kVar) {
            kn.l0.p(s0Var, "<this>");
            kn.l0.p(kVar, "source");
            return l0.g(s0Var, kVar, false);
        }

        @Override // fl.k0
        @os.l
        public pl.k b(@os.l nq.s0 s0Var, @os.l pl.k kVar) {
            kn.l0.p(s0Var, "<this>");
            kn.l0.p(kVar, "source");
            return f0.i(kVar, true, null, s0Var.getCoroutineContext(), 2, null);
        }
    }

    public static final class b implements k0 {
        @Override // fl.k0
        @os.l
        public pl.k a(@os.l nq.s0 s0Var, @os.l pl.k kVar) {
            kn.l0.p(s0Var, "<this>");
            kn.l0.p(kVar, "source");
            return l0.h(s0Var, kVar, false, 2, null);
        }

        @Override // fl.k0
        @os.l
        public pl.k b(@os.l nq.s0 s0Var, @os.l pl.k kVar) {
            kn.l0.p(s0Var, "<this>");
            kn.l0.p(kVar, "source");
            return f0.i(kVar, true, null, s0Var.getCoroutineContext(), 2, null);
        }
    }

    @xm.f(c = "io.ktor.util.EncodersJvmKt$inflate$1", f = "EncodersJvm.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {68, 85, 163, 166, 103, 109, 123}, m = "invokeSuspend", n = {"$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "extraLen", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "n$iv", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    public static final class c extends xm.o implements jn.p<pl.m0, um.d<? super l2>, Object> {
        final /* synthetic */ boolean $gzip;
        final /* synthetic */ pl.k $source;
        byte B$0;
        byte B$1;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        short S$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(boolean z10, pl.k kVar, um.d<? super c> dVar) {
            super(2, dVar);
            this.$gzip = z10;
            this.$source = kVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            c cVar = new c(this.$gzip, this.$source, dVar);
            cVar.L$0 = obj;
            return cVar;
        }

        /* JADX WARN: Code duplicated, block: B:75:0x028e A[Catch: all -> 0x003d, TryCatch #2 {all -> 0x003d, blocks: (B:7:0x0034, B:105:0x034f, B:99:0x0327, B:101:0x032d, B:106:0x0367, B:108:0x036b, B:110:0x0373, B:112:0x0391, B:115:0x0396, B:116:0x03ba, B:117:0x03bb, B:118:0x03c2, B:119:0x03c3, B:120:0x03e6, B:121:0x03e7, B:125:0x03ff, B:126:0x0406, B:12:0x005e, B:90:0x02f5, B:82:0x02c4, B:84:0x02ca, B:86:0x02d0, B:91:0x030e, B:73:0x0286, B:75:0x028e, B:78:0x02a9, B:81:0x02b2, B:92:0x0313, B:94:0x0319, B:97:0x0320, B:98:0x0321, B:15:0x0080), top: B:137:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:77:0x02a8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:80:0x02b1  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x034d -> B:105:0x034f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x02b1 -> B:73:0x0286). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x02b2 -> B:82:0x02c4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x02f0 -> B:90:0x02f5). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 1072
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: fl.l0.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l pl.m0 m0Var, @os.m um.d<? super l2> dVar) {
            return ((c) create(m0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "io.ktor.util.EncodersJvmKt", f = "EncodersJvm.kt", i = {0}, l = {159}, m = "inflateTo", n = {"inflated"}, s = {"I$0"})
    public static final class d extends xm.d {
        int I$0;
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
            return l0.i(null, null, null, null, this);
        }
    }

    @os.l
    public static final k0 d() {
        return f6063b;
    }

    @os.l
    public static final k0 e() {
        return f6064c;
    }

    public static final boolean f(int i10, int i11) {
        return (i10 & i11) != 0;
    }

    public static final pl.k g(nq.s0 s0Var, pl.k kVar, boolean z10) {
        return pl.v.o(s0Var, null, false, new c(z10, kVar, null), 3, null).a();
    }

    public static /* synthetic */ pl.k h(nq.s0 s0Var, pl.k kVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return g(s0Var, kVar, z10);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object i(Inflater inflater, pl.n nVar, ByteBuffer byteBuffer, Checksum checksum, um.d<? super Integer> dVar) throws DataFormatException {
        d dVar2;
        int iInflate;
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
        Object obj = dVar2.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = dVar2.label;
        if (i11 == 0) {
            lm.d1.n(obj);
            byteBuffer.clear();
            iInflate = inflater.inflate(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
            byteBuffer.position(byteBuffer.position() + iInflate);
            byteBuffer.flip();
            f0.o(checksum, byteBuffer);
            dVar2.I$0 = iInflate;
            dVar2.label = 1;
            if (nVar.M(byteBuffer, dVar2) == obj2) {
                return obj2;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            iInflate = dVar2.I$0;
            lm.d1.n(obj);
        }
        return new Integer(iInflate);
    }
}
