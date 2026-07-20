package vc;

import android.graphics.drawable.VectorDrawable;
import com.transsion.hubsdk.graphics.TranVectorDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class g implements of.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranVectorDrawable f16901a = new TranVectorDrawable();

    @Override // of.f
    public boolean a(VectorDrawable vectorDrawable, int i10, int i11, int i12, String str) {
        TranVectorDrawable tranVectorDrawable = this.f16901a;
        if (tranVectorDrawable != null) {
            return tranVectorDrawable.updateIconColor(vectorDrawable, i10, i11, i12, str);
        }
        return false;
    }
}
