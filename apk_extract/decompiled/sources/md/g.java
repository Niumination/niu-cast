package md;

import android.graphics.drawable.StateListDrawable;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public StateListDrawable f8020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f8021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f8022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f8023d;

    public h getCheckedDrawable() {
        return this.f8021b;
    }

    public h getDisabledDrawable() {
        return this.f8023d;
    }

    public h getNormalDrawable() {
        return this.f8022c;
    }

    public StateListDrawable getStateListDrawable() {
        return this.f8020a;
    }

    public void setCheckedDrawable(h hVar) {
        this.f8021b = hVar;
    }

    public void setDisabledDrawable(h hVar) {
        this.f8023d = hVar;
    }

    public void setNormalDrawable(h hVar) {
        this.f8022c = hVar;
    }

    public void setStateListDrawable(StateListDrawable stateListDrawable) {
        this.f8020a = stateListDrawable;
    }
}
