package pi;

import java.util.concurrent.CancellationException;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends CancellationException {

    @JvmField
    public final transient Object owner;

    public a(Object obj) {
        super("Flow was aborted, no more elements needed");
        this.owner = obj;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
