package k3;

import android.widget.TextView;
import com.transsion.iotservice.multiscreen.pc.bean.SearchPageText;
import com.transsion.iotservice.multiscreen.pc.bean.TextBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static cj.d f6431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static cj.d f6432b;

    public static final void a(TextView view, TextBean textBean) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(textBean, "textBean");
        String remotetext = textBean.getRemotetext();
        if (remotetext != null) {
            view.setText(remotetext);
            return;
        }
        Integer defaultText = textBean.getDefaultText();
        if (defaultText != null) {
            view.setText(defaultText.intValue());
        }
    }

    public static final void b(TextView view, SearchPageText searchPageText, bb.w wVar) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (searchPageText == null) {
            return;
        }
        if (!searchPageText.isDefault()) {
            String remotetext = searchPageText.getText().getRemotetext();
            Intrinsics.checkNotNull(remotetext);
            String remotetext2 = searchPageText.getLink().getRemotetext();
            Intrinsics.checkNotNull(remotetext2);
            va.e.b(view, remotetext, remotetext2, new gi.a(11, wVar, searchPageText));
            return;
        }
        Integer defaultText = searchPageText.getText().getDefaultText();
        Intrinsics.checkNotNull(defaultText);
        int iIntValue = defaultText.intValue();
        Integer defaultText2 = searchPageText.getLink().getDefaultText();
        Intrinsics.checkNotNull(defaultText2);
        int iIntValue2 = defaultText2.intValue();
        bb.f fVar = new bb.f(wVar, 2, view, searchPageText);
        Intrinsics.checkNotNullParameter(view, "<this>");
        String string = view.getContext().getString(iIntValue, view.getContext().getString(iIntValue2));
        Intrinsics.checkNotNull(string);
        lj.c.b(view, string, iIntValue2, null, fVar, 4);
    }
}
