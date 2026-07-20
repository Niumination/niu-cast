package lm;

/* JADX INFO: loaded from: classes3.dex */
public class i1 extends h1 {
    @an.f
    public static final <R> R l(Object obj, jn.a<? extends R> aVar) {
        R rInvoke;
        kn.l0.p(obj, "lock");
        kn.l0.p(aVar, "block");
        synchronized (obj) {
            rInvoke = aVar.invoke();
        }
        return rInvoke;
    }
}
