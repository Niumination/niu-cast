package sd;

import rd.i;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    int getHeaderCount();

    default i getRefreshLayout() {
        return null;
    }

    void setRefreshLayout(i iVar);
}
