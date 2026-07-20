package ae;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.transsion.widgetsbottomsheet.R$dimen;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f115a;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f115a) {
            case 0:
                outline.setOval(0, 0, view.getWidth(), view.getHeight());
                break;
            case 1:
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), view.getContext().getResources().getDimension(R$dimen.os_radius_xxxl));
                break;
            case 2:
                Intrinsics.checkNotNull(view);
                int width = view.getWidth();
                int height = view.getHeight();
                Path path = new Path();
                float dimension = view.getResources().getDimension(R$dimen.os_bottom_sheet_radius);
                path.addRoundRect(new RectF(0.0f, 0.0f, width, height), new float[]{dimension, dimension, dimension, dimension, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                Intrinsics.checkNotNull(outline);
                outline.setConvexPath(path);
                break;
            default:
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                float fCoerceAtMost = RangesKt.coerceAtMost(view.getWidth() / 2.0f, view.getHeight() / 2.0f);
                Path path2 = new Path();
                path2.addCircle(view.getWidth() / 2.0f, view.getHeight() / 2.0f, fCoerceAtMost, Path.Direction.CCW);
                outline.setPath(path2);
                break;
        }
    }
}
