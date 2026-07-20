package k3;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class g extends p {
    public g(Map map) {
        super(map);
    }

    @Override // k3.p
    public /* bridge */ /* synthetic */ Collection zza() {
        throw null;
    }

    @Override // k3.p
    public final /* synthetic */ Collection zzb() {
        return Collections.emptyList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k3.p
    public final Collection zzc(Collection collection) {
        return Collections.unmodifiableList(collection);
    }

    @Override // k3.p
    public final Collection zzd(Object obj, Collection collection) {
        return zzm(obj, (List) collection, null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Collection, java.util.List] */
    public final List zze(Object obj) {
        return zzj(obj);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Collection, java.util.List] */
    public final List zzf(Object obj) {
        return zzk(obj);
    }
}
