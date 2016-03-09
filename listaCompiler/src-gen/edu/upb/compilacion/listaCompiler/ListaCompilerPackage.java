/**
 */
package edu.upb.compilacion.listaCompiler;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.upb.compilacion.listaCompiler.ListaCompilerFactory
 * @model kind="package"
 * @generated
 */
public interface ListaCompilerPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "listaCompiler";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.upb.edu/compilacion/ListaCompiler";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "listaCompiler";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ListaCompilerPackage eINSTANCE = edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl.init();

  /**
   * The meta object id for the '{@link edu.upb.compilacion.listaCompiler.impl.ListaImpl <em>Lista</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see edu.upb.compilacion.listaCompiler.impl.ListaImpl
   * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getLista()
   * @generated
   */
  int LISTA = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LISTA__NAME = 0;

  /**
   * The number of structural features of the '<em>Lista</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LISTA_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link edu.upb.compilacion.listaCompiler.Lista <em>Lista</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Lista</em>'.
   * @see edu.upb.compilacion.listaCompiler.Lista
   * @generated
   */
  EClass getLista();

  /**
   * Returns the meta object for the attribute '{@link edu.upb.compilacion.listaCompiler.Lista#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see edu.upb.compilacion.listaCompiler.Lista#getName()
   * @see #getLista()
   * @generated
   */
  EAttribute getLista_Name();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ListaCompilerFactory getListaCompilerFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link edu.upb.compilacion.listaCompiler.impl.ListaImpl <em>Lista</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see edu.upb.compilacion.listaCompiler.impl.ListaImpl
     * @see edu.upb.compilacion.listaCompiler.impl.ListaCompilerPackageImpl#getLista()
     * @generated
     */
    EClass LISTA = eINSTANCE.getLista();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LISTA__NAME = eINSTANCE.getLista_Name();

  }

} //ListaCompilerPackage
