package vq;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f17894a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f17894a;
    }

    @os.m
    public static final String b(@os.l String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
