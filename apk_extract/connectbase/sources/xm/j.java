package xm;

import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
public abstract class j extends a {
    public j(@os.m um.d<Object> dVar) {
        super(dVar);
        if (dVar != null && dVar.getContext() != um.i.INSTANCE) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // um.d
    @os.l
    public um.g getContext() {
        return um.i.INSTANCE;
    }
}
