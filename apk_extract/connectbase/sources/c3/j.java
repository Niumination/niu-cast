package c3;

import androidx.constraintlayout.widget.ConstraintLayout;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.w;
import lm.d1;
import lm.t0;
import nq.l2;
import nq.s0;
import nq.x3;
import r2.s;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nFileDataSender.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileDataSender.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileDataSender\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus\n*L\n1#1,228:1\n1#2:229\n53#3:230\n*S KotlinDebug\n*F\n+ 1 FileDataSender.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileDataSender\n*L\n134#1:230\n*E\n"})
public final class j implements s0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public static final a f1296v = new a();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public static final String f1297w = "FileDataSender";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final r2.k f1298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f1299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public l2 f1302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public Exception f1303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1304g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1305i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f1306n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final byte[] f1307p;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    @r1({"SMAP\nDataBus.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus$receiveWitTimeOut$2\n*L\n1#1,116:1\n*E\n"})
    @xm.f(c = "com.transsion.airtransfer.filetransfer.databus.DataBus$receiveWitTimeOut$2", f = "DataBus.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends xm.o implements jn.p<s0, um.d<? super r2.q>, Object> {
        final /* synthetic */ Integer $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Integer num, um.d dVar) {
            super(2, dVar);
            this.$type = num;
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new b(this.$type, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                w2.a aVarG = u2.b.f16175b.g(r2.q.class);
                Integer num = this.$type;
                this.label = 1;
                obj = aVarG.b(num, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return obj;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super r2.q> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataSender", f = "FileDataSender.kt", i = {0, 0, 0}, l = {229, 143}, m = "listenReceiveFinish", n = {"this", "onTimeout", "onFinishCallback"}, s = {"L$0", "L$1", "L$2"})
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
            return j.this.B(null, null, this);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataSender$onCancelReceive$1", f = "FileDataSender.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends xm.o implements jn.p<s0, um.d<? super lm.l2>, Object> {
        final /* synthetic */ int $currentFileIndex;
        final /* synthetic */ long $sentLength;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(int i10, long j10, um.d<? super d> dVar) {
            super(2, dVar);
            this.$currentFileIndex = i10;
            this.$sentLength = j10;
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return j.this.new d(this.$currentFileIndex, this.$sentLength, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                j3.b.f8554a.e(j.f1297w, "send cancel receive reply msg");
                r2.p.b(u2.b.f16175b, new r2.c(j.this.f1298a.f14187a, j.this.f1298a.f14189c.get(this.$currentFileIndex).f14176a, this.$sentLength), null, 2, null);
                j jVar = j.this;
                this.label = 1;
                if (jVar.N(true, this) == aVar) {
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
            return ((d) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataSender$onCancelSend$1", f = "FileDataSender.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends xm.o implements jn.p<s0, um.d<? super lm.l2>, Object> {
        final /* synthetic */ int $currentFileIndex;
        final /* synthetic */ long $sentLength;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(int i10, long j10, um.d<? super e> dVar) {
            super(2, dVar);
            this.$currentFileIndex = i10;
            this.$sentLength = j10;
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return j.this.new e(this.$currentFileIndex, this.$sentLength, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                j3.b.f8554a.e(j.f1297w, "send cancel send msg");
                r2.p.b(u2.b.f16175b, new r2.d(j.this.f1298a.f14187a, j.this.f1298a.f14189c.get(this.$currentFileIndex).f14176a, this.$sentLength), null, 2, null);
                j jVar = j.this;
                this.label = 1;
                if (jVar.N(false, this) == aVar) {
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
            return ((e) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataSender$onProgress$1", f = "FileDataSender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends xm.o implements jn.p<s0, um.d<? super lm.l2>, Object> {
        final /* synthetic */ int $currentFileIndex;
        final /* synthetic */ long $sentLength;
        final /* synthetic */ int $totalFiles;
        final /* synthetic */ long $totalLength;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(long j10, long j11, int i10, int i11, um.d<? super f> dVar) {
            super(2, dVar);
            this.$sentLength = j10;
            this.$totalLength = j11;
            this.$currentFileIndex = i10;
            this.$totalFiles = i11;
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return j.this.new f(this.$sentLength, this.$totalLength, this.$currentFileIndex, this.$totalFiles, dVar);
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
            q qVar = q2.c.f13806e;
            if (qVar != null) {
                qVar.onProgress(j.this.f1298a.f14187a, (this.$sentLength * 1.0d) / this.$totalLength, this.$currentFileIndex, this.$totalFiles);
            }
            return lm.l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super lm.l2> dVar) {
            return ((f) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataSender", f = "FileDataSender.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {103, 109}, m = "sendFile", n = {"this", "fileDataChannel", "fileData", "totalLength", "this", "fileDataChannel", "dataStream", "length", "totalLength", "startTime"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1"})
    public static final class g extends xm.d {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
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
            return j.this.I(null, this);
        }
    }

    @r1({"SMAP\nFileDataSender.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileDataSender.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileDataSender$start$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,228:1\n766#2:229\n857#2,2:230\n*S KotlinDebug\n*F\n+ 1 FileDataSender.kt\ncom/transsion/airtransfer/filetransfer/process/file/FileDataSender$start$1\n*L\n53#1:229\n53#1:230,2\n*E\n"})
    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataSender$start$1", f = "FileDataSender.kt", i = {0, 1}, l = {63, ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT, 81}, m = "invokeSuspend", n = {"fileDataChannel", "fileDataChannel"}, s = {"L$0", "L$0"})
    public static final class h extends xm.o implements jn.p<s0, um.d<? super lm.l2>, Object> {
        Object L$0;
        int label;

        public static final class a extends n0 implements jn.a<lm.l2> {
            final /* synthetic */ j this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(j jVar) {
                super(0);
                this.this$0 = jVar;
            }

            @Override // jn.a
            public /* bridge */ /* synthetic */ lm.l2 invoke() {
                invoke2();
                return lm.l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                q2.c.f13803b.getClass();
                q qVar = q2.c.f13806e;
                if (qVar != null) {
                    qVar.b(this.this$0.f1298a.f14187a, r2.w.WAIT_RECEIVE_SUCCESS_TIMEOUT);
                }
            }
        }

        public static final class b extends n0 implements jn.a<lm.l2> {
            final /* synthetic */ j this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(j jVar) {
                super(0);
                this.this$0 = jVar;
            }

            @Override // jn.a
            public /* bridge */ /* synthetic */ lm.l2 invoke() {
                invoke2();
                return lm.l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.F();
            }
        }

        public h(um.d<? super h> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return j.this.new h(dVar);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:29:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:31:0x00cb A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00c9 -> B:32:0x00cc). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // xm.a
        @os.m
        public final java.lang.Object invokeSuspend(@os.l java.lang.Object r12) {
            /*
                Method dump skipped, instruction units count: 329
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: c3.j.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super lm.l2> dVar) {
            return ((h) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.process.file.FileDataSender$startCancelMsgReceiveJob$1", f = "FileDataSender.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends xm.o implements jn.p<s0, um.d<? super lm.l2>, Object> {
        final /* synthetic */ r2.k $data;
        int label;
        final /* synthetic */ j this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(r2.k kVar, j jVar, um.d<? super i> dVar) {
            super(2, dVar);
            this.$data = kVar;
            this.this$0 = jVar;
        }

        @Override // xm.a
        @os.l
        public final um.d<lm.l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
            return new i(this.$data, this.this$0, dVar);
        }

        @Override // xm.a
        @os.m
        public final Object invokeSuspend(@os.l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                j3.b.f8554a.e(j.f1297w, "receive cancel msg start");
                u2.b bVar = u2.b.f16175b;
                t0<Integer, Class<?>>[] t0VarArr = {new t0(new Integer(1), r2.a.class), new t0(new Integer(2), r2.b.class), new t0(new Integer(1), s.class)};
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
            j3.b.f8554a.e(j.f1297w, "receive cancel msg " + obj);
            long jB = obj instanceof r2.o ? ((r2.o) obj).b() : 0L;
            if (jB == this.$data.f14187a || ((obj instanceof r2.a) && jB == 0)) {
                this.this$0.f1300c = true;
                this.this$0.f1301d = obj instanceof r2.b;
            } else if (obj instanceof s) {
                this.this$0.f1300c = true;
                this.this$0.f1303f = ((s) obj).f14203g;
            } else {
                m.f1313a.f(jB);
                this.this$0.M(this.$data);
            }
            return lm.l2.f10208a;
        }

        @Override // jn.p
        @os.m
        public final Object invoke(@os.l s0 s0Var, @os.m um.d<? super lm.l2> dVar) {
            return ((i) create(s0Var, dVar)).invokeSuspend(lm.l2.f10208a);
        }
    }

    /* JADX INFO: renamed from: c3.j$j, reason: collision with other inner class name */
    public static final class C0054j extends n0 implements jn.a<lm.l2> {
        final /* synthetic */ boolean $isRemoteCancel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0054j(boolean z10) {
            super(0);
            this.$isRemoteCancel = z10;
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ lm.l2 invoke() {
            invoke2();
            return lm.l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            q2.c.f13803b.getClass();
            q qVar = q2.c.f13806e;
            if (qVar != null) {
                qVar.onCancel(j.this.f1298a.f14187a, this.$isRemoteCancel);
            }
        }
    }

    public j(@os.l r2.k kVar) {
        l0.p(kVar, "fileTaskInfo");
        this.f1298a = kVar;
        this.f1299b = s2.d.a();
        this.f1307p = new byte[1048576];
    }

    private final l2 G(long j10, long j11, int i10, int i11) {
        return nq.k.f(this, null, null, new f(j10, j11, i10, i11, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        M(this.f1298a);
        q2.c.f13803b.getClass();
        q qVar = q2.c.f13806e;
        if (qVar != null) {
            qVar.g(this.f1298a.f14187a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object B(jn.a<lm.l2> aVar, jn.a<lm.l2> aVar2, um.d<? super lm.l2> dVar) {
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
        Object objF = cVar.result;
        wm.a aVar3 = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                aVar2 = (jn.a) cVar.L$2;
                aVar = (jn.a) cVar.L$1;
                this = (j) cVar.L$0;
                d1.n(objF);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(objF);
            }
            return lm.l2.f10208a;
        }
        d1.n(objF);
        u2.b bVar = u2.b.f16175b;
        Integer num = new Integer(2);
        lq.e.a aVar4 = lq.e.f10247b;
        long jM0 = lq.g.m0(10000, lq.h.MILLISECONDS);
        b bVar2 = new b(num, null);
        cVar.L$0 = this;
        cVar.L$1 = aVar;
        cVar.L$2 = aVar2;
        cVar.label = 1;
        objF = x3.f(jM0, bVar2, cVar);
        if (objF == aVar3) {
            return aVar3;
        }
        r2.q qVar = (r2.q) objF;
        j3.b bVar3 = j3.b.f8554a;
        StringBuilder sb2 = new StringBuilder("receiveFinish taskId = ");
        sb2.append(qVar != null ? new Long(qVar.f14201h) : null);
        bVar3.e(f1297w, sb2.toString());
        if (qVar == null) {
            aVar.invoke();
            return lm.l2.f10208a;
        }
        if (qVar.f14201h == this.f1298a.f14187a) {
            aVar2.invoke();
            return lm.l2.f10208a;
        }
        cVar.L$0 = null;
        cVar.L$1 = null;
        cVar.L$2 = null;
        cVar.label = 2;
        if (this.B(aVar, aVar2, cVar) == aVar3) {
            return aVar3;
        }
        return lm.l2.f10208a;
    }

    public final l2 C(int i10, long j10) {
        return nq.k.f(this, null, null, new d(i10, j10, null), 3, null);
    }

    public final l2 D(int i10, long j10) {
        return nq.k.f(this, null, null, new e(i10, j10, null), 3, null);
    }

    public final void F() {
        l2 l2Var = this.f1302e;
        if (l2Var != null) {
            l2.a.b(l2Var, null, 1, null);
        }
        q2.c.f13803b.getClass();
        q qVar = q2.c.f13806e;
        if (qVar != null) {
            qVar.onFinish(this.f1298a.f14187a);
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00c8 A[Catch: all -> 0x010f, TryCatch #4 {all -> 0x010f, blocks: (B:44:0x00f0, B:36:0x00c4, B:38:0x00c8, B:40:0x00d2, B:47:0x0112), top: B:66:0x00f0 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x00d2 A[Catch: all -> 0x010f, TryCatch #4 {all -> 0x010f, blocks: (B:44:0x00f0, B:36:0x00c4, B:38:0x00c8, B:40:0x00d2, B:47:0x0112), top: B:66:0x00f0 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00eb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00ec -> B:66:0x00f0). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object I(r2.g r22, um.d<? super lm.l2> r23) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.j.I(r2.g, um.d):java.lang.Object");
    }

    public final Object J(r2.j jVar, r2.g gVar, um.d<? super lm.l2> dVar) {
        byte[] bArrA = s2.a.a(k.f1308a.b(c3.f.a(jVar)));
        Object objE = gVar.e(bArrA, 0, bArrA.length, dVar);
        return objE == wm.a.COROUTINE_SUSPENDED ? objE : lm.l2.f10208a;
    }

    @os.l
    public final l2 L() {
        return nq.k.f(this, null, null, new h(null), 3, null);
    }

    public final void M(r2.k kVar) {
        this.f1302e = nq.k.f(this, null, null, new i(kVar, this, null), 3, null);
    }

    public final Object N(boolean z10, um.d<? super lm.l2> dVar) {
        C0054j c0054j = new C0054j(z10);
        Object objB = B(c0054j, c0054j, dVar);
        return objB == wm.a.COROUTINE_SUSPENDED ? objB : lm.l2.f10208a;
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.f1299b.getCoroutineContext();
    }
}
