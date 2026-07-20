package nq;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timeout.kt\nkotlinx/coroutines/TimeoutCancellationException\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,193:1\n1#2:194\n*E\n"})
public final class v3 extends CancellationException implements l0<v3> {

    @os.m
    @in.f
    public final transient l2 coroutine;

    public v3(@os.l String str, @os.m l2 l2Var) {
        super(str);
        this.coroutine = l2Var;
    }

    @Override // nq.l0
    @os.l
    public v3 createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        v3 v3Var = new v3(message, this.coroutine);
        v3Var.initCause(this);
        return v3Var;
    }

    public v3(@os.l String str) {
        this(str, null);
    }
}
