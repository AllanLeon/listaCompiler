/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerFactory
 * @model kind="package"
 * @generated
 */
public interface ListaCompilerPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "listaCompiler";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.upb.edu/compilacion/ListaCompiler";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "listaCompiler";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ListaCompilerPackage eINSTANCE = edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.ListaImpl <em>Lista</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.ListaImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getLista()
   * @generated
   */
  int LISTA = 0;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LISTA__DEFINITIONS = 0;

  /**
   * The feature id for the '<em><b>Evaluations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LISTA__EVALUATIONS = 1;

  /**
   * The number of structural features of the '<em>Lista</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LISTA_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.EvaluationImpl <em>Evaluation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.EvaluationImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getEvaluation()
   * @generated
   */
  int EVALUATION = 1;

  /**
   * The feature id for the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVALUATION__RETURN = 0;

  /**
   * The number of structural features of the '<em>Evaluation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVALUATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.FunctionDefinitionImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFunctionDefinition()
   * @generated
   */
  int FUNCTION_DEFINITION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Params</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__PARAMS = 1;

  /**
   * The feature id for the '<em><b>Return</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__RETURN = 2;

  /**
   * The number of structural features of the '<em>Function Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.TermImpl <em>Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.TermImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getTerm()
   * @generated
   */
  int TERM = 8;

  /**
   * The number of structural features of the '<em>Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.ExpressionImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 3;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__EXP = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.FirstLevelExpImpl <em>First Level Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.FirstLevelExpImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFirstLevelExp()
   * @generated
   */
  int FIRST_LEVEL_EXP = 4;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_LEVEL_EXP__ARGS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_LEVEL_EXP__OP = 1;

  /**
   * The number of structural features of the '<em>First Level Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIRST_LEVEL_EXP_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.SecondLevelExpImpl <em>Second Level Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.SecondLevelExpImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getSecondLevelExp()
   * @generated
   */
  int SECOND_LEVEL_EXP = 5;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_LEVEL_EXP__ARGS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_LEVEL_EXP__OP = 1;

  /**
   * The number of structural features of the '<em>Second Level Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECOND_LEVEL_EXP_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.ThirdLevelExpImpl <em>Third Level Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.ThirdLevelExpImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getThirdLevelExp()
   * @generated
   */
  int THIRD_LEVEL_EXP = 6;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_LEVEL_EXP__ARGS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_LEVEL_EXP__OP = 1;

  /**
   * The number of structural features of the '<em>Third Level Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIRD_LEVEL_EXP_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.FourthLevelExpImpl <em>Fourth Level Exp</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.FourthLevelExpImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFourthLevelExp()
   * @generated
   */
  int FOURTH_LEVEL_EXP = 7;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOURTH_LEVEL_EXP__ARGS = 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOURTH_LEVEL_EXP__OP = 1;

  /**
   * The number of structural features of the '<em>Fourth Level Exp</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOURTH_LEVEL_EXP_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.MyIntegerImpl <em>My Integer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.MyIntegerImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getMyInteger()
   * @generated
   */
  int MY_INTEGER = 9;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_INTEGER__VAL = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>My Integer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_INTEGER_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.PosIntegerImpl <em>Pos Integer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.PosIntegerImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getPosInteger()
   * @generated
   */
  int POS_INTEGER = 10;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POS_INTEGER__VAL = MY_INTEGER__VAL;

  /**
   * The number of structural features of the '<em>Pos Integer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POS_INTEGER_FEATURE_COUNT = MY_INTEGER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.NegIntegerImpl <em>Neg Integer</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.NegIntegerImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getNegInteger()
   * @generated
   */
  int NEG_INTEGER = 11;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEG_INTEGER__VAL = MY_INTEGER__VAL;

  /**
   * The number of structural features of the '<em>Neg Integer</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEG_INTEGER_FEATURE_COUNT = MY_INTEGER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.MyVariableImpl <em>My Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.MyVariableImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getMyVariable()
   * @generated
   */
  int MY_VARIABLE = 12;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_VARIABLE__VAR = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>My Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_VARIABLE_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.MyBoolImpl <em>My Bool</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.MyBoolImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getMyBool()
   * @generated
   */
  int MY_BOOL = 13;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_BOOL__VAL = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>My Bool</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_BOOL_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.PosBoolImpl <em>Pos Bool</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.PosBoolImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getPosBool()
   * @generated
   */
  int POS_BOOL = 14;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POS_BOOL__VAL = MY_BOOL__VAL;

  /**
   * The number of structural features of the '<em>Pos Bool</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POS_BOOL_FEATURE_COUNT = MY_BOOL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.NegBoolImpl <em>Neg Bool</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.NegBoolImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getNegBool()
   * @generated
   */
  int NEG_BOOL = 15;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEG_BOOL__VAL = MY_BOOL__VAL;

  /**
   * The number of structural features of the '<em>Neg Bool</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NEG_BOOL_FEATURE_COUNT = MY_BOOL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.MyStringImpl <em>My String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.MyStringImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getMyString()
   * @generated
   */
  int MY_STRING = 16;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_STRING__VAL = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>My String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MY_STRING_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.IfControlFlowImpl <em>If Control Flow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.IfControlFlowImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getIfControlFlow()
   * @generated
   */
  int IF_CONTROL_FLOW = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CONTROL_FLOW__NAME = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CONTROL_FLOW__COND = TERM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Iftrue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CONTROL_FLOW__IFTRUE = TERM_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Iffalse</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CONTROL_FLOW__IFFALSE = TERM_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>If Control Flow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CONTROL_FLOW_FEATURE_COUNT = TERM_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.FunctionCallImpl <em>Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.FunctionCallImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFunctionCall()
   * @generated
   */
  int FUNCTION_CALL = 18;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL__ARGS = TERM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL_FEATURE_COUNT = TERM_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.PreDefFunctionCallImpl <em>Pre Def Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.PreDefFunctionCallImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getPreDefFunctionCall()
   * @generated
   */
  int PRE_DEF_FUNCTION_CALL = 19;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_DEF_FUNCTION_CALL__ARGS = FUNCTION_CALL__ARGS;

  /**
   * The feature id for the '<em><b>Function</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_DEF_FUNCTION_CALL__FUNCTION = FUNCTION_CALL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Pre Def Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_DEF_FUNCTION_CALL_FEATURE_COUNT = FUNCTION_CALL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.UserDefFunctionCallImpl <em>User Def Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.UserDefFunctionCallImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getUserDefFunctionCall()
   * @generated
   */
  int USER_DEF_FUNCTION_CALL = 20;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_DEF_FUNCTION_CALL__ARGS = FUNCTION_CALL__ARGS;

  /**
   * The feature id for the '<em><b>Function</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_DEF_FUNCTION_CALL__FUNCTION = FUNCTION_CALL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>User Def Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int USER_DEF_FUNCTION_CALL_FEATURE_COUNT = FUNCTION_CALL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.ListImpl <em>List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.ListImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getList()
   * @generated
   */
  int LIST = 21;

  /**
   * The number of structural features of the '<em>List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_FEATURE_COUNT = TERM_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.ListElemImpl <em>List Elem</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.ListElemImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getListElem()
   * @generated
   */
  int LIST_ELEM = 22;

  /**
   * The number of structural features of the '<em>List Elem</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_ELEM_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.PreDefFunctionImpl <em>Pre Def Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.PreDefFunctionImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getPreDefFunction()
   * @generated
   */
  int PRE_DEF_FUNCTION = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_DEF_FUNCTION__NAME = 0;

  /**
   * The number of structural features of the '<em>Pre Def Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_DEF_FUNCTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.IntListImpl <em>Int List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.IntListImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getIntList()
   * @generated
   */
  int INT_LIST = 24;

  /**
   * The feature id for the '<em><b>Elems</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LIST__ELEMS = LIST_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LIST_FEATURE_COUNT = LIST_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.Bool <em>Bool</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.Bool
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getBool()
   * @generated
   */
  int BOOL = 25;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.PDFunction <em>PD Function</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.PDFunction
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getPDFunction()
   * @generated
   */
  int PD_FUNCTION = 26;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.CFlow <em>CFlow</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.CFlow
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getCFlow()
   * @generated
   */
  int CFLOW = 27;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.FirstLevelOp <em>First Level Op</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.FirstLevelOp
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFirstLevelOp()
   * @generated
   */
  int FIRST_LEVEL_OP = 28;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.SecondLevelOp <em>Second Level Op</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.SecondLevelOp
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getSecondLevelOp()
   * @generated
   */
  int SECOND_LEVEL_OP = 29;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.ThirdLevelOp <em>Third Level Op</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.ThirdLevelOp
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getThirdLevelOp()
   * @generated
   */
  int THIRD_LEVEL_OP = 30;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.FourthLevelOp <em>Fourth Level Op</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.FourthLevelOp
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFourthLevelOp()
   * @generated
   */
  int FOURTH_LEVEL_OP = 31;


  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.Lista <em>Lista</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lista</em>'.
   * @see edu.upb.compilacion.listaCompiler.Lista
   * @generated
   */
  EClass getLista();

  /**
   * Returns the meta object for the containment reference list '{@link edu.upb.compilacion.listaCompiler.Lista#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see edu.upb.compilacion.listaCompiler.Lista#getDefinitions()
   * @see #getLista()
   * @generated
   */
  EReference getLista_Definitions();

  /**
   * Returns the meta object for the containment reference list '{@link edu.upb.compilacion.listaCompiler.Lista#getEvaluations <em>Evaluations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Evaluations</em>'.
   * @see edu.upb.compilacion.listaCompiler.Lista#getEvaluations()
   * @see #getLista()
   * @generated
   */
  EReference getLista_Evaluations();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.Evaluation <em>Evaluation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Evaluation</em>'.
   * @see edu.upb.compilacion.listaCompiler.Evaluation
   * @generated
   */
  EClass getEvaluation();

  /**
   * Returns the meta object for the containment reference '{@link edu.upb.compilacion.listaCompiler.Evaluation#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return</em>'.
   * @see edu.upb.compilacion.listaCompiler.Evaluation#getReturn()
   * @see #getEvaluation()
   * @generated
   */
  EReference getEvaluation_Return();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.FunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Definition</em>'.
   * @see edu.upb.compilacion.listaCompiler.FunctionDefinition
   * @generated
   */
  EClass getFunctionDefinition();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.FunctionDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.upb.compilacion.listaCompiler.FunctionDefinition#getName()
   * @see #getFunctionDefinition()
   * @generated
   */
  EAttribute getFunctionDefinition_Name();

  /**
   * Returns the meta object for the attribute list '{@link edu.upb.compilacion.listaCompiler.FunctionDefinition#getParams <em>Params</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Params</em>'.
   * @see edu.upb.compilacion.listaCompiler.FunctionDefinition#getParams()
   * @see #getFunctionDefinition()
   * @generated
   */
  EAttribute getFunctionDefinition_Params();

  /**
   * Returns the meta object for the containment reference '{@link edu.upb.compilacion.listaCompiler.FunctionDefinition#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return</em>'.
   * @see edu.upb.compilacion.listaCompiler.FunctionDefinition#getReturn()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Return();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see edu.upb.compilacion.listaCompiler.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for the containment reference '{@link edu.upb.compilacion.listaCompiler.Expression#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see edu.upb.compilacion.listaCompiler.Expression#getExp()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Exp();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.FirstLevelExp <em>First Level Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>First Level Exp</em>'.
   * @see edu.upb.compilacion.listaCompiler.FirstLevelExp
   * @generated
   */
  EClass getFirstLevelExp();

  /**
   * Returns the meta object for the containment reference list '{@link edu.upb.compilacion.listaCompiler.FirstLevelExp#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see edu.upb.compilacion.listaCompiler.FirstLevelExp#getArgs()
   * @see #getFirstLevelExp()
   * @generated
   */
  EReference getFirstLevelExp_Args();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.FirstLevelExp#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.upb.compilacion.listaCompiler.FirstLevelExp#getOp()
   * @see #getFirstLevelExp()
   * @generated
   */
  EAttribute getFirstLevelExp_Op();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.SecondLevelExp <em>Second Level Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Second Level Exp</em>'.
   * @see edu.upb.compilacion.listaCompiler.SecondLevelExp
   * @generated
   */
  EClass getSecondLevelExp();

  /**
   * Returns the meta object for the containment reference list '{@link edu.upb.compilacion.listaCompiler.SecondLevelExp#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see edu.upb.compilacion.listaCompiler.SecondLevelExp#getArgs()
   * @see #getSecondLevelExp()
   * @generated
   */
  EReference getSecondLevelExp_Args();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.SecondLevelExp#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.upb.compilacion.listaCompiler.SecondLevelExp#getOp()
   * @see #getSecondLevelExp()
   * @generated
   */
  EAttribute getSecondLevelExp_Op();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.ThirdLevelExp <em>Third Level Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Third Level Exp</em>'.
   * @see edu.upb.compilacion.listaCompiler.ThirdLevelExp
   * @generated
   */
  EClass getThirdLevelExp();

  /**
   * Returns the meta object for the containment reference list '{@link edu.upb.compilacion.listaCompiler.ThirdLevelExp#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see edu.upb.compilacion.listaCompiler.ThirdLevelExp#getArgs()
   * @see #getThirdLevelExp()
   * @generated
   */
  EReference getThirdLevelExp_Args();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.ThirdLevelExp#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.upb.compilacion.listaCompiler.ThirdLevelExp#getOp()
   * @see #getThirdLevelExp()
   * @generated
   */
  EAttribute getThirdLevelExp_Op();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.FourthLevelExp <em>Fourth Level Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fourth Level Exp</em>'.
   * @see edu.upb.compilacion.listaCompiler.FourthLevelExp
   * @generated
   */
  EClass getFourthLevelExp();

  /**
   * Returns the meta object for the containment reference list '{@link edu.upb.compilacion.listaCompiler.FourthLevelExp#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see edu.upb.compilacion.listaCompiler.FourthLevelExp#getArgs()
   * @see #getFourthLevelExp()
   * @generated
   */
  EReference getFourthLevelExp_Args();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.FourthLevelExp#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see edu.upb.compilacion.listaCompiler.FourthLevelExp#getOp()
   * @see #getFourthLevelExp()
   * @generated
   */
  EAttribute getFourthLevelExp_Op();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Term</em>'.
   * @see edu.upb.compilacion.listaCompiler.Term
   * @generated
   */
  EClass getTerm();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.MyInteger <em>My Integer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Integer</em>'.
   * @see edu.upb.compilacion.listaCompiler.MyInteger
   * @generated
   */
  EClass getMyInteger();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.MyInteger#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see edu.upb.compilacion.listaCompiler.MyInteger#getVal()
   * @see #getMyInteger()
   * @generated
   */
  EAttribute getMyInteger_Val();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.PosInteger <em>Pos Integer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pos Integer</em>'.
   * @see edu.upb.compilacion.listaCompiler.PosInteger
   * @generated
   */
  EClass getPosInteger();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.NegInteger <em>Neg Integer</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Neg Integer</em>'.
   * @see edu.upb.compilacion.listaCompiler.NegInteger
   * @generated
   */
  EClass getNegInteger();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.MyVariable <em>My Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Variable</em>'.
   * @see edu.upb.compilacion.listaCompiler.MyVariable
   * @generated
   */
  EClass getMyVariable();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.MyVariable#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see edu.upb.compilacion.listaCompiler.MyVariable#getVar()
   * @see #getMyVariable()
   * @generated
   */
  EAttribute getMyVariable_Var();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.MyBool <em>My Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My Bool</em>'.
   * @see edu.upb.compilacion.listaCompiler.MyBool
   * @generated
   */
  EClass getMyBool();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.MyBool#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see edu.upb.compilacion.listaCompiler.MyBool#getVal()
   * @see #getMyBool()
   * @generated
   */
  EAttribute getMyBool_Val();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.PosBool <em>Pos Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pos Bool</em>'.
   * @see edu.upb.compilacion.listaCompiler.PosBool
   * @generated
   */
  EClass getPosBool();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.NegBool <em>Neg Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Neg Bool</em>'.
   * @see edu.upb.compilacion.listaCompiler.NegBool
   * @generated
   */
  EClass getNegBool();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.MyString <em>My String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>My String</em>'.
   * @see edu.upb.compilacion.listaCompiler.MyString
   * @generated
   */
  EClass getMyString();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.MyString#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see edu.upb.compilacion.listaCompiler.MyString#getVal()
   * @see #getMyString()
   * @generated
   */
  EAttribute getMyString_Val();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.IfControlFlow <em>If Control Flow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Control Flow</em>'.
   * @see edu.upb.compilacion.listaCompiler.IfControlFlow
   * @generated
   */
  EClass getIfControlFlow();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.IfControlFlow#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.upb.compilacion.listaCompiler.IfControlFlow#getName()
   * @see #getIfControlFlow()
   * @generated
   */
  EAttribute getIfControlFlow_Name();

  /**
   * Returns the meta object for the containment reference '{@link edu.upb.compilacion.listaCompiler.IfControlFlow#getCond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond</em>'.
   * @see edu.upb.compilacion.listaCompiler.IfControlFlow#getCond()
   * @see #getIfControlFlow()
   * @generated
   */
  EReference getIfControlFlow_Cond();

  /**
   * Returns the meta object for the containment reference '{@link edu.upb.compilacion.listaCompiler.IfControlFlow#getIftrue <em>Iftrue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Iftrue</em>'.
   * @see edu.upb.compilacion.listaCompiler.IfControlFlow#getIftrue()
   * @see #getIfControlFlow()
   * @generated
   */
  EReference getIfControlFlow_Iftrue();

  /**
   * Returns the meta object for the containment reference '{@link edu.upb.compilacion.listaCompiler.IfControlFlow#getIffalse <em>Iffalse</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Iffalse</em>'.
   * @see edu.upb.compilacion.listaCompiler.IfControlFlow#getIffalse()
   * @see #getIfControlFlow()
   * @generated
   */
  EReference getIfControlFlow_Iffalse();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Call</em>'.
   * @see edu.upb.compilacion.listaCompiler.FunctionCall
   * @generated
   */
  EClass getFunctionCall();

  /**
   * Returns the meta object for the containment reference list '{@link edu.upb.compilacion.listaCompiler.FunctionCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see edu.upb.compilacion.listaCompiler.FunctionCall#getArgs()
   * @see #getFunctionCall()
   * @generated
   */
  EReference getFunctionCall_Args();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.PreDefFunctionCall <em>Pre Def Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pre Def Function Call</em>'.
   * @see edu.upb.compilacion.listaCompiler.PreDefFunctionCall
   * @generated
   */
  EClass getPreDefFunctionCall();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.PreDefFunctionCall#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Function</em>'.
   * @see edu.upb.compilacion.listaCompiler.PreDefFunctionCall#getFunction()
   * @see #getPreDefFunctionCall()
   * @generated
   */
  EAttribute getPreDefFunctionCall_Function();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.UserDefFunctionCall <em>User Def Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>User Def Function Call</em>'.
   * @see edu.upb.compilacion.listaCompiler.UserDefFunctionCall
   * @generated
   */
  EClass getUserDefFunctionCall();

  /**
   * Returns the meta object for the reference '{@link edu.upb.compilacion.listaCompiler.UserDefFunctionCall#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Function</em>'.
   * @see edu.upb.compilacion.listaCompiler.UserDefFunctionCall#getFunction()
   * @see #getUserDefFunctionCall()
   * @generated
   */
  EReference getUserDefFunctionCall_Function();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.List <em>List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List</em>'.
   * @see edu.upb.compilacion.listaCompiler.List
   * @generated
   */
  EClass getList();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.ListElem <em>List Elem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Elem</em>'.
   * @see edu.upb.compilacion.listaCompiler.ListElem
   * @generated
   */
  EClass getListElem();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.PreDefFunction <em>Pre Def Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pre Def Function</em>'.
   * @see edu.upb.compilacion.listaCompiler.PreDefFunction
   * @generated
   */
  EClass getPreDefFunction();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.PreDefFunction#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.upb.compilacion.listaCompiler.PreDefFunction#getName()
   * @see #getPreDefFunction()
   * @generated
   */
  EAttribute getPreDefFunction_Name();

  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.IntList <em>Int List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int List</em>'.
   * @see edu.upb.compilacion.listaCompiler.IntList
   * @generated
   */
  EClass getIntList();

  /**
   * Returns the meta object for the containment reference list '{@link edu.upb.compilacion.listaCompiler.IntList#getElems <em>Elems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elems</em>'.
   * @see edu.upb.compilacion.listaCompiler.IntList#getElems()
   * @see #getIntList()
   * @generated
   */
  EReference getIntList_Elems();

  /**
   * Returns the meta object for enum '{@link edu.upb.compilacion.listaCompiler.Bool <em>Bool</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Bool</em>'.
   * @see edu.upb.compilacion.listaCompiler.Bool
   * @generated
   */
  EEnum getBool();

  /**
   * Returns the meta object for enum '{@link edu.upb.compilacion.listaCompiler.PDFunction <em>PD Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>PD Function</em>'.
   * @see edu.upb.compilacion.listaCompiler.PDFunction
   * @generated
   */
  EEnum getPDFunction();

  /**
   * Returns the meta object for enum '{@link edu.upb.compilacion.listaCompiler.CFlow <em>CFlow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>CFlow</em>'.
   * @see edu.upb.compilacion.listaCompiler.CFlow
   * @generated
   */
  EEnum getCFlow();

  /**
   * Returns the meta object for enum '{@link edu.upb.compilacion.listaCompiler.FirstLevelOp <em>First Level Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>First Level Op</em>'.
   * @see edu.upb.compilacion.listaCompiler.FirstLevelOp
   * @generated
   */
  EEnum getFirstLevelOp();

  /**
   * Returns the meta object for enum '{@link edu.upb.compilacion.listaCompiler.SecondLevelOp <em>Second Level Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Second Level Op</em>'.
   * @see edu.upb.compilacion.listaCompiler.SecondLevelOp
   * @generated
   */
  EEnum getSecondLevelOp();

  /**
   * Returns the meta object for enum '{@link edu.upb.compilacion.listaCompiler.ThirdLevelOp <em>Third Level Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Third Level Op</em>'.
   * @see edu.upb.compilacion.listaCompiler.ThirdLevelOp
   * @generated
   */
  EEnum getThirdLevelOp();

  /**
   * Returns the meta object for enum '{@link edu.upb.compilacion.listaCompiler.FourthLevelOp <em>Fourth Level Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Fourth Level Op</em>'.
   * @see edu.upb.compilacion.listaCompiler.FourthLevelOp
   * @generated
   */
  EEnum getFourthLevelOp();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ListaCompilerFactory getListaCompilerFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.ListaImpl <em>Lista</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.ListaImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getLista()
     * @generated
     */
    EClass LISTA = eINSTANCE.getLista();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LISTA__DEFINITIONS = eINSTANCE.getLista_Definitions();

    /**
     * The meta object literal for the '<em><b>Evaluations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LISTA__EVALUATIONS = eINSTANCE.getLista_Evaluations();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.EvaluationImpl <em>Evaluation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.EvaluationImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getEvaluation()
     * @generated
     */
    EClass EVALUATION = eINSTANCE.getEvaluation();

    /**
     * The meta object literal for the '<em><b>Return</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVALUATION__RETURN = eINSTANCE.getEvaluation_Return();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.FunctionDefinitionImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFunctionDefinition()
     * @generated
     */
    EClass FUNCTION_DEFINITION = eINSTANCE.getFunctionDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_DEFINITION__NAME = eINSTANCE.getFunctionDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Params</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_DEFINITION__PARAMS = eINSTANCE.getFunctionDefinition_Params();

    /**
     * The meta object literal for the '<em><b>Return</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__RETURN = eINSTANCE.getFunctionDefinition_Return();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.ExpressionImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__EXP = eINSTANCE.getExpression_Exp();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.FirstLevelExpImpl <em>First Level Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.FirstLevelExpImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFirstLevelExp()
     * @generated
     */
    EClass FIRST_LEVEL_EXP = eINSTANCE.getFirstLevelExp();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIRST_LEVEL_EXP__ARGS = eINSTANCE.getFirstLevelExp_Args();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIRST_LEVEL_EXP__OP = eINSTANCE.getFirstLevelExp_Op();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.SecondLevelExpImpl <em>Second Level Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.SecondLevelExpImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getSecondLevelExp()
     * @generated
     */
    EClass SECOND_LEVEL_EXP = eINSTANCE.getSecondLevelExp();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECOND_LEVEL_EXP__ARGS = eINSTANCE.getSecondLevelExp_Args();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SECOND_LEVEL_EXP__OP = eINSTANCE.getSecondLevelExp_Op();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.ThirdLevelExpImpl <em>Third Level Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.ThirdLevelExpImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getThirdLevelExp()
     * @generated
     */
    EClass THIRD_LEVEL_EXP = eINSTANCE.getThirdLevelExp();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THIRD_LEVEL_EXP__ARGS = eINSTANCE.getThirdLevelExp_Args();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute THIRD_LEVEL_EXP__OP = eINSTANCE.getThirdLevelExp_Op();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.FourthLevelExpImpl <em>Fourth Level Exp</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.FourthLevelExpImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFourthLevelExp()
     * @generated
     */
    EClass FOURTH_LEVEL_EXP = eINSTANCE.getFourthLevelExp();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOURTH_LEVEL_EXP__ARGS = eINSTANCE.getFourthLevelExp_Args();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOURTH_LEVEL_EXP__OP = eINSTANCE.getFourthLevelExp_Op();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.TermImpl <em>Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.TermImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getTerm()
     * @generated
     */
    EClass TERM = eINSTANCE.getTerm();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.MyIntegerImpl <em>My Integer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.MyIntegerImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getMyInteger()
     * @generated
     */
    EClass MY_INTEGER = eINSTANCE.getMyInteger();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_INTEGER__VAL = eINSTANCE.getMyInteger_Val();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.PosIntegerImpl <em>Pos Integer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.PosIntegerImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getPosInteger()
     * @generated
     */
    EClass POS_INTEGER = eINSTANCE.getPosInteger();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.NegIntegerImpl <em>Neg Integer</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.NegIntegerImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getNegInteger()
     * @generated
     */
    EClass NEG_INTEGER = eINSTANCE.getNegInteger();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.MyVariableImpl <em>My Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.MyVariableImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getMyVariable()
     * @generated
     */
    EClass MY_VARIABLE = eINSTANCE.getMyVariable();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_VARIABLE__VAR = eINSTANCE.getMyVariable_Var();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.MyBoolImpl <em>My Bool</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.MyBoolImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getMyBool()
     * @generated
     */
    EClass MY_BOOL = eINSTANCE.getMyBool();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_BOOL__VAL = eINSTANCE.getMyBool_Val();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.PosBoolImpl <em>Pos Bool</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.PosBoolImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getPosBool()
     * @generated
     */
    EClass POS_BOOL = eINSTANCE.getPosBool();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.NegBoolImpl <em>Neg Bool</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.NegBoolImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getNegBool()
     * @generated
     */
    EClass NEG_BOOL = eINSTANCE.getNegBool();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.MyStringImpl <em>My String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.MyStringImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getMyString()
     * @generated
     */
    EClass MY_STRING = eINSTANCE.getMyString();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MY_STRING__VAL = eINSTANCE.getMyString_Val();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.IfControlFlowImpl <em>If Control Flow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.IfControlFlowImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getIfControlFlow()
     * @generated
     */
    EClass IF_CONTROL_FLOW = eINSTANCE.getIfControlFlow();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IF_CONTROL_FLOW__NAME = eINSTANCE.getIfControlFlow_Name();

    /**
     * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_CONTROL_FLOW__COND = eINSTANCE.getIfControlFlow_Cond();

    /**
     * The meta object literal for the '<em><b>Iftrue</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_CONTROL_FLOW__IFTRUE = eINSTANCE.getIfControlFlow_Iftrue();

    /**
     * The meta object literal for the '<em><b>Iffalse</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_CONTROL_FLOW__IFFALSE = eINSTANCE.getIfControlFlow_Iffalse();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.FunctionCallImpl <em>Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.FunctionCallImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFunctionCall()
     * @generated
     */
    EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_CALL__ARGS = eINSTANCE.getFunctionCall_Args();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.PreDefFunctionCallImpl <em>Pre Def Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.PreDefFunctionCallImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getPreDefFunctionCall()
     * @generated
     */
    EClass PRE_DEF_FUNCTION_CALL = eINSTANCE.getPreDefFunctionCall();

    /**
     * The meta object literal for the '<em><b>Function</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRE_DEF_FUNCTION_CALL__FUNCTION = eINSTANCE.getPreDefFunctionCall_Function();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.UserDefFunctionCallImpl <em>User Def Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.UserDefFunctionCallImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getUserDefFunctionCall()
     * @generated
     */
    EClass USER_DEF_FUNCTION_CALL = eINSTANCE.getUserDefFunctionCall();

    /**
     * The meta object literal for the '<em><b>Function</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference USER_DEF_FUNCTION_CALL__FUNCTION = eINSTANCE.getUserDefFunctionCall_Function();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.ListImpl <em>List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.ListImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getList()
     * @generated
     */
    EClass LIST = eINSTANCE.getList();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.ListElemImpl <em>List Elem</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.ListElemImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getListElem()
     * @generated
     */
    EClass LIST_ELEM = eINSTANCE.getListElem();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.PreDefFunctionImpl <em>Pre Def Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.PreDefFunctionImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getPreDefFunction()
     * @generated
     */
    EClass PRE_DEF_FUNCTION = eINSTANCE.getPreDefFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRE_DEF_FUNCTION__NAME = eINSTANCE.getPreDefFunction_Name();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.IntListImpl <em>Int List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.IntListImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getIntList()
     * @generated
     */
    EClass INT_LIST = eINSTANCE.getIntList();

    /**
     * The meta object literal for the '<em><b>Elems</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INT_LIST__ELEMS = eINSTANCE.getIntList_Elems();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.Bool <em>Bool</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.Bool
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getBool()
     * @generated
     */
    EEnum BOOL = eINSTANCE.getBool();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.PDFunction <em>PD Function</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.PDFunction
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getPDFunction()
     * @generated
     */
    EEnum PD_FUNCTION = eINSTANCE.getPDFunction();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.CFlow <em>CFlow</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.CFlow
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getCFlow()
     * @generated
     */
    EEnum CFLOW = eINSTANCE.getCFlow();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.FirstLevelOp <em>First Level Op</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.FirstLevelOp
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFirstLevelOp()
     * @generated
     */
    EEnum FIRST_LEVEL_OP = eINSTANCE.getFirstLevelOp();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.SecondLevelOp <em>Second Level Op</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.SecondLevelOp
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getSecondLevelOp()
     * @generated
     */
    EEnum SECOND_LEVEL_OP = eINSTANCE.getSecondLevelOp();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.ThirdLevelOp <em>Third Level Op</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.ThirdLevelOp
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getThirdLevelOp()
     * @generated
     */
    EEnum THIRD_LEVEL_OP = eINSTANCE.getThirdLevelOp();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.FourthLevelOp <em>Fourth Level Op</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.FourthLevelOp
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFourthLevelOp()
     * @generated
     */
    EEnum FOURTH_LEVEL_OP = eINSTANCE.getFourthLevelOp();

  }

} //ListaCompilerPackage
