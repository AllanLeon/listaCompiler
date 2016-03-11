/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage
 * @generated
 */
public interface ListaCompilerFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ListaCompilerFactory eINSTANCE = edu.upb.compilacion.listaCompiler.impl.ListaCompilerFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Lista</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lista</em>'.
   * @generated
   */
  Lista createLista();

  /**
   * Returns a new object of class '<em>Evaluation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Evaluation</em>'.
   * @generated
   */
  Evaluation createEvaluation();

  /**
   * Returns a new object of class '<em>Function Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Definition</em>'.
   * @generated
   */
  FunctionDefinition createFunctionDefinition();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>First Level Exp</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>First Level Exp</em>'.
   * @generated
   */
  FirstLevelExp createFirstLevelExp();

  /**
   * Returns a new object of class '<em>Second Level Exp</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Second Level Exp</em>'.
   * @generated
   */
  SecondLevelExp createSecondLevelExp();

  /**
   * Returns a new object of class '<em>Third Level Exp</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Third Level Exp</em>'.
   * @generated
   */
  ThirdLevelExp createThirdLevelExp();

  /**
   * Returns a new object of class '<em>Fourth Level Exp</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fourth Level Exp</em>'.
   * @generated
   */
  FourthLevelExp createFourthLevelExp();

  /**
   * Returns a new object of class '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Term</em>'.
   * @generated
   */
  Term createTerm();

  /**
   * Returns a new object of class '<em>My Integer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Integer</em>'.
   * @generated
   */
  MyInteger createMyInteger();

  /**
   * Returns a new object of class '<em>Pos Integer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pos Integer</em>'.
   * @generated
   */
  PosInteger createPosInteger();

  /**
   * Returns a new object of class '<em>Neg Integer</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Neg Integer</em>'.
   * @generated
   */
  NegInteger createNegInteger();

  /**
   * Returns a new object of class '<em>My Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Variable</em>'.
   * @generated
   */
  MyVariable createMyVariable();

  /**
   * Returns a new object of class '<em>My Bool</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My Bool</em>'.
   * @generated
   */
  MyBool createMyBool();

  /**
   * Returns a new object of class '<em>Pos Bool</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pos Bool</em>'.
   * @generated
   */
  PosBool createPosBool();

  /**
   * Returns a new object of class '<em>Neg Bool</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Neg Bool</em>'.
   * @generated
   */
  NegBool createNegBool();

  /**
   * Returns a new object of class '<em>My String</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>My String</em>'.
   * @generated
   */
  MyString createMyString();

  /**
   * Returns a new object of class '<em>If Control Flow</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Control Flow</em>'.
   * @generated
   */
  IfControlFlow createIfControlFlow();

  /**
   * Returns a new object of class '<em>Function Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Call</em>'.
   * @generated
   */
  FunctionCall createFunctionCall();

  /**
   * Returns a new object of class '<em>Pre Def Function Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pre Def Function Call</em>'.
   * @generated
   */
  PreDefFunctionCall createPreDefFunctionCall();

  /**
   * Returns a new object of class '<em>User Def Function Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>User Def Function Call</em>'.
   * @generated
   */
  UserDefFunctionCall createUserDefFunctionCall();

  /**
   * Returns a new object of class '<em>List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List</em>'.
   * @generated
   */
  List createList();

  /**
   * Returns a new object of class '<em>List Elem</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Elem</em>'.
   * @generated
   */
  ListElem createListElem();

  /**
   * Returns a new object of class '<em>Pre Def Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pre Def Function</em>'.
   * @generated
   */
  PreDefFunction createPreDefFunction();

  /**
   * Returns a new object of class '<em>Int List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Int List</em>'.
   * @generated
   */
  IntList createIntList();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ListaCompilerPackage getListaCompilerPackage();

} //ListaCompilerFactory
