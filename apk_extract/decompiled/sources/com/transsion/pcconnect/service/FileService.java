package com.transsion.pcconnect.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import zc.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/transsion/pcconnect/service/FileService;", "Landroid/app/Service;", "<init>", "()V", "m3/k0", "zc/a", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FileService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f2953b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2954a;

    public FileService() {
        a aVar = new a();
        aVar.attachInterface(aVar, "com.transsion.iotservice.pc.IDeviceService");
        this.f2954a = aVar;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f2954a;
    }
}
