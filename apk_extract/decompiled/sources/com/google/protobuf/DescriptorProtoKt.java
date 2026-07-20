package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u000f\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\nJ*\u0010\u000b\u001a\u00020\f2\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt;", "", "()V", "extensionRange", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange;", "block", "Lkotlin/Function1;", "Lcom/google/protobuf/DescriptorProtoKt$ExtensionRangeKt$Dsl;", "", "Lkotlin/ExtensionFunctionType;", "-initializeextensionRange", "reservedRange", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange;", "Lcom/google/protobuf/DescriptorProtoKt$ReservedRangeKt$Dsl;", "-initializereservedRange", "Dsl", "ExtensionRangeKt", "ReservedRangeKt", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nDescriptorProtoKt.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DescriptorProtoKt.kt\ncom/google/protobuf/DescriptorProtoKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,841:1\n1#2:842\n*E\n"})
public final class DescriptorProtoKt {
    public static final DescriptorProtoKt INSTANCE = new DescriptorProtoKt();

    @Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u001c\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0012\b\u0007\u0018\u0000 u2\u00020\u0001:\tuvwxyz{|}B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00105\u001a\u00020\u001eH\u0001J\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000207J\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020:J%\u0010<\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u00062\u0006\u0010\u0016\u001a\u00020\u001eH\u0007¢\u0006\u0002\b=J%\u0010<\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0016\u001a\u00020\u0010H\u0007¢\u0006\u0002\b>J%\u0010<\u001a\u000207*\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000\u00062\u0006\u0010\u0016\u001a\u00020/H\u0007¢\u0006\u0002\b?J%\u0010<\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0016\u001a\u00020\u0007H\u0007¢\u0006\u0002\b@J%\u0010<\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0016\u001a\u00020\fH\u0007¢\u0006\u0002\bAJ%\u0010<\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u0016\u001a\u00020\fH\u0007¢\u0006\u0002\bBJ%\u0010<\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00062\u0006\u0010\u0016\u001a\u00020\"H\u0007¢\u0006\u0002\bCJ%\u0010<\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020,0\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\bDJ+\u0010E\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001e0GH\u0007¢\u0006\u0002\bHJ+\u0010E\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00100GH\u0007¢\u0006\u0002\bIJ+\u0010E\u001a\u000207*\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020/0GH\u0007¢\u0006\u0002\bJJ+\u0010E\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00070GH\u0007¢\u0006\u0002\bKJ+\u0010E\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0GH\u0007¢\u0006\u0002\bLJ+\u0010E\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0GH\u0007¢\u0006\u0002\bMJ+\u0010E\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\"0GH\u0007¢\u0006\u0002\bNJ+\u0010E\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020,0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00170GH\u0007¢\u0006\u0002\bOJ\u001d\u0010P\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u0006H\u0007¢\u0006\u0002\bQJ\u001d\u0010P\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0006H\u0007¢\u0006\u0002\bRJ\u001d\u0010P\u001a\u000207*\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000\u0006H\u0007¢\u0006\u0002\bSJ\u001d\u0010P\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\bTJ\u001d\u0010P\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u0006H\u0007¢\u0006\u0002\bUJ\u001d\u0010P\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0006H\u0007¢\u0006\u0002\bVJ\u001d\u0010P\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u0006H\u0007¢\u0006\u0002\bWJ\u001d\u0010P\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020,0\u0006H\u0007¢\u0006\u0002\bXJ&\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u00062\u0006\u0010\u0016\u001a\u00020\u001eH\u0087\n¢\u0006\u0002\bZJ,\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001e0GH\u0087\n¢\u0006\u0002\b[J&\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010\u0016\u001a\u00020\u0010H\u0087\n¢\u0006\u0002\b\\J,\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00100GH\u0087\n¢\u0006\u0002\b]J&\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000\u00062\u0006\u0010\u0016\u001a\u00020/H\u0087\n¢\u0006\u0002\b^J,\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020/0GH\u0087\n¢\u0006\u0002\b_J&\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u0016\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b`J,\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00070GH\u0087\n¢\u0006\u0002\baJ&\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u0016\u001a\u00020\fH\u0087\n¢\u0006\u0002\bbJ,\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0GH\u0087\n¢\u0006\u0002\bcJ&\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u0016\u001a\u00020\fH\u0087\n¢\u0006\u0002\bdJ,\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\f0GH\u0087\n¢\u0006\u0002\beJ&\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00062\u0006\u0010\u0016\u001a\u00020\"H\u0087\n¢\u0006\u0002\bfJ,\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\"0GH\u0087\n¢\u0006\u0002\bgJ&\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020,0\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0087\n¢\u0006\u0002\bhJ,\u0010Y\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020,0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00170GH\u0087\n¢\u0006\u0002\biJ.\u0010j\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u00062\u0006\u0010k\u001a\u00020l2\u0006\u0010\u0016\u001a\u00020\u001eH\u0087\u0002¢\u0006\u0002\bmJ.\u0010j\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00062\u0006\u0010k\u001a\u00020l2\u0006\u0010\u0016\u001a\u00020\u0010H\u0087\u0002¢\u0006\u0002\bnJ.\u0010j\u001a\u000207*\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000\u00062\u0006\u0010k\u001a\u00020l2\u0006\u0010\u0016\u001a\u00020/H\u0087\u0002¢\u0006\u0002\boJ.\u0010j\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010k\u001a\u00020l2\u0006\u0010\u0016\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0002\bpJ.\u0010j\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010k\u001a\u00020l2\u0006\u0010\u0016\u001a\u00020\fH\u0087\u0002¢\u0006\u0002\bqJ.\u0010j\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010k\u001a\u00020l2\u0006\u0010\u0016\u001a\u00020\fH\u0087\u0002¢\u0006\u0002\brJ.\u0010j\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00062\u0006\u0010k\u001a\u00020l2\u0006\u0010\u0016\u001a\u00020\"H\u0087\u0002¢\u0006\u0002\bsJ.\u0010j\u001a\u000207*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020,0\u00062\u0006\u0010k\u001a\u00020l2\u0006\u0010\u0016\u001a\u00020\u0017H\u0087\u0002¢\u0006\u0002\btR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u00068F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\nR$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u00068F¢\u0006\u0006\u001a\u0004\b \u0010\nR\u001d\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0\u00068F¢\u0006\u0006\u001a\u0004\b$\u0010\nR$\u0010&\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020%8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001d\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020,0\u00068F¢\u0006\u0006\u001a\u0004\b-\u0010\nR\u001d\u0010.\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000\u00068F¢\u0006\u0006\u001a\u0004\b1\u0010\nR\u0017\u00102\u001a\u0004\u0018\u00010%*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b3\u00104¨\u0006~"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$Builder;", "(Lcom/google/protobuf/DescriptorProtos$DescriptorProto$Builder;)V", "enumType", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto;", "Lcom/google/protobuf/DescriptorProtoKt$Dsl$EnumTypeProxy;", "getEnumType", "()Lcom/google/protobuf/kotlin/DslList;", "extension", "Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto;", "Lcom/google/protobuf/DescriptorProtoKt$Dsl$ExtensionProxy;", "getExtension", "extensionRange", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange;", "Lcom/google/protobuf/DescriptorProtoKt$Dsl$ExtensionRangeProxy;", "getExtensionRange", "field", "Lcom/google/protobuf/DescriptorProtoKt$Dsl$FieldProxy;", "getField", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "nestedType", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto;", "Lcom/google/protobuf/DescriptorProtoKt$Dsl$NestedTypeProxy;", "getNestedType", "oneofDecl", "Lcom/google/protobuf/DescriptorProtos$OneofDescriptorProto;", "Lcom/google/protobuf/DescriptorProtoKt$Dsl$OneofDeclProxy;", "getOneofDecl", "Lcom/google/protobuf/DescriptorProtos$MessageOptions;", "options", "getOptions", "()Lcom/google/protobuf/DescriptorProtos$MessageOptions;", "setOptions", "(Lcom/google/protobuf/DescriptorProtos$MessageOptions;)V", "reservedName", "Lcom/google/protobuf/DescriptorProtoKt$Dsl$ReservedNameProxy;", "getReservedName", "reservedRange", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange;", "Lcom/google/protobuf/DescriptorProtoKt$Dsl$ReservedRangeProxy;", "getReservedRange", "optionsOrNull", "getOptionsOrNull", "(Lcom/google/protobuf/DescriptorProtoKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$MessageOptions;", "_build", "clearName", "", "clearOptions", "hasName", "", "hasOptions", "add", "addNestedType", "addExtensionRange", "addReservedRange", "addEnumType", "addExtension", "addField", "addOneofDecl", "addReservedName", "addAll", "values", "", "addAllNestedType", "addAllExtensionRange", "addAllReservedRange", "addAllEnumType", "addAllExtension", "addAllField", "addAllOneofDecl", "addAllReservedName", "clear", "clearNestedType", "clearExtensionRange", "clearReservedRange", "clearEnumType", "clearExtension", "clearField", "clearOneofDecl", "clearReservedName", "plusAssign", "plusAssignNestedType", "plusAssignAllNestedType", "plusAssignExtensionRange", "plusAssignAllExtensionRange", "plusAssignReservedRange", "plusAssignAllReservedRange", "plusAssignEnumType", "plusAssignAllEnumType", "plusAssignExtension", "plusAssignAllExtension", "plusAssignField", "plusAssignAllField", "plusAssignOneofDecl", "plusAssignAllOneofDecl", "plusAssignReservedName", "plusAssignAllReservedName", "set", "index", "", "setNestedType", "setExtensionRange", "setReservedRange", "setEnumType", "setExtension", "setField", "setOneofDecl", "setReservedName", "Companion", "EnumTypeProxy", "ExtensionProxy", "ExtensionRangeProxy", "FieldProxy", "NestedTypeProxy", "OneofDeclProxy", "ReservedNameProxy", "ReservedRangeProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.DescriptorProto.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/DescriptorProtoKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(DescriptorProtos.DescriptorProto.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$Dsl$EnumTypeProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class EnumTypeProxy extends DslProxy {
            private EnumTypeProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$Dsl$ExtensionProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class ExtensionProxy extends DslProxy {
            private ExtensionProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$Dsl$ExtensionRangeProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class ExtensionRangeProxy extends DslProxy {
            private ExtensionRangeProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$Dsl$FieldProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class FieldProxy extends DslProxy {
            private FieldProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$Dsl$NestedTypeProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class NestedTypeProxy extends DslProxy {
            private NestedTypeProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$Dsl$OneofDeclProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class OneofDeclProxy extends DslProxy {
            private OneofDeclProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$Dsl$ReservedNameProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class ReservedNameProxy extends DslProxy {
            private ReservedNameProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$Dsl$ReservedRangeProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class ReservedRangeProxy extends DslProxy {
            private ReservedRangeProxy() {
            }
        }

        public /* synthetic */ Dsl(DescriptorProtos.DescriptorProto.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ DescriptorProtos.DescriptorProto _build() {
            DescriptorProtos.DescriptorProto descriptorProtoBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(descriptorProtoBuild, "_builder.build()");
            return descriptorProtoBuild;
        }

        @JvmName(name = "addAllEnumType")
        public final /* synthetic */ void addAllEnumType(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllEnumType(values);
        }

        @JvmName(name = "addAllExtension")
        public final /* synthetic */ void addAllExtension(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllExtension(values);
        }

        @JvmName(name = "addAllExtensionRange")
        public final /* synthetic */ void addAllExtensionRange(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllExtensionRange(values);
        }

        @JvmName(name = "addAllField")
        public final /* synthetic */ void addAllField(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllField(values);
        }

        @JvmName(name = "addAllNestedType")
        public final /* synthetic */ void addAllNestedType(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllNestedType(values);
        }

        @JvmName(name = "addAllOneofDecl")
        public final /* synthetic */ void addAllOneofDecl(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllOneofDecl(values);
        }

        @JvmName(name = "addAllReservedName")
        public final /* synthetic */ void addAllReservedName(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllReservedName(values);
        }

        @JvmName(name = "addAllReservedRange")
        public final /* synthetic */ void addAllReservedRange(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllReservedRange(values);
        }

        @JvmName(name = "addEnumType")
        public final /* synthetic */ void addEnumType(DslList dslList, DescriptorProtos.EnumDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addEnumType(value);
        }

        @JvmName(name = "addExtension")
        public final /* synthetic */ void addExtension(DslList dslList, DescriptorProtos.FieldDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addExtension(value);
        }

        @JvmName(name = "addExtensionRange")
        public final /* synthetic */ void addExtensionRange(DslList dslList, DescriptorProtos.DescriptorProto.ExtensionRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addExtensionRange(value);
        }

        @JvmName(name = "addField")
        public final /* synthetic */ void addField(DslList dslList, DescriptorProtos.FieldDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addField(value);
        }

        @JvmName(name = "addNestedType")
        public final /* synthetic */ void addNestedType(DslList dslList, DescriptorProtos.DescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addNestedType(value);
        }

        @JvmName(name = "addOneofDecl")
        public final /* synthetic */ void addOneofDecl(DslList dslList, DescriptorProtos.OneofDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addOneofDecl(value);
        }

        @JvmName(name = "addReservedName")
        public final /* synthetic */ void addReservedName(DslList dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addReservedName(value);
        }

        @JvmName(name = "addReservedRange")
        public final /* synthetic */ void addReservedRange(DslList dslList, DescriptorProtos.DescriptorProto.ReservedRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addReservedRange(value);
        }

        @JvmName(name = "clearEnumType")
        public final /* synthetic */ void clearEnumType(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearEnumType();
        }

        @JvmName(name = "clearExtension")
        public final /* synthetic */ void clearExtension(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearExtension();
        }

        @JvmName(name = "clearExtensionRange")
        public final /* synthetic */ void clearExtensionRange(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearExtensionRange();
        }

        @JvmName(name = "clearField")
        public final /* synthetic */ void clearField(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearField();
        }

        public final void clearName() {
            this._builder.clearName();
        }

        @JvmName(name = "clearNestedType")
        public final /* synthetic */ void clearNestedType(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearNestedType();
        }

        @JvmName(name = "clearOneofDecl")
        public final /* synthetic */ void clearOneofDecl(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearOneofDecl();
        }

        public final void clearOptions() {
            this._builder.clearOptions();
        }

        @JvmName(name = "clearReservedName")
        public final /* synthetic */ void clearReservedName(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearReservedName();
        }

        @JvmName(name = "clearReservedRange")
        public final /* synthetic */ void clearReservedRange(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearReservedRange();
        }

        public final /* synthetic */ DslList getEnumType() {
            List<DescriptorProtos.EnumDescriptorProto> enumTypeList = this._builder.getEnumTypeList();
            Intrinsics.checkNotNullExpressionValue(enumTypeList, "_builder.getEnumTypeList()");
            return new DslList(enumTypeList);
        }

        public final /* synthetic */ DslList getExtension() {
            List<DescriptorProtos.FieldDescriptorProto> extensionList = this._builder.getExtensionList();
            Intrinsics.checkNotNullExpressionValue(extensionList, "_builder.getExtensionList()");
            return new DslList(extensionList);
        }

        public final /* synthetic */ DslList getExtensionRange() {
            List<DescriptorProtos.DescriptorProto.ExtensionRange> extensionRangeList = this._builder.getExtensionRangeList();
            Intrinsics.checkNotNullExpressionValue(extensionRangeList, "_builder.getExtensionRangeList()");
            return new DslList(extensionRangeList);
        }

        public final /* synthetic */ DslList getField() {
            List<DescriptorProtos.FieldDescriptorProto> fieldList = this._builder.getFieldList();
            Intrinsics.checkNotNullExpressionValue(fieldList, "_builder.getFieldList()");
            return new DslList(fieldList);
        }

        @JvmName(name = "getName")
        public final String getName() {
            String name = this._builder.getName();
            Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
            return name;
        }

        public final /* synthetic */ DslList getNestedType() {
            List<DescriptorProtos.DescriptorProto> nestedTypeList = this._builder.getNestedTypeList();
            Intrinsics.checkNotNullExpressionValue(nestedTypeList, "_builder.getNestedTypeList()");
            return new DslList(nestedTypeList);
        }

        public final /* synthetic */ DslList getOneofDecl() {
            List<DescriptorProtos.OneofDescriptorProto> oneofDeclList = this._builder.getOneofDeclList();
            Intrinsics.checkNotNullExpressionValue(oneofDeclList, "_builder.getOneofDeclList()");
            return new DslList(oneofDeclList);
        }

        @JvmName(name = "getOptions")
        public final DescriptorProtos.MessageOptions getOptions() {
            DescriptorProtos.MessageOptions options = this._builder.getOptions();
            Intrinsics.checkNotNullExpressionValue(options, "_builder.getOptions()");
            return options;
        }

        public final DescriptorProtos.MessageOptions getOptionsOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return DescriptorProtoKtKt.getOptionsOrNull(dsl._builder);
        }

        public final /* synthetic */ DslList getReservedName() {
            ProtocolStringList reservedNameList = this._builder.getReservedNameList();
            Intrinsics.checkNotNullExpressionValue(reservedNameList, "_builder.getReservedNameList()");
            return new DslList(reservedNameList);
        }

        public final /* synthetic */ DslList getReservedRange() {
            List<DescriptorProtos.DescriptorProto.ReservedRange> reservedRangeList = this._builder.getReservedRangeList();
            Intrinsics.checkNotNullExpressionValue(reservedRangeList, "_builder.getReservedRangeList()");
            return new DslList(reservedRangeList);
        }

        public final boolean hasName() {
            return this._builder.hasName();
        }

        public final boolean hasOptions() {
            return this._builder.hasOptions();
        }

        @JvmName(name = "plusAssignAllEnumType")
        public final /* synthetic */ void plusAssignAllEnumType(DslList<DescriptorProtos.EnumDescriptorProto, EnumTypeProxy> dslList, Iterable<DescriptorProtos.EnumDescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllEnumType(dslList, values);
        }

        @JvmName(name = "plusAssignAllExtension")
        public final /* synthetic */ void plusAssignAllExtension(DslList<DescriptorProtos.FieldDescriptorProto, ExtensionProxy> dslList, Iterable<DescriptorProtos.FieldDescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllExtension(dslList, values);
        }

        @JvmName(name = "plusAssignAllExtensionRange")
        public final /* synthetic */ void plusAssignAllExtensionRange(DslList<DescriptorProtos.DescriptorProto.ExtensionRange, ExtensionRangeProxy> dslList, Iterable<DescriptorProtos.DescriptorProto.ExtensionRange> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllExtensionRange(dslList, values);
        }

        @JvmName(name = "plusAssignAllField")
        public final /* synthetic */ void plusAssignAllField(DslList<DescriptorProtos.FieldDescriptorProto, FieldProxy> dslList, Iterable<DescriptorProtos.FieldDescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllField(dslList, values);
        }

        @JvmName(name = "plusAssignAllNestedType")
        public final /* synthetic */ void plusAssignAllNestedType(DslList<DescriptorProtos.DescriptorProto, NestedTypeProxy> dslList, Iterable<DescriptorProtos.DescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllNestedType(dslList, values);
        }

        @JvmName(name = "plusAssignAllOneofDecl")
        public final /* synthetic */ void plusAssignAllOneofDecl(DslList<DescriptorProtos.OneofDescriptorProto, OneofDeclProxy> dslList, Iterable<DescriptorProtos.OneofDescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllOneofDecl(dslList, values);
        }

        @JvmName(name = "plusAssignAllReservedName")
        public final /* synthetic */ void plusAssignAllReservedName(DslList<String, ReservedNameProxy> dslList, Iterable<String> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllReservedName(dslList, values);
        }

        @JvmName(name = "plusAssignAllReservedRange")
        public final /* synthetic */ void plusAssignAllReservedRange(DslList<DescriptorProtos.DescriptorProto.ReservedRange, ReservedRangeProxy> dslList, Iterable<DescriptorProtos.DescriptorProto.ReservedRange> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllReservedRange(dslList, values);
        }

        @JvmName(name = "plusAssignEnumType")
        public final /* synthetic */ void plusAssignEnumType(DslList<DescriptorProtos.EnumDescriptorProto, EnumTypeProxy> dslList, DescriptorProtos.EnumDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addEnumType(dslList, value);
        }

        @JvmName(name = "plusAssignExtension")
        public final /* synthetic */ void plusAssignExtension(DslList<DescriptorProtos.FieldDescriptorProto, ExtensionProxy> dslList, DescriptorProtos.FieldDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addExtension(dslList, value);
        }

        @JvmName(name = "plusAssignExtensionRange")
        public final /* synthetic */ void plusAssignExtensionRange(DslList<DescriptorProtos.DescriptorProto.ExtensionRange, ExtensionRangeProxy> dslList, DescriptorProtos.DescriptorProto.ExtensionRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addExtensionRange(dslList, value);
        }

        @JvmName(name = "plusAssignField")
        public final /* synthetic */ void plusAssignField(DslList<DescriptorProtos.FieldDescriptorProto, FieldProxy> dslList, DescriptorProtos.FieldDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addField(dslList, value);
        }

        @JvmName(name = "plusAssignNestedType")
        public final /* synthetic */ void plusAssignNestedType(DslList<DescriptorProtos.DescriptorProto, NestedTypeProxy> dslList, DescriptorProtos.DescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addNestedType(dslList, value);
        }

        @JvmName(name = "plusAssignOneofDecl")
        public final /* synthetic */ void plusAssignOneofDecl(DslList<DescriptorProtos.OneofDescriptorProto, OneofDeclProxy> dslList, DescriptorProtos.OneofDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addOneofDecl(dslList, value);
        }

        @JvmName(name = "plusAssignReservedName")
        public final /* synthetic */ void plusAssignReservedName(DslList<String, ReservedNameProxy> dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addReservedName(dslList, value);
        }

        @JvmName(name = "plusAssignReservedRange")
        public final /* synthetic */ void plusAssignReservedRange(DslList<DescriptorProtos.DescriptorProto.ReservedRange, ReservedRangeProxy> dslList, DescriptorProtos.DescriptorProto.ReservedRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addReservedRange(dslList, value);
        }

        @JvmName(name = "setEnumType")
        public final /* synthetic */ void setEnumType(DslList dslList, int i8, DescriptorProtos.EnumDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEnumType(i8, value);
        }

        @JvmName(name = "setExtension")
        public final /* synthetic */ void setExtension(DslList dslList, int i8, DescriptorProtos.FieldDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtension(i8, value);
        }

        @JvmName(name = "setExtensionRange")
        public final /* synthetic */ void setExtensionRange(DslList dslList, int i8, DescriptorProtos.DescriptorProto.ExtensionRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setExtensionRange(i8, value);
        }

        @JvmName(name = "setField")
        public final /* synthetic */ void setField(DslList dslList, int i8, DescriptorProtos.FieldDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setField(i8, value);
        }

        @JvmName(name = "setName")
        public final void setName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setName(value);
        }

        @JvmName(name = "setNestedType")
        public final /* synthetic */ void setNestedType(DslList dslList, int i8, DescriptorProtos.DescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setNestedType(i8, value);
        }

        @JvmName(name = "setOneofDecl")
        public final /* synthetic */ void setOneofDecl(DslList dslList, int i8, DescriptorProtos.OneofDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOneofDecl(i8, value);
        }

        @JvmName(name = "setOptions")
        public final void setOptions(DescriptorProtos.MessageOptions value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOptions(value);
        }

        @JvmName(name = "setReservedName")
        public final /* synthetic */ void setReservedName(DslList dslList, int i8, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setReservedName(i8, value);
        }

        @JvmName(name = "setReservedRange")
        public final /* synthetic */ void setReservedRange(DslList dslList, int i8, DescriptorProtos.DescriptorProto.ReservedRange value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setReservedRange(i8, value);
        }

        private Dsl(DescriptorProtos.DescriptorProto.Builder builder) {
            this._builder = builder;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$ExtensionRangeKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class ExtensionRangeKt {
        public static final ExtensionRangeKt INSTANCE = new ExtensionRangeKt();

        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0019H\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010!\u001a\u00020\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0015\u001a\u0004\u0018\u00010\f*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$ExtensionRangeKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange$Builder;", "(Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange$Builder;)V", "value", "", "end", "getEnd", "()I", "setEnd", "(I)V", "Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;", "options", "getOptions", "()Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;", "setOptions", "(Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;)V", "start", "getStart", "setStart", "optionsOrNull", "getOptionsOrNull", "(Lcom/google/protobuf/DescriptorProtoKt$ExtensionRangeKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$ExtensionRangeOptions;", "_build", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange;", "clearEnd", "", "clearOptions", "clearStart", "hasEnd", "", "hasOptions", "hasStart", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @ProtoDslMarker
        public static final class Dsl {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.DescriptorProto.ExtensionRange.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$ExtensionRangeKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/DescriptorProtoKt$ExtensionRangeKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ExtensionRange$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(DescriptorProtos.DescriptorProto.ExtensionRange.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                private Companion() {
                }
            }

            public /* synthetic */ Dsl(DescriptorProtos.DescriptorProto.ExtensionRange.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            @PublishedApi
            public final /* synthetic */ DescriptorProtos.DescriptorProto.ExtensionRange _build() {
                DescriptorProtos.DescriptorProto.ExtensionRange extensionRangeBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(extensionRangeBuild, "_builder.build()");
                return extensionRangeBuild;
            }

            public final void clearEnd() {
                this._builder.clearEnd();
            }

            public final void clearOptions() {
                this._builder.clearOptions();
            }

            public final void clearStart() {
                this._builder.clearStart();
            }

            @JvmName(name = "getEnd")
            public final int getEnd() {
                return this._builder.getEnd();
            }

            @JvmName(name = "getOptions")
            public final DescriptorProtos.ExtensionRangeOptions getOptions() {
                DescriptorProtos.ExtensionRangeOptions options = this._builder.getOptions();
                Intrinsics.checkNotNullExpressionValue(options, "_builder.getOptions()");
                return options;
            }

            public final DescriptorProtos.ExtensionRangeOptions getOptionsOrNull(Dsl dsl) {
                Intrinsics.checkNotNullParameter(dsl, "<this>");
                return DescriptorProtoKtKt.getOptionsOrNull(dsl._builder);
            }

            @JvmName(name = "getStart")
            public final int getStart() {
                return this._builder.getStart();
            }

            public final boolean hasEnd() {
                return this._builder.hasEnd();
            }

            public final boolean hasOptions() {
                return this._builder.hasOptions();
            }

            public final boolean hasStart() {
                return this._builder.hasStart();
            }

            @JvmName(name = "setEnd")
            public final void setEnd(int i8) {
                this._builder.setEnd(i8);
            }

            @JvmName(name = "setOptions")
            public final void setOptions(DescriptorProtos.ExtensionRangeOptions value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this._builder.setOptions(value);
            }

            @JvmName(name = "setStart")
            public final void setStart(int i8) {
                this._builder.setStart(i8);
            }

            private Dsl(DescriptorProtos.DescriptorProto.ExtensionRange.Builder builder) {
                this._builder = builder;
            }
        }

        private ExtensionRangeKt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$ReservedRangeKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    public static final class ReservedRangeKt {
        public static final ReservedRangeKt INSTANCE = new ReservedRangeKt();

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$ReservedRangeKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange$Builder;", "(Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange$Builder;)V", "value", "", "end", "getEnd", "()I", "setEnd", "(I)V", "start", "getStart", "setStart", "_build", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange;", "clearEnd", "", "clearStart", "hasEnd", "", "hasStart", "Companion", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        @ProtoDslMarker
        public static final class Dsl {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final DescriptorProtos.DescriptorProto.ReservedRange.Builder _builder;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/DescriptorProtoKt$ReservedRangeKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/DescriptorProtoKt$ReservedRangeKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto$ReservedRange$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                @PublishedApi
                public final /* synthetic */ Dsl _create(DescriptorProtos.DescriptorProto.ReservedRange.Builder builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    return new Dsl(builder, null);
                }

                private Companion() {
                }
            }

            public /* synthetic */ Dsl(DescriptorProtos.DescriptorProto.ReservedRange.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
                this(builder);
            }

            @PublishedApi
            public final /* synthetic */ DescriptorProtos.DescriptorProto.ReservedRange _build() {
                DescriptorProtos.DescriptorProto.ReservedRange reservedRangeBuild = this._builder.build();
                Intrinsics.checkNotNullExpressionValue(reservedRangeBuild, "_builder.build()");
                return reservedRangeBuild;
            }

            public final void clearEnd() {
                this._builder.clearEnd();
            }

            public final void clearStart() {
                this._builder.clearStart();
            }

            @JvmName(name = "getEnd")
            public final int getEnd() {
                return this._builder.getEnd();
            }

            @JvmName(name = "getStart")
            public final int getStart() {
                return this._builder.getStart();
            }

            public final boolean hasEnd() {
                return this._builder.hasEnd();
            }

            public final boolean hasStart() {
                return this._builder.hasStart();
            }

            @JvmName(name = "setEnd")
            public final void setEnd(int i8) {
                this._builder.setEnd(i8);
            }

            @JvmName(name = "setStart")
            public final void setStart(int i8) {
                this._builder.setStart(i8);
            }

            private Dsl(DescriptorProtos.DescriptorProto.ReservedRange.Builder builder) {
                this._builder = builder;
            }
        }

        private ReservedRangeKt() {
        }
    }

    private DescriptorProtoKt() {
    }

    @JvmName(name = "-initializeextensionRange")
    /* JADX INFO: renamed from: -initializeextensionRange, reason: not valid java name */
    public final DescriptorProtos.DescriptorProto.ExtensionRange m61initializeextensionRange(Function1<? super ExtensionRangeKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ExtensionRangeKt.Dsl.Companion companion = ExtensionRangeKt.Dsl.INSTANCE;
        DescriptorProtos.DescriptorProto.ExtensionRange.Builder builderNewBuilder = DescriptorProtos.DescriptorProto.ExtensionRange.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ExtensionRangeKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @JvmName(name = "-initializereservedRange")
    /* JADX INFO: renamed from: -initializereservedRange, reason: not valid java name */
    public final DescriptorProtos.DescriptorProto.ReservedRange m62initializereservedRange(Function1<? super ReservedRangeKt.Dsl, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ReservedRangeKt.Dsl.Companion companion = ReservedRangeKt.Dsl.INSTANCE;
        DescriptorProtos.DescriptorProto.ReservedRange.Builder builderNewBuilder = DescriptorProtos.DescriptorProto.ReservedRange.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ReservedRangeKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
