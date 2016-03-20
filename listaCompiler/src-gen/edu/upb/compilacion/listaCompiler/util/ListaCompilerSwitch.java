/**
 */
package edu.upb.compilacion.listaCompiler.util;

import edu.upb.compilacion.listaCompiler.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage
 * @generated
 */
public class ListaCompilerSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ListaCompilerPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListaCompilerSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ListaCompilerPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ListaCompilerPackage.LISTA:
      {
        Lista lista = (Lista)theEObject;
        T result = caseLista(lista);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.EVALUATION:
      {
        Evaluation evaluation = (Evaluation)theEObject;
        T result = caseEvaluation(evaluation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.FUNCTION_DEFINITION:
      {
        FunctionDefinition functionDefinition = (FunctionDefinition)theEObject;
        T result = caseFunctionDefinition(functionDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.EXPRESSION:
      {
        Expression expression = (Expression)theEObject;
        T result = caseExpression(expression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.FIRST_LEVEL_EXP:
      {
        FirstLevelExp firstLevelExp = (FirstLevelExp)theEObject;
        T result = caseFirstLevelExp(firstLevelExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.SECOND_LEVEL_EXP:
      {
        SecondLevelExp secondLevelExp = (SecondLevelExp)theEObject;
        T result = caseSecondLevelExp(secondLevelExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.THIRD_LEVEL_EXP:
      {
        ThirdLevelExp thirdLevelExp = (ThirdLevelExp)theEObject;
        T result = caseThirdLevelExp(thirdLevelExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.FOURTH_LEVEL_EXP:
      {
        FourthLevelExp fourthLevelExp = (FourthLevelExp)theEObject;
        T result = caseFourthLevelExp(fourthLevelExp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.TERM:
      {
        Term term = (Term)theEObject;
        T result = caseTerm(term);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.SIMPLE_TERM:
      {
        SimpleTerm simpleTerm = (SimpleTerm)theEObject;
        T result = caseSimpleTerm(simpleTerm);
        if (result == null) result = caseTerm(simpleTerm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.COMPLEX_TERM:
      {
        ComplexTerm complexTerm = (ComplexTerm)theEObject;
        T result = caseComplexTerm(complexTerm);
        if (result == null) result = caseTerm(complexTerm);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.BRACKET_EXPRESSION:
      {
        BracketExpression bracketExpression = (BracketExpression)theEObject;
        T result = caseBracketExpression(bracketExpression);
        if (result == null) result = caseComplexTerm(bracketExpression);
        if (result == null) result = caseTerm(bracketExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.MY_INTEGER:
      {
        MyInteger myInteger = (MyInteger)theEObject;
        T result = caseMyInteger(myInteger);
        if (result == null) result = caseSimpleTerm(myInteger);
        if (result == null) result = caseListElem(myInteger);
        if (result == null) result = caseTerm(myInteger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.POS_INTEGER:
      {
        PosInteger posInteger = (PosInteger)theEObject;
        T result = casePosInteger(posInteger);
        if (result == null) result = caseMyInteger(posInteger);
        if (result == null) result = caseSimpleTerm(posInteger);
        if (result == null) result = caseListElem(posInteger);
        if (result == null) result = caseTerm(posInteger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.NEG_INTEGER:
      {
        NegInteger negInteger = (NegInteger)theEObject;
        T result = caseNegInteger(negInteger);
        if (result == null) result = caseMyInteger(negInteger);
        if (result == null) result = caseSimpleTerm(negInteger);
        if (result == null) result = caseListElem(negInteger);
        if (result == null) result = caseTerm(negInteger);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.MY_VARIABLE:
      {
        MyVariable myVariable = (MyVariable)theEObject;
        T result = caseMyVariable(myVariable);
        if (result == null) result = caseListElem(myVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.VARIABLE:
      {
        Variable variable = (Variable)theEObject;
        T result = caseVariable(variable);
        if (result == null) result = caseSimpleTerm(variable);
        if (result == null) result = caseMyVariable(variable);
        if (result == null) result = caseTerm(variable);
        if (result == null) result = caseListElem(variable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.CASTED_VARIABLE:
      {
        CastedVariable castedVariable = (CastedVariable)theEObject;
        T result = caseCastedVariable(castedVariable);
        if (result == null) result = caseMyVariable(castedVariable);
        if (result == null) result = caseListElem(castedVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.MY_BOOL:
      {
        MyBool myBool = (MyBool)theEObject;
        T result = caseMyBool(myBool);
        if (result == null) result = caseSimpleTerm(myBool);
        if (result == null) result = caseTerm(myBool);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.POS_BOOL:
      {
        PosBool posBool = (PosBool)theEObject;
        T result = casePosBool(posBool);
        if (result == null) result = caseMyBool(posBool);
        if (result == null) result = caseSimpleTerm(posBool);
        if (result == null) result = caseTerm(posBool);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.NEG_BOOL:
      {
        NegBool negBool = (NegBool)theEObject;
        T result = caseNegBool(negBool);
        if (result == null) result = caseMyBool(negBool);
        if (result == null) result = caseSimpleTerm(negBool);
        if (result == null) result = caseTerm(negBool);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.MY_STRING:
      {
        MyString myString = (MyString)theEObject;
        T result = caseMyString(myString);
        if (result == null) result = caseSimpleTerm(myString);
        if (result == null) result = caseTerm(myString);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.IF_CONTROL_FLOW:
      {
        IfControlFlow ifControlFlow = (IfControlFlow)theEObject;
        T result = caseIfControlFlow(ifControlFlow);
        if (result == null) result = caseComplexTerm(ifControlFlow);
        if (result == null) result = caseTerm(ifControlFlow);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.FUNCTION_CALL:
      {
        FunctionCall functionCall = (FunctionCall)theEObject;
        T result = caseFunctionCall(functionCall);
        if (result == null) result = caseComplexTerm(functionCall);
        if (result == null) result = caseTerm(functionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.PRE_DEF_FUNCTION_CALL:
      {
        PreDefFunctionCall preDefFunctionCall = (PreDefFunctionCall)theEObject;
        T result = casePreDefFunctionCall(preDefFunctionCall);
        if (result == null) result = caseFunctionCall(preDefFunctionCall);
        if (result == null) result = caseComplexTerm(preDefFunctionCall);
        if (result == null) result = caseTerm(preDefFunctionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.USER_DEF_FUNCTION_CALL:
      {
        UserDefFunctionCall userDefFunctionCall = (UserDefFunctionCall)theEObject;
        T result = caseUserDefFunctionCall(userDefFunctionCall);
        if (result == null) result = caseFunctionCall(userDefFunctionCall);
        if (result == null) result = caseComplexTerm(userDefFunctionCall);
        if (result == null) result = caseTerm(userDefFunctionCall);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.LIST:
      {
        List list = (List)theEObject;
        T result = caseList(list);
        if (result == null) result = caseSimpleTerm(list);
        if (result == null) result = caseTerm(list);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ListaCompilerPackage.LIST_ELEM:
      {
        ListElem listElem = (ListElem)theEObject;
        T result = caseListElem(listElem);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Lista</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Lista</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLista(Lista object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Evaluation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Evaluation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEvaluation(Evaluation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionDefinition(FunctionDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpression(Expression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>First Level Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>First Level Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFirstLevelExp(FirstLevelExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Second Level Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Second Level Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSecondLevelExp(SecondLevelExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Third Level Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Third Level Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseThirdLevelExp(ThirdLevelExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fourth Level Exp</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fourth Level Exp</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFourthLevelExp(FourthLevelExp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTerm(Term object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Simple Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Simple Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSimpleTerm(SimpleTerm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Complex Term</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Complex Term</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseComplexTerm(ComplexTerm object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bracket Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bracket Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBracketExpression(BracketExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Integer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Integer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyInteger(MyInteger object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pos Integer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pos Integer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePosInteger(PosInteger object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Neg Integer</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Neg Integer</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNegInteger(NegInteger object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyVariable(MyVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariable(Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Casted Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Casted Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCastedVariable(CastedVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My Bool</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My Bool</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyBool(MyBool object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pos Bool</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pos Bool</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePosBool(PosBool object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Neg Bool</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Neg Bool</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNegBool(NegBool object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>My String</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>My String</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMyString(MyString object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Control Flow</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Control Flow</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfControlFlow(IfControlFlow object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunctionCall(FunctionCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pre Def Function Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pre Def Function Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePreDefFunctionCall(PreDefFunctionCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>User Def Function Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>User Def Function Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUserDefFunctionCall(UserDefFunctionCall object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseList(List object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>List Elem</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>List Elem</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseListElem(ListElem object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ListaCompilerSwitch
