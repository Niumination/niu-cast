package vc;

import android.graphics.Bitmap;
import android.graphics.RenderNode;
import com.transsion.hubsdk.graphics.TranHardwareRenderer;

/* JADX INFO: loaded from: classes2.dex */
public class d implements of.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16894a = "d";

    @Override // of.c
    public Bitmap a(final RenderNode renderNode, final int i10, final int i11) {
        return (Bitmap) new zb.f().c(new zb.f.b() { // from class: vc.c
            @Override // zb.f.b
            public final Object run() {
                return TranHardwareRenderer.createHardwareBitmap(renderNode, i10, i11);
            }
        }, f16894a);
    }
}
