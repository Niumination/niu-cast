package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import j.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import k.c;

/* JADX INFO: loaded from: classes.dex */
public class TransitionValues {
    public View view;
    public final Map<String, Object> values = new HashMap();
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sbA = c.a("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        sbA.append(this.view);
        sbA.append("\n");
        String strA = a.a(sbA.toString(), "    values:");
        for (String str : this.values.keySet()) {
            strA = strA + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return strA;
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }
}
