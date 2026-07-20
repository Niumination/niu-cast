package ed;

import android.widget.CompoundButton;
import com.google.android.material.chip.Chip;
import com.transsion.widgetPerGuide.perguide.PerGuideAdapter;
import com.transsion.widgetPerGuide.perguide.PerGuideDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4837b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f4836a = i8;
        this.f4837b = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        Object obj = this.f4837b;
        switch (this.f4836a) {
            case 0:
                int i8 = PerGuideAdapter.PerGuideHolder.f2966b;
                PerGuideAdapter this$0 = (PerGuideAdapter) obj;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (this$0.f2965b != null && (compoundButton.getTag() instanceof Integer)) {
                    PerGuideDialog perGuideDialog = this$0.f2965b;
                    Intrinsics.checkNotNull(perGuideDialog);
                    Object tag = compoundButton.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                    ((e) perGuideDialog.u.get(((Integer) tag).intValue())).f4841d = z2;
                    if (z2) {
                        perGuideDialog.f2978v--;
                    } else {
                        perGuideDialog.f2978v++;
                    }
                    perGuideDialog.y().setEnabled(perGuideDialog.f2978v <= 0);
                    break;
                }
                break;
            default:
                ((Chip) obj).lambda$new$0(compoundButton, z2);
                break;
        }
    }
}
