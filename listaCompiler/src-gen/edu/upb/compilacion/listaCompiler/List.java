/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.List#getElems <em>Elems</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getList()
 * @model
 * @generated
 */
public interface List extends Term
{
  /**
   * Returns the value of the '<em><b>Elems</b></em>' containment reference list.
   * The list contents are of type {@link edu.upb.compilacion.listaCompiler.ListElem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elems</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elems</em>' containment reference list.
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getList_Elems()
   * @model containment="true"
   * @generated
   */
  EList<ListElem> getElems();

} // List
