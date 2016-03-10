/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lista</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.Lista#getLines <em>Lines</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getLista()
 * @model
 * @generated
 */
public interface Lista extends EObject
{
  /**
   * Returns the value of the '<em><b>Lines</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lines</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lines</em>' containment reference list.
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getLista_Lines()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getLines();

} // Lista
