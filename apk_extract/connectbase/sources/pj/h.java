package pj;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class h implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13162c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<String> f13163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13164b;

    public h(ArrayList<String> arrayList, int i10) {
        this.f13163a = arrayList;
        this.f13164b = i10;
    }

    @Override // pj.i
    public int a() {
        return this.f13163a.size();
    }

    @Override // pj.i
    public int b() {
        return this.f13164b;
    }

    @Override // pj.i
    public String getItem(int i10) {
        if (i10 < 0 || i10 >= this.f13163a.size()) {
            return null;
        }
        return this.f13163a.get(i10);
    }
}
