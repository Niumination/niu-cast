package gg;

import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.channels.SelectableChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import li.p1;
import li.r1;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements fg.s, c, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fg.t f5194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ServerSocketChannel f5195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fg.u f5196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final r1 f5197d;

    public r(ServerSocketChannel channel, fg.u selector) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(selector, "selector");
        this.f5194a = new fg.t(channel);
        this.f5195b = channel;
        this.f5196c = selector;
        if (channel.isBlocking()) {
            throw new IllegalArgumentException("Channel need to be configured as non-blocking.");
        }
        this.f5197d = l0.c();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x0054  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0049 -> B:18:0x004c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:0:?
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof gg.q
            if (r0 == 0) goto L13
            r0 = r5
            gg.q r0 = (gg.q) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            gg.q r0 = new gg.q
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            gg.r r4 = (gg.r) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L4c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
        L38:
            fg.r r5 = fg.r.ACCEPT
            r4.q(r5, r3)
            r0.L$0 = r4
            r0.label = r3
            fg.u r2 = r4.f5196c
            fg.e r2 = (fg.e) r2
            java.lang.Object r5 = r2.a0(r4, r5, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            java.nio.channels.ServerSocketChannel r5 = r4.f5195b
            java.nio.channels.SocketChannel r5 = r5.accept()
            if (r5 == 0) goto L38
            gg.u r4 = r4.c(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: gg.r.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final u c(SocketChannel socketChannel) throws IOException {
        q(fg.r.ACCEPT, false);
        socketChannel.configureBlocking(false);
        if (m() instanceof n) {
            if (o.f5190a) {
                socketChannel.setOption((SocketOption<Boolean>) StandardSocketOptions.TCP_NODELAY, Boolean.TRUE);
            } else {
                socketChannel.socket().setTcpNoDelay(true);
            }
        }
        return new u(socketChannel, this.f5196c, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        r1 r1Var = this.f5197d;
        fg.u uVar = this.f5196c;
        try {
            try {
                this.f5195b.close();
                ((fg.e) uVar).L(this);
                r1Var.r0();
            } catch (Throwable th2) {
                ((fg.e) uVar).L(this);
                throw th2;
            }
        } catch (Throwable th3) {
            r1Var.s0(th3);
        }
    }

    @Override // li.x0
    public final void dispose() {
        try {
            close();
        } catch (Throwable unused) {
        }
    }

    @Override // gg.c
    public final p1 g0() {
        return this.f5197d;
    }

    @Override // fg.s
    public final boolean isClosed() {
        return this.f5194a.f5050b.get();
    }

    @Override // gg.a
    public final l m() {
        boolean z2 = o.f5190a;
        ServerSocketChannel serverSocketChannel = this.f5195b;
        SocketAddress localAddress = z2 ? serverSocketChannel.getLocalAddress() : serverSocketChannel.socket().getLocalSocketAddress();
        Intrinsics.checkNotNull(localAddress);
        return l.d(localAddress);
    }

    @Override // fg.s
    public final fg.m p() {
        return this.f5194a.f5051c;
    }

    @Override // fg.s
    public final void q(fg.r interest, boolean z2) {
        Intrinsics.checkNotNullParameter(interest, "interest");
        this.f5194a.q(interest, z2);
    }

    @Override // fg.s
    public final SelectableChannel u() {
        return this.f5195b;
    }

    @Override // fg.s
    public final int y() {
        return this.f5194a.y();
    }
}
