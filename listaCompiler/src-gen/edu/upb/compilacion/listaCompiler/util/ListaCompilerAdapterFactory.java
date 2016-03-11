/**
 */
package edu.upb.compilacion.listaCompiler.util;

import edu.upb.compilacion.listaCompiler.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage
 * @generated
 */
public class ListaCompilerAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ListaCompilerPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ListaCompilerAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = ListaCompilerPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ListaCompilerSwitch<Adapter> modelSwitch =
    new ListaCompilerSwitch<Adapter>()
    {
      @Override
      public Adapter caseLista(Lista object)
      {
        return createListaAdapter();
      }
      @Override
      public Adapter caseEvaluation(Evaluation object)
      {
        return createEvaluationAdapter();
      }
      @Override
      public Adapter caseFunctionDefinition(FunctionDefinition object)
      {
        return createFunctionDefinitionAdapter();
      }
      @Override
      public Adapter caseExpression(Expression object)
      {
        return createExpressionAdapter();
      }
      @Override
      public Adapter caseFirstLevelExp(FirstLevelExp object)
      {
        return createFirstLevelExpAdapter();
      }
      @Override
      public Adapter caseSecondLevelExp(SecondLevelExp object)
      {
        return createSecondLevelExpAdapter();
      }
      @Override
      public Adapter caseThirdLevelExp(ThirdLevelExp object)
      {
        return createThirdLevelExpAdapter();
      }
      @Override
      public Adapter caseTerm(Term object)
      {
        return createTermAdapter();
      }
      @Override
      public Adapter caseMyInteger(MyInteger object)
      {
        return createMyIntegerAdapter();
      }
      @Override
      public Adapter casePosInteger(PosInteger object)
      {
        return createPosIntegerAdapter();
      }
      @Override
      public Adapter caseNegInteger(NegInteger object)
      {
        return createNegIntegerAdapter();
      }
      @Override
      public Adapter caseMyVariable(MyVariable object)
      {
        return createMyVariableAdapter();
      }
      @Override
      public Adapter caseBoolTerm(BoolTerm object)
      {
        return createBoolTermAdapter();
      }
      @Override
      public Adapter caseMyBool(MyBool object)
      {
        return createMyBoolAdapter();
      }
      @Override
      public Adapter caseMyString(MyString object)
      {
        return createMyStringAdapter();
      }
      @Override
      public Adapter caseIfControlFlow(IfControlFlow object)
      {
        return createIfControlFlowAdapter();
      }
      @Override
      public Adapter caseFunctionCall(FunctionCall object)
      {
        return createFunctionCallAdapter();
      }
      @Override
      public Adapter caseIntList(IntList object)
      {
        return createIntListAdapter();
      }
      @Override
      public Adapter casePreDefFunction(PreDefFunction object)
      {
        return createPreDefFunctionAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.Lista <em>Lista</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.Lista
   * @generated
   */
  public Adapter createListaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.Evaluation <em>Evaluation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.Evaluation
   * @generated
   */
  public Adapter createEvaluationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.FunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.FunctionDefinition
   * @generated
   */
  public Adapter createFunctionDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.Expression
   * @generated
   */
  public Adapter createExpressionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.FirstLevelExp <em>First Level Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.FirstLevelExp
   * @generated
   */
  public Adapter createFirstLevelExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.SecondLevelExp <em>Second Level Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.SecondLevelExp
   * @generated
   */
  public Adapter createSecondLevelExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.ThirdLevelExp <em>Third Level Exp</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.ThirdLevelExp
   * @generated
   */
  public Adapter createThirdLevelExpAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.Term <em>Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.Term
   * @generated
   */
  public Adapter createTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.MyInteger <em>My Integer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.MyInteger
   * @generated
   */
  public Adapter createMyIntegerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.PosInteger <em>Pos Integer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.PosInteger
   * @generated
   */
  public Adapter createPosIntegerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.NegInteger <em>Neg Integer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.NegInteger
   * @generated
   */
  public Adapter createNegIntegerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.MyVariable <em>My Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.MyVariable
   * @generated
   */
  public Adapter createMyVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.BoolTerm <em>Bool Term</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.BoolTerm
   * @generated
   */
  public Adapter createBoolTermAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.MyBool <em>My Bool</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.MyBool
   * @generated
   */
  public Adapter createMyBoolAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.MyString <em>My String</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.MyString
   * @generated
   */
  public Adapter createMyStringAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.IfControlFlow <em>If Control Flow</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.IfControlFlow
   * @generated
   */
  public Adapter createIfControlFlowAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.FunctionCall
   * @generated
   */
  public Adapter createFunctionCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.IntList <em>Int List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.IntList
   * @generated
   */
  public Adapter createIntListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link edu.upb.compilacion.listaCompiler.PreDefFunction <em>Pre Def Function</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see edu.upb.compilacion.listaCompiler.PreDefFunction
   * @generated
   */
  public Adapter createPreDefFunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //ListaCompilerAdapterFactory
