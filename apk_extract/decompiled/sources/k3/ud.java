package k3;

import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.transsion.widgetslistitemlayout.OSListItemView;
import k3.gc;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ud {
    public static final void a(final OSListItemView oSListItemView, final Function1 onAction) {
        Intrinsics.checkNotNullParameter(oSListItemView, "<this>");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Switch r7 = oSListItemView.getSwitch();
        if (r7 != null) {
            r7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: va.d
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    Switch r10;
                    OSListItemView oSListItemView2 = oSListItemView;
                    Switch r11 = oSListItemView2.getSwitch();
                    if (r11 == null || !r11.isShown() || (r10 = oSListItemView2.getSwitch()) == null || !r10.isAttachedToWindow()) {
                        return;
                    }
                    String strO = o.d.o("Switch state changed: ", z2, "bindSwitch", "tag", "log");
                    if (gc.f6462a <= 3) {
                        Log.d(gc.f6463b.concat("bindSwitch"), strO);
                    }
                    onAction.invoke(Boolean.valueOf(z2));
                }
            });
        }
        oSListItemView.setOnClickListener(new ce.a(oSListItemView, 10));
    }
}
