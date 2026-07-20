package nl;

import fl.m1;
import kn.l1;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements xm.e, um.d<?> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final o f11599a = new o();

    @Override // xm.e
    @os.m
    public xm.e getCallerFrame() {
        return null;
    }

    @Override // um.d
    @os.l
    public um.g getContext() {
        return um.i.INSTANCE;
    }

    @Override // xm.e
    @os.m
    public StackTraceElement getStackTraceElement() {
        un.d dVarD = l1.d(n.class);
        n nVar = n.f11598a;
        return m1.c(dVarD, "failedToCaptureStackFrame", "StackWalkingFailed.kt", 8);
    }

    @Override // um.d
    public void resumeWith(@os.l Object obj) {
        n.f11598a.a();
    }
}
