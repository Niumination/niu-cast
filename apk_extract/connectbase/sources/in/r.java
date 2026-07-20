package in;

/* JADX INFO: loaded from: classes3.dex */
public class r extends Error {
    public r() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public r(@os.m String str) {
        super(str);
    }

    public r(@os.m String str, @os.m Throwable th2) {
        super(str, th2);
    }

    public r(@os.m Throwable th2) {
        super(th2);
    }
}
