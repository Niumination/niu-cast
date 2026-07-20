package eh;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f4959c;

    public d(String pluginName, String handler, c event) {
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(event, "event");
        this.f4957a = pluginName;
        this.f4958b = handler;
        this.f4959c = event;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.f4957a, dVar.f4957a) && Intrinsics.areEqual(this.f4958b, dVar.f4958b) && this.f4959c == dVar.f4959c;
    }

    public final int hashCode() {
        return this.f4959c.hashCode() + a1.a.e(this.f4957a.hashCode() * 31, 31, this.f4958b);
    }

    public final String toString() {
        return "PluginTraceElement(pluginName=" + this.f4957a + ", handler=" + this.f4958b + ", event=" + this.f4959c + ')';
    }
}
