package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ListViewCompat {
    private ListViewCompat() {
    }

    @ReplaceWith(expression = "listView.canScrollList(direction)")
    @Deprecated
    public static boolean canScrollList(@NonNull ListView listView, int i8) {
        return listView.canScrollList(i8);
    }

    @ReplaceWith(expression = "listView.scrollListBy(y)")
    @Deprecated
    public static void scrollListBy(@NonNull ListView listView, int i8) {
        listView.scrollListBy(i8);
    }
}
