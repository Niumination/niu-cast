package ic;

import com.transsion.hubsdk.app.TranFollowDisplayOrientationManager;

/* JADX INFO: loaded from: classes2.dex */
public class j1 implements bf.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranFollowDisplayOrientationManager f7819a = new TranFollowDisplayOrientationManager();

    @Override // bf.k
    public Object a(String str, int i10) {
        return this.f7819a.setFollowDisplayOrientationType(str, i10);
    }

    @Override // bf.k
    public Object b(String str, boolean z10) {
        return this.f7819a.setEnabledPackage(str, z10);
    }

    @Override // bf.k
    public int c(String str) {
        return this.f7819a.getFollowDisplayOrientionType(str);
    }

    @Override // bf.k
    public void d() {
        this.f7819a.commit();
    }

    @Override // bf.k
    public void e() {
        this.f7819a.init();
    }

    @Override // bf.k
    public boolean f(String str) {
        return this.f7819a.isEnabledPackage(str);
    }
}
