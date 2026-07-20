package je;

import android.view.View;
import com.transsion.widgetsliquid.view.OSLiquidToolBar;
import com.transsion.widgetsliquid.view.OSLiquidWidgetToolBar;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class s implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f6244b;

    public /* synthetic */ s(int i8, Function1 function1) {
        this.f6243a = i8;
        this.f6244b = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i8 = this.f6243a;
        Function1 function1 = this.f6244b;
        switch (i8) {
            case 0:
                OSLiquidToolBar.setOnLeftIconClickListener$lambda$19(function1, view);
                break;
            default:
                OSLiquidWidgetToolBar.setOnLeftIconClickListener$lambda$19(function1, view);
                break;
        }
    }
}
