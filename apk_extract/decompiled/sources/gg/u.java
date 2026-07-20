package gg;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import jh.o0;
import jh.q0;
import jh.v0;
import jh.y0;
import k3.ha;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.l0;
import li.p1;
import li.r1;
import li.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends fg.t implements s, c, b, d, g0 {
    public final fg.u e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final x f5198h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f5199i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AtomicReference f5200j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicReference f5201k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final r1 f5202l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SocketChannel f5203m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(SocketChannel channel, fg.u selector, x xVar) {
        super(channel);
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.e = selector;
        this.f5198h = xVar;
        this.f5199i = new AtomicBoolean();
        this.f5200j = new AtomicReference();
        this.f5201k = new AtomicReference();
        this.f5202l = l0.c();
        this.f5203m = channel;
        if (channel.isBlocking()) {
            throw new IllegalArgumentException("Channel need to be configured as non-blocking.");
        }
    }

    public static Throwable L(AtomicReference atomicReference) {
        q0 q0Var = (q0) atomicReference.get();
        if (q0Var == null) {
            return null;
        }
        jh.l0 l0Var = o0.f6300a;
        Intrinsics.checkNotNullParameter(q0Var, "<this>");
        if (!q0Var.a().isCancelled()) {
            q0Var = null;
        }
        if (q0Var == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(q0Var, "<this>");
        CancellationException cancellationExceptionT = q0Var.a().t();
        if (cancellationExceptionT != null) {
            return cancellationExceptionT.getCause();
        }
        return null;
    }

    public final void A() {
        Throwable th2;
        if (this.f5199i.get()) {
            AtomicReference atomicReference = this.f5200j;
            q0 q0Var = (q0) atomicReference.get();
            if (q0Var != null) {
                jh.l0 l0Var = o0.f6300a;
                Intrinsics.checkNotNullParameter(q0Var, "<this>");
                if (!q0Var.a().H()) {
                    return;
                }
            }
            AtomicReference atomicReference2 = this.f5201k;
            q0 q0Var2 = (q0) atomicReference2.get();
            if (q0Var2 != null) {
                jh.l0 l0Var2 = o0.f6300a;
                Intrinsics.checkNotNullParameter(q0Var2, "<this>");
                if (!q0Var2.a().H()) {
                    return;
                }
            }
            Throwable thL = L(atomicReference);
            Throwable thL2 = L(atomicReference2);
            fg.u uVar = this.e;
            try {
                this.f5203m.close();
                super.close();
                ((fg.e) uVar).L(this);
                th2 = null;
            } catch (Throwable th3) {
                ((fg.e) uVar).L(this);
                th2 = th3;
            }
            if (thL == null) {
                thL = thL2;
            } else if (thL2 != null && thL != thL2) {
                ExceptionsKt.addSuppressed(thL, thL2);
            }
            if (thL != null) {
                if (th2 != null && thL != th2) {
                    ExceptionsKt.addSuppressed(thL, th2);
                }
                th2 = thL;
            }
            r1 r1Var = this.f5202l;
            if (th2 == null) {
                r1Var.r0();
            } else {
                r1Var.s0(th2);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object H(SocketAddress socketAddress, ContinuationImpl continuationImpl) throws IOException {
        t tVar;
        String hostAddress;
        InetAddress address;
        InetAddress address2;
        String hostAddress2;
        InetAddress address3;
        if (continuationImpl instanceof t) {
            tVar = (t) continuationImpl;
            int i8 = tVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                tVar.label = i8 - Integer.MIN_VALUE;
            } else {
                tVar = new t(this, continuationImpl);
            }
        } else {
            tVar = new t(this, continuationImpl);
        }
        Object obj = tVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = tVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f5203m.connect(socketAddress)) {
                return this;
            }
            fg.r rVar = fg.r.CONNECT;
            q(rVar, true);
            tVar.L$0 = this;
            tVar.label = 1;
            if (((fg.e) this.e).a0(this, rVar, tVar) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1 && i9 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (u) tVar.L$0;
            ResultKt.throwOnFailure(obj);
        }
        while (true) {
            if (this.f5203m.finishConnect()) {
                boolean z2 = o.f5190a;
                SocketChannel socketChannel = this.f5203m;
                SocketAddress localAddress = z2 ? socketChannel.getLocalAddress() : socketChannel.socket().getLocalSocketAddress();
                SocketAddress remoteAddress = z2 ? socketChannel.getRemoteAddress() : socketChannel.socket().getRemoteSocketAddress();
                if (localAddress == null || remoteAddress == null) {
                    break;
                }
                InetSocketAddress inetSocketAddress = localAddress instanceof InetSocketAddress ? (InetSocketAddress) localAddress : null;
                InetSocketAddress inetSocketAddress2 = remoteAddress instanceof InetSocketAddress ? (InetSocketAddress) remoteAddress : null;
                String str = "";
                if (inetSocketAddress == null || (address3 = inetSocketAddress.getAddress()) == null || (hostAddress = address3.getHostAddress()) == null) {
                    hostAddress = "";
                }
                if (inetSocketAddress2 != null && (address2 = inetSocketAddress2.getAddress()) != null && (hostAddress2 = address2.getHostAddress()) != null) {
                    str = hostAddress2;
                }
                boolean zIsAnyLocalAddress = (inetSocketAddress2 == null || (address = inetSocketAddress2.getAddress()) == null) ? false : address.isAnyLocalAddress();
                if (!Intrinsics.areEqual(inetSocketAddress != null ? Integer.valueOf(inetSocketAddress.getPort()) : null, inetSocketAddress2 != null ? Integer.valueOf(inetSocketAddress2.getPort()) : null) || (!zIsAnyLocalAddress && !Intrinsics.areEqual(hostAddress, str))) {
                    this.q(fg.r.CONNECT, false);
                    return this;
                }
                if (z2) {
                    socketChannel.close();
                } else {
                    socketChannel.socket().close();
                }
            } else {
                fg.r rVar2 = fg.r.CONNECT;
                this.q(rVar2, true);
                tVar.L$0 = this;
                tVar.label = 2;
                if (((fg.e) this.e).a0(this, rVar2, tVar) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        throw new IllegalStateException("localAddress and remoteAddress should not be null.");
    }

    @Override // gg.d
    public final v0 a(jh.k channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        return (v0) t("writing", channel, this.f5200j, new p(this, channel, 0));
    }

    @Override // fg.t, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f5199i.compareAndSet(false, true)) {
            v0 v0Var = (v0) this.f5200j.get();
            if (v0Var != null) {
                ha.a(v0Var.f6306a);
            }
            y0 y0Var = (y0) this.f5201k.get();
            if (y0Var != null) {
                jh.l0 l0Var = o0.f6300a;
                Intrinsics.checkNotNullParameter(y0Var, "<this>");
                ((x1) y0Var.a()).h(null);
            }
            A();
        }
    }

    @Override // fg.t, li.x0
    public final void dispose() {
        close();
    }

    @Override // gg.c
    public final p1 g0() {
        return this.f5202l;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f5202l;
    }

    @Override // gg.s
    public final l i0() {
        boolean z2 = o.f5190a;
        SocketChannel socketChannel = this.f5203m;
        SocketAddress remoteAddress = z2 ? socketChannel.getRemoteAddress() : socketChannel.socket().getRemoteSocketAddress();
        if (remoteAddress != null) {
            return l.d(remoteAddress);
        }
        throw new IllegalStateException("Channel is not yet connected");
    }

    @Override // gg.a
    public final l m() {
        boolean z2 = o.f5190a;
        SocketChannel socketChannel = this.f5203m;
        SocketAddress localAddress = z2 ? socketChannel.getLocalAddress() : socketChannel.socket().getLocalSocketAddress();
        if (localAddress != null) {
            return l.d(localAddress);
        }
        throw new IllegalStateException("Channel is not yet bound");
    }

    @Override // gg.b
    public final y0 s(jh.k channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        return (y0) t("reading", channel, this.f5201k, new p(this, channel, 1));
    }

    public final q0 t(String str, jh.k kVar, AtomicReference atomicReference, Function0 function0) throws ClosedChannelException {
        AtomicBoolean atomicBoolean = this.f5199i;
        if (atomicBoolean.get()) {
            ClosedChannelException closedChannelException = new ClosedChannelException();
            o0.a(kVar, closedChannelException);
            throw closedChannelException;
        }
        q0 job = (q0) function0.invoke();
        if (!atomicReference.compareAndSet(null, job)) {
            IllegalStateException illegalStateException = new IllegalStateException(str.concat(" channel has already been set"));
            jh.l0 l0Var = o0.f6300a;
            Intrinsics.checkNotNullParameter(job, "<this>");
            job.a().h(null);
            throw illegalStateException;
        }
        if (atomicBoolean.get()) {
            ClosedChannelException closedChannelException2 = new ClosedChannelException();
            jh.l0 l0Var2 = o0.f6300a;
            Intrinsics.checkNotNullParameter(job, "<this>");
            job.a().h(null);
            o0.a(kVar, closedChannelException2);
            throw closedChannelException2;
        }
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(job, "job");
        p1 job2 = job.a();
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Intrinsics.checkNotNullParameter(job2, "job");
        job2.A(new jh.l(kVar, 0));
        ag.a block = new ag.a(this, 3);
        jh.l0 l0Var3 = o0.f6300a;
        Intrinsics.checkNotNullParameter(job, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        job.a().A(new bh.a(1, block));
        return job;
    }

    @Override // fg.t, fg.s
    public final SelectableChannel u() {
        return this.f5203m;
    }
}
