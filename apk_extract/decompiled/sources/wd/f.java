package wd;

import android.content.Context;
import com.transsion.widgetslib.widget.OsPressSmoothCornerDrawable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends Lambda implements Function0 {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final OsPressSmoothCornerDrawable invoke() {
        OsPressSmoothCornerDrawable osPressSmoothCornerDrawable = new OsPressSmoothCornerDrawable(this.$context);
        osPressSmoothCornerDrawable.setClickable(false);
        return osPressSmoothCornerDrawable;
    }
}
