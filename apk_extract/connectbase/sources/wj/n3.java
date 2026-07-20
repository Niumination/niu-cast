package wj;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public interface n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n3 f19104a = new a();

    public class a implements n3 {
        @Override // wj.n3
        public long a() {
            return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        }
    }

    long a();
}
