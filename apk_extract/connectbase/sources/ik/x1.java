package ik;

/* JADX INFO: loaded from: classes2.dex */
public final class x1 extends IllegalArgumentException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x1(@os.l String str) {
        super("Header(s) " + str + " are controlled by the engine and cannot be set explicitly");
        kn.l0.p(str, "header");
    }
}
