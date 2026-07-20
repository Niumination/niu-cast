package q5;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.ui.search.SearchActivity;
import eb.y1;
import g3.b;
import g3.c;
import g3.d;
import k3.gc;
import k3.pb;
import kotlin.jvm.internal.Intrinsics;
import q7.f;
import q7.g;
import x7.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements j, d {
    public static Intent a(int i8, int i9) {
        int i10 = SearchActivity.f2817s;
        if ((i9 & 1) != 0) {
            i8 = 1;
        }
        Intent intent = new Intent(pb.a(), (Class<?>) SearchActivity.class);
        intent.putExtra("INTENT_FROM_PATH", i8);
        return intent;
    }

    @Override // x7.j
    public void b(f disconnectInfoBean) {
        Intrinsics.checkNotNullParameter(disconnectInfoBean, "disconnectInfoBean");
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter("source service disconnected", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), "source service disconnected");
        }
        y1.a();
    }

    @Override // g3.d
    public c f(Context context, String str, b bVar) {
        c cVar = new c();
        int iB = bVar.b(context, str);
        cVar.f5094a = iB;
        if (iB != 0) {
            cVar.f5096c = -1;
        } else {
            int iA = bVar.a(context, str, true);
            cVar.f5095b = iA;
            if (iA != 0) {
                cVar.f5096c = 1;
            }
        }
        return cVar;
    }

    @Override // x7.j
    public void k(g error) {
        Intrinsics.checkNotNullParameter(error, "error");
    }

    @Override // x7.j
    public void onConnected() {
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter("source service connected", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), "source service connected");
        }
    }
}
