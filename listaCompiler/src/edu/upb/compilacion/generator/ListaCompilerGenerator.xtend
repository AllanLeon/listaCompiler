/*
 * generated by Xtext
 */
package edu.upb.compilacion.generator

import edu.upb.compilacion.listaCompiler.Evaluation
import edu.upb.compilacion.listaCompiler.Expression
import edu.upb.compilacion.listaCompiler.FirstLevelExp
import edu.upb.compilacion.listaCompiler.FourthLevelExp
import edu.upb.compilacion.listaCompiler.FunctionDefinition
import edu.upb.compilacion.listaCompiler.Lista
import edu.upb.compilacion.listaCompiler.PDFunction
import edu.upb.compilacion.listaCompiler.SecondLevelExp
import edu.upb.compilacion.listaCompiler.ThirdLevelExp
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import edu.upb.compilacion.listaCompiler.Term

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class ListaCompilerGenerator implements IGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
//		fsa.generateFile('greetings.txt', 'People to greet: ' + 
//			resource.allContents
//				.filter(typeof(Greeting))
//				.map[name]
//				.join(', '))
		val lista = (resource.contents.get(0) as Lista)
		fsa.generateFile('seks.java', lista.generate)
	}
	
	def generate(Lista lista) '''«generateMain(lista.evaluations)»«FOR fd : lista.definitions»«fd.generate»«ENDFOR»'''
	
	def generateMain(EList<Evaluation> evaluations) '''public static void main(String[] args) {
		«FOR eval : evaluations»«eval.generate»«ENDFOR»
}'''
	
	def generate(Evaluation ev) '''«ev.^return.generate»'''
	
	def generate(Expression exp) '''«exp.exp.generate»'''
	
	def generate(FirstLevelExp exp) ''''''
	def generate(SecondLevelExp exp) ''''''
	def generate(ThirdLevelExp exp) ''''''
	def generate(FourthLevelExp exp) ''''''
	
	def generate(FunctionDefinition funcd) '''public TYPE! «»«funcd.name»(«FOR fp : funcd.params SEPARATOR ','»«fp»«ENDFOR») {
	«FOR f : funcd.^return»«f.generate»«ENDFOR»;
}'''
}
