package l3;

/* JADX INFO: loaded from: classes.dex */
public final class n2 extends RuntimeException {
    public n2(q1 q1Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final b1 zza() {
        return new b1(getMessage());
    }
}
