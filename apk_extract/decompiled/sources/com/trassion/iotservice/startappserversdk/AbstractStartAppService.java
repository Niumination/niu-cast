package com.trassion.iotservice.startappserversdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/trassion/iotservice/startappserversdk/AbstractStartAppService;", "Landroid/app/Service;", "", "<init>", "()V", "StartAppSeverSDK_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class AbstractStartAppService extends Service {
    public abstract void a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Log.d("AbstractService", "onBind");
        a();
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.d("AbstractService", "onCreate");
        super.onCreate();
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        Log.d("AbstractService", "onUnbind");
        return super.onUnbind(intent);
    }
}
