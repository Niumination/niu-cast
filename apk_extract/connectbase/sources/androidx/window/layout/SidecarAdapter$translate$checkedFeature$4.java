package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import jn.l;
import kn.l0;
import kn.n0;

/* JADX INFO: loaded from: classes.dex */
public final class SidecarAdapter$translate$checkedFeature$4 extends n0 implements l<SidecarDisplayFeature, Boolean> {
    public static final SidecarAdapter$translate$checkedFeature$4 INSTANCE = new SidecarAdapter$translate$checkedFeature$4();

    public SidecarAdapter$translate$checkedFeature$4() {
        super(1);
    }

    @Override // jn.l
    @os.l
    public final Boolean invoke(@os.l SidecarDisplayFeature sidecarDisplayFeature) {
        l0.p(sidecarDisplayFeature, "$this$require");
        return Boolean.valueOf(sidecarDisplayFeature.getRect().left == 0 || sidecarDisplayFeature.getRect().top == 0);
    }
}
