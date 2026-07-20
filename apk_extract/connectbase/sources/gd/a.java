package gd;

import com.transsion.hubsdk.internal.graphic.TranDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class a implements zf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranDrawable f6466a = new TranDrawable();

    @Override // zf.a
    public void a(Object obj, float f10) {
        TranDrawable tranDrawable = this.f6466a;
        if (tranDrawable != null) {
            tranDrawable.setBlurSaturation(obj, f10);
        }
    }
}
