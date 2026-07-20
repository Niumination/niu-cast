package cf;

import e8.m;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    List<String> a(String str);

    boolean b(String str, String str2);

    boolean c(String str, String str2);

    void d(String str, String str2, Executor executor, Consumer<Boolean> consumer);

    void e(String str, String str2, int i10, int i11, m.a aVar);

    void f(String str, String str2, int i10, int i11);
}
