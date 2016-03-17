/**
 */
package edu.upb.compilacion.listaCompiler;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pos Bool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.upb.compilacion.listaCompiler.PosBool#getVal <em>Val</em>}</li>
 * </ul>
 *
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getPosBool()
 * @model
 * @generated
 */
public interface PosBool extends MyBool
{
  /**
   * Returns the value of the '<em><b>Val</b></em>' attribute.
   * The literals are from the enumeration {@link edu.upb.compilacion.listaCompiler.Bool}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Val</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Val</em>' attribute.
   * @see edu.upb.compilacion.listaCompiler.Bool
   * @see #setVal(Bool)
   * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage#getPosBool_Val()
   * @model
   * @generated
   */
  Bool getVal();

  /**
   * Sets the value of the '{@link edu.upb.compilacion.listaCompiler.PosBool#getVal <em>Val</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Val</em>' attribute.
   * @see edu.upb.compilacion.listaCompiler.Bool
   * @see #getVal()
   * @generated
   */
  void setVal(Bool value);

} // PosBool
