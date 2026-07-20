package com.transsion.iotservice.multiscreen.pc.helper;

import android.content.Intent;
import android.service.quicksettings.Tile;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.iotservice.multiscreen.pc.R$string;
import com.transsion.iotservice.multiscreen.pc.bean.Permission;
import java.util.List;
import jb.h;
import k3.gc;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/helper/IconService;", "Lcom/transsion/iotservice/multiscreen/pc/helper/BaseIconService;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class IconService extends BaseIconService {
    @Override // com.transsion.iotservice.multiscreen.pc.helper.BaseIconService
    public final List a() {
        Permission permission = h.f6138a;
        return CollectionsKt.listOf((Object[]) new Permission[]{h.f6141d, h.f6138a, h.f6139b});
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i8, int i9) {
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            qsTile.setLabel(getString(R$string.module_pc_connect));
        }
        Tile qsTile2 = getQsTile();
        if (qsTile2 != null) {
            qsTile2.updateTile();
        }
        Tile qsTile3 = getQsTile();
        String log = "<updateIconLang>, lang:" + ((Object) (qsTile3 != null ? qsTile3.getLabel() : null));
        Intrinsics.checkNotNullParameter("PhoneIconService", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("PhoneIconService"), log);
        }
        return super.onStartCommand(intent, i8, i9);
    }

    @Override // com.transsion.iotservice.multiscreen.pc.helper.BaseIconService, android.service.quicksettings.TileService
    public final void onStartListening() {
        super.onStartListening();
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            qsTile.setLabel(getString(R$string.module_pc_connect));
        }
        Tile qsTile2 = getQsTile();
        if (qsTile2 != null) {
            qsTile2.updateTile();
        }
    }
}
