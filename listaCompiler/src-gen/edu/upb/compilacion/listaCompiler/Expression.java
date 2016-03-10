/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.Expression#getArgs <em>Args</em>}</li>
 *   <li>{@link edu.upb.compilacion.listaCompiler.Expression#getOperators <em>Operators</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getExpression()
 * @model
 * @generated
 */
public interface Expression extends EObject
{
  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link edu.upb.compilacion.listaCompiler.Term}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getExpression_Args()
   * @model containment="true"
   * @generated
   */
  EList<Term> getArgs();

  /**
   * Returns the value of the '<em><b>Operators</b></em>' containment reference list.
   * The list contents are of type {@link edu.upb.compilacion.listaCompiler.Operator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operators</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operators</em>' containment reference list.
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getExpression_Operators()
   * @model containment="true"
   * @generated
   */
  EList<Operator> getOperators();

} // Expression
