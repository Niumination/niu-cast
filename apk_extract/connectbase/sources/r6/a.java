package r6;

import android.app.usage.UsageEvents;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a implements df.a {
    @Override // df.a
    public String a(UsageEvents.Event event) {
        Method methodG = cc.a.g(event.getClass(), "getNotificationChannelId", new Class[0]);
        if (methodG != null) {
            return (String) cc.a.j(methodG, event, new Object[0]);
        }
        return null;
    }
}
