package be;

import com.transsion.widgetslib.widget.autoadjust.OSMediumButton;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSMediumButton f1271b;

    public /* synthetic */ a(OSMediumButton oSMediumButton, int i8) {
        this.f1270a = i8;
        this.f1271b = oSMediumButton;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1270a) {
            case 0:
                OSMediumButton oSMediumButton = this.f1271b;
                oSMediumButton.f3477i = false;
                oSMediumButton.f3474c.setOrientation(0);
                break;
            default:
                OSMediumButton oSMediumButton2 = this.f1271b;
                oSMediumButton2.f3477i = true;
                oSMediumButton2.f3474c.setOrientation(1);
                break;
        }
    }
}
