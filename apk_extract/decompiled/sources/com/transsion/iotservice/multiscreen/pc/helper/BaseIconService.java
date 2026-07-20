package com.transsion.iotservice.multiscreen.pc.helper;

import android.os.SystemClock;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import bb.a;
import bb.b;
import eb.y0;
import java.util.List;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li.h0;
import li.l0;
import li.v0;
import o.d;
import qi.c;
import si.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/helper/BaseIconService;", "Landroid/service/quicksettings/TileService;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class BaseIconService extends TileService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2659c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f2660a = new a(this, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f2661b;

    public BaseIconService() {
        v0 v0Var = v0.f7498a;
        this.f2661b = h0.a(e.f10118a);
    }

    public abstract List a();

    public final void b(boolean z2) {
        String strO = d.o("<updateIconState>, isOpen:", z2, "BaseIconService", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseIconService"), strO);
        }
        if (z2) {
            Tile qsTile = getQsTile();
            if (qsTile != null) {
                qsTile.setState(2);
            }
        } else {
            Tile qsTile2 = getQsTile();
            if (qsTile2 != null) {
                qsTile2.setState(1);
            }
        }
        Tile qsTile3 = getQsTile();
        if (qsTile3 != null) {
            qsTile3.updateTile();
        }
    }

    @Override // android.service.quicksettings.TileService
    public final void onClick() {
        gc.c("BaseIconService", "onClick");
        super.onClick();
        if (!y0.e) {
            l0.p(this.f2661b, null, null, new b(this, new a(this, 1), null), 3);
            return;
        }
        ob.b bVar = ob.b.f8417b;
        bVar.getClass();
        Intrinsics.checkNotNullParameter("shortcut_center", "entry");
        long jElapsedRealtime = SystemClock.elapsedRealtime() - ob.b.f;
        Intrinsics.checkNotNullParameter("shortcut_center", "entry");
        bVar.f8437a.Q(jElapsedRealtime);
        gc.d("BaseIconService", "stop pc connect");
        y0.b("icon service");
    }

    @Override // android.app.Service
    public final void onCreate() {
        Intrinsics.checkNotNullParameter("BaseIconService", "tag");
        Intrinsics.checkNotNullParameter("onCreate", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseIconService"), "onCreate");
        }
        super.onCreate();
        y0.f4816d.observeForever(new bb.c(this.f2660a));
    }

    @Override // android.service.quicksettings.TileService, android.app.Service
    public final void onDestroy() {
        Intrinsics.checkNotNullParameter("BaseIconService", "tag");
        Intrinsics.checkNotNullParameter("onDestroy", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseIconService"), "onDestroy");
        }
        super.onDestroy();
        y0.f4816d.removeObserver(new bb.c(this.f2660a));
    }

    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        Intrinsics.checkNotNullParameter("BaseIconService", "tag");
        Intrinsics.checkNotNullParameter("onStartListening", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseIconService"), "onStartListening");
        }
        super.onStartListening();
        b(y0.e);
    }

    @Override // android.service.quicksettings.TileService
    public final void onStopListening() {
        Intrinsics.checkNotNullParameter("BaseIconService", "tag");
        Intrinsics.checkNotNullParameter("onStopListening", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("BaseIconService"), "onStopListening");
        }
        super.onStopListening();
    }
}
