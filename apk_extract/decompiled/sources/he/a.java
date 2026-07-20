package he;

import android.provider.Settings;
import com.transsion.widgetslib.widget.timepicker.OSDateTimePicker;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSDateTimePicker f5298b;

    public /* synthetic */ a(OSDateTimePicker oSDateTimePicker, int i8) {
        this.f5297a = i8;
        this.f5298b = oSDateTimePicker;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OSDateTimePicker oSDateTimePicker = this.f5298b;
        switch (this.f5297a) {
            case 0:
                int i8 = OSDateTimePicker.f3736l;
                Settings.System.getInt(oSDateTimePicker.getContext().getContentResolver(), "haptic_feedback_enabled", 0);
                break;
            default:
                if (oSDateTimePicker.e) {
                    oSDateTimePicker.e = false;
                    int i9 = oSDateTimePicker.f3742i;
                    oSDateTimePicker.f3742i = 0;
                    if ((i9 & 2) != 0) {
                        oSDateTimePicker.a(1);
                        break;
                    } else if ((i9 & 4) != 0) {
                        oSDateTimePicker.a(2);
                        break;
                    } else if ((i9 & 8) == 0) {
                        if ((i9 & 16) != 0) {
                            oSDateTimePicker.a(4);
                        } else if ((i9 & 32) != 0) {
                            oSDateTimePicker.a(5);
                        } else if ((i9 & 64) != 0) {
                            oSDateTimePicker.a(6);
                        } else if ((i9 & 128) == 0) {
                            oSDateTimePicker.a(oSDateTimePicker.f3741h);
                        } else {
                            oSDateTimePicker.a(7);
                        }
                        break;
                    }
                }
                break;
        }
    }
}
