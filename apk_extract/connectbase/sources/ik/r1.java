package ik;

/* JADX INFO: loaded from: classes2.dex */
public final class r1 extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r1(@os.l String str, @os.l Throwable th2) {
        super(kn.l0.C("Fail to parse url: ", str), th2);
        kn.l0.p(str, "urlString");
        kn.l0.p(th2, "cause");
    }
}
