package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface ItemTouchUIUtil {
    void clearView(View view);

    void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f4, int i8, boolean z2);

    void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f4, int i8, boolean z2);

    void onSelected(View view);
}
