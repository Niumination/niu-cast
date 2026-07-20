package ef;

import androidx.core.app.NotificationCompat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f4924d;
    public Object e;

    public g(d6.d player) {
        Intrinsics.checkNotNullParameter(player, "player");
        h6.b bVar = new h6.b(player);
        this.f4924d = bVar;
        this.e = CollectionsKt.listOf((Object[]) new i6.a[]{bVar, new g6.a(player)});
    }

    public void a(d dVar) {
        int i8;
        int i9 = dVar.f4914c;
        if (i9 > 4096) {
            Arrays.fill((d[]) this.e, (Object) null);
            this.f4922b = ((d[]) this.e).length - 1;
            this.f4921a = 0;
            this.f4923c = 0;
            return;
        }
        int i10 = (this.f4923c + i9) - 4096;
        if (i10 > 0) {
            int length = ((d[]) this.e).length - 1;
            int i11 = 0;
            while (true) {
                i8 = this.f4922b;
                if (length < i8 || i10 <= 0) {
                    break;
                }
                int i12 = ((d[]) this.e)[length].f4914c;
                i10 -= i12;
                this.f4923c -= i12;
                this.f4921a--;
                i11++;
                length--;
            }
            d[] dVarArr = (d[]) this.e;
            int i13 = i8 + 1;
            System.arraycopy(dVarArr, i13, dVarArr, i13 + i11, this.f4921a);
            this.f4922b += i11;
        }
        int i14 = this.f4921a + 1;
        d[] dVarArr2 = (d[]) this.e;
        if (i14 > dVarArr2.length) {
            d[] dVarArr3 = new d[dVarArr2.length * 2];
            System.arraycopy(dVarArr2, 0, dVarArr3, dVarArr2.length, dVarArr2.length);
            this.f4922b = ((d[]) this.e).length - 1;
            this.e = dVarArr3;
        }
        int i15 = this.f4922b;
        this.f4922b = i15 - 1;
        ((d[]) this.e)[i15] = dVar;
        this.f4921a++;
        this.f4923c += i9;
    }

    public int b(d6.a config) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", "tag");
        Intrinsics.checkNotNullParameter("onConfigCreate", NotificationCompat.CATEGORY_MESSAGE);
        Iterator it = ((List) this.e).iterator();
        while (it.hasNext()) {
            ((i6.a) it.next()).c(config);
        }
        return 0;
    }

    public void c() {
        if (this.f4922b > this.f4921a + 1 || this.f4923c >= 4) {
            String msg = "jump frameIndex= " + this.f4921a + ",decodeIndex=" + this.f4922b + ",frameDiffTimes=" + this.f4923c;
            Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            this.f4921a = this.f4922b;
        }
        int i8 = this.f4922b;
        int i9 = this.f4921a;
        if (i8 != i9) {
            this.f4923c++;
        } else {
            this.f4923c = 0;
        }
        String msg2 = Intrinsics.stringPlus("onRendering frameIndex=", Integer.valueOf(i9));
        Intrinsics.checkNotNullParameter("AnimPlayer.AnimPluginManager", "tag");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Iterator it = ((List) this.e).iterator();
        while (it.hasNext()) {
            ((i6.a) it.next()).a(this.f4921a);
        }
        this.f4921a++;
    }

    public void d(qj.j jVar) {
        e(jVar.size(), 127, 0);
        ((qj.f) this.f4924d).I(jVar);
    }

    public void e(int i8, int i9, int i10) {
        qj.f fVar = (qj.f) this.f4924d;
        if (i8 < i9) {
            fVar.S(i8 | i10);
            return;
        }
        fVar.S(i10 | i9);
        int i11 = i8 - i9;
        while (i11 >= 128) {
            fVar.S(128 | (i11 & 127));
            i11 >>>= 7;
        }
        fVar.S(i11);
    }

    public g(qj.f fVar) {
        this.e = new d[8];
        this.f4922b = 7;
        this.f4924d = fVar;
    }
}
