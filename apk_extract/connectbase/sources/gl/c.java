package gl;

import java.io.IOException;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public class c extends IOException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@os.l String str, @os.l Throwable th2) {
        super(str, th2);
        l0.p(str, "message");
        l0.p(th2, "exception");
    }
}
