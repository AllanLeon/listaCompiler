/**
 */
package edu.upb.compilacion.listaCompiler.impl;

import edu.upb.compilacion.listaCompiler.Expression;
import edu.upb.compilacion.listaCompiler.IfControlFlow;
import edu.upb.compilacion.listaCompiler.ListaCompilerPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Control Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.impl.IfControlFlowImpl#getCond <em>Cond</em>}</li>
 *   <li>{@link edu.upb.compilacion.listaCompiler.impl.IfControlFlowImpl#getIftrue <em>Iftrue</em>}</li>
 *   <li>{@link edu.upb.compilacion.listaCompiler.impl.IfControlFlowImpl#getIffalse <em>Iffalse</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfControlFlowImpl extends TermImpl implements IfControlFlow
{
  /**
   * The cached value of the '{@link #getCond() <em>Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCond()
   * @generated
   * @ordered
   */
  protected Expression cond;

  /**
   * The cached value of the '{@link #getIftrue() <em>Iftrue</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIftrue()
   * @generated
   * @ordered
   */
  protected Expression iftrue;

  /**
   * The cached value of the '{@link #getIffalse() <em>Iffalse</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIffalse()
   * @generated
   * @ordered
   */
  protected Expression iffalse;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfControlFlowImpl()
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
    return ListaCompilerPackage.Literals.IF_CONTROL_FLOW;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getCond()
  {
    return cond;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCond(Expression newCond, NotificationChain msgs)
  {
    Expression oldCond = cond;
    cond = newCond;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ListaCompilerPackage.IF_CONTROL_FLOW__COND, oldCond, newCond);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCond(Expression newCond)
  {
    if (newCond != cond)
    {
      NotificationChain msgs = null;
      if (cond != null)
        msgs = ((InternalEObject)cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ListaCompilerPackage.IF_CONTROL_FLOW__COND, null, msgs);
      if (newCond != null)
        msgs = ((InternalEObject)newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ListaCompilerPackage.IF_CONTROL_FLOW__COND, null, msgs);
      msgs = basicSetCond(newCond, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ListaCompilerPackage.IF_CONTROL_FLOW__COND, newCond, newCond));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getIftrue()
  {
    return iftrue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIftrue(Expression newIftrue, NotificationChain msgs)
  {
    Expression oldIftrue = iftrue;
    iftrue = newIftrue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ListaCompilerPackage.IF_CONTROL_FLOW__IFTRUE, oldIftrue, newIftrue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIftrue(Expression newIftrue)
  {
    if (newIftrue != iftrue)
    {
      NotificationChain msgs = null;
      if (iftrue != null)
        msgs = ((InternalEObject)iftrue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ListaCompilerPackage.IF_CONTROL_FLOW__IFTRUE, null, msgs);
      if (newIftrue != null)
        msgs = ((InternalEObject)newIftrue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ListaCompilerPackage.IF_CONTROL_FLOW__IFTRUE, null, msgs);
      msgs = basicSetIftrue(newIftrue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ListaCompilerPackage.IF_CONTROL_FLOW__IFTRUE, newIftrue, newIftrue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getIffalse()
  {
    return iffalse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIffalse(Expression newIffalse, NotificationChain msgs)
  {
    Expression oldIffalse = iffalse;
    iffalse = newIffalse;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ListaCompilerPackage.IF_CONTROL_FLOW__IFFALSE, oldIffalse, newIffalse);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIffalse(Expression newIffalse)
  {
    if (newIffalse != iffalse)
    {
      NotificationChain msgs = null;
      if (iffalse != null)
        msgs = ((InternalEObject)iffalse).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ListaCompilerPackage.IF_CONTROL_FLOW__IFFALSE, null, msgs);
      if (newIffalse != null)
        msgs = ((InternalEObject)newIffalse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ListaCompilerPackage.IF_CONTROL_FLOW__IFFALSE, null, msgs);
      msgs = basicSetIffalse(newIffalse, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ListaCompilerPackage.IF_CONTROL_FLOW__IFFALSE, newIffalse, newIffalse));
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
      case ListaCompilerPackage.IF_CONTROL_FLOW__COND:
        return basicSetCond(null, msgs);
      case ListaCompilerPackage.IF_CONTROL_FLOW__IFTRUE:
        return basicSetIftrue(null, msgs);
      case ListaCompilerPackage.IF_CONTROL_FLOW__IFFALSE:
        return basicSetIffalse(null, msgs);
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
      case ListaCompilerPackage.IF_CONTROL_FLOW__COND:
        return getCond();
      case ListaCompilerPackage.IF_CONTROL_FLOW__IFTRUE:
        return getIftrue();
      case ListaCompilerPackage.IF_CONTROL_FLOW__IFFALSE:
        return getIffalse();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ListaCompilerPackage.IF_CONTROL_FLOW__COND:
        setCond((Expression)newValue);
        return;
      case ListaCompilerPackage.IF_CONTROL_FLOW__IFTRUE:
        setIftrue((Expression)newValue);
        return;
      case ListaCompilerPackage.IF_CONTROL_FLOW__IFFALSE:
        setIffalse((Expression)newValue);
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
      case ListaCompilerPackage.IF_CONTROL_FLOW__COND:
        setCond((Expression)null);
        return;
      case ListaCompilerPackage.IF_CONTROL_FLOW__IFTRUE:
        setIftrue((Expression)null);
        return;
      case ListaCompilerPackage.IF_CONTROL_FLOW__IFFALSE:
        setIffalse((Expression)null);
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
      case ListaCompilerPackage.IF_CONTROL_FLOW__COND:
        return cond != null;
      case ListaCompilerPackage.IF_CONTROL_FLOW__IFTRUE:
        return iftrue != null;
      case ListaCompilerPackage.IF_CONTROL_FLOW__IFFALSE:
        return iffalse != null;
    }
    return super.eIsSet(featureID);
  }

} //IfControlFlowImpl
