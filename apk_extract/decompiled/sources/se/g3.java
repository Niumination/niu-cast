package se;

import android.util.Log;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.IllegalBlockingModeException;
import k3.lb;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g3 extends SuspendLambda implements Function2 {
    int label;
    final /* synthetic */ i3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g3(i3 i3Var, Continuation<? super g3> continuation) {
        super(2, continuation);
        this.this$0 = i3Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new g3(this.this$0, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:76:0x01ab A[PHI: r11
      0x01ab: PHI (r11v16 java.net.ServerSocket) = 
      (r11v4 java.net.ServerSocket)
      (r11v7 java.net.ServerSocket)
      (r11v10 java.net.ServerSocket)
      (r11v13 java.net.ServerSocket)
      (r11v34 java.net.ServerSocket)
     binds: [B:84:0x01e5, B:88:0x01fb, B:80:0x01cf, B:92:0x0211, B:75:0x01a9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        ServerSocket serverSocket;
        InetAddress inetAddress;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            try {
                try {
                    try {
                        try {
                            this.this$0.getClass();
                            we.h.h("TcpHskServer", "Starting server with port " + this.this$0.f9799a);
                            this.this$0.f9800b = new ServerSocket(this.this$0.f9799a, 50, InetAddress.getByName("0.0.0.0"));
                            i3 i3Var = this.this$0;
                            ServerSocket serverSocket2 = i3Var.f9800b;
                            i3Var.f9803g = serverSocket2 != null ? serverSocket2.getLocalPort() : this.this$0.f9799a;
                            this.this$0.getClass();
                            ServerSocket serverSocket3 = this.this$0.f9800b;
                            we.h.h("TcpHskServer", "Ipv4 Server started on port " + (serverSocket3 != null ? Boxing.boxInt(serverSocket3.getLocalPort()) : null));
                            if (this.this$0.f9803g > 0) {
                                this.this$0.f = true;
                                i3 i3Var2 = this.this$0;
                                i3.g(i3Var2, i3Var2.f9803g, this.this$0.f9804h);
                            }
                            while (this.this$0.f) {
                                try {
                                    ServerSocket serverSocket4 = this.this$0.f9800b;
                                    Socket socketAccept = serverSocket4 != null ? serverSocket4.accept() : null;
                                    this.this$0.getClass();
                                    we.h.h("TcpHskServer", "Client connected: " + ((socketAccept == null || (inetAddress = socketAccept.getInetAddress()) == null) ? null : inetAddress.getHostAddress()));
                                    if (socketAccept != null) {
                                        i3.a(this.this$0, socketAccept);
                                        i3.f(this.this$0, socketAccept);
                                    }
                                } catch (IOException e) {
                                    this.this$0.getClass();
                                    Intrinsics.checkNotNullParameter("TcpHskServer", "tag");
                                    Intrinsics.checkNotNullParameter("Server socket IO error", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("TcpHskServer", "TransConnect:Server socket IO error", null);
                                    }
                                    e.printStackTrace();
                                    if (!this.this$0.f) {
                                        serverSocket = this.this$0.f9800b;
                                        if (serverSocket != null) {
                                            serverSocket.close();
                                        }
                                        i3.h(this.this$0);
                                        this.this$0.getClass();
                                        we.h.h("TcpHskServer", "Server socket closed");
                                        return Unit.INSTANCE;
                                    }
                                } catch (SecurityException e4) {
                                    this.this$0.getClass();
                                    Intrinsics.checkNotNullParameter("TcpHskServer", "tag");
                                    Intrinsics.checkNotNullParameter("Server socket Security error", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("TcpHskServer", "TransConnect:Server socket Security error", null);
                                    }
                                    e4.printStackTrace();
                                    if (!this.this$0.f) {
                                        serverSocket = this.this$0.f9800b;
                                        if (serverSocket != null) {
                                            serverSocket.close();
                                        }
                                        i3.h(this.this$0);
                                        this.this$0.getClass();
                                        we.h.h("TcpHskServer", "Server socket closed");
                                        return Unit.INSTANCE;
                                    }
                                } catch (IllegalBlockingModeException e10) {
                                    this.this$0.getClass();
                                    Intrinsics.checkNotNullParameter("TcpHskServer", "tag");
                                    Intrinsics.checkNotNullParameter("Server socket IllegalBlockingMode error", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("TcpHskServer", "TransConnect:Server socket IllegalBlockingMode error", null);
                                    }
                                    e10.printStackTrace();
                                    if (!this.this$0.f) {
                                        serverSocket = this.this$0.f9800b;
                                        if (serverSocket != null) {
                                            serverSocket.close();
                                        }
                                        i3.h(this.this$0);
                                        this.this$0.getClass();
                                        we.h.h("TcpHskServer", "Server socket closed");
                                        return Unit.INSTANCE;
                                    }
                                } catch (Exception e11) {
                                    this.this$0.getClass();
                                    Intrinsics.checkNotNullParameter("TcpHskServer", "tag");
                                    Intrinsics.checkNotNullParameter("Server socket exception", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("TcpHskServer", "TransConnect:Server socket exception", null);
                                    }
                                    e11.printStackTrace();
                                    if (!this.this$0.f) {
                                        serverSocket = this.this$0.f9800b;
                                        if (serverSocket != null) {
                                            serverSocket.close();
                                        }
                                        i3.h(this.this$0);
                                        this.this$0.getClass();
                                        we.h.h("TcpHskServer", "Server socket closed");
                                        return Unit.INSTANCE;
                                    }
                                }
                            }
                            serverSocket = this.this$0.f9800b;
                            if (serverSocket != null) {
                                serverSocket.close();
                            }
                        } catch (IOException e12) {
                            this.this$0.getClass();
                            we.h.c("TcpHskServer", "Server socket creation IO error", null);
                            e12.printStackTrace();
                            serverSocket = this.this$0.f9800b;
                            if (serverSocket != null) {
                            }
                        }
                    } catch (Exception e13) {
                        this.this$0.getClass();
                        we.h.c("TcpHskServer", "Server socket creation exception", null);
                        e13.printStackTrace();
                        serverSocket = this.this$0.f9800b;
                        if (serverSocket != null) {
                        }
                    }
                } catch (SecurityException e14) {
                    this.this$0.getClass();
                    we.h.c("TcpHskServer", "Server socket creation Security error", null);
                    e14.printStackTrace();
                    serverSocket = this.this$0.f9800b;
                    if (serverSocket != null) {
                    }
                }
            } catch (IllegalArgumentException e15) {
                this.this$0.getClass();
                we.h.c("TcpHskServer", "Server socket creation IllegalArgumentException error", null);
                e15.printStackTrace();
                serverSocket = this.this$0.f9800b;
                if (serverSocket != null) {
                }
            }
            i3.h(this.this$0);
            this.this$0.getClass();
            we.h.h("TcpHskServer", "Server socket closed");
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            ServerSocket serverSocket5 = this.this$0.f9800b;
            if (serverSocket5 != null) {
                serverSocket5.close();
            }
            i3.h(this.this$0);
            this.this$0.getClass();
            we.h.h("TcpHskServer", "Server socket closed");
            throw th2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(li.g0 g0Var, Continuation<? super Unit> continuation) {
        return ((g3) create(g0Var, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
