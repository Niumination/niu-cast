package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import jn.l;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes.dex */
public final class SidecarAdapter$translate$checkedFeature$2 extends n0 implements l<SidecarDisplayFeature, Boolean> {
    public static final SidecarAdapter$translate$checkedFeature$2 INSTANCE = new SidecarAdapter$translate$checkedFeature$2();

    public SidecarAdapter$translate$checkedFeature$2() {
        super(1);
    }

    @Override // jn.l
    @os.l
    public final Boolean invoke(@os.l SidecarDisplayFeature sidecarDisplayFeature) {
        l0.p(sidecarDisplayFeature, "$this$require");
        return Boolean.valueOf((sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) ? false : true);
    }
}
