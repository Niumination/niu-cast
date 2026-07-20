package c2;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f1407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f1408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f1409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f1410d;
    public Serializable e;
    public Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f1411g;

    public k(String str, Set set, String str2) {
        o3.a aVar = o3.a.f8366a;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f1407a = setEmptySet;
        Map mapEmptyMap = Collections.emptyMap();
        this.f1410d = mapEmptyMap;
        this.f = str;
        this.e = str2;
        this.f1411g = aVar;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = mapEmptyMap.values().iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        this.f1409c = Collections.unmodifiableSet(hashSet);
    }
}
