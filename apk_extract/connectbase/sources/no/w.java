package no;

import java.util.EnumMap;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final EnumMap<a, q> f11790a;

    public w(@os.l EnumMap<a, q> enumMap) {
        l0.p(enumMap, "defaultQualifiers");
        this.f11790a = enumMap;
    }

    @os.m
    public final q a(@os.m a aVar) {
        return this.f11790a.get(aVar);
    }

    @os.l
    public final EnumMap<a, q> b() {
        return this.f11790a;
    }
}
