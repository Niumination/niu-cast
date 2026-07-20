package i4;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class y0 extends h0 {
    final /* synthetic */ h0 val$entryList;

    public y0(a1 a1Var, h0 h0Var) {
        this.val$entryList = h0Var;
    }

    @Override // java.util.List
    public Object get(int i8) {
        return ((Map.Entry) this.val$entryList.get(i8)).getValue();
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.val$entryList.size();
    }
}
