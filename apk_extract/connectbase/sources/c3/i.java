package c3;

import android.os.Handler;
import android.os.HandlerThread;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.w;
import lm.d0;
import lm.d1;
import lm.f0;
import lm.t0;
import nm.h0;
import nq.l2;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nFileDataReceiver.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileDataReceiver.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileDataReceiver\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,325:1\n766#2:326\n857#2,2:327\n288#2,2:329\n*S KotlinDebug\n*F\n+ 1 FileDataReceiver.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileDataReceiver\n*L\n119#1:326\n119#1:327,2\n121#1:329,2\n*E\n"})
public final class i implements s0 {

    @os.l
    public static final a N = new a();

    @os.l
    public static final String O = "FileDataReceiver";
    public static final int P = 0;
    public static final int Q = 1;
    public static final int R = 2;
    public static final long S = 20000;

    @os.m
    public r2.g H;
    public boolean I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1282b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1287g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1288i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1289n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f1290p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.m
    public OutputStream f1291v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1292w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1293x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1294y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.m
    public l2 f1295z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s0 f1281a = s2.d.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteBuf f1283c = Unpooled.buffer();

    @os.l
    public final x2.b J = c3.c.f1273a.a();

    @os.l
    public final d0 K = f0.b(d.INSTANCE);
    public long L = System.currentTimeMillis();

    @os.l
    public final Runnable M = new Runnable() { // from class: c3.h
        @Override // java.lang.Runnable
        public final void run() {
            i.M(this.f1280a);
        }
    };

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public static final class b extends n0 implements jn.l<Long, lm.l2> {
        public b() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(Long l10) {
            invoke(l10.longValue());
            return lm.l2.f10208a;
        }

        public final void invoke(long j10) {
            q2.c.f13803b.getClass();
            p pVar = q2.c.f13805d;
            if (pVar != null) {
                pVar.onCancel(j10, i.this.f1294y);
            }
        }
    }

    public static final class c extends n0 implements jn.l<Long, lm.l2> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ lm.l2 invoke(Long l10) {
            invoke(l10.longValue());
            return lm.l2.f10208a;
        }

        public final void invoke(long j10) {
            q2.c.f13803b.getClass();
            p pVar = q2.c.f13805d;
            if (pVar != null) {
                pVar.onFinish(j10);
            }
        }
    }

    public static final class d extends n0 implements jn.a<Handler> {
        public static final d INSTANCE = new d();

        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final Handler invoke() {
            HandlerThread handlerThread = new HandlerThread(i.O);
            handlerThread.start();
            return new Handler(handlerThread.getLooper());
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataReceiver$onProgress$1", f = "FileDataReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends xm.o implements jn.p<s0, um.d<? super lm.l2>, Object> {
        final /* synthetic */ int $currentFileIndex;
        final /* synthetic */ long $receiveLength;
        final /* synthetic */ int $totalFiles;
        final /* synthetic */ long $totalLength;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j10, long j11, int i10, int i11, um.d<? super e> dVar) {
            super(2, dVar);
            this.$receiveLength = j10;
            this.$totalLength = j11;
            this.$currentFileIndex = i10;
            this.$totalFiles = i11;
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return i.this.new e(this.$receiveLength, this.$totalLength, this.$currentFileIndex, this.$totalFiles, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            q2.c.f13803b.getClass();
            p pVar = q2.c.f13805d;
            if (pVar != null) {
                pVar.onProgress(i.this.f1290p, (this.$receiveLength * 1.0d) / this.$totalLength, this.$currentFileIndex, this.$totalFiles);
            }
            return lm.l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super lm.l2> dVar) {
            return ((e) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    public static final class f extends n0 implements jn.a<lm.l2> {
        final /* synthetic */ jn.l<Long, lm.l2> $block;
        final /* synthetic */ long $taskId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public f(jn.l<? super Long, lm.l2> lVar, long j10) {
            super(0);
            this.$block = lVar;
            this.$taskId = j10;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ lm.l2 invoke() {
            invoke2();
            return lm.l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            jn.l<Long, lm.l2> lVar = this.$block;
            if (lVar != null) {
                lVar.invoke(Long.valueOf(this.$taskId));
            }
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataReceiver$receiveData$1", f = "FileDataReceiver.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends xm.o implements jn.p<s0, um.d<? super lm.l2>, Object> {
        final /* synthetic */ r2.g $fileDataChannel;
        int label;

        public static final class a extends n0 implements jn.q<byte[], Integer, Integer, lm.l2> {
            final /* synthetic */ i this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(i iVar) {
                super(3);
                this.this$0 = iVar;
            }

            @Override // jn.q
            public /* bridge */ /* synthetic */ lm.l2 invoke(byte[] bArr, Integer num, Integer num2) {
                invoke(bArr, num.intValue(), num2.intValue());
                return lm.l2.f10208a;
            }

            public final void invoke(@os.l byte[] bArr, int i10, int i11) {
                l0.p(bArr, "data");
                if (this.this$0.I) {
                    return;
                }
                i iVar = this.this$0;
                if (iVar.f1293x) {
                    return;
                }
                if (bArr.length != 0 && i11 > 0) {
                    if (iVar.A()) {
                        this.this$0.v(bArr, i10, i11);
                        return;
                    } else {
                        this.this$0.L(bArr, i10, i11);
                        return;
                    }
                }
                if (iVar.f1290p > 0) {
                    q2.c.f13803b.getClass();
                    p pVar = q2.c.f13805d;
                    if (pVar != null) {
                        pVar.b(this.this$0.f1290p, r2.w.FILE_CHANNEL_CLOSE);
                    }
                }
                i.H(this.this$0, false, null, 2, null);
                this.this$0.N();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(r2.g gVar, um.d<? super g> dVar) {
            super(2, dVar);
            this.$fileDataChannel = gVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return i.this.new g(this.$fileDataChannel, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                i.this.H = this.$fileDataChannel;
                r2.g gVar = this.$fileDataChannel;
                a aVar2 = new a(i.this);
                this.label = 1;
                if (gVar.d(aVar2, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return lm.l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super lm.l2> dVar) {
            return ((g) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataReceiver$startCancelMsgReceiveJob$1", f = "FileDataReceiver.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends xm.o implements jn.p<s0, um.d<? super lm.l2>, Object> {
        int label;

        public h(um.d<? super h> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return i.this.new h(dVar);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00b8  */
        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                j3.b.f8554a.e(i.O, "receive cancel send request start");
                u2.b bVar = u2.b.f16175b;
                t0<Integer, Class<?>>[] t0VarArr = {new t0(new Integer(1), r2.a.class), new t0(new Integer(2), r2.d.class), new t0(new Integer(2), r2.c.class)};
                this.label = 1;
                obj = bVar.m(t0VarArr, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            j3.b bVar2 = j3.b.f8554a;
            bVar2.e(i.O, "receive cancel msg " + obj);
            if (obj instanceof r2.o) {
                r2.o oVar = (r2.o) obj;
                if (oVar.b() == i.this.f1290p || ((obj instanceof r2.a) && oVar.b() == 0)) {
                    bVar2.e(i.O, "receive cancel msg handle");
                    if (obj instanceof r2.a) {
                        i.this.D();
                    }
                    if (obj instanceof r2.d) {
                        i.this.B(((r2.d) obj).f14155j, true);
                    }
                    if (obj instanceof r2.c) {
                        i.C(i.this, ((r2.c) obj).f14152j, false, 2, null);
                    }
                } else {
                    i.this.P();
                }
            } else {
                i.this.P();
            }
            return lm.l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super lm.l2> dVar) {
            return ((h) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(long j10, boolean z10) {
        this.f1285e = j10;
        this.f1292w = true;
        this.f1294y = z10;
        s();
    }

    public static /* synthetic */ void C(i iVar, long j10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        iVar.B(j10, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void H(i iVar, boolean z10, jn.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        iVar.G(z10, lVar);
    }

    private final void I() {
        q2.c.f13803b.getClass();
        p pVar = q2.c.f13805d;
        if (pVar != null) {
            pVar.g(this.f1290p);
        }
    }

    public static final void M(i iVar) {
        l0.p(iVar, "this$0");
        j3.b.f8554a.c(O, "receive file data timeout");
        iVar.I = true;
        q2.c.f13803b.getClass();
        p pVar = q2.c.f13805d;
        if (pVar != null) {
            pVar.b(iVar.f1290p, r2.w.RECEIVE_FILE_TIMEOUT);
        }
        H(iVar, false, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        this.f1284d = 0L;
        this.f1285e = 0L;
        this.f1292w = false;
        try {
            OutputStream outputStream = this.f1291v;
            if (outputStream != null) {
                outputStream.close();
            }
            this.f1291v = null;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f1282b = 0;
    }

    public final boolean A() {
        int i10 = this.f1282b;
        return i10 == 0 || i10 == 1;
    }

    public final void D() {
        r2.p.b(u2.b.f16175b, new r2.b(this.f1290p), null, 2, null);
        P();
    }

    public final l2 F(long j10, long j11, int i10, int i11) {
        return nq.k.f(this, null, null, new e(j10, j11, i10, i11, null), 3, null);
    }

    public final void G(boolean z10, jn.l<? super Long, lm.l2> lVar) {
        long j10 = this.f1290p;
        l2 l2Var = this.f1295z;
        if (l2Var != null) {
            l2.a.b(l2Var, null, 1, null);
        }
        r();
        if (z10) {
            r2.p.a(u2.b.f16175b, new r2.q(j10), new f(lVar, j10));
        }
        r2.g gVar = this.H;
        if (gVar != null) {
            gVar.a();
        }
        this.f1290p = 0L;
        this.f1283c.clear();
    }

    @os.l
    public final l2 J(@os.l r2.g gVar) {
        l0.p(gVar, "fileDataChannel");
        return nq.k.f(this, null, null, new g(gVar, null), 3, null);
    }

    public final void L(byte[] bArr, int i10, int i11) {
        try {
            if (this.I) {
                return;
            }
            long j10 = this.f1284d;
            long j11 = i11;
            long j12 = j10 + j11;
            long j13 = this.f1285e;
            if (j12 <= j13) {
                OutputStream outputStream = this.f1291v;
                if (outputStream != null) {
                    outputStream.write(bArr, i10, i11);
                }
                this.f1284d += j11;
            } else {
                int i12 = (int) (j13 - j10);
                OutputStream outputStream2 = this.f1291v;
                if (outputStream2 != null) {
                    outputStream2.write(bArr, 0, i12);
                }
                this.f1284d = this.f1285e;
                j3.b bVar = j3.b.f8554a;
                StringBuilder sb2 = new StringBuilder("receiveFileDat last length ");
                int i13 = i11 - i12;
                sb2.append(i13);
                bVar.e(O, sb2.toString());
                this.f1283c.writeBytes(bArr, i12 + i10, i13);
            }
            if (!this.f1292w) {
                F(this.f1284d, this.f1285e, this.f1287g, this.f1289n);
            }
            s();
        } catch (Exception e10) {
            j3.b.f8554a.d(O, e10);
            this.I = true;
            q2.c.f13803b.getClass();
            p pVar = q2.c.f13805d;
            if (pVar != null) {
                pVar.a(this.f1290p, e10);
            }
            H(this, false, null, 2, null);
        }
    }

    public final void O(long j10) {
        this.L = j10;
    }

    public final void P() {
        this.f1295z = nq.k.f(this, null, null, new h(null), 3, null);
    }

    public final void Q() {
        r();
        w().postDelayed(this.M, S);
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f1281a.getCoroutineContext();
    }

    public final void r() {
        w().removeCallbacks(this.M);
    }

    public final void s() {
        if (this.f1284d < this.f1285e) {
            Q();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        j3.b bVar = j3.b.f8554a;
        StringBuilder sb2 = new StringBuilder("receive speed is ");
        double d10 = 1024;
        sb2.append((((this.f1285e * 1.0d) / d10) / d10) / (((jCurrentTimeMillis - this.L) * 1.0d) / ((double) 1000)));
        sb2.append(" MB/S");
        bVar.e(O, sb2.toString());
        bVar.e(O, "receive data size " + this.f1284d + " totalsize : " + this.f1285e);
        if (this.f1292w) {
            this.f1293x = true;
            H(this, false, new b(), 1, null);
        } else if (this.f1286f == this.f1288i - 1) {
            H(this, false, c.INSTANCE, 1, null);
        } else {
            Q();
        }
        N();
        if (this.f1283c.readableBytes() >= 32) {
            u();
        }
    }

    public final OutputStream t(r2.j jVar) {
        OutputStream outputStreamA = this.J.a(jVar.f14177b);
        if (outputStreamA == null) {
            this.I = true;
            q2.c.f13803b.getClass();
            p pVar = q2.c.f13805d;
            if (pVar != null) {
                pVar.b(this.f1290p, r2.w.FILE_OPERATION_ERROR);
            }
            H(this, false, null, 2, null);
        }
        return outputStreamA;
    }

    public final void u() {
        ArrayList arrayList;
        List<r2.j> list;
        List<r2.j> list2;
        List<r2.j> list3;
        this.f1282b = 1;
        k kVar = k.f1308a;
        ByteBuf byteBuf = this.f1283c;
        l0.o(byteBuf, "headerBuf");
        r2.i iVarA = kVar.a(byteBuf);
        j3.b.f8554a.e(O, "file header " + iVarA);
        if (iVarA == null) {
            if (this.f1283c.readableBytes() > 32) {
                this.f1283c.clear();
                return;
            }
            return;
        }
        this.L = System.currentTimeMillis();
        this.f1284d = 0L;
        r2.k kVarG = m.f1313a.g(iVarA.f14169b);
        r2.j jVar = null;
        Object obj = null;
        if (kVarG == null || (list3 = kVarG.f14189c) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj2 : list3) {
                if (((r2.j) obj2).f14178c > 0) {
                    arrayList.add(obj2);
                }
            }
        }
        j3.b.f8554a.e(O, "file task info " + kVarG);
        if (arrayList != null) {
            for (Object obj3 : arrayList) {
                if (((r2.j) obj3).f14176a == iVarA.f14169b) {
                    obj = obj3;
                    break;
                }
            }
            jVar = (r2.j) obj;
        }
        this.f1287g = (kVarG == null || (list2 = kVarG.f14189c) == null) ? 0 : h0.d3(list2, jVar);
        this.f1286f = arrayList != null ? h0.d3(arrayList, jVar) : 0;
        this.f1289n = (kVarG == null || (list = kVarG.f14189c) == null) ? 0 : list.size();
        this.f1288i = arrayList != null ? arrayList.size() : 0;
        long j10 = kVarG != null ? kVarG.f14187a : 0L;
        this.f1290p = j10;
        if (kVarG == null || jVar == null || j10 == 0) {
            return;
        }
        this.f1285e = jVar.f14178c;
        P();
        this.f1282b = 2;
        if (this.f1286f == 0) {
            I();
        }
        this.f1291v = t(jVar);
        if (this.f1283c.readableBytes() <= 0) {
            this.f1283c.clear();
            return;
        }
        ByteBuf byteBuf2 = this.f1283c;
        l0.o(byteBuf2, "headerBuf");
        byte[] bArrA = s2.a.a(byteBuf2);
        this.f1283c.clear();
        L(bArrA, 0, bArrA.length);
    }

    public final void v(byte[] bArr, int i10, int i11) {
        this.f1283c.writeBytes(bArr, i10, i11);
        u();
    }

    public final Handler w() {
        return (Handler) this.K.getValue();
    }

    public final long x() {
        return this.L;
    }

    public final boolean y() {
        return this.f1282b == 2;
    }
}
