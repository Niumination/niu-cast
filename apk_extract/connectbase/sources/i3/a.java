package i3;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.net.InetSocketAddress;
import java.net.Socket;
import kn.l0;
import kn.r1;
import lm.d1;
import lm.l2;
import nq.k;
import nq.o0;
import nq.s0;
import nq.t0;
import os.l;
import os.m;
import r2.p;
import um.g;
import xm.o;

/* JADX INFO: loaded from: classes2.dex */
@r1({"SMAP\nSocketClientConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SocketClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/socket/SocketClientConnector\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,78:1\n48#2,4:79\n1#3:83\n*S KotlinDebug\n*F\n+ 1 SocketClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/socket/SocketClientConnector\n*L\n33#1:79,4\n*E\n"})
public final class a implements z2.d, s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final String f7695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f7696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s0 f7697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m
    public z2.c f7698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7699e;

    /* JADX INFO: renamed from: i3.a$a, reason: collision with other inner class name */
    @r1({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 SocketClientConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/socket/SocketClientConnector\n*L\n1#1,110:1\n34#2,3:111\n*E\n"})
    public static final class C0212a extends um.a implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7700a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0212a(o0.b bVar, a aVar) {
            super(bVar);
            this.f7700a = aVar;
        }

        @Override // nq.o0
        public void g0(@l g gVar, @l Throwable th2) {
            th2.printStackTrace();
            u2.b bVar = u2.b.f16175b;
            String simpleName = this.f7700a.getClass().getSimpleName();
            l0.o(simpleName, "getSimpleName(...)");
            p.b(bVar, new r2.f(simpleName, false), null, 2, null);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.socket.SocketClientConnector$connect$1", f = "SocketClientConnector.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends o implements jn.p<s0, um.d<? super l2>, Object> {
        int label;

        public b(um.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return a.this.new b(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            int i10 = this.label;
            if (i10 == 0) {
                d1.n(obj);
                a aVar2 = a.this;
                this.label = 1;
                if (aVar2.f(this) == aVar) {
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
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.socket.SocketClientConnector", f = "SocketClientConnector.kt", i = {}, l = {ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE}, m = "connectServer", n = {}, s = {})
    public static final class c extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public c(um.d<? super c> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.f(this);
        }
    }

    @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.socket.SocketClientConnector", f = "SocketClientConnector.kt", i = {0}, l = {63, 64}, m = "reconnect", n = {"this"}, s = {"L$0"})
    public static final class d extends xm.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public d(um.d<? super d> dVar) {
            super(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.i(this);
        }
    }

    public a(@l String str, int i10) {
        l0.p(str, "serverIp");
        this.f7695a = str;
        this.f7696b = i10;
        this.f7697c = s2.d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object i(um.d<? super l2> dVar) {
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
        Object obj = dVar2.result;
        wm.a aVar = wm.a.COROUTINE_SUSPENDED;
        int i11 = dVar2.label;
        if (i11 != 0) {
            if (i11 == 1) {
                this = (a) dVar2.L$0;
                d1.n(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                d1.n(obj);
            }
            return l2.f10208a;
        }
        d1.n(obj);
        int i12 = this.f7699e;
        if (i12 >= 10) {
            u2.b bVar = u2.b.f16175b;
            String simpleName = a.class.getSimpleName();
            l0.o(simpleName, "getSimpleName(...)");
            p.b(bVar, new r2.f(simpleName, false), null, 2, null);
            return l2.f10208a;
        }
        this.f7699e = i12 + 1;
        dVar2.L$0 = this;
        dVar2.label = 1;
        if (nq.d1.b(300L, dVar2) == aVar) {
            return aVar;
        }
        dVar2.L$0 = null;
        dVar2.label = 2;
        if (this.f(dVar2) == aVar) {
            return aVar;
        }
        return l2.f10208a;
    }

    @Override // z2.d
    public void b() {
        k.f(this, new C0212a(o0.f11887j, this), null, new b(null), 2, null);
    }

    @Override // z2.d
    public void disconnect() {
        z2.c cVar = this.f7698d;
        if (cVar != null) {
            cVar.stop();
        }
        t0.f(this, null, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f(um.d<? super l2> dVar) {
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
        Object obj = cVar.result;
        Object obj2 = wm.a.COROUTINE_SUSPENDED;
        int i11 = cVar.label;
        if (i11 == 0) {
            d1.n(obj);
            Socket socket = new Socket();
            try {
                socket.connect(new InetSocketAddress(this.f7695a, this.f7696b), 1000);
                this.f7698d = g(socket);
                u2.b bVar = u2.b.f16175b;
                String simpleName = a.class.getSimpleName();
                l0.o(simpleName, "getSimpleName(...)");
                p.b(bVar, new r2.f(simpleName, true), null, 2, null);
            } catch (Exception e10) {
                e10.printStackTrace();
                cVar.L$0 = socket;
                cVar.label = 1;
                if (i(cVar) == obj2) {
                    return obj2;
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
        }
        return l2.f10208a;
    }

    public final z2.c g(Socket socket) {
        f fVar = new f(socket);
        fVar.start();
        return fVar;
    }

    @Override // nq.s0
    @l
    public g getCoroutineContext() {
        return this.f7697c.getCoroutineContext();
    }
}
