package ie;

import android.view.inputmethod.BaseInputConnection;
import com.transsion.widgetslib.widget.timepicker.wheel.WheelView;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends BaseInputConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelView f5786a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(WheelView wheelView, WheelView wheelView2) {
        super(wheelView2, true);
        this.f5786a = wheelView;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence charSequence, int i8) {
        if (charSequence.length() <= 0 || !Character.isDigit(charSequence.charAt(0))) {
            return super.commitText(charSequence, i8);
        }
        char cCharAt = charSequence.charAt(0);
        float f = WheelView.I0;
        this.f5786a.m(cCharAt);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i8, int i9) {
        WheelView wheelView = this.f5786a;
        if (wheelView.C0.length() <= 0) {
            return false;
        }
        String str = wheelView.C0;
        wheelView.C0 = str.substring(0, str.length() - 1);
        wheelView.invalidate();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int i8) {
        if (i8 != 6) {
            return super.performEditorAction(i8);
        }
        this.f5786a.i();
        return true;
    }
}
