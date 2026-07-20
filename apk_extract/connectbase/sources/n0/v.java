package n0;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f11085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final LottieAnimationView f11086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final j f11087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11088d;

    @VisibleForTesting
    public v() {
        this.f11085a = new HashMap();
        this.f11088d = true;
        this.f11086b = null;
        this.f11087c = null;
    }

    public final String a(String str) {
        return str;
    }

    public final String b(String str) {
        if (this.f11088d && this.f11085a.containsKey(str)) {
            return this.f11085a.get(str);
        }
        if (this.f11088d) {
            this.f11085a.put(str, str);
        }
        return str;
    }

    public final void c() {
        LottieAnimationView lottieAnimationView = this.f11086b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        j jVar = this.f11087c;
        if (jVar != null) {
            jVar.invalidateSelf();
        }
    }

    public void d() {
        this.f11085a.clear();
        c();
    }

    public void e(String str) {
        this.f11085a.remove(str);
        c();
    }

    public void f(boolean z10) {
        this.f11088d = z10;
    }

    public void g(String str, String str2) {
        this.f11085a.put(str, str2);
        c();
    }

    public v(LottieAnimationView lottieAnimationView) {
        this.f11085a = new HashMap();
        this.f11088d = true;
        this.f11086b = lottieAnimationView;
        this.f11087c = null;
    }

    public v(j jVar) {
        this.f11085a = new HashMap();
        this.f11088d = true;
        this.f11087c = jVar;
        this.f11086b = null;
    }
}
