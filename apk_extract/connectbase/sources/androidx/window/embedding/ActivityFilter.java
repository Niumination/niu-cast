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

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class ActivityFilter {

    @l
    private final ComponentName componentName;

    @m
    private final String intentAction;

    public ActivityFilter(@l ComponentName componentName, @m String str) {
        l0.p(componentName, "componentName");
        this.componentName = componentName;
        this.intentAction = str;
        String packageName = componentName.getPackageName();
        l0.o(packageName, "componentName.packageName");
        String className = componentName.getClassName();
        l0.o(className, "componentName.className");
        if (packageName.length() <= 0) {
            throw new IllegalArgumentException("Package name must not be empty");
        }
        if (className.length() <= 0) {
            throw new IllegalArgumentException("Activity class name must not be empty.");
        }
        if (h0.T2(packageName, "*", false, 2, null) && h0.p3(packageName, "*", 0, false, 6, null) != packageName.length() - 1) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.");
        }
        if (h0.T2(className, "*", false, 2, null) && h0.p3(className, "*", 0, false, 6, null) != className.length() - 1) {
            throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
        }
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        return l0.g(this.componentName, activityFilter.componentName) && l0.g(this.intentAction, activityFilter.intentAction);
    }

    @l
    public final ComponentName getComponentName() {
        return this.componentName;
    }

    @m
    public final String getIntentAction() {
        return this.intentAction;
    }

    public int hashCode() {
        int iHashCode = this.componentName.hashCode() * 31;
        String str = this.intentAction;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final boolean matchesActivity(@l Activity activity) {
        l0.p(activity, "activity");
        if (MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(activity, this.componentName)) {
            String str = this.intentAction;
            if (str != null) {
                Intent intent = activity.getIntent();
                if (l0.g(str, intent != null ? intent.getAction() : null)) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean matchesIntent(@l Intent intent) {
        l0.p(intent, "intent");
        if (!MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.componentName)) {
            return false;
        }
        String str = this.intentAction;
        return str == null || l0.g(str, intent.getAction());
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("ActivityFilter(componentName=");
        sb2.append(this.componentName);
        sb2.append(", intentAction=");
        return a.a(sb2, this.intentAction, ')');
    }
}
