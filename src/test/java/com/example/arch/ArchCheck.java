package com.example.arch;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "com.example.arch")
public class ArchCheck {

  @ArchTest
  public static final ArchRule repoRule = ArchRuleDefinition.classes()
      .that().resideInAPackage("..repo..")
      .should().onlyHaveDependentClassesThat().resideInAnyPackage("..core..", "..repo..");

  @ArchTest
  public static final ArchRule coreRule = ArchRuleDefinition.classes()
      .that().resideInAPackage("..core..")
      .should().onlyHaveDependentClassesThat().resideInAnyPackage("..core..", "..controller..");

  @ArchTest
  public static final ArchRule controllerRule = ArchRuleDefinition.classes()
      .that().resideInAPackage("..controller..")
      .should().onlyHaveDependentClassesThat().resideInAnyPackage("..controller..");

}
