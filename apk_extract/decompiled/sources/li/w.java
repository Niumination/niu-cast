package li;

import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w {
    public static final Object a(Object obj) {
        if (!(obj instanceof u)) {
            return Result.m159constructorimpl(obj);
        }
        Result.Companion companion = Result.INSTANCE;
        return Result.m159constructorimpl(ResultKt.createFailure(((u) obj).f7494a));
    }
}
