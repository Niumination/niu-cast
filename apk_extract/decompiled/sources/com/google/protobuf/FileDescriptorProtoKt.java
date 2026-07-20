package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/google/protobuf/FileDescriptorProtoKt;", "", "()V", "Dsl", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class FileDescriptorProtoKt {
    public static final FileDescriptorProtoKt INSTANCE = new FileDescriptorProtoKt();

    @Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u001c\n\u0002\b0\b\u0007\u0018\u0000 \u0088\u00012\u00020\u0001:\u0010\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001\u008f\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010F\u001a\u00020GH\u0001J\u0006\u0010H\u001a\u00020IJ\u0006\u0010J\u001a\u00020IJ\u0006\u0010K\u001a\u00020IJ\u0006\u0010L\u001a\u00020IJ\u0006\u0010M\u001a\u00020IJ\u0006\u0010N\u001a\u00020IJ\u0006\u0010O\u001a\u00020PJ\u0006\u0010Q\u001a\u00020PJ\u0006\u0010R\u001a\u00020PJ\u0006\u0010S\u001a\u00020PJ\u0006\u0010T\u001a\u00020PJ\u0006\u0010U\u001a\u00020PJ%\u0010V\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\u000b\u001a\u00020\u001bH\u0007¢\u0006\u0002\bWJ%\u0010V\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u000b\u001a\u00020\u0013H\u0007¢\u0006\u0002\bXJ%\u0010V\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u000b\u001a\u00020\u0017H\u0007¢\u0006\u0002\bYJ%\u0010V\u001a\u00020I*\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020\u00062\u0006\u0010\u000b\u001a\u000201H\u0007¢\u0006\u0002\bZJ%\u0010V\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\u00062\u0006\u0010\u000b\u001a\u00020-H\u0007¢\u0006\u0002\b[J%\u0010V\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020>0\u00062\u0006\u0010\u000b\u001a\u00020-H\u0007¢\u0006\u0002\b\\J%\u0010V\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0007¢\u0006\u0002\b]J+\u0010^\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001b0`H\u0007¢\u0006\u0002\baJ+\u0010^\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00130`H\u0007¢\u0006\u0002\bbJ+\u0010^\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00170`H\u0007¢\u0006\u0002\bcJ+\u0010^\u001a\u00020I*\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u0002010`H\u0007¢\u0006\u0002\bdJ+\u0010^\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020-0`H\u0007¢\u0006\u0002\beJ+\u0010^\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020>0\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020-0`H\u0007¢\u0006\u0002\bfJ+\u0010^\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00070`H\u0007¢\u0006\u0002\bgJ\u001d\u0010h\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u0006H\u0007¢\u0006\u0002\biJ\u001d\u0010h\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0006H\u0007¢\u0006\u0002\bjJ\u001d\u0010h\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0006H\u0007¢\u0006\u0002\bkJ\u001d\u0010h\u001a\u00020I*\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020\u0006H\u0007¢\u0006\u0002\blJ\u001d\u0010h\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\u0006H\u0007¢\u0006\u0002\bmJ\u001d\u0010h\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020>0\u0006H\u0007¢\u0006\u0002\bnJ\u001d\u0010h\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0007¢\u0006\u0002\boJ&\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\u000b\u001a\u00020\u001bH\u0087\n¢\u0006\u0002\bqJ,\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001b0`H\u0087\n¢\u0006\u0002\brJ&\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u000b\u001a\u00020\u0013H\u0087\n¢\u0006\u0002\bsJ,\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00130`H\u0087\n¢\u0006\u0002\btJ&\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00062\u0006\u0010\u000b\u001a\u00020\u0017H\u0087\n¢\u0006\u0002\buJ,\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00170`H\u0087\n¢\u0006\u0002\bvJ&\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020\u00062\u0006\u0010\u000b\u001a\u000201H\u0087\n¢\u0006\u0002\bwJ,\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u0002010`H\u0087\n¢\u0006\u0002\bxJ&\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\u00062\u0006\u0010\u000b\u001a\u00020-H\u0087\n¢\u0006\u0002\byJ,\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020-0`H\u0087\n¢\u0006\u0002\bzJ&\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020>0\u00062\u0006\u0010\u000b\u001a\u00020-H\u0087\n¢\u0006\u0002\b{J,\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020>0\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020-0`H\u0087\n¢\u0006\u0002\b|J&\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\n¢\u0006\u0002\b}J,\u0010p\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00070`H\u0087\n¢\u0006\u0002\b~J0\u0010\u007f\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00062\u0007\u0010\u0080\u0001\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\u001bH\u0087\u0002¢\u0006\u0003\b\u0081\u0001J0\u0010\u007f\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00062\u0007\u0010\u0080\u0001\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\u0013H\u0087\u0002¢\u0006\u0003\b\u0082\u0001J0\u0010\u007f\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00062\u0007\u0010\u0080\u0001\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\u0017H\u0087\u0002¢\u0006\u0003\b\u0083\u0001J0\u0010\u007f\u001a\u00020I*\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020\u00062\u0007\u0010\u0080\u0001\u001a\u00020-2\u0006\u0010\u000b\u001a\u000201H\u0087\u0002¢\u0006\u0003\b\u0084\u0001J0\u0010\u007f\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\u00062\u0007\u0010\u0080\u0001\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020-H\u0087\u0002¢\u0006\u0003\b\u0085\u0001J0\u0010\u007f\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020>0\u00062\u0007\u0010\u0080\u0001\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020-H\u0087\u0002¢\u0006\u0003\b\u0086\u0001J0\u0010\u007f\u001a\u00020I*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0007\u0010\u0080\u0001\u001a\u00020-2\u0006\u0010\u000b\u001a\u00020\u0007H\u0087\u0002¢\u0006\u0003\b\u0087\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\nR\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u00068F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\nR\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\nR$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010$\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001d\u0010,\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0\u00068F¢\u0006\u0006\u001a\u0004\b/\u0010\nR\u001d\u00100\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002020\u00068F¢\u0006\u0006\u001a\u0004\b3\u0010\nR$\u00105\u001a\u0002042\u0006\u0010\u000b\u001a\u0002048G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00078G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R\u001d\u0010=\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020>0\u00068F¢\u0006\u0006\u001a\u0004\b?\u0010\nR\u0017\u0010@\u001a\u0004\u0018\u00010#*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0017\u0010C\u001a\u0004\u0018\u000104*\u00020\u00008F¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006\u0090\u0001"}, d2 = {"Lcom/google/protobuf/FileDescriptorProtoKt$Dsl;", "", "_builder", "Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto$Builder;", "(Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto$Builder;)V", "dependency", "Lcom/google/protobuf/kotlin/DslList;", "", "Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$DependencyProxy;", "getDependency", "()Lcom/google/protobuf/kotlin/DslList;", "value", "Lcom/google/protobuf/DescriptorProtos$Edition;", "edition", "getEdition", "()Lcom/google/protobuf/DescriptorProtos$Edition;", "setEdition", "(Lcom/google/protobuf/DescriptorProtos$Edition;)V", "enumType", "Lcom/google/protobuf/DescriptorProtos$EnumDescriptorProto;", "Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$EnumTypeProxy;", "getEnumType", "extension", "Lcom/google/protobuf/DescriptorProtos$FieldDescriptorProto;", "Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$ExtensionProxy;", "getExtension", "messageType", "Lcom/google/protobuf/DescriptorProtos$DescriptorProto;", "Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$MessageTypeProxy;", "getMessageType", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Lcom/google/protobuf/DescriptorProtos$FileOptions;", "options", "getOptions", "()Lcom/google/protobuf/DescriptorProtos$FileOptions;", "setOptions", "(Lcom/google/protobuf/DescriptorProtos$FileOptions;)V", "package_", "getPackage_", "setPackage_", "publicDependency", "", "Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$PublicDependencyProxy;", "getPublicDependency", "service", "Lcom/google/protobuf/DescriptorProtos$ServiceDescriptorProto;", "Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$ServiceProxy;", "getService", "Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;", "sourceCodeInfo", "getSourceCodeInfo", "()Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;", "setSourceCodeInfo", "(Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;)V", "syntax", "getSyntax", "setSyntax", "weakDependency", "Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$WeakDependencyProxy;", "getWeakDependency", "optionsOrNull", "getOptionsOrNull", "(Lcom/google/protobuf/FileDescriptorProtoKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$FileOptions;", "sourceCodeInfoOrNull", "getSourceCodeInfoOrNull", "(Lcom/google/protobuf/FileDescriptorProtoKt$Dsl;)Lcom/google/protobuf/DescriptorProtos$SourceCodeInfo;", "_build", "Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto;", "clearEdition", "", "clearName", "clearOptions", "clearPackage_", "clearSourceCodeInfo", "clearSyntax", "hasEdition", "", "hasName", "hasOptions", "hasPackage_", "hasSourceCodeInfo", "hasSyntax", "add", "addMessageType", "addEnumType", "addExtension", "addService", "addPublicDependency", "addWeakDependency", "addDependency", "addAll", "values", "", "addAllMessageType", "addAllEnumType", "addAllExtension", "addAllService", "addAllPublicDependency", "addAllWeakDependency", "addAllDependency", "clear", "clearMessageType", "clearEnumType", "clearExtension", "clearService", "clearPublicDependency", "clearWeakDependency", "clearDependency", "plusAssign", "plusAssignMessageType", "plusAssignAllMessageType", "plusAssignEnumType", "plusAssignAllEnumType", "plusAssignExtension", "plusAssignAllExtension", "plusAssignService", "plusAssignAllService", "plusAssignPublicDependency", "plusAssignAllPublicDependency", "plusAssignWeakDependency", "plusAssignAllWeakDependency", "plusAssignDependency", "plusAssignAllDependency", "set", "index", "setMessageType", "setEnumType", "setExtension", "setService", "setPublicDependency", "setWeakDependency", "setDependency", "Companion", "DependencyProxy", "EnumTypeProxy", "ExtensionProxy", "MessageTypeProxy", "PublicDependencyProxy", "ServiceProxy", "WeakDependencyProxy", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    @ProtoDslMarker
    public static final class Dsl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final DescriptorProtos.FileDescriptorProto.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$Companion;", "", "()V", "_create", "Lcom/google/protobuf/FileDescriptorProtoKt$Dsl;", "builder", "Lcom/google/protobuf/DescriptorProtos$FileDescriptorProto$Builder;", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(DescriptorProtos.FileDescriptorProto.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$DependencyProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class DependencyProxy extends DslProxy {
            private DependencyProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$EnumTypeProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class EnumTypeProxy extends DslProxy {
            private EnumTypeProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$ExtensionProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class ExtensionProxy extends DslProxy {
            private ExtensionProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$MessageTypeProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class MessageTypeProxy extends DslProxy {
            private MessageTypeProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$PublicDependencyProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class PublicDependencyProxy extends DslProxy {
            private PublicDependencyProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$ServiceProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class ServiceProxy extends DslProxy {
            private ServiceProxy() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/google/protobuf/FileDescriptorProtoKt$Dsl$WeakDependencyProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "java_kotlin-well_known_protos_kotlin"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        public static final class WeakDependencyProxy extends DslProxy {
            private WeakDependencyProxy() {
            }
        }

        public /* synthetic */ Dsl(DescriptorProtos.FileDescriptorProto.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }

        @PublishedApi
        public final /* synthetic */ DescriptorProtos.FileDescriptorProto _build() {
            DescriptorProtos.FileDescriptorProto fileDescriptorProtoBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(fileDescriptorProtoBuild, "_builder.build()");
            return fileDescriptorProtoBuild;
        }

        @JvmName(name = "addAllDependency")
        public final /* synthetic */ void addAllDependency(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllDependency(values);
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

        @JvmName(name = "addAllMessageType")
        public final /* synthetic */ void addAllMessageType(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllMessageType(values);
        }

        @JvmName(name = "addAllPublicDependency")
        public final /* synthetic */ void addAllPublicDependency(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllPublicDependency(values);
        }

        @JvmName(name = "addAllService")
        public final /* synthetic */ void addAllService(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllService(values);
        }

        @JvmName(name = "addAllWeakDependency")
        public final /* synthetic */ void addAllWeakDependency(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllWeakDependency(values);
        }

        @JvmName(name = "addDependency")
        public final /* synthetic */ void addDependency(DslList dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addDependency(value);
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

        @JvmName(name = "addMessageType")
        public final /* synthetic */ void addMessageType(DslList dslList, DescriptorProtos.DescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addMessageType(value);
        }

        @JvmName(name = "addPublicDependency")
        public final /* synthetic */ void addPublicDependency(DslList dslList, int i8) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.addPublicDependency(i8);
        }

        @JvmName(name = "addService")
        public final /* synthetic */ void addService(DslList dslList, DescriptorProtos.ServiceDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addService(value);
        }

        @JvmName(name = "addWeakDependency")
        public final /* synthetic */ void addWeakDependency(DslList dslList, int i8) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.addWeakDependency(i8);
        }

        @JvmName(name = "clearDependency")
        public final /* synthetic */ void clearDependency(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearDependency();
        }

        public final void clearEdition() {
            this._builder.clearEdition();
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

        @JvmName(name = "clearMessageType")
        public final /* synthetic */ void clearMessageType(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearMessageType();
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final void clearOptions() {
            this._builder.clearOptions();
        }

        public final void clearPackage_() {
            this._builder.clearPackage();
        }

        @JvmName(name = "clearPublicDependency")
        public final /* synthetic */ void clearPublicDependency(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearPublicDependency();
        }

        @JvmName(name = "clearService")
        public final /* synthetic */ void clearService(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearService();
        }

        public final void clearSourceCodeInfo() {
            this._builder.clearSourceCodeInfo();
        }

        public final void clearSyntax() {
            this._builder.clearSyntax();
        }

        @JvmName(name = "clearWeakDependency")
        public final /* synthetic */ void clearWeakDependency(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearWeakDependency();
        }

        public final /* synthetic */ DslList getDependency() {
            ProtocolStringList dependencyList = this._builder.getDependencyList();
            Intrinsics.checkNotNullExpressionValue(dependencyList, "_builder.getDependencyList()");
            return new DslList(dependencyList);
        }

        @JvmName(name = "getEdition")
        public final DescriptorProtos.Edition getEdition() {
            DescriptorProtos.Edition edition = this._builder.getEdition();
            Intrinsics.checkNotNullExpressionValue(edition, "_builder.getEdition()");
            return edition;
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

        public final /* synthetic */ DslList getMessageType() {
            List<DescriptorProtos.DescriptorProto> messageTypeList = this._builder.getMessageTypeList();
            Intrinsics.checkNotNullExpressionValue(messageTypeList, "_builder.getMessageTypeList()");
            return new DslList(messageTypeList);
        }

        @JvmName(name = "getName")
        public final String getName() {
            String name = this._builder.getName();
            Intrinsics.checkNotNullExpressionValue(name, "_builder.getName()");
            return name;
        }

        @JvmName(name = "getOptions")
        public final DescriptorProtos.FileOptions getOptions() {
            DescriptorProtos.FileOptions options = this._builder.getOptions();
            Intrinsics.checkNotNullExpressionValue(options, "_builder.getOptions()");
            return options;
        }

        public final DescriptorProtos.FileOptions getOptionsOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return FileDescriptorProtoKtKt.getOptionsOrNull(dsl._builder);
        }

        @JvmName(name = "getPackage_")
        public final String getPackage_() {
            String str = this._builder.getPackage();
            Intrinsics.checkNotNullExpressionValue(str, "_builder.getPackage()");
            return str;
        }

        public final /* synthetic */ DslList getPublicDependency() {
            List<Integer> publicDependencyList = this._builder.getPublicDependencyList();
            Intrinsics.checkNotNullExpressionValue(publicDependencyList, "_builder.getPublicDependencyList()");
            return new DslList(publicDependencyList);
        }

        public final /* synthetic */ DslList getService() {
            List<DescriptorProtos.ServiceDescriptorProto> serviceList = this._builder.getServiceList();
            Intrinsics.checkNotNullExpressionValue(serviceList, "_builder.getServiceList()");
            return new DslList(serviceList);
        }

        @JvmName(name = "getSourceCodeInfo")
        public final DescriptorProtos.SourceCodeInfo getSourceCodeInfo() {
            DescriptorProtos.SourceCodeInfo sourceCodeInfo = this._builder.getSourceCodeInfo();
            Intrinsics.checkNotNullExpressionValue(sourceCodeInfo, "_builder.getSourceCodeInfo()");
            return sourceCodeInfo;
        }

        public final DescriptorProtos.SourceCodeInfo getSourceCodeInfoOrNull(Dsl dsl) {
            Intrinsics.checkNotNullParameter(dsl, "<this>");
            return FileDescriptorProtoKtKt.getSourceCodeInfoOrNull(dsl._builder);
        }

        @JvmName(name = "getSyntax")
        public final String getSyntax() {
            String syntax = this._builder.getSyntax();
            Intrinsics.checkNotNullExpressionValue(syntax, "_builder.getSyntax()");
            return syntax;
        }

        public final /* synthetic */ DslList getWeakDependency() {
            List<Integer> weakDependencyList = this._builder.getWeakDependencyList();
            Intrinsics.checkNotNullExpressionValue(weakDependencyList, "_builder.getWeakDependencyList()");
            return new DslList(weakDependencyList);
        }

        public final boolean hasEdition() {
            return this._builder.hasEdition();
        }

        public final boolean hasName() {
            return this._builder.hasName();
        }

        public final boolean hasOptions() {
            return this._builder.hasOptions();
        }

        public final boolean hasPackage_() {
            return this._builder.hasPackage();
        }

        public final boolean hasSourceCodeInfo() {
            return this._builder.hasSourceCodeInfo();
        }

        public final boolean hasSyntax() {
            return this._builder.hasSyntax();
        }

        @JvmName(name = "plusAssignAllDependency")
        public final /* synthetic */ void plusAssignAllDependency(DslList<String, DependencyProxy> dslList, Iterable<String> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllDependency(dslList, values);
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

        @JvmName(name = "plusAssignAllMessageType")
        public final /* synthetic */ void plusAssignAllMessageType(DslList<DescriptorProtos.DescriptorProto, MessageTypeProxy> dslList, Iterable<DescriptorProtos.DescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllMessageType(dslList, values);
        }

        @JvmName(name = "plusAssignAllPublicDependency")
        public final /* synthetic */ void plusAssignAllPublicDependency(DslList<Integer, PublicDependencyProxy> dslList, Iterable<Integer> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllPublicDependency(dslList, values);
        }

        @JvmName(name = "plusAssignAllService")
        public final /* synthetic */ void plusAssignAllService(DslList<DescriptorProtos.ServiceDescriptorProto, ServiceProxy> dslList, Iterable<DescriptorProtos.ServiceDescriptorProto> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllService(dslList, values);
        }

        @JvmName(name = "plusAssignAllWeakDependency")
        public final /* synthetic */ void plusAssignAllWeakDependency(DslList<Integer, WeakDependencyProxy> dslList, Iterable<Integer> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllWeakDependency(dslList, values);
        }

        @JvmName(name = "plusAssignDependency")
        public final /* synthetic */ void plusAssignDependency(DslList<String, DependencyProxy> dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addDependency(dslList, value);
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

        @JvmName(name = "plusAssignMessageType")
        public final /* synthetic */ void plusAssignMessageType(DslList<DescriptorProtos.DescriptorProto, MessageTypeProxy> dslList, DescriptorProtos.DescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addMessageType(dslList, value);
        }

        @JvmName(name = "plusAssignPublicDependency")
        public final /* synthetic */ void plusAssignPublicDependency(DslList<Integer, PublicDependencyProxy> dslList, int i8) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            addPublicDependency(dslList, i8);
        }

        @JvmName(name = "plusAssignService")
        public final /* synthetic */ void plusAssignService(DslList<DescriptorProtos.ServiceDescriptorProto, ServiceProxy> dslList, DescriptorProtos.ServiceDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addService(dslList, value);
        }

        @JvmName(name = "plusAssignWeakDependency")
        public final /* synthetic */ void plusAssignWeakDependency(DslList<Integer, WeakDependencyProxy> dslList, int i8) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            addWeakDependency(dslList, i8);
        }

        @JvmName(name = "setDependency")
        public final /* synthetic */ void setDependency(DslList dslList, int i8, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setDependency(i8, value);
        }

        @JvmName(name = "setEdition")
        public final void setEdition(DescriptorProtos.Edition value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setEdition(value);
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

        @JvmName(name = "setMessageType")
        public final /* synthetic */ void setMessageType(DslList dslList, int i8, DescriptorProtos.DescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setMessageType(i8, value);
        }

        @JvmName(name = "setName")
        public final void setName(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setName(value);
        }

        @JvmName(name = "setOptions")
        public final void setOptions(DescriptorProtos.FileOptions value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setOptions(value);
        }

        @JvmName(name = "setPackage_")
        public final void setPackage_(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setPackage(value);
        }

        @JvmName(name = "setPublicDependency")
        public final /* synthetic */ void setPublicDependency(DslList dslList, int i8, int i9) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.setPublicDependency(i8, i9);
        }

        @JvmName(name = "setService")
        public final /* synthetic */ void setService(DslList dslList, int i8, DescriptorProtos.ServiceDescriptorProto value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setService(i8, value);
        }

        @JvmName(name = "setSourceCodeInfo")
        public final void setSourceCodeInfo(DescriptorProtos.SourceCodeInfo value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSourceCodeInfo(value);
        }

        @JvmName(name = "setSyntax")
        public final void setSyntax(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setSyntax(value);
        }

        @JvmName(name = "setWeakDependency")
        public final /* synthetic */ void setWeakDependency(DslList dslList, int i8, int i9) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.setWeakDependency(i8, i9);
        }

        private Dsl(DescriptorProtos.FileDescriptorProto.Builder builder) {
            this._builder = builder;
        }
    }

    private FileDescriptorProtoKt() {
    }
}
