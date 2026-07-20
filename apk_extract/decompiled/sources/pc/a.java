package pc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface a {
    boolean include() default true;

    String name() default "";

    Class objectFactory() default oc.a.class;

    Class transformer() default qc.a.class;
}
