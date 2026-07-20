package ce;

import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Switch;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.iotservice.multiscreen.pc.ui.dialog.CastControlDialog;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideActivity;
import com.transsion.iotservice.multiscreen.pc.ui.search.SearchActivity;
import com.transsion.widgetPerGuide.perguide.PerGuideAdapter;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBaseCloseBottomSheetDialog;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetContainer;
import com.transsion.widgetslib.view.OSLoadingButton;
import com.transsion.widgetslib.widget.editext.ExtendedEditText;
import com.transsion.widgetslib.widget.editext.OSMaterialEditText;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar;
import com.transsion.widgetslistitemlayout.OSListItemView;
import jd.h;
import jd.i;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1460b;

    public /* synthetic */ a(Object obj, int i8) {
        this.f1459a = i8;
        this.f1460b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener;
        Object obj = this.f1460b;
        switch (this.f1459a) {
            case 0:
                ExtendedEditText extendedEditText = ((OSMaterialEditText) obj).e;
                String[] strArr = j.f8764a;
                if (extendedEditText != null && extendedEditText.isAttachedToWindow()) {
                    extendedEditText.requestFocus();
                    ((InputMethodManager) extendedEditText.getContext().getSystemService(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD)).showSoftInput(extendedEditText, 0);
                    break;
                }
                break;
            case 1:
                int i8 = PerGuideAdapter.PerGuideHolder.f2966b;
                Switch r7 = (Switch) obj;
                r7.setChecked(!r7.isChecked());
                break;
            case 2:
                int i9 = OSBaseCloseBottomSheetDialog.f2991j;
                OSBaseCloseBottomSheetDialog this$0 = (OSBaseCloseBottomSheetDialog) obj;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.k();
                break;
            case 3:
                OSBottomSheetContainer.a((OSBottomSheetContainer) obj);
                break;
            case 4:
                h hVar = ((i) obj).f6173m;
                if (hVar != null) {
                    hVar.b(view, false);
                }
                break;
            case 5:
                OSLiquidToolBar.createOptionsMenuPopupWindow$lambda$6((OSLiquidToolBar) obj, view);
                break;
            case 6:
                OSLiquidWidgetToolBar.createOptionsMenuPopupWindow$lambda$6((OSLiquidWidgetToolBar) obj, view);
                break;
            case 7:
                OSLoadingButton oSLoadingButton = (OSLoadingButton) obj;
                if (!oSLoadingButton.f3162c && (onClickListener = oSLoadingButton.f3164h) != null) {
                    onClickListener.onClick(oSLoadingButton);
                    break;
                }
                break;
            case 8:
                int i10 = CastControlDialog.f2710n;
                ((CastControlDialog) obj).finish();
                break;
            case 9:
                int i11 = FunctionGuideActivity.f2774o;
                ((FunctionGuideActivity) obj).finish();
                break;
            case 10:
                Intrinsics.checkNotNullParameter("bindSwitch", "tag");
                Intrinsics.checkNotNullParameter("Row clicked", "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("bindSwitch"), "Row clicked");
                }
                OSListItemView oSListItemView = (OSListItemView) obj;
                Switch r10 = oSListItemView.getSwitch();
                boolean z2 = !(r10 != null ? r10.isChecked() : false);
                Switch r11 = oSListItemView.getSwitch();
                if (r11 != null) {
                    r11.setChecked(z2);
                }
                break;
            case 11:
                ((MaterialDatePicker) obj).lambda$initHeaderToggle$0(view);
                break;
            default:
                int i12 = SearchActivity.f2817s;
                ob.b bVar = ob.b.f8417b;
                bVar.getClass();
                ob.b.f8426m = 0;
                String triggerScene = ob.b.f8418c;
                Intrinsics.checkNotNullParameter(triggerScene, "triggerScene");
                bVar.f8437a.p(triggerScene);
                ((SearchActivity) obj).finishAndRemoveTask();
                break;
        }
    }
}
