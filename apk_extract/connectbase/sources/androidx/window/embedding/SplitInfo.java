package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ExperimentalWindowApi;
import io.netty.util.internal.StringUtil;
import kn.l0;
import os.l;
import os.m;
import rs.f;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class SplitInfo {

    @l
    private final ActivityStack primaryActivityStack;

    @l
    private final ActivityStack secondaryActivityStack;
    private final float splitRatio;

    public SplitInfo(@l ActivityStack activityStack, @l ActivityStack activityStack2, float f10) {
        l0.p(activityStack, "primaryActivityStack");
        l0.p(activityStack2, "secondaryActivityStack");
        this.primaryActivityStack = activityStack;
        this.secondaryActivityStack = activityStack2;
        this.splitRatio = f10;
    }

    public final boolean contains(@l Activity activity) {
        l0.p(activity, "activity");
        return this.primaryActivityStack.contains(activity) || this.secondaryActivityStack.contains(activity);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitInfo)) {
            return false;
        }
        SplitInfo splitInfo = (SplitInfo) obj;
        return l0.g(this.primaryActivityStack, splitInfo.primaryActivityStack) && l0.g(this.secondaryActivityStack, splitInfo.secondaryActivityStack) && this.splitRatio == splitInfo.splitRatio;
    }

    @l
    public final ActivityStack getPrimaryActivityStack() {
        return this.primaryActivityStack;
    }

    @l
    public final ActivityStack getSecondaryActivityStack() {
        return this.secondaryActivityStack;
    }

    public final float getSplitRatio() {
        return this.splitRatio;
    }

    public int hashCode() {
        return Float.hashCode(this.splitRatio) + ((this.secondaryActivityStack.hashCode() + (this.primaryActivityStack.hashCode() * 31)) * 31);
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("SplitInfo:{");
        sb2.append("primaryActivityStack=" + this.primaryActivityStack + StringUtil.COMMA);
        sb2.append("secondaryActivityStack=" + this.secondaryActivityStack + StringUtil.COMMA);
        sb2.append("splitRatio=" + this.splitRatio + f.f14860b);
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
