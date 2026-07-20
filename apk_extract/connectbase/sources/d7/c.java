package d7;

import android.graphics.Bitmap;
import android.graphics.RenderNode;

/* JADX INFO: loaded from: classes2.dex */
public class c implements of.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f3621a = "c";

    @Override // of.c
    public Bitmap a(RenderNode renderNode, int i10, int i11) {
        Class clsA = cc.a.a("android.graphics.HardwareRenderer");
        Class cls = Integer.TYPE;
        Object objJ = cc.a.j(cc.a.g(clsA, "createHardwareBitmap", RenderNode.class, cls, cls), null, renderNode, Integer.valueOf(i10), Integer.valueOf(i11));
        if (objJ instanceof Bitmap) {
            return (Bitmap) objJ;
        }
        return null;
    }
}
