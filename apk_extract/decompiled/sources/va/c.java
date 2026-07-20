package va;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends ClickableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f10533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f10535d;
    public final int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f10536h;

    public c(Context context, String mColorStr, Function1 function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mColorStr, "mColorStr");
        this.f10532a = mColorStr;
        this.f10533b = function1;
        this.e = j.e(context, R$attr.os_platform_clickable_color, R$color.os_platform_clickable_color_hios);
        this.f10536h = j.e(context, R$attr.os_platform_basic_color, R$color.os_platform_basic_color_hios);
        if (na.c.a()) {
            this.e = j.d(R$attr.os_platform_clickable_color, context.getColor(R$color.os_platform_clickable_color_xos), context);
        }
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.f10534c < 1000) {
            return;
        }
        this.f10534c = jElapsedRealtime;
        Function1 function1 = this.f10533b;
        if (function1 != null) {
            function1.invoke(this.f10532a);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        super.updateDrawState(ds);
        ds.setColor(this.f10535d ? this.e : this.f10536h);
        ds.setUnderlineText(false);
    }
}
