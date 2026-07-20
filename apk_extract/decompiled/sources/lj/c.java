package lj;

import android.R;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import k3.gc;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static boolean a() {
        return d.f7518d;
    }

    public static void b(TextView textView, String content, int i8, String str, Function1 function1, int i9) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        if ((i9 & 4) != 0) {
            str = null;
        }
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        if (i8 != 0) {
            str = textView.getContext().getString(i8);
        } else if (str == null) {
            str = "";
        }
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Intrinsics.checkNotNull(str);
        va.c cVar = new va.c(context, str, function1);
        textView.setOnTouchListener(new sa.l(1, textView, cVar));
        SpannableString spannableString = new SpannableString(content);
        String string = spannableString.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, str, 0, false, 6, (Object) null);
        int length = str.length() + iIndexOf$default;
        if (iIndexOf$default < 0 || length > spannableString.toString().length()) {
            String log = "setPartTextColor: ill param " + str + ", " + ((Object) spannableString);
            Intrinsics.checkNotNullParameter("TextViewExt", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 6) {
                Log.e(gc.f6463b.concat("TextViewExt"), log);
            }
        } else {
            spannableString.setSpan(cVar, iIndexOf$default, length, 17);
        }
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(ContextCompat.getColor(textView.getContext(), R.color.transparent));
    }
}
