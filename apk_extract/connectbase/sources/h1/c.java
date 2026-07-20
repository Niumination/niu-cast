package h1;

import androidx.core.app.NotificationCompat;
import c1.z;

/* JADX INFO: loaded from: classes.dex */
@e
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f6929b;

    public c(Object source, Object event) {
        source.getClass();
        this.f6928a = source;
        event.getClass();
        this.f6929b = event;
    }

    public Object a() {
        return this.f6929b;
    }

    public Object b() {
        return this.f6928a;
    }

    public String toString() {
        return z.c(this).j("source", this.f6928a).j(NotificationCompat.CATEGORY_EVENT, this.f6929b).toString();
    }
}
