/*
 * generated by Xtext
 */
package edu.upb.compilacion.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class ListaCompilerAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("edu/upb/compilacion/parser/antlr/internal/InternalListaCompiler.tokens");
	}
}
