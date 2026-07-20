package gg;

import java.io.Closeable;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.r1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(r rVar, ContinuationImpl continuationImpl) {
        z zVar;
        c cVar;
        if (continuationImpl instanceof z) {
            zVar = (z) continuationImpl;
            int i8 = zVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                zVar.label = i8 - Integer.MIN_VALUE;
            } else {
                zVar = new z(continuationImpl);
            }
        } else {
            zVar = new z(continuationImpl);
        }
        Object obj = zVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = zVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            r1 r1Var = rVar.f5197d;
            zVar.L$0 = rVar;
            zVar.label = 1;
            if (r1Var.S(zVar) == coroutine_suspended) {
                cVar = rVar;
                return coroutine_suspended;
            }
        } else {
            if (i9 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            c cVar2 = (c) zVar.L$0;
            ResultKt.throwOnFailure(obj);
            cVar = cVar2;
        }
        cVar = rVar;
        if (cVar.g0().isCancelled()) {
            throw cVar.g0().t();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object b(fg.u uVar, n address, x xVar, ContinuationImpl continuationImpl) throws Throwable {
        k kVar;
        Closeable closeable;
        if (continuationImpl instanceof k) {
            kVar = (k) continuationImpl;
            int i8 = kVar.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                kVar.label = i8 - Integer.MIN_VALUE;
            } else {
                kVar = new k(continuationImpl);
            }
        } else {
            kVar = new k(continuationImpl);
        }
        Object obj = kVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i9 = kVar.label;
        if (i9 == 0) {
            ResultKt.throwOnFailure(obj);
            SelectorProvider selectorProvider = ((fg.e) uVar).f5034a;
            Intrinsics.checkNotNullParameter(selectorProvider, "<this>");
            Intrinsics.checkNotNullParameter(address, "address");
            if (address == null) {
                throw new NoWhenBranchMatchedException();
            }
            SocketChannel socketChannelOpenSocketChannel = selectorProvider.openSocketChannel();
            if (address != null) {
                try {
                    Intrinsics.checkNotNull(socketChannelOpenSocketChannel);
                    o.a(socketChannelOpenSocketChannel, xVar);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = socketChannelOpenSocketChannel;
                }
            }
            Intrinsics.checkNotNull(socketChannelOpenSocketChannel);
            boolean z2 = o.f5190a;
            Intrinsics.checkNotNullParameter(socketChannelOpenSocketChannel, "<this>");
            socketChannelOpenSocketChannel.configureBlocking(false);
            u uVar2 = new u(socketChannelOpenSocketChannel, uVar, xVar);
            Intrinsics.checkNotNullParameter(address, "<this>");
            SocketAddress socketAddressC = address.c();
            kVar.L$0 = socketChannelOpenSocketChannel;
            kVar.L$1 = uVar2;
            kVar.label = 1;
            return uVar2.H(socketAddressC, kVar) == coroutine_suspended ? coroutine_suspended : uVar2;
        }
        if (i9 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u uVar3 = (u) kVar.L$1;
        closeable = (Closeable) kVar.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            return uVar3;
        } catch (Throwable th3) {
            th = th3;
        }
        closeable.close();
        throw th;
    }

    public static final l d(SocketAddress socketAddress) {
        Intrinsics.checkNotNullParameter(socketAddress, "<this>");
        if (socketAddress instanceof InetSocketAddress) {
            return new n((InetSocketAddress) socketAddress);
        }
        if (Intrinsics.areEqual(socketAddress.getClass().getName(), "java.net.UnixDomainSocketAddress")) {
            return new a0(socketAddress);
        }
        throw new IllegalStateException("Unknown socket address type");
    }

    public abstract SocketAddress c();
}
