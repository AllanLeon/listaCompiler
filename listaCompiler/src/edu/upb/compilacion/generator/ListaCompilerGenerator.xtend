/*
 * generated by Xtext
 */
package edu.upb.compilacion.generator

import edu.upb.compilacion.TypeInferrer
import edu.upb.compilacion.listaCompiler.BracketExpression
import edu.upb.compilacion.listaCompiler.Evaluation
import edu.upb.compilacion.listaCompiler.Expression
import edu.upb.compilacion.listaCompiler.FirstLevelExp
import edu.upb.compilacion.listaCompiler.FourthLevelExp
import edu.upb.compilacion.listaCompiler.FunctionCall
import edu.upb.compilacion.listaCompiler.FunctionDefinition
import edu.upb.compilacion.listaCompiler.IfControlFlow
import edu.upb.compilacion.listaCompiler.List
import edu.upb.compilacion.listaCompiler.Lista
import edu.upb.compilacion.listaCompiler.MyBool
import edu.upb.compilacion.listaCompiler.MyInteger
import edu.upb.compilacion.listaCompiler.MyString
import edu.upb.compilacion.listaCompiler.MyVariable
import edu.upb.compilacion.listaCompiler.SecondLevelExp
import edu.upb.compilacion.listaCompiler.Term
import edu.upb.compilacion.listaCompiler.ThirdLevelExp
import edu.upb.compilacion.validation.ListaCompilerValidator.DataType
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import edu.upb.compilacion.listaCompiler.PosInteger
import edu.upb.compilacion.listaCompiler.NegInteger

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
	
	def generate(FirstLevelExp exp) {
		val first = exp.args.get(0) as SecondLevelExp;
		var res = first.generate; 
		if(exp.args.length > 1) {
			res = res + exp.op.literal + (exp.args.get(1) as FirstLevelExp).generate;
		}
		return res;
	}
	
	def generate(SecondLevelExp exp) {
		val first = exp.args.get(0) as ThirdLevelExp;
		var res = first.generate; 
		if(exp.args.length > 1) {
			res = res + exp.op.literal + (exp.args.get(1) as SecondLevelExp).generate;
		}
		return res;
	}
	def generate(ThirdLevelExp exp) {
		val first = exp.args.get(0) as FourthLevelExp;
		var res = first.generate; 
		if(exp.args.length > 1) {
			res = res + exp.op.literal + (exp.args.get(1) as ThirdLevelExp).generate;
		}
		return res;
				
	}
	def generate(FourthLevelExp exp) {
		val first = exp.args.get(0) as Term;
		var res = first.generate; 
		if(exp.args.length > 1) {
			res = res + exp.op.literal + (exp.args.get(1) as FourthLevelExp).generate;
		}
		return res;		
	}
	
	def generate(Term term) {
		if (term instanceof MyInteger) {
			return (term as MyInteger).generate;
		} else if (term instanceof MyString) {
			return (term as MyString).^val;
		} else if (term instanceof MyBool) {
			return (term as MyBool).generate;
		} else if (term instanceof List) {
			return (term as List).generate;
		} else if (term instanceof MyVariable) {
			return (term as MyVariable).^var;
		} else if (term instanceof FunctionCall) {
			return (term as FunctionCall).generate;
		} else if (term instanceof IfControlFlow) {
			return (term as IfControlFlow).generate;
		} else if (term instanceof BracketExpression) {
			return (term as BracketExpression).exp.generate;
		}
	}
	
	def generate (MyInteger mi) {
		if (mi instanceof PosInteger) {
			return (mi as PosInteger).^val.toString;
		} else if (mi instanceof NegInteger) {
			return (mi as MyString).^val;
		}
	}
	
	def generate (MyBool mb) {
		
	}
	
	def generate (List li) {
		
	}
	
	def generate (FunctionCall fc) {
		
	}
	
	def generate (IfControlFlow icf) {
		
	}
	
	def generate (BracketExpression be) {
		
	}
	
	def generate(FunctionDefinition funcd) '''public «TypeInferrer.getFunctionTypes.get(funcd.name).convertDTtoString» «funcd.name»(«FOR fp : funcd.params SEPARATOR ','»«TypeInferrer.functionParams.get(funcd.name).get(fp).convertDTtoString + ' ' + fp»«ENDFOR») {
	«funcd.^return.exp.generate»;
}'''

	def convertDTtoString(DataType dt) {
		switch(dt) {
			case DataType.BOOL:
				return "boolean"
			case DataType.INT:
				return dt.name.toLowerCase
			case DataType.STRING:
				return dt.name.toLowerCase.toFirstUpper
			case DataType.LIST:
				return "int[]"
			default:
				return "void"
		}
	}
}
