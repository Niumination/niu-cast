package nq;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nExceptions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,76:1\n26#2:77\n*S KotlinDebug\n*F\n+ 1 Exceptions.kt\nkotlinx/coroutines/JobCancellationException\n*L\n44#1:77\n*E\n"})
public final class m2 extends CancellationException implements l0<m2> {

    @in.f
    @os.l
    public final transient l2 job;

    public m2(@os.l String str, @os.m Throwable th2, @os.l l2 l2Var) {
        super(str);
        this.job = l2Var;
        if (th2 != null) {
            initCause(th2);
        }
    }

    public boolean equals(@os.m Object obj) {
        if (obj != this) {
            if (obj instanceof m2) {
                m2 m2Var = (m2) obj;
                if (!kn.l0.g(m2Var.getMessage(), getMessage()) || !kn.l0.g(m2Var.job, this.job) || !kn.l0.g(m2Var.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Throwable
    @os.l
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        kn.l0.m(message);
        int iHashCode = (this.job.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    @os.l
    public String toString() {
        return super.toString() + "; job=" + this.job;
    }

    @Override // nq.l0
    @os.m
    public m2 createCopy() {
        return null;
    }
}
