package o4;

import androidx.core.app.NotificationCompat;
import k3.v8;
import ze.q2;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8369a;

    public a(Object obj, int i8) {
        switch (i8) {
            case 1:
                v8.i(q2.e, NotificationCompat.CATEGORY_STATUS);
                this.f8369a = obj;
                break;
            default:
                this.f8369a = obj;
                break;
        }
    }

    @Override // o4.c
    public Object a(u uVar) {
        return this.f8369a;
    }
}
