package p2;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class e extends h3.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f8655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f8656c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.f8656c = aVar;
        this.f8655b = context.getApplicationContext();
    }

    @Override // h3.e, android.os.Handler
    public final void handleMessage(Message message) {
        int i8 = message.what;
        if (i8 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i8);
            return;
        }
        int i9 = b.f8649a;
        a aVar = this.f8656c;
        Context context = this.f8655b;
        int iC = aVar.c(context, i9);
        int i10 = c.f8653c;
        if (iC == 1 || iC == 2 || iC == 3 || iC == 9) {
            Intent intentB = aVar.b(context, iC, "n");
            aVar.g(context, iC, intentB == null ? null : PendingIntent.getActivity(context, 0, intentB, 201326592));
        }
    }
}
