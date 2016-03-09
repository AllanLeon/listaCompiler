/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerPackage
 * @generated
 */
public interface ListaCompilerFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ListaCompilerFactory eINSTANCE = edu.upb.compilacion.listaCompiler.impl.ListaCompilerFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Lista</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lista</em>'.
   * @generated
   */
  Lista createLista();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ListaCompilerPackage getListaCompilerPackage();

} //ListaCompilerFactory
