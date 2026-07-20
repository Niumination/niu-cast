package ed;

import android.content.Context;
import com.transsion.hubsdk.internal.app.TranLocaleStore;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class h implements xf.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranLocaleStore f4268a;

    @Override // xf.d
    public Set<da.g.a> a(Context context, Set<String> set, da.g.a aVar, boolean z10) {
        Set<TranLocaleStore.TranLocaleInfo> levelLocales = c().getLevelLocales(context, set, (TranLocaleStore.TranLocaleInfo) null, z10);
        HashSet hashSet = new HashSet();
        if (aVar != null) {
            for (TranLocaleStore.TranLocaleInfo tranLocaleInfo : levelLocales) {
                if (aVar.b() == tranLocaleInfo.getId()) {
                    levelLocales = c().getLevelLocales(context, set, tranLocaleInfo, z10);
                    break;
                }
            }
        }
        for (TranLocaleStore.TranLocaleInfo tranLocaleInfo2 : levelLocales) {
            hashSet.add(new da.g.a(tranLocaleInfo2.getLocale(), tranLocaleInfo2.getId(), tranLocaleInfo2.getFullNameNative()));
        }
        return hashSet;
    }

    @Override // xf.d
    public Set<da.g.a> b(Context context, Set<String> set, da.g.a aVar, boolean z10) {
        TranLocaleStore.TranLocaleInfo tranLocaleInfo;
        if (aVar != null) {
            TranLocaleStore tranLocaleStoreC = c();
            Objects.requireNonNull(tranLocaleStoreC);
            tranLocaleInfo = new TranLocaleStore.TranLocaleInfo(tranLocaleStoreC, aVar.c(), aVar.b(), aVar.a());
        } else {
            tranLocaleInfo = null;
        }
        Set<TranLocaleStore.TranLocaleInfo> levelLocalesExt = c().getLevelLocalesExt(context, set, tranLocaleInfo, z10);
        HashSet hashSet = new HashSet();
        if (aVar != null) {
            for (TranLocaleStore.TranLocaleInfo tranLocaleInfo2 : levelLocalesExt) {
                if (aVar.b() == tranLocaleInfo2.getId()) {
                    levelLocalesExt = c().getLevelLocalesExt(context, set, tranLocaleInfo2, z10);
                    break;
                }
            }
        }
        for (TranLocaleStore.TranLocaleInfo tranLocaleInfo3 : levelLocalesExt) {
            da.g.a aVar2 = new da.g.a(tranLocaleInfo3.getLocale(), tranLocaleInfo3.getId(), tranLocaleInfo3.getFullNameNative());
            aVar2.f(tranLocaleInfo3.getParent());
            hashSet.add(aVar2);
        }
        return hashSet;
    }

    public final TranLocaleStore c() {
        if (this.f4268a == null) {
            this.f4268a = new TranLocaleStore();
        }
        return this.f4268a;
    }
}
