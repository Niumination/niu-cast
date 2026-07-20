package a;

import kn.r1;
import n1.e;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nCoroutineDebugging.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineDebugging.kt\n_COROUTINE/CoroutineDebuggingKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,66:1\n1#2:67\n*E\n"})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public static final String f1a = "_COROUTINE";

    public static final StackTraceElement b(Throwable th2, String str) {
        StackTraceElement stackTraceElement = th2.getStackTrace()[0];
        return new StackTraceElement(f1a + e.f11183c + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }

    @l
    public static final String c() {
        return f1a;
    }
}
