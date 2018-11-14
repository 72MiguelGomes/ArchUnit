package com.example.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.library.Architectures;

@AnalyzeClasses(packages = "com.example.arch")
public class ArchCheck {

  @ArchTest
  public static final ArchRule layersRule = Architectures.layeredArchitecture()
      .layer("Controller").definedBy("..controller..")
      .layer("Core").definedBy("..core..")
      .layer("Repository").definedBy("..repo..")

      .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
      .whereLayer("Core").mayOnlyBeAccessedByLayers("Controller")
      .whereLayer("Repository").mayOnlyBeAccessedByLayers("Core");
}
