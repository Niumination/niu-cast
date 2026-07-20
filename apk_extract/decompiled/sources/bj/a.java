package bj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f1335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f1337d;
    public final ArrayList e;

    public a(String serialName) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.f1334a = CollectionsKt.emptyList();
        this.f1335b = new ArrayList();
        new HashSet();
        this.f1336c = new ArrayList();
        this.f1337d = new ArrayList();
        this.e = new ArrayList();
    }
}
