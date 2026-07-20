package com.transsion.iotservice.multiscreen.pc.helper;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotservice.multiscreen.pc.R$drawable;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.state.BaseState;
import com.transsion.iotservice.multiscreen.pc.state.MainSocketConnected;
import eb.y;
import k3.gc;
import k3.pb;
import k3.vb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import li.g2;
import li.h0;
import li.l0;
import li.v0;
import si.e;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/helper/PadBaseIconService;", "Landroid/service/quicksettings/TileService;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public class PadBaseIconService extends TileService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g2 f2669a;

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        int i8;
        int i9 = 1;
        boolean z2 = y.f4804h.compareTo((BaseState) new MainSocketConnected()) > 0;
        Boolean bool = (Boolean) y.f4808l.getValue();
        boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
        gc.c("PadBaseIconService", "updateTileState, isConnected: " + y.f4804h + ", isMirror: " + zBooleanValue);
        boolean z3 = y.f == 6;
        int i10 = (z2 && z3) ? R$drawable.ic_phone_cooperate_connect : R$drawable.ic_phone_cooperate_disconnect;
        if (!z2) {
            i8 = R$string.pad_not_connect;
        } else if (zBooleanValue && z3) {
            i8 = R$string.pad_connected_mirror;
        } else {
            i8 = z3 ? R$string.pad_connected : R$string.pad_not_connect;
        }
        if (z2 && z3) {
            i9 = 2;
        }
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            qsTile.setLabel(getString(R$string.pad_phone_screen_mirror));
            qsTile.setIcon(Icon.createWithResource(pb.a(), i10));
            qsTile.setSubtitle(getString(i8));
            qsTile.setState(i9);
            qsTile.updateTile();
            gc.c("PadBaseIconService", "Tile updated: isConnected=" + z2 + ", isMirror=" + zBooleanValue);
        }
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Intrinsics.checkNotNullParameter("PadBaseIconService", "tag");
        Intrinsics.checkNotNullParameter("PadBaseIconService created", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PadBaseIconService"), "PadBaseIconService created");
        }
        Context context = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context, "getApplicationContext(...)");
        Intrinsics.checkNotNullParameter(context, "context");
        vb.f6684a = context.getSharedPreferences("pc_connect", 0);
        v0 v0Var = v0.f7498a;
        this.f2669a = l0.p(h0.a(e.f10118a), null, null, new bb.y(this, null), 3);
    }

    @Override // android.service.quicksettings.TileService, android.app.Service
    public final void onDestroy() {
        Intrinsics.checkNotNullParameter("PadBaseIconService", "tag");
        Intrinsics.checkNotNullParameter("PadBaseIconService destroyed", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PadBaseIconService"), "PadBaseIconService destroyed");
        }
        g2 g2Var = this.f2669a;
        if (g2Var != null) {
            g2Var.h(null);
        }
        super.onDestroy();
    }

    @Override // android.service.quicksettings.TileService
    public final void onStartListening() {
        Intrinsics.checkNotNullParameter("PadBaseIconService", "tag");
        Intrinsics.checkNotNullParameter("onStartListening", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PadBaseIconService"), "onStartListening");
        }
        a();
        super.onStartListening();
    }

    @Override // android.service.quicksettings.TileService
    public final void onStopListening() {
        Intrinsics.checkNotNullParameter("PadBaseIconService", "tag");
        Intrinsics.checkNotNullParameter("onStopListening", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PadBaseIconService"), "onStopListening");
        }
        super.onStopListening();
    }

    @Override // android.service.quicksettings.TileService
    public final void onTileAdded() {
        Intrinsics.checkNotNullParameter("PadBaseIconService", "tag");
        Intrinsics.checkNotNullParameter("Tile added, no long-click support", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("PadBaseIconService"), "Tile added, no long-click support");
        }
    }
}
