package kc;

import android.app.usage.UsageEvents;
import com.transsion.hubsdk.app.usage.TranUsageEvents;

/* JADX INFO: loaded from: classes2.dex */
public class a implements df.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranUsageEvents f9169a = new TranUsageEvents();

    @Override // df.a
    public String a(UsageEvents.Event event) {
        TranUsageEvents tranUsageEvents = this.f9169a;
        if (tranUsageEvents != null) {
            return tranUsageEvents.getNotificationChannelId(event);
        }
        return null;
    }
}
