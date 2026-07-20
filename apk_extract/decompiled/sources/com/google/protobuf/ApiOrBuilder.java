package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface ApiOrBuilder extends MessageOrBuilder {
    Method getMethods(int i8);

    int getMethodsCount();

    List<Method> getMethodsList();

    MethodOrBuilder getMethodsOrBuilder(int i8);

    List<? extends MethodOrBuilder> getMethodsOrBuilderList();

    Mixin getMixins(int i8);

    int getMixinsCount();

    List<Mixin> getMixinsList();

    MixinOrBuilder getMixinsOrBuilder(int i8);

    List<? extends MixinOrBuilder> getMixinsOrBuilderList();

    String getName();

    ByteString getNameBytes();

    Option getOptions(int i8);

    int getOptionsCount();

    List<Option> getOptionsList();

    OptionOrBuilder getOptionsOrBuilder(int i8);

    List<? extends OptionOrBuilder> getOptionsOrBuilderList();

    SourceContext getSourceContext();

    SourceContextOrBuilder getSourceContextOrBuilder();

    Syntax getSyntax();

    int getSyntaxValue();

    String getVersion();

    ByteString getVersionBytes();

    boolean hasSourceContext();
}
