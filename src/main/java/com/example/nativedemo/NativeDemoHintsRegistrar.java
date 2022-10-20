package com.example.nativedemo;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

public class NativeDemoHintsRegistrar implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {

        /*
          Caused by: java.lang.NoSuchMethodException: org.hibernate.id.IdentityGenerator.<init>()
            at java.lang.Class.getConstructor0(DynamicHub.java:3585) ~[native-demo:na]
            at java.lang.Class.newInstance(DynamicHub.java:626) ~[native-demo:na]
            ... 39 common frames omitted
         */
        hints.reflection().registerType(org.hibernate.id.IdentityGenerator.class,
            MemberCategory.INVOKE_DECLARED_CONSTRUCTORS);
    }
}
