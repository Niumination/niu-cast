package v1;

/* JADX INFO: loaded from: classes.dex */
public interface w {
    public static final w BLOCK_INACCESSIBLE_JAVA = new a();
    public static final w BLOCK_ALL_JAVA = new b();
    public static final w BLOCK_ALL_ANDROID = new c();
    public static final w BLOCK_ALL_PLATFORM = new d();

    public class a implements w {
        @Override // v1.w
        public e check(Class<?> cls) {
            return x1.n.isJavaType(cls) ? e.BLOCK_INACCESSIBLE : e.INDECISIVE;
        }
    }

    public class b implements w {
        @Override // v1.w
        public e check(Class<?> cls) {
            return x1.n.isJavaType(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    public class c implements w {
        @Override // v1.w
        public e check(Class<?> cls) {
            return x1.n.isAndroidType(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    public class d implements w {
        @Override // v1.w
        public e check(Class<?> cls) {
            return x1.n.isAnyPlatformType(cls) ? e.BLOCK_ALL : e.INDECISIVE;
        }
    }

    public enum e {
        ALLOW,
        INDECISIVE,
        BLOCK_INACCESSIBLE,
        BLOCK_ALL
    }

    e check(Class<?> cls);
}
