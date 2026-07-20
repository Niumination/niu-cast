package tm;

import lm.f1;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.3")
@an.b
@f
public enum g {
    AT_MOST_ONCE,
    AT_LEAST_ONCE,
    EXACTLY_ONCE,
    UNKNOWN;


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ ym.a f15889b = ym.c.c(a());

    @l
    public static ym.a<g> getEntries() {
        return f15889b;
    }
}
