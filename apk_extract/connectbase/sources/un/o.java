package un;

import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
public interface o<V> extends un.c<V> {

    public interface a<V> {
        @os.l
        o<V> j();
    }

    public static final class b {
        public static /* synthetic */ void a() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void b() {
        }

        @f1(version = "1.1")
        public static /* synthetic */ void c() {
        }
    }

    public interface c<V> extends a<V>, i<V> {
    }

    @os.l
    c<V> getGetter();

    boolean isConst();

    boolean isLateinit();
}
