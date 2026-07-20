package qr;

import hs.f0;
import hs.i0;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@hs.e({i0.EXCEPTION_PARAMETER, i0.UPPER_BOUND})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@f0({e.class})
@hs.h
@Retention(RetentionPolicy.RUNTIME)
public @interface c {
    String[] value() default {};
}
