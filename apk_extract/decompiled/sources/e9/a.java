package e9;

import android.util.Log;
import com.transsion.hubsdk.view.TranUnionRenderEffect;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v9.a f4737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q8.a f4738b;

    public a(TranUnionRenderEffect tranUnionRenderEffect) {
        ga.a aVarC = c(l9.a.f7348i, false);
        if (aVarC instanceof v9.a) {
            ((v9.a) aVarC).f10527a = tranUnionRenderEffect;
        } else {
            boolean z2 = j9.a.f6132a;
            Log.e("a", "re-establish TranUnionRenderEffectProxy fail: mAospService not support.");
        }
    }

    public static final int a() {
        return TranUnionRenderEffect.getApiLevel();
    }

    public final TranUnionRenderEffect b() {
        return c(l9.a.f7348i, true).c();
    }

    public final ga.a c(String str, boolean z2) {
        if (l9.b.a(str)) {
            j9.a.c("a", "TranThubUnionRenderEffect");
            v9.a aVar = this.f4737a;
            if (aVar != null) {
                return aVar;
            }
            v9.a aVar2 = new v9.a(z2);
            this.f4737a = aVar2;
            return aVar2;
        }
        j9.a.c("a", "TranAospUnionRenderEffect");
        q8.a aVar3 = this.f4738b;
        if (aVar3 != null) {
            return aVar3;
        }
        q8.a aVar4 = new q8.a();
        this.f4738b = aVar4;
        return aVar4;
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof a) && ((a) obj).b() == b();
    }
}
