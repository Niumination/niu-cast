package eo;

/* JADX INFO: loaded from: classes3.dex */
public enum e0 {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;


    @os.l
    public static final a Companion = new a();

    public static final class a {
        public a() {
        }

        @os.l
        public final e0 a(boolean z10, boolean z11, boolean z12) {
            if (z10) {
                return e0.SEALED;
            }
            if (z11) {
                return e0.ABSTRACT;
            }
            return z12 ? e0.OPEN : e0.FINAL;
        }

        public a(kn.w wVar) {
        }
    }
}
