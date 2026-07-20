package p9;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<T> f13064a;

    public h(List<T> list) {
        this.f13064a = list;
    }

    public static <T> h<T> a() {
        return new h<>(Collections.emptyList());
    }

    public List<T> b() {
        return this.f13064a;
    }
}
