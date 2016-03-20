/**
 */
package edu.upb.compilacion.listaCompiler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Casted Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.CastedVariable#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getCastedVariable()
 * @model
 * @generated
 */
public interface CastedVariable extends MyVariable
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link edu.upb.compilacion.listaCompiler.CastedType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see edu.upb.compilacion.listaCompiler.CastedType
   * @see #setType(CastedType)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getCastedVariable_Type()
   * @model
   * @generated
   */
  CastedType getType();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.CastedVariable#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see edu.upb.compilacion.listaCompiler.CastedType
   * @see #getType()
   * @generated
   */
  void setType(CastedType value);

} // CastedVariable
