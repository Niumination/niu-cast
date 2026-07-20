package gk;

/* JADX INFO: loaded from: classes2.dex */
public class c extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@os.l String str, @os.m Throwable th2) {
        super(str, th2);
        kn.l0.p(str, "message");
    }

    public /* synthetic */ c(String str, Throwable th2, int i10, kn.w wVar) {
        this(str, (i10 & 2) != 0 ? null : th2);
    }
}
