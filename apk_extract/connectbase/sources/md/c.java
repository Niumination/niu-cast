package md;

import com.transsion.hubsdk.internal.widget.TranNotificationExpandButton;

/* JADX INFO: loaded from: classes2.dex */
public class c implements gg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranNotificationExpandButton f10636a = new TranNotificationExpandButton();

    @Override // gg.b
    public void a(Object obj, boolean z10) {
        TranNotificationExpandButton tranNotificationExpandButton = this.f10636a;
        if (tranNotificationExpandButton != null) {
            tranNotificationExpandButton.setExpandedVisibility(obj, z10);
        }
    }
}
