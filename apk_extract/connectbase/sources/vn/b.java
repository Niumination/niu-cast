package vn;

import kn.l0;
import lm.f1;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
@f1(version = "1.1")
public final class b extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@l IllegalAccessException illegalAccessException) {
        super("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", illegalAccessException);
        l0.p(illegalAccessException, "cause");
    }
}
