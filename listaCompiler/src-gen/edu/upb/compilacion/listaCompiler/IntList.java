/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Int List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.IntList#getElems <em>Elems</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getIntList()
 * @model
 * @generated
 */
public interface IntList extends DataType
{
  /**
   * Returns the value of the '<em><b>Elems</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elems</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elems</em>' attribute list.
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getIntList_Elems()
   * @model unique="false"
   * @generated
   */
  EList<String> getElems();

} // IntList
