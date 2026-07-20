package vq;

import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public class y extends a0 {
    public final <T extends a0> void C(jn.l<? super T, l2> lVar) {
        Object objN = n();
        kn.l0.n(objN, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        for (a0 a0VarO = (a0) objN; !kn.l0.g(a0VarO, this); a0VarO = a0VarO.o()) {
            kn.l0.P();
            if (a0VarO != null) {
                lVar.invoke(a0VarO);
            }
        }
    }

    public final boolean D() {
        return n() == this;
    }

    @os.l
    public final Void E() {
        throw new IllegalStateException("head cannot be removed");
    }

    public final void F() {
        Object objN = n();
        kn.l0.n(objN, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        for (a0 a0VarO = (a0) objN; !kn.l0.g(a0VarO, this); a0VarO = a0VarO.o()) {
        }
        Object objN2 = n();
        kn.l0.n(objN2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
    }

    @Override // vq.a0
    public boolean q() {
        return false;
    }

    @Override // vq.a0
    @os.m
    public a0 u() {
        return null;
    }

    @Override // vq.a0
    public /* bridge */ /* synthetic */ boolean v() {
        return ((Boolean) E()).booleanValue();
    }
}
