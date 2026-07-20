package k3;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ga {
    public static final void a(jh.o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        oVar.b(new IOException("Channel was cancelled"));
    }
}
