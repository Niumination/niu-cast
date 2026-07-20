package xm;

import java.io.Serializable;
import kn.l0;
import lm.c1;
import lm.d1;
import lm.f1;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
public abstract class a implements um.d<Object>, e, Serializable {

    @os.m
    private final um.d<Object> completion;

    public a(@os.m um.d<Object> dVar) {
        this.completion = dVar;
    }

    @os.l
    public um.d<l2> create(@os.l um.d<?> dVar) {
        l0.p(dVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @os.m
    public e getCallerFrame() {
        um.d<Object> dVar = this.completion;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    @os.m
    public final um.d<Object> getCompletion() {
        return this.completion;
    }

    @os.m
    public StackTraceElement getStackTraceElement() {
        return g.e(this);
    }

    @os.m
    public abstract Object invokeSuspend(@os.l Object obj);

    public void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [um.d] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    @Override // um.d
    public final void resumeWith(@os.l Object obj) {
        ?? r10 = this;
        while (true) {
            h.b(r10);
            a aVar = (a) r10;
            um.d<Object> dVar = aVar.completion;
            l0.m(dVar);
            try {
                Object objInvokeSuspend = aVar.invokeSuspend(obj);
                if (objInvokeSuspend == wm.a.COROUTINE_SUSPENDED) {
                    return;
                }
                c1.a aVar2 = c1.Companion;
                obj = c1.m59constructorimpl(objInvokeSuspend);
            } catch (Throwable th2) {
                c1.a aVar3 = c1.Companion;
                obj = c1.m59constructorimpl(d1.a(th2));
            }
            aVar.releaseIntercepted();
            if (!(dVar instanceof a)) {
                dVar.resumeWith(obj);
                return;
            }
            r10 = dVar;
        }
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    @os.l
    public um.d<l2> create(@os.m Object obj, @os.l um.d<?> dVar) {
        l0.p(dVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
