/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
   * The feature id for the '<em><b>Lines</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LISTA__LINES = 0;

  /**
   * The number of structural features of the '<em>Lista</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LISTA_FEATURE_COUNT = 1;

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
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.ExpressionImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 3;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__ARGS = 0;

  /**
   * The feature id for the '<em><b>Operators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__OPERATORS = 1;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.TermImpl <em>Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.TermImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getTerm()
   * @generated
   */
  int TERM = 4;

  /**
   * The number of structural features of the '<em>Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TERM_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.ControlFlowImpl <em>Control Flow</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.ControlFlowImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getControlFlow()
   * @generated
   */
  int CONTROL_FLOW = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTROL_FLOW__NAME = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTROL_FLOW__COND = TERM_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Iftrue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTROL_FLOW__IFTRUE = TERM_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Iffalse</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTROL_FLOW__IFFALSE = TERM_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Control Flow</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTROL_FLOW_FEATURE_COUNT = TERM_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.FunctionCallImpl <em>Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.FunctionCallImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getFunctionCall()
   * @generated
   */
  int FUNCTION_CALL = 6;

  /**
   * The feature id for the '<em><b>Function</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL__FUNCTION = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL__ARGS = TERM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.DataTypeImpl <em>Data Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.DataTypeImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getDataType()
   * @generated
   */
  int DATA_TYPE = 7;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__VAL = TERM_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE__VAR = TERM_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Data Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_FEATURE_COUNT = TERM_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.IntListImpl <em>Int List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.IntListImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getIntList()
   * @generated
   */
  int INT_LIST = 8;

  /**
   * The feature id for the '<em><b>Val</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LIST__VAL = DATA_TYPE__VAL;

  /**
   * The feature id for the '<em><b>Var</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LIST__VAR = DATA_TYPE__VAR;

  /**
   * The feature id for the '<em><b>Elems</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LIST__ELEMS = DATA_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LIST_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.PreDefFunctionImpl <em>Pre Def Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.PreDefFunctionImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getPreDefFunction()
   * @generated
   */
  int PRE_DEF_FUNCTION = 9;

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
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.OperatorImpl <em>Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.OperatorImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getOperator()
   * @generated
   */
  int OPERATOR = 10;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR__TYPE = 0;

  /**
   * The number of structural features of the '<em>Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATOR_FEATURE_COUNT = 1;


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
   * Returns the meta object for the containment reference list '{@link edu.upb.compilacion.listaCompiler.Lista#getLines <em>Lines</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Lines</em>'.
   * @see edu.upb.compilacion.listaCompiler.Lista#getLines()
   * @see #getLista()
   * @generated
   */
  EReference getLista_Lines();

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
   * Returns the meta object for the containment reference list '{@link edu.upb.compilacion.listaCompiler.Expression#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see edu.upb.compilacion.listaCompiler.Expression#getArgs()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Args();

  /**
   * Returns the meta object for the containment reference list '{@link edu.upb.compilacion.listaCompiler.Expression#getOperators <em>Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operators</em>'.
   * @see edu.upb.compilacion.listaCompiler.Expression#getOperators()
   * @see #getExpression()
   * @generated
   */
  EReference getExpression_Operators();

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
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.ControlFlow <em>Control Flow</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Control Flow</em>'.
   * @see edu.upb.compilacion.listaCompiler.ControlFlow
   * @generated
   */
  EClass getControlFlow();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.ControlFlow#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.upb.compilacion.listaCompiler.ControlFlow#getName()
   * @see #getControlFlow()
   * @generated
   */
  EAttribute getControlFlow_Name();

  /**
   * Returns the meta object for the containment reference '{@link edu.upb.compilacion.listaCompiler.ControlFlow#getCond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond</em>'.
   * @see edu.upb.compilacion.listaCompiler.ControlFlow#getCond()
   * @see #getControlFlow()
   * @generated
   */
  EReference getControlFlow_Cond();

  /**
   * Returns the meta object for the containment reference '{@link edu.upb.compilacion.listaCompiler.ControlFlow#getIftrue <em>Iftrue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Iftrue</em>'.
   * @see edu.upb.compilacion.listaCompiler.ControlFlow#getIftrue()
   * @see #getControlFlow()
   * @generated
   */
  EReference getControlFlow_Iftrue();

  /**
   * Returns the meta object for the containment reference '{@link edu.upb.compilacion.listaCompiler.ControlFlow#getIffalse <em>Iffalse</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Iffalse</em>'.
   * @see edu.upb.compilacion.listaCompiler.ControlFlow#getIffalse()
   * @see #getControlFlow()
   * @generated
   */
  EReference getControlFlow_Iffalse();

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
   * Returns the meta object for the containment reference '{@link edu.upb.compilacion.listaCompiler.FunctionCall#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function</em>'.
   * @see edu.upb.compilacion.listaCompiler.FunctionCall#getFunction()
   * @see #getFunctionCall()
   * @generated
   */
  EReference getFunctionCall_Function();

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
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.DataType <em>Data Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Data Type</em>'.
   * @see edu.upb.compilacion.listaCompiler.DataType
   * @generated
   */
  EClass getDataType();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.DataType#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Val</em>'.
   * @see edu.upb.compilacion.listaCompiler.DataType#getVal()
   * @see #getDataType()
   * @generated
   */
  EAttribute getDataType_Val();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.DataType#getVar <em>Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Var</em>'.
   * @see edu.upb.compilacion.listaCompiler.DataType#getVar()
   * @see #getDataType()
   * @generated
   */
  EAttribute getDataType_Var();

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
   * Returns the meta object for the attribute list '{@link edu.upb.compilacion.listaCompiler.IntList#getElems <em>Elems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Elems</em>'.
   * @see edu.upb.compilacion.listaCompiler.IntList#getElems()
   * @see #getIntList()
   * @generated
   */
  EAttribute getIntList_Elems();

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
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.Operator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operator</em>'.
   * @see edu.upb.compilacion.listaCompiler.Operator
   * @generated
   */
  EClass getOperator();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.Operator#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see edu.upb.compilacion.listaCompiler.Operator#getType()
   * @see #getOperator()
   * @generated
   */
  EAttribute getOperator_Type();

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
     * The meta object literal for the '<em><b>Lines</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LISTA__LINES = eINSTANCE.getLista_Lines();

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
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__ARGS = eINSTANCE.getExpression_Args();

    /**
     * The meta object literal for the '<em><b>Operators</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION__OPERATORS = eINSTANCE.getExpression_Operators();

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
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.ControlFlowImpl <em>Control Flow</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.ControlFlowImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getControlFlow()
     * @generated
     */
    EClass CONTROL_FLOW = eINSTANCE.getControlFlow();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTROL_FLOW__NAME = eINSTANCE.getControlFlow_Name();

    /**
     * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTROL_FLOW__COND = eINSTANCE.getControlFlow_Cond();

    /**
     * The meta object literal for the '<em><b>Iftrue</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTROL_FLOW__IFTRUE = eINSTANCE.getControlFlow_Iftrue();

    /**
     * The meta object literal for the '<em><b>Iffalse</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTROL_FLOW__IFFALSE = eINSTANCE.getControlFlow_Iffalse();

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
     * The meta object literal for the '<em><b>Function</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_CALL__FUNCTION = eINSTANCE.getFunctionCall_Function();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_CALL__ARGS = eINSTANCE.getFunctionCall_Args();

    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.DataTypeImpl <em>Data Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.DataTypeImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getDataType()
     * @generated
     */
    EClass DATA_TYPE = eINSTANCE.getDataType();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATA_TYPE__VAL = eINSTANCE.getDataType_Val();

    /**
     * The meta object literal for the '<em><b>Var</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATA_TYPE__VAR = eINSTANCE.getDataType_Var();

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
     * The meta object literal for the '<em><b>Elems</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_LIST__ELEMS = eINSTANCE.getIntList_Elems();

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
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.OperatorImpl <em>Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.OperatorImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getOperator()
     * @generated
     */
    EClass OPERATOR = eINSTANCE.getOperator();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATOR__TYPE = eINSTANCE.getOperator_Type();

  }

} //ListaCompilerPackage
