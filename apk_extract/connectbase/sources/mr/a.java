package mr;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@hs.p
@hs.x(qualifier = i.class)
@Documented
@Repeatable(InterfaceC0285a.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface a {

    /* JADX INFO: renamed from: mr.a$a, reason: collision with other inner class name */
    @Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
    @hs.p
    @hs.x(qualifier = i.class)
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface InterfaceC0285a {
        a[] value();
    }

    @hs.a0(TypedValues.CycleType.S_WAVE_OFFSET)
    @hs.r
    String[] offset() default {};

    @hs.a0("value")
    @hs.r
    String[] targetValue();

    @hs.r
    String[] value();
}
