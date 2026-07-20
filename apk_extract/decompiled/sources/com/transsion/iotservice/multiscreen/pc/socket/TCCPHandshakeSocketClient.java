package com.transsion.iotservice.multiscreen.pc.socket;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import k3.gc;
import k3.ob;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.l0;
import li.v0;
import o.d;
import si.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0014J\u001e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0010H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/socket/TCCPHandshakeSocketClient;", "Lcom/transsion/iotservice/multiscreen/pc/socket/TranTCCPChannel;", "Lcom/transsion/iotservice/multiscreen/pc/socket/IHandshakeChannelClient;", "<init>", "()V", "socket", "Ljava/net/Socket;", "getSocket", "()Ljava/net/Socket;", "setSocket", "(Ljava/net/Socket;)V", "running", "", "connectRetryCount", "", "connect", "", "host", "", "port", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSocketWithRetry", "waitData", "(Ljava/net/Socket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "Companion", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class TCCPHandshakeSocketClient extends TranTCCPChannel implements IHandshakeChannelClient {
    public static final int MAIN_SOCKET_PORT = 8613;
    public static final int MAX_RETRY_COUNT = 10;
    private static final String SOCKET_CONNECT_FAIL_LOG = "failed to connect";
    private static final String TAG = "TCCPHandshakeSocketClient";
    private int connectRetryCount;
    private boolean running;
    private Socket socket;

    /* JADX INFO: renamed from: com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient$connect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient", f = "TCCPHandshakeSocketClient.kt", i = {0, 1}, l = {23, 29}, m = "connect", n = {"this", "this"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TCCPHandshakeSocketClient.this.connect(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient$createSocketWithRetry$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @DebugMetadata(c = "com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient", f = "TCCPHandshakeSocketClient.kt", i = {0, 0, 0, 1, 1, 1}, l = {41, 46}, m = "createSocketWithRetry", n = {"host", "port", "retryCount", "host", "port", "retryCount"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1"})
    public static final class C00641 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C00641(Continuation<? super C00641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TCCPHandshakeSocketClient.this.createSocketWithRetry(null, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient$createSocketWithRetry$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lli/g0;", "Ljava/net/Socket;", "<anonymous>", "(Lli/g0;)Ljava/net/Socket;"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient$createSocketWithRetry$2", f = "TCCPHandshakeSocketClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<g0, Continuation<? super Socket>, Object> {
        final /* synthetic */ String $host;
        final /* synthetic */ int $port;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, int i8, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$host = str;
            this.$port = i8;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$host, this.$port, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new Socket(InetAddress.getByName(this.$host), this.$port);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(g0 g0Var, Continuation<? super Socket> continuation) {
            return ((AnonymousClass2) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient$waitData$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lli/g0;", "", "<anonymous>", "(Lli/g0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient$waitData$2", f = "TCCPHandshakeSocketClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C00652 extends SuspendLambda implements Function2<g0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Socket $socket;
        int label;
        final /* synthetic */ TCCPHandshakeSocketClient this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00652(Socket socket, TCCPHandshakeSocketClient tCCPHandshakeSocketClient, Continuation<? super C00652> continuation) {
            super(2, continuation);
            this.$socket = socket;
            this.this$0 = tCCPHandshakeSocketClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C00652(this.$socket, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int port = this.$socket.getPort();
            InetAddress inetAddress = this.$socket.getInetAddress();
            String log = "waitData: ip:" + port + " port:" + (inetAddress != null ? inetAddress.getHostAddress() : null) + " ";
            Intrinsics.checkNotNullParameter(TCCPHandshakeSocketClient.TAG, "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat(TCCPHandshakeSocketClient.TAG), log);
            }
            this.this$0.running = true;
            while (!this.$socket.isClosed() && this.this$0.running) {
                try {
                    this.this$0.handleTccp();
                } catch (IOException e) {
                    String strN = d.n("IOException:", e.getMessage(), TCCPHandshakeSocketClient.TAG, "tag", "log");
                    if (gc.f6462a <= 6) {
                        Log.e(gc.f6463b.concat(TCCPHandshakeSocketClient.TAG), strN);
                    }
                    this.this$0.disconnect();
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(g0 g0Var, Continuation<? super Unit> continuation) {
            return ((C00652) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(3:58|24|(1:26)) */
    /* JADX WARN: Code duplicated, block: B:26:0x006e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:38:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:47:0x0105  */
    /* JADX WARN: Code duplicated, block: B:51:0x0114  */
    /* JADX WARN: Code duplicated, block: B:52:0x0116 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0118 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:54:0x0119  */
    /* JADX WARN: Code duplicated, block: B:58:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0071, code lost:
    
        r1 = r9;
        r9 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0033, code lost:
    
        if (r9 != r12) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createSocketWithRetry(java.lang.String r10, int r11, kotlin.coroutines.Continuation<? super java.net.Socket> r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient.createSocketWithRetry(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object waitData(Socket socket, Continuation<? super Unit> continuation) throws Throwable {
        v0 v0Var = v0.f7498a;
        Object objU = l0.u(e.f10118a, new C00652(socket, this, null), continuation);
        return objU == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objU : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    @Override // com.transsion.iotservice.multiscreen.pc.socket.IHandshakeChannelClient
    public Object connect(String str, int i8, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        TCCPHandshakeSocketClient tCCPHandshakeSocketClient;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i9 = anonymousClass1.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i9 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objCreateSocketWithRetry = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = anonymousClass1.label;
        try {
            if (i10 != 0) {
                if (i10 == 1) {
                    this = (TCCPHandshakeSocketClient) anonymousClass1.L$1;
                    tCCPHandshakeSocketClient = (TCCPHandshakeSocketClient) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure(objCreateSocketWithRetry);
                    } catch (Exception unused) {
                        this = tCCPHandshakeSocketClient;
                        this.disconnect();
                    }
                } else {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objCreateSocketWithRetry);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(objCreateSocketWithRetry);
            String log = "connect:" + str + ":" + i8;
            Intrinsics.checkNotNullParameter(TAG, "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat(TAG), log);
            }
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = this;
            anonymousClass1.label = 1;
            objCreateSocketWithRetry = createSocketWithRetry(str, i8, anonymousClass1);
            if (objCreateSocketWithRetry == coroutine_suspended) {
                return coroutine_suspended;
            }
            tCCPHandshakeSocketClient = this;
            this.socket = (Socket) objCreateSocketWithRetry;
            String log2 = "connect success msgListener:" + tCCPHandshakeSocketClient.getMsgListener();
            Intrinsics.checkNotNullParameter(TAG, "tag");
            Intrinsics.checkNotNullParameter(log2, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat(TAG), log2);
            }
            EventListener msgListener = tCCPHandshakeSocketClient.getMsgListener();
            if (msgListener != null) {
                msgListener.onConnected();
            }
            Socket socket = tCCPHandshakeSocketClient.socket;
            if (socket != null) {
                tCCPHandshakeSocketClient.setInput(socket.getInputStream());
                tCCPHandshakeSocketClient.setOutput(socket.getOutputStream());
                anonymousClass1.L$0 = tCCPHandshakeSocketClient;
                anonymousClass1.L$1 = socket;
                anonymousClass1.label = 2;
                if (tCCPHandshakeSocketClient.waitData(socket, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } catch (Exception unused2) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.transsion.iotservice.multiscreen.pc.socket.IHandshakeChannelClient
    public void disconnect() {
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter("disconnect", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat(TAG), "disconnect");
        }
        this.running = false;
        try {
            Socket socket = this.socket;
            if (socket != null) {
                socket.shutdownInput();
                socket.shutdownOutput();
                socket.close();
            }
            EventListener msgListener = getMsgListener();
            if (msgListener != null) {
                msgListener.onDisconnected();
            }
            ob.a(this.socket);
            ob.a(getInput(), getOutput());
            ob.a(getInput());
        } catch (IOException e) {
            String log = e.toString();
            Intrinsics.checkNotNullParameter(TAG, "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat(TAG), log);
            }
            ob.a(this.socket);
            ob.a(getInput(), getOutput());
            ob.a(getInput());
        } finally {
            ob.a(this.socket);
            ob.a(getInput(), getOutput());
            ob.a(getInput());
            getHandlerThread().quitSafely();
            this.socket = null;
            setInput(null);
            setOutput(null);
            this.connectRetryCount = 0;
        }
    }

    public final Socket getSocket() {
        return this.socket;
    }

    public final void setSocket(Socket socket) {
        this.socket = socket;
    }
}
