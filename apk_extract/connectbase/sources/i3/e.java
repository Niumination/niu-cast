package i3;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
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
@r1({"SMAP\nSocketServerConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SocketServerConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/socket/SocketServerConnector\n+ 2 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,60:1\n48#2,4:61\n1855#3,2:65\n*S KotlinDebug\n*F\n+ 1 SocketServerConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/socket/SocketServerConnector\n*L\n28#1:61,4\n57#1:65,2\n*E\n"})
public final class e implements z2.d, s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7711a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m
    public ServerSocket f7713c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s0 f7712b = s2.d.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final ArrayList<z2.c> f7714d = new ArrayList<>();

    @r1({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1\n+ 2 SocketServerConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/socket/SocketServerConnector\n*L\n1#1,110:1\n29#2,3:111\n*E\n"})
    public static final class a extends um.a implements o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f7715a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o0.b bVar, e eVar) {
            super(bVar);
            this.f7715a = eVar;
        }

        @Override // nq.o0
        public void g0(@l g gVar, @l Throwable th2) {
            th2.printStackTrace();
            u2.b bVar = u2.b.f16175b;
            String simpleName = this.f7715a.getClass().getSimpleName();
            l0.o(simpleName, "getSimpleName(...)");
            p.b(bVar, new r2.f(simpleName, false), null, 2, null);
        }
    }

    @r1({"SMAP\nSocketServerConnector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SocketServerConnector.kt\ncom/transsion/airtransfer/filetransfer/transmission/socket/SocketServerConnector$connect$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
    @xm.f(c = "com.transsion.airtransfer.filetransfer.transmission.socket.SocketServerConnector$connect$1", f = "SocketServerConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends o implements jn.p<s0, um.d<? super l2>, Object> {
        int label;

        public b(um.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // xm.a
        @l
        public final um.d<l2> create(@m Object obj, @l um.d<?> dVar) {
            return e.this.new b(dVar);
        }

        @Override // xm.a
        @m
        public final Object invokeSuspend(@l Object obj) throws SocketException {
            Socket socketAccept;
            wm.a aVar = wm.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            d1.n(obj);
            e eVar = e.this;
            ServerSocket serverSocket = new ServerSocket(e.this.f7711a);
            serverSocket.setReuseAddress(true);
            eVar.f7713c = serverSocket;
            u2.b bVar = u2.b.f16175b;
            String simpleName = e.this.getClass().getSimpleName();
            l0.o(simpleName, "getSimpleName(...)");
            p.b(bVar, new r2.f(simpleName, true), null, 2, null);
            while (true) {
                ServerSocket serverSocket2 = e.this.f7713c;
                if (serverSocket2 != null && (socketAccept = serverSocket2.accept()) != null) {
                    ArrayList<z2.c> arrayList = e.this.f7714d;
                    f fVar = new f(socketAccept);
                    fVar.start();
                    arrayList.add(fVar);
                }
            }
        }

        @Override // jn.p
        @m
        public final Object invoke(@l s0 s0Var, @m um.d<? super l2> dVar) {
            return ((b) create(s0Var, dVar)).invokeSuspend(l2.f10208a);
        }
    }

    public e(int i10) {
        this.f7711a = i10;
    }

    @Override // z2.d
    public void b() {
        k.f(this, new a(o0.f11887j, this), null, new b(null), 2, null);
    }

    @Override // z2.d
    public void disconnect() {
        try {
            ServerSocket serverSocket = this.f7713c;
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        Iterator<T> it = this.f7714d.iterator();
        while (it.hasNext()) {
            ((z2.c) it.next()).stop();
        }
        t0.f(this, null, 1, null);
    }

    @Override // nq.s0
    @l
    public g getCoroutineContext() {
        return this.f7712b.getCoroutineContext();
    }
}
