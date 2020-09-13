package com.leysoft.optics.inmutable;

import org.immutables.value.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@Value.Style(
        visibility = Value.Style.ImplementationVisibility.PUBLIC,
        typeImmutable = "*",
        depluralize = true,
        redactedMask = "****",
        defaults = @Value.Immutable(builder = false, copy = false))
public @interface NoBuilder {}
