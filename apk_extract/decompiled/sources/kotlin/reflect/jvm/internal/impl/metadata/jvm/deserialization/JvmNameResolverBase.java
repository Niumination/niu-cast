package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import h0.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nJvmNameResolverBase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JvmNameResolverBase.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolverBase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,106:1\n1216#2,2:107\n1246#2,4:109\n*S KotlinDebug\n*F\n+ 1 JvmNameResolverBase.kt\norg/jetbrains/kotlin/metadata/jvm/deserialization/JvmNameResolverBase\n*L\n101#1:107,2\n101#1:109,4\n*E\n"})
public class JvmNameResolverBase implements NameResolver {
    public static final Companion Companion = new Companion(null);
    private static final List<String> PREDEFINED_STRINGS;
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;

    /* JADX INFO: renamed from: kotlin, reason: collision with root package name */
    private static final String f7043kotlin;
    private final Set<Integer> localNameIndices;
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    private final String[] strings;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        String strJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        f7043kotlin = strJoinToString$default;
        List<String> listListOf = CollectionsKt.listOf((Object[]) new String[]{a.B(strJoinToString$default, "/Any"), a.B(strJoinToString$default, "/Nothing"), a.B(strJoinToString$default, "/Unit"), a.B(strJoinToString$default, "/Throwable"), a.B(strJoinToString$default, "/Number"), a.B(strJoinToString$default, "/Byte"), a.B(strJoinToString$default, "/Double"), a.B(strJoinToString$default, "/Float"), a.B(strJoinToString$default, "/Int"), a.B(strJoinToString$default, "/Long"), a.B(strJoinToString$default, "/Short"), a.B(strJoinToString$default, "/Boolean"), a.B(strJoinToString$default, "/Char"), a.B(strJoinToString$default, "/CharSequence"), a.B(strJoinToString$default, "/String"), a.B(strJoinToString$default, "/Comparable"), a.B(strJoinToString$default, "/Enum"), a.B(strJoinToString$default, "/Array"), a.B(strJoinToString$default, "/ByteArray"), a.B(strJoinToString$default, "/DoubleArray"), a.B(strJoinToString$default, "/FloatArray"), a.B(strJoinToString$default, "/IntArray"), a.B(strJoinToString$default, "/LongArray"), a.B(strJoinToString$default, "/ShortArray"), a.B(strJoinToString$default, "/BooleanArray"), a.B(strJoinToString$default, "/CharArray"), a.B(strJoinToString$default, "/Cloneable"), a.B(strJoinToString$default, "/Annotation"), a.B(strJoinToString$default, "/collections/Iterable"), a.B(strJoinToString$default, "/collections/MutableIterable"), a.B(strJoinToString$default, "/collections/Collection"), a.B(strJoinToString$default, "/collections/MutableCollection"), a.B(strJoinToString$default, "/collections/List"), a.B(strJoinToString$default, "/collections/MutableList"), a.B(strJoinToString$default, "/collections/Set"), a.B(strJoinToString$default, "/collections/MutableSet"), a.B(strJoinToString$default, "/collections/Map"), a.B(strJoinToString$default, "/collections/MutableMap"), a.B(strJoinToString$default, "/collections/Map.Entry"), a.B(strJoinToString$default, "/collections/MutableMap.MutableEntry"), a.B(strJoinToString$default, "/collections/Iterator"), a.B(strJoinToString$default, "/collections/MutableIterator"), a.B(strJoinToString$default, "/collections/ListIterator"), a.B(strJoinToString$default, "/collections/MutableListIterator")});
        PREDEFINED_STRINGS = listListOf;
        Iterable<IndexedValue> iterableWithIndex = CollectionsKt.withIndex(listListOf);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.i(iterableWithIndex)), 16));
        for (IndexedValue indexedValue : iterableWithIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }

    public JvmNameResolverBase(String[] strings, Set<Integer> localNameIndices, List<JvmProtoBuf.StringTableTypes.Record> records) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(localNameIndices, "localNameIndices");
        Intrinsics.checkNotNullParameter(records, "records");
        this.strings = strings;
        this.localNameIndices = localNameIndices;
        this.records = records;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int i8) {
        return getString(i8);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0035  */
    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int i8) {
        String strReplace$default;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(i8);
        if (record.hasString()) {
            strReplace$default = record.getString();
        } else if (record.hasPredefinedIndex()) {
            List<String> list = PREDEFINED_STRINGS;
            int size = list.size();
            int predefinedIndex = record.getPredefinedIndex();
            if (predefinedIndex < 0 || predefinedIndex >= size) {
                strReplace$default = this.strings[i8];
            } else {
                strReplace$default = list.get(record.getPredefinedIndex());
            }
        } else {
            strReplace$default = this.strings[i8];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNull(substringIndexList);
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            if (num.intValue() >= 0 && num.intValue() <= num2.intValue() && num2.intValue() <= strReplace$default.length()) {
                Intrinsics.checkNotNull(strReplace$default);
                Intrinsics.checkNotNull(num);
                int iIntValue = num.intValue();
                Intrinsics.checkNotNull(num2);
                strReplace$default = strReplace$default.substring(iIntValue, num2.intValue());
                Intrinsics.checkNotNullExpressionValue(strReplace$default, "substring(...)");
            }
        }
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNull(replaceCharList);
            Integer num3 = replaceCharList.get(0);
            Integer num4 = replaceCharList.get(1);
            Intrinsics.checkNotNull(strReplace$default);
            strReplace$default = StringsKt__StringsJVMKt.replace$default(strReplace$default, (char) num3.intValue(), (char) num4.intValue(), false, 4, (Object) null);
        }
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i9 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                Intrinsics.checkNotNull(strReplace$default);
                strReplace$default = StringsKt__StringsJVMKt.replace$default(strReplace$default, Typography.dollar, '.', false, 4, (Object) null);
            } else {
                if (i9 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                if (strReplace$default.length() >= 2) {
                    Intrinsics.checkNotNull(strReplace$default);
                    strReplace$default = strReplace$default.substring(1, strReplace$default.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(strReplace$default, "substring(...)");
                }
                Intrinsics.checkNotNull(strReplace$default);
                strReplace$default = StringsKt__StringsJVMKt.replace$default(strReplace$default, Typography.dollar, '.', false, 4, (Object) null);
            }
        }
        Intrinsics.checkNotNull(strReplace$default);
        return strReplace$default;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i8) {
        return this.localNameIndices.contains(Integer.valueOf(i8));
    }
}
