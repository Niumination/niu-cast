package xf;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yf.a f10919a = new yf.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final yf.a f10920b = new yf.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final yf.a f10921c = new yf.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final yf.a f10922d = new yf.a();
    public static final yf.a e = new yf.a();

    public static final Throwable a(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "<this>");
        Throwable cause = th2;
        while (cause instanceof CancellationException) {
            CancellationException cancellationException = (CancellationException) cause;
            if (Intrinsics.areEqual(cause, cancellationException.getCause())) {
                return th2;
            }
            cause = cancellationException.getCause();
        }
        return cause == null ? th2 : cause;
    }
}
