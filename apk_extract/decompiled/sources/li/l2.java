package li;

import java.util.concurrent.CancellationException;
import kotlin.jvm.JvmField;

/* JADX INFO: loaded from: classes3.dex */
public final class l2 extends CancellationException implements x {

    @JvmField
    public final transient p1 coroutine;

    public l2(String str, p1 p1Var) {
        super(str);
        this.coroutine = p1Var;
    }

    @Override // li.x
    public l2 createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        l2 l2Var = new l2(message, this.coroutine);
        l2Var.initCause(this);
        return l2Var;
    }

    public l2(String str) {
        this(str, null);
    }
}
