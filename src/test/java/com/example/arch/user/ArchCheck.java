package com.example.arch.user;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = "com.example.arch")
public class ArchCheck {

  @ArchTest
  public static final ArchRule userLayersRule = Architectures.layeredArchitecture()
      .layer("Controller").definedBy("com.example.arch.user.controller..")
      .layer("GlobalCore").definedBy("..core..")
      .layer("Core").definedBy("com.example.arch.user.core..")
      .layer("Repository").definedBy("com.example.arch.user.repo..")

      .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
      .whereLayer("Core").mayOnlyBeAccessedByLayers("Controller", "GlobalCore")
      .whereLayer("Repository").mayOnlyBeAccessedByLayers("Core");

}
