package yb;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import bb.w;
import com.transsion.iotservice.multiscreen.pc.ui.search.fragment.SearchPcFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchPcFragment f11115a;

    public f(SearchPcFragment searchPcFragment) {
        this.f11115a = searchPcFragment;
    }

    @Override // bb.w
    public final void d(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        boolean zEquals = TextUtils.equals("shortcut_open_click", ob.b.f8418c);
        tj.w wVar = bVar.f8437a;
        if (zEquals || TextUtils.equals("setting_open_click", ob.b.f8418c)) {
            Intrinsics.checkNotNullParameter("pc_connection", "triggerScene");
            wVar.s("pc_connection");
        } else {
            String triggerScene = ob.b.f8418c;
            Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
            wVar.s(triggerScene);
        }
        Context context = this.f11115a.requireContext();
        Intrinsics.checkNotNullExpressionValue(context, "requireContext(...)");
        Intrinsics.checkNotNullParameter(context, "context");
        ClipboardManager clipboardManager = (ClipboardManager) ContextCompat.getSystemService(context, ClipboardManager.class);
        ClipData clipDataNewPlainText = ClipData.newPlainText("text", text);
        Intrinsics.checkNotNullExpressionValue(clipDataNewPlainText, "newPlainText(...)");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
    }
}
