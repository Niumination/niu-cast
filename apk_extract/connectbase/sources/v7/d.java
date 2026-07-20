package v7;

import com.android.internal.widget.NotificationExpandButton;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class d implements gg.b {
    @Override // gg.b
    public void a(Object obj, boolean z10) {
        NotificationExpandButton notificationExpandButton;
        Method methodG;
        if (!(obj instanceof NotificationExpandButton) || (notificationExpandButton = (NotificationExpandButton) obj) == null || (methodG = cc.a.g(notificationExpandButton.getClass(), "setExpandedVisibility", Boolean.TYPE)) == null) {
            return;
        }
        cc.a.j(methodG, notificationExpandButton, Boolean.valueOf(z10));
    }
}
