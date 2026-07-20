package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder;
import io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractInboundHttp2ToHttpAdapterBuilder<T extends InboundHttp2ToHttpAdapter, B extends AbstractInboundHttp2ToHttpAdapterBuilder<T, B>> {
    private final Http2Connection connection;
    private int maxContentLength;
    private boolean propagateSettings;
    private boolean validateHttpHeaders;

    public AbstractInboundHttp2ToHttpAdapterBuilder(Http2Connection http2Connection) {
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public T build() {
        try {
            T t10 = (T) build(connection(), maxContentLength(), isValidateHttpHeaders(), isPropagateSettings());
            this.connection.addListener(t10);
            return t10;
        } catch (Throwable th2) {
            throw new IllegalStateException("failed to create a new InboundHttp2ToHttpAdapter", th2);
        }
    }

    public abstract T build(Http2Connection http2Connection, int i10, boolean z10, boolean z11) throws Exception;

    public Http2Connection connection() {
        return this.connection;
    }

    public boolean isPropagateSettings() {
        return this.propagateSettings;
    }

    public boolean isValidateHttpHeaders() {
        return this.validateHttpHeaders;
    }

    public int maxContentLength() {
        return this.maxContentLength;
    }

    public B propagateSettings(boolean z10) {
        this.propagateSettings = z10;
        return (B) self();
    }

    public final B self() {
        return this;
    }

    public B validateHttpHeaders(boolean z10) {
        this.validateHttpHeaders = z10;
        return (B) self();
    }

    public B maxContentLength(int i10) {
        this.maxContentLength = i10;
        return (B) self();
    }
}
