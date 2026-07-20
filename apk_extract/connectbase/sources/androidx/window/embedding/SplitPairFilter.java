package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import jq.h0;
import kn.l0;
import l.a;
import os.l;
import os.m;
import rs.f;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class SplitPairFilter {

    @l
    private final ComponentName primaryActivityName;

    @m
    private final String secondaryActivityIntentAction;

    @l
    private final ComponentName secondaryActivityName;

    public SplitPairFilter(@l ComponentName componentName, @l ComponentName componentName2, @m String str) {
        l0.p(componentName, "primaryActivityName");
        l0.p(componentName2, "secondaryActivityName");
        this.primaryActivityName = componentName;
        this.secondaryActivityName = componentName2;
        this.secondaryActivityIntentAction = str;
        String packageName = componentName.getPackageName();
        l0.o(packageName, "primaryActivityName.packageName");
        String className = componentName.getClassName();
        l0.o(className, "primaryActivityName.className");
        String packageName2 = componentName2.getPackageName();
        l0.o(packageName2, "secondaryActivityName.packageName");
        String className2 = componentName2.getClassName();
        l0.o(className2, "secondaryActivityName.className");
        if (packageName.length() == 0 || packageName2.length() == 0) {
            throw new IllegalArgumentException("Package name must not be empty");
        }
        if (className.length() == 0 || className2.length() == 0) {
            throw new IllegalArgumentException("Activity class name must not be empty.");
        }
        if (h0.T2(packageName, "*", false, 2, null) && h0.p3(packageName, "*", 0, false, 6, null) != packageName.length() - 1) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.");
        }
        if (h0.T2(className, "*", false, 2, null) && h0.p3(className, "*", 0, false, 6, null) != className.length() - 1) {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
        }
        if (h0.T2(packageName2, r12, r11, r10, r9) && h0.p3(packageName2, "*", 0, false, 6, null) != packageName2.length() - 1) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.");
        }
        if (h0.T2(className2, "*", false, 2, 0) && h0.p3(className2, "*", 0, false, 6, null) != className2.length() - 1) {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
        }
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        return l0.g(this.primaryActivityName, splitPairFilter.primaryActivityName) && l0.g(this.secondaryActivityName, splitPairFilter.secondaryActivityName) && l0.g(this.secondaryActivityIntentAction, splitPairFilter.secondaryActivityIntentAction);
    }

    @l
    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    @m
    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    @l
    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public int hashCode() {
        int iHashCode = (this.secondaryActivityName.hashCode() + (this.primaryActivityName.hashCode() * 31)) * 31;
        String str = this.secondaryActivityIntentAction;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final boolean matchesActivityIntentPair(@l Activity activity, @l Intent intent) {
        l0.p(activity, "primaryActivity");
        l0.p(intent, "secondaryActivityIntent");
        ComponentName componentName = activity.getComponentName();
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        if (!matcherUtils.areComponentsMatching$window_release(componentName, this.primaryActivityName) || !matcherUtils.areComponentsMatching$window_release(intent.getComponent(), this.secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityIntentAction;
        return str == null || l0.g(str, intent.getAction());
    }

    public final boolean matchesActivityPair(@l Activity activity, @l Activity activity2) {
        l0.p(activity, "primaryActivity");
        l0.p(activity2, "secondaryActivity");
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        boolean z10 = false;
        boolean z11 = matcherUtils.areComponentsMatching$window_release(activity.getComponentName(), this.primaryActivityName) && matcherUtils.areComponentsMatching$window_release(activity2.getComponentName(), this.secondaryActivityName);
        if (activity2.getIntent() == null) {
            return z11;
        }
        if (z11) {
            Intent intent = activity2.getIntent();
            l0.o(intent, "secondaryActivity.intent");
            if (matchesActivityIntentPair(activity, intent)) {
                z10 = true;
            }
        }
        return z10;
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("SplitPairFilter{primaryActivityName=");
        sb2.append(this.primaryActivityName);
        sb2.append(", secondaryActivityName=");
        sb2.append(this.secondaryActivityName);
        sb2.append(", secondaryActivityAction=");
        return a.a(sb2, this.secondaryActivityIntentAction, f.f14860b);
    }
}
