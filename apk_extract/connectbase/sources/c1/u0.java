package c1;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public abstract class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u0 f1249a = new a();

    public class a extends u0 {
        @Override // c1.u0
        public long a() {
            return System.nanoTime();
        }
    }

    public static u0 b() {
        return f1249a;
    }

    public abstract long a();
}
