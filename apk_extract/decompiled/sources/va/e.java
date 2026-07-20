package va;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    /* JADX WARN: Code duplicated, block: B:9:0x0039  */
    public static final void a(ConstraintLayout constraintLayout, Context context) {
        int dimensionPixelSize;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(context, "context");
        int identifier = context.getResources().getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier <= 0 || !context.getResources().getBoolean(identifier)) {
            dimensionPixelSize = 0;
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            Resources resources = context.getResources();
            int identifier2 = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier2 != 0) {
                dimensionPixelSize = resources.getDimensionPixelSize(identifier2);
            } else {
                dimensionPixelSize = 0;
            }
        }
        if (constraintLayout != null) {
            constraintLayout.setPadding(0, 0, 0, dimensionPixelSize);
        }
    }

    public static final void b(TextView textView, String strText, String colorStrText, Function1 function1) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(strText, "strText");
        Intrinsics.checkNotNullParameter(colorStrText, "colorStrText");
        lj.c.b(textView, StringsKt__StringsJVMKt.replace$default(strText, "%s", colorStrText, false, 4, (Object) null), 0, colorStrText, function1, 2);
    }
}
