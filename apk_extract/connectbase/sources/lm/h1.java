package lm;

import com.transsion.connectx.mirror.source.receiver.HomeKeyReceiver;

/* JADX INFO: loaded from: classes3.dex */
public class h1 {
    /* JADX WARN: Multi-variable type inference failed */
    @an.f
    public static final Void a() {
        throw new j0(null, 1, 0 == true ? 1 : 0);
    }

    @an.f
    public static final Void b(String str) {
        kn.l0.p(str, HomeKeyReceiver.f2161e);
        throw new j0(m.a.a("An operation is not implemented: ", str));
    }

    @f1(version = "1.1")
    @an.f
    public static final <T> T c(T t10, jn.l<? super T, l2> lVar) {
        kn.l0.p(lVar, "block");
        lVar.invoke(t10);
        return t10;
    }

    @an.f
    public static final <T> T d(T t10, jn.l<? super T, l2> lVar) {
        kn.l0.p(lVar, "block");
        lVar.invoke(t10);
        return t10;
    }

    @an.f
    public static final <T, R> R e(T t10, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(lVar, "block");
        return lVar.invoke(t10);
    }

    @an.f
    public static final void f(int i10, jn.l<? super Integer, l2> lVar) {
        kn.l0.p(lVar, k4.f.f8937e);
        for (int i11 = 0; i11 < i10; i11++) {
            lVar.invoke(Integer.valueOf(i11));
        }
    }

    @an.f
    public static final <T, R> R g(T t10, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(lVar, "block");
        return lVar.invoke(t10);
    }

    @an.f
    public static final <R> R h(jn.a<? extends R> aVar) {
        kn.l0.p(aVar, "block");
        return aVar.invoke();
    }

    @f1(version = "1.1")
    @an.f
    public static final <T> T i(T t10, jn.l<? super T, Boolean> lVar) {
        kn.l0.p(lVar, "predicate");
        if (lVar.invoke(t10).booleanValue()) {
            return t10;
        }
        return null;
    }

    @f1(version = "1.1")
    @an.f
    public static final <T> T j(T t10, jn.l<? super T, Boolean> lVar) {
        kn.l0.p(lVar, "predicate");
        if (lVar.invoke(t10).booleanValue()) {
            return null;
        }
        return t10;
    }

    @an.f
    public static final <T, R> R k(T t10, jn.l<? super T, ? extends R> lVar) {
        kn.l0.p(lVar, "block");
        return lVar.invoke(t10);
    }
}
