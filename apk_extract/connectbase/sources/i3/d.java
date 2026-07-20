package i3;

import java.io.IOException;
import java.io.OutputStream;
import jn.p;
import jn.q;
import kn.l0;
import kn.n0;
import kn.r1;
import kn.w;
import lm.d1;
import lm.l2;
import nq.k;
import nq.s0;
import os.l;
import os.m;
import r2.g;
import r2.s;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nSocketDataSender.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SocketDataSender.kt\ncom/transsion/airtransfer/filetransfer/transmission/socket/SocketDataSender\n+ 2 DataBus.kt\ncom/transsion/airtransfer/filetransfer/databus/DataBus\n*L\n1#1,64:1\n45#2,2:65\n*S KotlinDebug\n*F\n+ 1 SocketDataSender.kt\ncom/transsion/airtransfer/filetransfer/transmission/socket/SocketDataSender\n*L\n62#1:65,2\n*E\n"})
public final class d extends f3.b<g> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final a f7706f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static final String f7707g = "SocketDataSender";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final OutputStream f7708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public final pq.l<Integer> f7710e;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.socket.SocketDataSender", f = "SocketDataSender.kt", i = {0, 1}, l = {40, 43, 48}, m = "write", n = {"this", "this"}, s = {"L$0", "L$0"})
    public static final class b extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public b(um.d<? super b> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.b(null, this);
        }
    }

    public static final class c extends n0 implements jn.a<l2> {

        @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.socket.SocketDataSender$write$2$1", f = "SocketDataSender.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends o implements p<s0, um.d<? super l2>, Object> {
            int label;
            final /* synthetic */ d this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(d dVar, um.d<? super a> dVar2) {
                super(2, dVar2);
                this.this$0 = dVar;
            }

            @Override // xm.a
            @l
            public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
                return new a(this.this$0, dVar);
            }

            @Override // xm.a
            @m
            public final Object invokeSuspend(@l Object obj) {
                wm.a aVar = wm.a.COROUTINE_SUSPENDED;
                int i10 = this.label;
                if (i10 == 0) {
                    d1.n(obj);
                    j3.b.f8554a.e(d.f7707g, "send write finish");
                    pq.l lVar = this.this$0.f7710e;
                    Integer num = new Integer(0);
                    this.label = 1;
                    if (lVar.L(num, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(obj);
                }
                return l2.f10208a;
            }

            @Override // jn.p
            @m
            public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
                return ((a) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
            }
        }

        public c() {
            super(0);
        }

        @Override // jn.a
        public /* bridge */ /* synthetic */ l2 invoke() {
            invoke2();
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            d dVar = d.this;
            k.f(dVar, null, null, new a(dVar, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: i3.d$d, reason: collision with other inner class name */
    public static final class C0213d extends n0 implements q<byte[], Integer, Integer, l2> {
        public C0213d() {
            super(3);
        }

        @Override // jn.q
        public /* bridge */ /* synthetic */ l2 invoke(byte[] bArr, Integer num, Integer num2) throws IOException {
            invoke(bArr, num.intValue(), num2.intValue());
            return l2.f10208a;
        }

        public final void invoke(@l byte[] bArr, int i10, int i11) throws IOException {
            l0.p(bArr, "bytes");
            d.this.f7708c.write(bArr, i10, i11);
        }
    }

    public d(@l OutputStream outputStream) {
        l0.p(outputStream, "outputStream");
        this.f7708c = outputStream;
        this.f7710e = pq.o.d(0, null, null, 7, null);
    }

    @Override // f3.b
    @m
    public Object f(@l um.d<? super g> dVar) {
        u2.b bVar = u2.b.f16175b;
        return bVar.g(g.class).b(new Integer(1), dVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // z2.b
    @m
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Object b(@l g gVar, @l um.d<? super l2> dVar) {
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
        Object objN = bVar.result;
        Object obj = wm.a.COROUTINE_SUSPENDED;
        int i11 = bVar.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    this = (d) bVar.L$0;
                    d1.n(objN);
                } else if (i11 == 2) {
                    d1.n(objN);
                    ((Number) objN).intValue();
                    j3.b.f8554a.e(f7707g, "write finish");
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d1.n(objN);
                }
                return l2.f10208a;
            }
            d1.n(objN);
            if (this.f7709d) {
                return l2.f10208a;
            }
            gVar.c(new c());
            q<? super byte[], ? super Integer, ? super Integer, l2> c0213d = new C0213d();
            bVar.L$0 = this;
            bVar.label = 1;
            if (gVar.d(c0213d, bVar) == obj) {
                return obj;
            }
            pq.l<Integer> lVar = this.f7710e;
            bVar.L$0 = this;
            bVar.label = 2;
            objN = lVar.n(bVar);
            if (objN == obj) {
                return obj;
            }
            ((Number) objN).intValue();
            j3.b.f8554a.e(f7707g, "write finish");
        } catch (IOException e10) {
            j3.b.f8554a.d(f7707g, e10);
            this.f7709d = true;
            u2.b bVar2 = u2.b.f16175b;
            s sVar = new s(e10);
            Integer num = new Integer(1);
            bVar.L$0 = null;
            bVar.label = 3;
            if (bVar2.r(sVar, num, bVar) == obj) {
                return obj;
            }
        }
        return l2.f10208a;
    }

    @Override // f3.b, z2.b
    public void stop() {
        this.f5842b = true;
        try {
            this.f7708c.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
