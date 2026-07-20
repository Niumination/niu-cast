package androidx.window.layout;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
final class EmptyDecorator implements WindowInfoTrackerDecorator {

    @l
    public static final EmptyDecorator INSTANCE = new EmptyDecorator();

    private EmptyDecorator() {
    }

    @Override // androidx.window.layout.WindowInfoTrackerDecorator
    @l
    public WindowInfoTracker decorate(@l WindowInfoTracker windowInfoTracker) {
        l0.p(windowInfoTracker, "tracker");
        return windowInfoTracker;
    }
}
