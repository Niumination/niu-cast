package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import jq.e0;
import jq.h0;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class MatcherUtils {

    @l
    public static final MatcherUtils INSTANCE = new MatcherUtils();
    public static final boolean sDebugMatchers = false;

    @l
    public static final String sMatchersTag = "SplitRuleResolution";

    private MatcherUtils() {
    }

    private final boolean wildcardMatch(String str, String str2) {
        if (!h0.T2(str2, "*", false, 2, null)) {
            return false;
        }
        if (l0.g(str2, "*")) {
            return true;
        }
        if (h0.p3(str2, "*", 0, false, 6, null) != h0.D3(str2, "*", 0, false, 6, null) || !e0.J1(str2, "*", false, 2, null)) {
            throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end");
        }
        String strSubstring = str2.substring(0, str2.length() - 1);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return e0.s2(str, strSubstring, false, 2, null);
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(@l Activity activity, @l ComponentName componentName) {
        ComponentName component;
        l0.p(activity, "activity");
        l0.p(componentName, "ruleComponent");
        if (areComponentsMatching$window_release(activity.getComponentName(), componentName)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null || (component = intent.getComponent()) == null) {
            return false;
        }
        return INSTANCE.areComponentsMatching$window_release(component, componentName);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x005c  */
    /* JADX WARN: Code duplicated, block: B:26:0x0086  */
    public final boolean areComponentsMatching$window_release(@m ComponentName componentName, @l ComponentName componentName2) {
        boolean z10;
        boolean z11;
        l0.p(componentName2, "ruleComponent");
        if (componentName == null) {
            return l0.g(componentName2.getPackageName(), "*") && l0.g(componentName2.getClassName(), "*");
        }
        String string = componentName.toString();
        l0.o(string, "activityComponent.toString()");
        if (h0.T2(string, "*", false, 2, null)) {
            throw new IllegalArgumentException("Wildcard can only be part of the rule.");
        }
        if (l0.g(componentName.getPackageName(), componentName2.getPackageName())) {
            z10 = true;
        } else {
            String packageName = componentName.getPackageName();
            l0.o(packageName, "activityComponent.packageName");
            String packageName2 = componentName2.getPackageName();
            l0.o(packageName2, "ruleComponent.packageName");
            if (wildcardMatch(packageName, packageName2)) {
                z10 = true;
            } else {
                z10 = false;
            }
        }
        if (l0.g(componentName.getClassName(), componentName2.getClassName())) {
            z11 = true;
        } else {
            String className = componentName.getClassName();
            l0.o(className, "activityComponent.className");
            String className2 = componentName2.getClassName();
            l0.o(className2, "ruleComponent.className");
            if (wildcardMatch(className, className2)) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z10 && z11;
    }
}
