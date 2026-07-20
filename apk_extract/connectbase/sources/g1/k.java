package g1;

/* JADX INFO: loaded from: classes.dex */
@f
@b1.b(emulated = true)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<char[]> f6374a = new a();

    public class a extends ThreadLocal<char[]> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public char[] initialValue() {
            return new char[1024];
        }
    }

    public static char[] a() {
        return f6374a.get();
    }
}
