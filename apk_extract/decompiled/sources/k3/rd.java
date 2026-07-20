package k3;

import android.content.res.AssetManager;
import android.util.Log;
import com.tencent.qgame.animplayer.AnimView;
import com.transsion.iotservice.multiscreen.pc.bean.VapResource;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class rd {
    public static final void a(AnimView animView, VapResource item, Boolean bool, boolean z2) {
        String path;
        Intrinsics.checkNotNullParameter(animView, "<this>");
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getSupportDayNight()) {
            path = Intrinsics.areEqual(bool, Boolean.TRUE) ? o.d.l(item.getPath(), File.separator, "night") : o.d.l(item.getPath(), File.separator, "light");
        } else {
            path = item.getPath();
        }
        if (z2) {
            animView.setLoop(Integer.MAX_VALUE);
        }
        int type = item.getType();
        if (type != 0) {
            if (type != 1) {
                return;
            }
            String strN = o.d.n("startPlay: file, ", path, "AnimView", "tag", "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("AnimView"), strN);
            }
            animView.d(new File(o.d.l(path, File.separator, item.getName())));
            return;
        }
        String strN2 = o.d.n("startPlay: assets, ", path, "AnimView", "tag", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("AnimView"), strN2);
        }
        AssetManager assets = animView.getResources().getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
        animView.c(assets, path + File.separator + item.getName());
    }
}
