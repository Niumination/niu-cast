package pr;

import hs.f0;
import hs.h0;
import hs.i0;
import hs.k0;
import hs.r;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@hs.e(typeKinds = {h0.BOOLEAN, h0.BYTE, h0.CHAR, h0.DOUBLE, h0.FLOAT, h0.INT, h0.LONG, h0.SHORT}, types = {String.class, Void.class}, value = {i0.EXCEPTION_PARAMETER, i0.UPPER_BOUND})
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@k0(typeKinds = {h0.BOOLEAN, h0.BYTE, h0.CHAR, h0.DOUBLE, h0.FLOAT, h0.INT, h0.LONG, h0.SHORT}, types = {String.class})
@f0({f.class})
@hs.h
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface d {
    @r
    String[] value() default {};
}
