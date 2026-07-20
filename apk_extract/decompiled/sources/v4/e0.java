package v4;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10471a;

    @Override // v4.g0
    public final f0 check(Class cls) {
        switch (this.f10471a) {
            case 0:
                return x4.z.isJavaType((Class<?>) cls) ? f0.BLOCK_INACCESSIBLE : f0.INDECISIVE;
            case 1:
                return x4.z.isJavaType((Class<?>) cls) ? f0.BLOCK_ALL : f0.INDECISIVE;
            case 2:
                return x4.z.isAndroidType((Class<?>) cls) ? f0.BLOCK_ALL : f0.INDECISIVE;
            default:
                return x4.z.isAnyPlatformType(cls) ? f0.BLOCK_ALL : f0.INDECISIVE;
        }
    }

    public final String toString() {
        switch (this.f10471a) {
            case 0:
                return "ReflectionAccessFilter#BLOCK_INACCESSIBLE_JAVA";
            case 1:
                return "ReflectionAccessFilter#BLOCK_ALL_JAVA";
            case 2:
                return "ReflectionAccessFilter#BLOCK_ALL_ANDROID";
            default:
                return "ReflectionAccessFilter#BLOCK_ALL_PLATFORM";
        }
    }
}
