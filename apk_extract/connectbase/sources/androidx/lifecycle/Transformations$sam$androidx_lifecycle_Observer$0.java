package androidx.lifecycle;

import jn.l;
import kn.d0;
import kn.l0;
import lm.v;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, d0 {
    private final /* synthetic */ l function;

    public Transformations$sam$androidx_lifecycle_Observer$0(l lVar) {
        l0.p(lVar, "function");
        this.function = lVar;
    }

    public final boolean equals(@m Object obj) {
        if ((obj instanceof Observer) && (obj instanceof d0)) {
            return l0.g(getFunctionDelegate(), ((d0) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kn.d0
    @os.l
    public final v<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }
}
