package o4;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class k extends l {
    private final List<b> componentsInCycle;

    public k(List<b> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.componentsInCycle = list;
    }

    public List<b> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
