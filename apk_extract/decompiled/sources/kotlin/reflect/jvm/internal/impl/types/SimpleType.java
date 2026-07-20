package kotlin.reflect.jvm.internal.impl.types;

import com.transsion.widgetsliquid.view.OSLiquidSearchBar;
import java.io.IOException;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.text.StringsKt__StringBuilderKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleType extends UnwrappedType implements SimpleTypeMarker, TypeArgumentListMarker {
    public SimpleType() {
        super(null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType makeNullableAsSpecified(boolean z2);

    @Override // kotlin.reflect.jvm.internal.impl.types.UnwrappedType
    public abstract SimpleType replaceAttributes(TypeAttributes typeAttributes);

    public String toString() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        Iterator<AnnotationDescriptor> it = getAnnotations().iterator();
        while (it.hasNext()) {
            StringsKt__StringBuilderKt.append(sb2, "[", DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.DEBUG_TEXT, it.next(), null, 2, null), "] ");
        }
        sb2.append(getConstructor());
        if (!getArguments().isEmpty()) {
            CollectionsKt___CollectionsKt.joinTo(getArguments(), sb2, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 2) != 0 ? ", " : ", ", (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 4) != 0 ? "" : "<", (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 8) == 0 ? ">" : "", (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 16) != 0 ? -1 : 0, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 32) != 0 ? "..." : null, (OSLiquidSearchBar.LIQUID_SEARCHBAR_EXIT_SPRING_FINAL_POSITION & 64) != 0 ? null : null);
        }
        if (isMarkedNullable()) {
            sb2.append("?");
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
