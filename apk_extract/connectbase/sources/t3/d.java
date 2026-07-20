package t3;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f15469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CopyOnWriteArrayList<Integer> f15470b = new CopyOnWriteArrayList<>();

    public static CopyOnWriteArrayList<Integer> a() {
        return f15470b;
    }

    public static boolean b(int i10) {
        if (f15470b.contains(Integer.valueOf(i10))) {
            return false;
        }
        return f15470b.add(Integer.valueOf(i10));
    }

    public static boolean c(long j10) {
        return f15470b.contains(Integer.valueOf(y3.d.a(j10)));
    }

    public static int d() {
        return f15469a;
    }

    public static void e(int i10) {
        if (f15469a != 0) {
            y3.b.b("The host appId has been set 2 times");
        }
        f15469a = i10;
    }
}
