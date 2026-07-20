package l6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class e<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9723c = "{}";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f9725b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f9726a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f9727b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f9728c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f9729d = 2;
    }

    public e(int i10, T t10) {
        this.f9724a = i10;
        this.f9725b = t10;
    }
}
