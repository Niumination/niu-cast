package zg;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ih.a f11584b;

    public a(String name, ih.a type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.f11583a = name;
        this.f11584b = type;
        if (StringsKt.isBlank(name)) {
            throw new IllegalArgumentException("Name can't be blank");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f11583a, aVar.f11583a) && Intrinsics.areEqual(this.f11584b, aVar.f11584b);
    }

    public final int hashCode() {
        return this.f11584b.hashCode() + (this.f11583a.hashCode() * 31);
    }

    public final String toString() {
        return "AttributeKey: " + this.f11583a;
    }
}
