package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import java.util.Map;
import kn.l0;
import kn.r1;
import lm.t0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nPersistableBundle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PersistableBundle.kt\nandroidx/core/os/PersistableBundleKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,155:1\n13579#2,2:156\n*S KotlinDebug\n*F\n+ 1 PersistableBundle.kt\nandroidx/core/os/PersistableBundleKt\n*L\n35#1:156,2\n*E\n"})
public final class PersistableBundleKt {
    @RequiresApi(21)
    @l
    public static final PersistableBundle persistableBundleOf(@l t0<String, ? extends Object>... t0VarArr) {
        l0.p(t0VarArr, "pairs");
        PersistableBundle persistableBundleCreatePersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(t0VarArr.length);
        for (t0<String, ? extends Object> t0Var : t0VarArr) {
            PersistableBundleApi21ImplKt.putValue(persistableBundleCreatePersistableBundle, t0Var.component1(), t0Var.component2());
        }
        return persistableBundleCreatePersistableBundle;
    }

    @RequiresApi(21)
    @l
    public static final PersistableBundle toPersistableBundle(@l Map<String, ? extends Object> map) {
        l0.p(map, "<this>");
        PersistableBundle persistableBundleCreatePersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(map.size());
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            PersistableBundleApi21ImplKt.putValue(persistableBundleCreatePersistableBundle, entry.getKey(), entry.getValue());
        }
        return persistableBundleCreatePersistableBundle;
    }

    @RequiresApi(21)
    @l
    public static final PersistableBundle persistableBundleOf() {
        return PersistableBundleApi21ImplKt.createPersistableBundle(0);
    }
}
