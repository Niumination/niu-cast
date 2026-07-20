package zd;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.transsion.widgetslib.widget.OSSmoothCornerFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OSSmoothCornerFrameLayout f11306a;

    public s(OSSmoothCornerFrameLayout oSSmoothCornerFrameLayout) {
        this.f11306a = oSSmoothCornerFrameLayout;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        bd.b bVar;
        z9.b bVar2;
        o9.b bVar3;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(outline, "outline");
        OSSmoothCornerFrameLayout oSSmoothCornerFrameLayout = this.f11306a;
        u8.d dVar = oSSmoothCornerFrameLayout.e;
        int width = view.getWidth();
        int height = view.getHeight();
        float f = oSSmoothCornerFrameLayout.f3415b;
        u8.c cVar = u8.c.ALL;
        dVar.getClass();
        if (outline == null) {
            throw new IllegalArgumentException("Illegal parameters outline == null");
        }
        float f4 = f * 1.4f;
        if (l9.b.a(l9.a.f7350k)) {
            bVar3 = dVar.f10417a;
            if (bVar3 == null) {
                bVar2 = bVar3;
                o9.b bVar4 = new o9.b();
                dVar.f10417a = bVar4;
                bVar2 = bVar4;
            }
        } else {
            bVar = dVar.f10418b;
            if (bVar == null) {
                bVar2 = bVar;
                bd.b bVar5 = new bd.b();
                dVar.f10418b = bVar5;
                bVar2 = bVar5;
            }
        }
        bVar2 = bVar;
        bVar2 = bVar3;
        bVar2.a(outline, width, height, f4, u8.d.f10416c[cVar.ordinal()]);
    }
}
