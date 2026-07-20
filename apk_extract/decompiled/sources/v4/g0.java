package v4;

/* JADX INFO: loaded from: classes.dex */
public interface g0 {
    public static final g0 BLOCK_INACCESSIBLE_JAVA = new e0(0);
    public static final g0 BLOCK_ALL_JAVA = new e0(1);
    public static final g0 BLOCK_ALL_ANDROID = new e0(2);
    public static final g0 BLOCK_ALL_PLATFORM = new e0(3);

    f0 check(Class<?> cls);
}
