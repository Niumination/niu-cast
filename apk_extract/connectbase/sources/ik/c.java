package ik;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@os.l String str) {
        super(kn.l0.C("Bad Content-Type format: ", str));
        kn.l0.p(str, "value");
    }
}
