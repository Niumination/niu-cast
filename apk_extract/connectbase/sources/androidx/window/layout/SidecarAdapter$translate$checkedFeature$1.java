package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import jn.l;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes.dex */
public final class SidecarAdapter$translate$checkedFeature$1 extends n0 implements l<SidecarDisplayFeature, Boolean> {
    public static final SidecarAdapter$translate$checkedFeature$1 INSTANCE = new SidecarAdapter$translate$checkedFeature$1();

    public SidecarAdapter$translate$checkedFeature$1() {
        super(1);
    }

    @Override // jn.l
    @os.l
    public final Boolean invoke(@os.l SidecarDisplayFeature sidecarDisplayFeature) {
        l0.p(sidecarDisplayFeature, "$this$require");
        boolean z10 = true;
        if (sidecarDisplayFeature.getType() != 1 && sidecarDisplayFeature.getType() != 2) {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
