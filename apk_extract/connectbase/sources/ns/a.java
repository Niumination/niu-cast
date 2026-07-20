package ns;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f12001e = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f12002f = "this";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12003g = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12004h = "The return value of this method";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f12005i = "this";

    String source() default "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

    boolean sourceIsContainer() default false;

    String target() default "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

    boolean targetIsContainer() default false;
}
