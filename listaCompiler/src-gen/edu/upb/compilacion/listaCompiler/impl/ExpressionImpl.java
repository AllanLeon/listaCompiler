/**
 */
package edu.upb.compilacion.listaCompiler.impl;

import edu.upb.compilacion.listaCompiler.Expression;
import edu.upb.compilacion.listaCompiler.ListaCompilerPackage;
import edu.upb.compilacion.listaCompiler.Operator;
import edu.upb.compilacion.listaCompiler.Term;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.impl.ExpressionImpl#getArgs <em>Args</em>}</li>
 *   <li>{@link edu.upb.compilacion.listaCompiler.impl.ExpressionImpl#getOperators <em>Operators</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExpressionImpl extends MinimalEObjectImpl.Container implements Expression
{
  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<Term> args;

  /**
   * The cached value of the '{@link #getOperators() <em>Operators</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperators()
   * @generated
   * @ordered
   */
  protected EList<Operator> operators;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ListaCompilerPackage.Literals.EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Term> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<Term>(Term.class, this, ListaCompilerPackage.EXPRESSION__ARGS);
    }
    return args;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Operator> getOperators()
  {
    if (operators == null)
    {
      operators = new EObjectContainmentEList<Operator>(Operator.class, this, ListaCompilerPackage.EXPRESSION__OPERATORS);
    }
    return operators;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ListaCompilerPackage.EXPRESSION__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
      case ListaCompilerPackage.EXPRESSION__OPERATORS:
        return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ListaCompilerPackage.EXPRESSION__ARGS:
        return getArgs();
      case ListaCompilerPackage.EXPRESSION__OPERATORS:
        return getOperators();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ListaCompilerPackage.EXPRESSION__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends Term>)newValue);
        return;
      case ListaCompilerPackage.EXPRESSION__OPERATORS:
        getOperators().clear();
        getOperators().addAll((Collection<? extends Operator>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ListaCompilerPackage.EXPRESSION__ARGS:
        getArgs().clear();
        return;
      case ListaCompilerPackage.EXPRESSION__OPERATORS:
        getOperators().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ListaCompilerPackage.EXPRESSION__ARGS:
        return args != null && !args.isEmpty();
      case ListaCompilerPackage.EXPRESSION__OPERATORS:
        return operators != null && !operators.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ExpressionImpl
