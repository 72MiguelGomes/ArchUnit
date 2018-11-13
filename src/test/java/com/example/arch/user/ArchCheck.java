package com.example.arch.user;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;

@AnalyzeClasses(packages = "com.example.arch")
public class ArchCheck {

  @ArchTest
  public static final ArchRule controllerRule = ArchRuleDefinition.classes()
      .that().resideInAPackage("com.example.arch.users.controller..")
      .should().onlyHaveDependentClassesThat().resideInAnyPackage("com.example.arch.users.controller..");

  @ArchTest
  public static final ArchRule coreRule = ArchRuleDefinition.classes()
      .that().resideInAPackage("com.example.arch.users.core..")
      .should().onlyHaveDependentClassesThat().resideInAnyPackage("com.example.arch.users.controller..", "com.example.arch.users.core..");

  @ArchTest
  public static final ArchRule repoRule = ArchRuleDefinition.classes()
      .that().resideInAPackage("com.example.arch.users.repo..")
      .should().onlyHaveDependentClassesThat().resideInAnyPackage("com.example.arch.users.repo..", "com.example.arch.users.core..");

}
