package t3;

import java.lang.ref.SoftReference;
import k6.g;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SoftReference<g.f> f15456b;

    public b(String str, g.f fVar) {
        this.f15455a = str;
        this.f15456b = new SoftReference<>(fVar);
    }
}
