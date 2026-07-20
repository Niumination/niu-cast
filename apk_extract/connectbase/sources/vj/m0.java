package vj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<l> f17181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<o2> f17182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<u2.a> f17183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f17184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f17185e;

    public static synchronized List<l> a() {
        f17185e = true;
        return f17181a;
    }

    public static synchronized List<o2> b() {
        f17185e = true;
        return f17182b;
    }

    public static synchronized List<u2.a> c() {
        f17185e = true;
        return f17183c;
    }

    public static synchronized void d(List<l> list, List<o2> list2, List<u2.a> list3) {
        if (f17185e) {
            throw new IllegalStateException("Set cannot be called after any get call");
        }
        if (f17184d) {
            throw new IllegalStateException("Global interceptors and tracers are already set");
        }
        list.getClass();
        list2.getClass();
        list3.getClass();
        f17181a = Collections.unmodifiableList(new ArrayList(list));
        f17182b = Collections.unmodifiableList(new ArrayList(list2));
        f17183c = Collections.unmodifiableList(new ArrayList(list3));
        f17184d = true;
    }
}
