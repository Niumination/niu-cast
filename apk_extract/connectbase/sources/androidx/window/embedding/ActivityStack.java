package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import kn.l0;
import kn.w;
import os.l;
import os.m;
import rs.f;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
public final class ActivityStack {

    @l
    private final List<Activity> activities;
    private final boolean isEmpty;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityStack(@l List<? extends Activity> list, boolean z10) {
        l0.p(list, "activities");
        this.activities = list;
        this.isEmpty = z10;
    }

    public final boolean contains(@l Activity activity) {
        l0.p(activity, "activity");
        return this.activities.contains(activity);
    }

    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityStack)) {
            return false;
        }
        ActivityStack activityStack = (ActivityStack) obj;
        return (l0.g(this.activities, activityStack.activities) || this.isEmpty == activityStack.isEmpty) ? false : true;
    }

    @l
    public final List<Activity> getActivities$window_release() {
        return this.activities;
    }

    public int hashCode() {
        return this.activities.hashCode() + ((this.isEmpty ? 1 : 0) * 31);
    }

    public final boolean isEmpty() {
        return this.isEmpty;
    }

    @l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("ActivityStack{");
        sb2.append("activities=" + this.activities);
        sb2.append("isEmpty=" + this.isEmpty + f.f14860b);
        String string = sb2.toString();
        l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public /* synthetic */ ActivityStack(List list, boolean z10, int i10, w wVar) {
        this(list, (i10 & 2) != 0 ? false : z10);
    }
}
