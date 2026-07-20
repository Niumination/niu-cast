package l3;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f7241a = new g0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g0 f7242b;

    static {
        g0 g0Var = null;
        try {
            g0Var = (g0) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f7242b = g0Var;
    }
}
