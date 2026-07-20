package io.netty.util.internal.logging;

import ps.a;
import ps.b;
import rs.h;

/* JADX INFO: loaded from: classes3.dex */
public class Slf4JLoggerFactory extends InternalLoggerFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final InternalLoggerFactory INSTANCE = new Slf4JLoggerFactory();

    public static final class NopInstanceHolder {
        private static final InternalLoggerFactory INSTANCE_WITH_NOP_CHECK = new Slf4JLoggerFactory(true);

        private NopInstanceHolder() {
        }
    }

    @Deprecated
    public Slf4JLoggerFactory() {
    }

    public static InternalLoggerFactory getInstanceWithNopCheck() {
        return NopInstanceHolder.INSTANCE_WITH_NOP_CHECK;
    }

    public static InternalLogger wrapLogger(a aVar) {
        return aVar instanceof ss.a ? new LocationAwareSlf4JLogger((ss.a) aVar) : new Slf4JLogger(aVar);
    }

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        return wrapLogger(b.j(str));
    }

    public Slf4JLoggerFactory(boolean z10) {
        if (b.h() instanceof h) {
            throw new NoClassDefFoundError("NOPLoggerFactory not supported");
        }
    }
}
